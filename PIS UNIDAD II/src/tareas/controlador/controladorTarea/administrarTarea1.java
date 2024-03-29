/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tareas.controlador.controladorTarea;

import dao.DaoImplement;
import java.lang.reflect.Field;
import lista.DynamicList;
import tareas.modelo.tarea;
import tareas.utiles.utiles;

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
    
    public DynamicList<tarea> ordenarQuickSort(DynamicList<tarea> lista, Integer tipo, String field) throws Exception {
        Field attribute = utiles.getField(tarea.class, field);
        Integer n = lista.getLength();
        tarea[] tareas = lista.toArray();

        if (attribute != null) {
            int iteraciones = quickSort(tareas, tipo, field, 0, tareas.length - 1);
            System.out.println("Iteraciones realizadas: " + iteraciones);
        } else {
            throw new Exception("No existe el atributo: " + field);
        }

        return lista.toList(tareas);
    }

    private int quickSort(tarea[] tareas, Integer tipo, String field, int izq, int der) {
        int iteraciones = 0; // Contador de iteraciones

        if (izq < der) {
            int i = izq;
            int j = der;
            tarea pivote = tareas[(izq + der) / 2];

            while (i <= j) {
                while (tareas[i].compare(pivote, field, tipo) < 0) {
                    i++;
                    iteraciones++;
                }

                while (tareas[j].compare(pivote, field, tipo) > 0) {
                    j--;
                    iteraciones++;
                }

                if (i <= j) {
                    tarea temp = tareas[i];
                    tareas[i] = tareas[j];
                    tareas[j] = temp;
                    i++;
                    j--;
                }
            }

            iteraciones += quickSort(tareas, tipo, field, izq, j);
            iteraciones += quickSort(tareas, tipo, field, i, der);
        }

        return iteraciones;
    }
    public DynamicList<tarea> busquedaBinaria(String texto, DynamicList<tarea> tipos, String criterio) {
    DynamicList<tarea> lista = new DynamicList<>();
    try {
        tarea [] aux = ordenarQuickSort(tipos, 0, criterio).toArray();
        int inicio = 0;
        int fin = aux.length - 1;
        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            tarea  p = aux[medio];
            String valorCriterio = obtenerValorCriterio(p, criterio).toLowerCase();
            if (valorCriterio.contains(texto.toLowerCase())) {
                lista.add(p);
            }
            if (valorCriterio.compareTo(texto.toLowerCase()) < 0) {
                inicio = medio + 1; // El elemento está en la mitad derecha
            } else {
                fin = medio - 1; // El elemento está en la mitad izquierda
            }
        }
    } catch (Exception e) {
        System.out.println("No existe el valor a comparar");
    }

    return lista;
    }
    public DynamicList<tarea> busquedaLineal(String texto, DynamicList<tarea> tarea, String criterio) {
        DynamicList<tarea> lista = new DynamicList<>();

        try {
            tarea[] aux = ordenarQuickSort(tarea, 0, criterio).toArray();

            for (tarea p : aux) {
                String valor = obtenerValorCriterio(p, criterio).toLowerCase();
                if (valor.contains(texto.toLowerCase())) {
                    lista.add(p);
                }
            }
        } catch (Exception e) {
            System.err.println("Error en buscar" + e.getMessage());
        }

        return lista;
    }

    private String obtenerValorCriterio(tarea tarea, String criterio) {
        String id_tarea=String.valueOf(tarea.getId_tarea());
        String id_estado=String.valueOf(tarea.getId_estado());
        String FechaInicio=String.valueOf(tarea.getFecha_Inicio());
        String FechaFinal=String.valueOf(tarea.getFecha_Final());
        switch (criterio) {
            case "Id_TipoTarea":
                return id_tarea;
            case "Titulo_Tarea":
                return tarea.getTituloTarea();
            case "Fecha_Inicio":
                return FechaInicio;
            case "Fecha_Final":
                return FechaFinal;
            case "Descripcion":
                return tarea.getDescripcion();
            case "Id_EstadoTarea":
                return id_estado;
            default:
                throw new IllegalArgumentException("Criterio no válido");
        }
    }
    
    
      public static void main(String[] args) {
            try {
            administrarTarea1 pc = new  administrarTarea1 ();      
            System.out.println("Lista Original:");
            System.out.println(pc.all().toString());
            System.out.println("-----------");
            System.out.println(pc.ordenarQuickSort(pc.all(),0,"id_estado").toString());
           
        } catch (Exception e) {
                System.out.println("Error");
        }
    }
}
