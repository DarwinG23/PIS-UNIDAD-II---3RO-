/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matricula.controlador;

import dao.DaoImplement;
import lista.DynamicList;
import matricula.modelo.Ciclo;

/**
 *
 * @author darwi
 */
public class CicloControl extends DaoImplement<Ciclo> {
     private DynamicList<Ciclo> listCiclo;
    private Ciclo ciclo;

    public CicloControl() {
        super(Ciclo.class);
    }
    

    public DynamicList<Ciclo> getListCiclo() {
        listCiclo = all();
        return listCiclo;
    }

    public void setListCiclo(DynamicList<Ciclo> ListCiclo) {
        this.listCiclo = ListCiclo;
    }

    public Ciclo getCiclo() {
        if(ciclo ==null){
            ciclo= new Ciclo();
        }
        return ciclo;
    }

    public void setCiclo(Ciclo ciclo) {
        this.ciclo = ciclo;
    }
    
    public Boolean persist(){
        ciclo.setId(all().getLength()+1);
        return persist(ciclo);
    }
    public static void main(String[] args) {
        CicloControl cc = new CicloControl();
    }
    
}
