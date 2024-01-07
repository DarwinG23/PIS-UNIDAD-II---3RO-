/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.controlador;

import lista.DynamicList;
import usuarios.modelo.Estudiante;

/**
 *
 * @author Alexander
 */
public class EstudianteControl {

    private Estudiante estudiante;
    private DynamicList<Estudiante> estudiantes;

    public EstudianteControl() {
        estudiante = new Estudiante();
        this.estudiantes = new DynamicList<>();
    }

    public Estudiante getEstudiante() {
        if (estudiante == null) {
            estudiante = new Estudiante();
        }

        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public DynamicList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstuidante(DynamicList<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    //Mwtodo guardar
    public Boolean guardar() {
        estudiante.setId(generarId());
        estudiantes.add(estudiante);
        return true;
    }

    private Integer generarId() {
        return estudiantes.getLength() + 1;

    }

    public void imprimir() {
        System.out.println(estudiantes.toString());
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

    public static void main(String[] args) throws Exception {
        EstudianteControl uc = new EstudianteControl();
        DynamicList<Estudiante> lista = uc.all();
        System.out.println(lista.toString());
        EstudianteControl us = new EstudianteControl();
        System.out.println(us.ordenar(lista, 0, "boletoFechaC").toString());
    }

    private DynamicList<Estudiante> all() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
