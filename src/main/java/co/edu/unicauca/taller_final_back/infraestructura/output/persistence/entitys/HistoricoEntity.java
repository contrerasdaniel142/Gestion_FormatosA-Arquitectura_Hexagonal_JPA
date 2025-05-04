package co.edu.unicauca.taller_final_back.infraestructura.output.persistence.entitys;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Historicos")
@Getter @Setter
public class HistoricoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idHistorico;
    @Column(nullable = false)
    private Boolean activo;
    @Column(name = "fecha_inicio", nullable = false)
    private LocalDate FechaInicio;
    @Column(name = "fecha_fin", nullable = true)
    private LocalDate FechaFin;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "idDocente", nullable = false)
    private DocenteEntity objDocente;

    @ManyToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "idRol", nullable = false)
    private RolEntity objRol;

    public HistoricoEntity(){
        this.activo = true;
        this.FechaInicio = LocalDate.now();
        this.FechaFin = this.FechaInicio.plusMonths(6);
    }

    public void asociarRolADocente(RolEntity rol, DocenteEntity docente){
        this.objDocente = docente;
        this.objRol = rol;
        docente.agregarHistorico(this);
        rol.agregarHistorico(this);
    }

    public void finalizarRol(){
        this.activo = false;
        this.FechaFin = LocalDate.now();
    }
}
