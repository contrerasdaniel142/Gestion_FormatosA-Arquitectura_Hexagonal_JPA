package co.edu.unicauca.taller_final_back.infraestructura.output.persistence.entitys;

import java.util.ArrayList;
import java.util.List;

import co.edu.unicauca.taller_final_back.dominio.enums.RolDocenteEnum;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Docentes")
@Getter @Setter
public class DocenteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDocente;
    @Column(name = "nombres_docente", nullable = false, length = 100)
    private String nombresDocente;
    @Column(name = "apellidos_docente", nullable = false, length = 100)
    private String apellidosDocente;
    @Column(name = "nombre_grupo", nullable = false, length = 50)
    private String nombreGrupo;
    @Column(nullable = false, length = 100, unique = true)
    private String correo;

    @OneToMany(fetch = FetchType.EAGER, mappedBy="objDocente", cascade = {CascadeType.PERSIST,CascadeType.REMOVE, CascadeType.MERGE})
    private List<FormatoAEntity> formatosA;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "objDocente", cascade = {CascadeType.PERSIST,CascadeType.REMOVE,CascadeType.MERGE})
    private List<HistoricoEntity> historicos;
    
    @ManyToMany(mappedBy = "docentes", cascade = {CascadeType.MERGE})
    private List<ObservacionEntity> observaciones;

    public DocenteEntity(){
        this.formatosA = new ArrayList<FormatoAEntity>();
        this.historicos = new ArrayList<HistoricoEntity>();
        this.observaciones = new ArrayList<ObservacionEntity>();
    }

    public DocenteEntity(String nombresDocente, String apellidosDocente, String nombreGrupo, String correo) {
        this.nombresDocente = nombresDocente;
        this.apellidosDocente = apellidosDocente;
        this.nombreGrupo = nombreGrupo;
        this.correo = correo;
        this.formatosA = new ArrayList<>();
        this.historicos = new ArrayList<>();
        this.observaciones = new ArrayList<>();
    }

    public void agregarFormatoA(FormatoAEntity objFormatoA){
        this.formatosA.add(objFormatoA);
    }

    public void agregarHistorico(HistoricoEntity objHistorico){
        this.historicos.add(objHistorico);
    }

    public void agregarObservacion(ObservacionEntity objObservacion){
        this.observaciones.add(objObservacion);
    }

    public String obtenerNombreCompleto() {
        return this.nombresDocente + " " + this.apellidosDocente;
    }
    
    public HistoricoEntity obtenerHistoricoActivoPorRol(RolDocenteEnum rol) {
        String rolBuscado = rol.toString();
        HistoricoEntity historicoBuscado = null;
        for (HistoricoEntity historico : this.historicos) {
            if (historico.getActivo() && historico.getObjRol().getRolAsignado().equals(rolBuscado)) {
                historicoBuscado = historico;
                break;
            }
        }
        return historicoBuscado;
    }
    
}
