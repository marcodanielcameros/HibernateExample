/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import hbm.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import pojo.Persona;
import pojo.TipoPersona;

/**
 *
 * @author RigoBono
 */
public class PersonaDAO {
    Session session;
    
    public PersonaDAO(){
        /**
         * Se Almacena la session en una variable del objeto PersonDAO
         */
        session=HibernateUtil.getLocalSession();
    }
    
    public  Persona getPersonaById(int id){
        /**
         * Retorna un objeto persona que tenga el id que mandamos en los parametros
         */
        return (Persona)session.load(Persona.class, id);
    }
    
    public List<Persona>  getPersonaByName(String nombre){
        /**
         * Almacena en la lista de tipo Persona llamada listaDePersonas todos los objetos que tengan el 
         * nombre de nuestro parametro
         */
        List<Persona> listaDePersonas=(List<Persona>)
                session.createCriteria(Persona.class)
                .add(Restrictions.eq("Nombre", nombre)).list();
        /**
         * Retorna la lista de personas.
         */
        return listaDePersonas;
    }
        
    public  Persona getPersonaByPhone(String telefono){
        
         return (Persona)session.createCriteria(Persona.class)
                .add(Restrictions.eq("Telefono", telefono)).uniqueResult();
         
         
                
    }
    
    public  boolean isPhone(String telefono){
        

             
         try{
            Persona personita=(Persona)session.createCriteria(Persona.class)
                .add(Restrictions.eq("Telefono", telefono)).uniqueResult();
             
            return true;
         }catch(NullPointerException e){
             return false;
         }
         
                
    }
    
    public boolean updateById(int id,Persona persona){
        /**
         * Inicializa un objeto Persona con el retorno del metodo 
         */
        Persona personaAModificar=getPersonaById(id);
        /**
        * Intentara realizar un cambio en la base de no ser posible correra el catch
        **/
        try{
            /*
            Se inicializa tipo interface transaccion con el metodo de el hilo session.
            */
            Transaction transaccion=session.beginTransaction();
            /*
            Si es posible realizar el proceso anterior entonces procede modificando el objeto personaAModificar
            con los atributos de mi objeto de los parametros
            */
            personaAModificar.setNombre(persona.getNombre());
            /*
            Se modifica actualiza la base de datos con mi objeto personaAModificar
            */
            session.update(personaAModificar);
            /*
            Actualiza a todos mis objetos que tambien esten en proceso para que sepan que la persona se modifico
            */
            transaccion.commit();
            //Regresa true que significa que el proceso se realizo
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    public boolean savePersona(String nombre,String materno,String paterno,String telefono,int idTipoPersona){
        /**
         * Crear un objeto tipo Persona vacio
         */
        Persona personaDeTanque=new Persona();
        /**
         * Busca un objeto que tenga el idTipoPersona de la clase TipoPersona la convierte a un objeto 
         * Tipo Persona y la almacena en tipoDeTanque
         */
        TipoPersona tipoDeTanque = (TipoPersona) session.load(TipoPersona.class, idTipoPersona);
        /**
         * Agregando los valores del objeto Persona
         */
        personaDeTanque.setNombre(nombre);
        personaDeTanque.setMaterno(materno);
        personaDeTanque.setPaterno(paterno);
        personaDeTanque.setTelefono(telefono);
        //Agrego el objeto tipo de persona a mi objeto persona
        personaDeTanque.setTipoPersona(tipoDeTanque);
        /*
        Intentara realizar cambios de no ser posible procedera con el catch
        */
        try{
            //Intentara iniciar una transaction de no ser posible procedera en el catch
            Transaction transaccion=session.beginTransaction();
            //Almacenara mi objeto personaDeTanque en la base de datos
            session.save(personaDeTanque);
            //Actualizara a mis sessiones que la base de datos fue actualizada
            transaccion.commit();
            return true;
        }catch(Exception e){
            
        }finally{
            
        }
        return false;
    }
    
}
