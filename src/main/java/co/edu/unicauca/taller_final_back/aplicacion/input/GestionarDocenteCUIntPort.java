package co.edu.unicauca.taller_final_back.aplicacion.input;

import java.util.List;

import co.edu.unicauca.taller_final_back.dominio.models.Docente;
import co.edu.unicauca.taller_final_back.infraestructura.input.controllerGestionarDocente.DTOAnswer.DocenteRolDTORespuesta;

public interface GestionarDocenteCUIntPort {
    public List<DocenteRolDTORespuesta> listarPorRolComite();
    public List<Docente> listarPorGrupoYPatron(String nombreGrupo,String patron);
}
