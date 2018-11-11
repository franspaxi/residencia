/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.dao.inventario;

import java.util.List;
import org.springframework.stereotype.Repository;
import pe.com.syscenterlife.SysDataAccess;
import pe.com.syscenterlife.modelo.GloAlmacen;

/**
 *
 * @author TOSHIBA
 */
@Repository
public class AlmacenDaoImpl extends SysDataAccess<Integer, GloAlmacen> implements AlmacenDaoI{
    @SuppressWarnings("unchecked")
    
        @Override
        public List<GloAlmacen> listarEntidad(){return getListAll();}
        @Override
        public List<GloAlmacen> listarEntidadDato(String dato){
        return (List<GloAlmacen>)sessionFactory.getCurrentSession()
                .createQuery("SELECT px FROM GloAlmacen px WHERE CONCAT(px.estado,' ', px.descripcion) LIKE ?1")
                .setParameter(1, "%"+dato+"%").list();
        }
        @Override
        public GloAlmacen buscarEntidadId(int id){return getById(id);}
        @Override
        public void guardarEntidad(GloAlmacen almacen){savev(almacen);}
        @Override
        public void eliminarEntidad(int id){delete(id);}
        @Override
        public void modificarEntidad(GloAlmacen almacen){update(almacen);}
}

