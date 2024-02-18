/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matricula.modelo;

import lista.DynamicList;

/**
 *
 * @author darwin
 */
public class Carrera {
    private String nombre;
    private String descripcion;
    private Integer duracionAnios;
    private Integer id;
    private DynamicList<Malla> mallas;

    public Carrera(String nombre, String descripcion, Integer duracionAnios, Integer id, DynamicList<Malla> listaMallas) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracionAnios = duracionAnios;
        this.id = id;
        this.mallas = listaMallas;
    }

    

    public Carrera() {
        this.nombre = null;
        this.duracionAnios = null;
        this.descripcion = null;
        this.id = null;
        this.mallas = null;
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

    public DynamicList<Malla> getMallas() {
        if (mallas == null){
            mallas = new DynamicList<Malla>();
        }
        return mallas;
    }

    public void setMallas(DynamicList<Malla> listaMallas) {
        this.mallas = listaMallas;
    }
    
    
    

    @Override
    public String toString() {
        return nombre;
    }
    public Boolean compare( Carrera p, String field, Integer type){
        switch (type) {
            case 0:
                if(field.equalsIgnoreCase("nombre")){
                    return nombre.compareTo(p.getNombre()) < 0;
                } else if(field.equalsIgnoreCase("descripcion")){
                    return descripcion.compareTo(p.getDescripcion()) < 0;
                }else if(field.equalsIgnoreCase("duracionAnios")){
                    return duracionAnios.compareTo(p.getDuracionAnios()) < 0;
                 }else if(field.equalsIgnoreCase("id")){
                    return id.compareTo(p.getId()) < 0;
                }
            case 1:
            if(field.equalsIgnoreCase("nombre")){
                    return nombre.compareTo(p.getNombre()) > 0;
                } else if(field.equalsIgnoreCase("descripcion")){
                    return descripcion.compareTo(p.getDescripcion()) > 0;
                }else if(field.equalsIgnoreCase("duracionAnios")){
                    return duracionAnios.compareTo(p.getDuracionAnios()) > 0;
                }else if(field.equalsIgnoreCase("id")){
                    return id.compareTo(p.getId()) > 0;
                }
            default:
                throw new AssertionError();
                
        }
     }

    
    
}
