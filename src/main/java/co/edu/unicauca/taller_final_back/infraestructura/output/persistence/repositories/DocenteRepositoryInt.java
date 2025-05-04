package co.edu.unicauca.taller_final_back.infraestructura.output.persistence.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.edu.unicauca.taller_final_back.infraestructura.output.persistence.entitys.DocenteEntity;


public interface DocenteRepositoryInt extends JpaRepository<DocenteEntity, Integer>{

    DocenteEntity findByIdDocente(Integer idDocente);
    
    //Punto 1 - 1
    List<DocenteEntity> findByNombreGrupoAndApellidosDocenteStartingWithIgnoreCaseOrderByApellidosDocenteAsc(
        String nombreGrupo, 
        String patronBusqueda
    );

    //Punto 2 - 4
    Boolean existsByCorreo(
        String correo
    );

    Optional<DocenteEntity> findByCorreo(
        String correo
    );

    Boolean existsByIdDocenteNotIn(
        List<Integer> idsDocente
    );

    @Query("""
        SELECT d 
        FROM DocenteEntity d 
        LEFT JOIN FETCH d.historicos 
        WHERE d.idDocente = :idDocente
    """)
    Optional<DocenteEntity> findByIdWithHistoricos(
        @Param("idDocente") Integer idDocente
    );

    @Query("""
        SELECT DISTINCT d 
        FROM DocenteEntity d
        JOIN FETCH d.historicos h
        JOIN FETCH h.objRol r
        WHERE UPPER(r.rolAsignado) = UPPER(:nombreRol)
    """)
    List<DocenteEntity> findDocentesConHistoricosPorRol(@Param("nombreRol") String nombreRol);

}
