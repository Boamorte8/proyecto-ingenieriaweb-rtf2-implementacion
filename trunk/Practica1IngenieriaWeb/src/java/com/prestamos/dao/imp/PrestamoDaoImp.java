/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.prestamos.dao.imp;

import com.prestamos.dao.PrestamoDao;
import com.prestamos.dto.Dispositivo;
import com.prestamos.dto.Prestamo;
import com.prestamos.dto.UsuarioId;
import com.prestamos.exception.DaoException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Clase que implementa los metodos del dao de prestam
 * @author Juan Carlos
 */
public class PrestamoDaoImp implements PrestamoDao{

    private SessionFactory sessionFactory;
    
    /**
     * Implementacion del metodo que lista los dispositivos disponibles
     * @param fecha es la fecha en la que se busca que los dispositivos esten disponibles
     * @return una lista con todos los dispositivos disponibles
     * @throws DaoException 
     */
    @Override
    public List<Dispositivo> listarDispositivosDisponibles(Date fecha) throws DaoException{
        Session session = null;
        List<Dispositivo> lista;
        try { //Abre la sesion y lista todos los dispositivos disponibles
            session = sessionFactory.openSession();
            SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            lista = session.createSQLQuery("SELECT * FROM dispositivo d, "
                    + "tipo_dispositivo t WHERE (d.codigo NOT IN "
                    + "(SELECT dispositivo FROM prestamo WHERE  ("
                    + "'"+formater.format(fecha)+"' BETWEEN fecha_inicio AND fecha_fin)"
                    + " AND (estado =  'activo' OR estado =  'aprobado'))) "
                    + "AND d.tipo = t.codigo").list();
        } catch (HibernateException e) {  //Lanza notificacion cuando hay error
            throw new DaoException(e);
        }finally{   //Cuando finaliza cierra la sesion
            if(session != null){
                session.close();
            }
        }
        return lista;  //Retorna la lista con los dispositivos disponibles
    }

    /**
     * Implementacion del metodo que solicita prestamos
     * @param prestamo es el nuevo prestamos que se va a ingresar 
     * @throws DaoException 
     */
    @Override
    public void solicitarPrestamo(Prestamo prestamo) throws DaoException{
        Session session = null;
        Transaction transaction = null;
        try {  //Inicia la sesion y se inserta el metodo y se hace commit
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(prestamo);
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
     * Implementa el metodo de actualizacion de prestamo
     * @param prestamo es el prestamo que se actualiza
     * @throws DaoException 
     */
    @Override
    public void actualizar(Prestamo prestamo) throws DaoException{
        Session session = null;
        Transaction transaction = null;
        try { //Se inicia sesion, se actualiza el prestamo y se hace commit
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(prestamo);
            transaction.commit();//EXITO
        } catch (HibernateException e) {  //Si hay error se hace rollback
            if(transaction != null){
                transaction.rollback();//ERROR 
            }
            throw new DaoException(e);
        } finally{  //Se finaliza y se cierra la sesion
            if(session != null){
                session.close();
            }
        }
    }

    /**
     * Implementa el metodo de consultar los prestamos hecho por un investigador
     * @param id es el id del investigador al que se le consultan los prestamos
     * @return retorna todos los prestamos realizados por el investigador
     * @throws DaoException 
     */
    @Override
    public List<Prestamo> consultarPrestamosInvestigador(UsuarioId id) throws DaoException{
        Session session = null;
        List<Prestamo> lista = null;
        try {  //Inicia sesion y se consultan los prestamos
            session = sessionFactory.openSession();
            Query query = session.createQuery("FROM Prestamo WHERE investigador.id = :id");
            query.setParameter("id", id);
            lista = query.list();
        } catch (HibernateException e) {  //Si hay error lanza una exception
            throw new DaoException(e);
        } finally{   //Se cierra la sesion
            if(session != null){
                session.close();
            }
        }
        return lista; //Se retorna la lista de prestamos del investigador
    }

    /**
     * Implementa el metodo de consulta de prestamos activos
     * @return una lista con todos los metodos que estan activos en el momento de la consulta
     * @throws DaoException 
     */
    @Override
    public List<Prestamo> consultarPrestamosActivos() throws DaoException{
        Session session = null;
        List<Prestamo> lista;
        try { //Inicia la sesion y realiza la consulta
            session = sessionFactory.openSession();
            SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date fecha = new Date();
            lista = session.createQuery("FROM Prestamo WHERE ('"+formater.format(fecha)+"' between fechaInicio "
                    + "and fechaFin) and (estado = 'activo' or estado = 'aprobado')").list();
        } catch (HibernateException e) {  //Lanza una exception cuando hay error
            throw new DaoException(e);
        }finally{   //Se cierra la sesion
            if(session != null){
                session.close();
            }
        }
        return lista;  //Retorna la lista con los prestamos activos
    }
    
    /**
     * Inyecta la sesion
     * @param sessionFactory 
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
