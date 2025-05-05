package co.edu.unicauca.taller_final_back.infraestructura.input.controllerGestionarObservacion.DTOAnswer;

import java.time.LocalDate;
import java.util.List;

import co.edu.unicauca.taller_final_back.infraestructura.input.controllerGestionarDocente.DTOAnswer.DocenteDTORespuesta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class ObservacionDTORespuesta {
    private LocalDate fechaRegistroObservacion;
    private String observacion;
    private List<DocenteDTORespuesta> docentes;
}
