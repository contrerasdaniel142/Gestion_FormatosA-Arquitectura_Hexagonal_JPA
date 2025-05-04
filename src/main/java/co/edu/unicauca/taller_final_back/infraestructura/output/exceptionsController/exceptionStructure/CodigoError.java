package co.edu.unicauca.taller_final_back.infraestructura.output.exceptionsController.exceptionStructure;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum CodigoError {

    ERROR_GENERICO("GC-0001", "{error.generico}"),
    ENTIDAD_YA_EXISTE("GC-0002", "{error.entidad.yaExiste}"),
    ENTIDAD_NO_ENCONTRADA("GC-0003", "{error.entidad.noEncontrada}"),
    VIOLACION_REGLA_DE_NEGOCIO("GC-0004", "{error.regla.negocio}"),
    CREDENCIALES_INVALIDAS("GC-0005", "{error.credenciales.invalidas}"),
    USUARIO_DESHABILITADO("GC-0006", "{error.usuario.deshabilitado}"),
    PARAMETRO_FALTANTE("GC-0007", "{error.parametro.faltante}"),
    VALIDATION_ERROR("GC-0008", "{error.validation}"),
    JSON_INVALIDO("GC-0009", "{error.json.invalido}");

    private final String codigo;
    private final String llaveMensaje;
}
