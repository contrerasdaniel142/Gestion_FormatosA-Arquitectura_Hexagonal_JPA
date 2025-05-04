package co.edu.unicauca.taller_final_back.infraestructura.input.controllerGestionarFormatoA.DTOPetition;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class FormatoTIADTOPeticion extends FormatoADTOPeticion{
    @NotNull(message = "{formatoTIA.estudiante1.emply}") @Size(min = 5, max = 100, message = "{formatoTIA.estudiante1.size}")
    private String nombreEstudiante1;
    @NotNull(message = "{formatoTIA.estudiante2.emply}") @Size(min = 5, max = 100, message = "{formatoTIA.estudiante2.size}")
    private String nombreEstudiante2;

    public FormatoTIADTOPeticion(String titulo, String objetivoGeneral, String objetivosEspecificos, String nombreEstudiante1, String nombreEstudiante2) {
        super(titulo, objetivoGeneral, objetivosEspecificos);
        this.nombreEstudiante1 = nombreEstudiante1;
        this.nombreEstudiante2 = nombreEstudiante2;
    }
}
