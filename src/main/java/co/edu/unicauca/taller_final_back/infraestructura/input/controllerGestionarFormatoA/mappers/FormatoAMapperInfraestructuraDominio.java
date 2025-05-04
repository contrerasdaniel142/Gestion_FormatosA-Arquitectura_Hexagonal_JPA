package co.edu.unicauca.taller_final_back.infraestructura.input.controllerGestionarFormatoA.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import co.edu.unicauca.taller_final_back.dominio.models.FormatoA;
import co.edu.unicauca.taller_final_back.dominio.models.RangoFechas;
import co.edu.unicauca.taller_final_back.infraestructura.input.controllerGestionarFormatoA.DTOAnswer.FormatoADTORespuesta;
import co.edu.unicauca.taller_final_back.infraestructura.input.controllerGestionarFormatoA.DTOPetition.FormatoADTOPeticion;
import co.edu.unicauca.taller_final_back.infraestructura.input.controllerGestionarFormatoA.DTOPetition.RangoFechasDTOPeticion;

@Mapper(componentModel = "spring")
public interface FormatoAMapperInfraestructuraDominio {
    FormatoA mappearDePeticionAFormatoA(FormatoADTOPeticion peticion);
    FormatoADTORespuesta mappearDeFormatoPPARespuesta(FormatoA formato);
    List<FormatoADTORespuesta> mappearListaDeFormatoARespuesta(List<FormatoA> formatos);
    RangoFechas mappearDePeticionARangoFechas(RangoFechasDTOPeticion rangoFechas);
}