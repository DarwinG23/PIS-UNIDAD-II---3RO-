/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package materias.vista.util;

import javax.swing.JComboBox;
import materias.controlador.registros.MateriaControl1;
import materias.modelo.Materia;

/**
 *
 * @author elias
 */
public class UtilVista1 {
    public static void cargarcomboRolesL(JComboBox cbx) throws Exception {
        MateriaControl1 rc= new MateriaControl1();
        cbx.removeAllItems();
         for (int i = 0; i < rc.getMaterias().getLength(); i++) {
            cbx.addItem(rc.getMaterias().getInfo(i).getNombre());
        }
    }
 
    public static String  obtenerRolControl(JComboBox cbx) {
        return (String) cbx.getSelectedItem();
    }
    
    public static Materia  obtenerMateria(JComboBox cbx) {
        return (Materia) cbx.getSelectedItem();
    }
}
  
