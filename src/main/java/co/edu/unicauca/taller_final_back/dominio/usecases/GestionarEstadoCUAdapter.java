package co.edu.unicauca.taller_final_back.dominio.usecases;

import co.edu.unicauca.taller_final_back.aplicacion.input.GestionarEstadoCUIntPort;
import co.edu.unicauca.taller_final_back.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.taller_final_back.aplicacion.output.GestionarEstadoGatewayIntPort;
import co.edu.unicauca.taller_final_back.aplicacion.output.GestionarFormatoAGatewayIntPort;
import co.edu.unicauca.taller_final_back.dominio.enums.EstadoFormatoAEnum;
import co.edu.unicauca.taller_final_back.dominio.models.Estado;
import co.edu.unicauca.taller_final_back.dominio.states.GestorEstadoFormatoA;
import co.edu.unicauca.taller_final_back.dominio.states.formatoA.ResultadoGestorFormatoA;

public class GestionarEstadoCUAdapter implements GestionarEstadoCUIntPort{

    private final GestionarFormatoAGatewayIntPort objGestionarFormatoAGateway;
    private final GestionarEstadoGatewayIntPort objGestionarEstadoGatewayInt;
    private final FormateadorResultadosIntPort objFormateadorResultados;

    public GestionarEstadoCUAdapter(GestionarFormatoAGatewayIntPort objGestionarFormatoAGateway, GestionarEstadoGatewayIntPort objGestionarEstadoGatewayInt, FormateadorResultadosIntPort objFormateadorResultados){
        this.objGestionarFormatoAGateway = objGestionarFormatoAGateway;
        this.objGestionarEstadoGatewayInt = objGestionarEstadoGatewayInt;
        this.objFormateadorResultados = objFormateadorResultados;
    }
    
    public Estado enviarParaEvaluacion(Integer idFormatoA){
        Estado objEstado = null;
        if (!this.objGestionarFormatoAGateway.existeFormatoAPorId(idFormatoA)) {
            this.objFormateadorResultados
                .retornarRespuestaErrorEntidadNoExiste("{peticion.idFormatoA.NoExiste}");
        } else {
            EstadoFormatoAEnum estadoActualEnum = this.objGestionarEstadoGatewayInt.obtenerEstadoActualFormatoA(idFormatoA);
            GestorEstadoFormatoA gestorEstado = new GestorEstadoFormatoA(estadoActualEnum);
            ResultadoGestorFormatoA resultadoGestorEstado = gestorEstado.enviarParaEvaluacion();
            if (!resultadoGestorEstado.cambioPermitido()) {
                this.objFormateadorResultados
                    .retornarRespuestaErrorReglaDeNegocio(resultadoGestorEstado.mensaje());
            }else{
                EstadoFormatoAEnum nuevoEstado = EstadoFormatoAEnum.EN_EVALUACION;
                objEstado = this.objGestionarEstadoGatewayInt.cambiarEstadoFormatoA(idFormatoA, nuevoEstado);
            }
         }
        return objEstado;
    }

    public Estado aprobar(Integer idFormatoA){
        Estado objEstado = null;
        if (!this.objGestionarFormatoAGateway.existeFormatoAPorId(idFormatoA)) {
            this.objFormateadorResultados
                .retornarRespuestaErrorEntidadNoExiste("{peticion.idFormatoA.NoExiste}");
        } else {
            EstadoFormatoAEnum estadoActualEnum = this.objGestionarEstadoGatewayInt.obtenerEstadoActualFormatoA(idFormatoA);
            GestorEstadoFormatoA gestorEstado = new GestorEstadoFormatoA(estadoActualEnum);
            ResultadoGestorFormatoA resultadoGestorEstado = gestorEstado.aprobar();
            if (!resultadoGestorEstado.cambioPermitido()) {
                this.objFormateadorResultados
                    .retornarRespuestaErrorReglaDeNegocio(resultadoGestorEstado.mensaje());
            }else{
                EstadoFormatoAEnum nuevoEstado = EstadoFormatoAEnum.APROBADO;
                objEstado = this.objGestionarEstadoGatewayInt.cambiarEstadoFormatoA(idFormatoA, nuevoEstado);
            }
         }
        return objEstado;
    }

    public Estado rechazar(Integer idFormatoA){
        Estado objEstado = null;
        if (!this.objGestionarFormatoAGateway.existeFormatoAPorId(idFormatoA)) {
            this.objFormateadorResultados
                .retornarRespuestaErrorEntidadNoExiste("{peticion.idFormatoA.NoExiste}");
        } else {
            EstadoFormatoAEnum estadoActualEnum = this.objGestionarEstadoGatewayInt.obtenerEstadoActualFormatoA(idFormatoA);
            GestorEstadoFormatoA gestorEstado = new GestorEstadoFormatoA(estadoActualEnum);
            ResultadoGestorFormatoA resultadoGestorEstado = gestorEstado.enviarParaEvaluacion();
            if (!resultadoGestorEstado.cambioPermitido()) {
                this.objFormateadorResultados
                    .retornarRespuestaErrorReglaDeNegocio(resultadoGestorEstado.mensaje());
            }else{
                EstadoFormatoAEnum nuevoEstado = EstadoFormatoAEnum.RECHAZADO;
                objEstado = this.objGestionarEstadoGatewayInt.cambiarEstadoFormatoA(idFormatoA, nuevoEstado);
            }
         }
        return objEstado;
    }
}
