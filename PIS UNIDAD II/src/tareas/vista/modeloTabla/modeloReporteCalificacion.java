/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tareas.vista.modeloTabla;

import javax.swing.table.AbstractTableModel;
import lista.DynamicList;
import tareas.modelo.GuardarTarea;
import tareas.modelo.ReporteTarea;
import tareas.modelo.tarea;

/**
 *
 * @author Alejandro
 */
public class modeloReporteCalificacion extends AbstractTableModel {
      private DynamicList<ReporteTarea> reporte;


    public DynamicList<ReporteTarea> getReporte() {
        return reporte;
    }

    public void setReporte(DynamicList<ReporteTarea> reporte) {
        this.reporte = reporte;
    }

        
     public modeloReporteCalificacion() {
        this.reporte=new DynamicList<>();
    }
    @Override
    public int getRowCount(){
        return reporte.getLength();
        
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
            ReporteTarea p = reporte.getInfo(i);

        switch(i1){
            case 0: return (p !=null) ? String.valueOf(p.getNota()):" ";
            case 1: return (p !=null) ? p.getRetroalimentacion():" ";
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
                return "Nota";
                case 1:
                return "Retroalimentacion";

            default:
                return null;

        }
    }
}
