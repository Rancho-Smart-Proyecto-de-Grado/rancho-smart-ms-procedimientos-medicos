package com.rancho_smart.ms_procedimientos_medicos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.rancho_smart.ms_procedimientos_medicos.entity.ProcedimientoMedico;

@Repository
public interface ProcedimientoMedicoRepository extends JpaRepository<ProcedimientoMedico, Long>{
    public List<ProcedimientoMedico> findByIdTratamiento(Long idTratamiento);
    public List<ProcedimientoMedico> findByIdHistorialMedico(Long idHistorialMedico);
}
