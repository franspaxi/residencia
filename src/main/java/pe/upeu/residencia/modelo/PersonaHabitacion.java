/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.upeu.residencia.modelo;

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
@Table(name = "persona_habitacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PersonaHabitacion.findAll", query = "SELECT p FROM PersonaHabitacion p")
    , @NamedQuery(name = "PersonaHabitacion.findByIdPersonaHabitacion", query = "SELECT p FROM PersonaHabitacion p WHERE p.idPersonaHabitacion = :idPersonaHabitacion")
    , @NamedQuery(name = "PersonaHabitacion.findByEstado", query = "SELECT p FROM PersonaHabitacion p WHERE p.estado = :estado")})
public class PersonaHabitacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPersonaHabitacion")
    private Integer idPersonaHabitacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "estado")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersonaHabitacion")
    private Collection<CobroAlquiler> cobroAlquilerCollection;
    @JoinColumn(name = "id_habitaciones", referencedColumnName = "id_habitaciones")
    @ManyToOne(optional = false)
    private Habitaciones idHabitaciones;
    @JoinColumn(name = "idpersona", referencedColumnName = "idpersona")
    @ManyToOne(optional = false)
    private Persona idpersona;
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;

    public PersonaHabitacion() {
    }

    public PersonaHabitacion(Integer idPersonaHabitacion) {
        this.idPersonaHabitacion = idPersonaHabitacion;
    }

    public PersonaHabitacion(Integer idPersonaHabitacion, String estado) {
        this.idPersonaHabitacion = idPersonaHabitacion;
        this.estado = estado;
    }

    public Integer getIdPersonaHabitacion() {
        return idPersonaHabitacion;
    }

    public void setIdPersonaHabitacion(Integer idPersonaHabitacion) {
        this.idPersonaHabitacion = idPersonaHabitacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<CobroAlquiler> getCobroAlquilerCollection() {
        return cobroAlquilerCollection;
    }

    public void setCobroAlquilerCollection(Collection<CobroAlquiler> cobroAlquilerCollection) {
        this.cobroAlquilerCollection = cobroAlquilerCollection;
    }

    public Habitaciones getIdHabitaciones() {
        return idHabitaciones;
    }

    public void setIdHabitaciones(Habitaciones idHabitaciones) {
        this.idHabitaciones = idHabitaciones;
    }

    public Persona getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(Persona idpersona) {
        this.idpersona = idpersona;
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
        hash += (idPersonaHabitacion != null ? idPersonaHabitacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonaHabitacion)) {
            return false;
        }
        PersonaHabitacion other = (PersonaHabitacion) object;
        if ((this.idPersonaHabitacion == null && other.idPersonaHabitacion != null) || (this.idPersonaHabitacion != null && !this.idPersonaHabitacion.equals(other.idPersonaHabitacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.upeu.residencia.modelo.PersonaHabitacion[ idPersonaHabitacion=" + idPersonaHabitacion + " ]";
    }
    
}
