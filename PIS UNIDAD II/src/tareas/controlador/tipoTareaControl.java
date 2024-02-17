/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tareas.controlador;

import lista.DynamicList;
import tareas.modelo.tipoTarea;

/**
 *
 * @author ALEJANDRO
 */
public class tipoTareaControl {
     private DynamicList<tipoTarea>tareas;
  
    public tipoTareaControl(){
        tareas=new DynamicList<>();
        tareas.add(new tipoTarea(1, "ACD"));
        tareas.add(new tipoTarea(2, "APE"));
        tareas.add(new tipoTarea(3, "AA")); 
    }

    public DynamicList<tipoTarea> getTareas() {
        return tareas;
    }

    public void setTareas(DynamicList<tipoTarea> tareas) {
        this.tareas = tareas;
    }
}
