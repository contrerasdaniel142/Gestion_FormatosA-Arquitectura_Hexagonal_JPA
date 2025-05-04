package co.edu.unicauca.taller_final_back.aplicacion.output;

import java.util.List;

import co.edu.unicauca.taller_final_back.dominio.models.Observacion;
import co.edu.unicauca.taller_final_back.infraestructura.input.controllerGestionarObservacion.DTOAnswer.ObservacionesDTORespuesta;

public interface GestionarObservacionGatewayIntPort {
    public Observacion guardarObservacion(Observacion observacion, List<Integer> idsDocente, Integer idFormatoA);
    public ObservacionesDTORespuesta listarPorFormatoA(Integer idFormatoA);
}
