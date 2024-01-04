/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matricula.controlador;

import dao.DaoImplement;
import lista.DynamicList;
import matricula.modelo.Carrera;

/**
 *
 * @author darwi
 */
public class CarreraControl extends DaoImplement<Carrera>{
    private DynamicList<Carrera> listCarrera;
    private Carrera carrera;

    public CarreraControl() {
        super(Carrera.class);
    }
    

    public DynamicList<Carrera> getListCarrera() {
        listCarrera = all();
        return listCarrera;
    }

    public void setListCarrera(DynamicList<Carrera> ListCarrera) {
        this.listCarrera = ListCarrera;
    }

    public Carrera getCarrera() {
        if(carrera ==null){
            carrera= new Carrera();
        }
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }
    
    public Boolean persist(){
        carrera.setId(all().getLength()+1);
        return persist(carrera);
    }
    
}
