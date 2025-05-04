package co.edu.unicauca.taller_final_back.infraestructura.input.controllerGestionarFormatoA.DTOAnswer;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class InformacionFormatoPPARespuesta extends InformacionFormatoARespuesta{
    private String nombreAsesor;
    private String nombreEstudiante;
    private String rutaCartAceptacion;

    public InformacionFormatoPPARespuesta(String titulo, String objetivoGeneral, String objetivosEspecificos, String estado, String docenteDirector, String nombreAsesor, String nombreEstudiante, String rutaCartAceptacion){
        super(titulo, objetivoGeneral, objetivosEspecificos, estado, docenteDirector);
        this.nombreAsesor = nombreAsesor;
        this.nombreEstudiante = nombreEstudiante;
        this.rutaCartAceptacion = rutaCartAceptacion;
    }
}
