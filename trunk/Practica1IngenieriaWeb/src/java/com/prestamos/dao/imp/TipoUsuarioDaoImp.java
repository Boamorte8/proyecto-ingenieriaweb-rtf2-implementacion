/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.prestamos.dao.imp;

import com.prestamos.dao.TipoUsuarioDao;
import com.prestamos.dto.TipoUsuario;
import com.prestamos.exception.DaoException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Clase que implementa los metodos del dao de TipoUsuario
 * @author Juan Carlos
 */
public class TipoUsuarioDaoImp implements TipoUsuarioDao{
    
    private SessionFactory sessionFactory;

    /**
     * Inyecta la sesion
     * @param sessionFactory 
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * Implementa el metodo para insertar
     * @param tipoUsuario es el tipoUsuario a insertar
     * @throws DaoException 
     */
    @Override
    public void insertar(TipoUsuario tipoUsuario) throws DaoException {
        Session session = null;
        Transaction transaction = null;
        try {   //Inicia sesion, inserta y hace commit
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(tipoUsuario);
            transaction.commit();//EXITO
        } catch (HibernateException e) { //Hace rollback si hay algun error
            if(transaction != null){
                transaction.rollback();//ERROR 
            }
            throw new DaoException(e);
        } finally{  //Cierra sesion
            if(session != null){
                session.close();
            }
        }    
    }

    /**
     * Implementacion del metodo para buscar un tipoUsuario
     * @param codigo es el codigo del tipoUsuario que se va a buscar
     * @return una instancia del tipoUsuario que se esta buscando
     * @throws DaoException 
     */
    @Override
    public TipoUsuario buscar(int codigo) throws DaoException {
        Session session = null;
        TipoUsuario tipoUsuario = null;
        try {  //Inicia sesion y busca
            session = sessionFactory.openSession();
            tipoUsuario = (TipoUsuario)session.get(TipoUsuario.class, codigo);
        } catch (ExceptionInInitializerError e) {  //Lanza una exception cuando hay error
            throw new DaoException(e);
        } finally{  //Cierra sesion
            if(session != null){
                session.close();
            }
        }
        return tipoUsuario;   //Retorna el tipoUsuario buscado 
    }

    /**
     * Implementacion del metodo para actualizar un tipoUsuario
     * @param tipoUsuario es el tipoUsuario que se va a actualizar
     * @throws DaoException 
     */
    @Override
    public void actualizar(TipoUsuario tipoUsuario) throws DaoException {
        Session session = null;
        Transaction transaction = null;
        try {   //Inicia sesion, actualiza y hace commit
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(tipoUsuario);
            transaction.commit();//EXITO
        } catch (HibernateException e) {  //Cuando hay error se hace rollback
            if(transaction != null){
                transaction.rollback();//ERROR 
            }
            throw new DaoException(e);
        } finally{   //Finaliza la sesion
            if(session != null){
                session.close();
            }
        }
    }

    /**
     * Implementa el metodo eliminar un tipousuario
     * @param tipoUsuario es el tipousuario que se elimina
     * @throws DaoException 
     */
    @Override
    public void eliminar(TipoUsuario tipoUsuario) throws DaoException {
        Session session = null;
        Transaction transaction = null;
        try { //Inicia la sesion, elimina y hace commit
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(tipoUsuario);
            transaction.commit();//EXITO
        } catch (HibernateException e) {   //Cuando hay error hace rollback
            if(transaction != null){
                transaction.rollback();//ERROR 
            }
            throw new DaoException(e);
        } finally{   //Cierra la sesion.
            if(session != null){
                session.close();
            }
        }    
    }

    /**
     * Implementa el metodo listar los tipos de usuarios existentes
     * @return una lista con todos los tipos de usuarios
     * @throws DaoException 
     */
    @Override
    public List<TipoUsuario> listar() throws DaoException {
        Session session = null;
        List<TipoUsuario> tipoDispositivos = new ArrayList<>();
        try {   // Inicia la sesion y lista todos los tipoUsuario
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(TipoUsuario.class);
            tipoDispositivos = criteria.list();
        } catch (ExceptionInInitializerError e) {  
            throw new DaoException(e); //Lanza una exception cuando hay error
        } finally{   //Cierra la sesion
            if(session != null){
                session.close();
            }
        }
        return tipoDispositivos;  //retorna una lista con todos los tipoDispositivos existentes  
    }
    
}
