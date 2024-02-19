/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matricula.controlador;

import dao.DaoImplement;
import java.lang.reflect.Field;
import lista.DynamicList;
import matricula.controlador.Utiles1.utiles;
import matricula.modelo.Ciclo;

/**
 *
 * @author darwi
 */
public class CicloControl extends DaoImplement<Ciclo> {
     private DynamicList<Ciclo> listCiclo;
    private Ciclo ciclo;

    public CicloControl() {
        super(Ciclo.class);
    }
    

    public DynamicList<Ciclo> getListCiclo() {
        listCiclo = all();
        return listCiclo;
    }

    public void setListCiclo(DynamicList<Ciclo> ListCiclo) {
        this.listCiclo = ListCiclo;
    }

    public Ciclo getCiclo() {
        if(ciclo ==null){
            ciclo= new Ciclo();
        }
        return ciclo;
    }

    public void setCiclo(Ciclo ciclo) {
        this.ciclo = ciclo;
    }
    
    public Boolean persist(){
        ciclo.setId(all().getLength()+1);
        return persist(ciclo);
    }
    public static void main(String[] args) {
        CicloControl cc = new CicloControl();
    }
     public DynamicList<Ciclo> ordenar(DynamicList<Ciclo> lista, Integer tipo, String field) throws Exception, Exception {
        Field attribute = utiles.getField(Ciclo.class, field);
        Integer n = lista.getLength();
        Ciclo[] ciclo = lista.toArray();
        if (attribute != null) {
            for (int i = 0; i < n; i++) {
                int k = i;
                Ciclo t = ciclo[i];
                for (int j = i + 1; j < n; j++) {
                    if (ciclo[j].compare(t, field, tipo)) {
                        t = ciclo[j];
                        k = j;
                    }
                }
                ciclo[k] = ciclo[i];
                ciclo[i] = t;
            }
        } else {
            throw new Exception("No existe el criterio de busqueda");
        }
        return lista.toList(ciclo);
    }
    public DynamicList<Ciclo> ordenarQuickSort(DynamicList<Ciclo> lista, Integer tipo, String field) throws Exception {
        Field attribute = utiles.getField(Ciclo.class, field);
        Integer n = lista.getLength();
        Ciclo[] ciclos = lista.toArray();
        if (attribute != null) {
            quickSort(ciclos, tipo, field, 0, ciclos.length - 1);
        } else {
            throw new Exception("No existe el atributo: " + field);

        }

        return lista.toList(ciclos);
    }
    private void quickSort(Ciclo[] ciclos, Integer tipo, String field, int izq, int der) {
        if (izq < der) {
            int i = izq;
            int j = der;
            Ciclo pivote = ciclos[(izq + der) / 2];

            while (i <= j) {
                while (ciclos[i].compare(pivote, field, tipo) ) {
                    i++;
                }

                while (ciclos[j].compare(pivote, field, tipo) ) {
                    j--;
                }

                if (i <= j) {
                    Ciclo temp = ciclos[i];
                    ciclos[i] = ciclos[j];
                    ciclos[j] = temp;
                    i++;
                    j--;
                }
            }

            quickSort(ciclos, tipo, field, izq, j);
            quickSort(ciclos, tipo, field, i, der);
        }
    }
    

    public DynamicList<Ciclo> buscarPorCriterioLineal(String texto, DynamicList<Ciclo> ciclo, String criterio) {
        DynamicList<Ciclo> lista = new DynamicList<>();

        try {
            Ciclo[] aux = ordenar(ciclo, 0, criterio).toArray();

            for (Ciclo p : aux) {
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

    public DynamicList<Ciclo> busquedaBinaria(String texto, DynamicList<Ciclo> ciclos, String criterio) {
    DynamicList<Ciclo> lista = new DynamicList<>();
    try {
        Ciclo[] aux = ordenar(ciclos, 0, criterio).toArray();
        int inicio = 0;
        int fin = aux.length - 1;
        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
           Ciclo p = aux[medio];
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


    private String obtenerValorCriterio(Ciclo ciclo, String criterio) {
        String numCiclos=String.valueOf(ciclo.getNumCiclo());
        String idMalla=String.valueOf(ciclo.getId_Malla());
        switch (criterio) {
            case "numCiclo":
                return numCiclos;
            case "id_Malla":
                return idMalla;
            
            default:
                throw new IllegalArgumentException("Criterio no válido");
        }
    }
    
}
