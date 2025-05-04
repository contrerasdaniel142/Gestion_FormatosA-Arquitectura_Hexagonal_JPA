package co.edu.unicauca.taller_final_back.infraestructura.input.controllerGestionarDocente.DTOAnswer;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class DocenteRolDTORespuesta {
    private String nombresDocente;
    private String apellidosDocente;
    private String nombreGrupo;
    private String correo;
    private String rol;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
}
