package com.rancho_smart.ms_procedimientos_medicos.service;

import java.util.List;
import java.util.Optional;

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
    
    public List<ProcedimientoMedico> getProcedimientosMedicosByHistorialMedico(Long idHistorialMedico){
        return this.getProcedimientosMedicosByHistorialMedico(idHistorialMedico);
    }

    public List<ProcedimientoMedico> getProcedimientosMedicosByTratamiento(Long idTratamiento){
        return this.procedimientoMedicoRepository.findByIdHistorialMedicoAndTratamiento(idTratamiento);
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
