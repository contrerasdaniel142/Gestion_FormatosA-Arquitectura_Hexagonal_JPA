package co.edu.unicauca.taller_final_back.infraestructura.output.exceptionsController.ownExceptions;

import co.edu.unicauca.taller_final_back.infraestructura.output.exceptionsController.exceptionStructure.CodigoError;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public abstract class GestionRuntimeException extends RuntimeException {

  protected CodigoError codigoError;

  public abstract String formatException();
}
