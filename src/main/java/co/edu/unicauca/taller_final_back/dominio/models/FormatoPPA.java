package co.edu.unicauca.taller_final_back.dominio.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
public class FormatoPPA extends FormatoA {
    private String nombreAsesor;
    private String nombreEstudiante;
    private String rutaCartAceptacion;

    public FormatoPPA(){
        super();
    }
}
