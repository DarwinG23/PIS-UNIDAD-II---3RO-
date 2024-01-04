/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matricula.controlador;

import dao.DaoImplement;
import lista.DynamicList;
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
    
}
