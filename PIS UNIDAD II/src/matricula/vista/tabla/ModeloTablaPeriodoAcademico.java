/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matricula.vista.tabla;

import lista.DynamicList;
import exeption.EmptyException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import matricula.modelo.PeriodoAcademico;

/**
 *
 * @author darwin
 */
public class ModeloTablaPeriodoAcademico extends AbstractTableModel{
    private DynamicList<PeriodoAcademico> periodosAcademicos;
    
    
    @Override
    public int getRowCount() {
        if(periodosAcademicos == null){
            periodosAcademicos = new DynamicList<>();
        }
        return periodosAcademicos.getLength();
    }

    @Override
    public int getColumnCount() { //Agregar columnas
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
       
       PeriodoAcademico pc;
       try {
           
           pc = (PeriodoAcademico)periodosAcademicos.getInfo(rowIndex);
           String fechaInicio= formatoFecha.format(pc.getFecha_Inicio());
           String fechaFin= formatoFecha.format(pc.getFecha_Fin());
           switch (columnIndex) {
            case 0:
                return (pc != null) ? pc.getId(): " ";
            case 1:
                return (pc != null) ? fechaInicio: " ";
            case 2:
                return (pc != null) ? fechaFin: " ";
            case 3:
                return (pc != null) ? pc.getNombre(): " ";
            default:
                return null;
        }
       } catch (EmptyException e) {
           JOptionPane.showMessageDialog(null, "Ocurrió un error al obtener la información. Por favor, inténtelo de nuevo o contacte al soporte.", "Error", JOptionPane.ERROR_MESSAGE);
           return null;
       }
        
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "FECHA DE INICIO";
            case 2:
                return "FECHA DE FIN";
            case 3:
                return "NOMBRE";
            default:
                return null;
        }
    }
    /**
     * @return the personas
     */
    public DynamicList getPeridosAcademicos() {
        return periodosAcademicos;
    }

    /**
     * @param peridosAcademicos
     */
    public void setPeridosAcademicos(DynamicList periodosAcademicos) {
        this.periodosAcademicos = periodosAcademicos;
    }
    
}
