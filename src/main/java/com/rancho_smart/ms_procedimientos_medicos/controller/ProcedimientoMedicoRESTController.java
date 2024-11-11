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
        return ResponseEntity.ok(listado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProcedimientoMedico> getProcedimientoMedico(@PathVariable Long id) {
        Optional<ProcedimientoMedico> procedimientoMedico = this.procedimientoMedicoService.getProcedimientoMedico(id);
        return procedimientoMedico.map(ResponseEntity::ok)
                                   .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/tratamiento/{idTratamiento}")
    public ResponseEntity<List<ProcedimientoMedico>> getProcedimientoMedicoByIdTratamiento(@PathVariable Long idTratamiento) {
        List<ProcedimientoMedico> procedimientos = this.procedimientoMedicoService.getProcedimientosMedicosByIdTratamiento(idTratamiento);
        if (procedimientos != null && !procedimientos.isEmpty()) {
            return ResponseEntity.ok(procedimientos);
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/historial/{idHistorialMedico}")
    public ResponseEntity<List<ProcedimientoMedico>> getProcedimientoMedicoByIdHistorial(@PathVariable Long idHistorialMedico) {
        List<ProcedimientoMedico> procedimientos = this.procedimientoMedicoService.getProcedimientosMedicosByIdHistorial(idHistorialMedico);
        if (procedimientos != null && !procedimientos.isEmpty()) {
            return ResponseEntity.ok(procedimientos);
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<ProcedimientoMedico> saveProcedimientoMedico(@RequestBody ProcedimientoMedico procedimientoMedico) {
        ProcedimientoMedico procedimientoMedicoCreado = this.procedimientoMedicoService.saveProcedimientoMedico(procedimientoMedico);
        return ResponseEntity.status(HttpStatus.CREATED).body(procedimientoMedicoCreado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProcedimientoMedico> updateProcedimientoMedico(@PathVariable Long id, @RequestBody ProcedimientoMedico procedimientoMedico) {
        Optional<ProcedimientoMedico> existingProcedimiento = this.procedimientoMedicoService.getProcedimientoMedico(id);
        if (!existingProcedimiento.isPresent()) {
            return ResponseEntity.notFound().build();
        } else {
            procedimientoMedico.setIdProcedimientoMedico(id);
            ProcedimientoMedico procedimientoMedicoActualizado = this.procedimientoMedicoService.saveProcedimientoMedico(procedimientoMedico);
            return ResponseEntity.ok(procedimientoMedicoActualizado);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProcedimientoMedico(@PathVariable Long id) {
        if (!this.procedimientoMedicoService.getProcedimientoMedico(id).isPresent()) {
            return ResponseEntity.notFound().build();
        } else {
            this.procedimientoMedicoService.deleteProcedimientoMedico(id);
            return ResponseEntity.noContent().build();
        }
    }
}
