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
@Table(name = "glo_area_usuario", catalog = "sysventas", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GloAreaUsuario.findAll", query = "SELECT g FROM GloAreaUsuario g")
    , @NamedQuery(name = "GloAreaUsuario.findByIdAreaUsuario", query = "SELECT g FROM GloAreaUsuario g WHERE g.idAreaUsuario = :idAreaUsuario")
    , @NamedQuery(name = "GloAreaUsuario.findByNombre", query = "SELECT g FROM GloAreaUsuario g WHERE g.nombre = :nombre")
    , @NamedQuery(name = "GloAreaUsuario.findByEstado", query = "SELECT g FROM GloAreaUsuario g WHERE g.estado = :estado")})
public class GloAreaUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAreaUsuario", nullable = false)
    private Integer idAreaUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nombre", nullable = false, length = 60)
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado", nullable = false)
    private int estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAreaUsuario")
    private Collection<GloUsuario> gloUsuarioCollection;

    public GloAreaUsuario() {
    }

    public GloAreaUsuario(Integer idAreaUsuario) {
        this.idAreaUsuario = idAreaUsuario;
    }

    public GloAreaUsuario(Integer idAreaUsuario, String nombre, int estado) {
        this.idAreaUsuario = idAreaUsuario;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Integer getIdAreaUsuario() {
        return idAreaUsuario;
    }

    public void setIdAreaUsuario(Integer idAreaUsuario) {
        this.idAreaUsuario = idAreaUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<GloUsuario> getGloUsuarioCollection() {
        return gloUsuarioCollection;
    }

    public void setGloUsuarioCollection(Collection<GloUsuario> gloUsuarioCollection) {
        this.gloUsuarioCollection = gloUsuarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAreaUsuario != null ? idAreaUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GloAreaUsuario)) {
            return false;
        }
        GloAreaUsuario other = (GloAreaUsuario) object;
        if ((this.idAreaUsuario == null && other.idAreaUsuario != null) || (this.idAreaUsuario != null && !this.idAreaUsuario.equals(other.idAreaUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.com.syscenterlife.modelo.GloAreaUsuario[ idAreaUsuario=" + idAreaUsuario + " ]";
    }
    
}
