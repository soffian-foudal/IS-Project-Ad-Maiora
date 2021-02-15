/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Application.ControlloContenuti.ManagerRichiestaTest;
import Application.GestioneAccount.ManagerUtenteTest;
import Application.GestioneDiscussioni.ManagerCommentoTest;
import Application.GestioneDiscussioni.ManagerDiscussioneTest;
import Presentation.ControlloContenuti.CreazioneDiscussioneIT;
import Presentation.GestioneAccount.AutenticazioneIT;
import Presentation.GestioneDiscussioni.PubblicazioneCommentoIT;
import java.util.ArrayList;
import java.util.List;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

/**
 *
 * @author utente
 */
public class AllTestIT {
    
    public static List<TestSuite> suite() {
        TestSuite gestioneAccount = new TestSuite();
        gestioneAccount.addTestSuite(ManagerUtenteTest.class);
        gestioneAccount.addTestSuite(AutenticazioneIT.class);
        
        TestSuite controlloContenuti = new TestSuite();
        controlloContenuti.addTestSuite(ManagerUtenteTest.class);
        controlloContenuti.addTestSuite(ManagerRichiestaTest.class);
        controlloContenuti.addTestSuite(CreazioneDiscussioneIT.class);
        
        TestSuite gestioneDiscussioni = new TestSuite();
        gestioneDiscussioni.addTestSuite(ManagerUtenteTest.class);
        gestioneDiscussioni.addTestSuite(ManagerDiscussioneTest.class);
        gestioneDiscussioni.addTestSuite(ManagerCommentoTest.class);
        gestioneDiscussioni.addTestSuite(PubblicazioneCommentoIT.class);
        
        List<TestSuite> list = new ArrayList<>();
        list.add(gestioneAccount);
        list.add(controlloContenuti);
        list.add(gestioneDiscussioni);
        return list;
    }
    
    public static void main(String[] args) {
        suite().forEach((TestSuite suite) -> {TestRunner.run(suite);});
    }
}
