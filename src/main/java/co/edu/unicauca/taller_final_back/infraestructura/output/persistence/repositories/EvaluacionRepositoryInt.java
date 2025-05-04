package co.edu.unicauca.taller_final_back.infraestructura.output.persistence.repositories;

import org.springframework.data.repository.CrudRepository;

import co.edu.unicauca.taller_final_back.infraestructura.output.persistence.entitys.EvaluacionEntity;

public interface EvaluacionRepositoryInt extends CrudRepository<EvaluacionEntity, Integer>{
    
}
