/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelo;

/**
 *
 * @author Alexander
 */
public class Docente extends Usuario{
    public Docente(String nombre, String apellido, String edad, Integer id, String cedula, String correo) {
        super(nombre, apellido, edad, id, cedula, correo);
    }
    private String tituloProfesional;
    private String aniosExperiencia;

    public Docente(String tituloProfesional, String aniosExperiencia, String nombre, String apellido, String edad, Integer id, String cedula, String correo) {
        super(nombre, apellido, edad, id, cedula, correo);
        this.tituloProfesional = tituloProfesional;
        this.aniosExperiencia = aniosExperiencia;
    }

    public String getTituloProfesional() {
        return tituloProfesional;
    }

    public void setTituloProfesional(String tituloProfesional) {
        this.tituloProfesional = tituloProfesional;
    }

    public String getAniosExperiencia() {
        return aniosExperiencia;
    }

    public void setAniosExperiencia(String aniosExperiencia) {
        this.aniosExperiencia = aniosExperiencia;
    }

    @Override
    public String toString() {
        return "Docente{" + "tituloProfesional=" + tituloProfesional + ", aniosExperiencia=" + aniosExperiencia + '}';
    }
    
   
}
