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
@Table(name = "glo_categoria_producto", catalog = "sysventas", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GloCategoriaProducto.findAll", query = "SELECT g FROM GloCategoriaProducto g")
    , @NamedQuery(name = "GloCategoriaProducto.findByIdCategoria", query = "SELECT g FROM GloCategoriaProducto g WHERE g.idCategoria = :idCategoria")
    , @NamedQuery(name = "GloCategoriaProducto.findByNombre", query = "SELECT g FROM GloCategoriaProducto g WHERE g.nombre = :nombre")
    , @NamedQuery(name = "GloCategoriaProducto.findByDescripcion", query = "SELECT g FROM GloCategoriaProducto g WHERE g.descripcion = :descripcion")
    , @NamedQuery(name = "GloCategoriaProducto.findByEstado", query = "SELECT g FROM GloCategoriaProducto g WHERE g.estado = :estado")})
public class GloCategoriaProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCategoria", nullable = false)
    private Integer idCategoria;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nombre", nullable = false, length = 60)
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descripcion", nullable = false, length = 100)
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado", nullable = false)
    private int estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCategoria")
    private Collection<GloProductos> gloProductosCollection;

    public GloCategoriaProducto() {
    }

    public GloCategoriaProducto(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public GloCategoriaProducto(Integer idCategoria, String nombre, String descripcion, int estado) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<GloProductos> getGloProductosCollection() {
        return gloProductosCollection;
    }

    public void setGloProductosCollection(Collection<GloProductos> gloProductosCollection) {
        this.gloProductosCollection = gloProductosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCategoria != null ? idCategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GloCategoriaProducto)) {
            return false;
        }
        GloCategoriaProducto other = (GloCategoriaProducto) object;
        if ((this.idCategoria == null && other.idCategoria != null) || (this.idCategoria != null && !this.idCategoria.equals(other.idCategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.com.syscenterlife.modelo.GloCategoriaProducto[ idCategoria=" + idCategoria + " ]";
    }
    
}
