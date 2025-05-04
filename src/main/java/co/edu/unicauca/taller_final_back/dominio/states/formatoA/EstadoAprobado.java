package co.edu.unicauca.taller_final_back.dominio.states.formatoA;

import co.edu.unicauca.taller_final_back.dominio.states.GestorEstadoFormatoA;

public class EstadoAprobado implements IEstadoFormatoA{

    @Override
    public ResultadoGestorFormatoA enviarFormatoAParaEvaluacion(GestorEstadoFormatoA gestorEstado){
        return new ResultadoGestorFormatoA(false, "{estado.aprobado.evaluacion}");
    }
    @Override
    public ResultadoGestorFormatoA agregarObservacionesFormatoA(GestorEstadoFormatoA gestorEstado){
        return new ResultadoGestorFormatoA(false, "{estado.aprobado.observaciones}");
    }
    @Override
    public ResultadoGestorFormatoA aprobarFormatoA(GestorEstadoFormatoA gestorEstado) {
        return new ResultadoGestorFormatoA(false, "{estado.aprobado.aprobacion}");
    }
    @Override
    public ResultadoGestorFormatoA rechazarFormatoA(GestorEstadoFormatoA gestorEstado){
        return new ResultadoGestorFormatoA(false, "{estado.aprobado.rechazo}");
    }
}
