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
public class Estudiante extends Persona{
    
    private Integer idEstudiante;
    private String CorreoUsuario;
    private String ContraseniaUsuario;
    private String promedioAcademico;
    private DynamicList<Matricula> matriculas;

    public Estudiante() {
        
    }

    public Estudiante(Integer idEstudiante, String CorreoUsuario, String ContraseniaUsuario, String promedioAcademico, DynamicList<Matricula> matriculas) {
        this.idEstudiante = idEstudiante;
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
                    return getApellido().compareTo(p.getApellido());
                } 
                else if (field.equalsIgnoreCase("nombre")) {
                    return getNombre().compareTo(p.getNombre());
                } 
                else if (field.equalsIgnoreCase("cedula")) {
                    return getCedula().compareTo(p.getCedula());
                } 
                else if (field.equalsIgnoreCase("correo")) {
                    return getCorreo().compareTo(p.getCorreo());
                }
                else if (field.equalsIgnoreCase("edad")) {
                    return getEdad().compareTo(p.getEdad());
                }
                else if (field.equalsIgnoreCase("promedioAcademico")) {
                    return promedioAcademico.compareTo(p.getPromedioAcademico());
                }
                
            case 1:
                if (field.equalsIgnoreCase("apellido")) {
                    return p.getApellido().compareTo(getApellido());
                } 
                else if (field.equalsIgnoreCase("nombre")) {
                    return p.getNombre().compareTo(getNombre());
                } 
                else if (field.equalsIgnoreCase("cedula")) {
                    return p.getCedula().compareTo(getCedula());
                }
                else if (field.equalsIgnoreCase("correo")) {
                    return p.getCorreo().compareTo(getCorreo());
                } 
                else if (field.equalsIgnoreCase("edad")) {
                    return p.getEdad().compareTo(getEdad());
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
        return getNombre();
    }

}
