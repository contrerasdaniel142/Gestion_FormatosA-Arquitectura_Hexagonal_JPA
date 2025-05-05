package co.edu.unicauca.taller_final_back.infraestructura.output.persistence.gateway;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unicauca.taller_final_back.aplicacion.output.GestionarFormatoAGatewayIntPort;
import co.edu.unicauca.taller_final_back.dominio.enums.RolDocenteEnum;
import co.edu.unicauca.taller_final_back.dominio.models.FormatoA;
import co.edu.unicauca.taller_final_back.dominio.models.RangoFechas;
import co.edu.unicauca.taller_final_back.infraestructura.input.controllerGestionarFormatoA.DTOAnswer.InformacionFormatoARespuesta;
import co.edu.unicauca.taller_final_back.infraestructura.input.controllerGestionarObservacion.DTOAnswer.ObservacionesDTORespuesta;
import co.edu.unicauca.taller_final_back.infraestructura.output.persistence.entitys.DocenteEntity;
import co.edu.unicauca.taller_final_back.infraestructura.output.persistence.entitys.EvaluacionEntity;
import co.edu.unicauca.taller_final_back.infraestructura.output.persistence.entitys.FormatoAEntity;
import co.edu.unicauca.taller_final_back.infraestructura.output.persistence.entitys.HistoricoEntity;
import co.edu.unicauca.taller_final_back.infraestructura.output.persistence.entitys.ObservacionEntity;
import co.edu.unicauca.taller_final_back.infraestructura.output.persistence.entitys.RolEntity;
import co.edu.unicauca.taller_final_back.infraestructura.output.persistence.mappers.FormatoAMapperPersistencia;
import co.edu.unicauca.taller_final_back.infraestructura.output.persistence.repositories.DocenteRepositoryInt;
import co.edu.unicauca.taller_final_back.infraestructura.output.persistence.repositories.FormatoARepositoryInt;
import co.edu.unicauca.taller_final_back.infraestructura.output.persistence.repositories.HistoricoRepositoryInt;
import co.edu.unicauca.taller_final_back.infraestructura.output.persistence.repositories.RolRepositoyInt;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GestionarFormatoAGatewayImplAdapter implements GestionarFormatoAGatewayIntPort{
    
    private final FormatoARepositoryInt objFormatoARepository;
    private final HistoricoRepositoryInt objHistoricoRepository;
    private final DocenteRepositoryInt objDocenteRepository;
    private final RolRepositoyInt objRolRepositoy;
    private final FormatoAMapperPersistencia objMapper;

    @Override
    @Transactional(readOnly = true)
    public Boolean existeTituloFormatoA(String titulo){
        return this.objFormatoARepository.existByTitulo(titulo)>0;
    }

    @Override
    @Transactional(readOnly = true)
    public Boolean existeFormatoAPorId(Integer idFormatoA){
        return this.objFormatoARepository.existsById(idFormatoA);
    }


    // Crear Formato A
    @Override
    @Transactional
    public FormatoA guardarFormatoA(FormatoA formatoA, Integer idDocente) {
        FormatoA resultado = null;
        String nombreRolDirector = RolDocenteEnum.DIRECTOR_TRABAJO_GRADO.toString();

        Optional<DocenteEntity> optionalDocente = objDocenteRepository.findByIdWithHistoricos(idDocente);

        if (optionalDocente.isPresent()) {
            DocenteEntity objDocente = optionalDocente.get();

            if (!objHistoricoRepository.docenteTieneRolActivo(idDocente, nombreRolDirector)) {
                Optional<RolEntity> optionalRol = objRolRepositoy.findByRolAsignado(nombreRolDirector);
                if(!optionalRol.isPresent()){
                    RolEntity rolEntity = optionalRol.get();
                    HistoricoEntity historico = new HistoricoEntity();
                    historico.asociarRolADocente(rolEntity, objDocente);
                }
            }

            FormatoAEntity formatoAEntity = this.objMapper.mappearDeFormatoAAEntity(formatoA);

            if (formatoAEntity != null) {
                formatoAEntity.agregarDocente(objDocente);
                
                DocenteEntity docenteGuardado = objDocenteRepository.save(objDocente);

                Optional<FormatoAEntity> ultimoFormato = docenteGuardado.getFormatosA().stream()
                    .reduce((primero, segundo) -> segundo);

                if (ultimoFormato.isPresent()) {
                    FormatoAEntity formatoGuardado = ultimoFormato.get();
                    formatoGuardado.formularEstado();
                    formatoGuardado = this.objFormatoARepository.save(formatoGuardado);
                    resultado = this.objMapper.mappearDeEntityAFormatoA(formatoGuardado);
                }
            }
        }

        return resultado;
    }


    // Consultar Formatos A Por docente
    @Override
    @Transactional(readOnly = true)
    public List<ObservacionesDTORespuesta> listarFormatosAPorDocente(String correoDocente) {
        List<ObservacionesDTORespuesta> resultado = new ArrayList<ObservacionesDTORespuesta>();

        this.objDocenteRepository.findByCorreo(correoDocente).ifPresent(objDocente -> {

            for (FormatoAEntity formato : objDocente.getFormatosA()) {

                String conceptoEvaluacion = null;
                LocalDate fechaRegistroConcepto = null;
                String nombreCoordinador = null;
                List<Map<String, String>> listaDocenteObservacion = new ArrayList<>();

                for (EvaluacionEntity evaluacion : formato.getEvaluaciones()) {
                    // Toma el primer concepto válido
                    if (conceptoEvaluacion == null && evaluacion.getConcepto() != null) {
                        conceptoEvaluacion = evaluacion.getConcepto();
                        fechaRegistroConcepto = evaluacion.getFechaRegistroConcepto();
                        nombreCoordinador = evaluacion.getNombreCoordinador();
                    }

                    for (ObservacionEntity observacion : evaluacion.getObservaciones()) {
                        String nombresDocentes = "";
                        for (DocenteEntity docente : observacion.getDocentes()) {
                            nombresDocentes += docente.getNombresDocente() + " " + docente.getApellidosDocente() + ", ";
                        }
                        if (!nombresDocentes.isEmpty()) {
                            nombresDocentes = nombresDocentes.substring(0, nombresDocentes.length() - 2);
                        }

                        Map<String, String> observacionMap = new HashMap<>();
                        observacionMap.put("Docentes", nombresDocentes);
                        observacionMap.put("observacion", observacion.getObservacion());
                        listaDocenteObservacion.add(observacionMap);
                    }
                }

                ObservacionesDTORespuesta observacion = new ObservacionesDTORespuesta(
                    formato.getTitulo(),
                    formato.getObjetivoGeneral(),
                    formato.getObjetivosEspecificos(),
                    formato.getObjEstado().getEstadoActual(),
                    formato.getObjEstado().getFechaRegistro(),
                    conceptoEvaluacion,
                    fechaRegistroConcepto,
                    nombreCoordinador,
                    listaDocenteObservacion
                );

                resultado.add(observacion);
            }
        });

        return resultado;
    }

    
    // Consultar Formatos A por Docente
    @Override
    @Transactional(readOnly = true)
    public List<InformacionFormatoARespuesta> listarFormatosAConObservacionesPorDocenteEntreFechas(Integer idDocente, RangoFechas rangoFechas) {
        List<InformacionFormatoARespuesta> listaResultado = new ArrayList<>();

        // Consulta todos los formatos A entre las fechas dadas asociados al docente, incluyendo evaluaciones y observaciones
        List<FormatoAEntity> listaFormatosA = this.objFormatoARepository.buscarFormatosPorTituloYFechaEstado(
            idDocente, rangoFechas.getFechaInicio(), rangoFechas.getFechaFin());

        for (FormatoAEntity formatoAEntity : listaFormatosA) {
            InformacionFormatoARespuesta informacionFormatoA = null;
            informacionFormatoA = this.objMapper.mappearDeEntityAInformacionFormatoA(formatoAEntity);
            informacionFormatoA.setEstado(formatoAEntity.getObjEstado().getEstadoActual());
            informacionFormatoA.setDocenteDirector(formatoAEntity.getObjDocente().obtenerNombreCompleto());
            listaResultado.add(informacionFormatoA);
        }
        return listaResultado;
    }


}
