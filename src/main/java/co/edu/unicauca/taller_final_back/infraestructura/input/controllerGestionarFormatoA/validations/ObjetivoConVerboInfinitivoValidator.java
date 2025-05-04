
// ObjetivoConVerboInfinitivoValidator.java
package co.edu.unicauca.taller_final_back.infraestructura.input.controllerGestionarFormatoA.validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ObjetivoConVerboInfinitivoValidator implements ConstraintValidator<ObjetivoConVerboInfinitivo, String> {

    private int minObjectives;

    @Override
    public void initialize(ObjetivoConVerboInfinitivo constraintAnnotation) {
        this.minObjectives = constraintAnnotation.min();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.trim().isEmpty()) {
            return false; // inválido si está vacío o nulo
        }

        // Dividir el texto por punto y coma (;), eliminando espacios alrededor
        String[] objetivos = value.split("\\s*;\\s*");

        // Contar objetivos no vacíos y verificar cada infinitivo
        int count = 0;
        for (String objetivo : objetivos) {
            String trimmed = objetivo.trim();
            if (trimmed.isEmpty()) {
                continue;
            }
            count++;
            String firstWord = trimmed.split("\\s+")[0].toLowerCase();
            if (!(firstWord.endsWith("ar") || firstWord.endsWith("er") || firstWord.endsWith("ir"))) {
                return false;
            }
        }

        // Verificar número mínimo de objetivos
        return count >= minObjectives;
    }
}