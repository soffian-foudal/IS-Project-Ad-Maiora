/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Storage.GestioneDati;

import Storage.MarcaturaDAO;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author utente
 */
@Entity
@Table(name = "utentegenerico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UtenteGenerico.findAll", query = "SELECT u FROM UtenteGenerico u"),
    @NamedQuery(name = "UtenteGenerico.findByUsername", query = "SELECT u FROM UtenteGenerico u WHERE u.username = :username"),
    @NamedQuery(name = "UtenteGenerico.findByPasswd", query = "SELECT u FROM UtenteGenerico u WHERE u.passwd = :passwd"),
    @NamedQuery(name = "UtenteGenerico.findByMail", query = "SELECT u FROM UtenteGenerico u WHERE u.mail = :mail"),
    @NamedQuery(name = "UtenteGenerico.findByNome", query = "SELECT u FROM UtenteGenerico u WHERE u.nome = :nome"),
    @NamedQuery(name = "UtenteGenerico.findByCognome", query = "SELECT u FROM UtenteGenerico u WHERE u.cognome = :cognome"),
    @NamedQuery(name = "UtenteGenerico.findByRuolo", query = "SELECT u FROM UtenteGenerico u WHERE u.ruolo = :ruolo")
})
public class UtenteGenerico implements Serializable, MarcaturaDAO {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "passwd")
    private String passwd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "mail")
    private String mail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "cognome")
    private String cognome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ruolo")
    private String ruolo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "utente", fetch = FetchType.LAZY)
    private List<Commento> commentoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "utenteGenerico")
    private List<RichiestaCreazione> richiestaCreazioneList;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "username")
    private String username;

    public UtenteGenerico() {}  //COSTRUTTORE

    public UtenteGenerico(String username) {                        
        this.username = username;
    }   //COSTRUTTORE
    
    public UtenteGenerico(String username, String passwd,
            String mail, String nome, String cognome) {
        this.username = username;
        this.passwd = passwd;
        this.mail = mail;
        this.nome = nome;
        this.cognome = cognome;
    }   //COSTRUTTORE

    public UtenteGenerico(String username, String passwd,
            String mail, String nome, String cognome, String ruolo) {
        this.username = username;
        this.passwd = passwd;
        this.mail = mail;
        this.nome = nome;
        this.cognome = cognome;
        this.ruolo = ruolo;
    }   //COSTRUTTORE

    public String getUsername() {
        return username;
    }   //GETTER
    public void setUsername(String username) {
        this.username = username;
    }   //SETTER
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UtenteGenerico)) {
            return false;
        }
        UtenteGenerico other = (UtenteGenerico) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return getClass().getName() + "[username=" + username +
                ", passwd=" + passwd + ", mail=" + mail +
                ", nome=" + nome + ", cognome=" + cognome +
                ", ruolo=" + ruolo + "]";
    }
    
    @XmlTransient
    public List<RichiestaCreazione> getRichiestaCreazioneList() {return richiestaCreazioneList;}
    public void setRichiestaCreazioneList(List<RichiestaCreazione> richiestaCreazioneList) {this.richiestaCreazioneList = richiestaCreazioneList;}

    public String getPasswd() {
        return passwd;
    }   //GETTER
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }   //SETTER

    public String getMail() {
        return mail;
    }   //GETTER
    public void setMail(String mail) {
        this.mail = mail;
    }   //SETTER

    public String getNome() {
        return nome;
    }   //GETTER
    public void setNome(String nome) {
        this.nome = nome;
    }   //SETTER

    public String getCognome() {
        return cognome;
    }   //GETTER
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }   //SETTER

    public String getRuolo() {
        return ruolo;
    }   //GETTER
    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }   //SETTER

    @XmlTransient
    public List<Commento> getCommentoList() {
        return commentoList;
    }   //GETTER
    public void setCommentoList(List<Commento> commentoList) {
        this.commentoList = commentoList;
    }   //SETTER
}
