/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tareas.controlador.controladorTarea;

import dao.DaoImplement;
import lista.DynamicList;
import tareas.modelo.tarea;

/**
 *
 * @author ALEJANDRO
 */
public class administrarTarea1 extends DaoImplement<tarea> {
    private DynamicList<tarea> tareas;
    private tarea tarea1;

    public administrarTarea1() {
        super(tarea.class);
    }

    public DynamicList<tarea> getTareas() {
        tareas = all();
        return tareas;
    }

    public void setTareas(DynamicList<tarea> tareas) {
        this.tareas = tareas;
    }

    public tarea getTarea1() {
        if (tarea1 == null) {
            tarea1 = new tarea();
        }
        return tarea1;
    }

    public void setTarea1(tarea tarea1) {
        this.tarea1 = tarea1;
    }
    
    public Boolean persist() {
        tarea1.setId(all().getLength() + 1);
        return persist(tarea1);
    }

}
