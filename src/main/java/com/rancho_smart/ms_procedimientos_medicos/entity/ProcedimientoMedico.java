package com.rancho_smart.ms_procedimientos_medicos.entity;

import java.time.LocalDateTime;

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
    
    @Column(name = "FECHA")
    private LocalDateTime fecha;

    @Column(name = "RESULTADOS")
    private String resultados;

    @Column(name = "RECOMENDACIONES")
    private String recomendaciones;

    @Column(name = "TITULO")
    private String titulo;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    public ProcedimientoMedico() {
    }

    public ProcedimientoMedico(Long idHistorialMedico, Long idTratamiento, LocalDateTime fecha, String resultados,
            String recomendaciones, String titulo, String descripcion) {
        this.idHistorialMedico = idHistorialMedico;
        this.idTratamiento = idTratamiento;
        this.fecha = fecha;
        this.resultados = resultados;
        this.recomendaciones = recomendaciones;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public Long getIdProcedimientoMedico() {
        return idProcedimientoMedico;
    }

    public void setIdProcedimientoMedico(Long idProcedimientoMedico) {
        this.idProcedimientoMedico = idProcedimientoMedico;
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

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getResultados() {
        return resultados;
    }

    public void setResultados(String resultados) {
        this.resultados = resultados;
    }

    public String getRecomendaciones() {
        return recomendaciones;
    }

    public void setRecomendaciones(String recomendaciones) {
        this.recomendaciones = recomendaciones;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
}


