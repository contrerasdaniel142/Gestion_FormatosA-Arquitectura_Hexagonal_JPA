package co.edu.unicauca.taller_final_back.infraestructura.output.persistence.entitys;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "roles")
@Getter @Setter
public class RolEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRol;
    @Column(name = "rol_asignado", nullable = false, length = 100)
    private String rolAsignado;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "objRol", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<HistoricoEntity> historicos;

    public RolEntity(){
        this.historicos = new ArrayList<HistoricoEntity>();
    }

    public void agregarHistorico(HistoricoEntity objHistorico){
        this.historicos.add(objHistorico);
    }
}
