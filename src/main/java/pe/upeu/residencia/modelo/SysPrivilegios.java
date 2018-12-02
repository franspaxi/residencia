/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.upeu.residencia.modelo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TOSHIBA
 */
@Entity
@Table(name = "sys_privilegios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SysPrivilegios.findAll", query = "SELECT s FROM SysPrivilegios s")
    , @NamedQuery(name = "SysPrivilegios.findByIdPrivilegios", query = "SELECT s FROM SysPrivilegios s WHERE s.idPrivilegios = :idPrivilegios")
    , @NamedQuery(name = "SysPrivilegios.findByFechaAlta", query = "SELECT s FROM SysPrivilegios s WHERE s.fechaAlta = :fechaAlta")
    , @NamedQuery(name = "SysPrivilegios.findByIp", query = "SELECT s FROM SysPrivilegios s WHERE s.ip = :ip")
    , @NamedQuery(name = "SysPrivilegios.findByEstado", query = "SELECT s FROM SysPrivilegios s WHERE s.estado = :estado")
    , @NamedQuery(name = "SysPrivilegios.findByIdPersonaUser", query = "SELECT s FROM SysPrivilegios s WHERE s.idPersonaUser = :idPersonaUser")})
public class SysPrivilegios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPrivilegios")
    private Integer idPrivilegios;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaAlta")
    @Temporal(TemporalType.DATE)
    private Date fechaAlta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ip")
    private String ip;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idPersonaUser")
    private int idPersonaUser;
    @JoinColumn(name = "idAccesos", referencedColumnName = "idAccesos")
    @ManyToOne(optional = false)
    private SysAccesos idAccesos;
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;

    public SysPrivilegios() {
    }

    public SysPrivilegios(Integer idPrivilegios) {
        this.idPrivilegios = idPrivilegios;
    }

    public SysPrivilegios(Integer idPrivilegios, Date fechaAlta, String ip, String estado, int idPersonaUser) {
        this.idPrivilegios = idPrivilegios;
        this.fechaAlta = fechaAlta;
        this.ip = ip;
        this.estado = estado;
        this.idPersonaUser = idPersonaUser;
    }

    public Integer getIdPrivilegios() {
        return idPrivilegios;
    }

    public void setIdPrivilegios(Integer idPrivilegios) {
        this.idPrivilegios = idPrivilegios;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdPersonaUser() {
        return idPersonaUser;
    }

    public void setIdPersonaUser(int idPersonaUser) {
        this.idPersonaUser = idPersonaUser;
    }

    public SysAccesos getIdAccesos() {
        return idAccesos;
    }

    public void setIdAccesos(SysAccesos idAccesos) {
        this.idAccesos = idAccesos;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrivilegios != null ? idPrivilegios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SysPrivilegios)) {
            return false;
        }
        SysPrivilegios other = (SysPrivilegios) object;
        if ((this.idPrivilegios == null && other.idPrivilegios != null) || (this.idPrivilegios != null && !this.idPrivilegios.equals(other.idPrivilegios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.upeu.residencia.modelo.SysPrivilegios[ idPrivilegios=" + idPrivilegios + " ]";
    }
    
}
