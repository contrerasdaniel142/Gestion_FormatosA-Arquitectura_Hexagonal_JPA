package co.edu.unicauca.taller_final_back.infraestructura.output.persistence.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import co.edu.unicauca.taller_final_back.dominio.models.Docente;
import co.edu.unicauca.taller_final_back.infraestructura.output.persistence.entitys.DocenteEntity;

@Mapper(componentModel = "spring")
public interface DocenteMapperPersistencia {
    List<Docente> mappearListaDeEntityADocente(List<DocenteEntity> listaDocentes);
    Docente mappearEntityADocente(DocenteEntity docenteEntity);
}
