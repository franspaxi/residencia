/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.dao.inventario;

import java.util.List;
import org.springframework.stereotype.Repository;
import pe.com.syscenterlife.SysDataAccess;
import pe.com.syscenterlife.modelo.GloSucursal;

/**
 *
 * @author TOSHIBA
 */
@Repository
public class SucursalDaoImpl extends SysDataAccess<Integer, GloSucursal> implements SucursalDaoI{
    @SuppressWarnings("unchecked")
    
        @Override
        public List<GloSucursal> listarEntidad(){return getListAll();}
        @Override
        public List<GloSucursal> listarEntidadDato(String dato){
        return (List<GloSucursal>)sessionFactory.getCurrentSession()
                .createQuery("SELECT px FROM GloSucursal px WHERE CONCAT(px.lugar,' ', px.direccion) LIKE ?1")
                .setParameter(1, "%"+dato+"%").list();
        }
        @Override
        public GloSucursal buscarEntidadId(int id){return getById(id);}
        @Override
        public void guardarEntidad(GloSucursal sucursal){savev(sucursal);}
        @Override
        public void eliminarEntidad(int id){delete(id);}
        @Override
        public void modificarEntidad(GloSucursal sucursal){update(sucursal);}
}
