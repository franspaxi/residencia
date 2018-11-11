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
@Table(name = "comp_proveedores", catalog = "sysventas", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CompProveedores.findAll", query = "SELECT c FROM CompProveedores c")
    , @NamedQuery(name = "CompProveedores.findByIdProveedor", query = "SELECT c FROM CompProveedores c WHERE c.idProveedor = :idProveedor")
    , @NamedQuery(name = "CompProveedores.findByRazonsocial", query = "SELECT c FROM CompProveedores c WHERE c.razonsocial = :razonsocial")
    , @NamedQuery(name = "CompProveedores.findByRuc", query = "SELECT c FROM CompProveedores c WHERE c.ruc = :ruc")
    , @NamedQuery(name = "CompProveedores.findByDireccion", query = "SELECT c FROM CompProveedores c WHERE c.direccion = :direccion")
    , @NamedQuery(name = "CompProveedores.findByTelefono", query = "SELECT c FROM CompProveedores c WHERE c.telefono = :telefono")
    , @NamedQuery(name = "CompProveedores.findByCelular", query = "SELECT c FROM CompProveedores c WHERE c.celular = :celular")
    , @NamedQuery(name = "CompProveedores.findByEstado", query = "SELECT c FROM CompProveedores c WHERE c.estado = :estado")
    , @NamedQuery(name = "CompProveedores.findByDireccionFiscal", query = "SELECT c FROM CompProveedores c WHERE c.direccionFiscal = :direccionFiscal")})
public class CompProveedores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProveedor", nullable = false)
    private Integer idProveedor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "razonsocial", nullable = false, length = 150)
    private String razonsocial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "ruc", nullable = false, length = 12)
    private String ruc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "direccion", nullable = false, length = 100)
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "telefono", nullable = false, length = 15)
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "celular", nullable = false, length = 15)
    private String celular;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado", nullable = false)
    private int estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "direccion_fiscal", nullable = false, length = 80)
    private String direccionFiscal;
    @JoinColumn(name = "idCodigoPostal", referencedColumnName = "idCodigoPostal", nullable = false)
    @ManyToOne(optional = false)
    private GloCodigopostal idCodigoPostal;
    @JoinColumn(name = "idPersona", referencedColumnName = "idPersona")
    @ManyToOne
    private GloPersonas idPersona;
    @JoinColumn(name = "idTipoProveedor", referencedColumnName = "idTipoProveedor", nullable = false)
    @ManyToOne(optional = false)
    private CompTipoProveedor idTipoProveedor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProveedor")
    private Collection<CompCompras> compComprasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProveedor")
    private Collection<CompDespachos> compDespachosCollection;

    public CompProveedores() {
    }

    public CompProveedores(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public CompProveedores(Integer idProveedor, String razonsocial, String ruc, String direccion, String telefono, String celular, int estado, String direccionFiscal) {
        this.idProveedor = idProveedor;
        this.razonsocial = razonsocial;
        this.ruc = ruc;
        this.direccion = direccion;
        this.telefono = telefono;
        this.celular = celular;
        this.estado = estado;
        this.direccionFiscal = direccionFiscal;
    }

    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getRazonsocial() {
        return razonsocial;
    }

    public void setRazonsocial(String razonsocial) {
        this.razonsocial = razonsocial;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getDireccionFiscal() {
        return direccionFiscal;
    }

    public void setDireccionFiscal(String direccionFiscal) {
        this.direccionFiscal = direccionFiscal;
    }

    public GloCodigopostal getIdCodigoPostal() {
        return idCodigoPostal;
    }

    public void setIdCodigoPostal(GloCodigopostal idCodigoPostal) {
        this.idCodigoPostal = idCodigoPostal;
    }

    public GloPersonas getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(GloPersonas idPersona) {
        this.idPersona = idPersona;
    }

    public CompTipoProveedor getIdTipoProveedor() {
        return idTipoProveedor;
    }

    public void setIdTipoProveedor(CompTipoProveedor idTipoProveedor) {
        this.idTipoProveedor = idTipoProveedor;
    }

    @XmlTransient
    public Collection<CompCompras> getCompComprasCollection() {
        return compComprasCollection;
    }

    public void setCompComprasCollection(Collection<CompCompras> compComprasCollection) {
        this.compComprasCollection = compComprasCollection;
    }

    @XmlTransient
    public Collection<CompDespachos> getCompDespachosCollection() {
        return compDespachosCollection;
    }

    public void setCompDespachosCollection(Collection<CompDespachos> compDespachosCollection) {
        this.compDespachosCollection = compDespachosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProveedor != null ? idProveedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompProveedores)) {
            return false;
        }
        CompProveedores other = (CompProveedores) object;
        if ((this.idProveedor == null && other.idProveedor != null) || (this.idProveedor != null && !this.idProveedor.equals(other.idProveedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.com.syscenterlife.modelo.CompProveedores[ idProveedor=" + idProveedor + " ]";
    }
    
}
