package co.edu.unicauca.taller_final_back.dominio.usecases;

import java.util.ArrayList;
import java.util.List;

import co.edu.unicauca.taller_final_back.aplicacion.input.GestionarFormatoACUIntPort;
import co.edu.unicauca.taller_final_back.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.taller_final_back.aplicacion.output.GestionarDocenteGatewayIntPort;
import co.edu.unicauca.taller_final_back.aplicacion.output.GestionarFormatoAGatewayIntPort;
import co.edu.unicauca.taller_final_back.dominio.models.FormatoA;
import co.edu.unicauca.taller_final_back.dominio.models.RangoFechas;
import co.edu.unicauca.taller_final_back.infraestructura.input.controllerGestionarFormatoA.DTOAnswer.InformacionFormatoARespuesta;
import co.edu.unicauca.taller_final_back.infraestructura.input.controllerGestionarObservacion.DTOAnswer.ObservacionesDTORespuesta;

public class GestionarFormatoACUAdapter implements GestionarFormatoACUIntPort {

    private final GestionarFormatoAGatewayIntPort objGestionarFormatoAGateway;
    private final GestionarDocenteGatewayIntPort objGestionarDocenteGateway;
    private final FormateadorResultadosIntPort objFormateadorResultados;

    public GestionarFormatoACUAdapter(GestionarFormatoAGatewayIntPort objGestionarFormatoAGateway, GestionarDocenteGatewayIntPort objGestionarDocenteGateway, FormateadorResultadosIntPort objFormateadorResultados){
        this.objGestionarFormatoAGateway = objGestionarFormatoAGateway;
        this.objGestionarDocenteGateway = objGestionarDocenteGateway;
        this.objFormateadorResultados= objFormateadorResultados;
    }

    public FormatoA crearFormatoA(FormatoA objFormatoA, Integer idDocente){
        FormatoA objFormatoACreado = null;
        if (this.objGestionarFormatoAGateway.existeTituloFormatoA(objFormatoA.getTitulo())){
            this.objFormateadorResultados
                    .retornarRespuestaErrorReglaDeNegocio("{peticion.titulo.existe}");
        }else{
            if (!this.objGestionarDocenteGateway.existeDocentePorId(idDocente)) {
                this.objFormateadorResultados
                    .retornarRespuestaErrorEntidadNoExiste("{peticion.idDocente.NoExiste}");
            }else{
                objFormatoACreado = this.objGestionarFormatoAGateway.guardarFormatoA(objFormatoA, idDocente);
            }
        }
        return objFormatoACreado;
    }
    
    public List<ObservacionesDTORespuesta> listarFormatosAPorDocente(String correoDocente){
        List<ObservacionesDTORespuesta> listaObtenida = new ArrayList<ObservacionesDTORespuesta>();
        if (!this.objGestionarDocenteGateway.existeDocentePorCorreo(correoDocente)) {
            this.objFormateadorResultados
                .retornarRespuestaErrorEntidadNoExiste("{peticion.correo.NoExiste}");
        }else{
            listaObtenida = this.objGestionarFormatoAGateway.listarFormatosAPorDocente(correoDocente);
        }
        return listaObtenida;
    }

    public List<InformacionFormatoARespuesta> listarFormatosAConObservacionesPorDocenteEntreFechas(Integer idDocente, RangoFechas rangoFechas){
        List<InformacionFormatoARespuesta> listaObtenida = new ArrayList<InformacionFormatoARespuesta>();
        if (!this.objGestionarDocenteGateway.existeDocentePorId(idDocente)) {
            this.objFormateadorResultados
                .retornarRespuestaErrorEntidadNoExiste("{peticion.idDocente.NoExiste}");
        } else {
            if (rangoFechas.getFechaInicio().isAfter(rangoFechas.getFechaFin())) {
                this.objFormateadorResultados
                    .retornarRespuestaErrorReglaDeNegocio("{peticion.fechas.invalidas}");
            } else {
                listaObtenida = this.objGestionarFormatoAGateway.listarFormatosAConObservacionesPorDocenteEntreFechas(idDocente, rangoFechas);
            }
        }
        return listaObtenida;
    }
}
