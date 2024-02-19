/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tareas.controlador.controladorTarea;

import dao.DaoImplement;
import lista.DynamicList;
import tareas.modelo.GuardarTarea;
import tareas.modelo.ReporteTarea;
import tareas.modelo.tarea;

/**
 *
 * @author Alejandro
 */
public class reporteTarea1 extends DaoImplement<ReporteTarea>{
    
     private DynamicList<ReporteTarea> TareaEstudiante;
    private ReporteTarea tareaEstudiante1;

    public reporteTarea1() {
        super(ReporteTarea.class);
    }

    public DynamicList<ReporteTarea> getTareaEstudiante() {
        TareaEstudiante = all();
        return TareaEstudiante;
    }

    public void setTareaEstudiante(DynamicList<ReporteTarea> TareaEstudiante) {
        this.TareaEstudiante = TareaEstudiante;
    }

    public ReporteTarea getTareaEstudiante1() {
        if (tareaEstudiante1 == null) {
            tareaEstudiante1 = new ReporteTarea();
        }
        return tareaEstudiante1;
    }

    public void setTareaEstudiante1(ReporteTarea tareaEstudiante1) {
        this.tareaEstudiante1 = tareaEstudiante1;
    }
    public Boolean persist() {
        tareaEstudiante1.setId(all().getLength() + 1);
        return persist(tareaEstudiante1);
    }
    
    
    
}