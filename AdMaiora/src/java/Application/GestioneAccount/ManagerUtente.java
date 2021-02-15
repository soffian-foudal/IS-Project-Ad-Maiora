/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application.GestioneAccount;

import Application.Manager;
import Storage.GestioneDati.UtenteGenerico;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.NoResultException;

/**
 *  Estensione della classe astratta Manager: definisce l'astrazione del
 *  concetto per oggetti di tipo UtenteGenerico. Eredita i comportamenti
 *  della classe padre, ridefinendoli all'occorrenza, e li estende con
 *  comportamenti applicabili esclusivamente a riferimenti di tipo
 *  UtenteGenerico.
 * 
 *  <pre>
 *      ManagerUtente managerUtente = new ManagerUtente();
 *  </pre>
 * 
 *  @author Davide Meriano
 *  @see    Application.InterfacciaDAO
 *  @see    Application.Manager
 *  @see    Storage.GestioneDati.UtenteGenerico
 */
public class ManagerUtente extends Manager<UtenteGenerico> {

    public ManagerUtente() {super();}   //COSTRUTTORE
    
    public UtenteGenerico create(String username, String passwd, String mail, String nome, String cognome) {
        if(null == username || null == passwd || null == mail || null == nome || null == cognome) return null;
        UtenteGenerico utente = new UtenteGenerico(username, passwd, mail, nome, cognome);
        if(mail.matches("[A-z]+@unisa\\.it")) utente.setRuolo("PROFESSORE");
        else if(mail.matches("[A-z]+@studenti\\.unisa\\.it")) utente.setRuolo("STUDENTE");
        else utente.setRuolo("MODERATORE");
        return create(utente);
    }
    
    /**
     *  @see Model.MarcaturaDAO
     *  @see Model.ControlloContenuti.UtenteGenerico
     */
    @Override
    public UtenteGenerico getById(String username) {
        try{
            return em.createNamedQuery("UtenteGenerico.findByUsername", UtenteGenerico.class).setParameter("username", username).getSingleResult();
        } catch(NoResultException nre) {
            Logger.getLogger(getClass().getName()).log(Level.WARNING, "@getById(String username): {0} has been caught...", nre.getClass().getName());
            return null;
        }
    }

    /**
     *  @see Model.MarcaturaDAO
     *  @see Model.ControlloContenuti.UtenteGenerico
     */
    @Override
    public List<UtenteGenerico> getAll() {
        return em.createNamedQuery("UtenteGenerico.findAll", UtenteGenerico.class).getResultList();
    }
    
    /**
     *  Metodo per l'autenticaizone di un account, associato ad un 
     *  UtenteGenerico, date le credenziali.
     * 
     *  @param username è il nome utente, che identifica univocamente l'account
     *                  di un utilizzatore del sistema.
     *  @param password è la stringa che, in combinazione con l'account,
     *                  garantisce l'autenticazione e l'accesso al sistema.
     *  @return         Un riferimento all'utente autenticato. Restituisce null
     *                  qualora non ci fosse alcun utente associato alla coppia
     *                  di credenziali.
     *  @see Storage.GestioneDati.UtenteGenerico
     */
    public UtenteGenerico login(String username, String password) {
        if(null == username) return null;
        UtenteGenerico utente = getById(username);
        return ((null != utente) && utente.getPasswd().equals(getMd5(password))) ? utente : null;
    }
    
    /**
     * Metodo per l'encrypt di una stringa utilizzando l'algoritmo MD5.
     * 
     * @param   input è la stringa che s'intende sottoporre a crittografia,
     *          attraverso l'algoritmo di cui sopra.
     * @return  Una stringa nella codifica specificata.
     */
    private static String getMd5(String input) { 
        try { 
            // Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5"); 
            
            // digest() method is called to calculate message digest 
            //  of an input digest() return array of byte 
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array into signum representation 
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }
        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
