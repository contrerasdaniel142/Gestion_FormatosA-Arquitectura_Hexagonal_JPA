package co.edu.unicauca.taller_final_back.dominio.states.formatoA;

import co.edu.unicauca.taller_final_back.dominio.states.GestorEstadoFormatoA;

public class EstadoEnEvaluacion implements IEstadoFormatoA{
    @Override
    public ResultadoGestorFormatoA enviarFormatoAParaEvaluacion(GestorEstadoFormatoA gestorEstado){
        return new ResultadoGestorFormatoA(false, "{estado.evaluacion.evaluacion}");
    }
    @Override
    public ResultadoGestorFormatoA agregarObservacionesFormatoA(GestorEstadoFormatoA gestorEstado){
        EstadoPorCorregir objEstado = new EstadoPorCorregir();
        gestorEstado.setEstado(objEstado);
        return new ResultadoGestorFormatoA(true, "{estado.evaluacion.observaciones}");
    }
    @Override
    public ResultadoGestorFormatoA aprobarFormatoA(GestorEstadoFormatoA gestorEstado) {
        EstadoAprobado objEstado = new EstadoAprobado();
        gestorEstado.setEstado(objEstado);
        return new ResultadoGestorFormatoA(true, "{estado.evaluacion.aprobacion}");
    }
    @Override
    public ResultadoGestorFormatoA rechazarFormatoA(GestorEstadoFormatoA gestorEstado){
        EstadoRechazado objEstado = new EstadoRechazado();
        gestorEstado.setEstado(objEstado);
        return new ResultadoGestorFormatoA(true, "{estado.evaluacion.rechazo}");
    }
    
}
