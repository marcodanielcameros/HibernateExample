/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbm;

import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author RigoBono
 */
public class HibernateUtil {
    //Declara sessionFactory con la interfaz SessionFactory en cuanto se corre el programa y vive para siempre
    private static final SessionFactory sessionFactory;
    //Declara un objeto tipo ThreadLocal que sera nuestro hilo.
    private static final ThreadLocal localSession;
    
    //En este bloque se cree una sola vez y funciona para todos por igual.
    static {
        //Tratara de realizar el bloque de codigo de lo contrario se pasara al catch
        try {
           /**
            * Se crea un objeto config de la Clase Configuration
            */
           Configuration config = new Configuration();
           /**
            * El objeto se configura segun el archivo de hibernate.cfg.xml
            */
            config.configure("hibernate.cfg.xml");
            //Conforme a la configuracion nosotros creamos los registros y los protocolos a nuestra sesion 
            //es una pequeña mini base para almacenar todo lo que pasa por el protocolo
            //le da contexto al sessionFactory
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
            applySettings(config.getProperties());
            /**
            *Se almacena la configuracion 
            **/
            sessionFactory = config.buildSessionFactory(builder.build());
        }
        //Manejara el error 
        catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        //Se inicializa un hilo.
        localSession = new ThreadLocal();
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
     public static Session getLocalSession() {
         /**
          * guarda el hilo la session local
          */
        Session session = (Session) localSession.get();
            //Si la session es nula se crea una session
        if (session == null) {
            //Se abre una session
            session = sessionFactory.openSession();
            //Se ajusta la session
            localSession.set(session);
            //Imprime un mensaje para avisar que se creo una session
            System.out.println("\nsesion iniciada");
        }
        //Retorna la sessio
        return session;
    }
     
     public static void closeLocalSession() {
         /**
          * Retorna la session 
          */
        Session session = (Session) localSession.get();
        /**
         * Si la session no es nula entonces la cierra
         */
        if (session != null) session.close();
        //Destruye el objeto
        localSession.set(null);
        //Imprime un mensaje que la session se cerro
        System.out.println("sesion cerrada\n");
    }
}
