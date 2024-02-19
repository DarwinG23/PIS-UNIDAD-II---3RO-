/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelo;

import lista.DynamicList;
import matricula.modelo.Matricula;

/**
 *
 * @author Alexander
 */
public class Estudiante {
    
    private Integer idEstudiante;
    private Usuario DatosUsuario;
    private String CorreoUsuario;
    private String ContraseniaUsuario;
    private String promedioAcademico;
    private DynamicList<Matricula> matriculas;

    public Estudiante() {
        
    }

    public Estudiante(Integer idEstudiante, Usuario DatosUsuario, String CorreoUsuario, String ContraseniaUsuario, String promedioAcademico, DynamicList<Matricula> matriculas) {
        this.idEstudiante = idEstudiante;
        this.DatosUsuario = DatosUsuario;
        this.CorreoUsuario = CorreoUsuario;
        this.ContraseniaUsuario = ContraseniaUsuario;
        this.promedioAcademico = promedioAcademico;
        this.matriculas = matriculas;
    }
    
    

    public Integer getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Integer idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public Usuario getDatosUsuario() {
        return DatosUsuario;
    }

    public void setDatosUsuario(Usuario DatosUsuario) {
        this.DatosUsuario = DatosUsuario;
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

    public String getPromedioAcademico() {
        return promedioAcademico;
    }

    public void setPromedioAcademico(String promedioAcademico) {
        this.promedioAcademico = promedioAcademico;
    }

    public DynamicList<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(DynamicList<Matricula> matriculas) {
        this.matriculas = matriculas;
    }
    
    

    public Integer compare(Estudiante p, String field, Integer Orden) {
        // 0 menor, 1 mayor
        switch (Orden) {
            
            case 0:
                if (field.equalsIgnoreCase("apellido")) {
                    return DatosUsuario.getApellido().compareTo(p.getDatosUsuario().getApellido());
                } 
                else if (field.equalsIgnoreCase("nombre")) {
                    return DatosUsuario.getNombre().compareTo(p.getDatosUsuario().getNombre());
                } 
                else if (field.equalsIgnoreCase("cedula")) {
                    return DatosUsuario.getCedula().compareTo(p.getDatosUsuario().getCedula());
                } 
                else if (field.equalsIgnoreCase("correo")) {
                    return DatosUsuario.getCorreo().compareTo(p.getDatosUsuario().getCorreo());
                }
                else if (field.equalsIgnoreCase("edad")) {
                    return DatosUsuario.getEdad().compareTo(p.getDatosUsuario().getEdad());
                }
                else if (field.equalsIgnoreCase("promedioAcademico")) {
                    return promedioAcademico.compareTo(p.getPromedioAcademico());
                }
                
            case 1:
                if (field.equalsIgnoreCase("apellido")) {
                    return p.getDatosUsuario().getApellido().compareTo(DatosUsuario.getApellido());
                } 
                else if (field.equalsIgnoreCase("nombre")) {
                    return p.getDatosUsuario().getNombre().compareTo(DatosUsuario.getNombre());
                } 
                else if (field.equalsIgnoreCase("cedula")) {
                    return p.getDatosUsuario().getCedula().compareTo(DatosUsuario.getCedula());
                }
                else if (field.equalsIgnoreCase("correo")) {
                    return p.getDatosUsuario().getCorreo().compareTo(DatosUsuario.getCorreo());
                } 
                else if (field.equalsIgnoreCase("edad")) {
                    return p.getDatosUsuario().getEdad().compareTo(DatosUsuario.getEdad());
                }
                else if (field.equalsIgnoreCase("promedioAcademico")) {
                    return p.getPromedioAcademico().compareTo(promedioAcademico);
                } 
            default:
                throw new AssertionError();
        }
     }
    
    @Override
    public String toString() {
        return DatosUsuario.getNombre();
    }

}
