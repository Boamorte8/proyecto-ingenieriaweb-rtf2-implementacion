package com.prestamos.dto;
// Generated 17/07/2014 03:01:05 PM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Dispositivo generated by hbm2java
 */
public class Dispositivo  implements java.io.Serializable {

    /**
     * Código que identifica el dispositivo
     */
     private Long codigo;
     /**
      * Tipo de dispositivo
      */
     private TipoDispositivo tipoDispositivo;
     /**
      * Descripción del dispositivo
      */
     private String descripcion;
     /**
      * Estado en que se encuentra el dispositivo en el sistema
      */
     private String estado;
     /**
      * 
      */
     private Set prestamos = new HashSet(0);

     //Constructores
    
    public Dispositivo() {
    }

	
    public Dispositivo(TipoDispositivo tipoDispositivo, String descripcion, String estado) {
        this.tipoDispositivo = tipoDispositivo;
        this.descripcion = descripcion;
        this.estado = estado;
    }
    public Dispositivo(TipoDispositivo tipoDispositivo, String descripcion, String estado, Set prestamos) {
       this.tipoDispositivo = tipoDispositivo;
       this.descripcion = descripcion;
       this.estado = estado;
       this.prestamos = prestamos;
    }
   
    
    //Setters and getters
    
    public Long getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }
    public TipoDispositivo getTipoDispositivo() {
        return this.tipoDispositivo;
    }
    
    public void setTipoDispositivo(TipoDispositivo tipoDispositivo) {
        this.tipoDispositivo = tipoDispositivo;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public Set getPrestamos() {
        return this.prestamos;
    }
    
    public void setPrestamos(Set prestamos) {
        this.prestamos = prestamos;
    }




}

