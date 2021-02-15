/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application.GestioneDiscussioni;

import Application.Manager;
import Storage.GestioneDati.UtenteGenerico;
import Storage.GestioneDati.Commento;
import Storage.GestioneDati.Discussione;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.NoResultException;

/**
 *  Estensione della classe astratta Manager: definisce l'astrazione del
 *  concetto per oggetti di tipo Commento. Eredita i comportamenti
 *  della classe padre, ridefinendoli all'occorrenza, e li estende con
 *  comportamenti applicabili esclusivamente a riferimenti di tipo
 *  Commento.
 * 
 *  <pre>
 *      ManagerCommento managerCommento = new ManagerCommento();
 *  </pre>
 * 
 *  @author Davide Meriano
 *  @see    Application.InterfacciaDAO
 *  @see    Application.Manager
 *  @see    Storage.GestioneDati.Commento
 */
public class ManagerCommento extends Manager<Commento>{

    public ManagerCommento() {super();} //Costruttore
    
    /**
     *  @see Model.MarcaturaDAO
     *  @see Storage.GestioneDati.Commento
     */
    @Override
    public Commento getById(String id) {
        try{
            return em.createNamedQuery("Commento.findById", Commento.class).setParameter("id", Integer.parseInt(id)).getSingleResult();
        } catch(NoResultException nre) {
            Logger.getLogger(getClass().getName()).log(Level.WARNING, "@getById(String id): {0} has been caught...", nre.getClass().getName());
            return null;
        }
    }

    /**
     *  @see Model.MarcaturaDAO
     *  @see Storage.GestioneDati.Commento
     */
    @Override
    public List<Commento> getAll() {
        return em.createNamedQuery("Commento.findAll", Commento.class).getResultList();
    }
    
    /**
     *  Metodo per il recupero di tutti i commenti persistenti, purché
     *  appartengano alla discussione specificata ed il loro
     *  stato sia 'PUBLIC', ossia parte integrante della discussione.
     * 
     *  @param discussione è un riferimento alla discussione della quale voler
     *         ottentere i commenti.
     *  @return Restituisce una lista di Commenti.
     *  @see    Storage.GestioneDati.Commento
     *  @see    Model.GestioneAccount.Discussione
     *  @see    java.util.List
     */
    public List<Commento> getPostDiscussione(Discussione discussione) {
        return em.createNamedQuery("Commento.findByDiscussione", Commento.class).setParameter("discussione", discussione.getId()).getResultList();
    }
    
    /**
     *  Metodo per delegare ad un oggetto di tipo Manager la creazione,
     *  con conseguente pubblicazione, e la persistenza di un oggetto di tipo 
     *  Commento.
     * 
     * @param corpo         Rappresentazione testuale del commento in sè.
     * @param utente        è un riferimento ad oggetto di tipo UtenteGenerico,
     *                      rappresenta l'utente che pubblica il Commento.
     * @param discussione   è un riferimento ad oggetto di tipo Discussione, 
     *                      rappresenta la discussione alla quale associare il
     *                      Commento.
     * @return              Un riferimento al commento appena reso persistente.
     *                      Resituisce null qualora uno dei parametri non fosse
     *                      valido.
     */
    public Commento pubblica(String corpo, UtenteGenerico utente, Discussione discussione) {
        if(null == corpo || null == utente || null == discussione) return null;
        Commento commento = new Commento(corpo);
        commento.setUtente(utente);
        commento.setDiscussione(discussione);
        return create(commento);
    }
}
