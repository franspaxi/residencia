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
@Table(name = "vent_servicio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VentServicio.findAll", query = "SELECT v FROM VentServicio v")
    , @NamedQuery(name = "VentServicio.findByIdVentaServicio", query = "SELECT v FROM VentServicio v WHERE v.idVentaServicio = :idVentaServicio")
    , @NamedQuery(name = "VentServicio.findByImporte", query = "SELECT v FROM VentServicio v WHERE v.importe = :importe")
    , @NamedQuery(name = "VentServicio.findByFecha", query = "SELECT v FROM VentServicio v WHERE v.fecha = :fecha")
    , @NamedQuery(name = "VentServicio.findByObservacion", query = "SELECT v FROM VentServicio v WHERE v.observacion = :observacion")
    , @NamedQuery(name = "VentServicio.findByTipoPago", query = "SELECT v FROM VentServicio v WHERE v.tipoPago = :tipoPago")
    , @NamedQuery(name = "VentServicio.findByEstado", query = "SELECT v FROM VentServicio v WHERE v.estado = :estado")})
public class VentServicio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idVentaServicio")
    private Integer idVentaServicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "importe")
    private double importe;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "observacion")
    private String observacion;
    @Size(max = 10)
    @Column(name = "tipo_pago")
    private String tipoPago;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "estado")
    private String estado;
    @JoinColumn(name = "idAperturaPeriodo", referencedColumnName = "idAperturaPeriodo")
    @ManyToOne(optional = false)
    private AperturaPeriodo idAperturaPeriodo;
    @JoinColumn(name = "idpersona", referencedColumnName = "idpersona")
    @ManyToOne(optional = false)
    private Persona idpersona;
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVentaServicio")
    private Collection<CobroDetalle> cobroDetalleCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVentaServicio")
    private Collection<VentDetalleServicio> ventDetalleServicioCollection;

    public VentServicio() {
    }

    public VentServicio(Integer idVentaServicio) {
        this.idVentaServicio = idVentaServicio;
    }

    public VentServicio(Integer idVentaServicio, double importe, Date fecha, String observacion, String estado) {
        this.idVentaServicio = idVentaServicio;
        this.importe = importe;
        this.fecha = fecha;
        this.observacion = observacion;
        this.estado = estado;
    }

    public Integer getIdVentaServicio() {
        return idVentaServicio;
    }

    public void setIdVentaServicio(Integer idVentaServicio) {
        this.idVentaServicio = idVentaServicio;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public AperturaPeriodo getIdAperturaPeriodo() {
        return idAperturaPeriodo;
    }

    public void setIdAperturaPeriodo(AperturaPeriodo idAperturaPeriodo) {
        this.idAperturaPeriodo = idAperturaPeriodo;
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

    @XmlTransient
    public Collection<CobroDetalle> getCobroDetalleCollection() {
        return cobroDetalleCollection;
    }

    public void setCobroDetalleCollection(Collection<CobroDetalle> cobroDetalleCollection) {
        this.cobroDetalleCollection = cobroDetalleCollection;
    }

    @XmlTransient
    public Collection<VentDetalleServicio> getVentDetalleServicioCollection() {
        return ventDetalleServicioCollection;
    }

    public void setVentDetalleServicioCollection(Collection<VentDetalleServicio> ventDetalleServicioCollection) {
        this.ventDetalleServicioCollection = ventDetalleServicioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVentaServicio != null ? idVentaServicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentServicio)) {
            return false;
        }
        VentServicio other = (VentServicio) object;
        if ((this.idVentaServicio == null && other.idVentaServicio != null) || (this.idVentaServicio != null && !this.idVentaServicio.equals(other.idVentaServicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.upeu.residencia.modelo.VentServicio[ idVentaServicio=" + idVentaServicio + " ]";
    }
    
}
