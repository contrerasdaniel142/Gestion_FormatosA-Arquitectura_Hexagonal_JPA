package co.edu.unicauca.taller_final_back.infraestructura.input.controllerGestionarEstado.DTOAnswer;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class EstadoDTORespuesta {
    private String estadoActual;
    private LocalDate fechaRegistro;
}
