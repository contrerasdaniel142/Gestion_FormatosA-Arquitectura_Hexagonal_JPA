package co.edu.unicauca.taller_final_back.aplicacion.input;

import java.util.List;

import co.edu.unicauca.taller_final_back.dominio.models.FormatoA;
import co.edu.unicauca.taller_final_back.dominio.models.RangoFechas;
import co.edu.unicauca.taller_final_back.infraestructura.input.controllerGestionarFormatoA.DTOAnswer.InformacionFormatoARespuesta;
import co.edu.unicauca.taller_final_back.infraestructura.input.controllerGestionarObservacion.DTOAnswer.ObservacionesDTORespuesta;

public interface GestionarFormatoACUIntPort {
    public FormatoA crearFormatoA(FormatoA formatoA, Integer idDocente);
    public List<ObservacionesDTORespuesta> listarFormatosAPorDocente(String correoDocente);
    public List<InformacionFormatoARespuesta> listarFormatosAConObservacionesPorDocenteEntreFechas(Integer idDocente, RangoFechas RangoFechas);

}
