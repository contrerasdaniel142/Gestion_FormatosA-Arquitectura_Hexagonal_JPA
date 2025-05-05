package co.edu.unicauca.taller_final_back.infraestructura.input.controllerGestionarFormatoA.DTOPetition;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FormatoPPADTOPeticion extends FormatoADTOPeticion {
    @NotNull(message = "{formatoPPA.asesor.emply}") @Size(min = 5,max = 100, message = "{formatoAasesor.size}")
    private String nombreAsesor;
    @NotNull(message = "{formatoPPA.estudiante.emply}") @Size(min = 5,max = 100, message = "{formatoAestudiante.size}")
    private String nombreEstudiante;
    @NotNull(message = "{formatoPPA.rutaCarta.emply}") @Size(min = 5, max = 255, message = "{formatoPPA.rutaCarta.size}")
    private String rutaCartAceptacion;

    public FormatoPPADTOPeticion(String titulo, String objetivoGeneral, String objetivosEspecificos, String nombreAsesor, String nombreEstudiante, String rutaCartAceptacion) {
        super(titulo, objetivoGeneral, objetivosEspecificos);
        this.nombreAsesor = nombreAsesor;
        this.nombreEstudiante = nombreEstudiante;
        this.rutaCartAceptacion = rutaCartAceptacion;
    }

}
