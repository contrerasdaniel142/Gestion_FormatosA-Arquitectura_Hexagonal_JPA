package co.edu.unicauca.taller_final_back.infraestructura.input.controllerGestionarFormatoA.DTOAnswer;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class InformacionFormatoTIARespuesta extends InformacionFormatoARespuesta {
    private String nombreEstudiante1;
    private String nombreEstudiante2;

    public InformacionFormatoTIARespuesta(String titulo, String objetivoGeneral, String objetivosEspecificos, String estado, String docenteDirector, String nombreEstudiante1, String nombreEstudiante2){
        super(titulo, objetivoGeneral, objetivosEspecificos, estado, docenteDirector);
        this.nombreEstudiante1 = nombreEstudiante1;
        this.nombreEstudiante2 = nombreEstudiante2;
    }
}
