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

/**
 *
 * @author darwi
 */
public class CursaControl extends DaoImplement<Cursa>{
    private DynamicList<Cursa> listCursa;
    private Cursa cursa;

    public CursaControl() {
        super(Cursa.class);
    }
    

    public DynamicList<Cursa> getListCursa() {
        listCursa = all();
        return listCursa;
    }

    public void setListCursa(DynamicList<Cursa> ListCursa) {
        this.listCursa = ListCursa;
    }

    public Cursa getCursa() {
        if(cursa ==null){
            cursa = new Cursa();
        }
        return cursa;
    }

    public void setCursa(Cursa cursa) {
        this.cursa = cursa;
    }
    
    public Boolean persist(){
        cursa.setId(all().getLength()+1);
        return persist(cursa);
    }
     public DynamicList<Cursa> ordenar(DynamicList<Cursa> lista, Integer tipo, String field) throws Exception, Exception {
        Field attribute = utiles.getField(Cursa.class, field);
        Integer n = lista.getLength();
        Cursa[] cursas = lista.toArray();
        if (attribute != null) {
            for (int i = 0; i < n; i++) {
                int k = i;
                Cursa t = cursas[i];
                for (int j = i + 1; j < n; j++) {
                    if (cursas[j].compare(t, field, tipo)) {
                        t = cursas[j];
                        k = j;
                    }
                }
                cursas[k] = cursas[i];
                cursas[i] = t;
            }
        } else {
            throw new Exception("No existe el criterio de busqueda");
        }
        return lista.toList(cursas);
    }
    public DynamicList<Cursa> ordenarQuickSort(DynamicList<Cursa> lista, Integer tipo, String field) throws Exception {
        Field attribute = utiles.getField(Cursa.class, field);
        Integer n = lista.getLength();
        Cursa[] cursas = lista.toArray();
        if (attribute != null) {
            quickSort(cursas, tipo, field, 0, cursas.length - 1);
        } else {
            throw new Exception("No existe el atributo: " + field);

        }

        return lista.toList(cursas);
    }
    private void quickSort(Cursa[] cursas, Integer tipo, String field, int izq, int der) {
        if (izq < der) {
            int i = izq;
            int j = der;
            Cursa pivote = cursas[(izq + der) / 2];

            while (i <= j) {
                while (cursas[i].compare(pivote, field, tipo) ) {
                    i++;
                }

                while (cursas[j].compare(pivote, field, tipo) ) {
                    j--;
                }

                if (i <= j) {
                    Cursa temp = cursas[i];
                    cursas[i] = cursas[j];
                    cursas[j] = temp;
                    i++;
                    j--;
                }
            }

            quickSort(cursas, tipo, field, izq, j);
            quickSort(cursas, tipo, field, i, der);
        }
    }
    

    public DynamicList<Cursa> buscarPorCriterioLineal(String texto, DynamicList<Cursa> cursa, String criterio) {
        DynamicList<Cursa> lista = new DynamicList<>();

        try {
            Cursa[] aux = ordenar(cursa, 0, criterio).toArray();

            for (Cursa p : aux) {
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

    public DynamicList<Cursa> busquedaBinaria(String texto, DynamicList<Cursa> cursas, String criterio) {
    DynamicList<Cursa> lista = new DynamicList<>();
    try {
        Cursa[] aux = ordenar(cursas, 0, criterio).toArray();
        int inicio = 0;
        int fin = aux.length - 1;
        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
           Cursa p = aux[medio];
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


    private String obtenerValorCriterio(Cursa cursa, String criterio) {
        String idEstudiante=String.valueOf(cursa.getId_estudiante());
        String idDocente=String.valueOf(cursa.getId_docente());
        String idMateria=String.valueOf(cursa.getId_materia());
         String idMaricula=String.valueOf(cursa.getId_matricula());
        switch (criterio) {
            case "id_estudiante":
                return idEstudiante;
            case "id_docente":
                return idDocente;
            case "id_materia":
                return idMateria;
            case "id_matricula":
                return idMaricula;
             case "paralelo":
                return cursa.getParalelo();
            default:
                throw new IllegalArgumentException("Criterio no válido");
        }
    }
    
}
