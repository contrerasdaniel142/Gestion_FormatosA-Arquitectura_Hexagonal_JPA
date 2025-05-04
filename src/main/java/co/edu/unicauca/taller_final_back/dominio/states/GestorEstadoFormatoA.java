package co.edu.unicauca.taller_final_back.dominio.states;

import co.edu.unicauca.taller_final_back.dominio.enums.EstadoFormatoAEnum;
import co.edu.unicauca.taller_final_back.dominio.states.formatoA.EstadoAprobado;
import co.edu.unicauca.taller_final_back.dominio.states.formatoA.EstadoEnEvaluacion;
import co.edu.unicauca.taller_final_back.dominio.states.formatoA.EstadoFormulado;
import co.edu.unicauca.taller_final_back.dominio.states.formatoA.EstadoPorCorregir;
import co.edu.unicauca.taller_final_back.dominio.states.formatoA.EstadoRechazado;
import co.edu.unicauca.taller_final_back.dominio.states.formatoA.IEstadoFormatoA;
import co.edu.unicauca.taller_final_back.dominio.states.formatoA.ResultadoGestorFormatoA;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class GestorEstadoFormatoA {
    private IEstadoFormatoA estado;

    public GestorEstadoFormatoA(EstadoFormatoAEnum estadoActualEnum){
        this.estado = this.establecerEstado(estadoActualEnum);
    }

    public ResultadoGestorFormatoA enviarParaEvaluacion(){
        return this.estado.enviarFormatoAParaEvaluacion(this);
    }

    public ResultadoGestorFormatoA aprobar(){
        return this.estado.aprobarFormatoA(this);
    }

    public ResultadoGestorFormatoA agregarObsservaciones(){
        return this.estado.agregarObservacionesFormatoA(this);
    }

    public ResultadoGestorFormatoA rechazar(){
        return this.estado.rechazarFormatoA(this);
    }

    private IEstadoFormatoA establecerEstado(EstadoFormatoAEnum estadoEnum) {
        return switch (estadoEnum) {
            case EN_EVALUACION -> new EstadoEnEvaluacion();
            case CON_OBSERVACIONES -> new EstadoPorCorregir();
            case APROBADO -> new EstadoAprobado();
            case RECHAZADO -> new EstadoRechazado();
            case FORMULADO -> new EstadoFormulado();
        };
    }

}
