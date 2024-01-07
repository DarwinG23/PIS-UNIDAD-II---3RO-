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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getPromedioAcademico() {
        return promedioAcademico;
    }

    public void setPromedioAcademico(String promedioAcademico) {
        this.promedioAcademico = promedioAcademico;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "promedioAcademico=" + promedioAcademico + '}';
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
            case "numero de cedula":
                return cedula.compareTo(p.getCedula());
            case "edad":
                return edad.compareTo(p.getEdad());
            case "apellido":
                return apellido.compareTo(p.getApellido());
            default:
                throw new IllegalArgumentException("Campo no válido");
        }
    }

}
