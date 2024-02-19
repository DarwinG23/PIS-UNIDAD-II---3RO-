/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tareas.vista.utilVista;

import javax.swing.JComboBox;
import materias.controlador.registros.MateriaControl1;
import materias.modelo.Materia;
import tareas.controlador.estadoTareaControl;
import tareas.modelo.estadoTarea;
import usuarios.controlador.daoUsuario.EstudianteControlDao;
import usuarios.modelo.Estudiante;

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
    public static void CargarMaterias(JComboBox cbx) throws Exception{
        MateriaControl1 rc=new MateriaControl1();
        cbx.removeAllItems();
        for (int i = 0; i < rc.getMaterias().getLength(); i++) {
            cbx.addItem(rc.getMaterias().getInfo(i));
        }
        
    }
    public static Materia ObtenerMateria(JComboBox cbx){
        return (Materia)cbx.getSelectedItem();
    }
    public static void CargarEstudiantes(JComboBox cbx) throws Exception{
        EstudianteControlDao rc=new EstudianteControlDao();
        cbx.removeAllItems();
        for (int i = 0; i < rc.getListaEstudiante().getLength(); i++) {
            cbx.addItem(rc.getListaEstudiante().getInfo(i));
        }
        
    }
    public static Estudiante ObtenerEstudiante(JComboBox cbx){
        return (Estudiante)cbx.getSelectedItem();
    }
}
