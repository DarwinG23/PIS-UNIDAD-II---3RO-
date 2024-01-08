/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matricula.vista.tabla;

import exeption.EmptyException;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import lista.DynamicList;
import matricula.modelo.Estado;
import matricula.modelo.Matricula;

/**
 *
 * @author darwi
 */
public class ModeloTablaMatricula extends AbstractTableModel {

    private DynamicList<Matricula> matriculas;

    @Override
    public int getRowCount() {
        if (matriculas == null) {
            matriculas = new DynamicList<>();
        }
        return matriculas.getLength();
    }

    @Override
    public int getColumnCount() { //Agregar columnas
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Matricula c;
        try {

            c = (Matricula) matriculas.getInfo(rowIndex);

            switch (columnIndex) {
                case 0:
                    return (c != null) ? c.getId() : " ";
                case 1:
                    return (c != null) ? c.getEstado() : " ";
                case 2:
                    return (c != null) ? c.getCursas().getLength() : " ";
                case 3:
                    return (c != null) ? c.getFechaEmision() : " ";
                case 4:
                    return (c != null) ? c.getModalidad() : " ";
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
                return "ESTADO";
            case 2:
                return "NRO CURSA";
            case 3:
                return "EMITIDO";
            case 4:
                return "MODALIDAD";
            default:
                return null;
        }
    }

    /**
     * @return the personas
     */
    public DynamicList getMatriculas() {
        return matriculas;
    }

    /**
     * @param cursas
     */
    public void setMatriculas(DynamicList cursas) {
        this.matriculas = cursas;
    }

}
