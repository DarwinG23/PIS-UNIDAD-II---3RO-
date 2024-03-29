/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package materias.vista.Tabla;

import java.text.SimpleDateFormat;
import javax.swing.table.AbstractTableModel;
import lista.DynamicList;
import materias.modelo.Materia;

/**
 *
 * @author elias
 */
public class ModeloTablaMateria  extends AbstractTableModel {
    private DynamicList<Materia> materias ;

    public DynamicList<Materia> getMaterias() {
        return materias ;
    }

    public void setMaterias(DynamicList<Materia> materias ) {
        this.materias  = materias ;
    }

    
     public ModeloTablaMateria() {
        this.materias =new DynamicList<>();
    }
    @Override
    public int getRowCount(){
        return materias .getLength();
        
    }
    @Override
    public int getColumnCount() {
       // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
       return 3;
    }
    @Override
    public String getValueAt(int i,int i1){
        // i=fila 1=columna
        SimpleDateFormat formatoFecha=new SimpleDateFormat("dd/MM/yyyy");
        try {
            Materia p = materias .getInfo(i);
            String fechaInicio=formatoFecha.format(p.getFecha());
        switch(i1){
            case 0: return (p !=null) ? p.getNombre():" ";   //modelos ternarios
            case 1: return (p !=null) ? p.getCiclo():" ";
            case 2: return (p !=null) ? fechaInicio:" ";
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
                return "Nombre";
            case 1:
                return "Ciclo";
            case 2:
                return "Fecha creacion";    
            default:
                return null;

        }
    }
}

