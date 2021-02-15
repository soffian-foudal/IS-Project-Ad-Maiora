/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.GestioneAccount;

import Presentation.GestioneAccount.Autenticazione;
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
public class AutenticazioneIT extends TestCase {
    
    private HttpServletRequest request;

    /**
     * Test of doPost method, of class Autenticazione.
     */
    @Test
    public void testDoPostAllOk() throws Exception {
        System.out.println(getClass().getName() + ".testDoPostAllOk");
        request = Mockito.mock(HttpServletRequest.class);
        Mockito.when(request.getParameter("nomeUtente")).thenReturn("utente123");
        Mockito.when(request.getParameter("parolaChiave")).thenReturn("utente123");
        Mockito.when(request.getSession(true)).thenReturn(Mockito.mock(HttpSession.class));
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        Autenticazione instance = Mockito.mock(Autenticazione.class);
        Mockito.doCallRealMethod().when(instance).doPost(request, response);
        Mockito.when(instance.getServletContext()).thenReturn(Mockito.mock(ServletContext.class));
        Mockito.when(instance.getServletContext().getRequestDispatcher(Mockito.anyString())).thenReturn(Mockito.mock(RequestDispatcher.class));
        instance.doPost(request, response);
        verify(request).setAttribute("LUOK", true);
        verify(request).setAttribute("FUOK", true);
        verify(request).setAttribute("LUFUOK", true);
        verify(request).setAttribute("LPOK", true);
        verify(request).setAttribute("FPOK", true);
        verify(request).setAttribute("LPFPOK", true);
        verify(request).setAttribute("UserRetreived", true);
    }
    
    @Test
    public void testDoPostLU() throws Exception {
        System.out.println(getClass().getName() + ".testDoPostLU");
        request = Mockito.mock(HttpServletRequest.class);
        Mockito.when(request.getParameter("nomeUtente")).thenReturn("aaaaa");
        Mockito.when(request.getParameter("parolaChiave")).thenReturn("utente123");
        Mockito.when(request.getSession(true)).thenReturn(Mockito.mock(HttpSession.class));
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        Autenticazione instance = Mockito.mock(Autenticazione.class);
        Mockito.doCallRealMethod().when(instance).doPost(request, response);
        Mockito.when(instance.getServletContext()).thenReturn(Mockito.mock(ServletContext.class));
        Mockito.when(instance.getServletContext().getRequestDispatcher(Mockito.anyString())).thenReturn(Mockito.mock(RequestDispatcher.class));
        instance.doPost(request, response);
        verify(request).setAttribute("LUOK", false);
        verify(request).setAttribute("FUOK", true);
        verify(request).setAttribute("LUFUOK", false);
        verify(request).setAttribute("LPOK", true);
        verify(request).setAttribute("FPOK", true);
        verify(request).setAttribute("LPFPOK", true);
        verify(request).setAttribute("UserRetreived", false);
    }
    
    @Test
    public void testDoPostFU() throws Exception {
        System.out.println(getClass().getName() + ".testDoPostFU");
        request = Mockito.mock(HttpServletRequest.class);
        Mockito.when(request.getParameter("nomeUtente")).thenReturn("(]\"w\\azA");
        Mockito.when(request.getParameter("parolaChiave")).thenReturn("utente123");
        Mockito.when(request.getSession(true)).thenReturn(Mockito.mock(HttpSession.class));
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        Autenticazione instance = Mockito.mock(Autenticazione.class);
        Mockito.doCallRealMethod().when(instance).doPost(request, response);
        Mockito.when(instance.getServletContext()).thenReturn(Mockito.mock(ServletContext.class));
        Mockito.when(instance.getServletContext().getRequestDispatcher(Mockito.anyString())).thenReturn(Mockito.mock(RequestDispatcher.class));
        instance.doPost(request, response);
        verify(request).setAttribute("LUOK", true);
        verify(request).setAttribute("FUOK", false);
        verify(request).setAttribute("LUFUOK", false);
        verify(request).setAttribute("LPOK", true);
        verify(request).setAttribute("FPOK", true);
        verify(request).setAttribute("LPFPOK", true);
        verify(request).setAttribute("UserRetreived", false);
    }
    
    @Test
    public void testDoPostLP() throws Exception {
        System.out.println(getClass().getName() + ".testDoPostLP");
        request = Mockito.mock(HttpServletRequest.class);
        Mockito.when(request.getParameter("nomeUtente")).thenReturn("utente123");
        Mockito.when(request.getParameter("parolaChiave")).thenReturn("aaaaaa");
        Mockito.when(request.getSession(true)).thenReturn(Mockito.mock(HttpSession.class));
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        Autenticazione instance = Mockito.mock(Autenticazione.class);
        Mockito.doCallRealMethod().when(instance).doPost(request, response);
        Mockito.when(instance.getServletContext()).thenReturn(Mockito.mock(ServletContext.class));
        Mockito.when(instance.getServletContext().getRequestDispatcher(Mockito.anyString())).thenReturn(Mockito.mock(RequestDispatcher.class));
        instance.doPost(request, response);
        verify(request).setAttribute("LUOK", true);
        verify(request).setAttribute("FUOK", true);
        verify(request).setAttribute("LUFUOK", true);
        verify(request).setAttribute("LPOK", false);
        verify(request).setAttribute("FPOK", true);
        verify(request).setAttribute("LPFPOK", false);
        verify(request).setAttribute("UserRetreived", false);
    }
    
