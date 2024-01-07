/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matricula.vista.util;

import javax.swing.JComboBox;
import matricula.modelo.Modalidad;

/**
 *
 * @author darwi
 */
public class UtilVistaModalidad {
    public static void cargarComboModalidad(JComboBox cbx) {
        cbx.removeAllItems();
        for (Modalidad modalidad : Modalidad.values()) {
            cbx.addItem(modalidad);
        }
    }

    public static Modalidad obtenerModalidadSeleccionada(JComboBox cbx) {
        return (Modalidad) cbx.getSelectedItem();
    }
    
}
