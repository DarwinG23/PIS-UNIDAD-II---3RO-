/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tareas.vista.modeloTabla;

import java.text.SimpleDateFormat;
import javax.swing.table.AbstractTableModel;
import lista.DynamicList;
import tareas.modelo.tarea;

/**
 *
 * @author ALEJANDRO
 */
public class modeloTareaEstudiante extends AbstractTableModel {
       private DynamicList<tarea> tarea;

    public DynamicList<tarea> getTarea() {
        return tarea;
    }

    public void setTarea(DynamicList<tarea> tarea) {
        this.tarea = tarea;
    }

        
     public modeloTareaEstudiante() {
        this.tarea=new DynamicList<>();
    }
    @Override
    public int getRowCount(){
        return tarea.getLength();
        
    }
    @Override
    public int getColumnCount() {
       // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
       return 2;
    }
    @Override
    public String getValueAt(int i,int i1){
        // i=fila 1=columna

        try {
            tarea p = tarea.getInfo(i);
        switch(i1){
            case 0: return (p !=null) ? p.getTituloTarea():" ";   //modelos ternarios
            case 1: return (p !=null) ? p.getDescripcion():" ";           
            default:
                return null;
        }
         } catch (Exception e) {
        }
        return null;
    }
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Titulo Tarea";
                case 1:
                return "Descripcion";           
            default:
                return null;

        }
    }
}
