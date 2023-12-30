/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tareas.controlador;

import lista.DynamicList;
import tareas.modelo.tarea;

/**
 *
 * @author ALEJANDRO
 */
public class administrarTarea {

    private tarea controlTarea;
    private DynamicList<tarea> tareas;

    public administrarTarea() {
        controlTarea = new tarea();
        this.tareas = new DynamicList<>();
    }

    public tarea getControlTarea() {
        if (controlTarea == null) {
            controlTarea = new tarea();
        }
        return controlTarea;
    }

    public void setControlTarea(tarea controlTarea) {
        this.controlTarea = controlTarea;
    }

    public DynamicList<tarea> getTareas() {
        return tareas;
    }

    public void setTareas(DynamicList<tarea> tareas) {
        this.tareas = tareas;
    }

    //Metodo guardar
    public Boolean guardar() {
        controlTarea.setId(generarId());
        tareas.add(controlTarea);
        return true;
    }

    private Integer generarId() {
        return tareas.getLength() + 1;
    }

    public void imprimir() {
        System.out.println(tareas.toString());
    }
}
