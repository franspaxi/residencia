/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.upeu.residencia.modelo;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author TOSHIBA
 */
@Entity
@Table(name = "cobro_alquiler")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CobroAlquiler.findAll", query = "SELECT c FROM CobroAlquiler c")
    , @NamedQuery(name = "CobroAlquiler.findByIdCobroAlquiler", query = "SELECT c FROM CobroAlquiler c WHERE c.idCobroAlquiler = :idCobroAlquiler")
    , @NamedQuery(name = "CobroAlquiler.findByImporteTotal", query = "SELECT c FROM CobroAlquiler c WHERE c.importeTotal = :importeTotal")})
public class CobroAlquiler implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCobroAlquiler")
    private Integer idCobroAlquiler;
    @Basic(optional = false)
    @NotNull
    @Column(name = "importe_total")
    private double importeTotal;
    @OneToMany(mappedBy = "idCobroAlquiler")
    private Collection<Cobro> cobroCollection;
    @JoinColumn(name = "idAperturaPeriodo", referencedColumnName = "idAperturaPeriodo")
    @ManyToOne(optional = false)
    private AperturaPeriodo idAperturaPeriodo;
    @JoinColumn(name = "idPersonaHabitacion", referencedColumnName = "idPersonaHabitacion")
    @ManyToOne(optional = false)
    private PersonaHabitacion idPersonaHabitacion;

    public CobroAlquiler() {
    }

    public CobroAlquiler(Integer idCobroAlquiler) {
        this.idCobroAlquiler = idCobroAlquiler;
    }

    public CobroAlquiler(Integer idCobroAlquiler, double importeTotal) {
        this.idCobroAlquiler = idCobroAlquiler;
        this.importeTotal = importeTotal;
    }

    public Integer getIdCobroAlquiler() {
        return idCobroAlquiler;
    }

    public void setIdCobroAlquiler(Integer idCobroAlquiler) {
        this.idCobroAlquiler = idCobroAlquiler;
    }

    public double getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(double importeTotal) {
        this.importeTotal = importeTotal;
    }

    @XmlTransient
    public Collection<Cobro> getCobroCollection() {
        return cobroCollection;
    }

    public void setCobroCollection(Collection<Cobro> cobroCollection) {
        this.cobroCollection = cobroCollection;
    }

    public AperturaPeriodo getIdAperturaPeriodo() {
        return idAperturaPeriodo;
    }

    public void setIdAperturaPeriodo(AperturaPeriodo idAperturaPeriodo) {
        this.idAperturaPeriodo = idAperturaPeriodo;
    }

    public PersonaHabitacion getIdPersonaHabitacion() {
        return idPersonaHabitacion;
    }

    public void setIdPersonaHabitacion(PersonaHabitacion idPersonaHabitacion) {
        this.idPersonaHabitacion = idPersonaHabitacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCobroAlquiler != null ? idCobroAlquiler.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CobroAlquiler)) {
            return false;
        }
        CobroAlquiler other = (CobroAlquiler) object;
        if ((this.idCobroAlquiler == null && other.idCobroAlquiler != null) || (this.idCobroAlquiler != null && !this.idCobroAlquiler.equals(other.idCobroAlquiler))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.upeu.residencia.modelo.CobroAlquiler[ idCobroAlquiler=" + idCobroAlquiler + " ]";
    }
    
}
