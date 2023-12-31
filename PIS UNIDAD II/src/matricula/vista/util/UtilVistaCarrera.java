/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matricula.vista.util;

import exeption.EmptyException;
import javax.swing.JComboBox;
import matricula.controlador.CarreraControl;
import matricula.modelo.Carrera;
import matricula.modelo.Malla;

/**
 *
 * @author darwi
 */
public class UtilVistaCarrera {
    public static void cargarcomboCarrera(JComboBox cbx) throws EmptyException{
        CarreraControl mc = new CarreraControl();
        cbx.removeAllItems();
        if(mc.getListCarrera().isEmpty()){
            throw new EmptyException("No hay carreras que mostrar");
        }
        else{
           for (int i = 0; i < mc.getListCarrera().getLength(); i++) {
            cbx.addItem(mc.getListCarrera().getInfo(i));
           }
        }
    }
    
    public static Carrera obtenerCarrera(JComboBox cbx){
        return (Carrera) cbx.getSelectedItem();
    }
    
}
