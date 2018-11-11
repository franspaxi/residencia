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
@Table(name = "vent_ventas", catalog = "sysventas", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VentVentas.findAll", query = "SELECT v FROM VentVentas v")
    , @NamedQuery(name = "VentVentas.findByIdMovVnt", query = "SELECT v FROM VentVentas v WHERE v.idMovVnt = :idMovVnt")
    , @NamedQuery(name = "VentVentas.findByIdVenta", query = "SELECT v FROM VentVentas v WHERE v.idVenta = :idVenta")
    , @NamedQuery(name = "VentVentas.findByTipoVenta", query = "SELECT v FROM VentVentas v WHERE v.tipoVenta = :tipoVenta")
    , @NamedQuery(name = "VentVentas.findByFechaVenta", query = "SELECT v FROM VentVentas v WHERE v.fechaVenta = :fechaVenta")
    , @NamedQuery(name = "VentVentas.findByFechaDoc", query = "SELECT v FROM VentVentas v WHERE v.fechaDoc = :fechaDoc")
    , @NamedQuery(name = "VentVentas.findByFechaVenc", query = "SELECT v FROM VentVentas v WHERE v.fechaVenc = :fechaVenc")
    , @NamedQuery(name = "VentVentas.findBySerie", query = "SELECT v FROM VentVentas v WHERE v.serie = :serie")
    , @NamedQuery(name = "VentVentas.findByNumvnt", query = "SELECT v FROM VentVentas v WHERE v.numvnt = :numvnt")
    , @NamedQuery(name = "VentVentas.findByExportImport", query = "SELECT v FROM VentVentas v WHERE v.exportImport = :exportImport")
    , @NamedQuery(name = "VentVentas.findByGlosa", query = "SELECT v FROM VentVentas v WHERE v.glosa = :glosa")
    , @NamedQuery(name = "VentVentas.findByBaseImp", query = "SELECT v FROM VentVentas v WHERE v.baseImp = :baseImp")
    , @NamedQuery(name = "VentVentas.findByIgv", query = "SELECT v FROM VentVentas v WHERE v.igv = :igv")
    , @NamedQuery(name = "VentVentas.findByExonerados", query = "SELECT v FROM VentVentas v WHERE v.exonerados = :exonerados")
    , @NamedQuery(name = "VentVentas.findByInafectos", query = "SELECT v FROM VentVentas v WHERE v.inafectos = :inafectos")
    , @NamedQuery(name = "VentVentas.findByIsc", query = "SELECT v FROM VentVentas v WHERE v.isc = :isc")
    , @NamedQuery(name = "VentVentas.findByImporte", query = "SELECT v FROM VentVentas v WHERE v.importe = :importe")
    , @NamedQuery(name = "VentVentas.findByDescuento", query = "SELECT v FROM VentVentas v WHERE v.descuento = :descuento")
    , @NamedQuery(name = "VentVentas.findByAnticipo", query = "SELECT v FROM VentVentas v WHERE v.anticipo = :anticipo")
    , @NamedQuery(name = "VentVentas.findBySaldo", query = "SELECT v FROM VentVentas v WHERE v.saldo = :saldo")
    , @NamedQuery(name = "VentVentas.findByTipoCambio", query = "SELECT v FROM VentVentas v WHERE v.tipoCambio = :tipoCambio")
    , @NamedQuery(name = "VentVentas.findByEstado", query = "SELECT v FROM VentVentas v WHERE v.estado = :estado")
    , @NamedQuery(name = "VentVentas.findByIp", query = "SELECT v FROM VentVentas v WHERE v.ip = :ip")
    , @NamedQuery(name = "VentVentas.findByModFecha", query = "SELECT v FROM VentVentas v WHERE v.modFecha = :modFecha")
    , @NamedQuery(name = "VentVentas.findByModTipo", query = "SELECT v FROM VentVentas v WHERE v.modTipo = :modTipo")
    , @NamedQuery(name = "VentVentas.findByModSerie", query = "SELECT v FROM VentVentas v WHERE v.modSerie = :modSerie")
    , @NamedQuery(name = "VentVentas.findByModNumdoc", query = "SELECT v FROM VentVentas v WHERE v.modNumdoc = :modNumdoc")
    , @NamedQuery(name = "VentVentas.findByComentario", query = "SELECT v FROM VentVentas v WHERE v.comentario = :comentario")
    , @NamedQuery(name = "VentVentas.findByObscredito", query = "SELECT v FROM VentVentas v WHERE v.obscredito = :obscredito")})
