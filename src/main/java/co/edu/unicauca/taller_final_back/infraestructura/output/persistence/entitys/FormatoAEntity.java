package co.edu.unicauca.taller_final_back.infraestructura.output.persistence.entitys;

import java.util.ArrayList;
import java.util.List;

import co.edu.unicauca.taller_final_back.dominio.enums.ConceptoEvaluacionEnum;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Formatos a")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter @Setter
@NoArgsConstructor
public class FormatoAEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFormatoA;
    @Column(length = 100, nullable = false, unique = true)
    private String titulo;
    @Column(name = "objetivoGeneral", nullable = false, columnDefinition = "TEXT")
    private String objetivoGeneral;
    @Column(name = "objetivos_especificos", nullable = false, columnDefinition = "TEXT")
    private String objetivosEspecificos;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
    @JoinColumn(name = "idFormatoA")
    private EstadoEntity objEstado;

    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "objFormatoA", cascade = {CascadeType.PERSIST,CascadeType.REMOVE, CascadeType.MERGE})
    private List<EvaluacionEntity> evaluaciones;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "idDocente", nullable = false )
    private DocenteEntity objDocente;

    public EvaluacionEntity crearNuevaEvaluacion(String nombreCoordinador){
        EvaluacionEntity evaluacion = new EvaluacionEntity();
        evaluacion.setConcepto(ConceptoEvaluacionEnum.POR_ESTABLECER.toString());
        evaluacion.setNombreCoordinador(nombreCoordinador);
        evaluacion.agregarFormatoA(this);
        this.evaluaciones.add(evaluacion);
        return evaluacion;
    }

    public EvaluacionEntity getEvaluacionActual(){
        EvaluacionEntity evaluacion;
        if(this.evaluaciones.isEmpty()){
            evaluacion = this.crearNuevaEvaluacion("");
        }else{
            evaluacion = this.evaluaciones.get(evaluaciones.size()-1);
        }
        return evaluacion;
    }

    public void agregarDocente(DocenteEntity objDocente){
        this.objDocente = objDocente;
        objDocente.agregarFormatoA(this);
        this.evaluaciones = new ArrayList<EvaluacionEntity>();
    }

    public void formularEstado(){
        this.objEstado = new EstadoEntity(this);
        this.getEvaluacionActual();
    }
}
