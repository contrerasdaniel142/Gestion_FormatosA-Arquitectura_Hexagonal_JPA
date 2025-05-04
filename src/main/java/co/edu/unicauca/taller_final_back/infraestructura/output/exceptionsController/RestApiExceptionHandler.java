package co.edu.unicauca.taller_final_back.infraestructura.output.exceptionsController;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import co.edu.unicauca.taller_final_back.infraestructura.output.exceptionsController.exceptionStructure.CodigoError;
import co.edu.unicauca.taller_final_back.infraestructura.output.exceptionsController.exceptionStructure.Error;
import co.edu.unicauca.taller_final_back.infraestructura.output.exceptionsController.exceptionStructure.ErrorUtils;
import co.edu.unicauca.taller_final_back.infraestructura.output.exceptionsController.ownExceptions.EntidadNoExisteException;
import co.edu.unicauca.taller_final_back.infraestructura.output.exceptionsController.ownExceptions.EntidadYaExisteException;
import co.edu.unicauca.taller_final_back.infraestructura.output.exceptionsController.ownExceptions.ReglaNegocioException;


@ControllerAdvice
public class RestApiExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> handleGenericException(final HttpServletRequest req,
                                                        final Exception ex,
                                                        final Locale locale) {
        final Error error = ErrorUtils
                .crearError(CodigoError.ERROR_GENERICO.getCodigo(),
                            CodigoError.ERROR_GENERICO.getLlaveMensaje(),
                            HttpStatus.INTERNAL_SERVER_ERROR.value())
                .setUrl(req.getRequestURL().toString())
                .setMetodo(req.getMethod());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(EntidadYaExisteException.class)
    public ResponseEntity<Error> handleEntidadYaExisteException(final HttpServletRequest req,
                                                                final EntidadYaExisteException ex) {
        final Error error = ErrorUtils
                .crearError(CodigoError.ENTIDAD_YA_EXISTE.getCodigo(),
                            String.format("%s, %s", CodigoError.ENTIDAD_YA_EXISTE.getLlaveMensaje(), ex.getMessage()),
                            HttpStatus.NOT_ACCEPTABLE.value())
                .setUrl(req.getRequestURL().toString())
                .setMetodo(req.getMethod());
        return new ResponseEntity<>(error, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(ReglaNegocioException.class)
    public ResponseEntity<Error> handleReglaNegocioExcepcion(final HttpServletRequest req,
                                                             final ReglaNegocioException ex,
                                                             final Locale locale) {
        final Error error = ErrorUtils
                .crearError(CodigoError.VIOLACION_REGLA_DE_NEGOCIO.getCodigo(),
                            ex.formatException(),
                            HttpStatus.BAD_REQUEST.value())
                .setUrl(req.getRequestURL().toString())
                .setMetodo(req.getMethod());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntidadNoExisteException.class)
    public ResponseEntity<Error> handleEntidadNoExisteException(final HttpServletRequest req,
                                                                final EntidadNoExisteException ex,
                                                                final Locale locale) {
        final Error error = ErrorUtils
                .crearError(CodigoError.ENTIDAD_NO_ENCONTRADA.getCodigo(),
                            String.format("%s, %s", CodigoError.ENTIDAD_NO_ENCONTRADA.getLlaveMensaje(), ex.getMessage()),
                            HttpStatus.NOT_FOUND.value())
                .setUrl(req.getRequestURL().toString())
                .setMetodo(req.getMethod());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errores = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String campo = ((FieldError) error).getField();
            String mensajeDeError = error.getDefaultMessage();
            errores.put(campo, mensajeDeError);
        });

        return new ResponseEntity<>(errores, HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map<String, String>> handleConstraintViolationException(ConstraintViolationException ex) {
        Map<String, String> errores = new HashMap<>();
        ex.getConstraintViolations().forEach(cv -> {
            String campo = cv.getPropertyPath().toString();
            String mensaje = cv.getMessage();
            errores.put(campo, mensaje);
        });

        return new ResponseEntity<>(errores, HttpStatus.BAD_REQUEST);
    }
}