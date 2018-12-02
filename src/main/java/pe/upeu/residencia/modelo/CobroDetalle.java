/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.upeu.residencia.modelo;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TOSHIBA
 */
@Entity
@Table(name = "cobro_detalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CobroDetalle.findAll", query = "SELECT c FROM CobroDetalle c")
    , @NamedQuery(name = "CobroDetalle.findByIdCobroDetalle", query = "SELECT c FROM CobroDetalle c WHERE c.idCobroDetalle = :idCobroDetalle")
    , @NamedQuery(name = "CobroDetalle.findByImporteTotal", query = "SELECT c FROM CobroDetalle c WHERE c.importeTotal = :importeTotal")})
public class CobroDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCobroDetalle")
    private Integer idCobroDetalle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "importe_total")
    private double importeTotal;
    @JoinColumn(name = "idAperturaPeriodo", referencedColumnName = "idAperturaPeriodo")
    @ManyToOne(optional = false)
    private AperturaPeriodo idAperturaPeriodo;
    @JoinColumn(name = "idtotal", referencedColumnName = "idtotal")
    @ManyToOne(optional = false)
    private Cobro idtotal;
    @JoinColumn(name = "idVentaServicio", referencedColumnName = "idVentaServicio")
    @ManyToOne(optional = false)
    private VentServicio idVentaServicio;

    public CobroDetalle() {
    }

    public CobroDetalle(Integer idCobroDetalle) {
        this.idCobroDetalle = idCobroDetalle;
    }

    public CobroDetalle(Integer idCobroDetalle, double importeTotal) {
        this.idCobroDetalle = idCobroDetalle;
        this.importeTotal = importeTotal;
    }

    public Integer getIdCobroDetalle() {
        return idCobroDetalle;
    }

    public void setIdCobroDetalle(Integer idCobroDetalle) {
        this.idCobroDetalle = idCobroDetalle;
    }

    public double getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(double importeTotal) {
        this.importeTotal = importeTotal;
    }

    public AperturaPeriodo getIdAperturaPeriodo() {
        return idAperturaPeriodo;
    }

    public void setIdAperturaPeriodo(AperturaPeriodo idAperturaPeriodo) {
        this.idAperturaPeriodo = idAperturaPeriodo;
    }

    public Cobro getIdtotal() {
        return idtotal;
    }

    public void setIdtotal(Cobro idtotal) {
        this.idtotal = idtotal;
    }

    public VentServicio getIdVentaServicio() {
        return idVentaServicio;
    }

    public void setIdVentaServicio(VentServicio idVentaServicio) {
        this.idVentaServicio = idVentaServicio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCobroDetalle != null ? idCobroDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CobroDetalle)) {
            return false;
        }
        CobroDetalle other = (CobroDetalle) object;
        if ((this.idCobroDetalle == null && other.idCobroDetalle != null) || (this.idCobroDetalle != null && !this.idCobroDetalle.equals(other.idCobroDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.upeu.residencia.modelo.CobroDetalle[ idCobroDetalle=" + idCobroDetalle + " ]";
    }
    
}
