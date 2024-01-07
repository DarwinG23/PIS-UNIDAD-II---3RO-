/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.controlador.daoUsuario;

import Controlador.utiles.Utiles;
import dao.DaoImplement;
import java.lang.reflect.Field;
import lista.DynamicList;
import usuarios.modelo.Docente;

/**
 *
 * @author USUARIO
 */
public class DocenteControl1 extends DaoImplement<Docente> {
      private DynamicList<Docente> docente;
    private Docente docente1;
    
     public DocenteControl1() {
         super(Docente.class);
    }

    public DynamicList<Docente> getDocente() {
        docente=all();
        return docente;
    }

    public void setDocente(DynamicList<Docente> docente) {
        this.docente= docente;
    }

    public Docente getDocente1() {
        if (docente1 == null) {
            docente1 = new Docente();
        }
        return docente1;
    }

    public void setDocente1(Docente docente1) {
        this.docente1 = docente1;
    }

    public Boolean persist(){
        docente1.setId(all().getLength()+ 1);
        return persist(docente1);
        
    }
    
    public DynamicList<Docente> ordenarQuickSort(DynamicList<Docente> lista, Integer tipo, String field) throws Exception {
        Field attribute = Utiles.getField(Docente.class, field);
        Integer n = lista.getLength();
        Docente[] tipos = lista.toArray();
        if (attribute != null) {
            quickSort(tipos, tipo, field, 0, tipos.length - 1);
        } else {
            throw new Exception("No existe el atributo: " + field);

        }

        return lista.toList(tipos);
    }

    private void quickSort(Docente[] docentes, Integer tipo, String field, int izq, int der) {
        if (izq < der) {
            int i = izq;
            int j = der;
            Docente pivote = docentes[(izq + der) / 2];

            while (i <= j) {
                while (docentes[i].compare(pivote, field, tipo)< 0 ) {
                    i++;
                }

                while (docentes[j].compare(pivote, field, tipo)> 0 ) {
                    j--;
                }

                if (i <= j) {
                    Docente temp = docentes[i];
                    docentes[i] = docentes[j];
                    docentes[j] = temp;
                    i++;
                    j--;
                }
            }

            quickSort(docentes, tipo, field, izq, j);
            quickSort(docentes, tipo, field, i, der);
        }
    }
    public DynamicList<Docente> busquedaBinaria(String texto, DynamicList<Docente> docentes, String criterio) {
    DynamicList<Docente> lista = new DynamicList<>();
    try {
        Docente [] aux = ordenarQuickSort(docentes, 0, criterio).toArray();
        int inicio = 0;
        int fin = aux.length - 1;
        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            Docente p = aux[medio];
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
    public DynamicList<Docente> buscarPorCriterioLineal(String texto, DynamicList<Docente> docente, String criterio) {
        DynamicList<Docente> lista = new DynamicList<>();

        try {
            Docente[] aux = ordenarQuickSort(docente, 0, criterio).toArray();

            for (Docente p : aux) {
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
     private String obtenerValorCriterio(Docente docente, String criterio) {
        switch (criterio) {
            case "nombre":
                return docente.getNombre();
            case "apellido":
                return docente.getApellido();
            case "cedula":
                return docente.getCedula();
            case "correo":
                return docente.getCorreo();
            case "edad":
                return docente.getEdad();
            case "aniosExperiencia":
                return docente.getAniosExperiencia();
            case "tituloProfesional":
                return docente.getTituloProfesional();
            default:
                throw new IllegalArgumentException("Criterio no válido");
        }
    }
     public static void main(String[] args) {
            try {
            DocenteControl1 pc = new   DocenteControl1();      
            System.out.println("Lista Original:");
            System.out.println(pc.all().toString());
            System.out.println("-----------");
            System.out.println(pc.ordenarQuickSort(pc.all(),1,"aniosExperiencia").toString());

        } catch (Exception e) {
                System.out.println("Error");
        }
    }
    
    
}
