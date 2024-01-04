/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matricula.vista.tabla;

import lista.DynamicList;
import exeption.EmptyException;
//import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import matricula.modelo.Carrera;

/**
 *
 * @author darwi
 */
public class ModeloTablaCarrera extends AbstractTableModel{
    private DynamicList<Carrera> carreras;
    
    @Override
    public int getRowCount() {
        if(carreras == null){
            carreras = new DynamicList<>();
        }
        return carreras.getLength();
    }

    @Override
    public int getColumnCount() { //Agregar columnas
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {      
       Carrera c;
       try {
           
           c = (Carrera)carreras.getInfo(rowIndex);
           switch (columnIndex) {
            case 0:
                return (c != null) ? c.getId(): " ";
            case 1:
                return (c != null) ? c.getNombre(): " ";
            case 2:
                return (c != null) ? c.getDescripcion(): " ";
            case 3:
                return (c != null) ? c.getDuracionAnios(): " ";
            case 4:
                return (c != null) ? c.getNumCiclos(): " ";
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
                return "NOMBRE";
            case 2:
                return "DESCRIPCION";
            case 3:
                return "AÑOS";
            case 4:
                return "CICLOS";
            default:
                return null;
        }
    }
    /**
     * @return the personas
     */
    public DynamicList getCarreras() {
        return carreras;
    }

    /**
     * @param carreras
     */
    public void setCarreras(DynamicList carreras) {
        this.carreras = carreras;
    }
    
    
}
