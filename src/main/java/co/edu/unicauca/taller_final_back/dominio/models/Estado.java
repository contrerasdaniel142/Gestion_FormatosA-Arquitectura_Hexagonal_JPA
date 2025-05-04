package co.edu.unicauca.taller_final_back.dominio.models;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Estado {
    private String estadoActual;
    private LocalDate fechaRegistro;
}
