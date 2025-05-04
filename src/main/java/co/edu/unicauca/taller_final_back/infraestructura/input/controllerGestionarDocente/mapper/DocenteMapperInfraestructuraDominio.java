package co.edu.unicauca.taller_final_back.infraestructura.input.controllerGestionarDocente.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import co.edu.unicauca.taller_final_back.dominio.models.Docente;
import co.edu.unicauca.taller_final_back.infraestructura.input.controllerGestionarDocente.DTOAnswer.DocenteDTORespuesta;
import co.edu.unicauca.taller_final_back.infraestructura.input.controllerGestionarDocente.DTOAnswer.DocenteRolDTORespuesta;

@Mapper(componentModel = "spring")
public interface DocenteMapperInfraestructuraDominio {
    DocenteDTORespuesta mappearDeDocenteARespuesta(Docente docente);
    List<DocenteDTORespuesta> mappearListaDeDocenteARespuesta(List<Docente> docentes);
    List<DocenteRolDTORespuesta> mappearListaDeDocenteRolARespuesta(List<DocenteRolDTORespuesta> docentes);
    DocenteRolDTORespuesta mappearDeDocenteRolARespuesta(DocenteRolDTORespuesta rol);
}