/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matricula.controlador;

import dao.DaoImplement;
import lista.DynamicList;
import matricula.modelo.Facultad;

/**
 *
 * @author darwi
 */
public class FacultadControl extends DaoImplement<Facultad>{
     private DynamicList<Facultad> listFacultad;
    private Facultad facultad;

    public FacultadControl() {
       super(Facultad.class);
    }
    

    public DynamicList<Facultad> getListFacultades() {
        listFacultad = all();
        return listFacultad;
    }

    public void setListFacultad(DynamicList<Facultad> listFacultad) {
        this.listFacultad= listFacultad;
    }

    public Facultad getFacultad() {
        if (facultad == null){
            facultad = new Facultad();
        }
        return facultad;
    }

    public void setFacultad(Facultad facultad) {
        this.facultad = facultad;
    }
    
    public Boolean persist(){
        facultad.setId(all().getLength()+1);
        return persist(facultad);
    }
    
}
