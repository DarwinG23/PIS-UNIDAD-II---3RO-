/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matricula.controlador;

import dao.DaoImplement;
import exeption.EmptyException;
import lista.DynamicList;
import matricula.modelo.Malla;

/**
 *
 * @author darwi
 */
public class MallaControl extends DaoImplement<Malla>{
    private DynamicList<Malla> listMalla;
    private Malla malla;

    public MallaControl() {
        super(Malla.class);
    }
    

    public DynamicList<Malla> getListMalla() {
        listMalla = all();
        return listMalla;
    }

    public void setListMalla(DynamicList<Malla> ListMalla) {
        this.listMalla = ListMalla;
    }

    public Malla getMalla() {
        if(malla ==null){
            malla = new Malla();
        }
        return malla;
    }

    public void setMalla(Malla malla) {
        this.malla = malla;
    }
    
    public Boolean persist(){
        malla.setId(all().getLength()+1);
        return persist(malla);
    }
    
    public DynamicList<Malla> ordenar(DynamicList<Malla> autos, String field, Integer tipo) {
        Malla[] array = autos.toArray();
        array = quicksort(array, 0, array.length -1 , field, tipo);
        return autos.toList(array);
    }

    public Malla[] quicksort (Malla[] array, int izq, int der, String field, Integer tipo) {
        if (izq >= der) {
            return array;
        }
        int i = izq, d = der;
        if (izq != der) {
            int pivote = izq;
            Malla aux;
            while (izq != der) {
                if(tipo == 0){
                    while ((array[der].compare(array[pivote], field, 1) || array[der].compare(array[pivote], field, 2)) && izq < der) {
                        der--;
                        while (array[izq].compare(array[pivote], field, 0) && izq < der) {
                            izq++;
                        }
                    }
                    if (izq != der) {
                        aux = array[der];
                        array[der] = array[izq];
                        array[izq] = aux;
                    }
                }else if(tipo == 1){
                    while ((array[der].compare(array[pivote], field, 0) || array[der].compare(array[pivote], field, 2)) && izq < der) {
                        der--;
                        while (array[izq].compare(array[pivote], field, 1) && izq < der) {
                            izq++;
                        }
                    }
                    if (izq != der) {
                        aux = array[izq];
                        array[izq] = array[der];
                        array[der] = aux;
                    }
                }  
                if (izq == der) {
                    quicksort(array, i, izq-1, field, tipo);
                    quicksort(array, izq+1,d,field, tipo);
                }
            }          
        }
        return array;
    }
    
    
    public DynamicList<Malla> busquedaBinaria(DynamicList<Malla> autos, String texto, String field){
        int centro, primero, ultimo;
        DynamicList<Malla> lista = new DynamicList<>();
        Malla[] array = ordenar(autos, field, 0).toArray();
        Malla valorCentro;
        primero = 0;
        ultimo =  array.length - 1;
        while(primero <= ultimo){
            centro = (primero + ultimo) / 2;
            valorCentro = array[centro];
            if(valorCentro.buscar(texto, field, 0)){
                lista.add(valorCentro);
            }
            if (valorCentro.buscar(texto, field, 1)){
                ultimo = centro - 1; //Desplaza a la izquierda
            }else{
                primero = centro + 1; //Desplaza a la derecha
            }   
        }
        return lista;    
    }
    
}
