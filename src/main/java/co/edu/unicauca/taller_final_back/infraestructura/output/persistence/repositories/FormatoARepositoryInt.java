package co.edu.unicauca.taller_final_back.infraestructura.output.persistence.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.edu.unicauca.taller_final_back.infraestructura.output.persistence.entitys.FormatoAEntity;

public interface FormatoARepositoryInt extends JpaRepository<FormatoAEntity, Integer>{

    FormatoAEntity findByIdFormatoA(Integer idFormatoA);

    //Punto 2 - 1
    @Query("""
        SELECT fa
        FROM FormatoAEntity fa
        JOIN fa.objEstado es
        JOIN fa.objDocente doc
        WHERE doc.idDocente = :idDocente
        AND es.fechaRegistro BETWEEN :fechaInicio AND :fechaFin
    """)
    List<FormatoAEntity> buscarFormatosPorTituloYFechaEstado(
        @Param("idDocente") Integer idDocente,
        @Param("fechaInicio") LocalDate fechaInicio,
        @Param("fechaFin") LocalDate fechaFin
    );

    //Punto 2 - 2
    @Query(
      value = """
        SELECT EXISTS(
          SELECT 1
          FROM `Formatos a`
          WHERE LOWER(titulo) = LOWER(:tituloBuscado)
        )
      """,
      nativeQuery = true
    )
    Integer existByTitulo(
        @Param("tituloBuscado") String tituloBuscado
    );

    //Punto 2 - 3
    @Query("""
        SELECT e.idEvaluacion 
        FROM EvaluacionEntity e 
        WHERE e.objFormatoA.idFormatoA = :idFormatoA 
        ORDER BY e.fechaRegistroConcepto DESC
    """)
    List<Integer> obtenerIdUltimaEvaluacionPorFormatoA(
        @Param("idFormatoA") Integer idFormatoA
    );
    
}
