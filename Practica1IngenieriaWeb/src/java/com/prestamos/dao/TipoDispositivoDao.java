/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.prestamos.dao;

import com.prestamos.dto.TipoDispositivo;
import com.prestamos.exception.DaoException;
import java.util.List;

/**
 * Interface que define los metodos que provee el dao de TipoDispositivo
 * @author Juan Carlos
 */
public interface TipoDispositivoDao {
    
    /**
     * Inserta un nuevo tipo de dispositivo en la base de datos
     * @param tipoDispositivo es el nuevo tipo de dispositivo a insertar
     * @throws DaoException 
     */
    public void insertar(TipoDispositivo tipoDispositivo) throws DaoException;
    
    /**
     * Busca un dispositivo en la base de datos segun su codigo
     * @param codigo  Es el codigo del dispositivo que se esta buscando
     * @return una instancia del dispositivo que se esta buscando
     * @throws DaoException 
     */
    public TipoDispositivo buscar(int codigo) throws DaoException;
    
    /**
     * Actualiza la informacion de un tipoDispositivo
     * @param tipoDispositivo es el tipoDispositivo al cual se le va a actualizar
     * la informacion
     * @throws DaoException 
     */
    public void actualizar(TipoDispositivo tipoDispositivo) throws DaoException;
    
    /**
     * Eliminar de la base de datos el tipoDispositivo que se esta buscando
     * @param tipoDispositivo es el tipoDispositivo que se va a eliminar
     * @throws DaoException 
     */
    public void eliminar(TipoDispositivo tipoDispositivo) throws DaoException;
    
    /**
     * Lista todos los tipoDispositivos que se encuentran en la base de datos
     * @return una lista con todos los tipos de dispositivos
     * @throws DaoException 
     */
    public List<TipoDispositivo> listar() throws DaoException;
}
