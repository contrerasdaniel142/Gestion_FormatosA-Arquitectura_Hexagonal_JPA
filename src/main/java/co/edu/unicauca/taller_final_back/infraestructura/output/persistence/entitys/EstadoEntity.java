package co.edu.unicauca.taller_final_back.infraestructura.output.persistence.entitys;

import java.time.LocalDate;

import co.edu.unicauca.taller_final_back.dominio.enums.EstadoFormatoAEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Estados")
@Getter @Setter
@NoArgsConstructor
public class EstadoEntity {
    @Id
    private Integer idFormatoA;
    @Column(name = "estado_actual", nullable = false, length = 50)
    private String estadoActual;
    @Column(name = "fecha_registro", nullable = false)
    private LocalDate fechaRegistro;

    @OneToOne
    @MapsId
    @JoinColumn(name = "idFormatoA")
    private FormatoAEntity objFormatoA;

    public EstadoEntity(FormatoAEntity objFormatoA){
        this.objFormatoA = objFormatoA;
        this.estadoActual = EstadoFormatoAEnum.FORMULADO.toString();
        this.fechaRegistro = LocalDate.now();
    }

    public void cambiarEstado(String estado){
        this.estadoActual = estado;
        this.fechaRegistro = LocalDate.now();
    }
}
