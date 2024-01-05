/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tareas.controlador.controladorTarea;

import dao.DaoImplement;
import java.lang.reflect.Field;
import lista.DynamicList;
import tareas.modelo.tarea;

/**
 *
 * @author ALEJANDRO
 */
public class administrarTarea1 extends DaoImplement<tarea> {
    private DynamicList<tarea> tareas;
    private tarea tarea1;

    public administrarTarea1() {
        super(tarea.class);
    }

    public DynamicList<tarea> getTareas() {
        tareas = all();
        return tareas;
    }

    public void setTareas(DynamicList<tarea> tareas) {
        this.tareas = tareas;
    }

    public tarea getTarea1() {
        if (tarea1 == null) {
            tarea1 = new tarea();
        }
        return tarea1;
    }

    public void setTarea1(tarea tarea1) {
        this.tarea1 = tarea1;
    }
    
    public Boolean persist() {
        tarea1.setId(all().getLength() + 1);
        return persist(tarea1);
    }
    
    public DynamicList<Vendedor> ordenarQuickSort(DynamicList<Vendedor> lista, Integer tipo, String field) throws Exception {
        Field attribute = Utiles.getField(Vendedor.class, field);
        Integer n = lista.getLength();
        Vendedor[] vendedores = lista.toArray();

        if (attribute != null) {
            int iteraciones = quickSort(vendedores, tipo, field, 0, vendedores.length - 1);
            System.out.println("Iteraciones realizadas: " + iteraciones);
        } else {
            throw new Exception("No existe el atributo: " + field);
        }

        return lista.toList(vendedores);
    }

    private int quickSort(Vendedor[] vendedores, Integer tipo, String field, int izq, int der) {
        int iteraciones = 0; // Contador de iteraciones

        if (izq < der) {
            int i = izq;
            int j = der;
            Vendedor pivote = vendedores[(izq + der) / 2];

            while (i <= j) {
                while (vendedores[i].compare(pivote, field, tipo) < 0) {
                    i++;
                    iteraciones++;
                }

                while (vendedores[j].compare(pivote, field, tipo) > 0) {
                    j--;
                    iteraciones++;
                }

                if (i <= j) {
                    Vendedor temp = vendedores[i];
                    vendedores[i] = vendedores[j];
                    vendedores[j] = temp;
                    i++;
                    j--;
                }
            }

            iteraciones += quickSort(vendedores, tipo, field, izq, j);
            iteraciones += quickSort(vendedores, tipo, field, i, der);
        }

        return iteraciones;
    }

}
