/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matricula.vista.util;

import exeption.EmptyException;
import javax.swing.JComboBox;
import matricula.controlador.CicloControl;
import matricula.modelo.Ciclo;


/**
 *
 * @author darwi
 */
public class UtilVistaCiclo {
    public static void cargarcomboCiclo(JComboBox cbx) throws EmptyException{
        CicloControl mc = new CicloControl();
        cbx.removeAllItems();
        if(mc.getListCiclo().isEmpty()){
            throw new EmptyException("No hay ciclos que mostrar");
        }
        else{
           for (int i = 0; i < mc.getListCiclo().getLength(); i++) {
            cbx.addItem(mc.getListCiclo().getInfo(i));
           }
        }
    }
    
    public static void cargarcomboCicloFiltro(JComboBox cbx) throws EmptyException{
        CicloControl mc = new CicloControl();
        cbx.removeAllItems();
        if(mc.getListCiclo().isEmpty()){
            throw new EmptyException("No hay ciclos que mostrar");
        }
        else{
           for (int i = 0; i < mc.getListCiclo().getLength(); i++) {
            cbx.addItem(mc.getListCiclo().getInfo(i));
           }
        }
    }
    
    public static Ciclo obtenerCiclo(JComboBox cbx){
        return (Ciclo) cbx.getSelectedItem();
    }
    
}
