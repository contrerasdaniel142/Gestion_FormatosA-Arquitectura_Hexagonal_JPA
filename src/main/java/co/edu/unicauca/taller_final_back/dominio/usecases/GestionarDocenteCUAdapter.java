package co.edu.unicauca.taller_final_back.dominio.usecases;

import java.util.List;

import co.edu.unicauca.taller_final_back.aplicacion.input.GestionarDocenteCUIntPort;
import co.edu.unicauca.taller_final_back.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.taller_final_back.aplicacion.output.GestionarDocenteGatewayIntPort;
import co.edu.unicauca.taller_final_back.dominio.enums.RolDocenteEnum;
import co.edu.unicauca.taller_final_back.dominio.models.Docente;
import co.edu.unicauca.taller_final_back.infraestructura.input.controllerGestionarDocente.DTOAnswer.DocenteRolDTORespuesta;

public class GestionarDocenteCUAdapter implements GestionarDocenteCUIntPort{
    private final GestionarDocenteGatewayIntPort objGestionarDocenteGateway;
    private final FormateadorResultadosIntPort objFormateadorResultados;

    public GestionarDocenteCUAdapter(GestionarDocenteGatewayIntPort objGestionarDocenteGateway, FormateadorResultadosIntPort objFormateadorResultados){
        this.objGestionarDocenteGateway = objGestionarDocenteGateway;
        this.objFormateadorResultados = objFormateadorResultados;
    }

    @Override
    public List<DocenteRolDTORespuesta> listarPorRolComite(){
        RolDocenteEnum rolDocenteEnum = RolDocenteEnum.COMITE_TRABAJO_GRADO;
        List<DocenteRolDTORespuesta> docentesMiembrosComite = this.objGestionarDocenteGateway.listarPorRol(rolDocenteEnum);
        return docentesMiembrosComite;
    }

    @Override
    public List<Docente> listarPorGrupoYPatron(String grupo, String patron){
        List<Docente> docentes = this.objGestionarDocenteGateway.listarPorGrupoYPatronAscendente(grupo,patron);
        return docentes;
    }
}
