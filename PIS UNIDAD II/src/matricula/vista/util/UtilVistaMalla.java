/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matricula.vista.util;

import exeption.EmptyException;
import javax.swing.JComboBox;
import matricula.controlador.MallaControl;
import matricula.modelo.Malla;

/**
 *
 * @author darwi
 */
public class UtilVistaMalla {

    public static void cargarcomboCarrera(JComboBox cbx) throws EmptyException {
        MallaControl mc = new MallaControl();
        cbx.removeAllItems();
        if (mc.getListMalla().isEmpty()) {
            throw new EmptyException("No hay carreras que mostrar");
        } else {
            for (int i = 0; i < mc.getListMalla().getLength(); i++) {
                cbx.addItem(mc.getListMalla().getInfo(i));
            }
        }
    }

    public static void cargarcomboMallaFiltro(JComboBox cbx, Integer id) throws EmptyException {
        MallaControl mc = new MallaControl();
        cbx.removeAllItems();
        if (mc.getListMalla().isEmpty()) {
            throw new EmptyException("No hay carreras que mostrar");
        } else {
            for (int i = 0; i < mc.getListMalla().getLength(); i++) {
                if (mc.getListMalla().getInfo(i).getId_Carrera() == id+1) {
                    cbx.addItem(mc.getListMalla().getInfo(i));
                }
            }
        }
    }

    public static Malla obtenerCarrera(JComboBox cbx) {
        return (Malla) cbx.getSelectedItem();
    }

}
