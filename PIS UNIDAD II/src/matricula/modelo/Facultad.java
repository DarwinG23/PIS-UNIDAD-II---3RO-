/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matricula.modelo;

import lista.DynamicList;

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
    private DynamicList<Carrera> carreras;

    public Facultad(String nombre, Integer id, String descripcion, String ubicacion, Integer numBloques, DynamicList<Carrera> carreras) {
        this.nombre = nombre;
        this.id = id;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.numBloques = numBloques;
        this.carreras = carreras;
    }

    

    public Facultad() {
        this.nombre = null;
        this.descripcion = null;
        this.id = null;
        this.numBloques = null;
        this.ubicacion = null;
        this.carreras = null;
        
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

    public DynamicList<Carrera> getCarreras() {
        if(carreras == null){
            carreras = new DynamicList<Carrera>();
        }
        return carreras;
    }

    public void setCarreras(DynamicList<Carrera> carreras) {
        this.carreras = carreras;
    }
    
    

    @Override
    public String toString() {
        return nombre;
    }
    public Boolean compare( Facultad p, String field, Integer type){
        switch (type) {
            case 0:
                if(field.equalsIgnoreCase("nombre")){
                    return nombre.compareTo(p.getNombre()) < 0;
                } else if(field.equalsIgnoreCase("descripcion")){
                    return descripcion.compareTo(p.getDescripcion()) < 0;
                }else if(field.equalsIgnoreCase("ubicacion")){
                    return ubicacion.compareTo(p.getUbicacion()) < 0;
                 }else if(field.equalsIgnoreCase("numBloques")){
                    return numBloques.compareTo(p.getNumBloques()) < 0;
                 }else if(field.equalsIgnoreCase("id")){
                    return id.compareTo(p.getId()) < 0;
                }
            case 1:
            if(field.equalsIgnoreCase("nombre")){
                    return nombre.compareTo(p.getNombre()) > 0;
                } else if(field.equalsIgnoreCase("descripcion")){
                    return descripcion.compareTo(p.getDescripcion()) > 0;
                }else if(field.equalsIgnoreCase("ubicacion")){
                    return ubicacion.compareTo(p.getUbicacion()) > 0;
                }else if(field.equalsIgnoreCase("numBloques")){
                    return numBloques.compareTo(p.getNumBloques()) > 0;
                }else if(field.equalsIgnoreCase("id")){
                    return id.compareTo(p.getId()) > 0;
                }
            default:
                throw new AssertionError();
                
        }
     }  
    
}
