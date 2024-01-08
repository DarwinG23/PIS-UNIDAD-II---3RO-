/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelo;

/**
 *
 * @author Alexander 
 */
public class Registro {
    private String nombre;
    private Integer id;
    private String usuario;
    private String contrasenia;

    public Registro(String nombre, String usuario, String contrasenia) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }
    
    public Registro() {
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
   

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @Override
    public String toString() {
        return "Registro{" + "nombre=" + nombre + ", usuario=" + usuario + ", contrasenia=" + contrasenia + '}';
    }

    
    
    
    
}
