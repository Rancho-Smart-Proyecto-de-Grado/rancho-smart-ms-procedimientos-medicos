package com.rancho_smart.ms_procedimientos_medicos.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rancho_smart.ms_procedimientos_medicos.entity.ProcedimientoMedico;
import com.rancho_smart.ms_procedimientos_medicos.repository.ProcedimientoMedicoRepository;

@Service
public class ProcedimientoMedicoService {

    @Autowired
    private ProcedimientoMedicoRepository procedimientoMedicoRepository;

    public List<ProcedimientoMedico> getProcedimientosMedicos() {
        return this.procedimientoMedicoRepository.findAll();
    }

    public List<ProcedimientoMedico> getProcedimientosMedicosByIdTratamiento(Long idTratamiento) {
        List<ProcedimientoMedico> procedimientosTratamiento = this.procedimientoMedicoRepository
                .findByIdTratamiento(idTratamiento);
        return procedimientosTratamiento;
    }

    public List<ProcedimientoMedico> getProcedimientosMedicosByIdHistorial(Long idHistorialMedico) {
        List<ProcedimientoMedico> procedimientosHistorial = this.procedimientoMedicoRepository
                .findByIdHistorialMedico(idHistorialMedico);
        return procedimientosHistorial.stream()
                .filter(procedimiento -> procedimiento.getIdTratamiento() == null)
                .collect(Collectors.toList());
    }

    public Optional<ProcedimientoMedico> getProcedimientoMedico(Long id) {
        return this.procedimientoMedicoRepository.findById(id);
    }

    public ProcedimientoMedico saveProcedimientoMedico(ProcedimientoMedico procedimientoMedico) {
        return this.procedimientoMedicoRepository.save(procedimientoMedico);
    }

    public void deleteProcedimientoMedico(Long id) {
        this.procedimientoMedicoRepository.deleteById(id);
    }
}
