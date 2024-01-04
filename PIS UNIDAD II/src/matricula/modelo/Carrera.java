/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matricula.modelo;

/**
 *
 * @author darwin
 */
public class Carrera {
    private String nombre;
    private String descripcion;
    private Integer duracionAnios;
    private Integer id;
    private Integer numCiclos;

    public Carrera(String nombre, String descripcion, Integer duracionAnios, Integer id, Integer numCiclos) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracionAnios = duracionAnios;
        this.id = id;
        this.numCiclos = numCiclos;
    }

    public Carrera() {
        this.nombre = null;
        this.duracionAnios = null;
        this.descripcion = null;
        this.id = null;
        this.numCiclos = null;
    }

    public Integer getNumCiclos() {
        return numCiclos;
    }

    public void setNumCiclos(Integer numCiclos) {
        this.numCiclos = numCiclos;
    }
    
    
    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getDuracionAnios() {
        return duracionAnios;
    }

    public void setDuracionAnios(Integer duracionAnios) {
        this.duracionAnios = duracionAnios;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    
    
}
