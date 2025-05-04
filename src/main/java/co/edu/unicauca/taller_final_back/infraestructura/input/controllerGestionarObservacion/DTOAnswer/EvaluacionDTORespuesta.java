package co.edu.unicauca.taller_final_back.infraestructura.input.controllerGestionarObservacion.DTOAnswer;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class EvaluacionDTORespuesta {
    private String concepto;
    private LocalDate fechaRegistroConcepto;
    private String nombreCoordinador;
    private List<ObservacionDTORespuesta> observaciones;
}
