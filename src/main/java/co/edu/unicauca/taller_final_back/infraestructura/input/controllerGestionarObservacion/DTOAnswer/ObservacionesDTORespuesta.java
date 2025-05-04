package co.edu.unicauca.taller_final_back.infraestructura.input.controllerGestionarObservacion.DTOAnswer;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class ObservacionesDTORespuesta {
    private String titulo;
    private String objetivoGeneral;
    private String objetivosEspecificos;
    private String estadoActual;
    private LocalDate fechaRegistroEstado;
    private String conceptoEvaluacion;
    private LocalDate fechaRegistroConcepto;
    private String nombreCoordinador;
    private List<Map<String, String>> listaDocenteObservacion;
}
