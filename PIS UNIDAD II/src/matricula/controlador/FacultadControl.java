/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matricula.controlador;

import dao.DaoImplement;
import java.lang.reflect.Field;
import lista.DynamicList;
import materias.controlador.Utiles.utiles;
import matricula.modelo.Cursa;
import matricula.modelo.Facultad;

/**
 *
 * @author darwi
 */
public class FacultadControl extends DaoImplement<Facultad>{
     private DynamicList<Facultad> listFacultad;
    private Facultad facultad;

    public FacultadControl() {
       super(Facultad.class);
    }
    

    public DynamicList<Facultad> getListFacultades() {
        listFacultad = all();
        return listFacultad;
    }

    public void setListFacultad(DynamicList<Facultad> listFacultad) {
        this.listFacultad= listFacultad;
    }

    public Facultad getFacultad() {
        if (facultad == null){
            facultad = new Facultad();
        }
        return facultad;
    }

    public void setFacultad(Facultad facultad) {
        this.facultad = facultad;
    }
    
    public Boolean persist(){
        facultad.setId(all().getLength()+1);
        return persist(facultad);
    }
     public DynamicList<Facultad> ordenar(DynamicList<Facultad> lista, Integer tipo, String field) throws Exception, Exception {
        Field attribute = utiles.getField(Facultad.class, field);
        Integer n = lista.getLength();
        Facultad[] facultades = lista.toArray();
        if (attribute != null) {
            for (int i = 0; i < n; i++) {
                int k = i;
                Facultad t = facultades[i];
                for (int j = i + 1; j < n; j++) {
                    if (facultades[j].compare(t, field, tipo)) {
                        t = facultades[j];
                        k = j;
                    }
                }
                facultades[k] = facultades[i];
                facultades[i] = t;
            }
        } else {
            throw new Exception("No existe el criterio de busqueda");
        }
        return lista.toList(facultades);
    }
    public DynamicList<Facultad> ordenarQuickSort(DynamicList<Facultad> lista, Integer tipo, String field) throws Exception {
        Field attribute = utiles.getField(Facultad.class, field);
        Integer n = lista.getLength();
        Facultad[] facultad = lista.toArray();
        if (attribute != null) {
            quickSort(facultad, tipo, field, 0, facultad.length - 1);
        } else {
            throw new Exception("No existe el atributo: " + field);

        }

        return lista.toList(facultad);
    }
    private void quickSort(Facultad[] facultades, Integer tipo, String field, int izq, int der) {
        if (izq < der) {
            int i = izq;
            int j = der;
            Facultad pivote = facultades[(izq + der) / 2];

            while (i <= j) {
                while (facultades[i].compare(pivote, field, tipo) ) {
                    i++;
                }

                while (facultades[j].compare(pivote, field, tipo) ) {
                    j--;
                }

                if (i <= j) {
                    Facultad temp = facultades[i];
                    facultades[i] = facultades[j];
                    facultades[j] = temp;
                    i++;
                    j--;
                }
            }

            quickSort(facultades, tipo, field, izq, j);
            quickSort(facultades, tipo, field, i, der);
        }
    }
    

    public DynamicList<Facultad> buscarPorCriterioLineal(String texto, DynamicList<Facultad> facultad, String criterio) {
        DynamicList<Facultad> lista = new DynamicList<>();

        try {
            Facultad[] aux = ordenar(facultad, 0, criterio).toArray();

            for (Facultad p : aux) {
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

    public DynamicList<Facultad> busquedaBinaria(String texto, DynamicList<Facultad> facultad, String criterio) {
    DynamicList<Facultad> lista = new DynamicList<>();
    try {
        Facultad[] aux = ordenar(facultad, 0, criterio).toArray();
        int inicio = 0;
        int fin = aux.length - 1;
        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
           Facultad p = aux[medio];
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


    private String obtenerValorCriterio(Facultad facultad, String criterio) {
        String numBloques=String.valueOf(facultad.getNumBloques());

        switch (criterio) {
            case "nombre":
                return facultad.getNombre();
            case "ubicacion":
                return facultad.getUbicacion();
            case "numBloques":
                return numBloques;
            default:
                throw new IllegalArgumentException("Criterio no válido");
        }
    }
    
    
}
