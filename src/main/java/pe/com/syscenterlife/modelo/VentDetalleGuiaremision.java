/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TOSHIBA
 */
@Entity
@Table(name = "vent_detalle_guiaremision", catalog = "sysventas", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VentDetalleGuiaremision.findAll", query = "SELECT v FROM VentDetalleGuiaremision v")
    , @NamedQuery(name = "VentDetalleGuiaremision.findByIdDetalleguiaremision", query = "SELECT v FROM VentDetalleGuiaremision v WHERE v.idDetalleguiaremision = :idDetalleguiaremision")
    , @NamedQuery(name = "VentDetalleGuiaremision.findByIdVenta", query = "SELECT v FROM VentDetalleGuiaremision v WHERE v.idVenta = :idVenta")
    , @NamedQuery(name = "VentDetalleGuiaremision.findByIdArticulo", query = "SELECT v FROM VentDetalleGuiaremision v WHERE v.idArticulo = :idArticulo")
    , @NamedQuery(name = "VentDetalleGuiaremision.findByDc", query = "SELECT v FROM VentDetalleGuiaremision v WHERE v.dc = :dc")
    , @NamedQuery(name = "VentDetalleGuiaremision.findByDetalle", query = "SELECT v FROM VentDetalleGuiaremision v WHERE v.detalle = :detalle")
    , @NamedQuery(name = "VentDetalleGuiaremision.findByCantidad", query = "SELECT v FROM VentDetalleGuiaremision v WHERE v.cantidad = :cantidad")
    , @NamedQuery(name = "VentDetalleGuiaremision.findByPreciounit", query = "SELECT v FROM VentDetalleGuiaremision v WHERE v.preciounit = :preciounit")
    , @NamedQuery(name = "VentDetalleGuiaremision.findByBaseImp", query = "SELECT v FROM VentDetalleGuiaremision v WHERE v.baseImp = :baseImp")
    , @NamedQuery(name = "VentDetalleGuiaremision.findByIgv", query = "SELECT v FROM VentDetalleGuiaremision v WHERE v.igv = :igv")
    , @NamedQuery(name = "VentDetalleGuiaremision.findByImporte", query = "SELECT v FROM VentDetalleGuiaremision v WHERE v.importe = :importe")
    , @NamedQuery(name = "VentDetalleGuiaremision.findByExonerados", query = "SELECT v FROM VentDetalleGuiaremision v WHERE v.exonerados = :exonerados")
    , @NamedQuery(name = "VentDetalleGuiaremision.findByInafectos", query = "SELECT v FROM VentDetalleGuiaremision v WHERE v.inafectos = :inafectos")
    , @NamedQuery(name = "VentDetalleGuiaremision.findByImpuestoigv", query = "SELECT v FROM VentDetalleGuiaremision v WHERE v.impuestoigv = :impuestoigv")
    , @NamedQuery(name = "VentDetalleGuiaremision.findByFechaEntrega", query = "SELECT v FROM VentDetalleGuiaremision v WHERE v.fechaEntrega = :fechaEntrega")
    , @NamedQuery(name = "VentDetalleGuiaremision.findByIdTrabajador", query = "SELECT v FROM VentDetalleGuiaremision v WHERE v.idTrabajador = :idTrabajador")})
public class VentDetalleGuiaremision implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDetalleguiaremision", nullable = false)
    private Integer idDetalleguiaremision;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idVenta", nullable = false)
    private int idVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idArticulo", nullable = false)
    private int idArticulo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "dc", nullable = false, length = 2)
    private String dc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "detalle", nullable = false, length = 80)
    private String detalle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad", nullable = false)
    private double cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "preciounit", nullable = false)
    private double preciounit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "base_imp", nullable = false)
    private double baseImp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "igv", nullable = false)
    private double igv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "importe", nullable = false)
    private double importe;
    @Basic(optional = false)
    @NotNull
    @Column(name = "exonerados", nullable = false)
    private double exonerados;
    @Basic(optional = false)
    @NotNull
    @Column(name = "inafectos", nullable = false)
    private double inafectos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "impuestoigv", nullable = false)
    private double impuestoigv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_entrega", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaEntrega;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idTrabajador", nullable = false)
    private int idTrabajador;
    @JoinColumn(name = "idGuiaremision", referencedColumnName = "idGuiaremision", nullable = false)
    @ManyToOne(optional = false)
    private VentGuiaremision idGuiaremision;

    public VentDetalleGuiaremision() {
    }

    public VentDetalleGuiaremision(Integer idDetalleguiaremision) {
        this.idDetalleguiaremision = idDetalleguiaremision;
    }

    public VentDetalleGuiaremision(Integer idDetalleguiaremision, int idVenta, int idArticulo, String dc, String detalle, double cantidad, double preciounit, double baseImp, double igv, double importe, double exonerados, double inafectos, double impuestoigv, Date fechaEntrega, int idTrabajador) {
        this.idDetalleguiaremision = idDetalleguiaremision;
        this.idVenta = idVenta;
        this.idArticulo = idArticulo;
        this.dc = dc;
        this.detalle = detalle;
        this.cantidad = cantidad;
        this.preciounit = preciounit;
        this.baseImp = baseImp;
        this.igv = igv;
        this.importe = importe;
        this.exonerados = exonerados;
        this.inafectos = inafectos;
        this.impuestoigv = impuestoigv;
        this.fechaEntrega = fechaEntrega;
        this.idTrabajador = idTrabajador;
    }

    public Integer getIdDetalleguiaremision() {
        return idDetalleguiaremision;
    }

    public void setIdDetalleguiaremision(Integer idDetalleguiaremision) {
        this.idDetalleguiaremision = idDetalleguiaremision;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getDc() {
        return dc;
    }

    public void setDc(String dc) {
        this.dc = dc;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getPreciounit() {
        return preciounit;
    }

    public void setPreciounit(double preciounit) {
        this.preciounit = preciounit;
    }

    public double getBaseImp() {
        return baseImp;
    }

    public void setBaseImp(double baseImp) {
        this.baseImp = baseImp;
    }

    public double getIgv() {
        return igv;
    }

    public void setIgv(double igv) {
        this.igv = igv;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public double getExonerados() {
        return exonerados;
    }

    public void setExonerados(double exonerados) {
        this.exonerados = exonerados;
    }

    public double getInafectos() {
        return inafectos;
    }

    public void setInafectos(double inafectos) {
        this.inafectos = inafectos;
    }

    public double getImpuestoigv() {
        return impuestoigv;
    }

    public void setImpuestoigv(double impuestoigv) {
        this.impuestoigv = impuestoigv;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public int getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public VentGuiaremision getIdGuiaremision() {
        return idGuiaremision;
    }

    public void setIdGuiaremision(VentGuiaremision idGuiaremision) {
        this.idGuiaremision = idGuiaremision;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleguiaremision != null ? idDetalleguiaremision.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentDetalleGuiaremision)) {
            return false;
        }
        VentDetalleGuiaremision other = (VentDetalleGuiaremision) object;
        if ((this.idDetalleguiaremision == null && other.idDetalleguiaremision != null) || (this.idDetalleguiaremision != null && !this.idDetalleguiaremision.equals(other.idDetalleguiaremision))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.com.syscenterlife.modelo.VentDetalleGuiaremision[ idDetalleguiaremision=" + idDetalleguiaremision + " ]";
    }
    
}
