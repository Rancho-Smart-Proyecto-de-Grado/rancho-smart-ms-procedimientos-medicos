package com.rancho_smart.ms_procedimientos_medicos.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rancho_smart.ms_procedimientos_medicos.entity.ProcedimientoMedico;
import com.rancho_smart.ms_procedimientos_medicos.service.ProcedimientoMedicoService;

@RestController
@RequestMapping("/procedimientos-medicos")
public class ProcedimientoMedicoRESTController {

    @Autowired
    private ProcedimientoMedicoService procedimientoMedicoService;

    @GetMapping
    public ResponseEntity<List<ProcedimientoMedico>> getProcedimientosMedicos() {
        List<ProcedimientoMedico> listado = this.procedimientoMedicoService.getProcedimientosMedicos();
        return new ResponseEntity<>(listado, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ProcedimientoMedico> getProcedimientoMedico(@PathVariable Long id) {
        Optional<ProcedimientoMedico> procedimientoMedico = this.procedimientoMedicoService.getProcedimientoMedico(id);
        return procedimientoMedico.map(ResponseEntity::ok)
                                   .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<ProcedimientoMedico> saveProcedimientoMedico(@RequestBody ProcedimientoMedico procedimientoMedico) {
        ProcedimientoMedico procedimientoMedicoCreado = this.procedimientoMedicoService.saveProcedimientoMedico(procedimientoMedico);
        return new ResponseEntity<>(procedimientoMedicoCreado, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ProcedimientoMedico> updateProcedimientoMedico(@PathVariable Long id, @RequestBody ProcedimientoMedico procedimientoMedico) {
        if (!this.procedimientoMedicoService.getProcedimientoMedico(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            procedimientoMedico.setIdProcedimientoMedico(id);
            ProcedimientoMedico procedimientoMedicoActualizado = this.procedimientoMedicoService.saveProcedimientoMedico(procedimientoMedico);
            return new ResponseEntity<>(procedimientoMedicoActualizado, HttpStatus.OK);
        }
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteProcedimientoMedico(@PathVariable Long id) {
        if (!this.procedimientoMedicoService.getProcedimientoMedico(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            this.procedimientoMedicoService.deleteProcedimientoMedico(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
