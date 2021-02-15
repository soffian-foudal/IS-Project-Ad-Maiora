/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import Storage.MarcaturaDAO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *  Classe astratta per l'implementazione del Design Pattern DAO. Definisce
 *  l'astrazione del concetto di Manager delle entità. Interagisce con lo
 *  Storage Layer e può operare solo con entità che implementino l'interfaccia
 *  MarcaturaDAO.
 * 
 *  <pre>
 *      Manager manager = new Manager();
 *  </pre>
 * 
 *  @author Davide Meriano
 *  @param  <T> è un tipo di dato generico che estende l'interfaccia MarcaturaDAO,
 *          stabilisce l'entità a cui fa riferimento il manager stesso.
 *  @see    Storage.MarcaturaDAO
 */
public abstract class Manager<T extends MarcaturaDAO> implements InterfacciaDAO<T> {
    protected final EntityManagerFactory emf;
    protected final EntityManager em;
    protected final EntityTransaction tx;
    
    /**
     *  Costruttore di un riferimento ad oggetto di tipo Manager, inizializza
     *  le componenti di riferimento per una gestione delle entità attraverso
     *  JPA. Fa riferimento ad una Persistency Unit chiamata "AdMaioraPU", 
     *  reperibile nella directory dedicata ai file di configurazione del
     *  progetto.
     * 
     *  @see javax.persistence.EntityManagerFactory
     *  @see javax.persistence.EntityManager
     *  @see javax.persistence.EntityTransaction
     */
    protected Manager() {   //Costruttore
        emf = Persistence.createEntityManagerFactory("AdMaioraPU");
        em = emf.createEntityManager();
        tx = em.getTransaction();
    }
    
    
    @Override
    public T create(T valueObject) {
        tx.begin();
        em.persist(valueObject);
        tx.commit();
        return valueObject;
    }
    
    @Override
    public T update(T valueObject) {
        tx.begin();
        T modelObject = em.merge(valueObject);
        tx.commit();
        return modelObject;
    }
    
    @Override
    public void delete(T valueObject) {
        tx.begin();
        em.remove(valueObject);
        tx.commit();
    }
}
