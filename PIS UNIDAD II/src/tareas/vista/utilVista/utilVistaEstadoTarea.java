/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tareas.vista.utilVista;

import javax.swing.JComboBox;
import tareas.controlador.estadoTareaControl;
import tareas.modelo.estadoTarea;

/**
 *
 * @author ALEJANDRO
 */
public class utilVistaEstadoTarea {
    public static void CargarComboRolesL(JComboBox cbx)throws Exception{
         estadoTareaControl rc= new estadoTareaControl();
        cbx.removeAllItems();
         for (int i = 0; i < rc.getEstado().getLength(); i++) {
            cbx.addItem(rc.getEstado().getInfo(i));
        }
    }
    
    public static estadoTarea ObtenerEstadoTarea(JComboBox cbx){
        return (estadoTarea)cbx.getSelectedItem();
    }
}
