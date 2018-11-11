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
@Table(name = "glo_unidad_medida", catalog = "sysventas", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GloUnidadMedida.findAll", query = "SELECT g FROM GloUnidadMedida g")
    , @NamedQuery(name = "GloUnidadMedida.findByIdUnidadMedida", query = "SELECT g FROM GloUnidadMedida g WHERE g.idUnidadMedida = :idUnidadMedida")
    , @NamedQuery(name = "GloUnidadMedida.findByNombre", query = "SELECT g FROM GloUnidadMedida g WHERE g.nombre = :nombre")
    , @NamedQuery(name = "GloUnidadMedida.findBySimbolo", query = "SELECT g FROM GloUnidadMedida g WHERE g.simbolo = :simbolo")
    , @NamedQuery(name = "GloUnidadMedida.findByEstado", query = "SELECT g FROM GloUnidadMedida g WHERE g.estado = :estado")})
public class GloUnidadMedida implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idUnidadMedida", nullable = false)
    private Integer idUnidadMedida;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "simbolo", nullable = false, length = 4)
    private String simbolo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado", nullable = false)
    private int estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUnidadMedida")
    private Collection<GloUnidadmedManufact> gloUnidadmedManufactCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUnidadMedida")
    private Collection<GloUnidadmedProducto> gloUnidadmedProductoCollection;

    public GloUnidadMedida() {
    }

    public GloUnidadMedida(Integer idUnidadMedida) {
        this.idUnidadMedida = idUnidadMedida;
    }

    public GloUnidadMedida(Integer idUnidadMedida, String nombre, String simbolo, int estado) {
        this.idUnidadMedida = idUnidadMedida;
        this.nombre = nombre;
        this.simbolo = simbolo;
        this.estado = estado;
    }

    public Integer getIdUnidadMedida() {
        return idUnidadMedida;
    }

    public void setIdUnidadMedida(Integer idUnidadMedida) {
        this.idUnidadMedida = idUnidadMedida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<GloUnidadmedManufact> getGloUnidadmedManufactCollection() {
        return gloUnidadmedManufactCollection;
    }

    public void setGloUnidadmedManufactCollection(Collection<GloUnidadmedManufact> gloUnidadmedManufactCollection) {
        this.gloUnidadmedManufactCollection = gloUnidadmedManufactCollection;
    }

    @XmlTransient
    public Collection<GloUnidadmedProducto> getGloUnidadmedProductoCollection() {
        return gloUnidadmedProductoCollection;
    }

    public void setGloUnidadmedProductoCollection(Collection<GloUnidadmedProducto> gloUnidadmedProductoCollection) {
        this.gloUnidadmedProductoCollection = gloUnidadmedProductoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUnidadMedida != null ? idUnidadMedida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GloUnidadMedida)) {
            return false;
        }
        GloUnidadMedida other = (GloUnidadMedida) object;
        if ((this.idUnidadMedida == null && other.idUnidadMedida != null) || (this.idUnidadMedida != null && !this.idUnidadMedida.equals(other.idUnidadMedida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.com.syscenterlife.modelo.GloUnidadMedida[ idUnidadMedida=" + idUnidadMedida + " ]";
    }
    
}
