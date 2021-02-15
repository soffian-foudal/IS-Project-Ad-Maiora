/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.ControlloContenuti;

import Presentation.ControlloContenuti.CreaDiscussione;
import Application.ControlloContenuti.ManagerRichiesta;
import Application.Manager;
import Storage.GestioneDati.RichiestaCreazione;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import junit.framework.TestCase;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.verify;

/**
 *
 * @author utente
 */
public class CreazioneDiscussioneIT extends TestCase {

    private HttpServletRequest request;
    
    /**
     * Test of doPost method, of class CreaDiscussione.
     */
    @Test
    public void testDoPost() throws Exception {
        System.out.println(getClass().getName() + ".testDoPost");
        request = Mockito.mock(HttpServletRequest.class);
        HttpSession sessione = Mockito.mock(HttpSession.class);
        Mockito.when(sessione.getAttribute("nomeUtente")).thenReturn("utente123");
        Mockito.when(request.getSession(false)).thenReturn(sessione);
        Mockito.when(request.getParameter("nome")).thenReturn("NomeTest");
        Mockito.when(request.getParameter("oggetto")).thenReturn("OggettoTest");
        Mockito.when(request.getParameter("descrizione")).thenReturn("DescrizioneTest");
        Mockito.when(request.getParameter("sottocategoria")).thenReturn("SottocategoriaTest");
        Mockito.when(request.getParameter("categoria")).thenReturn("CategoriaTest");
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        CreaDiscussione instance = Mockito.mock(CreaDiscussione.class);
        Mockito.doCallRealMethod().when(instance).doPost(request, response);
        Mockito.when(instance.getServletContext()).thenReturn(Mockito.mock(ServletContext.class));
        Mockito.when(instance.getServletContext().getRequestDispatcher(Mockito.anyString())).thenReturn(Mockito.mock(RequestDispatcher.class));
        instance.doPost(request, response);
        verify(request).setAttribute("LNOK", true);
        verify(request).setAttribute("LOOK", true);
        verify(request).setAttribute("LDOK", true);
        verify(request).setAttribute("LSOK", true);
        verify(request).setAttribute("LCOK", true);
        ManagerRichiesta managerRichiesta = new ManagerRichiesta();
        List<RichiestaCreazione> list = managerRichiesta.getAll();
        RichiestaCreazione r = list.get(list.size()-1);
        managerRichiesta.delete(r);
    }
    
    @Test
    public void testDoPostLN() throws Exception {
        System.out.println(getClass().getName() + ".testDoPostLN");
        request = Mockito.mock(HttpServletRequest.class);
        HttpSession sessione = Mockito.mock(HttpSession.class);
        Mockito.when(sessione.getAttribute("nomeUtente")).thenReturn("utente123");
        Mockito.when(request.getSession(false)).thenReturn(sessione);
        Mockito.when(request.getParameter("nome")).thenReturn(
                "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
                        + "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
                        + "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
                        + "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
                        + "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
                        + "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
                        + "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
                        + "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
        );
        Mockito.when(request.getParameter("oggetto")).thenReturn("OggettoTest");
        Mockito.when(request.getParameter("descrizione")).thenReturn("DescrizioneTest");
        Mockito.when(request.getParameter("sottocategoria")).thenReturn("SottocategoriaTest");
        Mockito.when(request.getParameter("categoria")).thenReturn("CategoriaTest");
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        CreaDiscussione instance = Mockito.mock(CreaDiscussione.class);
        Mockito.doCallRealMethod().when(instance).doPost(request, response);
        Mockito.when(instance.getServletContext()).thenReturn(Mockito.mock(ServletContext.class));
        Mockito.when(instance.getServletContext().getRequestDispatcher(Mockito.anyString())).thenReturn(Mockito.mock(RequestDispatcher.class));
        instance.doPost(request, response);
        verify(request).setAttribute("LNOK", false);
        verify(request).setAttribute("LOOK", true);
        verify(request).setAttribute("LDOK", true);
        verify(request).setAttribute("LSOK", true);
        verify(request).setAttribute("LCOK", true);
    }
    
