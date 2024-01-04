/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matricula.modelo;

/**
 *
 * @author darwin
 */
public class Malla {
    private String nombre;
    private Integer id;
    private Integer id_Carrera;

    public Malla(String nombre, Integer id, Integer id_Carrera) {
        this.nombre = nombre;
        this.id = id;
        this.id_Carrera = id_Carrera;
    }

    public Malla() {
        this.nombre = null;
        this.id = null;
        this.id_Carrera = null;
    }
    
    
    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_Carrera() {
        return id_Carrera;
    }

    public void setId_Carrera(Integer id_Carrera) {
        this.id_Carrera = id_Carrera;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    
    
    
    
    
    
}
