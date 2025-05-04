package co.edu.unicauca.taller_final_back.infraestructura.output.persistence.mappers;

import org.mapstruct.Mapper;

import co.edu.unicauca.taller_final_back.dominio.models.Estado;
import co.edu.unicauca.taller_final_back.infraestructura.output.persistence.entitys.EstadoEntity;

@Mapper(componentModel = "spring")
public interface EstadoMapperPersistencia {
    Estado mappearDeEntityAEstado(EstadoEntity estadoEntity);
    EstadoEntity mappearEstadoAEntity(Estado estado);
}
