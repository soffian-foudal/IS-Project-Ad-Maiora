/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import java.util.List;

/**
 *  Interfaccia per l'implementazione del Design Pattern DAO. Definisce le 
 *  operazioni standard da effettuare sugli oggetti dello Storage
 *  Layer. Può operare solo su oggetti che implementano l'interfaccia
 *  MarcaturaDAO.
 * 
 *  @author Davide Meriano
 *  @param  <MarcaturaDAO> definisce il tipo di dato soggetto alla gestione della
 *          persistenza, su cui dunque è possibile effettuare operazioni CRUD.
 *  @see    Storage.MarcaturaDAO
 */
public interface InterfacciaDAO<MarcaturaDAO> {
    /**
     *  Metodo per la creazione di un'entità che implementi l'interfaccia
     *  MarcaturaDAO. Gestisce la persistenza dell'entità.
     * 
     *  @param   object è l'istanza di una classe di cui si gestisce la persistenza.
     *  @return  Restituisce un riferimento all'entità data in gestione.
     *  @see     Storage.MarcaturaDAO
     */
    public MarcaturaDAO create(MarcaturaDAO object);
    
    /**
     *  Metodo per l'aggiornamento di un'entità che implementi l'interfaccia
     *  MarcaturaDAO. Gestisce la persistenza dell'entità.
     * 
     *  @param   object è l'istanza di una classe di cui si gestisce la persistenza.
     *           Incapsula le modifiche che s'intende apportare all'entità.
     *  @return  Restituisce un riferimento all'entità data in gestione.
     *  @see     Storage.MarcaturaDAO
     */
    public MarcaturaDAO update(MarcaturaDAO object);
    
    /**
     *  Metodo per il recupero di un'entità che implementi l'interfaccia MarcaturaDAO.
     * 
     *  @param   id è la chiave, attraverso la quale ricercare l'entità 
     *           persistente associata.
     *  @return  Restituisce un riferimento all'entità cercata.
     *           Resituisce null qualora la ricerca si rivelasse improduttiva.
     *  @see     Storage.MarcaturaDAO
     */
    public MarcaturaDAO getById(String id);
    
    /**
     *  Metodo per il recupero di tutte le entità che implementano l'interfaccia MarcaturaDAO
     * 
     *  @return  Restituisce una lista di entità.
     *           Resituisce null qualora la ricerca si rivelasse improduttiva.
     *  @see     Storage.MarcaturaDAO
     *  @see     java.util.List
     */
    public List<MarcaturaDAO> getAll();
    
    /**
     * Metodo per la cancellazione di un'entità che implementi l'interfaccia MarcaturaDAO.
     * 
     * @param   object è l'istanza di una classe di cui si gestisce la persistenza.
     *          Rappresenta l'entità che s'intende rimuovere.
     * @see     Storage.MarcaturaDAO
     */
    public void delete(MarcaturaDAO object);
}
