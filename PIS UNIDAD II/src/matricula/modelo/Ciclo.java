/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matricula.modelo;

import java.util.Date;
import materias.modelo.Materia;
import lista.DynamicList;

/**
 *
 * @author darwi
 */
public class Ciclo {

    private Integer numCiclo;
    private Integer id;
    private Integer id_Malla;
    private DynamicList<Materia> materias;

    public Ciclo(Integer numCiclo, Integer id, Integer id_Malla, DynamicList<Materia> materias) {
        this.numCiclo = numCiclo;
        this.id = id;
        this.id_Malla = id_Malla;
        this.materias = materias;
    }

    public Ciclo() {
        this.numCiclo = null;
        this.id = null;
        this.id_Malla = null;
        this.materias = null;
    }

    public Integer getNumCiclo() {
        return numCiclo;
    }

    public void setNumCiclo(Integer numCiclo) {
        this.numCiclo = numCiclo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_Malla() {
        return id_Malla;
    }

    public void setId_Malla(Integer id_Malla) {
        this.id_Malla = id_Malla;
    }

    public DynamicList<Materia> getMaterias() {
        if (materias == null) {
            materias = new DynamicList();
        }
        return materias;
    }

    public void setMaterias(DynamicList<Materia> materias) {
        this.materias = materias;
    }

    @Override
    public String toString() {
        return numCiclo.toString();
    }

    public Boolean compare(Ciclo p, String field, Integer type) {
        switch (type) {
            case 0:
                if (field.equalsIgnoreCase("numCiclo")) {
                    return numCiclo.compareTo(p.getNumCiclo()) < 0;
                } else if (field.equalsIgnoreCase("id_Malla")) {
                    return id_Malla.compareTo(p.getId_Malla()) < 0;
                } else if (field.equalsIgnoreCase("id")) {
                    return id.compareTo(p.getId()) < 0;
                }
            case 1:
                if (field.equalsIgnoreCase("numCiclo")) {
                    return numCiclo.compareTo(p.getNumCiclo()) > 0;
                } else if (field.equalsIgnoreCase("id_Malla")) {
                    return id_Malla.compareTo(p.getId_Malla()) > 0;
                } else if (field.equalsIgnoreCase("id")) {
                    return id.compareTo(p.getId()) > 0;
                }
            default:
                throw new AssertionError();

        }
    }

}
