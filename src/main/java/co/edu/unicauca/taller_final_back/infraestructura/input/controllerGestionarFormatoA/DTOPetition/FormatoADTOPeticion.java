package co.edu.unicauca.taller_final_back.infraestructura.input.controllerGestionarFormatoA.DTOPetition;

import co.edu.unicauca.taller_final_back.infraestructura.input.controllerGestionarFormatoA.validations.ObjetivoConVerboInfinitivo;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class FormatoADTOPeticion {
    @NotNull(message = "{formatoA.titulo.emply}") @Size(min = 5,max = 100, message = "{formato.Atitulo.size}")
    private String titulo;
    @NotNull(message = "{formatoA.objetivoGeneral.emply}") @ObjetivoConVerboInfinitivo(message = "{formatoA.objetivoGeneral.infinitivo}")
    private String objetivoGeneral;
    @NotNull(message = "{formatoA.objetivoEspecifico.emply}") @ObjetivoConVerboInfinitivo(message = "{formatoA.objetivoEspecifico.infinitivo}", min = 3)
    private String objetivosEspecificos;
}
