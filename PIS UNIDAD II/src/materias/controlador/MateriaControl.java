/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package materias.controlador;

import lista.DynamicList;
import materias.modelo.Materia;

/**
 *
 * @author elias
 */
public class MateriaControl {
    
    private Materia materia;
    private DynamicList<Materia> materias;
     public MateriaControl() {
        materia = new Materia();
        this.materias = new DynamicList<>();
    }


    public Materia getVendedor() {
        if(materia==null){
            materia = new Materia();
        }
            
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public DynamicList<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(DynamicList<Materia> materiaes) {
        this.materias = materiaes;
    }
  
    //Mwtodo guardar
    public Boolean guardar(){
        materia.setId(generarId());
        materias.add(materia);
        return true;
    }
    private Integer generarId(){
        return materias.getLength()+1;
  }
    
   
    
     public void imprimir(){
        System.out.println(materias.toString());
    }
   
}
 