    @Test
    public void testDoPostLNLO() throws Exception {
        System.out.println(getClass().getName() + ".testDoPostLNLO");
        request = Mockito.mock(HttpServletRequest.class);
        HttpSession sessione = Mockito.mock(HttpSession.class);
        Mockito.when(sessione.getAttribute("nomeUtente")).thenReturn("utente123");
        Mockito.when(request.getSession(false)).thenReturn(sessione);
        Mockito.when(request.getParameter("nome")).thenReturn("");
        Mockito.when(request.getParameter("oggetto")).thenReturn(
                "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
                        + "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
                        + "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
                        + "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
                        + "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
                        + "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
                        + "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
                        + "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
        );
        Mockito.when(request.getParameter("descrizione")).thenReturn("DescrizioneTest");
        Mockito.when(request.getParameter("sottocategoria")).thenReturn("SottocategoriaTest");
        Mockito.when(request.getParameter("categoria")).thenReturn("CategoriaTest");
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        CreaDiscussione instance = Mockito.mock(CreaDiscussione.class);
        Mockito.doCallRealMethod().when(instance).doPost(request, response);
        Mockito.when(instance.getServletContext()).thenReturn(Mockito.mock(ServletContext.class));
        Mockito.when(instance.getServletContext().getRequestDispatcher(Mockito.anyString())).thenReturn(Mockito.mock(RequestDispatcher.class));
        instance.doPost(request, response);
        verify(request).setAttribute("LNOK", false);
        verify(request).setAttribute("LOOK", false);
        verify(request).setAttribute("LDOK", true);
        verify(request).setAttribute("LSOK", true);
        verify(request).setAttribute("LCOK", true);
    }
    
    @Test
    public void testDoPostLOLD() throws Exception {
        System.out.println(getClass().getName() + ".testDoPostLOLD");
        request = Mockito.mock(HttpServletRequest.class);
        HttpSession sessione = Mockito.mock(HttpSession.class);
        Mockito.when(sessione.getAttribute("nomeUtente")).thenReturn("utente123");
        Mockito.when(request.getSession(false)).thenReturn(sessione);
        Mockito.when(request.getParameter("nome")).thenReturn("NomeTest");
        Mockito.when(request.getParameter("oggetto")).thenReturn("");
        Mockito.when(request.getParameter("descrizione")).thenReturn(
                "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
                        + "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
                        + "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
                        + "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
                        + "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
                        + "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
                        + "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
                        + "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
        );
        Mockito.when(request.getParameter("sottocategoria")).thenReturn("SottocategoriaTest");
        Mockito.when(request.getParameter("categoria")).thenReturn("CategoriaTest");
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        CreaDiscussione instance = Mockito.mock(CreaDiscussione.class);
        Mockito.doCallRealMethod().when(instance).doPost(request, response);
        Mockito.when(instance.getServletContext()).thenReturn(Mockito.mock(ServletContext.class));
        Mockito.when(instance.getServletContext().getRequestDispatcher(Mockito.anyString())).thenReturn(Mockito.mock(RequestDispatcher.class));
        instance.doPost(request, response);
        verify(request).setAttribute("LNOK", true);
        verify(request).setAttribute("LOOK", false);
        verify(request).setAttribute("LDOK", false);
        verify(request).setAttribute("LSOK", true);
        verify(request).setAttribute("LCOK", true);
    }
    
