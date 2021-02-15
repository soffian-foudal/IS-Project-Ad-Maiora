/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application.GestioneDiscussioni;

import Application.GestioneDiscussioni.ManagerCommento;
import Storage.GestioneDati.UtenteGenerico;
import Storage.GestioneDati.Commento;
import Storage.GestioneDati.Discussione;
import java.util.ArrayList;
import java.util.List;
import junit.framework.TestCase;
import org.junit.Test;

/**
 *
 * @author utente
 */
public class ManagerCommentoTest extends TestCase {
    
    public ManagerCommentoTest() {}
    
    /**
     * Test of getById method, of class ManagerCommento.
     */
    @Test
    public void testGetById() throws Exception {
        System.out.println(getClass().getName() + ".testGetById");
        String id = "1";
        ManagerCommento instance = new ManagerCommento();
        Commento expResult = new Commento("Post di test, è il primo della discussione");
        UtenteGenerico utente = new UtenteGenerico(
                "utente123", "c244b31f0f9750fbc3b8e52936b6877a", 
                "mrossi@unisa.it", "mario", "rossi"
        );
        Discussione discussione = new Discussione(1, 
                "Ingegneria del Software", "General",
                "Discussione generale, riferita al corso di Ingegneria del Software: "
                        + "Dipartimento d'Informatica, Università degli Studi di Salerno.", 
                "Ingegneria del Software", "Terzo Anno"
        );
        expResult.setId(1);
        expResult.setUtente(utente);
        expResult.setDiscussione(discussione);
        Commento result = instance.getById(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of getAll method, of class ManagerCommento.
     */
    @Test
    public void testGetAll() throws Exception {
        System.out.println(getClass().getName() + ".testGetAll");
        ManagerCommento instance = new ManagerCommento();
        List<Commento> expResult = new ArrayList<>();
        UtenteGenerico utente = new UtenteGenerico(
                "utente123", "c244b31f0f9750fbc3b8e52936b6877a", 
                "mrossi@unisa.it", "mario", "rossi"
        );
        utente.setRuolo("PROFESSORE");
        Discussione discussione = new Discussione(1, 
                "Ingegneria del Software", "General",
                "Discussione generale, riferita al corso di Ingegneria del Software: "
                        + "Dipartimento d'Informatica, Università degli Studi di Salerno.", 
                "Ingegneria del Software", "Terzo Anno"
        );
        Commento commento1 = new Commento("Post di test è il primo della discussione");
        commento1.setId(1);
        commento1.setUtente(utente);
        commento1.setDiscussione(discussione);
        Commento commento2 = new Commento("Post di test1 è il secondo della discussione");
        commento2.setId(2);
        commento2.setUtente(utente);
        commento2.setDiscussione(discussione);
        Commento commento3 = new Commento(3, "Ultimo post di test della discussione...", "DELETED");
        commento3.setUtente(utente);
        commento3.setDiscussione(discussione);
        expResult.add(commento1);
        expResult.add(commento2);
        expResult.add(commento3);
        List<Commento> result = instance.getAll();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPostDiscussione method, of class ManagerCommento.
     */
    @Test
    public void testGetPostDiscussione() throws Exception {
        System.out.println(getClass().getName() + ".testGetPostDiscussione");
        UtenteGenerico utente = new UtenteGenerico(
                "utente123", "c244b31f0f9750fbc3b8e52936b6877a", 
                "mrossi@unisa.it", "mario", "rossi"
        );
        Discussione discussione = new Discussione(1, 
                "Ingegneria del Software", "General",
                "Discussione generale, riferita al corso di Ingegneria del Software: "
                        + "Dipartimento d'Informatica, Università degli Studi di Salerno.", 
                "Ingegneria del Software", "Terzo Anno"
        );
        ManagerCommento instance = new ManagerCommento();
        List<Commento> expResult = new ArrayList<>();
        Commento commento1 = new Commento("Post di test è il primo della discussione");
        commento1.setId(1);
        commento1.setUtente(utente);
        commento1.setDiscussione(discussione);
        Commento commento2 = new Commento("Post di test è il secondo della discussione");
        commento2.setId(2);
        commento2.setUtente(utente);
        commento2.setDiscussione(discussione);
        expResult.add(commento1);
        expResult.add(commento2);
        List<Commento> result = instance.getPostDiscussione(discussione);
        assertEquals(expResult, result);
    }

    /**
     * Test of pubblica method, of class ManagerCommento.
     */
    @Test
    public void testPubblica() throws Exception {
        System.out.println(getClass().getName() + ".testPubblica");
        String corpo = "Corpo Prova";
        UtenteGenerico utente = new UtenteGenerico(
                "utente123", "c244b31f0f9750fbc3b8e52936b6877a", 
                "mrossi@unisa.it", "mario", "rossi"
        );
        Discussione discussione = new Discussione(1, 
                "Ingegneria del Software", "General",
                "Discussione generale, riferita al corso di Ingegneria del Software: "
                        + "Dipartimento d'Informatica, Università degli Studi di Salerno.", 
                "Ingegneria del Software", "Terzo Anno"
        );
        ManagerCommento instance = new ManagerCommento();
        Commento expResult = new Commento(0, "Corpo Prova", "PUBLIC");
        expResult.setDiscussione(discussione);
        expResult.setUtente(utente);
        Commento result = instance.pubblica(corpo, utente, discussione);
        instance.delete(result);
        if(null != result && null != result.getId())result.setId(0);
        assertEquals(expResult, result);
    }
}
