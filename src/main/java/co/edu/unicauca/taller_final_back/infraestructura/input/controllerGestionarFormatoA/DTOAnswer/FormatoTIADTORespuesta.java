package co.edu.unicauca.taller_final_back.infraestructura.input.controllerGestionarFormatoA.DTOAnswer;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class FormatoTIADTORespuesta extends FormatoADTORespuesta{
    
    private String nombreEstudiante1;
    private String nombreEstudiante2;

    public FormatoTIADTORespuesta(String titulo, String objetivoGeneral, String objetivosEspecificos, String nombreEstudiante1, String nombreEstudiante2){
        super(titulo, objetivoGeneral, objetivosEspecificos);
        this.nombreEstudiante1 = nombreEstudiante1;
        this.nombreEstudiante2 = nombreEstudiante2;
    }
}
