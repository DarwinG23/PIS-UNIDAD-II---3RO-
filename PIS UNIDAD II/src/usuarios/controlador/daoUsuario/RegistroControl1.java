/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.controlador.daoUsuario;

import dao.DaoImplement;
import lista.DynamicList;
import usuarios.modelo.Registro;

/**
 *
 * @author Alexander
 */
public class RegistroControl1 extends DaoImplement<Registro> {
    private DynamicList<Registro> registro;
    private Registro registro1;
    
     public RegistroControl1() {
         super(Registro.class);
    }

    public DynamicList<Registro> getRegistro() {
        registro =all();
        return registro;
    }

    public void setRegistro(DynamicList<Registro> docente) {
        this.registro= docente;
    }

    public Registro getRegistro1() {
        if (registro1 == null) {
            registro1 = new Registro();
        }
        return registro1;
    }

    public void setRegistro1(Registro registro1) {
        this.registro1 = registro1;
    }

    public Boolean persist(){
        registro1.setId(all().getLength()+ 1);
        return persist(registro1);
       
    }
}