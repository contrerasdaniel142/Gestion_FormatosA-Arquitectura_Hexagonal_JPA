package co.edu.unicauca.taller_final_back.aplicacion.output;

import java.util.List;

import co.edu.unicauca.taller_final_back.dominio.enums.RolDocenteEnum;
import co.edu.unicauca.taller_final_back.dominio.models.Docente;
import co.edu.unicauca.taller_final_back.infraestructura.input.controllerGestionarDocente.DTOAnswer.DocenteRolDTORespuesta;

public interface GestionarDocenteGatewayIntPort {
    public Boolean existeDocentePorId(Integer idDocente);
    public Boolean existeDocentePorCorreo(String correoDocente);
    public Boolean existenDocentesPorIds(List<Integer> idsDocente);
    public List<DocenteRolDTORespuesta> listarPorRol(RolDocenteEnum rolDocenteEnum);
    public List<Docente> listarPorGrupoYPatronAscendente(String grupo, String patron);
}
