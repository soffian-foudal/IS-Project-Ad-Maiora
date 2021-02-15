/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application.GestioneDiscussioni;

import Application.Manager;
import Storage.GestioneDati.Discussione;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.NoResultException;

/**
 *  Estensione della classe astratta Manager: definisce l'astrazione del
 *  concetto per oggetti di tipo Discussione. Eredita i comportamenti
 *  della classe padre, ridefinendoli all'occorrenza.
 * 
 *  <pre>
 *      ManagerDiscussione managerDiscussione = new ManagerDiscussione();
 *  </pre>
 * 
 *  @author Davide Meriano
 *  @see    Application.InterfacciaDAO
 *  @see    Application.Manager
 *  @see    Storage.GestioneDati.Discussione
 */
public class ManagerDiscussione extends Manager<Discussione> {

    public ManagerDiscussione() {super();}  //Costruttore
    
    /**
     *  Metodo per delegare ad un oggetto di tipo Manager la creazione e la 
     *  persistenza di un oggetto di tipo Discussione.
     * 
     *  @param nome             è il nome della discussione che s'intende creare.
     *  @param oggetto          è l'oggetto della discussione che s'intende creare.
     *  @param descrizione      è la descrizione della discussione che s'intende creare.
     *  @param sottocategoria   è la sottocategoria della discussione che s'intende creare.
     *  @param categoria        è la categoria della discussione che s'intende creare.
     *  @param mail             è la mail dell'utente che ha richiesto la creazione della
     *                          discussione, nel caso di discussione preconfigurata assume il valore
     *                          "SISTEMA". Rappresenta l'utente che ha sottomesso la richiesta.
     *  @return                 Un riferimento alla discussione appena resa persistente.
     *                          Restituisce null qualora uno dei parametri fosse un riferimento a null.
     * @see Storage.GestioneDati.Discussione
     * @see Model.GestioneAccount.UtenteGenerico
     */
    public Discussione create(String mail, String nome, String oggetto, String descrizione, String sottocategoria, String categoria) {
        if(null == mail || null == nome || null == oggetto || null == descrizione || null == sottocategoria || null == categoria) return null;
        Discussione discussione = new Discussione(mail, nome, oggetto, descrizione, sottocategoria, categoria);
        return create(discussione);
    }
    
    /**
     *  @see Model.MarcaturaDAO
     *  @see Storage.GestioneDati.Discussione
     */
    @Override
    public Discussione getById(String id) {
        try{
            return em.createNamedQuery("Discussione.findById", Discussione.class).setParameter("id", Integer.parseInt(id)).getSingleResult();
        } catch(NoResultException nre) {
            Logger.getLogger(getClass().getName()).log(Level.WARNING, "@getById(String id): {0} has been caught...", nre.getClass().getName());
            return null;
        }
    }
    
    /**
     *  @see Model.MarcaturaDAO
     *  @see Storage.GestioneDati.Discussione
     */
    @Override
    public List<Discussione> getAll() {
        return em.createNamedQuery("Discussione.findAll", Discussione.class).getResultList();
    }
}
