/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.controlador.daoUsuario;

import Controlador.utiles.Utiles;
import dao.DaoImplement;
import java.lang.reflect.Field;
import lista.DynamicList;
import usuarios.modelo.Estudiante;

/**
 *
 * @author Alexander
 */
public class EstudianteControlDao extends DaoImplement<Estudiante> {

    private DynamicList<Estudiante> listaEstudiante = new DynamicList<>();
    private Estudiante estudiante;
    
    public EstudianteControlDao() {
        super(Estudiante.class);
    }

    public DynamicList<Estudiante> getListaEstudiante() {
        listaEstudiante = all();
        return listaEstudiante;
    }

    public void setListaEstudiante(DynamicList<Estudiante> listaEstudiante) {
        this.listaEstudiante = listaEstudiante;
    }

    public Estudiante getEstudiante() {
        if(estudiante == null){
            estudiante = new Estudiante();
        }
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }
    
        
    public Boolean Persist(){
        estudiante.setIdEstudiante(all().getLength()+1);
        return persist(estudiante);
    }
    
    public DynamicList<Estudiante> ordenarQuickSort(DynamicList<Estudiante> lista, Integer tipo, String field) throws Exception {
        Field attribute = Utiles.getField(Estudiante.class, field);
        Integer n = lista.getLength();
        Estudiante[] estudiante = lista.toArray();
        if (attribute != null) {
            quickSort(estudiante, tipo, field, 0, estudiante.length - 1);
        } else {
            throw new Exception("No existe el atributo: " + field);

        }

        return lista.toList(estudiante);
    }

    private void quickSort(Estudiante[] estudiantes, Integer tipo, String field, int izq, int der) {
        if (izq < der) {
            int i = izq;
            int j = der;
            Estudiante pivote = estudiantes[(izq + der) / 2];

            while (i <= j) {
                while (estudiantes[i].compare(pivote, field, tipo)< 0 ) {
                    i++;
                }

                while (estudiantes[j].compare(pivote, field, tipo)> 0 ) {
                    j--;
                }

                if (i <= j) {
                    Estudiante temp = estudiantes[i];
                    estudiantes[i] = estudiantes[j];
                    estudiantes[j] = temp;
                    i++;
                    j--;
                }
            }

            quickSort(estudiantes, tipo, field, izq, j);
            quickSort(estudiantes, tipo, field, i, der);
        }
    }
    public DynamicList<Estudiante> busquedaBinaria(String texto, DynamicList<Estudiante> estudiantes, String criterio) {
    DynamicList<Estudiante> lista = new DynamicList<>();
    try {
       Estudiante [] aux = ordenarQuickSort(estudiantes, 0, criterio).toArray();
        int inicio = 0;
        int fin = aux.length - 1;
        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            Estudiante p = aux[medio];
            String valorCriterio = obtenerValorCriterio(p, criterio);
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
    public DynamicList<Estudiante> buscarPorCriterioLineal(String texto, DynamicList<Estudiante> estudiante, String criterio) {
        DynamicList<Estudiante> lista = new DynamicList<>();

        try {
            Estudiante[] aux = ordenarQuickSort(estudiante, 0, criterio).toArray();

            for (Estudiante p : aux) {
                String valor = obtenerValorCriterio(p, criterio);
                if (valor.contains(texto.toLowerCase())) {
                    lista.add(p);
                }
            }
        } catch (Exception e) {
            System.err.println("Error en buscar" + e.getMessage());
        }

        return lista;
    }
     private String obtenerValorCriterio(Estudiante estudiante, String criterio) {
        switch (criterio) {
            case "nombre":
                return estudiante.getNombre();
            case "apellido":
                return estudiante.getApellido();
            case "cedula":
                return estudiante.getCedula();
            case "correo":
                return estudiante.getCorreo();
            case "edad":
                return estudiante.getEdad();
            case "promedioAcademico":
                return estudiante.getPromedioAcademico();
           
            default:
                throw new IllegalArgumentException("Criterio no válido");
        }
    }

}
