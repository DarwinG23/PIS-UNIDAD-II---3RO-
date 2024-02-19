/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.utiles;

import exeption.EmptyException;
import exeption.EmptyList;
import java.lang.reflect.Field;
import javax.swing.JComboBox;
import lista.DynamicList;
import usuarios.controlador.daoUsuario.DocenteControlDao;
import usuarios.modelo.Docente;

/**
 *
 * @author Alexander 
 */
public class Utiles {
    public static Field getField(Class clazz, String atribute) {
        Field field = null;
        for (Field f : clazz.getSuperclass().getDeclaredFields()) {
            if (f.getName().equalsIgnoreCase(atribute)) {
                field = f;
                break;
            }
        }
        for (Field f : clazz.getDeclaredFields()) {
            if (f.getName().equalsIgnoreCase(atribute)) {
                field = f;
                break;
            }
        }
        return field;
    }
    
}
