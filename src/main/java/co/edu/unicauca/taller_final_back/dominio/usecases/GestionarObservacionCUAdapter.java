package co.edu.unicauca.taller_final_back.dominio.usecases;

import java.util.List;

import co.edu.unicauca.taller_final_back.aplicacion.input.GestionarObservacionCUIntPort;
import co.edu.unicauca.taller_final_back.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.taller_final_back.aplicacion.output.GestionarDocenteGatewayIntPort;
import co.edu.unicauca.taller_final_back.aplicacion.output.GestionarEstadoGatewayIntPort;
import co.edu.unicauca.taller_final_back.aplicacion.output.GestionarFormatoAGatewayIntPort;
import co.edu.unicauca.taller_final_back.aplicacion.output.GestionarObservacionGatewayIntPort;
import co.edu.unicauca.taller_final_back.dominio.enums.EstadoFormatoAEnum;
import co.edu.unicauca.taller_final_back.dominio.models.Observacion;
import co.edu.unicauca.taller_final_back.dominio.states.GestorEstadoFormatoA;
import co.edu.unicauca.taller_final_back.dominio.states.formatoA.ResultadoGestorFormatoA;
import co.edu.unicauca.taller_final_back.infraestructura.input.controllerGestionarObservacion.DTOAnswer.ObservacionesDTORespuesta;

public class GestionarObservacionCUAdapter implements GestionarObservacionCUIntPort{
    
    private final GestionarObservacionGatewayIntPort objGestionarObservacionGateway;
    private final GestionarFormatoAGatewayIntPort objGestionarFormatoAGateway;
    private final GestionarDocenteGatewayIntPort objGestionarDocenteGateway;
    private final FormateadorResultadosIntPort objFormateadorResultados;
    private final GestionarEstadoGatewayIntPort objGestionarEstadoGatewayInt;

    public GestionarObservacionCUAdapter(GestionarObservacionGatewayIntPort objGestionarObservacionGateway, GestionarFormatoAGatewayIntPort objGestionarFormatoAGateway, GestionarDocenteGatewayIntPort objGestionarDocenteGateway, GestionarEstadoGatewayIntPort objGestionarEstadoGatewayInt, FormateadorResultadosIntPort objFormateadorResultados){
        this.objGestionarObservacionGateway = objGestionarObservacionGateway;
        this.objFormateadorResultados = objFormateadorResultados;
        this.objGestionarDocenteGateway = objGestionarDocenteGateway;
        this.objGestionarFormatoAGateway = objGestionarFormatoAGateway;
        this.objGestionarEstadoGatewayInt = objGestionarEstadoGatewayInt;
    }

    public Observacion crearObservacion(Observacion objObservacion, List<Integer> idsDocente, Integer idFormatoA){
        Observacion objObservacionCreada = null;
        if (!this.objGestionarFormatoAGateway.existeFormatoAPorId(idFormatoA)) {
            this.objFormateadorResultados
                .retornarRespuestaErrorEntidadNoExiste("{peticion.idFormatoA.NoExiste}");
        }else{
            if (!this.objGestionarDocenteGateway.existenDocentesPorIds(idsDocente)) {
                this.objFormateadorResultados
                    .retornarRespuestaErrorEntidadNoExiste("{peticion.idsDocente.NoExiste}");
            }else{
                EstadoFormatoAEnum estadoActualEnum = this.objGestionarEstadoGatewayInt.obtenerEstadoActualFormatoA(idFormatoA);
                GestorEstadoFormatoA gestorEstado = new GestorEstadoFormatoA(estadoActualEnum);
                ResultadoGestorFormatoA resultadoGestorEstado = gestorEstado.aprobar();
                if (!resultadoGestorEstado.cambioPermitido()) {
                    this.objFormateadorResultados
                        .retornarRespuestaErrorReglaDeNegocio(resultadoGestorEstado.mensaje());
                }else{
                    objObservacionCreada = this.objGestionarObservacionGateway.guardarObservacion(objObservacion, idsDocente, idFormatoA);
                }
            }
        }
        return objObservacionCreada;
    }

    public ObservacionesDTORespuesta listarObservacionesPorFormatoA(Integer idFormatoA){
        ObservacionesDTORespuesta objObservaciones = null;
        if (!this.objGestionarFormatoAGateway.existeFormatoAPorId(idFormatoA)) {
            this.objFormateadorResultados
                .retornarRespuestaErrorEntidadNoExiste("{peticion.idFormatoA.NoExiste}");
        }else{
            objObservaciones = this.objGestionarObservacionGateway.listarPorFormatoA(idFormatoA);
        }
        return objObservaciones;
    }
}
