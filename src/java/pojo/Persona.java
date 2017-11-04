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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author RigoBono
 */
/**
 * Crea una clase le dice a la maquina virtual de java que sera una base de datos 
 * Table es para decirle a la maquina virtual que sera llamada Persona del catlogo generationHibernate.
 */
@Entity
@Table(name="Persona",catalog="generationHibernate")
public class Persona {
    /**
     * Le dice a la maquina virtual de Java que este valor sera nuestra llave primaria autoIncremental
     * La variable almacenara los valores de la columna idPersona.
     */
    @Id @GeneratedValue
    @Column(name="idPersona")
    private int idPersona;
    
    /**
     * Le dice a la maquina virtual de Java que la variable almacenara la columna Nombre y podra ser nulo.
     */
    @Column(name="Nombre",nullable=true)
    private String Nombre;
    
    @Column(name="Paterno")
    private String Paterno;
    
     @Column(name="Materno")
    private String Materno;
     
     @Column(name="Telefono")
    private String Telefono;
    
     /**
      * Le dice a la maquina Virtual de Java que el valor es una llave Foranea de muchos a uno 
      * la columna Foreign key sera idTipoPersona.
      */
     @ManyToOne
     @JoinColumn(name="idTipoPersona")
    private TipoPersona tipoPersona;

    /**
     * @return the idPersona
     */
    public int getIdPersona() {
        return idPersona;
    }

    /**
     * @param idPersona the idPersona to set
     */
    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return the Paterno
     */
    public String getPaterno() {
        return Paterno;
    }

    /**
     * @param Paterno the Paterno to set
     */
    public void setPaterno(String Paterno) {
        this.Paterno = Paterno;
    }

    /**
     * @return the Materno
     */
    public String getMaterno() {
        return Materno;
    }

    /**
     * @param Materno the Materno to set
     */
    public void setMaterno(String Materno) {
        this.Materno = Materno;
    }

    /**
     * @return the Telefono
     */
    public String getTelefono() {
        return Telefono;
    }

    /**
     * @param Telefono the Telefono to set
     */
    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    /**
     * @return the tipoPersona
     */
    public TipoPersona getTipoPersona() {
        return tipoPersona;
    }

    /**
     * @param tipoPersona the tipoPersona to set
     */
    public void setTipoPersona(TipoPersona tipoPersona) {
        this.tipoPersona = tipoPersona;
    }
     
     
    
}
