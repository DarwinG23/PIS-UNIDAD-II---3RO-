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
    
    private String tituloProfesional;
    private String aniosExperiencia;

    public Docente(String tituloProfesional, String aniosExperiencia) {
        this.tituloProfesional = tituloProfesional;
        this.aniosExperiencia = aniosExperiencia;
    }
    public Docente() {
        this.tituloProfesional = null;
        this.aniosExperiencia = null;
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
     public Boolean comparar(Estudiante p, String campo, Integer tipo) {
        switch (tipo) {
            case 0:
                return compararCampo(p, campo) < 0;
            case 1:
                return compararCampo(p, campo) > 0;
            default:
                throw new IllegalArgumentException("Tipo no válido");
        }
    }
    public int compararCampo(Estudiante p, String campo) {
        switch (campo.toLowerCase()) {
            
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
            case "anios de experiencia":
                return cedula.compareTo(p.getCedula());
            case "titulo":
                return correo.compareTo(p.getCorreo());
            default:
                throw new IllegalArgumentException("Campo no válido");
        }
    }
    

    @Override
    public String toString() {
        return "Docente{" + "tituloProfesional=" + tituloProfesional + ", aniosExperiencia=" + aniosExperiencia + '}';
    }

    public boolean comparar(Docente t, String field, Integer tipo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getLength() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Object getInfo(int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
   
}
