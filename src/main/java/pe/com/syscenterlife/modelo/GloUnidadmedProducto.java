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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TOSHIBA
 */
@Entity
@Table(name = "glo_unidadmed_producto", catalog = "sysventas", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GloUnidadmedProducto.findAll", query = "SELECT g FROM GloUnidadmedProducto g")
    , @NamedQuery(name = "GloUnidadmedProducto.findByIdUnidMedProducto", query = "SELECT g FROM GloUnidadmedProducto g WHERE g.idUnidMedProducto = :idUnidMedProducto")
    , @NamedQuery(name = "GloUnidadmedProducto.findByCantidad", query = "SELECT g FROM GloUnidadmedProducto g WHERE g.cantidad = :cantidad")
    , @NamedQuery(name = "GloUnidadmedProducto.findByOrden", query = "SELECT g FROM GloUnidadmedProducto g WHERE g.orden = :orden")
    , @NamedQuery(name = "GloUnidadmedProducto.findByUnidadmin", query = "SELECT g FROM GloUnidadmedProducto g WHERE g.unidadmin = :unidadmin")})
public class GloUnidadmedProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idUnidMedProducto", nullable = false)
    private Integer idUnidMedProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad", nullable = false)
    private double cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "orden", nullable = false)
    private int orden;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "unidadmin", nullable = false, length = 5)
    private String unidadmin;
    @JoinColumn(name = "idProducto", referencedColumnName = "idProducto", nullable = false)
    @ManyToOne(optional = false)
    private GloProductos idProducto;
    @JoinColumn(name = "idUnidadMedida", referencedColumnName = "idUnidadMedida", nullable = false)
    @ManyToOne(optional = false)
    private GloUnidadMedida idUnidadMedida;

    public GloUnidadmedProducto() {
    }

    public GloUnidadmedProducto(Integer idUnidMedProducto) {
        this.idUnidMedProducto = idUnidMedProducto;
    }

    public GloUnidadmedProducto(Integer idUnidMedProducto, double cantidad, int orden, String unidadmin) {
        this.idUnidMedProducto = idUnidMedProducto;
        this.cantidad = cantidad;
        this.orden = orden;
        this.unidadmin = unidadmin;
    }

    public Integer getIdUnidMedProducto() {
        return idUnidMedProducto;
    }

    public void setIdUnidMedProducto(Integer idUnidMedProducto) {
        this.idUnidMedProducto = idUnidMedProducto;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public String getUnidadmin() {
        return unidadmin;
    }

    public void setUnidadmin(String unidadmin) {
        this.unidadmin = unidadmin;
    }

    public GloProductos getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(GloProductos idProducto) {
        this.idProducto = idProducto;
    }

    public GloUnidadMedida getIdUnidadMedida() {
        return idUnidadMedida;
    }

    public void setIdUnidadMedida(GloUnidadMedida idUnidadMedida) {
        this.idUnidadMedida = idUnidadMedida;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUnidMedProducto != null ? idUnidMedProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GloUnidadmedProducto)) {
            return false;
        }
        GloUnidadmedProducto other = (GloUnidadmedProducto) object;
        if ((this.idUnidMedProducto == null && other.idUnidMedProducto != null) || (this.idUnidMedProducto != null && !this.idUnidMedProducto.equals(other.idUnidMedProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.com.syscenterlife.modelo.GloUnidadmedProducto[ idUnidMedProducto=" + idUnidMedProducto + " ]";
    }
    
}
