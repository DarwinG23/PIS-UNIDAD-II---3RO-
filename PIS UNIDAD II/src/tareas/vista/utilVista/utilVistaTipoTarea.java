/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tareas.vista.utilVista;

import javax.swing.JComboBox;
import tareas.controlador.tipoTareaControl;
import tareas.modelo.tipoTarea;

/**
 *
 * @author ALEJANDRO
 */
public class utilVistaTipoTarea {
    public static void CargarComboRolesL(JComboBox cbx)throws Exception{
        tipoTareaControl rc= new tipoTareaControl();
        cbx.removeAllItems();
         for (int i = 0; i < rc.getTareas().getLength(); i++) {
            cbx.addItem(rc.getTareas().getInfo(i));
        }
    }
    
    public static tipoTarea ObtenerTipoTarea(JComboBox cbx){
        return (tipoTarea)cbx.getSelectedItem();
    }
}
