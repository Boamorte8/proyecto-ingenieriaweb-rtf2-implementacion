/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.prestamos.dao;

import com.prestamos.dto.TipoUsuario;
import com.prestamos.exception.DaoException;
import java.util.List;

/**
 * Interface que define todos los metodos que provee el tipousuario
 * @author Juan Carlos
 */
public interface TipoUsuarioDao {
    
    /**
     * Inserta un nuevo tipoUsuario a la base de datos
     * @param tipoUsuario es el nuevo tipoUsuario que se va a insertar
     * @throws DaoException 
     */
    public void insertar(TipoUsuario tipoUsuario) throws DaoException;
    
    /**
     * Busca un TipoUsuario en la base de datos 
     * @param codigo es el codigo del TipoUsuario que se esta buscando
     * @return una instancia del TipoUsuario que se esta buscando
     * @throws DaoException 
     */
    public TipoUsuario buscar(int codigo) throws DaoException;
    
    /**
     * Actualiza la informacion de un tipoUsuario existente en la base de datos
     * @param tipoUsuario es el tipoUsuario al que se le actualiza los datos
     * @throws DaoException 
     */
    public void actualizar(TipoUsuario tipoUsuario) throws DaoException;
    
    /**
     * Eliminar un tipoUsuario de la base de datos
     * @param tipoUsuario es el tipoUsuario que se elimina de la base de datos
     * @throws DaoException 
     */
    public void eliminar(TipoUsuario tipoUsuario) throws DaoException;
    
    /**
     * Lista todos los tipoUsuario que existen en la base de datos
     * @return una lista con todos los tipoUsuario de la base de datos
     * @throws DaoException 
     */
    public List<TipoUsuario> listar() throws DaoException;
}
