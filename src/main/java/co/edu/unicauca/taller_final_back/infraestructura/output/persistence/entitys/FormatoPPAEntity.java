package co.edu.unicauca.taller_final_back.infraestructura.output.persistence.entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "formatos ppa")
@PrimaryKeyJoinColumn(name = "idFormatoPPA")
@Getter @Setter
public class FormatoPPAEntity extends FormatoAEntity{
    @Column(name = "nombre_asesor", nullable = false, length = 100)
    private String nombreAsesor;
    @Column(name = "nombre_estudiante", nullable = false, length = 100)
    private String nombreEstudiante;
    @Column(name = "ruta_carta_aceptacion", nullable = false, length = 255)
    private String rutaCartAceptacion;
    
    public FormatoPPAEntity(){
        super();
    }
}
