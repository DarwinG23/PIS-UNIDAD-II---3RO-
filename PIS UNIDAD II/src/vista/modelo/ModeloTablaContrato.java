/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.modelo;

import java.text.SimpleDateFormat;
import javax.swing.table.AbstractTableModel;
import lista.DynamicList;
import usuarios.modelo.Contrato;
import usuarios.modelo.Imparte;

/**
 *
 * @author Alejandro
 */
public class ModeloTablaContrato extends AbstractTableModel {
    
    private DynamicList<Imparte> contrato;

    public DynamicList<Imparte> getContrato() {
        return contrato;
    }

    public void setContrato(DynamicList<Imparte> imparte) {
        this.contrato = imparte;
    }
   
    @Override
    public int getRowCount() {
        return contrato.getLength();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int Fila, int Columna) {
        SimpleDateFormat formatoFecha=new SimpleDateFormat("dd/MM/yyyy");

        try {
            Imparte p = contrato.getInfo(Fila);
            String fechaInicio=formatoFecha.format(p.getId_Contrato().getId_periodo().getFechaFinal());
            String fechaFinal=formatoFecha.format(p.getId_Contrato().getId_periodo().getFechaInicio());
            

            switch (Columna) {
                case 0:
                    return (p != null) ? p.getId_Docente().getNombre(): "";
                case 1:
                    return (p != null) ? p.getId_Contrato().getSalario(): "";
                case 2:
                    return (p != null) ? fechaInicio: "";
                case 3:
                    return (p != null) ? fechaFinal:" ";
                default:
                    return null;
            }
     } catch (Exception e) {
             System.out.println("ERROR");
        }
        return contrato;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Docente";
            case 1:
                return "Salario";
            case 2:
                return "Fecha Inicio";
            case 3:
                return "Fecha Final";
           
            default:
                return null;
        }
    }

}
