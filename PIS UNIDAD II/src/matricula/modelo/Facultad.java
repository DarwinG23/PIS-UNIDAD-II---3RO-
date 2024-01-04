/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matricula.modelo;

/**
 *
 * @author darwi
 */
public class Facultad {
    private String nombre;
    private Integer id;
    private String descripcion;
    private String ubicacion;
    private Integer numBloques;

    public Facultad(String nombre, Integer id, String descripcion, String ubicacion, Integer numBloques) {
        this.nombre = nombre;
        this.id = id;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.numBloques = numBloques;
    }

    public Facultad() {
        this.nombre = null;
        this.descripcion = null;
        this.id = null;
        this.numBloques = null;
        this.ubicacion = null;
        
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Integer getNumBloques() {
        return numBloques;
    }

    public void setNumBloques(Integer numBloques) {
        this.numBloques = numBloques;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    
    
    
    
}