public class VentVentas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_mov_vnt", nullable = false)
    private Integer idMovVnt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idVenta", nullable = false)
    private int idVenta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "tipo_venta", nullable = false, length = 6)
    private String tipoVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_venta", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_doc", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaDoc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_venc", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVenc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "serie", nullable = false, length = 10)
    private String serie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "numvnt", nullable = false, length = 15)
    private String numvnt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "export_import", nullable = false)
    private double exportImport;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "glosa", nullable = false, length = 80)
    private String glosa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "base_imp", nullable = false)
    private double baseImp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "igv", nullable = false)
    private double igv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "exonerados", nullable = false)
    private double exonerados;
    @Basic(optional = false)
    @NotNull
    @Column(name = "inafectos", nullable = false)
    private double inafectos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isc", nullable = false)
    private double isc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "importe", nullable = false)
    private double importe;
    @Basic(optional = false)
    @NotNull
    @Column(name = "descuento", nullable = false)
    private double descuento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "anticipo", nullable = false)
    private double anticipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "saldo", nullable = false)
    private double saldo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo_cambio", nullable = false)
    private double tipoCambio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "estado", nullable = false, length = 5)
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ip", nullable = false, length = 30)
    private String ip;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mod_fecha", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modFecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "mod_tipo", nullable = false, length = 6)
    private String modTipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "mod_serie", nullable = false, length = 10)
    private String modSerie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "mod_numdoc", nullable = false, length = 10)
    private String modNumdoc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "comentario", nullable = false, length = 40)
    private String comentario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "obscredito", nullable = false, length = 40)
    private String obscredito;
    @JoinColumn(name = "idComprobante", referencedColumnName = "idComprobante", nullable = false)
    @ManyToOne(optional = false)
    private GloComprobante idComprobante;
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario", nullable = false)
    @ManyToOne(optional = false)
    private GloUsuario idUsuario;
    @JoinColumn(name = "idTipomoneda", referencedColumnName = "idTipomoneda", nullable = false)
    @ManyToOne(optional = false)
    private GloTipomoneda idTipomoneda;
    @JoinColumn(name = "idCliente", referencedColumnName = "idCliente", nullable = false)
    @ManyToOne(optional = false)
    private VentClientes idCliente;
    @JoinColumn(name = "idVoucher", referencedColumnName = "idVoucher", nullable = false)
    @ManyToOne(optional = false)
    private VentVoucher idVoucher;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMovVnt")
    private Collection<VentVentasDetalles> ventVentasDetallesCollection;

    public VentVentas() {
    }

    public VentVentas(Integer idMovVnt) {
        this.idMovVnt = idMovVnt;
    }

    public VentVentas(Integer idMovVnt, int idVenta, String tipoVenta, Date fechaVenta, Date fechaDoc, Date fechaVenc, String serie, String numvnt, double exportImport, String glosa, double baseImp, double igv, double exonerados, double inafectos, double isc, double importe, double descuento, double anticipo, double saldo, double tipoCambio, String estado, String ip, Date modFecha, String modTipo, String modSerie, String modNumdoc, String comentario, String obscredito) {
        this.idMovVnt = idMovVnt;
        this.idVenta = idVenta;
        this.tipoVenta = tipoVenta;
        this.fechaVenta = fechaVenta;
        this.fechaDoc = fechaDoc;
        this.fechaVenc = fechaVenc;
        this.serie = serie;
        this.numvnt = numvnt;
        this.exportImport = exportImport;
        this.glosa = glosa;
        this.baseImp = baseImp;
        this.igv = igv;
        this.exonerados = exonerados;
        this.inafectos = inafectos;
        this.isc = isc;
        this.importe = importe;
        this.descuento = descuento;
        this.anticipo = anticipo;
        this.saldo = saldo;
        this.tipoCambio = tipoCambio;
        this.estado = estado;
        this.ip = ip;
        this.modFecha = modFecha;
        this.modTipo = modTipo;
        this.modSerie = modSerie;
        this.modNumdoc = modNumdoc;
        this.comentario = comentario;
        this.obscredito = obscredito;
    }

    public Integer getIdMovVnt() {
        return idMovVnt;
    }

    public void setIdMovVnt(Integer idMovVnt) {
        this.idMovVnt = idMovVnt;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public String getTipoVenta() {
        return tipoVenta;
    }

    public void setTipoVenta(String tipoVenta) {
        this.tipoVenta = tipoVenta;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Date getFechaDoc() {
        return fechaDoc;
    }

    public void setFechaDoc(Date fechaDoc) {
        this.fechaDoc = fechaDoc;
    }

    public Date getFechaVenc() {
        return fechaVenc;
    }

    public void setFechaVenc(Date fechaVenc) {
        this.fechaVenc = fechaVenc;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getNumvnt() {
        return numvnt;
    }

    public void setNumvnt(String numvnt) {
        this.numvnt = numvnt;
    }

    public double getExportImport() {
        return exportImport;
    }

    public void setExportImport(double exportImport) {
        this.exportImport = exportImport;
    }

    public String getGlosa() {
        return glosa;
    }

    public void setGlosa(String glosa) {
        this.glosa = glosa;
    }

    public double getBaseImp() {
        return baseImp;
    }

    public void setBaseImp(double baseImp) {
        this.baseImp = baseImp;
    }

    public double getIgv() {
        return igv;
    }

    public void setIgv(double igv) {
        this.igv = igv;
    }

    public double getExonerados() {
        return exonerados;
    }

    public void setExonerados(double exonerados) {
        this.exonerados = exonerados;
    }

    public double getInafectos() {
        return inafectos;
    }

    public void setInafectos(double inafectos) {
        this.inafectos = inafectos;
    }

    public double getIsc() {
        return isc;
    }

    public void setIsc(double isc) {
        this.isc = isc;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getAnticipo() {
        return anticipo;
    }

    public void setAnticipo(double anticipo) {
        this.anticipo = anticipo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getTipoCambio() {
        return tipoCambio;
    }

    public void setTipoCambio(double tipoCambio) {
        this.tipoCambio = tipoCambio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getModFecha() {
        return modFecha;
    }

    public void setModFecha(Date modFecha) {
        this.modFecha = modFecha;
    }

    public String getModTipo() {
        return modTipo;
    }

    public void setModTipo(String modTipo) {
        this.modTipo = modTipo;
    }

    public String getModSerie() {
        return modSerie;
    }

    public void setModSerie(String modSerie) {
        this.modSerie = modSerie;
    }

    public String getModNumdoc() {
        return modNumdoc;
    }

    public void setModNumdoc(String modNumdoc) {
        this.modNumdoc = modNumdoc;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getObscredito() {
        return obscredito;
    }

    public void setObscredito(String obscredito) {
        this.obscredito = obscredito;
    }

    public GloComprobante getIdComprobante() {
        return idComprobante;
    }

    public void setIdComprobante(GloComprobante idComprobante) {
        this.idComprobante = idComprobante;
    }

    public GloUsuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(GloUsuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public GloTipomoneda getIdTipomoneda() {
        return idTipomoneda;
    }

    public void setIdTipomoneda(GloTipomoneda idTipomoneda) {
        this.idTipomoneda = idTipomoneda;
    }

    public VentClientes getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(VentClientes idCliente) {
        this.idCliente = idCliente;
    }

    public VentVoucher getIdVoucher() {
        return idVoucher;
    }

    public void setIdVoucher(VentVoucher idVoucher) {
        this.idVoucher = idVoucher;
    }

    @XmlTransient
    public Collection<VentVentasDetalles> getVentVentasDetallesCollection() {
        return ventVentasDetallesCollection;
    }

    public void setVentVentasDetallesCollection(Collection<VentVentasDetalles> ventVentasDetallesCollection) {
        this.ventVentasDetallesCollection = ventVentasDetallesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMovVnt != null ? idMovVnt.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentVentas)) {
            return false;
        }
        VentVentas other = (VentVentas) object;
        if ((this.idMovVnt == null && other.idMovVnt != null) || (this.idMovVnt != null && !this.idMovVnt.equals(other.idMovVnt))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.com.syscenterlife.modelo.VentVentas[ idMovVnt=" + idMovVnt + " ]";
    }
    
}
