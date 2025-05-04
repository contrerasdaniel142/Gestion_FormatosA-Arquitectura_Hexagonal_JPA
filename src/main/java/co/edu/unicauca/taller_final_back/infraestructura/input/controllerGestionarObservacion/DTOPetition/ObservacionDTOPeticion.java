package co.edu.unicauca.taller_final_back.infraestructura.input.controllerGestionarObservacion.DTOPetition;

import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class ObservacionDTOPeticion {
    @NotNull(message = "{observacion.observacion.emply}")
    private String observacion;
}