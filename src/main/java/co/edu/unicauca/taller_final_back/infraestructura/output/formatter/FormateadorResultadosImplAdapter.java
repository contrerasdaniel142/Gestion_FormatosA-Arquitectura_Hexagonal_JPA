package co.edu.unicauca.taller_final_back.infraestructura.output.formatter;

import org.springframework.stereotype.Service;

import co.edu.unicauca.taller_final_back.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.taller_final_back.infraestructura.output.exceptionsController.ownExceptions.EntidadNoExisteException;
import co.edu.unicauca.taller_final_back.infraestructura.output.exceptionsController.ownExceptions.EntidadYaExisteException;
import co.edu.unicauca.taller_final_back.infraestructura.output.exceptionsController.ownExceptions.ReglaNegocioException;

@Service
public class FormateadorResultadosImplAdapter implements FormateadorResultadosIntPort {
    @Override
    public void retornarRespuestaErrorEntidadYaExiste(String mensaje){
        EntidadYaExisteException objException = new EntidadYaExisteException(mensaje);
        throw objException;
    }

    @Override
    public void retornarRespuestaErrorEntidadNoExiste(String mensaje){
        EntidadNoExisteException objException = new EntidadNoExisteException(mensaje);
        throw objException;
    }

    @Override
    public void retornarRespuestaErrorReglaDeNegocio(String mensaje){
        ReglaNegocioException objException = new ReglaNegocioException(mensaje);
        throw objException;
    }
}
