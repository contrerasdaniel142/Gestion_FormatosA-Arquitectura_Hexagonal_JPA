package co.edu.unicauca.taller_final_back.dominio.models;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class Observacion {
    private Integer idObservacion;
    private String observacion;
    private LocalDate fechaRegistroObservacion;
    private List<Docente> docentes;
}
