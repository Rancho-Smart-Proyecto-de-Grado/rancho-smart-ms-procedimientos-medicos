package com.rancho_smart.ms_procedimientos_medicos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rancho_smart.ms_procedimientos_medicos.entity.ProcedimientoMedico;

@Repository
public interface ProcedimientoMedicoRepository extends JpaRepository<ProcedimientoMedico, Long>{
    
    @Query("SELECT pm FROM PROCEDIMIENTO_MEDICO pm WHERE pm.idHistorialMedico = :idHistorialMedico AND pm.idTratamiento IS NULL")
    List<ProcedimientoMedico> findByIdHistorialMedico(@Param("idHistorialMedico") Long idHistorialMedico);

    @Query("SELECT pm FROM PROCEDIMIENTO_MEDICO pm WHERE pm.idHistorialMedico = :idHistorialMedico AND pm.idTratamiento IS NOT NULL")
    List<ProcedimientoMedico> findByIdHistorialMedicoAndTratamiento(@Param("idHistorialMedico") Long idHistorialMedico);
}
