package com.rancho_smart.ms_procedimientos_medicos.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PROCEDIMIENTO_MEDICO")
public class ProcedimientoMedico {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProcedimientoMedico;

    @Column(name = "ID_HISTORIAL_MEDICO", nullable = false)
    private Long idHistorialMedico;

    @Column(name = "ID_TRATAMIENTO")
    private Long idTratamiento;
    
    @Column(name = "TITULO")
    private String titulo;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    public ProcedimientoMedico() {
    }

        public ProcedimientoMedico(Long idHistorialMedico, Long idTratamiento, String titulo, String descripcion) {
        this.idHistorialMedico = idHistorialMedico;
        this.idTratamiento = idTratamiento;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public Long getIdProcedimientoMedico() {
        return idProcedimientoMedico;
    }

    public void setIdProcedimientoMedico(Long idProcedimientoMedico) {
        this.idProcedimientoMedico = idProcedimientoMedico;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Long getIdHistorialMedico() {
        return idHistorialMedico;
    }

    public void setIdHistorialMedico(Long idHistorialMedico) {
        this.idHistorialMedico = idHistorialMedico;
    }

    public Long getIdTratamiento() {
        return idTratamiento;
    }

    public void setIdTratamiento(Long idTratamiento) {
        this.idTratamiento = idTratamiento;
    }
}


