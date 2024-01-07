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
import usuarios.controlador.daoUsuario.DocenteControl1;
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
    public static DynamicList<Docente> ShellSort(DynamicList<Docente> lista, Integer tipo, String field) {
        int n = lista.getLength();
        Docente[] personas = lista.toArray();

        for (int intervalo = n / 2; intervalo > 0; intervalo /= 2) {
            for (int i = intervalo; i < n; i++) {
                Docente ayuda = personas[i];
                int j;
                for (j = i; j >= intervalo && ayuda.comparar(personas[j - intervalo], field, tipo); j -= intervalo) {
                    personas[j] = personas[j - intervalo];
                }
                personas[j] = ayuda;
            }
        }
        return lista.toList(personas);
    }
    
    public static DynamicList<Docente> MetodoQuickSort(DynamicList<Docente> docentelList, Integer tipo, String Campo) throws EmptyList, NullPointerException, EmptyException {
        if (docentelList == null || docentelList.getLength()<= 1) {
            return docentelList;
        }
        Recursuvoquicksort(docentelList, 0, docentelList.getLength()- 1, tipo, Campo);
        return docentelList;
    }
    

    private static void Recursuvoquicksort(DynamicList<Docente> docenList, int inicio, int fin, Integer tipo, String Campo) throws EmptyList, NullPointerException, EmptyException {
        if (inicio < fin) {
            int indiceParticion = Dividir(docenList, inicio, fin, tipo, Campo);
            Recursuvoquicksort(docenList, inicio, indiceParticion - 1, tipo, Campo);
            Recursuvoquicksort(docenList, indiceParticion + 1, fin, tipo, Campo);
        }
    }

    private static int Dividir(DynamicList<Docente> doceList, int inicio, int fin, Integer tipo, String Campo) throws EmptyList, NullPointerException, EmptyException {
        Docente pivote = doceList.getInfo(fin);
        int i = inicio - 1;

        for (int j = inicio; j < fin; j++) {
            if (pivote.comparar(doceList.getInfo(j), Campo, tipo)) {
                i++;
                cambio(doceList, i, j);
            }
        }
        cambio(doceList, i + 1, fin);
        return i + 1;
    }

    private static void cambio(DynamicList<Docente> docenteList, int i, int j) throws EmptyList, NullPointerException, EmptyException {
        Docente ayuda = docenteList.getInfo(i);
        docenteList.ModificarInfo(docenteList.getInfo(j), i);
        docenteList.ModificarInfo(ayuda, j);
    }
    
    public static void cargarcomboDocente(JComboBox cbx) throws EmptyList{
        DocenteControl1 rc = new DocenteControl1();
        cbx.removeAllItems();
        
        if(rc.getDocente1().isEmpty()){
            throw new EmptyList("No hay pasajeros que mostrar");
        }
        else{
           for (int i = 0; i < rc.getDocente1().getLength(); i++) {
            cbx.addItem(rc.getDocente1().getInfo(i));
           }
        }
    }
    
    public static Docente obtenerDocenteControl1(JComboBox cbx){
        return (Docente) cbx.getSelectedItem();
    }
}