    @Test
    public void testDoPostFP() throws Exception {
        System.out.println(getClass().getName() + ".testDoPostFP");
        request = Mockito.mock(HttpServletRequest.class);
        Mockito.when(request.getParameter("nomeUtente")).thenReturn("utente123");
        Mockito.when(request.getParameter("parolaChiave")).thenReturn("aaaaaa\"a");
        Mockito.when(request.getSession(true)).thenReturn(Mockito.mock(HttpSession.class));
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        Autenticazione instance = Mockito.mock(Autenticazione.class);
        Mockito.doCallRealMethod().when(instance).doPost(request, response);
        Mockito.when(instance.getServletContext()).thenReturn(Mockito.mock(ServletContext.class));
        Mockito.when(instance.getServletContext().getRequestDispatcher(Mockito.anyString())).thenReturn(Mockito.mock(RequestDispatcher.class));
        instance.doPost(request, response);
        verify(request).setAttribute("LUOK", true);
        verify(request).setAttribute("FUOK", true);
        verify(request).setAttribute("LUFUOK", true);
        verify(request).setAttribute("LPOK", true);
        verify(request).setAttribute("FPOK", false);
        verify(request).setAttribute("LPFPOK", false);
        verify(request).setAttribute("UserRetreived", false);
    }
    
    @Test
    public void testDoPostUOK() throws Exception {
        System.out.println(getClass().getName() + ".testDoPostUOK");
        request = Mockito.mock(HttpServletRequest.class);
        Mockito.when(request.getParameter("nomeUtente")).thenReturn("utente123");
        Mockito.when(request.getParameter("parolaChiave")).thenReturn("''abcdef\"ghijklm");
        Mockito.when(request.getSession(true)).thenReturn(Mockito.mock(HttpSession.class));
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        Autenticazione instance = Mockito.mock(Autenticazione.class);
        Mockito.doCallRealMethod().when(instance).doPost(request, response);
        Mockito.when(instance.getServletContext()).thenReturn(Mockito.mock(ServletContext.class));
        Mockito.when(instance.getServletContext().getRequestDispatcher(Mockito.anyString())).thenReturn(Mockito.mock(RequestDispatcher.class));
        instance.doPost(request, response);
        verify(request).setAttribute("LUOK", true);
        verify(request).setAttribute("FUOK", true);
        verify(request).setAttribute("LUFUOK", true);
        verify(request).setAttribute("LPOK", false);
        verify(request).setAttribute("FPOK", false);
        verify(request).setAttribute("LPFPOK", false);
        verify(request).setAttribute("UserRetreived", false);
    }
    
    @Test
    public void testDoPostPOK() throws Exception {
        System.out.println(getClass().getName() + ".testDoPostPOK");
        request = Mockito.mock(HttpServletRequest.class);
        Mockito.when(request.getParameter("nomeUtente")).thenReturn("abcdefg<>,;hijklm");
        Mockito.when(request.getParameter("parolaChiave")).thenReturn("utente123");
        Mockito.when(request.getSession(true)).thenReturn(Mockito.mock(HttpSession.class));
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        Autenticazione instance = Mockito.mock(Autenticazione.class);
        Mockito.doCallRealMethod().when(instance).doPost(request, response);
        Mockito.when(instance.getServletContext()).thenReturn(Mockito.mock(ServletContext.class));
        Mockito.when(instance.getServletContext().getRequestDispatcher(Mockito.anyString())).thenReturn(Mockito.mock(RequestDispatcher.class));
        instance.doPost(request, response);
        verify(request).setAttribute("LUOK", false);
        verify(request).setAttribute("FUOK", false);
        verify(request).setAttribute("LUFUOK", false);
        verify(request).setAttribute("LPOK", true);
        verify(request).setAttribute("FPOK", true);
        verify(request).setAttribute("LPFPOK", true);
        verify(request).setAttribute("UserRetreived", false);
    }
    
