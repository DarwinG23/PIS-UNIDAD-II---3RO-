/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.vista.UtilVista;

import javax.swing.JComboBox;
import usuarios.controlador.daoUsuario.DocenteControlDao;
import usuarios.modelo.Docente;

/**
 *
 * @author Alejandro
 */
public class UtilVistaDocente {
    public static void CargarDocentes(JComboBox cbx) throws Exception{
        DocenteControlDao rc=new DocenteControlDao();
        cbx.removeAllItems();
        for (int i = 0; i < rc.getDocente().getLength(); i++) {
            cbx.addItem(rc.getDocente().getInfo(i));
        }
        
    }
    public static Docente ObtenerDocente(JComboBox cbx){
        return (Docente)cbx.getSelectedItem();
    }
}
