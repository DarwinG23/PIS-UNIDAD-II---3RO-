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
import matricula.controlador.MallaControl;
import matricula.modelo.Ciclo;
import matricula.modelo.Malla;

/**
 *
 * @author darwi
 */
public class ModeloTablaCiclo extends AbstractTableModel {

    private DynamicList<Ciclo> ciclos;

    @Override
    public int getRowCount() {
        if (ciclos == null) {
            ciclos = new DynamicList<>();
        }
        return ciclos.getLength();
    }

    @Override
    public int getColumnCount() { //Agregar columnas
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");

        Ciclo c;
        try {

            c = (Ciclo) ciclos.getInfo(rowIndex);
            String fechaInicio = formatoFecha.format(c.getFechaInicio());
            String fechaFin = formatoFecha.format(c.getFechaFin());

//            String nombreMalla = obtenerNombreMalla(c.getId_Malla());
            switch (columnIndex) {
                case 0:
                    return (c != null) ? c.getId() : " ";
                case 1:
                    return (c != null) ? c.getNumCiclo() : " ";
                case 2:
                    return (c != null) ? fechaInicio : " ";
                case 3:
                    return (c != null) ? fechaFin : " ";
                case 4:
                    return (c != null) ? c.getMaterias().getLength() : " ";
                case 5:
                    return (c != null) ? c.getId_Malla() : " ";
                default:
                    return null;
            }
        } catch (EmptyException e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al obtener la información. Por favor, inténtelo de nuevo o contacte al soporte.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }

    }

//    public String obtenerNombreMalla(Integer id) throws EmptyException {
//        MallaControl mallaControl = new MallaControl();
//        int i = 0;
//
//        while (i <= mallaControl.getListMalla().getLength()) {
//            Malla mallaActual = mallaControl.getListMalla().getInfo(i);
//            if(mallaActual.getId() == id ){
//                return mallaActual.getNombre();
//            }     
//        }
//
//        return null;
//    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "Numero";
            case 2:
                return "FECHA INICIO";
            case 3:
                return "FECHA FIN";
            case 4:
                return "NÚMERO MATERIAS";
            case 5:
                return "MALLA";
            default:
                return null;
        }
    }

    /**
     * @return the personas
     */
    public DynamicList getCiclos() {
        return ciclos;
    }

    /**
     * @param ciclos
     */
    public void setCiclos(DynamicList ciclos) {
        this.ciclos = ciclos;
    }

}
