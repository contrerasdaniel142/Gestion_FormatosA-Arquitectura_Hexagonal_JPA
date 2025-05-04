package co.edu.unicauca.taller_final_back.infraestructura.input.controllerGestionarFormatoA.DTOAnswer;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter 
@NoArgsConstructor
public class FormatoPPADTORespuesta extends FormatoADTORespuesta{
    private String nombreAsesor;
    private String nombreEstudiante;
    private String rutaCartaAceptacion;

    public FormatoPPADTORespuesta(String titulo, String objetivoGeneral, String objetivosEspecificos, String nombreAsesor, String nombreEstudiante, String rutaCartaAceptacion){
        super(titulo, objetivoGeneral, objetivosEspecificos);
        this.nombreAsesor = nombreAsesor;
        this.nombreEstudiante = nombreEstudiante;
        this.rutaCartaAceptacion = rutaCartaAceptacion;
    }
}
