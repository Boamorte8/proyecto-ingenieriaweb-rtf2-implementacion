/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.prestamos.dao;

import com.prestamos.dto.Usuario;
import com.prestamos.dto.UsuarioId;
import com.prestamos.exception.DaoException;
import java.util.List;

/**
 * Interface que define los metodos que provee el dao de Usuario
 * @author Juan Carlos
 */
public interface UsuarioDao {
    
    /**
     * Inserta un nuevo usuario en la bases de datos
     * @param usuario son los datos del nuevo usuario que se ingresa
     * @throws DaoException 
     */
    public void insertar(Usuario usuario) throws DaoException;
    
    /**
     * Busca un usuario de la base de datos segun su id
     * @param id es el id del usuario que se busca
     * @return una instancia del usuario que se busca
     * @throws DaoException 
     */
    public Usuario buscar(UsuarioId id) throws DaoException;
    
    /**
     * Actualiza los datos de un usuario de la base de datos
     * @param usuario es el usuario al que se actualizan los datos
     * @throws DaoException 
     */
    public void actualizar(Usuario usuario) throws DaoException;
    
    /**
     * Elimina un usuario de la base de datos
     * @param usuario es el usuario que se elimina de la base de datos
     * @throws DaoException 
     */
    public void eliminar(Usuario usuario) throws DaoException;
    
    /**
     * Lista todos los usuarios que se encuentran en la base de datos
     * @return una lista con todos los usuarios que existen en la base de datos
     * @throws DaoException 
     */
    public List<Usuario> listar() throws DaoException;
}

