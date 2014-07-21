/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.prestamos.dao.imp;

import com.prestamos.dao.TipoDispositivoDao;
import com.prestamos.dto.TipoDispositivo;
import com.prestamos.exception.DaoException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Clase que implementa los metodos de el dao tipo de dispositivos
 * @author Juan Carlos
 */
public class TipoDispositivoDaoImp implements TipoDispositivoDao{
    
    private SessionFactory sessionFactory;

    /**
     * Inyecta la sesion
     * @param sessionFactory 
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * Implementa el metodo insertar
     * @param tipoDispositivo es el tipoDispositivo que se va a insertar
     * @throws DaoException 
     */
    @Override
    public void insertar(TipoDispositivo tipoDispositivo) throws DaoException {
        Session session = null;
        Transaction transaction = null;
        try {  //Se incia sesion, se inserta y se hace commit
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(tipoDispositivo);
            transaction.commit();//EXITO
        } catch (HibernateException e) { //Si hay error se hace rollback
            if(transaction != null){
                transaction.rollback();//ERROR 
            }
            throw new DaoException(e);
        } finally{  //Se finaliza la sesion
            if(session != null){
                session.close();
            }
        }    
    }

    /**
     * Implementa el metodo buscar tipodispositivo
     * @param codigo es el codigo del tipodispositivo que se va a buscar
     * @return retorna una instancia del metodo dispositivo a buscar
     * @throws DaoException 
     */
    @Override
    public TipoDispositivo buscar(int codigo) throws DaoException {
        Session session = null;
        TipoDispositivo tipoDispositivo = null;
        try { //Se inicia la sesion y se busca el dispositivo
            session = sessionFactory.openSession();
            tipoDispositivo = (TipoDispositivo)session.get(TipoDispositivo.class, codigo);
        } catch (ExceptionInInitializerError e) { //Se lanza exception si hay errores
            throw new DaoException(e);
        } finally{   //Se cierra la sesion.
            if(session != null){
                session.close();
            }
        }
        return tipoDispositivo;  //Se retorna el dispositivo buscado   
    }

    /**
     * Implementa el metodo actualizar tipo dispositivo
     * @param tipoDispositivo es el tipo dispositivo que se va a actualizar
     * @throws DaoException 
     */
    @Override
    public void actualizar(TipoDispositivo tipoDispositivo) throws DaoException {
        Session session = null;
        Transaction transaction = null;
        try {   //Inicia la sesion, actualiza y hace commit
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(tipoDispositivo);
            transaction.commit();//EXITO
        } catch (HibernateException e) {  //Si hay error hace rollback
            if(transaction != null){
                transaction.rollback();//ERROR 
            }
            throw new DaoException(e);
        } finally{ //Cierra la sesion
            if(session != null){
                session.close();
            }
        }
    }

    /**
     * Implementa el metodo eliminar
     * @param tipoDispositivo es el tipoDispositivo que se va a eliminar
     * @throws DaoException 
     */
    @Override
    public void eliminar(TipoDispositivo tipoDispositivo) throws DaoException {
        Session session = null;
        Transaction transaction = null;
        try {  //Inicia la sesion, elimina y hace commit
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(tipoDispositivo);
            transaction.commit();//EXITO
        } catch (HibernateException e) {  //SI hay error hace rollback
            if(transaction != null){
                transaction.rollback();//ERROR 
            }
            throw new DaoException(e); 
        } finally{  //Cierra la sesion
            if(session != null){
                session.close();
            }
        }    
    }

    /**
     * Implementa el metodo listar
     * @return una instancia de una lista de tipoDispositivos 
     * @throws DaoException 
     */
    @Override
    public List<TipoDispositivo> listar() throws DaoException {
        Session session = null;
        List<TipoDispositivo> tipoDispositivos = new ArrayList<>();
        try {  //Inicia la sesion y lista todos los dispositivos existentes
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(TipoDispositivo.class);
            tipoDispositivos = criteria.list();
        } catch (ExceptionInInitializerError e) {  //Lanza una exception si hay error
            throw new DaoException(e);
        } finally{  // Cierra la sesion
            if(session != null){
                session.close();
            }
        }
        return tipoDispositivos;   // Retorna una lista de tipoDispositivos 
    }
    
}
