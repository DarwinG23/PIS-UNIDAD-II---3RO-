///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package matricula.vista.util;
//
//import exeption.EmptyException;
//import javax.swing.JComboBox;
//import controlador.MateriaControl;
//import materias.Modelo.Materia;
//
///**
// *
// * @author darwi
// */
//public class UtilVistaMateria {
//    public static void cargarcomboCarrera(JComboBox cbx) throws EmptyException{
//        MateriaControl mt = new MateriaControl();
//        cbx.removeAllItems();
//        if(mt.getMaterias().isEmpty()){
//            throw new EmptyException("No hay carreras que mostrar");
//        }
//        else{
//           for (int i = 0; i < mt.getMaterias().getLength(); i++) {
//            cbx.addItem(mt.getMaterias().getInfo(i));
//           }
//        }
//    }
//    
//    public static Materia obtenerMateria(JComboBox cbx){
//        return (Materia) cbx.getSelectedItem();
//    }
//    
//}
