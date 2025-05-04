package co.edu.unicauca.taller_final_back.infraestructura.input.controllerGestionarFormatoA.DTOPetition;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class RangoFechasDTOPeticion {
    @NotNull(message = "{rangoFechas.fechaInicio.emply}") @PastOrPresent(message = "{rangoFechas.fechaInicio.invalida}")
    private LocalDate fechaInicio;

    @NotNull(message = "{rangoFechas.fechaFin.emply}")
    private LocalDate fechaFin;
}