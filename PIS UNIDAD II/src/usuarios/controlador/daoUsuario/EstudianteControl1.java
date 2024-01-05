/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.controlador.daoUsuario;

import dao.DaoImplement;
import lista.DynamicList;
import usuarios.modelo.Docente;
import usuarios.modelo.Estudiante;

/**
 *
 * @author USUARIO
 */
public class EstudianteControl1 extends DaoImplement<Estudiante> {
    private DynamicList<Estudiante> estudiante;
    private Estudiante estudiante1;
     public EstudianteControl1() {
         super(Estudiante.class);
    }

    public DynamicList<Estudiante> getEstudiante() {
        estudiante=all();
        return estudiante;
    }

    public void setEstudiante(DynamicList<Estudiante> estudiante) {
        this.estudiante= estudiante;
    }

    public Estudiante getEstudiante1() {
        if (estudiante1 == null) {
            estudiante1 = new Estudiante();
        }
        return estudiante1;
    }

    public void setEstudiante1(Estudiante estudiante1) {
        this.estudiante1 = estudiante1;
    }

    public Boolean persist(){
        estudiante1.setId(all().getLength()+ 1);
        return persist(estudiante1);
    }
}
