package co.edu.unicauca.taller_final_back.infraestructura.output.persistence.gateway;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unicauca.taller_final_back.aplicacion.output.GestionarObservacionGatewayIntPort;
import co.edu.unicauca.taller_final_back.dominio.models.Observacion;
import co.edu.unicauca.taller_final_back.infraestructura.input.controllerGestionarObservacion.DTOAnswer.ObservacionesDTORespuesta;
import co.edu.unicauca.taller_final_back.infraestructura.output.persistence.entitys.DocenteEntity;
import co.edu.unicauca.taller_final_back.infraestructura.output.persistence.entitys.FormatoAEntity;
import co.edu.unicauca.taller_final_back.infraestructura.output.persistence.entitys.ObservacionEntity;
import co.edu.unicauca.taller_final_back.infraestructura.output.persistence.mappers.ObservacionMapperPersistencia;
import co.edu.unicauca.taller_final_back.infraestructura.output.persistence.repositories.DocenteRepositoryInt;
import co.edu.unicauca.taller_final_back.infraestructura.output.persistence.repositories.FormatoARepositoryInt;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GestionarObservacionGatewayImplAdapter implements GestionarObservacionGatewayIntPort{
    private final DocenteRepositoryInt objDocenteRepository;
    private final FormatoARepositoryInt objFormatoARepository;
    private final ObservacionMapperPersistencia objMapper;

    @Override
    @Transactional
    public Observacion guardarObservacion(Observacion observacion, List<Integer> idsDocente, Integer idFormatoA){
        ObservacionEntity nuevaObservacion = new ObservacionEntity();
        nuevaObservacion.setObservacion(observacion.getObservacion());
        FormatoAEntity formatoA = this.objFormatoARepository.findByIdFormatoA(idFormatoA);
        formatoA.getEvaluaciones().size();
        for (Integer id : idsDocente) {
            nuevaObservacion.agregarDocente(this.objDocenteRepository.findByIdDocente(id));
        }
        formatoA.getEvaluacionActual().addObservacion(nuevaObservacion);
        FormatoAEntity formatoActualizado = this.objFormatoARepository.save(formatoA);
        ObservacionEntity observacionGuardada = formatoActualizado.getEvaluacionActual().getUltimaObservacion();
        return this.objMapper.mappearDeEntityAObservacion(observacionGuardada);
    }

    @Override
    @Transactional(readOnly = true)
    public ObservacionesDTORespuesta listarPorFormatoA(Integer idFormatoA){
        FormatoAEntity formatoAEntity = this.objFormatoARepository.findByIdFormatoA(idFormatoA);
        formatoAEntity.getEvaluaciones().size();
        ObservacionesDTORespuesta objObservaciones = new ObservacionesDTORespuesta();
        objObservaciones.setTitulo(formatoAEntity.getTitulo());
        objObservaciones.setObjetivoGeneral(formatoAEntity.getObjetivoGeneral());
        objObservaciones.setEstadoActual(formatoAEntity.getObjEstado().getEstadoActual());
        objObservaciones.setFechaRegistroEstado(formatoAEntity.getObjEstado().getFechaRegistro());
        objObservaciones.setConceptoEvaluacion(formatoAEntity.getEvaluacionActual().getConcepto());
        objObservaciones.setFechaRegistroConcepto(formatoAEntity.getEvaluacionActual().getFechaRegistroConcepto());
        objObservaciones.setNombreCoordinador(formatoAEntity.getEvaluacionActual().getNombreCoordinador());

        List<Map<String, String>> listaDocenteObservacion = new ArrayList<>();
        for (ObservacionEntity observacion : formatoAEntity.getEvaluacionActual().getObservaciones()) {
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
        objObservaciones.setListaDocenteObservacion(listaDocenteObservacion);
        return objObservaciones;
    }
}
