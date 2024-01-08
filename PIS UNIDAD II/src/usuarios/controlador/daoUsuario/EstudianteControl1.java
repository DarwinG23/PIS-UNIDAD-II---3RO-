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
    public DynamicList<Estudiante> ordenar(DynamicList<Estudiante> lista, Integer tipo, String field) throws Exception {

        Integer n = lista.getLength();
        Estudiante[] estudiantes = lista.toArray();

        for (int i = 0; i < n; i++) {
            int k = i;
            Estudiante t = estudiantes[i];
            for (int j = i + 1; j < n; j++) {
//                    if (personas[j].getApellidos().compareTo(t.getApellidos()) < 0) {
                if (estudiantes[j].comparar(t, field, tipo)) {
                    t = estudiantes[j];
                    k = j;
                }
            }
            estudiantes[k] = estudiantes[i];
            estudiantes[i] = t;
        }

        return lista.toList(estudiantes);
    }

}
