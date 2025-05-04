package co.edu.unicauca.taller_final_back.aplicacion.input;

import co.edu.unicauca.taller_final_back.dominio.models.Estado;

public interface GestionarEstadoCUIntPort {
    public Estado enviarParaEvaluacion(Integer idFormatoA);
    public Estado aprobar(Integer idFormatoA);
    public Estado rechazar(Integer idFormatoA);
}