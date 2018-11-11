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
@Table(name = "cont_cuenta", catalog = "sysventas", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContCuenta.findAll", query = "SELECT c FROM ContCuenta c")
    , @NamedQuery(name = "ContCuenta.findByIdCuenta", query = "SELECT c FROM ContCuenta c WHERE c.idCuenta = :idCuenta")
    , @NamedQuery(name = "ContCuenta.findByCuenta", query = "SELECT c FROM ContCuenta c WHERE c.cuenta = :cuenta")
    , @NamedQuery(name = "ContCuenta.findByDescripcion", query = "SELECT c FROM ContCuenta c WHERE c.descripcion = :descripcion")
    , @NamedQuery(name = "ContCuenta.findByEstado", query = "SELECT c FROM ContCuenta c WHERE c.estado = :estado")})
public class ContCuenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCuenta", nullable = false)
    private Integer idCuenta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "cuenta", nullable = false, length = 12)
    private String cuenta;
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
    @JoinColumn(name = "idElemento", referencedColumnName = "idElemento", nullable = false)
    @ManyToOne(optional = false)
    private ContElemento idElemento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCuenta")
    private Collection<ContSubCuenta> contSubCuentaCollection;

    public ContCuenta() {
    }

    public ContCuenta(Integer idCuenta) {
        this.idCuenta = idCuenta;
    }

    public ContCuenta(Integer idCuenta, String cuenta, String descripcion, String estado) {
        this.idCuenta = idCuenta;
        this.cuenta = cuenta;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Integer getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Integer idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
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

    public ContElemento getIdElemento() {
        return idElemento;
    }

    public void setIdElemento(ContElemento idElemento) {
        this.idElemento = idElemento;
    }

    @XmlTransient
    public Collection<ContSubCuenta> getContSubCuentaCollection() {
        return contSubCuentaCollection;
    }

    public void setContSubCuentaCollection(Collection<ContSubCuenta> contSubCuentaCollection) {
        this.contSubCuentaCollection = contSubCuentaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCuenta != null ? idCuenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContCuenta)) {
            return false;
        }
        ContCuenta other = (ContCuenta) object;
        if ((this.idCuenta == null && other.idCuenta != null) || (this.idCuenta != null && !this.idCuenta.equals(other.idCuenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.com.syscenterlife.modelo.ContCuenta[ idCuenta=" + idCuenta + " ]";
    }
    
}
