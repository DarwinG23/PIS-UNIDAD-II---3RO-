/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matricula.controlador;

import dao.DaoImplement;
import java.lang.reflect.Field;
import lista.DynamicList;
import matricula.modelo.Carrera;
import matricula.controlador.Utiles1.utiles;

/**
 *
 * @author darwi
 */
public class CarreraControl extends DaoImplement<Carrera>{
    private DynamicList<Carrera> listCarrera;
    private Carrera carrera;

    public CarreraControl() {
        super(Carrera.class);
    }
    

    public DynamicList<Carrera> getListCarrera() {
        listCarrera = all();
        return listCarrera;
    }

    public void setListCarrera(DynamicList<Carrera> ListCarrera) {
        this.listCarrera = ListCarrera;
    }

    public Carrera getCarrera() {
        if(carrera ==null){
            carrera= new Carrera();
        }
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }
    
    public Boolean persist(){
        carrera.setId(all().getLength()+1);
        return persist(carrera);
    }
    public DynamicList<Carrera> ordenar(DynamicList<Carrera> lista, Integer tipo, String field) throws Exception, Exception {
        Field attribute = utiles.getField(Carrera.class, field);
        Integer n = lista.getLength();
        Carrera[] carreras = lista.toArray();
        if (attribute != null) {
            for (int i = 0; i < n; i++) {
                int k = i;
                Carrera t = carreras[i];
                for (int j = i + 1; j < n; j++) {
                    if (carreras[j].compare(t, field, tipo)) {
                        t = carreras[j];
                        k = j;
                    }
                }
                carreras[k] = carreras[i];
                carreras[i] = t;
            }
        } else {
            throw new Exception("No existe el criterio de busqueda");
        }
        return lista.toList(carreras);
    }
    public DynamicList<Carrera> ordenarQuickSort(DynamicList<Carrera> lista, Integer tipo, String field) throws Exception {
        Field attribute = utiles.getField(Carrera.class, field);
        Integer n = lista.getLength();
        Carrera[] carreras = lista.toArray();
        if (attribute != null) {
            quickSort(carreras, tipo, field, 0, carreras.length - 1);
        } else {
            throw new Exception("No existe el atributo: " + field);

        }

        return lista.toList(carreras);
    }
    private void quickSort(Carrera[] carreras, Integer tipo, String field, int izq, int der) {
        if (izq < der) {
            int i = izq;
            int j = der;
            Carrera pivote = carreras[(izq + der) / 2];

            while (i <= j) {
                while (carreras[i].compare(pivote, field, tipo) ) {
                    i++;
                }

                while (carreras[j].compare(pivote, field, tipo) ) {
                    j--;
                }

                if (i <= j) {
                    Carrera temp = carreras[i];
                    carreras[i] = carreras[j];
                    carreras[j] = temp;
                    i++;
                    j--;
                }
            }

            quickSort(carreras, tipo, field, izq, j);
            quickSort(carreras, tipo, field, i, der);
        }
    }
    

    public DynamicList<Carrera> buscarPorCriterioLineal(String texto, DynamicList<Carrera> carrera, String criterio) {
        DynamicList<Carrera> lista = new DynamicList<>();

        try {
            Carrera[] aux = ordenar(carrera, 0, criterio).toArray();

            for (Carrera p : aux) {
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

    public DynamicList<Carrera> busquedaBinaria(String texto, DynamicList<Carrera> carreras, String criterio) {
    DynamicList<Carrera> lista = new DynamicList<>();
    try {
        Carrera[] aux = ordenar(carreras, 0, criterio).toArray();
        int inicio = 0;
        int fin = aux.length - 1;
        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
           Carrera p = aux[medio];
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


    private String obtenerValorCriterio(Carrera carrera, String criterio) {
//        String numCiclos=String.valueOf(carrera.getNumCiclos());
        String duracionAnios=String.valueOf(carrera.getDuracionAnios());
        switch (criterio) {
            case "nombre":
                return carrera.getNombre();
            case "descripcion":
                return carrera.getDescripcion();
            case "duracionAnios":
                return duracionAnios;
            
            default:
                throw new IllegalArgumentException("Criterio no válido");
        }
    }
    
}