    @Test
    public void testDoPostLDLS() throws Exception {
        System.out.println(getClass().getName() + ".testDoPostLDLS");
        request = Mockito.mock(HttpServletRequest.class);
        HttpSession sessione = Mockito.mock(HttpSession.class);
        Mockito.when(sessione.getAttribute("nomeUtente")).thenReturn("utente123");
        Mockito.when(request.getSession(false)).thenReturn(sessione);
        Mockito.when(request.getParameter("nome")).thenReturn("NomeTest");
        Mockito.when(request.getParameter("oggetto")).thenReturn("OggettoTest");
        Mockito.when(request.getParameter("descrizione")).thenReturn("");
        Mockito.when(request.getParameter("sottocategoria")).thenReturn(
                "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
                        + "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
                        + "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
                        + "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
                        + "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
                        + "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
                        + "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
                        + "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
        );
        Mockito.when(request.getParameter("categoria")).thenReturn("CategoriaTest");
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        CreaDiscussione instance = Mockito.mock(CreaDiscussione.class);
        Mockito.doCallRealMethod().when(instance).doPost(request, response);
        Mockito.when(instance.getServletContext()).thenReturn(Mockito.mock(ServletContext.class));
        Mockito.when(instance.getServletContext().getRequestDispatcher(Mockito.anyString())).thenReturn(Mockito.mock(RequestDispatcher.class));
        instance.doPost(request, response);
        verify(request).setAttribute("LNOK", true);
        verify(request).setAttribute("LOOK", true);
        verify(request).setAttribute("LDOK", false);
        verify(request).setAttribute("LSOK", false);
        verify(request).setAttribute("LCOK", true);
    }
    
    @Test
    public void testDoPostLSLC() throws Exception {
        System.out.println(getClass().getName() + ".testDoPostLSLC");
        request = Mockito.mock(HttpServletRequest.class);
        HttpSession sessione = Mockito.mock(HttpSession.class);
        Mockito.when(sessione.getAttribute("nomeUtente")).thenReturn("utente123");
        Mockito.when(request.getSession(false)).thenReturn(sessione);
        Mockito.when(request.getParameter("nome")).thenReturn("NomeTest");
        Mockito.when(request.getParameter("oggetto")).thenReturn("OggettoTest");
        Mockito.when(request.getParameter("descrizione")).thenReturn("DescrizioneTest");
        Mockito.when(request.getParameter("sottocategoria")).thenReturn("");
        Mockito.when(request.getParameter("categoria")).thenReturn(
                "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
                        + "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
                        + "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
                        + "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
                        + "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
                        + "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
                        + "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
                        + "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
        );
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        CreaDiscussione instance = Mockito.mock(CreaDiscussione.class);
        Mockito.doCallRealMethod().when(instance).doPost(request, response);
        Mockito.when(instance.getServletContext()).thenReturn(Mockito.mock(ServletContext.class));
        Mockito.when(instance.getServletContext().getRequestDispatcher(Mockito.anyString())).thenReturn(Mockito.mock(RequestDispatcher.class));
        instance.doPost(request, response);
        verify(request).setAttribute("LNOK", true);
        verify(request).setAttribute("LOOK", true);
        verify(request).setAttribute("LDOK", true);
        verify(request).setAttribute("LSOK", false);
        verify(request).setAttribute("LCOK", false);
    }
    
    @Test
    public void testDoPostAllWrong() throws Exception {
        System.out.println(getClass().getName() + ".testDoPostAllWrong");
        request = Mockito.mock(HttpServletRequest.class);
        HttpSession sessione = Mockito.mock(HttpSession.class);
        Mockito.when(sessione.getAttribute("nomeUtente")).thenReturn("utente123");
        Mockito.when(request.getSession(false)).thenReturn(sessione);
        Mockito.when(request.getParameter("nome")).thenReturn("");
        Mockito.when(request.getParameter("oggetto")).thenReturn("");
        Mockito.when(request.getParameter("descrizione")).thenReturn("");
        Mockito.when(request.getParameter("sottocategoria")).thenReturn("");
        Mockito.when(request.getParameter("categoria")).thenReturn("");
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        CreaDiscussione instance = Mockito.mock(CreaDiscussione.class);
        Mockito.doCallRealMethod().when(instance).doPost(request, response);
        Mockito.when(instance.getServletContext()).thenReturn(Mockito.mock(ServletContext.class));
        Mockito.when(instance.getServletContext().getRequestDispatcher(Mockito.anyString())).thenReturn(Mockito.mock(RequestDispatcher.class));
        instance.doPost(request, response);
        verify(request).setAttribute("LNOK", false);
        verify(request).setAttribute("LOOK", false);
        verify(request).setAttribute("LDOK", false);
        verify(request).setAttribute("LSOK", false);
        verify(request).setAttribute("LCOK", false);
    }
}
