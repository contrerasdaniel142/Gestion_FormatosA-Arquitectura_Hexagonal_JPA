package co.edu.unicauca.taller_final_back.dominio.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Docente {
    private String nombresDocente;
    private String apellidosDocente;
    private String nombreGrupo;
    private String correo;
}
