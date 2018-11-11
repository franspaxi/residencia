/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "aut_historial", catalog = "sysventas", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AutHistorial.findAll", query = "SELECT a FROM AutHistorial a")
    , @NamedQuery(name = "AutHistorial.findByIdHistorial", query = "SELECT a FROM AutHistorial a WHERE a.idHistorial = :idHistorial")
    , @NamedQuery(name = "AutHistorial.findByUsuario", query = "SELECT a FROM AutHistorial a WHERE a.usuario = :usuario")
    , @NamedQuery(name = "AutHistorial.findByPrograma", query = "SELECT a FROM AutHistorial a WHERE a.programa = :programa")
    , @NamedQuery(name = "AutHistorial.findByHora", query = "SELECT a FROM AutHistorial a WHERE a.hora = :hora")
    , @NamedQuery(name = "AutHistorial.findByFecha", query = "SELECT a FROM AutHistorial a WHERE a.fecha = :fecha")
    , @NamedQuery(name = "AutHistorial.findByIp", query = "SELECT a FROM AutHistorial a WHERE a.ip = :ip")
    , @NamedQuery(name = "AutHistorial.findByAccion", query = "SELECT a FROM AutHistorial a WHERE a.accion = :accion")})
public class AutHistorial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idHistorial", nullable = false)
    private Integer idHistorial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "usuario", nullable = false, length = 80)
    private String usuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "programa", nullable = false, length = 200)
    private String programa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hora", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date hora;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ip", nullable = false, length = 30)
    private String ip;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "accion", nullable = false, length = 2000)
    private String accion;

    public AutHistorial() {
    }

    public AutHistorial(Integer idHistorial) {
        this.idHistorial = idHistorial;
    }

    public AutHistorial(Integer idHistorial, String usuario, String programa, Date hora, Date fecha, String ip, String accion) {
        this.idHistorial = idHistorial;
        this.usuario = usuario;
        this.programa = programa;
        this.hora = hora;
        this.fecha = fecha;
        this.ip = ip;
        this.accion = accion;
    }

    public Integer getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(Integer idHistorial) {
        this.idHistorial = idHistorial;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHistorial != null ? idHistorial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AutHistorial)) {
            return false;
        }
        AutHistorial other = (AutHistorial) object;
        if ((this.idHistorial == null && other.idHistorial != null) || (this.idHistorial != null && !this.idHistorial.equals(other.idHistorial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.com.syscenterlife.modelo.AutHistorial[ idHistorial=" + idHistorial + " ]";
    }
    
}
