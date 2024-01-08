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

    public Boolean compare(Malla a, String field, Integer type) {
        // 0 menor  1 mayor 2 igual
        switch (type) {
            case 0:
                if (field.equalsIgnoreCase("id")) {
                    return id.intValue() < a.getId().intValue();
                }
            case 1:
                if (field.equalsIgnoreCase("id")) {
                    return id.intValue() > a.getId().intValue();
                }
            case 2:
                if (field.equalsIgnoreCase("id")) {
                    return id.intValue() == a.getId().intValue();
                }
            default:
                return null;
        }
    }

    public Boolean buscar(String texto, String field, Integer tipo) {
        // 0 igual  1 menor
        switch (tipo) {
            case 0:
                if (field.equalsIgnoreCase("id")) {
                    String idAuto = Integer.toString(id);
                    return idAuto.toLowerCase().equalsIgnoreCase(texto.toLowerCase());
                }
            case 1:
                if (field.equalsIgnoreCase("id")) {
                    String idAuto = Integer.toString(id);
                    return (idAuto.toLowerCase().compareTo(texto.toLowerCase())) > 0;
                }  
            default:
                return null;
        }
    }

}
