package com.prestamos.dto;
// Generated 17/07/2014 03:01:05 PM by Hibernate Tools 3.6.0


import java.util.Date;

/**
 * Prestamo generated by hbm2java
 */
public class Prestamo  implements java.io.Serializable {


    /**
     * Consecutivo para identificar el préstamo
     */
     private Long consecutivo;
     /**
      * Dispositivo a prestar
      */
     private Dispositivo dispositivo;
     /**
      * Fecha de inicio del prestamo
      */
     private Date fechaInicio;
     /**
      * Fecha final del prestamo
      */
     private Date fechaFin;
     /**
      * Estado del prestamo
      */
     private String estado;
     /**
      * Estado inicial del dispositivo
      */
     private String estadoInicialDispositivo;
     /**
      * Estado final del dispositivo
      */
     private String estadoFinalDispositivo;
     /**
      * Investigador que solicita el préstamo
      */
     private Usuario investigador;
     /**
      * Encargado del prestamo
      */
     private Usuario encargado;

     
     //Constructores
    public Prestamo() {
    }

    public Prestamo(Dispositivo dispositivo, Date fechaInicio, Date fechaFin, String estado, String estadoInicialDispositivo, String estadoFinalDispositivo, Usuario Investigador, Usuario Encargado) {
        this.dispositivo = dispositivo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
        this.estadoInicialDispositivo = estadoInicialDispositivo;
        this.estadoFinalDispositivo = estadoFinalDispositivo;
        this.investigador = Investigador;
        this.encargado = Encargado;
    }

    //Setters and getters
    public Long getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(Long consecutivo) {
        this.consecutivo = consecutivo;
    }

    public Dispositivo getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(Dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstadoInicialDispositivo() {
        return estadoInicialDispositivo;
    }

    public void setEstadoInicialDispositivo(String estadoInicialDispositivo) {
        this.estadoInicialDispositivo = estadoInicialDispositivo;
    }

    public String getEstadoFinalDispositivo() {
        return estadoFinalDispositivo;
    }

    public void setEstadoFinalDispositivo(String estadoFinalDispositivo) {
        this.estadoFinalDispositivo = estadoFinalDispositivo;
    }

    public Usuario getInvestigador() {
        return investigador;
    }

    public void setInvestigador(Usuario Investigador) {
        this.investigador = Investigador;
    }

    public Usuario getEncargado() {
        return encargado;
    }

    public void setEncargado(Usuario Encargado) {
        this.encargado = Encargado;
    }

    
}