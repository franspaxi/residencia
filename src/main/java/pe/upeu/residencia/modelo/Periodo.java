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
@Table(name = "periodo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Periodo.findAll", query = "SELECT p FROM Periodo p")
    , @NamedQuery(name = "Periodo.findByIdPeriodo", query = "SELECT p FROM Periodo p WHERE p.idPeriodo = :idPeriodo")
    , @NamedQuery(name = "Periodo.findByNombre", query = "SELECT p FROM Periodo p WHERE p.nombre = :nombre")})
public class Periodo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPeriodo")
    private Integer idPeriodo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPeriodo")
    private Collection<AperturaPeriodo> aperturaPeriodoCollection;

    public Periodo() {
    }

    public Periodo(Integer idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public Periodo(Integer idPeriodo, String nombre) {
        this.idPeriodo = idPeriodo;
        this.nombre = nombre;
    }

    public Integer getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(Integer idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<AperturaPeriodo> getAperturaPeriodoCollection() {
        return aperturaPeriodoCollection;
    }

    public void setAperturaPeriodoCollection(Collection<AperturaPeriodo> aperturaPeriodoCollection) {
        this.aperturaPeriodoCollection = aperturaPeriodoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPeriodo != null ? idPeriodo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Periodo)) {
            return false;
        }
        Periodo other = (Periodo) object;
        if ((this.idPeriodo == null && other.idPeriodo != null) || (this.idPeriodo != null && !this.idPeriodo.equals(other.idPeriodo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.upeu.residencia.modelo.Periodo[ idPeriodo=" + idPeriodo + " ]";
    }
    
}
