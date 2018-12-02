/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.upeu.residencia.servicio.persona;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.upeu.residencia.dao.persona.PersonaDaoI;
import pe.upeu.residencia.modelo.Persona;
/**
 *
 * @author TOSHIBA
 */
@Service
@Transactional
public class PersonaServicioImpl implements PersonaServicioI{
    
    @Autowired
    public PersonaDaoI daoI;    
    @Override
    public List<Persona> listarEntidad(){return daoI.listarEntidad();}
    @Override
    public List<Persona> listarEntidadDato(String dato){return daoI.listarEntidadDato(dato);}
    @Override
    public Persona buscarEntidadId(int id){return daoI.buscarEntidadId(id);}
    @Override
    public void guardarEntidad(Persona persona){daoI.guardarEntidad(persona);}
    @Override
    public void eliminarEntidad(int id){daoI.eliminarEntidad(id);}
    @Override
    public void modificarEntidad(Persona persona){daoI.modificarEntidad(persona);}
}
