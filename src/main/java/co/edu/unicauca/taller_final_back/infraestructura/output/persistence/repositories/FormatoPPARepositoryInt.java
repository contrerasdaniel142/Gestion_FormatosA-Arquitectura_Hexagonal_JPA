package co.edu.unicauca.taller_final_back.infraestructura.output.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.unicauca.taller_final_back.infraestructura.output.persistence.entitys.FormatoAEntity;

public interface FormatoPPARepositoryInt extends JpaRepository<FormatoAEntity, Integer>{
}
