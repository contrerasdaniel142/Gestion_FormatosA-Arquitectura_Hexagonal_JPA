package co.edu.unicauca.taller_final_back.aplicacion.output;

import java.util.List;

import co.edu.unicauca.taller_final_back.dominio.models.FormatoA;
import co.edu.unicauca.taller_final_back.dominio.models.RangoFechas;
import co.edu.unicauca.taller_final_back.infraestructura.input.controllerGestionarFormatoA.DTOAnswer.InformacionFormatoARespuesta;
import co.edu.unicauca.taller_final_back.infraestructura.input.controllerGestionarObservacion.DTOAnswer.ObservacionesDTORespuesta;

public interface GestionarFormatoAGatewayIntPort {
    public Boolean existeTituloFormatoA(String titulo);
    public Boolean existeFormatoAPorId(Integer idFormatoA);
    public FormatoA guardarFormatoA(FormatoA formatoA, Integer idDocente);
    public List<ObservacionesDTORespuesta> listarFormatosAPorDocente(String correoDocente);
    public List<InformacionFormatoARespuesta> listarFormatosAConObservacionesPorDocenteEntreFechas(Integer idDocente, RangoFechas rangoFechas);
}
