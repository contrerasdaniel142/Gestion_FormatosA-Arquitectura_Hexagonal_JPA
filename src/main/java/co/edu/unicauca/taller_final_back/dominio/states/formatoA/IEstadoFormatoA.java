package co.edu.unicauca.taller_final_back.dominio.states.formatoA;

import co.edu.unicauca.taller_final_back.dominio.states.GestorEstadoFormatoA;

public interface IEstadoFormatoA {
    ResultadoGestorFormatoA enviarFormatoAParaEvaluacion(GestorEstadoFormatoA gestorEstado);
    ResultadoGestorFormatoA agregarObservacionesFormatoA(GestorEstadoFormatoA gestorEstado);
    ResultadoGestorFormatoA aprobarFormatoA(GestorEstadoFormatoA gestorEstado);
    ResultadoGestorFormatoA rechazarFormatoA(GestorEstadoFormatoA gestorEstado);
}
