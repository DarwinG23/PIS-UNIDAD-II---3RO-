/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package materias.modelo;

/**
 *
 * @author elias
 */
public class Materia {
    private String nombre;
    private String paralelo;
    private String ciclo;
    private String id_Materia;
    private Integer id;

    public Materia(String nombre, String paralelo, String ciclo, String id_Materia, Integer id) {
        this.nombre = null;
        this.paralelo = null;
        this.ciclo = null;
        this.id_Materia = null;
        this.id = null;
    }

    public Materia() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getParalelo() {
        return paralelo;
    }

    public void setParalelo(String paralelo) {
        this.paralelo = paralelo;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public String getId_Materia() {
        return id_Materia;
    }

    public void setId_Materia(String id_Materia) {
        this.id_Materia = id_Materia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public Boolean compare( Materia p, String field, Integer type){
        switch (type) {
            case 0:
                if(field.equalsIgnoreCase("nombre")){
                    return nombre.compareTo(p.getNombre()) < 0;
                } else if(field.equalsIgnoreCase("paralelo")){
                    return paralelo.compareTo(p.getParalelo()) < 0;
                }else if(field.equalsIgnoreCase("ciclo")){
                    return ciclo.compareTo(p.getCiclo()) < 0;
                }else if(field.equalsIgnoreCase("id_Materia")){
                    return id_Materia.compareTo(p.getId_Materia()) < 0;
                }
            case 1:
            if(field.equalsIgnoreCase("nombre")){
                    return nombre.compareTo(p.getNombre()) > 0;
                } else if(field.equalsIgnoreCase("paralelo")){
                    return paralelo.compareTo(p.getParalelo()) > 0;
                }else if(field.equalsIgnoreCase("edad")){
                    return ciclo.compareTo(p.getCiclo()) > 0;
                }else if(field.equalsIgnoreCase("id_Materia")){
                    return id_Materia.compareTo(p.getId_Materia()) > 0;
                }
            default:
                throw new AssertionError();
                
        }
     }

    @Override
    public String toString() {
        return "Censador{" + "nombre=" + nombre + ", paralelo=" + paralelo + ", ciclo=" + ciclo+ "id_Materia=" + id_Materia + '}';
    }
     
}
    
