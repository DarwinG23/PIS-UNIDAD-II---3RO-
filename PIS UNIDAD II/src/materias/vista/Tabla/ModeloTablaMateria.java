/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package materias.vista.Tabla;

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
       return 5;
    }
    @Override
    public String getValueAt(int i,int i1){
        // i=fila 1=columna
        try {
            Materia p = materias .getInfo(i);
        switch(i1){
            case 0: return (p !=null) ? p.getNombre():" ";   //modelos ternarios
            case 1: return (p !=null) ? p.getId_Materia():" ";
            case 2: return (p !=null) ? p.getCiclo():" ";
            case 3: return (p !=null) ? p.getParalelo():" ";
            case 4: return (p !=null) ? p.getFecha():" ";
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
                return "Id Materia";
            case 2:
                return "Ciclo";
            case 3:
                return "Paralelo";
            case 4:
                return "Fecha creacion";    
            default:
                return null;

        }
    }
}

