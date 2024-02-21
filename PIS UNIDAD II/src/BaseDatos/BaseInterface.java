/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package BaseDatos;


import lista.DynamicList;

/**
 *
 * @author Alejandro
 */
public interface BaseInterface<T> {
    public Boolean persist(T data)throws Exception;
    public void merge(T data)throws Exception;
    public DynamicList<T> all();
    public T get(Integer id);
}
