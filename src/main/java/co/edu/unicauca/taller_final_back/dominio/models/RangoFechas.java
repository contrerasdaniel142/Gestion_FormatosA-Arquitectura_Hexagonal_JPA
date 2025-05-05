package co.edu.unicauca.taller_final_back.dominio.models;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class RangoFechas {
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
}
