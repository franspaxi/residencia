/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author TOSHIBA
 */
@Entity
@Table(name = "vent_clientes", catalog = "sysventas", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VentClientes.findAll", query = "SELECT v FROM VentClientes v")
    , @NamedQuery(name = "VentClientes.findByIdCliente", query = "SELECT v FROM VentClientes v WHERE v.idCliente = :idCliente")
    , @NamedQuery(name = "VentClientes.findByNombre", query = "SELECT v FROM VentClientes v WHERE v.nombre = :nombre")
    , @NamedQuery(name = "VentClientes.findByPaterno", query = "SELECT v FROM VentClientes v WHERE v.paterno = :paterno")
    , @NamedQuery(name = "VentClientes.findByMaterno", query = "SELECT v FROM VentClientes v WHERE v.materno = :materno")
    , @NamedQuery(name = "VentClientes.findByEstado", query = "SELECT v FROM VentClientes v WHERE v.estado = :estado")
    , @NamedQuery(name = "VentClientes.findByRuc", query = "SELECT v FROM VentClientes v WHERE v.ruc = :ruc")
    , @NamedQuery(name = "VentClientes.findByNumdocIdent", query = "SELECT v FROM VentClientes v WHERE v.numdocIdent = :numdocIdent")
    , @NamedQuery(name = "VentClientes.findByFechaNacimiento", query = "SELECT v FROM VentClientes v WHERE v.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "VentClientes.findByCelularcontacto", query = "SELECT v FROM VentClientes v WHERE v.celularcontacto = :celularcontacto")
    , @NamedQuery(name = "VentClientes.findByDireccionFiscal", query = "SELECT v FROM VentClientes v WHERE v.direccionFiscal = :direccionFiscal")
    , @NamedQuery(name = "VentClientes.findByDireccion", query = "SELECT v FROM VentClientes v WHERE v.direccion = :direccion")})
public class VentClientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCliente", nullable = false)
    private Integer idCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "nombre", nullable = false, length = 80)
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "paterno", nullable = false, length = 60)
    private String paterno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "materno", nullable = false, length = 60)
    private String materno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado", nullable = false)
    private int estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "ruc", nullable = false, length = 12)
    private String ruc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "numdoc_ident", nullable = false, length = 20)
    private String numdocIdent;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_nacimiento", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNacimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "celularcontacto", nullable = false, length = 10)
    private String celularcontacto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "direccion_fiscal", nullable = false, length = 80)
    private String direccionFiscal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "direccion", nullable = false, length = 100)
    private String direccion;
    @JoinColumn(name = "idCodigoPostal", referencedColumnName = "idCodigoPostal", nullable = false)
    @ManyToOne(optional = false)
    private GloCodigopostal idCodigoPostal;
    @JoinColumn(name = "idTipoCliente", referencedColumnName = "idTipoCliente", nullable = false)
    @ManyToOne(optional = false)
    private VentTipoCliente idTipoCliente;
    @JoinColumn(name = "idTipodocidentidad", referencedColumnName = "idTipodocidentidad", nullable = false)
    @ManyToOne(optional = false)
    private GloTipodocidentidad idTipodocidentidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCliente")
    private Collection<VentVentas> ventVentasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCliente")
    private Collection<VentDespachos> ventDespachosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCliente")
    private Collection<VentVentaServicio> ventVentaServicioCollection;

    public VentClientes() {
    }

    public VentClientes(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public VentClientes(Integer idCliente, String nombre, String paterno, String materno, int estado, String ruc, String numdocIdent, Date fechaNacimiento, String celularcontacto, String direccionFiscal, String direccion) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.estado = estado;
        this.ruc = ruc;
        this.numdocIdent = numdocIdent;
        this.fechaNacimiento = fechaNacimiento;
        this.celularcontacto = celularcontacto;
        this.direccionFiscal = direccionFiscal;
        this.direccion = direccion;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getNumdocIdent() {
        return numdocIdent;
    }

    public void setNumdocIdent(String numdocIdent) {
        this.numdocIdent = numdocIdent;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCelularcontacto() {
        return celularcontacto;
    }

    public void setCelularcontacto(String celularcontacto) {
        this.celularcontacto = celularcontacto;
    }

    public String getDireccionFiscal() {
        return direccionFiscal;
    }

    public void setDireccionFiscal(String direccionFiscal) {
        this.direccionFiscal = direccionFiscal;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public GloCodigopostal getIdCodigoPostal() {
        return idCodigoPostal;
    }

    public void setIdCodigoPostal(GloCodigopostal idCodigoPostal) {
        this.idCodigoPostal = idCodigoPostal;
    }

    public VentTipoCliente getIdTipoCliente() {
        return idTipoCliente;
    }

    public void setIdTipoCliente(VentTipoCliente idTipoCliente) {
        this.idTipoCliente = idTipoCliente;
    }

    public GloTipodocidentidad getIdTipodocidentidad() {
        return idTipodocidentidad;
    }

    public void setIdTipodocidentidad(GloTipodocidentidad idTipodocidentidad) {
        this.idTipodocidentidad = idTipodocidentidad;
    }

    @XmlTransient
    public Collection<VentVentas> getVentVentasCollection() {
        return ventVentasCollection;
    }

    public void setVentVentasCollection(Collection<VentVentas> ventVentasCollection) {
        this.ventVentasCollection = ventVentasCollection;
    }

    @XmlTransient
    public Collection<VentDespachos> getVentDespachosCollection() {
        return ventDespachosCollection;
    }

    public void setVentDespachosCollection(Collection<VentDespachos> ventDespachosCollection) {
        this.ventDespachosCollection = ventDespachosCollection;
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
        hash += (idCliente != null ? idCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentClientes)) {
            return false;
        }
        VentClientes other = (VentClientes) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.com.syscenterlife.modelo.VentClientes[ idCliente=" + idCliente + " ]";
    }
    
}
