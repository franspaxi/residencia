/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.servicio.inventario;

import java.util.List;
import pe.com.syscenterlife.modelo.GloSucursal;

/**
 *
 * @author TOSHIBA
 */
public interface SucursalServicioI {
    public List<GloSucursal> listarEntidad();
    public List<GloSucursal> listarEntidadDato(String dato);
    public GloSucursal buscarEntidadId(int id);
    public void guardarEntidad(GloSucursal sucursal);
    public void eliminarEntidad(int id);
    public void modificarEntidad(GloSucursal sucursal);
}
