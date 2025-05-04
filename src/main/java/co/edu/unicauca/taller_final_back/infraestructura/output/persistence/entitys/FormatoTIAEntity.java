package co.edu.unicauca.taller_final_back.infraestructura.output.persistence.entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "formatos tia")
@PrimaryKeyJoinColumn(name = "idFormatoTIA")
@Getter @Setter
public class FormatoTIAEntity extends FormatoAEntity{
    @Column(name = "nombre_estudiante1", nullable = false, length = 100)
    private String nombreEstudiante1;
    @Column(name = "nombre_estudiante2", nullable = false, length = 100)
    private String nombreEstudiante2;

    public FormatoTIAEntity(){
            super();      
        }
}
