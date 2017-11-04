/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *  #Pray4Tanque
 * @author RigoBono
 */
/**
 * Le dice a la maquina virtual de Java que sera una entidad de una base de datos
 * La tabla sera Tipo de persona y estara en la base de datos generationHibernate
 */
@Entity
@Table(name="TipoPersona", catalog="generationHibernate")
public class TipoPersona {
    
    /**
     * se le dice a la maquina Virtual de Java que sera una primary key 
     * y la columna sera idTipoPersona
     */
    @Id @GeneratedValue
    @Column(name="idTipoPersona")
    private int idTipoPersona;
    /**
     * La variable almacenara un valor de la columna TipoPersonacol
     */
     @Column(name="TipoPersonacol")
    private String TipoPersona;
     
     public TipoPersona(){
         
     }
     

    /**
     * @return the idTipoPersona
     */
    public int getIdTipoPersona() {
        return idTipoPersona;
    }

    /**
     * @param idTipoPersona the idTipoPersona to set
     */
    public void setIdTipoPersona(int idTipoPersona) {
        this.idTipoPersona = idTipoPersona;
    }

    /**
     * @return the TipoPersona
     */
    public String getTipoPersona() {
        return TipoPersona;
    }

    /**
     * @param TipoPersona the TipoPersona to set
     */
    public void setTipoPersona(String TipoPersona) {
        this.TipoPersona = TipoPersona;
    }
     
     
     
     
    
}
