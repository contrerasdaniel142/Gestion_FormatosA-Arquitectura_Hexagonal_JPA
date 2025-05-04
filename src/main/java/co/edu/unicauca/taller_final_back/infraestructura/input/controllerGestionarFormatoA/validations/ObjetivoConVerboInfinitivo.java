package co.edu.unicauca.taller_final_back.infraestructura.input.controllerGestionarFormatoA.validations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = ObjetivoConVerboInfinitivoValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ObjetivoConVerboInfinitivo {

    /**
     * Mensaje por defecto cuando la validación falla.
     */
    String message() default "Cada objetivo debe comenzar con un verbo en infinitivo y se requieren al menos {min} objetivo(s).";

    /**
     * Número mínimo de objetivos (separados por ';').
     */
    int min() default 1;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
