package co.edu.unicauca.taller_final_back.infraestructura.output.persistence.mappers;

import org.mapstruct.Mapper;

import co.edu.unicauca.taller_final_back.dominio.models.Observacion;
import co.edu.unicauca.taller_final_back.infraestructura.output.persistence.entitys.ObservacionEntity;

@Mapper(componentModel = "spring")
public interface ObservacionMapperPersistencia {
    Observacion mappearDeEntityAObservacion(ObservacionEntity observacion);
    
}
