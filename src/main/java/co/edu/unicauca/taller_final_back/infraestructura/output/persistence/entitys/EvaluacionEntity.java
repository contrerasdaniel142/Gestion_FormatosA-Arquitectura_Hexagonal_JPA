package co.edu.unicauca.taller_final_back.infraestructura.output.persistence.entitys;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import co.edu.unicauca.taller_final_back.dominio.enums.ConceptoEvaluacionEnum;

@Entity
@Table(name = "Evaluaciones")
@Getter @Setter 
public class EvaluacionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEvaluacion;
    @Column(length = 255, nullable = false)
    private String concepto;
    @Column(name = "fecha_registro_concepto",  nullable = false)
    private LocalDate fechaRegistroConcepto;
    @Column(name = "nombre_coordinador", nullable = false, length = 100)
    private String nombreCoordinador;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="idFormatoA", nullable=false)
    private FormatoAEntity objFormatoA;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "objEvaluacion", cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
    private List<ObservacionEntity> observaciones;

    public EvaluacionEntity(){
        this.observaciones = new ArrayList<ObservacionEntity>();
        this.fechaRegistroConcepto = LocalDate.now();
    }

    public void addObservacion(ObservacionEntity objObservacion){
        this.concepto = ConceptoEvaluacionEnum.POR_CORREGIR.toString();
        objObservacion.setObjEvaluacion(this);
        this.observaciones.add(objObservacion);
    }

    public void agregarFormatoA(FormatoAEntity objFormatoA){
        this.objFormatoA = objFormatoA;
    }

    public ObservacionEntity getUltimaObservacion(){
        ObservacionEntity observacion = null;
        if (!this.observaciones.isEmpty()){
            observacion = this.observaciones.get(this.observaciones.size()-1);
        }
        return observacion;
    }

}
