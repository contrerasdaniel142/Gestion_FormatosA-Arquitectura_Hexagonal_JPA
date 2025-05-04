package co.edu.unicauca.taller_final_back.infraestructura.input.controllerGestionarObservacion.mappers;

import org.mapstruct.Mapper;

import co.edu.unicauca.taller_final_back.dominio.models.Observacion;
import co.edu.unicauca.taller_final_back.infraestructura.input.controllerGestionarObservacion.DTOAnswer.ObservacionDTORespuesta;
import co.edu.unicauca.taller_final_back.infraestructura.input.controllerGestionarObservacion.DTOPetition.ObservacionDTOPeticion;

@Mapper(componentModel = "spring")
public interface ObservacionMapperInfraestructuraDominio {
    Observacion mappearDePeticionAObservacion(ObservacionDTOPeticion peticion);
    ObservacionDTORespuesta mappearDeObservacionARespuesta(Observacion observacion);
}