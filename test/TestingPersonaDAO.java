/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.PersonaDAO;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pojo.Persona;

/**
 *
 * @author RigoBono
 */
public class TestingPersonaDAO {
    
    public TestingPersonaDAO() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }


     @Test
     public void hello() {
         PersonaDAO personita=new PersonaDAO();
         Persona personaProNuevoPablo=new Persona();
         //System.out.println(personita.getPersonaByName("marco"));
         //personaProNuevoPablo.setNombre("Marco");
         //personita.updateById(4, personaProNuevoPablo);
         System.out.println(personita.getPersonaByPhone("111"));
     }
}
