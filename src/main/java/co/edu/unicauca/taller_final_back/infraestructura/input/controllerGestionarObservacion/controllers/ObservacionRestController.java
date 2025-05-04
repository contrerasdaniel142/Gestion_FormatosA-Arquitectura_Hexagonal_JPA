package co.edu.unicauca.taller_final_back.infraestructura.input.controllerGestionarObservacion.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.taller_final_back.aplicacion.input.GestionarObservacionCUIntPort;
import co.edu.unicauca.taller_final_back.dominio.models.Observacion;
import co.edu.unicauca.taller_final_back.infraestructura.input.controllerGestionarObservacion.DTOAnswer.ObservacionDTORespuesta;
import co.edu.unicauca.taller_final_back.infraestructura.input.controllerGestionarObservacion.DTOAnswer.ObservacionesDTORespuesta;
import co.edu.unicauca.taller_final_back.infraestructura.input.controllerGestionarObservacion.DTOPetition.ObservacionDTOPeticion;
import co.edu.unicauca.taller_final_back.infraestructura.input.controllerGestionarObservacion.mappers.ObservacionMapperInfraestructuraDominio;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/observacion")
@RequiredArgsConstructor
public class ObservacionRestController {
    
    private final GestionarObservacionCUIntPort objGestionarObservacionCUInt;
    private final ObservacionMapperInfraestructuraDominio objMapper;

    @PostMapping("/formato_a/{idFormatoA}")
    public ResponseEntity<ObservacionDTORespuesta> crear(
            @RequestBody @Valid ObservacionDTOPeticion objObservacion,
            @RequestParam("idsDocentes") @NotEmpty(message = "{observacion.docentes.emply}") List<Integer> idsDocente,
            @PathVariable Integer idFormatoA) {
        
        Observacion objObservacionCrear = this.objMapper.mappearDePeticionAObservacion(objObservacion);
        ResponseEntity<ObservacionDTORespuesta> objRespuesta = new ResponseEntity<ObservacionDTORespuesta>(
                this.objMapper.mappearDeObservacionARespuesta(
                    this.objGestionarObservacionCUInt.crearObservacion(objObservacionCrear, idsDocente, idFormatoA)
                ), HttpStatus.CREATED
        );
        return objRespuesta;
    }

    @GetMapping("/formato_a/{idFormatoA}")
    public ResponseEntity<ObservacionesDTORespuesta> listarPorFormatoA(@PathVariable Integer idFormatoA) {
        ObservacionesDTORespuesta objResultado = this.objGestionarObservacionCUInt.listarObservacionesPorFormatoA(idFormatoA);
        return ResponseEntity.ok(objResultado);
    }
    
}
