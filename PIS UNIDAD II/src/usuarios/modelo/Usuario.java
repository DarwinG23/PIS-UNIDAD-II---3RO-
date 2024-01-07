/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelo;

/**
 *
 * @author Alexander
 */
public class Usuario {
    
    String nombre;
    String apellido;
    String edad;
    private Integer id;
    String cedula;
    String correo;

    public Usuario(String nombre, String apellido, String edad, Integer id, String cedula, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.id = id;
        this.cedula = cedula;
        this.correo = correo;
    }

    public Usuario() {
        this.nombre = null;
        this.apellido = null;
        this.edad = null;
        this.id = null;
        this.cedula = null;
        this.correo = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", id=" + id + ", cedula=" + cedula + ", correo=" + correo + '}';
    }
    public Boolean compararUsuario(Usuario p, String campo, Integer tipo) {

        switch (tipo) {
            case 0:
                return compararCampo(p, campo) < 0;
            case 1:
                return compararCampo(p, campo) > 0;
            default:
                throw new IllegalArgumentException("Tipo no válido");
        }
    }
    public int compararCampo(Usuario p, String campo) {

        switch (campo) {
            
            case "nombre":
                return nombre.compareTo(p.getNombre());
            case "apellido":
                return apellido.compareTo(p.getApellido());
            case "edad":
                return edad.compareTo(p.getEdad());
            case "cedula":
                return cedula.compareTo(p.getCedula());
            case "correo":
                return correo.compareTo(p.getCorreo());
 
            default:
                throw new IllegalArgumentException("Campo no válido");
        }
    }
    
    

    public Object getUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
