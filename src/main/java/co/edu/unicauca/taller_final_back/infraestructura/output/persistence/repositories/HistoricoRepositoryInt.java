package co.edu.unicauca.taller_final_back.infraestructura.output.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.edu.unicauca.taller_final_back.infraestructura.output.persistence.entitys.HistoricoEntity;

public interface HistoricoRepositoryInt extends JpaRepository<HistoricoEntity, Integer> {
    
    @Query("""
        SELECT CASE WHEN COUNT(h) > 0 THEN true ELSE false END
        FROM HistoricoEntity h
        JOIN h.objRol r
        WHERE h.objDocente.idDocente = :idDocente
        AND r.rolAsignado = :rolAsignado
        AND h.activo = true
    """)
    boolean docenteTieneRolActivo(
        @Param("idDocente") Integer idDocente,
        @Param("rolAsignado") String rolAsignado
    );
}