package co.edu.unicauca.taller_final_back.infraestructura.input.controllerGestionarEstado.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import co.edu.unicauca.taller_final_back.aplicacion.input.GestionarEstadoCUIntPort;
import co.edu.unicauca.taller_final_back.infraestructura.input.controllerGestionarEstado.DTOAnswer.EstadoDTORespuesta;
import co.edu.unicauca.taller_final_back.infraestructura.input.controllerGestionarEstado.mappers.EstadoMapperInfraestructuraDominio;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/estado/formato_a")
@RequiredArgsConstructor
@Validated
public class EstadoRestController {

    private final GestionarEstadoCUIntPort objGestionarEstadoCUInt;
    private final EstadoMapperInfraestructuraDominio objMapper;

    @PostMapping("/enviar_para_evaluacion/{idFormatoA}")
    public ResponseEntity<EstadoDTORespuesta> enviarParaEvaluacion(
            @PathVariable Integer idFormatoA) {
        
        ResponseEntity<EstadoDTORespuesta> objRespuesta = new ResponseEntity<EstadoDTORespuesta>(
                this.objMapper.mappearDeEstadoARespuesta(
                    this.objGestionarEstadoCUInt.enviarParaEvaluacion(idFormatoA)
                ), HttpStatus.OK
        );
        return objRespuesta;
    }

    @PostMapping("/aprobar/{idFormatoA}")
    public ResponseEntity<EstadoDTORespuesta> aprobar(
            @PathVariable Integer idFormatoA) {

        ResponseEntity<EstadoDTORespuesta> objRespuesta = new ResponseEntity<EstadoDTORespuesta>(
                this.objMapper.mappearDeEstadoARespuesta(
                    this.objGestionarEstadoCUInt.aprobar(idFormatoA)
                ), HttpStatus.OK
        );
        return objRespuesta;
    }

    @PostMapping("/rechazar/{idFormatoA}")
    public ResponseEntity<EstadoDTORespuesta> rechazar(
            @PathVariable Integer idFormatoA) {

        ResponseEntity<EstadoDTORespuesta> objRespuesta = new ResponseEntity<EstadoDTORespuesta>(
                this.objMapper.mappearDeEstadoARespuesta(
                    this.objGestionarEstadoCUInt.rechazar(idFormatoA)
                ), HttpStatus.OK
        );
        return objRespuesta;
    }
}
