/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.upeu.residencia.modelo;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TOSHIBA
 */
@Entity
@Table(name = "vent_detalle_servicio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VentDetalleServicio.findAll", query = "SELECT v FROM VentDetalleServicio v")
    , @NamedQuery(name = "VentDetalleServicio.findByIdDetalleServicio", query = "SELECT v FROM VentDetalleServicio v WHERE v.idDetalleServicio = :idDetalleServicio")
    , @NamedQuery(name = "VentDetalleServicio.findByCantidad", query = "SELECT v FROM VentDetalleServicio v WHERE v.cantidad = :cantidad")
    , @NamedQuery(name = "VentDetalleServicio.findByPrecioUnit", query = "SELECT v FROM VentDetalleServicio v WHERE v.precioUnit = :precioUnit")
    , @NamedQuery(name = "VentDetalleServicio.findByImporte", query = "SELECT v FROM VentDetalleServicio v WHERE v.importe = :importe")})
public class VentDetalleServicio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDetalleServicio")
    private Integer idDetalleServicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private double cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_unit")
    private double precioUnit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "importe")
    private double importe;
    @JoinColumn(name = "idServicio", referencedColumnName = "idServicio")
    @ManyToOne(optional = false)
    private Servicio idServicio;
    @JoinColumn(name = "idVentaServicio", referencedColumnName = "idVentaServicio")
    @ManyToOne(optional = false)
    private VentServicio idVentaServicio;

    public VentDetalleServicio() {
    }

    public VentDetalleServicio(Integer idDetalleServicio) {
        this.idDetalleServicio = idDetalleServicio;
    }

    public VentDetalleServicio(Integer idDetalleServicio, double cantidad, double precioUnit, double importe) {
        this.idDetalleServicio = idDetalleServicio;
        this.cantidad = cantidad;
        this.precioUnit = precioUnit;
        this.importe = importe;
    }

    public Integer getIdDetalleServicio() {
        return idDetalleServicio;
    }

    public void setIdDetalleServicio(Integer idDetalleServicio) {
        this.idDetalleServicio = idDetalleServicio;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnit() {
        return precioUnit;
    }

    public void setPrecioUnit(double precioUnit) {
        this.precioUnit = precioUnit;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public Servicio getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Servicio idServicio) {
        this.idServicio = idServicio;
    }

    public VentServicio getIdVentaServicio() {
        return idVentaServicio;
    }

    public void setIdVentaServicio(VentServicio idVentaServicio) {
        this.idVentaServicio = idVentaServicio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleServicio != null ? idDetalleServicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentDetalleServicio)) {
            return false;
        }
        VentDetalleServicio other = (VentDetalleServicio) object;
        if ((this.idDetalleServicio == null && other.idDetalleServicio != null) || (this.idDetalleServicio != null && !this.idDetalleServicio.equals(other.idDetalleServicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.upeu.residencia.modelo.VentDetalleServicio[ idDetalleServicio=" + idDetalleServicio + " ]";
    }
    
}
