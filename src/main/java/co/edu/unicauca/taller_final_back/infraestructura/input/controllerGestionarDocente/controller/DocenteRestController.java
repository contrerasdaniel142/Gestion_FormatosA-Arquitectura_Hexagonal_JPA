package co.edu.unicauca.taller_final_back.infraestructura.input.controllerGestionarDocente.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.taller_final_back.aplicacion.input.GestionarDocenteCUIntPort;
import co.edu.unicauca.taller_final_back.infraestructura.input.controllerGestionarDocente.DTOAnswer.DocenteDTORespuesta;
import co.edu.unicauca.taller_final_back.infraestructura.input.controllerGestionarDocente.DTOAnswer.DocenteRolDTORespuesta;
import co.edu.unicauca.taller_final_back.infraestructura.input.controllerGestionarDocente.mapper.DocenteMapperInfraestructuraDominio;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/docente")
@RequiredArgsConstructor
public class DocenteRestController {
    
    private final GestionarDocenteCUIntPort objGestionarDocenteCUInt;
    private final DocenteMapperInfraestructuraDominio objMapper;

    @GetMapping("/listar/comite")
    public ResponseEntity<List<DocenteRolDTORespuesta>> listarComite() {
        ResponseEntity<List<DocenteRolDTORespuesta>> objRespuesta = new ResponseEntity<List<DocenteRolDTORespuesta>>(
                this.objMapper.mappearListaDeDocenteRolARespuesta(this.objGestionarDocenteCUInt.listarPorRolComite()),
                HttpStatus.OK
        );
        return objRespuesta;
    }

    @GetMapping("/listar/grupo")
    public ResponseEntity<List<DocenteDTORespuesta>> listarPorGrupoYPatron(
            @RequestParam @NotBlank(message = "{listar.docentes.grupo.emply}") String grupo,
            @RequestParam @NotBlank(message = "{listar.docentes.patron.emply}") String patron) {

        ResponseEntity<List<DocenteDTORespuesta>> objRespuesta = new ResponseEntity<>(
                this.objMapper.mappearListaDeDocenteARespuesta(
                    this.objGestionarDocenteCUInt.listarPorGrupoYPatron(grupo, patron)
                ), HttpStatus.OK
        );

        return objRespuesta;
    }
    
}
