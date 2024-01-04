/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.thoughtworks.xstream.XStream;
import lista.DynamicList;
import exeption.EmptyException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author darwi
 */
public class DaoImplement <T> implements DaoInterface<T>{
    private Class <T> clazz;
    private XStream connection;
    private String URL;
    
    public DaoImplement(Class<T> clazz){
        this.clazz = clazz;
        connection = Bridge.getConnection();
        URL = Bridge.URL+clazz.getSimpleName() + ".json";
    }

    @Override
    public Boolean persist(T data) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        DynamicList<T> ld = all();
        ld.add(data);
        try {
            connection.toXML(ld, new FileWriter(URL));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    //Actualizar lista
    public Boolean marge(T data, Integer id) {
        DynamicList<T> ld = all();
        try {
            ld.obtenerNodo(id).setInfo(data);
        } catch (EmptyException ex) {
            Logger.getLogger(DaoImplement.class.getName()).log(Level.SEVERE,  "No se pudo actualizar", ex);
        }
        try {
            connection.toXML(ld, new FileWriter(URL));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public DynamicList<T> all() {
       DynamicList<T> dl = new DynamicList<>();
        try {
            dl = (DynamicList<T>)connection.fromXML(new FileReader(URL));
        } catch (Exception e) {
        }
        return dl;
    }

    @Override
    public T get(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
