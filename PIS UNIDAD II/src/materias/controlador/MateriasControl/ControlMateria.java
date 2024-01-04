/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package materias.controlador.MateriasControl;

import dao.DaoImplement;
import lista.DynamicList;
import materias.modelo.Materia;

/**
 *
 * @author elias
 */
public class ControlMateria extends DaoImplement<Materia> {

    private DynamicList<Materia> materia;
    private Materia materia1;

    public ControlMateria() {
        super(Materia.class);
    }

    public DynamicList<Materia> getMateria() {
        materia = all();
        return materia;
    }

    public void setMateria(DynamicList<Materia> materia) {
        this.materia = materia;
    }

    public Materia getMateria1() {
        if (materia1 == null) {
            materia1 = new Materia();
        }
        return materia1;
    }

    public void setMateria1(Materia materia1) {
        this.materia1 = materia1;
    }

    public Boolean persist() {
        materia1.setId(all().getLength() + 1);
        return persist(materia1);
    }

}

