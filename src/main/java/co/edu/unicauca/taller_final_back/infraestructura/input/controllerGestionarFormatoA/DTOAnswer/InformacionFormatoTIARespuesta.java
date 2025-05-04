package co.edu.unicauca.taller_final_back.infraestructura.input.controllerGestionarFormatoA.DTOAnswer;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class InformacionFormatoTIARespuesta extends InformacionFormatoARespuesta {
    private String nombreEstudiante1;
    private String nombreEstudiante2;

    public InformacionFormatoTIARespuesta(String titulo, String objetivoGeneral, String objetivosEspecificos, String estado, String docenteDirector, String nombreEstudiante1, String nombreEstudiante2){
        super(titulo, objetivoGeneral, objetivosEspecificos, estado, docenteDirector);
        this.nombreEstudiante1 = nombreEstudiante1;
        this.nombreEstudiante2 = nombreEstudiante2;
    }
}
