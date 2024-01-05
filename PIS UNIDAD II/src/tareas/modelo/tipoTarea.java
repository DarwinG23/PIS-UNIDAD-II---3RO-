/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tareas.modelo;

/**
 *
 * @author ALEJANDRO
 */
public class tipoTarea {
    private String nombre;
    private Integer Id;

    public tipoTarea(Integer Id,String nombre) {
        this.nombre = nombre;

        this.Id = Id;
    }
    public tipoTarea(){
        
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
     
    @Override
    public String toString() {
        return  nombre;
    }

    public int compareTo(tipoTarea other, String field) {
        switch (field.toLowerCase()) {
            case "nombre":
                // Comparar por nombre solo si los id_tarea son iguales
                if (this.nombre.equals(other.getNombre())) {
                    return this.nombre.compareTo(other.getNombre());
                } else {
                    // En caso de id_tarea diferentes, retornar la comparación de id_tarea
                    return this.nombre.compareTo(other.getNombre());
                }
            // Añadir más casos según tus necesidades
            default:
                throw new IllegalArgumentException("Campo no soportado: " + field);
        }
    }
        
    
    
}
