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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "discussione")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Discussione.findAll", query = "SELECT d FROM Discussione d"),
    @NamedQuery(name = "Discussione.findById", query = "SELECT d FROM Discussione d WHERE d.id = :id"),
    @NamedQuery(name = "Discussione.findByMail", query = "SELECT d FROM Discussione d WHERE d.mail = :mail"),
    @NamedQuery(name = "Discussione.findByNome", query = "SELECT d FROM Discussione d WHERE d.nome = :nome"),
    @NamedQuery(name = "Discussione.findByOggetto", query = "SELECT d FROM Discussione d WHERE d.oggetto = :oggetto"),
    @NamedQuery(name = "Discussione.findByDescrizione", query = "SELECT d FROM Discussione d WHERE d.descrizione = :descrizione"),
    @NamedQuery(name = "Discussione.findBySottocategoria", query = "SELECT d FROM Discussione d WHERE d.sottocategoria = :sottocategoria"),
    @NamedQuery(name = "Discussione.findByCategoria", query = "SELECT d FROM Discussione d WHERE d.categoria = :categoria")
})
public class Discussione implements Serializable, MarcaturaDAO {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 30)
    @Column(name = "mail")
    private String mail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "oggetto")
    private String oggetto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "descrizione")
    private String descrizione;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "sottocategoria")
    private String sottocategoria;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "categoria")
    private String categoria;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "discussione", fetch = FetchType.LAZY)
    private List<Commento> commentoList;

    public Discussione() {} //COSTRUTTORE

    public Discussione(Integer id) {
        this.id = id;
    }   //COSTRUTTORE
    
    public Discussione(String mail, String nome, 
            String oggetto, String descrizione, 
            String sottocategoria, String categoria) {
        this.mail = mail;
        this.nome = nome;
        this.oggetto = oggetto;
        this.descrizione = descrizione;
        this.sottocategoria = sottocategoria;
        this.categoria = categoria;
    }   //COSTRUTTORE

    public Discussione(Integer id, 
            String nome, String oggetto, String descrizione, 
            String sottocategoria, String categoria) {
        this.id = id;
        this.nome = nome;
        this.oggetto = oggetto;
        this.descrizione = descrizione;
        this.sottocategoria = sottocategoria;
        this.categoria = categoria;
    }   //COSTRUTTORE

    public Integer getId() {
        return id;
    }   //GETTER
    public void setId(Integer id) {
        this.id = id;
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

    public String getOggetto() {
        return oggetto;
    }   //GETTER
    public void setOggetto(String oggetto) {
        this.oggetto = oggetto;
    }   //SETTER

    public String getDescrizione() {
        return descrizione;
    }   //GETTER
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }   //SETTER

    public String getSottocategoria() {
        return sottocategoria;
    }   //GETTER
    public void setSottocategoria(String sottocategoria) {
        this.sottocategoria = sottocategoria;
    }   //SETTER

    public String getCategoria() {
        return categoria;
    }   //GETTER
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }   //SETTER

    @XmlTransient
    public List<Commento> getCommentoList() {
        return commentoList;
    }   //GETTER
    public void setCommentoList(List<Commento> commentoList) {
        this.commentoList = commentoList;
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
        if (!(object instanceof Discussione)) {
            return false;
        }
        Discussione other = (Discussione) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getClass().getName() + "[id=" + id + ", mail=" + 
                ", nome=" + nome + ", oggetto=" + oggetto + 
                ", descrizione=" + descrizione + 
                ", sottocategoria=" + sottocategoria + 
                ", categoria=" + categoria + "]";
    }
    
}
