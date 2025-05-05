package co.edu.unicauca.taller_final_back.infraestructura.input.controllerGestionarFormatoA.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.taller_final_back.aplicacion.input.GestionarFormatoACUIntPort;
import co.edu.unicauca.taller_final_back.dominio.models.FormatoA;
import co.edu.unicauca.taller_final_back.dominio.models.RangoFechas;
import co.edu.unicauca.taller_final_back.infraestructura.input.controllerGestionarFormatoA.DTOAnswer.FormatoADTORespuesta;
import co.edu.unicauca.taller_final_back.infraestructura.input.controllerGestionarFormatoA.DTOAnswer.InformacionFormatoARespuesta;
import co.edu.unicauca.taller_final_back.infraestructura.input.controllerGestionarFormatoA.DTOPetition.FormatoADTOPeticion;
import co.edu.unicauca.taller_final_back.infraestructura.input.controllerGestionarFormatoA.DTOPetition.RangoFechasDTOPeticion;
import co.edu.unicauca.taller_final_back.infraestructura.input.controllerGestionarFormatoA.mappers.FormatoAMapperInfraestructuraDominio;
import co.edu.unicauca.taller_final_back.infraestructura.input.controllerGestionarObservacion.DTOAnswer.ObservacionesDTORespuesta;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/formato_a")
@RequiredArgsConstructor
public class FormatoARestController {
    private final GestionarFormatoACUIntPort objGestionarFormatoACUInt;
    private final FormatoAMapperInfraestructuraDominio objMapperFormatoA;

    @PostMapping("/docente/{idDocente}")
    public ResponseEntity<FormatoADTORespuesta> crear(
        @RequestBody @Valid FormatoADTOPeticion objFormatoA, @PathVariable Integer idDocente) {

        FormatoA objFormatoACrear = this.objMapperFormatoA.mappearDePeticionAFormatoA(objFormatoA);
        FormatoA objFormatoACreado = this.objGestionarFormatoACUInt.crearFormatoA(objFormatoACrear, idDocente);

        FormatoADTORespuesta objFormatoARespuesta = this.objMapperFormatoA.mappearDeFormatoPPARespuesta(objFormatoACreado);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(objFormatoARespuesta);
    }
    
    @GetMapping("/docente")
    public ResponseEntity<List<ObservacionesDTORespuesta>> listarPorDocente(
        @RequestParam @Email(message = "{email.invalido}") @NotBlank(message = "{email.emply}") String correoDocente) {
        
        List<ObservacionesDTORespuesta> listaRespuesta = this.objGestionarFormatoACUInt.listarFormatosAPorDocente(correoDocente);
        return ResponseEntity.ok(listaRespuesta);
    }

    @GetMapping("/docente/{idDocente}/rango")
    public ResponseEntity<List<InformacionFormatoARespuesta>> listarPorDocenteEnRangoDeFechas(
        @PathVariable Integer idDocente, @RequestBody @Valid RangoFechasDTOPeticion rangoFechas) {
        
        RangoFechas objRangoABuscar = this.objMapperFormatoA.mappearDePeticionARangoFechas(rangoFechas);
        List<InformacionFormatoARespuesta> objRespuesta = this.objGestionarFormatoACUInt.listarFormatosAConObservacionesPorDocenteEntreFechas(idDocente, objRangoABuscar);
        return ResponseEntity.ok(objRespuesta);
    }
}
