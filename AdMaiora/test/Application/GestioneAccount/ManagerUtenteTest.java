/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application.GestioneAccount;

import Application.GestioneAccount.ManagerUtente;
import Storage.GestioneDati.UtenteGenerico;
import java.util.ArrayList;
import java.util.List;
import junit.framework.TestCase;
import org.junit.Test;

/**
 *
 * @author utente
 */
public class ManagerUtenteTest extends TestCase {
    
    public ManagerUtenteTest() {}

    /**
     * Test of create method, of class ManagerUtente.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println(getClass().getName() + ".testCreate");
        String username = "utenteTest";
        String passwd = "c244b31f0f9750fbc3b8e52936b6877a";
        String mail = "utest@unisa.it";
        String nome = "Ciro";
        String cognome = "Esposito";
        ManagerUtente instance = new ManagerUtente();
        UtenteGenerico expResult = new UtenteGenerico(username, passwd, mail, nome, cognome);
        UtenteGenerico result = instance.create(username, passwd, mail, nome, cognome);
        instance.delete(result);
        assertEquals(expResult, result);
    }

    /**
     * Test of getById method, of class ManagerUtente.
     */
    @Test
    public void testGetById() throws Exception {
        System.out.println(getClass().getName() + ".testGetById");
        String username = "utente123";
        ManagerUtente instance = new ManagerUtente();
        UtenteGenerico expResult = new UtenteGenerico(
                "utente123", "c244b31f0f9750fbc3b8e52936b6877a", 
                "mrossi@unisa.it", "mario", "rossi"
        );
        UtenteGenerico result = instance.getById(username);
        assertEquals(expResult, result);
    }

    /**
     * Test of getAll method, of class ManagerUtente.
     */
    @Test
    public void testGetAll() throws Exception {
        System.out.println(getClass().getName() + ".testGetAll");
        ManagerUtente instance = new ManagerUtente();
        UtenteGenerico utente1 = new UtenteGenerico(
                "utente123", "c244b31f0f9750fbc3b8e52936b6877a", 
                "mrossi@unisa.it", "mario", "rossi"
        );
        UtenteGenerico utente2 = new UtenteGenerico(
                "utente456", "454bae7e806a281ac1ef1d1ccde20c6a", 
                "giulia@verdi.it", "giulia", "verdi"
        );
        List<UtenteGenerico> expResult = new ArrayList<>();
        expResult.add(utente1);
        expResult.add(utente2);
        List<UtenteGenerico> result = instance.getAll();
        assertEquals(expResult, result);
    }

    /**
     * Test of login method, of class ManagerUtente.
     */
    @Test
    public void testLogin() throws Exception {
        System.out.println(getClass().getName() + ".testLogin");
        String username = "utente123";
        String password = "utente123";
        ManagerUtente instance = new ManagerUtente();
        UtenteGenerico expResult = new UtenteGenerico(
                "utente123", "c244b31f0f9750fbc3b8e52936b6877a", 
                "mrossi@unisa.it", "mario", "rossi"
        );
        UtenteGenerico result = instance.login(username, password);
        assertEquals(expResult, result);
    }
    
}
