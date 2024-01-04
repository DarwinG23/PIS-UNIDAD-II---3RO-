/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matricula.controlador;

import dao.DaoImplement;
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
    
}
