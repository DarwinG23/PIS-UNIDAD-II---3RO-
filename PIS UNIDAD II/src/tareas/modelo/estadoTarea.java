/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tareas.modelo;

/**
 *
 * @author ALEJANDRO
 */
public class estadoTarea {
    private String estado;
    private Integer Id;

    public estadoTarea(Integer Id,String estado) {
        this.estado = estado;

        this.Id = Id;
    }
    public estadoTarea(){
        
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }
   

    @Override
    public String toString() {
        return estado;
    }
      public int compareTo(estadoTarea other, String field) {
        switch (field.toLowerCase()) {
            case "estado":
                if (this.estado.equals(other.getEstado())) {
                    return this.estado.compareTo(other.getEstado());
                } else {
                    return this.estado.compareTo(other.getEstado());
                }
            default:
                throw new IllegalArgumentException("Campo no soportado: " + field);
        }
      }
    
}
