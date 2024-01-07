/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matricula.vista.util;

import javax.swing.JComboBox;
import matricula.modelo.Estado;

/**
 *
 * @author darwi
 */
public class UtilVistaEstado {
    public static void cargarComboEstado(JComboBox cbx) {
        cbx.removeAllItems();
        for (Estado estado : Estado.values()) {
            cbx.addItem(estado);
        }
    }

    public static Estado obtenerEstadoSeleccionado(JComboBox cbx) {
        return (Estado) cbx.getSelectedItem();
    }
    
}
