/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matricula.vista.util;

import exeption.EmptyException;
import javax.swing.JComboBox;
import matricula.controlador.PeriodoAcademicoControl;
import matricula.modelo.PeriodoAcademico;

/**
 *
 * @author darwi
 */
public class UtilVistaPeriodoAcademico {
    public static void cargarcomboPerido(JComboBox cbx) throws EmptyException{
        PeriodoAcademicoControl mc = new PeriodoAcademicoControl();
        cbx.removeAllItems();
        if(mc.getListPeriodoAcademico().isEmpty()){
            throw new EmptyException("No hay carreras que mostrar");
        }
        else{
           for (int i = 0; i < mc.getListPeriodoAcademico().getLength(); i++) {
            cbx.addItem(mc.getListPeriodoAcademico().getInfo(i));
           }
        }
    }
    
    public static PeriodoAcademico obtenerCarrera(JComboBox cbx){
        return (PeriodoAcademico) cbx.getSelectedItem();
    }
    
}
