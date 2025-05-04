package co.edu.unicauca.taller_final_back.infraestructura.input.controllerGestionarEstado.mappers;

import org.mapstruct.Mapper;

import co.edu.unicauca.taller_final_back.dominio.models.Estado;
import co.edu.unicauca.taller_final_back.infraestructura.input.controllerGestionarEstado.DTOAnswer.EstadoDTORespuesta;

@Mapper(componentModel = "spring")
public interface EstadoMapperInfraestructuraDominio {
    EstadoDTORespuesta mappearDeEstadoARespuesta(Estado estado);
}