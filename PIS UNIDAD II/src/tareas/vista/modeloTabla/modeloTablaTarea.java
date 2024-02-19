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
public class modeloTablaTarea extends AbstractTableModel {
       private DynamicList<tarea> tarea;

    public DynamicList<tarea> getTarea() {
        return tarea;
    }

    public void setTarea(DynamicList<tarea> tarea) {
        this.tarea = tarea;
    }

        
     public modeloTablaTarea() {
        this.tarea=new DynamicList<>();
    }
    @Override
    public int getRowCount(){
        return tarea.getLength();
        
    }
    @Override
    public int getColumnCount() {
       // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
       return 6;
    }
    @Override
    public String getValueAt(int i,int i1){
        // i=fila 1=columna
        SimpleDateFormat formatoFecha=new SimpleDateFormat("dd/MM/yyyy");
        try {
            tarea p = tarea.getInfo(i);
            String fechaInicio=formatoFecha.format(p.getFecha_Inicio());
            String fechaFinal=formatoFecha.format(p.getFecha_Final());
        switch(i1){
            case 0: return (p !=null) ? p.getTituloTarea():" ";   //modelos ternarios
            case 1: return (p !=null) ? p.getId_tarea().getNombre():" ";
            case 2: return (p !=null) ? p.getDescripcion():" ";
            case 3:return (p !=null) ?  fechaInicio:" ";
            case 4:return (p !=null) ?  fechaFinal:" ";
            case 5: return (p !=null) ?  p.getId_estado().getEstado():" ";

            
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
                return "Tipo Tarea";
                case 2:
                return "Descripcion";
                case 3:
                    return "Fecha Inicio";
                case 4:
                    return "Fecha Final";
                case 5:
                    return "Estado tarea";
//                case 6:
//                    return "Nota";
                    
           
            default:
                return null;

        }
    }
}
