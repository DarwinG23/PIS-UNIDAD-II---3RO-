/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tareas.controlador.controladorTarea;

import dao.DaoImplement;
import lista.DynamicList;
import tareas.modelo.GuardarTarea;
import tareas.modelo.tarea;

/**
 *
 * @author Alejandro
 */
public class envioTarea extends DaoImplement<tarea>{
    
     private DynamicList<tarea> TareaEstudiante;
    private tarea tareaEstudiante1;

    public envioTarea() {
        super(tarea.class);
    }

    public DynamicList<tarea> getTareaEstudiante() {
        TareaEstudiante = all();
        return TareaEstudiante;
    }

    public void setTareaEstudiante(DynamicList<tarea> TareaEstudiante) {
        this.TareaEstudiante = TareaEstudiante;
    }

    public tarea getTareaEstudiante1() {
        if (tareaEstudiante1 == null) {
            tareaEstudiante1 = new tarea();
        }
        return tareaEstudiante1;
    }

    public void setTareaEstudiante1(tarea tareaEstudiante1) {
        this.tareaEstudiante1 = tareaEstudiante1;
    }
    public Boolean persist() {
        tareaEstudiante1.setId(all().getLength() + 1);
        return persist(tareaEstudiante1);
    }
    
    
    
}