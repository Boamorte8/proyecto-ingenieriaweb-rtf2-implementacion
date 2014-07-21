/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.prestamos.dao.imp;

import com.prestamos.dto.Dispositivo;
import com.prestamos.dto.Prestamo;
import com.prestamos.dto.UsuarioId;
import com.prestamos.exception.DaoException;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Juan Carlos
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "file:web/WEB-INF/applicationContext.xml")
public class PrestamoDaoImpTest {
    
    @Autowired
    PrestamoDaoImp instance;
   
    /**
     * Test of disponibles method, of class PrestamoDaoImp.
     * @throws com.prestamos.exception.DaoException
     */
    @Test
    public void testListarDispositivosDisponibles() throws DaoException {
        System.out.println("disponibles");
        Date fecha = new Date(2014, 07, 20, 05, 05);
        List<Dispositivo> result = instance.listarDispositivosDisponibles(fecha);
        assertTrue(result.size() > 0);
    }

    /**
     * Test of solicitarPrestamo method, of class PrestamoDaoImp.
     * @throws com.prestamos.exception.DaoException
     */
    @Test
    public void testSolicitarPrestamo() throws DaoException {
        System.out.println("solicitarPrestamo");
        Prestamo prestamo = instance.consultarPrestamosInvestigador(new UsuarioId("cedula", "123")).get(0);
        instance.solicitarPrestamo(prestamo);
        assertTrue(true);
    }

    /**
     * Test of actualizar method, of class PrestamoDaoImp.
     * @throws com.prestamos.exception.DaoException
     */
    @Test
    public void testActualizar() throws DaoException {
        System.out.println("actualizar");
        Prestamo prestamo = instance.consultarPrestamosInvestigador(new UsuarioId("cedula", "123")).get(0);
        prestamo.setEstado("Finalizado");
        instance.actualizar(prestamo);
        prestamo = instance.consultarPrestamosInvestigador(new UsuarioId("cedula", "123")).get(0);
        assertEquals("Finalizado", prestamo.getEstado());
    }

    /**
     * Test of consultarPrestamosInvestigador method, of class PrestamoDaoImp.
     * @throws com.prestamos.exception.DaoException
     */
    @Test
    public void testConsultarPrestamosInvestigador() throws DaoException {
        System.out.println("consultarPrestamosInvestigador");
        UsuarioId id = new UsuarioId("cedula", "123");
        List<Prestamo> result = instance.consultarPrestamosInvestigador(id);
        assertTrue(result.size() > 0);
    }

    /**
     * Test of consultarPrestamosActivos method, of class PrestamoDaoImp.
     * @throws com.prestamos.exception.DaoException
     */
    @Test
    public void testConsultarPrestamosActivos() throws DaoException {
        System.out.println("consultarPrestamosActivos");
        List<Prestamo> result = instance.consultarPrestamosActivos();
        assertTrue(result.size() > 0);
    }
}
