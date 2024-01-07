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
    
//      public Boolean compararDocente(Docente p, String campo, Integer tipo) {
//
//          switch (tipo) {
//            case 0:
//                return compararCampo(p, campo) < 0;
//            case 1:
//                return compararCampo(p, campo) > 0;
//            default:
//                throw new IllegalArgumentException("Tipo no válido");
//        }
//    }
//     public int compararCampo(Docente p, String campo) {
//        System.out.println("Prueba");
//        switch (campo) {
//            case "nombre":
//                    return nombre.compareTo(p.getNombre());
//            case "apellido":
//                    return apellido.compareTo(p.getApellido());
//            case "cedula":
//                    return cedula.compareTo(p.getCedula());
//            case "correo":
//                    return correo.compareTo(p.getCorreo());
//            case "edad":
//                    return edad.compareTo(p.getEdad());        
//            case "aniosExperiencia":
//                return aniosExperiencia.compareTo(p.getAniosExperiencia());
//            case "tituloProfesional":
//                return tituloProfesional.compareTo(p.getTituloProfesional());
//            default:
//                throw new IllegalArgumentException("Campo no válido");
//        }
//    }
     public Integer compare(Docente p, String field, Integer type) {
        // 0 menor, 1 mayor
        switch (type) {
            case 0:
                if (field.equalsIgnoreCase("apellido")) {
                    return apellido.compareTo(p.getApellido());
                } else if (field.equalsIgnoreCase("nombre")) {
                    return nombre.compareTo(p.getNombre());
                } else if (field.equalsIgnoreCase("cedula")) {
                    return cedula.compareTo(p.getCedula());
                } else if (field.equalsIgnoreCase("correo")) {
                    return correo.compareTo(p.getCorreo());
                } else if (field.equalsIgnoreCase("edad")) {
                    return edad.compareTo(p.getEdad());
                }else if (field.equalsIgnoreCase("tituloProfesional")) {
                    return tituloProfesional.compareTo(p.getTituloProfesional());
                }else if (field.equalsIgnoreCase("aniosExperiencia")) {
                    return aniosExperiencia.compareTo(p.getAniosExperiencia());
                }
            case 1:
                if (field.equalsIgnoreCase("apellido")) {
                    return p.getApellido().compareTo(apellido);
                } else if (field.equalsIgnoreCase("nombre")) {
                    return p.getNombre().compareTo(nombre);
                } else if (field.equalsIgnoreCase("cedula")) {
                    return p.getCedula().compareTo(cedula);
                } else if (field.equalsIgnoreCase("correo")) {
                    return p.getCorreo().compareTo(correo);
                } else if (field.equalsIgnoreCase("edad")) {
                    return p.getEdad().compareTo(edad);
                }else if (field.equalsIgnoreCase("tituloProfesional")) {
                    return p.getTituloProfesional().compareTo(tituloProfesional);
                } else if (field.equalsIgnoreCase("aniosExperiencia")) {
                    return p.getAniosExperiencia().compareTo(aniosExperiencia);
                }
            default:
                throw new AssertionError();
        }
     }
    @Override
    public String toString() {
        return "Docente{" + "tituloProfesional=" + tituloProfesional + ", aniosExperiencia=" + aniosExperiencia + '}';
    }

}
