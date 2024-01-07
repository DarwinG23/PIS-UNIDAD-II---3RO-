/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matricula.vista.tabla;

import exeption.EmptyException;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import lista.DynamicList;
import matricula.modelo.Cursa;

/**
 *
 * @author darwi
 */
public class ModeloTablaCursaMateria extends AbstractTableModel {
    private DynamicList<Cursa> cursas;

    @Override
    public int getRowCount() {
        if (cursas == null) {
            cursas = new DynamicList<>();
        }
        return cursas.getLength();
    }

    @Override
    public int getColumnCount() { //Agregar columnas
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Cursa c;
        try {

            c = (Cursa) cursas.getInfo(rowIndex);
            switch (columnIndex) {
                case 0:
                    return (c != null) ? c.getId(): " ";
                case 1:
                    return (c != null) ? c.getId_materia() : " ";
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
                return "MATERIA";
            default:
                return null;
        }
    }

    /**
     * @return the personas
     */
    public DynamicList getCursas() {
        return cursas;
    }

    /**
     * @param cursas
     */
    public void setCursas(DynamicList cursas) {
        this.cursas = cursas;
    }
    
}
