/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tareas.controlador.tipoEstadoTarea;

import dao.DaoImplement;
import lista.DynamicList;
import tareas.modelo.tipoTarea;

/**
 *
 * @author ALEJANDRO
 */
public class tipoTareaControl1 extends DaoImplement<tipoTarea>{
    private DynamicList<tipoTarea> listR = new DynamicList<>();
    private tipoTarea tipotarea;

    public tipoTareaControl1() {
        super(tipoTarea.class);
    }

    public DynamicList<tipoTarea> getListR() {
        listR = all();
        return listR;
    }

    public void setListR(DynamicList<tipoTarea> listR) {
        this.listR = listR;
    }

    public tipoTarea getTipoTarea() {
        if (tipotarea == null) {
            tipotarea = new tipoTarea();
        }
        return tipotarea;

    }

    public void setTipoTarea(tipoTarea tarea) {
        this.tipotarea = tarea;
    }

    public Boolean persit() {
        tipotarea.setId(all().getLength() + 1);

        return persist(tipotarea);
    }
}
