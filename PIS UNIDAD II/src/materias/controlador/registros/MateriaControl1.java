/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package materias.controlador.registros;

import dao.DaoImplement;
import exeption.EmptyException;
import java.lang.reflect.Field;
import lista.DynamicList;
import materias.controlador.Utiles.utiles;
import materias.modelo.Materia;

/**
 *
 * @author elias
 */
    public class MateriaControl1 extends DaoImplement<Materia> {

    private DynamicList<Materia> listR = new DynamicList<>();
    private Materia materia;

    public MateriaControl1() {
        super(Materia.class);
    }

    public DynamicList<Materia> getMaterias() {
        return listR = all();
    }

    public void setListR(DynamicList<Materia> listR) {
        this.listR = listR;
    }

    public Materia getMateria() {
        if (materia == null) {
            materia = new Materia();
        }
        return materia;

    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Boolean persit() {
        materia.setId(all().getLength() + 1);

        return persist(materia);
    }
    public DynamicList<Materia> ordenarQuickSort(DynamicList<Materia> lista, Integer tipo, String field) throws Exception {
        Field attribute = utiles.getField(Materia.class, field);
        Integer n = lista.getLength();
        Materia[] tareas = lista.toArray();

        if (attribute != null) {
            int iteraciones = quickSort(tareas, tipo, field, 0, tareas.length - 1);
            System.out.println("Iteraciones realizadas: " + iteraciones);
        } else {
            throw new Exception("No existe el atributo: " + field);
        }

        return lista.toList(tareas);
    }

    private int quickSort(Materia[] tareas, Integer tipo, String field, int izq, int der) {
        int iteraciones = 0; // Contador de iteraciones

        if (izq < der) {
            int i = izq;
            int j = der;
            Materia pivote = tareas[(izq + der) / 2];

            while (i <= j) {
                while (tareas[i].compare(pivote, field, tipo)) {
                    i++;
                    iteraciones++;
                }

                while (tareas[j].compare(pivote, field, tipo)) {
                    j--;
                    iteraciones++;
                }

                if (i <= j) {
                    Materia temp = tareas[i];
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
    public DynamicList<Materia> busquedaBinaria(String texto, DynamicList<Materia> tipos, String criterio) {
    DynamicList<Materia> lista = new DynamicList<>();
    try {
        Materia [] aux = ordenarQuickSort(tipos, 0, criterio).toArray();
        int inicio = 0;
        int fin = aux.length - 1;
        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            Materia  p = aux[medio];
            String valorCriterio = obtenerValorCriterio1(p, criterio).toLowerCase();
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
    public DynamicList<Materia> busquedaLineal(String texto, DynamicList<Materia> tarea, String criterio) {
        DynamicList<Materia> lista = new DynamicList<>();

        try {
            Materia[] aux = ordenarQuickSort(tarea, 0, criterio).toArray();

            for (Materia p : aux) {
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



    private String obtenerValorCriterio(Materia materia, String criterio) {
        String FechaFinal=String.valueOf(materia.getFecha());
        switch (criterio.toLowerCase()) {
            case "nombre":
                return materia.getNombre();
            case "paralelo":
                return materia.getParalelo();
            case "fecha":
                return FechaFinal;
            default:
                throw new IllegalArgumentException("Criterio no válido");
        }
    }
    private String obtenerValorCriterio1(Materia materia, String criterio) {
        String FechaFinal=String.valueOf(materia.getFecha());
        switch (criterio.toLowerCase()) {
            case "ciclo":
                return materia.getCiclo();
            default:
                throw new IllegalArgumentException("Criterio no válido");
        }
    }
    

    
}
