/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application.GestioneDiscussioni;

import Application.GestioneDiscussioni.ManagerDiscussione;
import Storage.GestioneDati.Discussione;
import java.util.ArrayList;
import java.util.List;
import junit.framework.TestCase;
import org.junit.Test;

/**
 *
 * @author utente
 */
public class ManagerDiscussioneTest extends TestCase {
    
    public ManagerDiscussioneTest() {}

    /**
     * Test of create method, of class ManagerDiscussione.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println(getClass().getName() + ".testCreate");
        String mail = "mrossi@unisa.it";
        String nome = "DiscussioneTest";
        String oggetto = "OggettoTest";
        String descrizione = "DescrizioneTest";
        String sottocategoria = "SottocategoriaTest";
        String categoria = "CategoriaTest";
        ManagerDiscussione instance = new ManagerDiscussione();
        Discussione expResult = new Discussione(0, nome, 
                oggetto, descrizione, sottocategoria, categoria);
        Discussione result = instance.create(mail, nome, oggetto, descrizione, sottocategoria, categoria);
        instance.delete(result);
        if(null != result && null != result.getId())result.setId(0);
        assertEquals(expResult, result);
    }

    /**
     * Test of getById method, of class ManagerDiscussione.
     */
    @Test
    public void testGetById() throws Exception {
        System.out.println(getClass().getName() + ".testGetById");
        String id = "1";
        ManagerDiscussione instance = new ManagerDiscussione();
        Discussione expResult = new Discussione(1, 
                "Ingegneria del Software", "General",
                "Discussione generale, riferita al corso di Ingegneria del Software: "
                        + "Dipartimento d'Informatica, Università degli Studi di Salerno.", 
                "Ingegneria del Software", "Terzo Anno"
        );
        Discussione result = instance.getById(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of getAll method, of class ManagerDiscussione.
     */
    @Test
    public void testGetAll() throws Exception {
        System.out.println(getClass().getName() + ".testGetAll");
        ManagerDiscussione instance = new ManagerDiscussione();
        List<Discussione> expResult = new ArrayList<>();
        Discussione discussione1 = new Discussione(1, 
                "Ingegneria del Software", "General",
                "Discussione generale, riferita al corso di Ingegneria del Software: "
                        + "Dipartimento d'Informatica, Università degli Studi di Salerno.", 
                "Ingegneria del Software", "Terzo Anno"
        );
        Discussione discussione2 = new Discussione(2, 
                "Analisi e Specifica dei Requisiti", "Requirements",
                "Discussione in merito all'Analisi e Specifica dei Requisiti in tutte le "
                        + "sue forme, riferita al corso di Ingegneria del Software: "
                        + "Dipartimento d'Informatica, Università degli Studi di Salerno.", 
                "Ingegneria del Software", "Terzo Anno"
        );
        Discussione discussione3 = new Discussione(3, 
                "System Design", "Design",
                "Discussione in merito al Design di Sistema in tutte le sue forme, "
                        + "riferita al corso di Ingegneria del Software: Dipartimento "
                        + "d'Informatica, Università degli Studi di Salerno.", 
                "Ingegneria del Software", "Terzo Anno"
        );
        Discussione discussione4 = new Discussione(4, 
                "Object Design", "Design",
                "Discussione in merito all'Object Design in tutte le sue forme, riferita "
                        + "al corso di Ingegneria del Software: Dipartimento d'Informatica, "
                        + "Università degli Studi di Salerno.", 
                "Ingegneria del Software", "Terzo Anno"
        );
        Discussione discussione5 = new Discussione(5, 
                "Software Testing", "Testing",
                "Discussione in merito al Testing del Software in tutte le sue forme, "
                        + "riferita al corso di Ingegneria del Software: Dipartimento "
                        + "d'Informatica, Università degli Studi di Salerno.", 
                "Ingegneria del Software", "Terzo Anno"
        );
        expResult.add(discussione1);
        expResult.add(discussione2);
        expResult.add(discussione3);
        expResult.add(discussione4);
        expResult.add(discussione5);
        List<Discussione> result = instance.getAll();
        assertEquals(expResult, result);
    }
}