    @Test
    public void testDoPostAllWrong() throws Exception {
        System.out.println(getClass().getName() + ".testDoPostAllWrong");
        request = Mockito.mock(HttpServletRequest.class);
        Mockito.when(request.getParameter("nomeUtente")).thenReturn("abcdefg<>,;hijklm");
        Mockito.when(request.getParameter("parolaChiave")).thenReturn("''abcdef\"ghijklm");
        Mockito.when(request.getSession(true)).thenReturn(Mockito.mock(HttpSession.class));
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        Autenticazione instance = Mockito.mock(Autenticazione.class);
        Mockito.doCallRealMethod().when(instance).doPost(request, response);
        Mockito.when(instance.getServletContext()).thenReturn(Mockito.mock(ServletContext.class));
        Mockito.when(instance.getServletContext().getRequestDispatcher(Mockito.anyString())).thenReturn(Mockito.mock(RequestDispatcher.class));
        instance.doPost(request, response);
        verify(request).setAttribute("LUOK", false);
        verify(request).setAttribute("FUOK", false);
        verify(request).setAttribute("LUFUOK", false);
        verify(request).setAttribute("LPOK", false);
        verify(request).setAttribute("FPOK", false);
        verify(request).setAttribute("LPFPOK", false);
        verify(request).setAttribute("UserRetreived", false);
    }
    
    @Test
    public void testDoPostAllOkNoUser() throws Exception {
        System.out.println(getClass().getName() + ".testDoPostAllOkNoUser");
        request = Mockito.mock(HttpServletRequest.class);
        Mockito.when(request.getParameter("nomeUtente")).thenReturn("58utente12");
        Mockito.when(request.getParameter("parolaChiave")).thenReturn("58utente12");
        Mockito.when(request.getSession(true)).thenReturn(Mockito.mock(HttpSession.class));
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        Autenticazione instance = Mockito.mock(Autenticazione.class);
        Mockito.doCallRealMethod().when(instance).doPost(request, response);
        Mockito.when(instance.getServletContext()).thenReturn(Mockito.mock(ServletContext.class));
        Mockito.when(instance.getServletContext().getRequestDispatcher(Mockito.anyString())).thenReturn(Mockito.mock(RequestDispatcher.class));
        instance.doPost(request, response);
        verify(request).setAttribute("LUOK", true);
        verify(request).setAttribute("FUOK", true);
        verify(request).setAttribute("LUFUOK", true);
        verify(request).setAttribute("LPOK", true);
        verify(request).setAttribute("FPOK", true);
        verify(request).setAttribute("LPFPOK", true);
        verify(request).setAttribute("UserRetreived", false);
    }
    
    @Test
    public void testDoPostEU() throws Exception {
        System.out.println(getClass().getName() + ".testDoPostAllOkNoUser");
        request = Mockito.mock(HttpServletRequest.class);
        Mockito.when(request.getParameter("nomeUtente")).thenReturn("58utente12");
        Mockito.when(request.getParameter("parolaChiave")).thenReturn("utente123");
        Mockito.when(request.getSession(true)).thenReturn(Mockito.mock(HttpSession.class));
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        Autenticazione instance = Mockito.mock(Autenticazione.class);
        Mockito.doCallRealMethod().when(instance).doPost(request, response);
        Mockito.when(instance.getServletContext()).thenReturn(Mockito.mock(ServletContext.class));
        Mockito.when(instance.getServletContext().getRequestDispatcher(Mockito.anyString())).thenReturn(Mockito.mock(RequestDispatcher.class));
        instance.doPost(request, response);
        verify(request).setAttribute("LUOK", true);
        verify(request).setAttribute("FUOK", true);
        verify(request).setAttribute("LUFUOK", true);
        verify(request).setAttribute("LPOK", true);
        verify(request).setAttribute("FPOK", true);
        verify(request).setAttribute("LPFPOK", true);
        verify(request).setAttribute("UserRetreived", false);
    }
    
    @Test
    public void testDoPostMP() throws Exception {
        System.out.println(getClass().getName() + ".testDoPostAllOkNoUser");
        request = Mockito.mock(HttpServletRequest.class);
        Mockito.when(request.getParameter("nomeUtente")).thenReturn("utente123");
        Mockito.when(request.getParameter("parolaChiave")).thenReturn("58utente12");
        Mockito.when(request.getSession(true)).thenReturn(Mockito.mock(HttpSession.class));
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        Autenticazione instance = Mockito.mock(Autenticazione.class);
        Mockito.doCallRealMethod().when(instance).doPost(request, response);
        Mockito.when(instance.getServletContext()).thenReturn(Mockito.mock(ServletContext.class));
        Mockito.when(instance.getServletContext().getRequestDispatcher(Mockito.anyString())).thenReturn(Mockito.mock(RequestDispatcher.class));
        instance.doPost(request, response);
        verify(request).setAttribute("LUOK", true);
        verify(request).setAttribute("FUOK", true);
        verify(request).setAttribute("LUFUOK", true);
        verify(request).setAttribute("LPOK", true);
        verify(request).setAttribute("FPOK", true);
        verify(request).setAttribute("LPFPOK", true);
        verify(request).setAttribute("UserRetreived", false);
    }
}
