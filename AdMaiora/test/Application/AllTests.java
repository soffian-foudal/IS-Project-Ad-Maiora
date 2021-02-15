/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import Application.ControlloContenuti.ManagerRichiestaTest;
import Application.GestioneAccount.ManagerUtenteTest;
import Application.GestioneDiscussioni.ManagerCommentoTest;
import Application.GestioneDiscussioni.ManagerDiscussioneTest;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

/**
 *
 * @author utente
 */
public class AllTests {
    
    public static TestSuite suite() {
        TestSuite suite = new TestSuite();
        suite.addTestSuite(ManagerUtenteTest.class);
        suite.addTestSuite(ManagerDiscussioneTest.class);
        suite.addTestSuite(ManagerCommentoTest.class);
        suite.addTestSuite(ManagerRichiestaTest.class);
        return suite;
    }
    
    public static void main(String[] args) {
        TestRunner.run(suite());
    }
}
