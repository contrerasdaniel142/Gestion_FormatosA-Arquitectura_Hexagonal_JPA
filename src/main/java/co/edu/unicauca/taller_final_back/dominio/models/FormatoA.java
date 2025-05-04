package co.edu.unicauca.taller_final_back.dominio.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class FormatoA {
    private String titulo;
    private String objetivoGeneral;
    private String objetivosEspecificos;
    private Estado objEstado;

}
