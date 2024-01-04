/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelo;

import java.util.List;

/**
 *
 * @author Alexander
 */
public class Curso {
    private Integer idEstudiante;
    private String detalles;
    private String Estado;
    private List<Curso> cursosImpartidos;

    public Curso(Integer idEstudiante, String detalles, String Estado, List<Curso> cursosImpartidos) {
        this.idEstudiante = idEstudiante;
        this.detalles = detalles;
        this.Estado = Estado;
        this.cursosImpartidos = cursosImpartidos;
    }

    public Integer getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Integer idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public List<Curso> getCursosImpartidos() {
        return cursosImpartidos;
    }

    public void setCursosImpartidos(List<Curso> cursosImpartidos) {
        this.cursosImpartidos = cursosImpartidos;
    }

    @Override
    public String toString() {
        return "Curso{" + "idEstudiante=" + idEstudiante + ", detalles=" + detalles + ", Estado=" + Estado + ", cursosImpartidos=" + cursosImpartidos + '}';
    }
    
    public void agregarCurso(Curso curso) {
        cursosImpartidos.add(curso);
    }

    public List<Curso> obtenerCursosImpartidos() {
        return cursosImpartidos;
    }
    
    
    
}
