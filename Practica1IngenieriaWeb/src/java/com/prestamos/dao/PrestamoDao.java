/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.prestamos.dao;

import com.prestamos.dto.Dispositivo;
import com.prestamos.dto.Prestamo;
import com.prestamos.dto.UsuarioId;
import com.prestamos.exception.DaoException;
import java.util.Date;
import java.util.List;

/**
 * Interface que define los metodos que va a proveer el dao de Prestamo
 * @author Juan Carlos
 */
public interface PrestamoDao {
    
    /**
     * Lista todos los dispositivos que estan disponibles en la fecha dada
     * @param fecha fecha con que se busca los dispositivos disponibles
     * @return una lista con los dispositivos disponibles la fecha entregada
     * @throws DaoException 
     */
    public List<Dispositivo> listarDispositivosDisponibles(Date fecha) throws DaoException;
    
    /**
     * Crea un nuevo prestamo en la base de datos y lo pone en estado de 
     * solicitado y esperando aprobacion
     * @param prestamo Es el nuevo prestamos que se creo y que solicita el dispositivo
     * @throws DaoException 
     */
    public void solicitarPrestamo(Prestamo prestamo) throws DaoException;
    
    /**
     * Actualiza los datos de un prestamo
     * @param prestamo es el prestamo que se va a actualizar
     * @throws DaoException 
     */
    public void actualizar(Prestamo prestamo) throws DaoException;
    
    /**
     * Consulta los prestamos realizados por un investigador
     * @param id Es la identificacion del investigador que se quiere consultar
     * @return una lista con todos los prestamos realizados por el investigador
     * @throws DaoException 
     */
    public List<Prestamo> consultarPrestamosInvestigador(UsuarioId id) throws DaoException;
    
    /**
     * Consulta todos los prestamos que se han aprobado y no se han devuelto
     * @return una lista con todos los prestamos que estan activos
     * @throws DaoException 
     */
    public List<Prestamo> consultarPrestamosActivos() throws DaoException;
}
