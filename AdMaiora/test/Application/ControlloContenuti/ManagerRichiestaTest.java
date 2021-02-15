/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application.ControlloContenuti;

import Application.ControlloContenuti.ManagerRichiesta;
import Storage.GestioneDati.RichiestaCreazione;
import Storage.GestioneDati.UtenteGenerico;
import java.util.ArrayList;
import java.util.List;
import junit.framework.TestCase;
import org.junit.Test;

/**
 *
 * @author utente
 */
public class ManagerRichiestaTest extends TestCase {
    
    public ManagerRichiestaTest() {}

    /**
     * Test of create method, of class ManagerRichiesta.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println(getClass().getName() + ".testCreate");
        String nome = "RichiestaTest";
        String oggetto = "OggettoTest";
        String descrizione = "DescrizioneTEst";
        String sottocategoria = "SottocategoriaTest";
        String categoria = "CategoriaTest";
        UtenteGenerico utente = new UtenteGenerico(
                "utente123", "c244b31f0f9750fbc3b8e52936b6877a", 
                "mrossi@unisa.it", "mario", "rossi"
        );
        ManagerRichiesta instance = new ManagerRichiesta();
        RichiestaCreazione expResult = new RichiestaCreazione(0, "PENDING", "CREAZIONE", 
                nome, oggetto, descrizione, sottocategoria, categoria
        );
        expResult.setUtenteGenerico(utente);
        RichiestaCreazione result = instance.create(nome, oggetto, descrizione, sottocategoria, categoria, utente);
        instance.delete(result);
        if(null != result && null != result.getId())result.setId(0);
        assertEquals(expResult, result);
    }

    /**
     * Test of getById method, of class ManagerRichiesta.
     */
    @Test
    public void testGetById() throws Exception{
        System.out.println(getClass().getName() + ".testGetById");
        String id = "1";
        ManagerRichiesta instance = new ManagerRichiesta();
        RichiestaCreazione expResult = new RichiestaCreazione(1, "PENDING", "CREAZIONE", 
                "Richiesta1", "Oggetto1", "Descrizione1", "Sottocategoria1", "Categoria1"
        );
        UtenteGenerico utente = new UtenteGenerico(
                "utente123", "c244b31f0f9750fbc3b8e52936b6877a", 
                "mrossi@unisa.it", "mario", "rossi"
        );
        expResult.setUtenteGenerico(utente);
        RichiestaCreazione result = instance.getById(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of getAll method, of class ManagerRichiesta.
     */
    @Test
    public void testGetAll() throws Exception {
        System.out.println(getClass().getName() + ".testGetAll");
        ManagerRichiesta instance = new ManagerRichiesta();
        List<RichiestaCreazione> expResult = new ArrayList<>();
        RichiestaCreazione richiesta1 = new RichiestaCreazione(1, "APPROVED", "CREAZIONE", 
                "Richiesta1", "Oggetto1", "Descrizione1", "Sottocategoria1", "Categoria1"
        );
        UtenteGenerico utente = new UtenteGenerico(
                "utente123", "c244b31f0f9750fbc3b8e52936b6877a", 
                "mrossi@unisa.it", "mario", "rossi", "PROFESSORE"
        );
        richiesta1.setUtenteGenerico(utente);
        RichiestaCreazione richiesta2 = new RichiestaCreazione(2, "REJECTED", "CREAZIONE", 
                "Richiesta2", "Oggetto2", "Descrizione2", "Sottocategoria2", "Categoria2"
        );
        richiesta2.setUtenteGenerico(utente);
        RichiestaCreazione richiesta3 = new RichiestaCreazione(3, "REJECTED", "CREAZIONE", 
                "Richiesta3", "Oggetto3", "Descrizione3", "Sottocategoria3", "Categoria3"
        );
        richiesta3.setUtenteGenerico(utente);
        expResult.add(richiesta1);
        expResult.add(richiesta2);
        expResult.add(richiesta3);
        List<RichiestaCreazione> result = instance.getAll();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAllPending method, of class ManagerRichiesta.
     */
    @Test
    public void testGetAllPending() throws Exception {
        System.out.println(getClass().getName() + ".testGetAllPending");
        ManagerRichiesta instance = new ManagerRichiesta();
        List<RichiestaCreazione> expResult = new ArrayList<>();
        expResult.add(new RichiestaCreazione(1, "PENDING", "CREAZIONE", 
                "Richiesta1", "Oggetto1", "Descrizione1", "Sottocategoria1", "Categoria1"));
        expResult.add(new RichiestaCreazione(3, "PENDING", "CREAZIONE", 
                "Richiesta3", "Oggetto3", "Descrizione3", "Sottocategoria3", "Categoria3"));
        List<RichiestaCreazione> result = instance.getAllPending();
        assertEquals(expResult, result);
    }

    /**
     * Test of accettaRichiesta method, of class ManagerRichiesta.
     */
    @Test
    public void testAccettaRichiesta() throws Exception {
        System.out.println(getClass().getName() + ".testAccettaRichiesta");
        RichiestaCreazione richiesta = new RichiestaCreazione(1, "PENDING", "CREAZIONE", 
                "Richiesta1", "Oggetto1", "Descrizione1", "Sottocategoria1", "Categoria1"
        );
        UtenteGenerico utente = new UtenteGenerico(
                "utente123", "c244b31f0f9750fbc3b8e52936b6877a", 
                "mrossi@unisa.it", "mario", "rossi"
        );
        richiesta.setUtenteGenerico(utente);
        ManagerRichiesta instance = new ManagerRichiesta();
        instance.accettaRichiesta(richiesta);
        assertEquals("APPROVED", richiesta.getStato());
        richiesta.setStato("PENDING");
        instance.update(richiesta);
    }

    /**
     * Test of rifiutaRichiesta method, of class ManagerRichiesta.
     */
    @Test
    public void testRifiutaRichiesta() throws Exception {
        System.out.println(getClass().getName() + ".testRifiutaRichiesta");
        RichiestaCreazione richiesta = new RichiestaCreazione(3, "PENDING", "CREAZIONE", 
                "Richiesta3", "Oggetto3", "Descrizione3", "Sottocategoria3", "Categoria3");
        UtenteGenerico utente = new UtenteGenerico(
                "utente123", "c244b31f0f9750fbc3b8e52936b6877a", 
                "mrossi@unisa.it", "mario", "rossi"
        );
        richiesta.setUtenteGenerico(utente);
        ManagerRichiesta instance = new ManagerRichiesta();
        instance.rifiutaRichiesta(richiesta);
        assertEquals("REJECTED", richiesta.getStato());
        richiesta.setStato("PENDING");
        instance.update(richiesta);
    }
}
