package co.edu.unicauca.taller_final_back.dominio.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class FormatoTIA extends FormatoA {
    private String nombreEstudiante1;
    private String nombreEstudiante2;

    public FormatoTIA(){
        super();      
    }
}
