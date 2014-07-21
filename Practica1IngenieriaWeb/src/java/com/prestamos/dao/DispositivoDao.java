/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.prestamos.dao;

import com.prestamos.dto.Dispositivo;
import com.prestamos.exception.DaoException;
import java.util.List;

/**
 * Interface que define los metodos que va a proveer el dao de Dispositivo
 * @author Juan Carlos
 */
public interface DispositivoDao {
    
    /** Inserta en la base de datos un dispositivo
     *  @param dispositivo el dispositivo a insertar
     *  @throws DAoException
     */
    public void insertar(Dispositivo dispositivo) throws DaoException;
    
    /**
     * Busca en la lista de dispositivos un dispositivo en especifico segun el codigo
     * @param codigo es el codigo del dispositivo que se va a buscar
     * @return una instancia del dispotivo buscado
     * @throws DaoException 
     */
    public Dispositivo buscar(long codigo) throws DaoException;
    
    /**
     * Actualiza un dispositivo elegido
     * @param dispositivo es el dispositivo que se va a actualizar
     * @throws DaoException 
     */
    public void actualizar(Dispositivo dispositivo) throws DaoException;
    
    /**
     * Elimina de la lista de dispositivos en la base de datos el dispositivo 
     * que se pasa como parametro
     * @param dispositivo es el dispositivo que se va a eliminar
     * @throws DaoException 
     */
    public void eliminar(Dispositivo dispositivo) throws DaoException;
    
    /**
     * Lista todos los dispositivos que se encuentran en la base de datos
     * @return una lista de dispositivos con todos los dispositivos 
     * @throws DaoException 
     */
    public List<Dispositivo> listar() throws DaoException;
}
