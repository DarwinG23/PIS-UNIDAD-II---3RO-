/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelo;

/**
 *
 * @author Alexander
 */
public class Estudiante extends Usuario {

    public Estudiante(String nombre, String apellido, String edad, Integer id, String cedula, String correo) {
        super(nombre, apellido, edad, id, cedula, correo);
    }
    private String promedioAcademico;

    public Estudiante(String promedioAcademico, String nombre, String apellido, String edad, Integer id, String cedula, String correo) {
        super(nombre, apellido, edad, id, cedula, correo);
        this.promedioAcademico = promedioAcademico;
    }
    public Estudiante() {
        
        this.promedioAcademico = null;
    }

    public String getPromedioAcademico() {
        return promedioAcademico;
    }

    public void setPromedioAcademico(String promedioAcademico) {
        this.promedioAcademico = promedioAcademico;
    }
    public Integer compare(Estudiante p, String field, Integer type) {
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
                }else if (field.equalsIgnoreCase("promedioAcademico")) {
                    return promedioAcademico.compareTo(p.getPromedioAcademico());
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
                }else if (field.equalsIgnoreCase("promedioAcademico")) {
                    return p.getPromedioAcademico().compareTo(promedioAcademico);
                } 
            default:
                throw new AssertionError();
        }
     }
    
    @Override
    public String toString() {
        return "Estudiante{" + "promedioAcademico=" + promedioAcademico + '}';
    }

    

}
