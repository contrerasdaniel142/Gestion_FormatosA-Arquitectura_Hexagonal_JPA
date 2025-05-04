package co.edu.unicauca.taller_final_back.infraestructura.output.persistence.repositories;

import org.springframework.data.repository.CrudRepository;

import co.edu.unicauca.taller_final_back.infraestructura.output.persistence.entitys.EstadoEntity;

public interface EstadoRepositoryInt extends CrudRepository<EstadoEntity, Integer>{
    
}
