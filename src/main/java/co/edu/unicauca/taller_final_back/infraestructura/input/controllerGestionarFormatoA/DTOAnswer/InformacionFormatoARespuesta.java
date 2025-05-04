package co.edu.unicauca.taller_final_back.infraestructura.input.controllerGestionarFormatoA.DTOAnswer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class InformacionFormatoARespuesta {
    private String titulo;
    private String objetivoGeneral;
    private String objetivosEspecificos;
    private String estado;
    private String docenteDirector;
}
