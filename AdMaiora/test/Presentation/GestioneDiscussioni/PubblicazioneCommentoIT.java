/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.GestioneDiscussioni;

import Presentation.GestioneDiscussioni.PubblicazioneCommento;
import Application.GestioneDiscussioni.ManagerCommento;
import Storage.GestioneDati.Commento;
import java.util.List;
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
public class PubblicazioneCommentoIT extends TestCase {

    private HttpServletRequest request;

    /**
     * Test of doPost method, of class PubblicazioneCommento.
     */
    @Test
    public void testDoPost() throws Exception {
        System.out.println(getClass().getName() + ".testDoPost");
        request = Mockito.mock(HttpServletRequest.class);
        HttpSession sessione = Mockito.mock(HttpSession.class);
        Mockito.when(sessione.getAttribute("nomeUtente")).thenReturn("utente123");
        Mockito.when(request.getSession(false)).thenReturn(sessione);
        Mockito.when(request.getParameter("idDiscussione")).thenReturn("1");
        Mockito.when(request.getParameter("corpo")).thenReturn("Corpo di prove, lunghezza accettabile");
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        PubblicazioneCommento instance = Mockito.mock(PubblicazioneCommento.class);
        Mockito.doCallRealMethod().when(instance).doPost(request, response);
        instance.doPost(request, response);
        verify(request).setAttribute("LCOK", true);
        ManagerCommento managerCommento = new ManagerCommento();
        List<Commento> list = managerCommento.getAll();
        Commento c = list.get(list.size()-1);
        managerCommento.delete(c);
    }
    
    @Test
    public void testDoPostLTooShort() throws Exception {
        System.out.println(getClass().getName() + ".testDoPostLTooShort");
        request = Mockito.mock(HttpServletRequest.class);
        HttpSession sessione = Mockito.mock(HttpSession.class);
        Mockito.when(sessione.getAttribute("nomeUtente")).thenReturn("utente123");
        Mockito.when(request.getSession(false)).thenReturn(sessione);
        Mockito.when(request.getParameter("idDiscussione")).thenReturn("1");
        Mockito.when(request.getParameter("corpo")).thenReturn("");
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        PubblicazioneCommento instance = Mockito.mock(PubblicazioneCommento.class);
        Mockito.doCallRealMethod().when(instance).doPost(request, response);
        instance.doPost(request, response);
        verify(request).setAttribute("LCOK", false);
    }
    
    @Test
    public void testDoPostLTooLong() throws Exception {
        System.out.println(getClass().getName() + ".testDoPostLTooLong");
        request = Mockito.mock(HttpServletRequest.class);
        HttpSession sessione = Mockito.mock(HttpSession.class);
        Mockito.when(sessione.getAttribute("nomeUtente")).thenReturn("utente123");
        Mockito.when(request.getSession(false)).thenReturn(sessione);
        Mockito.when(request.getParameter("idDiscussione")).thenReturn("1");
        Mockito.when(request.getParameter("corpo")).thenReturn(
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
        PubblicazioneCommento instance = Mockito.mock(PubblicazioneCommento.class);
        Mockito.doCallRealMethod().when(instance).doPost(request, response);
        instance.doPost(request, response);
        verify(request).setAttribute("LCOK", false);
    }
}
