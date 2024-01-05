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
    private Date fechaInicio;
    private Date fechaFin;
    private Integer id;
    private Integer id_Malla;
    private DynamicList<Materia> materias;

    public Ciclo(Integer numCiclo, Date fechaInicio, Date fechaFin, Integer id, Integer id_Malla, DynamicList<Materia> materias) {
        this.numCiclo = numCiclo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.id = id;
        this.id_Malla = id_Malla;
        this.materias = materias;
    }

    

    public Ciclo() {
        this.fechaFin = null;
        this.fechaInicio = null;
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

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
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
        return materias;
    }

    public void setMaterias(DynamicList<Materia> materias) {
        this.materias = materias;
    }
    

    @Override
    public String toString() {
        return numCiclo.toString();
    } 
    
}
