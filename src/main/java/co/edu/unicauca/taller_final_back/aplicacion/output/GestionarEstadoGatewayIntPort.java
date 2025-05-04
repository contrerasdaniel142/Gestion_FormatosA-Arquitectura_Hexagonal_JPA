package co.edu.unicauca.taller_final_back.aplicacion.output;

import co.edu.unicauca.taller_final_back.dominio.enums.EstadoFormatoAEnum;
import co.edu.unicauca.taller_final_back.dominio.models.Estado;

public interface GestionarEstadoGatewayIntPort {
    public EstadoFormatoAEnum obtenerEstadoActualFormatoA(Integer idFormatoA);
    public Estado cambiarEstadoFormatoA(Integer idFormatoA, EstadoFormatoAEnum nuevoEstadoEnum);
}
