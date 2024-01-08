/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package materias.modelo.Dao;

import dao.DaoImplement;
import lista.DynamicList;
import materias.modelo.Materia;

/**
 *
 * @author elias
 */
    public class DaoMateria extends DaoImplement<Materia> {

    private DynamicList<Materia> MateriasLista = new DynamicList<>();
    private Materia materia;

    public DaoMateria() {
        super(Materia.class);
    }

    public DynamicList<Materia> getMateriasLista() {
        MateriasLista = all();
        return MateriasLista;
    }

    public void setMateriasLista(DynamicList<Materia> MateriasLista) {
        this.MateriasLista = MateriasLista;
    }

    public Materia getMateria() {
        if (materia == null) {
            materia = new Materia();
        }
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Boolean Persist() {
        materia.setId(all().getLength()+ 1);
        return persist (materia);
    }
   }
    
