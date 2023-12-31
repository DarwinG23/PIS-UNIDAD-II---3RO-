/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matricula.controlador;

import dao.DaoImplement;
import lista.DynamicList;
import matricula.modelo.Matricula;

/**
 *
 * @author darwi
 */
public class MatriculaControl extends DaoImplement<Matricula>{
    private DynamicList<Matricula> listMatricula;
    private Matricula matricula;

    public MatriculaControl() {
        super(Matricula.class);
    }
    

    public DynamicList<Matricula> getListMatricula() {
        listMatricula = all();
        return listMatricula;
    }

    public void setListMatricula(DynamicList<Matricula> ListC) {
        this.listMatricula = ListC;
    }

    public Matricula getMatricula() {
        if(matricula ==null){
            matricula = new Matricula();
        }
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }
    
    public Boolean persist(){
        matricula.setId(all().getLength()+1);
        return persist(matricula);
    }
    
}
