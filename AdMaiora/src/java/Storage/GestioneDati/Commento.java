/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Storage.GestioneDati;

import Storage.MarcaturaDAO;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author utente
 */
@Entity
@Table(name = "commento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Commento.findAll", query = "SELECT c FROM Commento c"),
    @NamedQuery(name = "Commento.findById", query = "SELECT c FROM Commento c WHERE c.id = :id"),
    @NamedQuery(name = "Commento.findByCorpo", query = "SELECT c FROM Commento c WHERE c.corpo = :corpo"),
    @NamedQuery(name = "Commento.findByStato", query = "SELECT c FROM Commento c WHERE c.stato = :stato"),
    @NamedQuery(name = "Commento.findByDiscussione", query = "SELECT c FROM Commento c JOIN c.discussione d WHERE c.stato = 'PUBLIC' AND d.id = :discussione")
})
public class Commento implements Serializable, MarcaturaDAO {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "corpo")
    private String corpo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "stato")
    private String stato;
    @JoinColumn(name = "discussione", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Discussione discussione;
    @JoinColumn(name = "utente", referencedColumnName = "username")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private UtenteGenerico utente;

    public Commento() {}    //COSTRUTTORE

    public Commento(Integer id) {
        this.id = id;
    }   //COSTRUTTORE
    
    public Commento(String corpo) {
        this.corpo = corpo;
        this.stato = "PUBLIC";
    }   //COSTRUTTORE

    public Commento(Integer id, String corpo, String stato) {
        this.id = id;
        this.corpo = corpo;
        this.stato = stato;
    }   //COSTRUTTORE

    public Integer getId() {
        return id;
    }   //GETTER
    public void setId(Integer id) {
        this.id = id;
    }   //SETTER

    public String getCorpo() {
        return corpo;
    }   //GETTER
    public void setCorpo(String corpo) {
        this.corpo = corpo;
    }   //SETTER

    public String getStato() {
        return stato;
    }   //GETTER
    public void setStato(String stato) {
        this.stato = stato;
    }   //SETTER

    public Discussione getDiscussione() {
        return discussione;
    }   //GETTER
    public void setDiscussione(Discussione discussione) {
        this.discussione = discussione;
    }   //SETTER

    public UtenteGenerico getUtente() {
        return utente;
    }   //GETTER
    public void setUtente(UtenteGenerico utente) {
        this.utente = utente;
    }   //SETTER

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Commento)) {
            return false;
        }
        Commento other = (Commento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getClass().getName() + "[id=" + id + 
                ", corpo=" + corpo + ", stato=" + stato +
                ", discussione=" + discussione + 
                ", utente=" + utente + "]";
    }
}
