/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exeption;

import javax.annotation.processing.Messager;

/**
 *
 * @author USUARIO
 */
public class EmptyList extends Exception {
    public EmptyList(){
        
    }
    public EmptyList(String msg){
        super(msg);
    }
    
}
