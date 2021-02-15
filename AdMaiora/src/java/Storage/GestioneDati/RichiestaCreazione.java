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
import javax.persistence.JoinColumns;
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
@Table(name = "richiestacreazione")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RichiestaCreazione.findAll", query = "SELECT r FROM RichiestaCreazione r"),
    @NamedQuery(name = "RichiestaCreazione.findById", query = "SELECT r FROM RichiestaCreazione r WHERE r.id = :id"),
    @NamedQuery(name = "RichiestaCreazione.findByStato", query = "SELECT r FROM RichiestaCreazione r WHERE r.stato = :stato"),
    @NamedQuery(name = "RichiestaCreazione.findByTipo", query = "SELECT r FROM RichiestaCreazione r WHERE r.tipo = :tipo"),
    @NamedQuery(name = "RichiestaCreazione.findByMotivazione", query = "SELECT r FROM RichiestaCreazione r WHERE r.motivazione = :motivazione"),
    @NamedQuery(name = "RichiestaCreazione.findByNome", query = "SELECT r FROM RichiestaCreazione r WHERE r.nome = :nome"),
    @NamedQuery(name = "RichiestaCreazione.findByOggetto", query = "SELECT r FROM RichiestaCreazione r WHERE r.oggetto = :oggetto"),
    @NamedQuery(name = "RichiestaCreazione.findByDescrizione", query = "SELECT r FROM RichiestaCreazione r WHERE r.descrizione = :descrizione"),
    @NamedQuery(name = "RichiestaCreazione.findBySottocategoria", query = "SELECT r FROM RichiestaCreazione r WHERE r.sottocategoria = :sottocategoria"),
    @NamedQuery(name = "RichiestaCreazione.findByCategoria", query = "SELECT r FROM RichiestaCreazione r WHERE r.categoria = :categoria"),
    @NamedQuery(name = "RichiestaCreazione.findAllPending", query = "SELECT r FROM RichiestaCreazione r WHERE r.stato = 'PENDING'")
})

/**
 * 
 */
public class RichiestaCreazione implements Serializable, MarcaturaDAO {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "stato")
    private String stato;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tipo")
    private String tipo;
    @Size(max = 255)
    @Column(name = "motivazione")
    private String motivazione;
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
    @JoinColumns({
        @JoinColumn(name = "utente", referencedColumnName = "username"),
        @JoinColumn(name = "utente", referencedColumnName = "username")})
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private UtenteGenerico utenteGenerico;

    public RichiestaCreazione() {}  //COSTRUTTORE

    public RichiestaCreazione(Integer id) {this.id = id;}   //COSTRUTTORE
    
    public RichiestaCreazione(String nome, String oggetto, 
            String descrizione, String sottocategoria, String categoria) {
        this.nome = nome;
        this.oggetto = oggetto;
        this.descrizione = descrizione;
        this.sottocategoria = sottocategoria;
        this.categoria = categoria;
        this.tipo = "CREAZIONE";
        this.stato = "PENDING";
    }   //COSTRUTTORE

    public RichiestaCreazione(Integer id, String stato, String tipo, 
            String nome, String oggetto, String descrizione,
            String sottocategoria, String categoria) {
        this.id = id;
        this.stato = stato;
        this.tipo = tipo;
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

    public String getStato() {
        return stato;
    }   //GETTER
    public void setStato(String stato) {
        this.stato = stato;
    }   //SETTER

    public String getTipo() {
        return tipo;
    }   //GETTER
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }   //SETTER

    public String getMotivazione() {
        return motivazione;
    }   //GETTER
    public void setMotivazione(String motivazione) {
        this.motivazione = motivazione;
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

    public UtenteGenerico getUtenteGenerico() {
        return utenteGenerico;
    }   //GETTER
    public void setUtenteGenerico(UtenteGenerico utenteGenerico) {
        this.utenteGenerico = utenteGenerico;
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
        if (!(object instanceof RichiestaCreazione)) {
            return false;
        }
        RichiestaCreazione other = (RichiestaCreazione) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getClass().getName() + "[id=" + id + 
                ", stato=" + stato + ", tipo=" + tipo + 
                ", motivazione=" + motivazione + ", nome=" + nome + 
                ", oggetto=" + oggetto + "descrizione=" + descrizione + 
                ", sottocategoria=" + sottocategoria + ", categoria=" + categoria + 
                ", utenteGenerico=" + utenteGenerico + "]";
    }
}
