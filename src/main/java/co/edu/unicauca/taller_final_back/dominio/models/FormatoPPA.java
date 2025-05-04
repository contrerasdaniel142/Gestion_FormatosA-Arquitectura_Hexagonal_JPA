package co.edu.unicauca.taller_final_back.dominio.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class FormatoPPA extends FormatoA {
    private String nombreAsesor;
    private String nombreEstudiante;
    private String rutaCartAceptacion;

    public FormatoPPA(){
        super();
    }
}
