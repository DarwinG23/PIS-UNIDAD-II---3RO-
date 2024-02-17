/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tareas.controlador.tipoEstadoTarea;

import dao.DaoImplement;
import lista.DynamicList;
import tareas.modelo.estadoTarea;

/**
 *
 * @author ALEJANDRO
 */
public class estadoTareaControl1 extends DaoImplement<estadoTarea> {
    private DynamicList<estadoTarea>listR=new DynamicList<>();
     private estadoTarea estado;
     
     public estadoTareaControl1(){
         super(estadoTarea.class);
     }
    public DynamicList<estadoTarea> getListR() {
        listR=all();
        return listR;
    }

    public void setListR(DynamicList<estadoTarea> listR) {
        this.listR = listR;
    }

    public estadoTarea getEstado() {
        if(estado==null)
            estado=new estadoTarea();
            return estado;
        
        
    }


    public void setEstado(estadoTarea estado) {
        this.estado=estado;
    }
    public Boolean persit(){
        estado.setId(all().getLength()+1);
        
        return persist(estado);
    }
}
