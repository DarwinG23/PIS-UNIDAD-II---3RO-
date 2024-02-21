/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelo;

/**
 *
 * @author Alexander
 */
public class Docente extends Persona{

    private Integer IdDocente;
//    private Persona DatosUsuarioDocente;
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
    

    public Integer compare(Docente p, String field, Integer type) {
        // 0 menor, 1 mayor
        switch (type) {
            case 0:
                if (field.equalsIgnoreCase("apellido")) {
                    return apellido.compareTo(getApellido());
                } 
                else if (field.equalsIgnoreCase("nombre")) {
                    return nombre.compareTo(getNombre());
                } 
                else if (field.equalsIgnoreCase("cedula")) {
                    return cedula.compareTo(getCedula());
                } 
                else if (field.equalsIgnoreCase("correo")) {
                    return correo.compareTo(getCorreo());
                }
                else if (field.equalsIgnoreCase("edad")) {
                    return edad.compareTo(getEdad());
                }
                else if (field.equalsIgnoreCase("tituloProfesional")) {
                    return tituloProfesional.compareTo(p.getTituloProfesional());
                } 
                else if (field.equalsIgnoreCase("aniosExperiencia")) {
                    return aniosExperiencia.compareTo(p.getAniosExperiencia());
                }
            case 1:
                if (field.equalsIgnoreCase("apellido")) {
                    return p.getApellido().compareTo(apellido);
                } 
                else if (field.equalsIgnoreCase("nombre")) {
                    return p.getNombre().compareTo(nombre);
                }
                else if (field.equalsIgnoreCase("cedula")) {
                    return p.getCedula().compareTo(cedula);
                }
                else if (field.equalsIgnoreCase("correo")) {
                    return p.getCorreo().compareTo(correo);
                }
                else if (field.equalsIgnoreCase("edad")) {
                    return p.getEdad().compareTo(edad);
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
        return nombre; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }



}
