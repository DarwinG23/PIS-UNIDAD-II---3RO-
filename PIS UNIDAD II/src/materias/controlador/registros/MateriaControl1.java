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
//     public DynamicList<Materia> quicksort(DynamicList<Materia> lista, Integer tipo, String field) throws EmptyException, Exception {
//        Materia[] materias = lista.toArray();
//        quicksort(materias, 0, materias.length - 1, tipo, field);
//        return lista.toList(materias);
//    }
//
//    public static void quicksort(Materia[] materias, int izq, int der, Integer tipo, String field) {
//        int i = izq;
//        int j = der;
//        Materia pivote = materias[izq];
//
//        while (i <= j) {
//            while (compare(materias[i], pivote, tipo, field) < 0) {
//                i++;
//            }
//            while (compare(materias[j], pivote, tipo, field) > 0) {
//                j--;
//            }
//            if (i <= j) {
//                Materia temp = materias[i];
//                materias[i] = materias[j];
//                materias[j] = temp;
//                i++;
//                j--;
//            }
//        }
//
//        if (izq < j) {
//            quicksort(materias, izq, j, tipo, field);
//        }
//        if (i < der) {
//            quicksort(materias, i, der, tipo, field);
//        }
//    }
//    public static int compare(Materia p1, Materia p2, Integer tipo, String field) {
//        int resultado = 0;
//
//        switch (field) {
//            case "Nombre":
//                resultado = p1.getNombre().compareTo(p2.getNombre());
//                break;
//            case "Paralelo":
//                resultado = p1.getParalelo().compareTo(p2.getParalelo());
//                break;
//            case "Ciclo":
//                resultado = p1.getCiclo().compareTo(p2.getCiclo());
//                break;
//                case "id_Materia":
//                resultado = p1.getId_Materia().compareTo(p2.getId_Materia());
//                break;
//            default:
//                throw new IllegalArgumentException("Campo de comparación no válido: " + field);
//        }
//
//        if (resultado == 0) {
//
//            return 0;
//        }
//
//        return resultado * tipo;
//    }

    public DynamicList<Materia> ordenar(DynamicList<Materia> lista, Integer tipo, String field) throws Exception, Exception {
        Field attribute = utiles.getField(Materia.class, field);
        Integer n = lista.getLength();
        Materia[] materias = lista.toArray();
        if (attribute != null) {
            for (int i = 0; i < n; i++) {
                int k = i;
                Materia t = materias[i];
                for (int j = i + 1; j < n; j++) {
                    if (materias[j].compare(t, field, tipo)) {
                        t = materias[j];
                        k = j;
                    }
                }
                materias[k] = materias[i];
                materias[i] = t;
            }
        } else {
            throw new Exception("No existe el criterio de busqueda");
        }
        return lista.toList(materias);
    }
    public DynamicList<Materia> ordenarQuickSort(DynamicList<Materia> lista, Integer tipo, String field) throws Exception {
        Field attribute = utiles.getField(Materia.class, field);
        Integer n = lista.getLength();
        Materia[] materias = lista.toArray();
        if (attribute != null) {
            quickSort(materias, tipo, field, 0, materias.length - 1);
        } else {
            throw new Exception("No existe el atributo: " + field);

        }

        return lista.toList(materias);
    }
    private void quickSort(Materia[] materias, Integer tipo, String field, int izq, int der) {
        if (izq < der) {
            int i = izq;
            int j = der;
            Materia pivote = materias[(izq + der) / 2];

            while (i <= j) {
                while (materias[i].compare(pivote, field, tipo) ) {
                    i++;
                }

                while (materias[j].compare(pivote, field, tipo) ) {
                    j--;
                }

                if (i <= j) {
                    Materia temp = materias[i];
                    materias[i] = materias[j];
                    materias[j] = temp;
                    i++;
                    j--;
                }
            }

            quickSort(materias, tipo, field, izq, j);
            quickSort(materias, tipo, field, i, der);
        }
    }
    

    public DynamicList<Materia> buscarPorCriterioLineal(String texto, DynamicList<Materia> materia, String criterio) {
        DynamicList<Materia> lista = new DynamicList<>();

        try {
            Materia[] aux = ordenar(materia, 0, criterio).toArray();

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

    public DynamicList<Materia> busquedaBinaria(String texto, DynamicList<Materia> materias, String criterio) {
    DynamicList<Materia> lista = new DynamicList<>();
    try {
        Materia[] aux = ordenar(materias, 0, criterio).toArray();
        int inicio = 0;
        int fin = aux.length - 1;
        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            Materia p = aux[medio];
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


    private String obtenerValorCriterio(Materia materia, String criterio) {
        switch (criterio.toLowerCase()) {
            case "nombre":
                return materia.getNombre();
            case "id_materia":
                return materia.getId_Materia();
            case "ciclo":
                return materia.getCiclo();
            case "paralelo":
                return materia.getParalelo();
            case "fecha":
                return materia.getFecha();
            default:
                throw new IllegalArgumentException("Criterio no válido");
        }
    }

    
}
