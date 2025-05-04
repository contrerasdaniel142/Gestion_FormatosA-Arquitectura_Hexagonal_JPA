package co.edu.unicauca.taller_final_back.infraestructura.output.persistence.entitys;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "observaciones")
@Getter @Setter
public class ObservacionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idObservacion;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String observacion;
    @Column(name="fecha_registro_observacion", nullable = false)
    private LocalDate fechaRegistroObservacion;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "idEvaluacion", nullable = true)
    private EvaluacionEntity objEvaluacion;

    @ManyToMany(cascade = {CascadeType.MERGE})
    @JoinTable(
        name = "observacion_docente",
        joinColumns = @JoinColumn(name = "idObservacion"),
        inverseJoinColumns = @JoinColumn(name = "idDocente")
    )
    private List<DocenteEntity> docentes;

    public ObservacionEntity(){
        this.docentes = new ArrayList<DocenteEntity>();
        this.fechaRegistroObservacion = LocalDate.now();
    }

    public void agregarDocente(DocenteEntity objDocente){
        objDocente.agregarObservacion(this);
        this.docentes.add(objDocente);
    }
    
}
