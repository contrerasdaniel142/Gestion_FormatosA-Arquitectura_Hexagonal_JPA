package co.edu.unicauca.taller_final_back.dominio.models;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Evaluacion {
    private String concepto;
    private LocalDate fechaRegistroConcepto;
    private String nombreCoordinador;
    private FormatoA objFormatoA;

}
