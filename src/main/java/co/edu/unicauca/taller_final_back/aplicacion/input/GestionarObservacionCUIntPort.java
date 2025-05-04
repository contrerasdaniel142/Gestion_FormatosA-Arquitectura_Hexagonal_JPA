package co.edu.unicauca.taller_final_back.aplicacion.input;

import java.util.List;

import co.edu.unicauca.taller_final_back.dominio.models.Observacion;
import co.edu.unicauca.taller_final_back.infraestructura.input.controllerGestionarObservacion.DTOAnswer.ObservacionesDTORespuesta;

public interface GestionarObservacionCUIntPort{
    public Observacion crearObservacion(Observacion objObservacion, List<Integer> idsDocente, Integer idFormatoA);
    public ObservacionesDTORespuesta listarObservacionesPorFormatoA(Integer idFormatoA);
}
