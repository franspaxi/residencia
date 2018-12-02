/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.upeu.residencia.modelo;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author TOSHIBA
 */
@Entity
@Table(name = "apertura_periodo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AperturaPeriodo.findAll", query = "SELECT a FROM AperturaPeriodo a")
    , @NamedQuery(name = "AperturaPeriodo.findByIdAperturaPeriodo", query = "SELECT a FROM AperturaPeriodo a WHERE a.idAperturaPeriodo = :idAperturaPeriodo")
    , @NamedQuery(name = "AperturaPeriodo.findByNombreMes", query = "SELECT a FROM AperturaPeriodo a WHERE a.nombreMes = :nombreMes")
    , @NamedQuery(name = "AperturaPeriodo.findByEstado", query = "SELECT a FROM AperturaPeriodo a WHERE a.estado = :estado")})
public class AperturaPeriodo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAperturaPeriodo")
    private Integer idAperturaPeriodo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "nombre_mes")
    private String nombreMes;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "estado")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAperturaPeriodo")
    private Collection<VentServicio> ventServicioCollection;
    @JoinColumn(name = "idPeriodo", referencedColumnName = "idPeriodo")
    @ManyToOne(optional = false)
    private Periodo idPeriodo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAperturaPeriodo")
    private Collection<CobroDetalle> cobroDetalleCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAperturaPeriodo")
    private Collection<Cobro> cobroCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAperturaPeriodo")
    private Collection<CobroAlquiler> cobroAlquilerCollection;

    public AperturaPeriodo() {
    }

    public AperturaPeriodo(Integer idAperturaPeriodo) {
        this.idAperturaPeriodo = idAperturaPeriodo;
    }

    public AperturaPeriodo(Integer idAperturaPeriodo, String nombreMes, String estado) {
        this.idAperturaPeriodo = idAperturaPeriodo;
        this.nombreMes = nombreMes;
        this.estado = estado;
    }

    public Integer getIdAperturaPeriodo() {
        return idAperturaPeriodo;
    }

    public void setIdAperturaPeriodo(Integer idAperturaPeriodo) {
        this.idAperturaPeriodo = idAperturaPeriodo;
    }

    public String getNombreMes() {
        return nombreMes;
    }

    public void setNombreMes(String nombreMes) {
        this.nombreMes = nombreMes;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<VentServicio> getVentServicioCollection() {
        return ventServicioCollection;
    }

    public void setVentServicioCollection(Collection<VentServicio> ventServicioCollection) {
        this.ventServicioCollection = ventServicioCollection;
    }

    public Periodo getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(Periodo idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    @XmlTransient
    public Collection<CobroDetalle> getCobroDetalleCollection() {
        return cobroDetalleCollection;
    }

    public void setCobroDetalleCollection(Collection<CobroDetalle> cobroDetalleCollection) {
        this.cobroDetalleCollection = cobroDetalleCollection;
    }

    @XmlTransient
    public Collection<Cobro> getCobroCollection() {
        return cobroCollection;
    }

    public void setCobroCollection(Collection<Cobro> cobroCollection) {
        this.cobroCollection = cobroCollection;
    }

    @XmlTransient
    public Collection<CobroAlquiler> getCobroAlquilerCollection() {
        return cobroAlquilerCollection;
    }

    public void setCobroAlquilerCollection(Collection<CobroAlquiler> cobroAlquilerCollection) {
        this.cobroAlquilerCollection = cobroAlquilerCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAperturaPeriodo != null ? idAperturaPeriodo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AperturaPeriodo)) {
            return false;
        }
        AperturaPeriodo other = (AperturaPeriodo) object;
        if ((this.idAperturaPeriodo == null && other.idAperturaPeriodo != null) || (this.idAperturaPeriodo != null && !this.idAperturaPeriodo.equals(other.idAperturaPeriodo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.upeu.residencia.modelo.AperturaPeriodo[ idAperturaPeriodo=" + idAperturaPeriodo + " ]";
    }
    
}
