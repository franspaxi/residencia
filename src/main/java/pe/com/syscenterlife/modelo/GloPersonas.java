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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author TOSHIBA
 */
@Entity
@Table(name = "glo_personas", catalog = "sysventas", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"dni"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GloPersonas.findAll", query = "SELECT g FROM GloPersonas g")
    , @NamedQuery(name = "GloPersonas.findByIdPersona", query = "SELECT g FROM GloPersonas g WHERE g.idPersona = :idPersona")
    , @NamedQuery(name = "GloPersonas.findByNombre", query = "SELECT g FROM GloPersonas g WHERE g.nombre = :nombre")
    , @NamedQuery(name = "GloPersonas.findByNombre2", query = "SELECT g FROM GloPersonas g WHERE g.nombre2 = :nombre2")
    , @NamedQuery(name = "GloPersonas.findByApellPaterno", query = "SELECT g FROM GloPersonas g WHERE g.apellPaterno = :apellPaterno")
    , @NamedQuery(name = "GloPersonas.findByApellMaterno", query = "SELECT g FROM GloPersonas g WHERE g.apellMaterno = :apellMaterno")
    , @NamedQuery(name = "GloPersonas.findByDni", query = "SELECT g FROM GloPersonas g WHERE g.dni = :dni")
    , @NamedQuery(name = "GloPersonas.findByFechaNacimiento", query = "SELECT g FROM GloPersonas g WHERE g.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "GloPersonas.findBySexo", query = "SELECT g FROM GloPersonas g WHERE g.sexo = :sexo")
    , @NamedQuery(name = "GloPersonas.findByDireccion", query = "SELECT g FROM GloPersonas g WHERE g.direccion = :direccion")
    , @NamedQuery(name = "GloPersonas.findByCelular", query = "SELECT g FROM GloPersonas g WHERE g.celular = :celular")
    , @NamedQuery(name = "GloPersonas.findByUsuario", query = "SELECT g FROM GloPersonas g WHERE g.usuario = :usuario")
    , @NamedQuery(name = "GloPersonas.findByClave", query = "SELECT g FROM GloPersonas g WHERE g.clave = :clave")
    , @NamedQuery(name = "GloPersonas.findByEmail", query = "SELECT g FROM GloPersonas g WHERE g.email = :email")
    , @NamedQuery(name = "GloPersonas.findByIdioma", query = "SELECT g FROM GloPersonas g WHERE g.idioma = :idioma")})
public class GloPersonas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPersona", nullable = false)
    private Integer idPersona;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nombre", nullable = false, length = 60)
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nombre2", nullable = false, length = 30)
    private String nombre2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "apell_paterno", nullable = false, length = 60)
    private String apellPaterno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "apell_materno", nullable = false, length = 60)
    private String apellMaterno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "dni", nullable = false, length = 8)
    private String dni;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_nacimiento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "sexo", nullable = false, length = 1)
    private String sexo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "direccion", nullable = false, length = 100)
    private String direccion;
    @Size(max = 15)
    @Column(name = "celular", length = 15)
    private String celular;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "usuario", nullable = false, length = 30)
    private String usuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "clave", nullable = false, length = 80)
    private String clave;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "email", nullable = false, length = 80)
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "idioma", nullable = false, length = 20)
    private String idioma;
    @OneToMany(mappedBy = "idPersona")
    private Collection<CompProveedores> compProveedoresCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersona")
    private Collection<GloUsuario> gloUsuarioCollection;

    public GloPersonas() {
    }

    public GloPersonas(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public GloPersonas(Integer idPersona, String nombre, String nombre2, String apellPaterno, String apellMaterno, String dni, Date fechaNacimiento, String sexo, String direccion, String usuario, String clave, String email, String idioma) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.nombre2 = nombre2;
        this.apellPaterno = apellPaterno;
        this.apellMaterno = apellMaterno;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.direccion = direccion;
        this.usuario = usuario;
        this.clave = clave;
        this.email = email;
        this.idioma = idioma;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getApellPaterno() {
        return apellPaterno;
    }

    public void setApellPaterno(String apellPaterno) {
        this.apellPaterno = apellPaterno;
    }

    public String getApellMaterno() {
        return apellMaterno;
    }

    public void setApellMaterno(String apellMaterno) {
        this.apellMaterno = apellMaterno;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    @XmlTransient
    public Collection<CompProveedores> getCompProveedoresCollection() {
        return compProveedoresCollection;
    }

    public void setCompProveedoresCollection(Collection<CompProveedores> compProveedoresCollection) {
        this.compProveedoresCollection = compProveedoresCollection;
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
        hash += (idPersona != null ? idPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GloPersonas)) {
            return false;
        }
        GloPersonas other = (GloPersonas) object;
        if ((this.idPersona == null && other.idPersona != null) || (this.idPersona != null && !this.idPersona.equals(other.idPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.com.syscenterlife.modelo.GloPersonas[ idPersona=" + idPersona + " ]";
    }
    
}
