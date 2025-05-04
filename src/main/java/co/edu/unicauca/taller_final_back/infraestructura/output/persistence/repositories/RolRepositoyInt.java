package co.edu.unicauca.taller_final_back.infraestructura.output.persistence.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import co.edu.unicauca.taller_final_back.infraestructura.output.persistence.entitys.RolEntity;

public interface RolRepositoyInt extends CrudRepository<RolEntity, Integer>{
    Optional<RolEntity> findByRolAsignado(String rolAsignado);
}
