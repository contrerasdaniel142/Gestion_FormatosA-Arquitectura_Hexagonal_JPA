package co.edu.unicauca.taller_final_back.infraestructura.input.controllerGestionarDocente.DTOAnswer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class DocenteDTORespuesta {
    private String nombresDocente;
    private String apellidosDocente;
    private String nombreGrupo;
    private String correo;
}
