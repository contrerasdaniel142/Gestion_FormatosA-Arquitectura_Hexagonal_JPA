package co.edu.unicauca.taller_final_back.infraestructura.output.persistence.gateway;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unicauca.taller_final_back.aplicacion.output.GestionarDocenteGatewayIntPort;
import co.edu.unicauca.taller_final_back.dominio.enums.RolDocenteEnum;
import co.edu.unicauca.taller_final_back.dominio.models.Docente;
import co.edu.unicauca.taller_final_back.infraestructura.input.controllerGestionarDocente.DTOAnswer.DocenteRolDTORespuesta;
import co.edu.unicauca.taller_final_back.infraestructura.output.persistence.entitys.DocenteEntity;
import co.edu.unicauca.taller_final_back.infraestructura.output.persistence.entitys.HistoricoEntity;
import co.edu.unicauca.taller_final_back.infraestructura.output.persistence.mappers.DocenteMapperPersistencia;
import co.edu.unicauca.taller_final_back.infraestructura.output.persistence.repositories.DocenteRepositoryInt;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GestionarDocenteGatewayImplAdapter implements GestionarDocenteGatewayIntPort{
    
    private final DocenteRepositoryInt objDocenteRepository;
    private final DocenteMapperPersistencia objMapper;

    @Override
    @Transactional(readOnly = true)
    public Boolean existeDocentePorId(Integer idDocente){
        return this.objDocenteRepository.existsById(idDocente);
    }

    @Override
    @Transactional(readOnly = true)
    public Boolean existeDocentePorCorreo(String correoDocente){
        return this.objDocenteRepository.existsByCorreo(correoDocente);
    }

    @Override
    @Transactional(readOnly = true)
    public Boolean existenDocentesPorIds(List<Integer> idsDocente){
        return this.objDocenteRepository.existsByIdDocenteNotIn(idsDocente);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DocenteRolDTORespuesta> listarPorRol(RolDocenteEnum rolDocenteEnum){
        List<DocenteRolDTORespuesta> listaDocentesRol = new ArrayList<DocenteRolDTORespuesta>();
        List<DocenteEntity> docentesObtenidos = this.objDocenteRepository.findDocentesConHistoricosPorRol(rolDocenteEnum.toString());
        for (DocenteEntity docenteEntity : docentesObtenidos) {
            HistoricoEntity historicoActivo = docenteEntity.obtenerHistoricoActivoPorRol(rolDocenteEnum);
            if (historicoActivo != null) {
                DocenteRolDTORespuesta docenteRol = new DocenteRolDTORespuesta();
                docenteRol.setNombresDocente(docenteEntity.getNombresDocente());
                docenteRol.setApellidosDocente(docenteEntity.getApellidosDocente());
                docenteRol.setNombreGrupo(docenteEntity.getNombreGrupo());
                docenteRol.setCorreo(docenteEntity.getCorreo());
                docenteRol.setRol(rolDocenteEnum.toString());
                docenteRol.setFechaInicio(historicoActivo.getFechaInicio());
                docenteRol.setFechaFin(historicoActivo.getFechaFin());
                listaDocentesRol.add(docenteRol);
            }
        }
        return listaDocentesRol;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Docente> listarPorGrupoYPatronAscendente(String grupo, String patron) {
        List<DocenteEntity> listaObtenida = objDocenteRepository
            .findByNombreGrupoAndApellidosDocenteStartingWithIgnoreCaseOrderByApellidosDocenteAsc(grupo, patron+"%");

        return this.objMapper.mappearListaDeEntityADocente(listaObtenida);
    }
}
