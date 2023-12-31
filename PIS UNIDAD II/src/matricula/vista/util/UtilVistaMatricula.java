/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matricula.vista.util;

import exeption.EmptyException;
import javax.swing.JComboBox;
import matricula.controlador.MatriculaControl;
import matricula.modelo.Matricula;

/**
 *
 * @author darwi
 */
public class UtilVistaMatricula {
    public static void cargarcomboCarrera(JComboBox cbx) throws EmptyException{
        MatriculaControl mc = new MatriculaControl();
        cbx.removeAllItems();
        if(mc.getListMatricula().isEmpty()){
            throw new EmptyException("No hay carreras que mostrar");
        }
        else{
           for (int i = 0; i < mc.getListMatricula().getLength(); i++) {
            cbx.addItem(mc.getListMatricula().getInfo(i));
           }
        }
    }
    
    public static Matricula obtenerCarrera(JComboBox cbx){
        return (Matricula) cbx.getSelectedItem();
    }
    
}
