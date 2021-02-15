/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application.ControlloContenuti;

import Application.Manager;
import Storage.GestioneDati.RichiestaCreazione;
import Storage.GestioneDati.UtenteGenerico;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.NoResultException;

/**
 *  Estensione della classe astratta Manager: definisce l'astrazione del
 *  concetto per oggetti di tipo RichiestaCreazione. Eredita i comportamenti
 *  della classe padre, ridefinendoli all'occorrenza, e li estende con
 *  comportamenti applicabili esclusivamente a riferimenti di tipo
 *  RichiestaCreazione.
 * 
 *  <pre>
 *      ManagerRichiesta managerRichiesta = new ManagerRichiesta();
 *  </pre>
 * 
 *  @author Davide Meriano
 *  @see    Application.InterfacciaDAO
 *  @see    Application.Manager
 *  @see    Storage.GestioneDati.RichiestaCreazione
 */
public class ManagerRichiesta extends Manager<RichiestaCreazione> {
    
    public ManagerRichiesta() {super();}    //Costruttore

    /**
     *  Metodo per delegare ad un oggetto di tipo Manager la creazione e la 
     *  persistenza di un oggetto di tipo RichiestaCreazione.
     * 
     *  @param nome             è il nome della discussione di cui s'intende richiedere la creazione.
     *  @param oggetto          è l'oggetto della discussione di cui s'intende richiedere la creazione.
     *  @param descrizione      è la descrizione della discussione di cui s'intende richiedere la creazione.
     *  @param sottocategoria   è la sottocategoria della discussione di cui s'intende richiedere la creazione.
     *  @param categoria        è la categoria della discussione di cui s'intende richiedere la creazione.
     *  @param utente           è un riferimento ad oggetto di tipo UtenteGenerico,
     *                          rappresenta l'utente che sottomette la richiesta.
     *  @return                 Un riferimento alla richiesta appena resa persistente.
     *                          Restituisce null qualora uno dei parametri fosse un riferimento a null.
     * @see Storage.GestioneDati.RichiestaCreazione
     * @see Storage.GestioneDati.UtenteGenerico
     */
    public RichiestaCreazione create(String nome, String oggetto, String descrizione, String sottocategoria, String categoria, UtenteGenerico utente) {
        if(null == nome || null == oggetto || null == descrizione || null == sottocategoria || null == categoria || null == utente) return null;
        RichiestaCreazione richiesta = new RichiestaCreazione(nome, oggetto, descrizione, sottocategoria, categoria);
        richiesta.setUtenteGenerico(utente);
        return create(richiesta);
    }
    
    /**
     *  @see Model.MarcaturaDAO
     *  @see Storage.GestioneDati.RichiestaCreazione 
     */
    @Override
    public RichiestaCreazione getById(String id) {
        try{
            return em.createNamedQuery("RichiestaCreazione.findById", RichiestaCreazione.class).setParameter("id", Integer.parseInt(id)).getSingleResult();
        } catch(NoResultException nre) {
            Logger.getLogger(getClass().getName()).log(Level.WARNING, "@getById(String id): {0} has been caught...", nre.getClass().getName());
            return null;
        }
    }

    /**
     *  @see Model.MarcaturaDAO
     *  @see Storage.GestioneDati.RichiestaCreazione
     */
    @Override
    public List<RichiestaCreazione> getAll() {
        return em.createNamedQuery("RichiestaCreazione.findAll", RichiestaCreazione.class).getResultList();
    }
    
    /**
     *  Metodo per il recupero di tutte le richieste persistenti, purché il loro
     *  stato sia 'PENDING', ossia in attesa d'approvazione.
     * 
     *  @return Restituisce una lista di richieste.
     *  @see    Storage.GestioneDati.RichiestaCreazione
     *  @see    java.util.List
     */
    public List<RichiestaCreazione> getAllPending() {
        return em.createNamedQuery("RichiestaCreazione.findAllPending", RichiestaCreazione.class).getResultList();
    }
    
    /**
     * Metodo per l'accettazione di una richiesta, ossia l'acquisizione da parte
     * della stessa dello stato 'APPROVED'.
     *  @param richiesta è un riferimento ad oggetto di tipo RichiestaCreazione,
     *         rappresenta la richiesta soggetta all'assunzione dello stato di cui sopra.
     *  @see Storage.GestioneDati.RichiestaCreazione
     */
    public void accettaRichiesta(RichiestaCreazione richiesta) {
        if(null != richiesta) {
            richiesta.setStato("APPROVED");
            update(richiesta);
            //TO ADD: More Logic?
        }
    }
    
    /**
     * Metodo per il rifiuto di una richiesta, ossia l'acquisizione da parte
     * della stessa dello stato 'REJECTED'.
     *  @param richiesta è un riferimento ad oggetto di tipo RichiestaCreazione,
     *         rappresenta la richiesta soggetta all'assunzione dello stato di cui sopra.
     *  @see Storage.GestioneDati.RichiestaCreazione
     */
    public void rifiutaRichiesta(RichiestaCreazione richiesta) {
        if(null != richiesta) {
            richiesta.setStato("REJECTED");
            update(richiesta);
            //TO ADD: More Logic?
        }
    }
}
