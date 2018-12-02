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
@Table(name = "habitaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Habitaciones.findAll", query = "SELECT h FROM Habitaciones h")
    , @NamedQuery(name = "Habitaciones.findByIdHabitaciones", query = "SELECT h FROM Habitaciones h WHERE h.idHabitaciones = :idHabitaciones")
    , @NamedQuery(name = "Habitaciones.findByNombre", query = "SELECT h FROM Habitaciones h WHERE h.nombre = :nombre")
    , @NamedQuery(name = "Habitaciones.findByPrecio", query = "SELECT h FROM Habitaciones h WHERE h.precio = :precio")})
public class Habitaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_habitaciones")
    private Integer idHabitaciones;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private double precio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idHabitaciones")
    private Collection<PersonaHabitacion> personaHabitacionCollection;

    public Habitaciones() {
    }

    public Habitaciones(Integer idHabitaciones) {
        this.idHabitaciones = idHabitaciones;
    }

    public Habitaciones(Integer idHabitaciones, String nombre, double precio) {
        this.idHabitaciones = idHabitaciones;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Integer getIdHabitaciones() {
        return idHabitaciones;
    }

    public void setIdHabitaciones(Integer idHabitaciones) {
        this.idHabitaciones = idHabitaciones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @XmlTransient
    public Collection<PersonaHabitacion> getPersonaHabitacionCollection() {
        return personaHabitacionCollection;
    }

    public void setPersonaHabitacionCollection(Collection<PersonaHabitacion> personaHabitacionCollection) {
        this.personaHabitacionCollection = personaHabitacionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHabitaciones != null ? idHabitaciones.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Habitaciones)) {
            return false;
        }
        Habitaciones other = (Habitaciones) object;
        if ((this.idHabitaciones == null && other.idHabitaciones != null) || (this.idHabitaciones != null && !this.idHabitaciones.equals(other.idHabitaciones))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.upeu.residencia.modelo.Habitaciones[ idHabitaciones=" + idHabitaciones + " ]";
    }
    
}
