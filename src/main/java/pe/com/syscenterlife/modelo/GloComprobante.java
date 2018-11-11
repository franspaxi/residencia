/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author TOSHIBA
 */
@Entity
@Table(name = "glo_comprobante", catalog = "sysventas", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GloComprobante.findAll", query = "SELECT g FROM GloComprobante g")
    , @NamedQuery(name = "GloComprobante.findByIdComprobante", query = "SELECT g FROM GloComprobante g WHERE g.idComprobante = :idComprobante")
    , @NamedQuery(name = "GloComprobante.findByNombre", query = "SELECT g FROM GloComprobante g WHERE g.nombre = :nombre")
    , @NamedQuery(name = "GloComprobante.findByCodigo", query = "SELECT g FROM GloComprobante g WHERE g.codigo = :codigo")
    , @NamedQuery(name = "GloComprobante.findByDescripcion", query = "SELECT g FROM GloComprobante g WHERE g.descripcion = :descripcion")
    , @NamedQuery(name = "GloComprobante.findByEstado", query = "SELECT g FROM GloComprobante g WHERE g.estado = :estado")})
public class GloComprobante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idComprobante", nullable = false)
    private Integer idComprobante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nombre", nullable = false, length = 60)
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "codigo", nullable = false, length = 6)
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descripcion", nullable = false, length = 100)
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "estado", nullable = false, length = 5)
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idComprobante")
    private Collection<VentVentas> ventVentasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idComprobante")
    private Collection<CompCompras> compComprasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idComprobante")
    private Collection<VentVentaServicio> ventVentaServicioCollection;

    public GloComprobante() {
    }

    public GloComprobante(Integer idComprobante) {
        this.idComprobante = idComprobante;
    }

    public GloComprobante(Integer idComprobante, String nombre, String codigo, String descripcion, String estado) {
        this.idComprobante = idComprobante;
        this.nombre = nombre;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Integer getIdComprobante() {
        return idComprobante;
    }

    public void setIdComprobante(Integer idComprobante) {
        this.idComprobante = idComprobante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<VentVentas> getVentVentasCollection() {
        return ventVentasCollection;
    }

    public void setVentVentasCollection(Collection<VentVentas> ventVentasCollection) {
        this.ventVentasCollection = ventVentasCollection;
    }

    @XmlTransient
    public Collection<CompCompras> getCompComprasCollection() {
        return compComprasCollection;
    }

    public void setCompComprasCollection(Collection<CompCompras> compComprasCollection) {
        this.compComprasCollection = compComprasCollection;
    }

    @XmlTransient
    public Collection<VentVentaServicio> getVentVentaServicioCollection() {
        return ventVentaServicioCollection;
    }

    public void setVentVentaServicioCollection(Collection<VentVentaServicio> ventVentaServicioCollection) {
        this.ventVentaServicioCollection = ventVentaServicioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComprobante != null ? idComprobante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GloComprobante)) {
            return false;
        }
        GloComprobante other = (GloComprobante) object;
        if ((this.idComprobante == null && other.idComprobante != null) || (this.idComprobante != null && !this.idComprobante.equals(other.idComprobante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.com.syscenterlife.modelo.GloComprobante[ idComprobante=" + idComprobante + " ]";
    }
    
}
