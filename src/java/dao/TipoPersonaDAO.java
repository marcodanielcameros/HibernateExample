
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
 * @author marcocameros
 */
public class TipoPersonaDAO {
    Session session;
    
    public TipoPersonaDAO(){
        /**
         * Se Almacena la session en una variable del objeto PersonDAO
         */
        session=HibernateUtil.getLocalSession();
    }
    
    public  TipoPersona getTipoPersonaById(int id){
        /**
         * Retorna un objeto persona que tenga el id que mandamos en los parametros
         */
        return (TipoPersona)session.load(TipoPersona.class, id);
    }
    
    public List<TipoPersona>  getTipoPersonaByName(String nombre){
        /**
         * Almacena en la lista de tipo Persona llamada listaDePersonas todos los objetos que tengan el 
         * nombre de nuestro parametro
         */
        List<TipoPersona> listaDePersonas=(List<TipoPersona>)
                session.createCriteria(TipoPersona.class)
                .add(Restrictions.eq("Nombre", nombre));
        /**
         * Retorna la lista de personas.
         */
        return listaDePersonas;
    }
    
    public boolean updateById(int id,TipoPersona tipoPersona){
        /**
         * Inicializa un objeto Persona con el retorno del metodo 
         */
        TipoPersona tipoPersonaAModificar=getTipoPersonaById(id);
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
            tipoPersonaAModificar.setTipoPersona(tipoPersona.getTipoPersona());
            /*
            Se modifica actualiza la base de datos con mi objeto personaAModificar
            */
            session.update(tipoPersonaAModificar);
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
    
    public boolean saveTipoPersona(String nombre){
        /**
         * Crear un objeto tipo Persona vacio
         */
        TipoPersona tipoPersona=new TipoPersona();
        /**
         * Agregando los valores del objeto Persona
         */
        //Agrego el objeto tipo de persona a mi objeto persona
        tipoPersona.setTipoPersona(nombre);
        /*
        Intentara realizar cambios de no ser posible procedera con el catch
        */
        try{
            //Intentara iniciar una transaction de no ser posible procedera en el catch
            Transaction transaccion=session.beginTransaction();
            //Almacenara mi objeto personaDeTanque en la base de datos
            session.save(tipoPersona);
            //Actualizara a mis sessiones que la base de datos fue actualizada
            transaccion.commit();
            return true;
        }catch(Exception e){
            
        }finally{
            
        }
        return false;
    }
    
}
