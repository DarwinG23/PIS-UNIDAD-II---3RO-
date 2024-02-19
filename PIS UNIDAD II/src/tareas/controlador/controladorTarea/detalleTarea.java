/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tareas.controlador.controladorTarea;

import dao.DaoImplement;
import lista.DynamicList;
import tareas.modelo.GuardarTarea;


/**
 *
 * @author Alejandro
 */
public class detalleTarea extends DaoImplement<GuardarTarea>{
    
     private DynamicList<GuardarTarea> TareaEstudiante;
    private GuardarTarea tareaEstudiante1;

    public detalleTarea() {
        super(GuardarTarea.class);
    }

    public DynamicList<GuardarTarea> getTareaEstudiante() {
        TareaEstudiante = all();
        return TareaEstudiante;
    }

    public void setTareaEstudiante(DynamicList<GuardarTarea> TareaEstudiante) {
        this.TareaEstudiante = TareaEstudiante;
    }

    public GuardarTarea getTareaEstudiante1() {
        if (tareaEstudiante1 == null) {
            tareaEstudiante1 = new GuardarTarea();
        }
        return tareaEstudiante1;
    }

    public void setTareaEstudiante1(GuardarTarea tareaEstudiante1) {
        this.tareaEstudiante1 = tareaEstudiante1;
    }
    public Boolean persist() {
        tareaEstudiante1.setId(all().getLength() + 1);
        return persist(tareaEstudiante1);
    }
    
    
    
}