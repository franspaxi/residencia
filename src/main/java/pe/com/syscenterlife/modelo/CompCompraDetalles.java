/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.modelo;

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
@Table(name = "comp_compra_detalles", catalog = "sysventas", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CompCompraDetalles.findAll", query = "SELECT c FROM CompCompraDetalles c")
    , @NamedQuery(name = "CompCompraDetalles.findByIdCompraDetalle", query = "SELECT c FROM CompCompraDetalles c WHERE c.idCompraDetalle = :idCompraDetalle")
    , @NamedQuery(name = "CompCompraDetalles.findByCantidad", query = "SELECT c FROM CompCompraDetalles c WHERE c.cantidad = :cantidad")
    , @NamedQuery(name = "CompCompraDetalles.findByPreciounit", query = "SELECT c FROM CompCompraDetalles c WHERE c.preciounit = :preciounit")
    , @NamedQuery(name = "CompCompraDetalles.findByIgv", query = "SELECT c FROM CompCompraDetalles c WHERE c.igv = :igv")
    , @NamedQuery(name = "CompCompraDetalles.findByImporte", query = "SELECT c FROM CompCompraDetalles c WHERE c.importe = :importe")
    , @NamedQuery(name = "CompCompraDetalles.findByEstado", query = "SELECT c FROM CompCompraDetalles c WHERE c.estado = :estado")})
public class CompCompraDetalles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCompraDetalle", nullable = false)
    private Integer idCompraDetalle;
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
    @Column(name = "igv", nullable = false)
    private double igv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "importe", nullable = false)
    private double importe;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado", nullable = false)
    private int estado;
    @JoinColumn(name = "idAlmacenProducto", referencedColumnName = "idAlmacenProducto", nullable = false)
    @ManyToOne(optional = false)
    private GloAlmacenProducto idAlmacenProducto;
    @JoinColumn(name = "id_mov_compra", referencedColumnName = "id_mov_compra", nullable = false)
    @ManyToOne(optional = false)
    private CompCompras idMovCompra;

    public CompCompraDetalles() {
    }

    public CompCompraDetalles(Integer idCompraDetalle) {
        this.idCompraDetalle = idCompraDetalle;
    }

    public CompCompraDetalles(Integer idCompraDetalle, double cantidad, double preciounit, double igv, double importe, int estado) {
        this.idCompraDetalle = idCompraDetalle;
        this.cantidad = cantidad;
        this.preciounit = preciounit;
        this.igv = igv;
        this.importe = importe;
        this.estado = estado;
    }

    public Integer getIdCompraDetalle() {
        return idCompraDetalle;
    }

    public void setIdCompraDetalle(Integer idCompraDetalle) {
        this.idCompraDetalle = idCompraDetalle;
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

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public GloAlmacenProducto getIdAlmacenProducto() {
        return idAlmacenProducto;
    }

    public void setIdAlmacenProducto(GloAlmacenProducto idAlmacenProducto) {
        this.idAlmacenProducto = idAlmacenProducto;
    }

    public CompCompras getIdMovCompra() {
        return idMovCompra;
    }

    public void setIdMovCompra(CompCompras idMovCompra) {
        this.idMovCompra = idMovCompra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCompraDetalle != null ? idCompraDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompCompraDetalles)) {
            return false;
        }
        CompCompraDetalles other = (CompCompraDetalles) object;
        if ((this.idCompraDetalle == null && other.idCompraDetalle != null) || (this.idCompraDetalle != null && !this.idCompraDetalle.equals(other.idCompraDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.com.syscenterlife.modelo.CompCompraDetalles[ idCompraDetalle=" + idCompraDetalle + " ]";
    }
    
}
