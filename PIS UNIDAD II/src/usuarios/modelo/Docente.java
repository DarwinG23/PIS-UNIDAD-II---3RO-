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
      public Boolean compararDocente(Docente p, String campo, Integer tipo) {

          switch (tipo) {
            case 0:
                return compararCampo(p, campo) < 0;
            case 1:
                return compararCampo(p, campo) > 0;
            default:
                throw new IllegalArgumentException("Tipo no válido");
        }
    }
     public int compararCampo(Docente p, String campo) {
        System.out.println("Prueba");
        switch (campo) {
            case "nombre":
                    return nombre.compareTo(p.getNombre());
            case "apellido":
                    return apellido.compareTo(p.getApellido());
            case "cedula":
                    return cedula.compareTo(p.getCedula());
            case "correo":
                    return correo.compareTo(p.getCorreo());
            case "edad":
                    return edad.compareTo(p.getEdad());        
            case "aniosExperiencia":
                return aniosExperiencia.compareTo(p.getAniosExperiencia());
            case "tituloProfesional":
                return tituloProfesional.compareTo(p.getTituloProfesional());
            default:
                throw new IllegalArgumentException("Campo no válido");
        }
    }

    @Override
    public String toString() {
        return "Docente{" + "tituloProfesional=" + tituloProfesional + ", aniosExperiencia=" + aniosExperiencia + '}';
    }

}
