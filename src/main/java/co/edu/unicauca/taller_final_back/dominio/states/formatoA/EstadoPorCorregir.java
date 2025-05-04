package co.edu.unicauca.taller_final_back.dominio.states.formatoA;

import co.edu.unicauca.taller_final_back.dominio.states.GestorEstadoFormatoA;

public class EstadoPorCorregir implements IEstadoFormatoA{
    @Override
    public ResultadoGestorFormatoA enviarFormatoAParaEvaluacion(GestorEstadoFormatoA gestorEstado){
        EstadoEnEvaluacion objEstado = new EstadoEnEvaluacion();
        gestorEstado.setEstado(objEstado);
        return new ResultadoGestorFormatoA(true, "{estado.porCorregir.evaluacion}");
    }
    @Override
    public ResultadoGestorFormatoA agregarObservacionesFormatoA(GestorEstadoFormatoA gestorEstado){
        return new ResultadoGestorFormatoA(false, "{estado.porCorregir.observaciones}");
    }
    @Override
    public ResultadoGestorFormatoA aprobarFormatoA(GestorEstadoFormatoA gestorEstado) {
        EstadoAprobado objEstado = new EstadoAprobado();
        gestorEstado.setEstado(objEstado);
        return new ResultadoGestorFormatoA(true, "{estado.porCorregir.aprobacion}");
    }
    @Override
    public ResultadoGestorFormatoA rechazarFormatoA(GestorEstadoFormatoA gestorEstado){
        EstadoRechazado objEstado = new EstadoRechazado();
        gestorEstado.setEstado(objEstado);
        return new ResultadoGestorFormatoA(true, "{estado.porCorregir.rechazo}");
    }
    
}
