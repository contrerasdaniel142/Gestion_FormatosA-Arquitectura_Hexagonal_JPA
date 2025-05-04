package co.edu.unicauca.taller_final_back.infraestructura.output.persistence.mappers;

import org.mapstruct.Mapper;

import co.edu.unicauca.taller_final_back.dominio.models.FormatoA;
import co.edu.unicauca.taller_final_back.infraestructura.input.controllerGestionarFormatoA.DTOAnswer.InformacionFormatoARespuesta;
import co.edu.unicauca.taller_final_back.infraestructura.output.persistence.entitys.FormatoAEntity;

@Mapper(componentModel = "spring")
public interface FormatoAMapperPersistencia {
    FormatoAEntity mappearDeFormatoAAEntity(FormatoA formatoA);
    FormatoA mappearDeEntityAFormatoA(FormatoAEntity formatoAEntity);
    InformacionFormatoARespuesta mappearDeEntityAInformacionFormatoA(FormatoAEntity formatoAEntity);
}
