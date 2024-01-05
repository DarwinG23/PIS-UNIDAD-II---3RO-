/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.beans;

/**
 *
 * @author USUARIO
 */
public class Usuario {
    private String Usuario;
    private String Constrasenia;
    private String nombres;
    private String apellidos;
    private String correo;

    public Usuario(String Usuario, String Constrasenia, String nombres, String apellidos, String correo) {
        this.Usuario = Usuario;
        this.Constrasenia = Constrasenia;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getConstrasenia() {
        return Constrasenia;
    }

    public void setConstrasenia(String Constrasenia) {
        this.Constrasenia = Constrasenia;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
}
