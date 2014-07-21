/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.prestamos.dao.imp;

import com.prestamos.dao.UsuarioDao;
import com.prestamos.dto.Usuario;
import com.prestamos.dto.UsuarioId;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.HibernateException;
import com.prestamos.exception.DaoException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que implementa todos los metodos de el dao de Usuario
 * @author Juan Carlos
 */
public class UsuarioDaoImp implements UsuarioDao{
    
    private SessionFactory sessionFactory;

    /**
     * 
     * @param usuario
     * @throws DaoException 
     */
    @Override
    public void insertar(Usuario usuario) throws DaoException{
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(usuario);
            transaction.commit();//EXITO
        } catch (HibernateException e) {
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
     * Implementa el metodo que busca a un usuario segun su id
     * @param id es el id de la persona que se busca
     * @return una instancia del usuario buscado
     * @throws DaoException 
     */
    @Override
    public Usuario buscar(UsuarioId id) throws DaoException{
          Session session = null;
        Usuario usuario = null;
        try {  //Inicia sesion y busca al usuario segun su id
            session = sessionFactory.openSession();
            usuario = (Usuario)session.get(Usuario.class, id);
        } catch (ExceptionInInitializerError e) {
            throw new DaoException(e);   //Lanza una exception cuando hay error
        } finally{     //Finaliza la sesion
            if(session != null){
                session.close();
            }
        }
        return usuario;  //retorna el usuario buscado
    }

    /**
     * Implementa el metodo que actualiza un usuario
     * @param usuario es el usuario que se va a actualizar
     * @throws DaoException 
     */
    @Override
    public void actualizar(Usuario usuario) throws DaoException{
         Session session = null;
        Transaction transaction = null;
        try {    //Inicia sesion, actualiza y hace commit
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(usuario);
            transaction.commit();//EXITO
        } catch (HibernateException e) {
            if(transaction != null){  //Hace rollback si hay algun error
                transaction.rollback();//ERROR 
            }
            throw new DaoException(e);
        } finally{       //Finaliza la sesion
            if(session != null){
                session.close();
            }
        }
    }

    /**
     * Implementa el metodo para eliminar una usuario de la base de datos
     * @param usuario es el usuario a eliminar
     * @throws DaoException 
     */
    @Override
    public void eliminar(Usuario usuario) throws DaoException{
        Session session = null;
        Transaction transaction = null;
        try {   //Inicia sesion, elimina y hace commit
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(usuario);
            transaction.commit();//EXITO
        } catch (HibernateException e) {
            if(transaction != null){   //Hace rollback si hay algun error
                transaction.rollback();//ERROR 
            }
            throw new DaoException(e);
        } finally{       //Finaliza la sesion
            if(session != null){
                session.close();
            }
        }
    }

    /**
     * Implementa el metodo para listar a todos los usuarios de la base de datos
     * @return una lista con todos los usuarios existentes
     * @throws DaoException 
     */
    @Override
    public List<Usuario> listar() throws DaoException{
        Session session = null;
        List<Usuario> usuarios = new ArrayList<>();
        try {    //Inicia sesion, lista a los usuarios y hace commit
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(Usuario.class);
            usuarios = criteria.list();
        } catch (ExceptionInInitializerError e) {
            throw new DaoException(e);   //Lanza una exception cuando hay error
        } finally{         //Finaliza la sesion
            if(session != null){
                session.close();
            }
        }
        return usuarios;   //Retorna una lista de usuarios existentes
    }
    
    /**
     * Inyecta la sesion
     * @param sessionFactory 
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
}
