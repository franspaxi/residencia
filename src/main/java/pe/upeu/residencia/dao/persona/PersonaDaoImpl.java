/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.upeu.residencia.dao.persona;

import java.util.List;
import org.springframework.stereotype.Repository;
import pe.upeu.residencia.SysDataAccess;
import pe.upeu.residencia.modelo.Persona;
/**
 *
 * @author TOSHIBA
 */
@Repository
public class PersonaDaoImpl extends SysDataAccess<Integer, Persona> implements PersonaDaoI{
    @SuppressWarnings("unchecked")
    
        @Override
        public List<Persona> listarEntidad(){return getListAll();}
        @Override
        public List<Persona> listarEntidadDato(String dato){
        return (List<Persona>)sessionFactory.getCurrentSession()
                .createQuery("SELECT px FROM Persona px WHERE CONCAT(px.nombre,' ', px.dni) LIKE ?1")
                .setParameter(1, "%"+dato+"%").list();
        }
        @Override
        public Persona buscarEntidadId(int id){return getById(id);}
        @Override
        public void guardarEntidad(Persona persona){savev(persona);}
        @Override
        public void eliminarEntidad(int id){delete(id);}
        @Override
        public void modificarEntidad(Persona persona){update(persona);}
}
