/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.upeu.residencia.modelo;

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
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByIdUsuario", query = "SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario")
    , @NamedQuery(name = "Usuario.findByFechaAcceso", query = "SELECT u FROM Usuario u WHERE u.fechaAcceso = :fechaAcceso")
    , @NamedQuery(name = "Usuario.findByFechaAlta", query = "SELECT u FROM Usuario u WHERE u.fechaAlta = :fechaAlta")
    , @NamedQuery(name = "Usuario.findByIp", query = "SELECT u FROM Usuario u WHERE u.ip = :ip")
    , @NamedQuery(name = "Usuario.findByEstado", query = "SELECT u FROM Usuario u WHERE u.estado = :estado")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idUsuario")
    private Integer idUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_acceso")
    @Temporal(TemporalType.DATE)
    private Date fechaAcceso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_alta")
    @Temporal(TemporalType.DATE)
    private Date fechaAlta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ip")
    private String ip;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private int estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private Collection<VentServicio> ventServicioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private Collection<SysPrivilegios> sysPrivilegiosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private Collection<Cobro> cobroCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private Collection<PersonaHabitacion> personaHabitacionCollection;
    @JoinColumn(name = "idCargo", referencedColumnName = "idCargo")
    @ManyToOne(optional = false)
    private Cargo idCargo;
    @JoinColumn(name = "idpersona", referencedColumnName = "idpersona")
    @ManyToOne(optional = false)
    private Persona idpersona;
    @JoinColumn(name = "idPerfil", referencedColumnName = "idPerfil")
    @ManyToOne(optional = false)
    private SysPerfiles idPerfil;

    public Usuario() {
    }

    public Usuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(Integer idUsuario, Date fechaAcceso, Date fechaAlta, String ip, int estado) {
        this.idUsuario = idUsuario;
        this.fechaAcceso = fechaAcceso;
        this.fechaAlta = fechaAlta;
        this.ip = ip;
        this.estado = estado;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Date getFechaAcceso() {
        return fechaAcceso;
    }

    public void setFechaAcceso(Date fechaAcceso) {
        this.fechaAcceso = fechaAcceso;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<VentServicio> getVentServicioCollection() {
        return ventServicioCollection;
    }

    public void setVentServicioCollection(Collection<VentServicio> ventServicioCollection) {
        this.ventServicioCollection = ventServicioCollection;
    }

    @XmlTransient
    public Collection<SysPrivilegios> getSysPrivilegiosCollection() {
        return sysPrivilegiosCollection;
    }

    public void setSysPrivilegiosCollection(Collection<SysPrivilegios> sysPrivilegiosCollection) {
        this.sysPrivilegiosCollection = sysPrivilegiosCollection;
    }

    @XmlTransient
    public Collection<Cobro> getCobroCollection() {
        return cobroCollection;
    }

    public void setCobroCollection(Collection<Cobro> cobroCollection) {
        this.cobroCollection = cobroCollection;
    }

    @XmlTransient
    public Collection<PersonaHabitacion> getPersonaHabitacionCollection() {
        return personaHabitacionCollection;
    }

    public void setPersonaHabitacionCollection(Collection<PersonaHabitacion> personaHabitacionCollection) {
        this.personaHabitacionCollection = personaHabitacionCollection;
    }

    public Cargo getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Cargo idCargo) {
        this.idCargo = idCargo;
    }

    public Persona getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(Persona idpersona) {
        this.idpersona = idpersona;
    }

    public SysPerfiles getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(SysPerfiles idPerfil) {
        this.idPerfil = idPerfil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.upeu.residencia.modelo.Usuario[ idUsuario=" + idUsuario + " ]";
    }
    
}
