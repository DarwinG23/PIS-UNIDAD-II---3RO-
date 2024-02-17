/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tareas.controlador;

import lista.DynamicList;
import tareas.modelo.estadoTarea;

/**
 *
 * @author ALEJANDRO
 */
public class estadoTareaControl {
    public DynamicList<estadoTarea> estado;
    //creación de esta clase para mandar a un combobox

    public estadoTareaControl() {
        estado=new DynamicList<>();
        estado.add(new estadoTarea(1,"Calificada"));
        estado.add(new estadoTarea(2,"Enviada"));
        estado.add(new estadoTarea(3,"Retrasada"));
        
        
    }

    public DynamicList<estadoTarea> getEstado() {
        return estado;
    }

    public void setEstado(DynamicList<estadoTarea> estado) {
        this.estado = estado;
    }
}
