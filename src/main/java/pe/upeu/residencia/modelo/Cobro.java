/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.upeu.residencia.modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author TOSHIBA
 */
@Entity
@Table(name = "cobro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cobro.findAll", query = "SELECT c FROM Cobro c")
    , @NamedQuery(name = "Cobro.findByIdtotal", query = "SELECT c FROM Cobro c WHERE c.idtotal = :idtotal")
    , @NamedQuery(name = "Cobro.findByPreciototal", query = "SELECT c FROM Cobro c WHERE c.preciototal = :preciototal")
    , @NamedQuery(name = "Cobro.findByFechaCobro", query = "SELECT c FROM Cobro c WHERE c.fechaCobro = :fechaCobro")})
public class Cobro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtotal")
    private Integer idtotal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "preciototal")
    private String preciototal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_cobro")
    @Temporal(TemporalType.DATE)
    private Date fechaCobro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtotal")
    private Collection<CobroDetalle> cobroDetalleCollection;
    @JoinColumn(name = "idAperturaPeriodo", referencedColumnName = "idAperturaPeriodo")
    @ManyToOne(optional = false)
    private AperturaPeriodo idAperturaPeriodo;
    @JoinColumn(name = "idCobroAlquiler", referencedColumnName = "idCobroAlquiler")
    @ManyToOne
    private CobroAlquiler idCobroAlquiler;
    @JoinColumn(name = "idpersona", referencedColumnName = "idpersona")
    @ManyToOne(optional = false)
    private Persona idpersona;
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;

    public Cobro() {
    }

    public Cobro(Integer idtotal) {
        this.idtotal = idtotal;
    }

    public Cobro(Integer idtotal, String preciototal, Date fechaCobro) {
        this.idtotal = idtotal;
        this.preciototal = preciototal;
        this.fechaCobro = fechaCobro;
    }

    public Integer getIdtotal() {
        return idtotal;
    }

    public void setIdtotal(Integer idtotal) {
        this.idtotal = idtotal;
    }

    public String getPreciototal() {
        return preciototal;
    }

    public void setPreciototal(String preciototal) {
        this.preciototal = preciototal;
    }

    public Date getFechaCobro() {
        return fechaCobro;
    }

    public void setFechaCobro(Date fechaCobro) {
        this.fechaCobro = fechaCobro;
    }

    @XmlTransient
    public Collection<CobroDetalle> getCobroDetalleCollection() {
        return cobroDetalleCollection;
    }

    public void setCobroDetalleCollection(Collection<CobroDetalle> cobroDetalleCollection) {
        this.cobroDetalleCollection = cobroDetalleCollection;
    }

    public AperturaPeriodo getIdAperturaPeriodo() {
        return idAperturaPeriodo;
    }

    public void setIdAperturaPeriodo(AperturaPeriodo idAperturaPeriodo) {
        this.idAperturaPeriodo = idAperturaPeriodo;
    }

    public CobroAlquiler getIdCobroAlquiler() {
        return idCobroAlquiler;
    }

    public void setIdCobroAlquiler(CobroAlquiler idCobroAlquiler) {
        this.idCobroAlquiler = idCobroAlquiler;
    }

    public Persona getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(Persona idpersona) {
        this.idpersona = idpersona;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtotal != null ? idtotal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cobro)) {
            return false;
        }
        Cobro other = (Cobro) object;
        if ((this.idtotal == null && other.idtotal != null) || (this.idtotal != null && !this.idtotal.equals(other.idtotal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.upeu.residencia.modelo.Cobro[ idtotal=" + idtotal + " ]";
    }
    
}
