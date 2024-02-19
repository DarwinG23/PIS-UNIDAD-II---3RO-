/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelo;

/**
 *
 * @author Alexander
 */
public class Docente {

    private Integer IdDocente;
    private Usuario DatosUsuarioDocente;
    private String tituloProfesional;
    private String aniosExperiencia;
    private String CorreoUsuario;
    private String ContraseniaUsuario;
    private String RolDocente;

    public Docente() {
        
    }

    public Integer getIdDocente() {
        return IdDocente;
    }

    public void setIdDocente(Integer IdDocente) {
        this.IdDocente = IdDocente;
    }

    public Usuario getDatosUsuarioDocente() {
        return DatosUsuarioDocente;
    }

    public void setDatosUsuarioDocente(Usuario DatosUsuarioDocente) {
        this.DatosUsuarioDocente = DatosUsuarioDocente;
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

    public String getCorreoUsuario() {
        return CorreoUsuario;
    }

    public void setCorreoUsuario(String CorreoUsuario) {
        this.CorreoUsuario = CorreoUsuario;
    }

    public String getContraseniaUsuario() {
        return ContraseniaUsuario;
    }

    public void setContraseniaUsuario(String ContraseniaUsuario) {
        this.ContraseniaUsuario = ContraseniaUsuario;
    }

    public String getRolDocente() {
        return RolDocente;
    }

    public void setRolDocente(String RolDocente) {
        this.RolDocente = RolDocente;
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
                    return DatosUsuarioDocente.apellido.compareTo(p.DatosUsuarioDocente.getApellido());
                } 
                else if (field.equalsIgnoreCase("nombre")) {
                    return DatosUsuarioDocente.nombre.compareTo(p.DatosUsuarioDocente.getNombre());
                } 
                else if (field.equalsIgnoreCase("cedula")) {
                    return DatosUsuarioDocente.cedula.compareTo(p.DatosUsuarioDocente.getCedula());
                } 
                else if (field.equalsIgnoreCase("correo")) {
                    return DatosUsuarioDocente.correo.compareTo(p.DatosUsuarioDocente.getCorreo());
                }
                else if (field.equalsIgnoreCase("edad")) {
                    return DatosUsuarioDocente.edad.compareTo(p.DatosUsuarioDocente.getEdad());
                }
                else if (field.equalsIgnoreCase("tituloProfesional")) {
                    return tituloProfesional.compareTo(p.getTituloProfesional());
                } 
                else if (field.equalsIgnoreCase("aniosExperiencia")) {
                    return aniosExperiencia.compareTo(p.getAniosExperiencia());
                }
            case 1:
                if (field.equalsIgnoreCase("apellido")) {
                    return p.DatosUsuarioDocente.getApellido().compareTo(DatosUsuarioDocente.apellido);
                } 
                else if (field.equalsIgnoreCase("nombre")) {
                    return p.DatosUsuarioDocente.getNombre().compareTo(DatosUsuarioDocente.nombre);
                }
                else if (field.equalsIgnoreCase("cedula")) {
                    return p.DatosUsuarioDocente.getCedula().compareTo(DatosUsuarioDocente.cedula);
                }
                else if (field.equalsIgnoreCase("correo")) {
                    return p.DatosUsuarioDocente.getCorreo().compareTo(DatosUsuarioDocente.correo);
                }
                else if (field.equalsIgnoreCase("edad")) {
                    return p.DatosUsuarioDocente.getEdad().compareTo(DatosUsuarioDocente.edad);
                } 
                else if (field.equalsIgnoreCase("tituloProfesional")) {
                    return p.getTituloProfesional().compareTo(tituloProfesional);
                } 
                else if (field.equalsIgnoreCase("aniosExperiencia")) {
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
