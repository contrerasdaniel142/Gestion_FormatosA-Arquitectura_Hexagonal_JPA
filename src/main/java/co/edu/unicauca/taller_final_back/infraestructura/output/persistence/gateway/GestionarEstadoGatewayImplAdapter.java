package co.edu.unicauca.taller_final_back.infraestructura.output.persistence.gateway;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unicauca.taller_final_back.aplicacion.output.GestionarEstadoGatewayIntPort;
import co.edu.unicauca.taller_final_back.dominio.enums.EstadoFormatoAEnum;
import co.edu.unicauca.taller_final_back.dominio.models.Estado;
import co.edu.unicauca.taller_final_back.infraestructura.output.persistence.entitys.EstadoEntity;
import co.edu.unicauca.taller_final_back.infraestructura.output.persistence.mappers.EstadoMapperPersistencia;
import co.edu.unicauca.taller_final_back.infraestructura.output.persistence.repositories.EstadoRepositoryInt;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GestionarEstadoGatewayImplAdapter implements GestionarEstadoGatewayIntPort {
    
    private final EstadoRepositoryInt objEstadoRepository;
    private final EstadoMapperPersistencia objMapper;

    @Override
    @Transactional(readOnly = true)
    public EstadoFormatoAEnum obtenerEstadoActualFormatoA(Integer idFormatoA){
        EstadoFormatoAEnum estadoEnum = null;
        Optional<EstadoEntity> optionalEstadoEntity = this.objEstadoRepository.findById(idFormatoA);
        if(optionalEstadoEntity.isPresent()){
            estadoEnum = EstadoFormatoAEnum.valueOf(optionalEstadoEntity.get().getEstadoActual());
        }
        return estadoEnum;
    }

    @Override
    @Transactional
    public Estado cambiarEstadoFormatoA(Integer idFormatoA, EstadoFormatoAEnum nuevoEstadoEnum){
        Estado objEstadoActualizado = null;
        Optional<EstadoEntity> optionalEntity = this.objEstadoRepository.findById(idFormatoA);
        if(optionalEntity.isPresent()){
            EstadoEntity objEstadoEntity = optionalEntity.get();
            objEstadoEntity.setEstadoActual(nuevoEstadoEnum.toString());
            objEstadoEntity = this.objEstadoRepository.save(objEstadoEntity);
            objEstadoActualizado = this.objMapper.mappearDeEntityAEstado(objEstadoEntity);
        }
        return objEstadoActualizado;
    }

}
