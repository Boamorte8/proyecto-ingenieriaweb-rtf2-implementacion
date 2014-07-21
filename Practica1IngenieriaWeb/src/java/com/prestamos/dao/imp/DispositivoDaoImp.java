/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.prestamos.dao.imp;

import com.prestamos.dao.DispositivoDao;
import com.prestamos.dto.Dispositivo;
import com.prestamos.exception.DaoException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Clase que implementa los metodos del dao de dispositivo
 * @author Juan Carlos
 */
public class DispositivoDaoImp implements DispositivoDao{
    
    private SessionFactory sessionFactory;

    /**
     * Implementacion del metodo insertar
     * @param dispositivo es el dispositivo que se va a insertar
     * @throws DaoException 
     */
    @Override
    public void insertar(Dispositivo dispositivo) throws DaoException{
        Session session = null;
        Transaction transaction = null;
        try {   //Se abre la session y se inserta el dispositivo y se hace commit
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(dispositivo);
            transaction.commit();//EXITO
        } catch (HibernateException e) { //Cuando hay un error se hace rollback
            if(transaction != null){
                transaction.rollback();//ERROR 
            }
            throw new DaoException(e);
        } finally{  //Se cierra la sesion cuando finaliza
            if(session != null){
                session.close();
            }
        }
    }

    /**
     * Implementacion del metodo buscar
     * @param codigo es el codigo de identificacion del dispositivo a buscar
     * @return una instancia del dispositivo buscado
     * @throws DaoException 
     */
    @Override
    public Dispositivo buscar(long codigo) throws DaoException{
        Session session = null;
        Dispositivo dispositivo = null;
        try {   //Se abre la sesion y se busca el dispositivo
            session = sessionFactory.openSession();
            dispositivo = (Dispositivo)session.get(Dispositivo.class, codigo);
        } catch (ExceptionInInitializerError e) {  //Cuando hay error se lanza notificacion
            throw new DaoException(e);
        } finally{   //Cuando finaliza el metodo se cierra la session
            if(session != null){
                session.close();
            }
        } 
        return dispositivo;    //Se restorna el dispositivo buscado
    }

    /**
     * Implementacion del metodo actualizar
     * @param dispositivo dispositivo que se van a actualizar los datos
     * @throws DaoException 
     */
    @Override
    public void actualizar(Dispositivo dispositivo) throws DaoException{
        Session session = null;
        Transaction transaction = null;
        try {  //Se abre la sesion y se actualiza el dispositivo y se hace commit
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(dispositivo);
            transaction.commit();//EXITO
        } catch (HibernateException e) {    //Cuando hay error se hace rollback
            if(transaction != null){
                transaction.rollback();//ERROR 
            }
            throw new DaoException(e);
        } finally{  //Cuando finaliza se cierra sesion
            if(session != null){
                session.close();
            }
        }
    }

    /**
     * Implementacion del metodo eliminar
     * @param dispositivo es el dispositivo que se va a eliminar 
     * @throws DaoException 
     */
    @Override
    public void eliminar(Dispositivo dispositivo) throws DaoException{
        Session session = null;
        Transaction transaction = null;
        try {  //Se abre la sesion y se elimina el dispositivo y se hace commit
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(dispositivo);
            transaction.commit();//EXITO
        } catch (HibernateException e) { //Cuando hay error se hace rollback
            if(transaction != null){
                transaction.rollback();//ERROR 
            }
            throw new DaoException(e);
        } finally{  //Cuando finaliza se cierra la sesion
            if(session != null){
                session.close();
            }
        }
    }

    /**
     * Implementa el metodo de listar los dispositivos 
     * @return una lista con todos los dipositivos disponibles
     * @throws DaoException 
     */
    @Override
    public List<Dispositivo> listar() throws DaoException{
        Session session = null;
        List<Dispositivo> dispositivos = new ArrayList<>();
        try {   //Abre una sesion y lista todos los dispositivos
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(Dispositivo.class);
            dispositivos = criteria.list();
        } catch (ExceptionInInitializerError e) {   //Lanza notificacion cuando hay error
            throw new DaoException(e);
        } finally{   //Cierra la sesion cuando finaliza
            if(session != null){
                session.close();
            }
        }
        return dispositivos;   //Retorna la lista de dispositivos
    }
    
    /**
     * Metodo que inyecta la sesion 
     * @param sessionFactory 
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
}
