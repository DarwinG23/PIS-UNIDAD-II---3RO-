/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matricula.vista.tabla;

import lista.DynamicList;
import exeption.EmptyException;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import matricula.modelo.Facultad;

/**
 *
 * @author darwi
 */
public class ModeloTablaFacultad extends AbstractTableModel {
    private DynamicList<Facultad> facultades;
    
    @Override
    public int getRowCount() {
        if(facultades == null){
            facultades = new DynamicList<>();
        }
        return facultades.getLength();
    }

    @Override
    public int getColumnCount() { //Agregar columnas
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       //SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
       
       Facultad f;
       try {
           
           f = (Facultad)facultades.getInfo(rowIndex);
           //String fechaInicio= formatoFecha.format(pc.getFecha_Inicio());
           //String fechaFin= formatoFecha.format(pc.getFecha_Fin());
           switch (columnIndex) {
            case 0:
                return (f != null) ? f.getId(): " ";
            case 1:
                return (f != null) ? f.getNombre(): " ";
            case 2:
                return (f != null) ? f.getNumBloques(): " ";
            case 3:
                return (f != null) ? f.getCarreras().getLength(): " ";
            case 4:
                return (f != null) ? f.getDescripcion(): " ";
            case 5:
                return (f != null) ? f.getUbicacion(): " ";
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
                return "NÚMERO DE BLOQUES";
            case 3:
                return "CARRERAS";
            case 4:
                return  "DESCRIPCIÓN";
            case 5:
                return "UBICACIÓN";
            default:
                return null;
        }
    }
    /**
     * @return the personas
     */
    public DynamicList getFacultades() {
        return facultades;
    }

    /**
     * @param facultades
     */
    public void setFacultades(DynamicList facultades) {
        this.facultades = facultades;
    }
    
}
