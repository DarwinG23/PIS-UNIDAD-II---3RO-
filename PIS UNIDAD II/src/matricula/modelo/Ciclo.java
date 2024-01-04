/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matricula.modelo;

import java.util.Date;

/**
 *
 * @author darwi
 */
public class Ciclo {
    private Integer numCiclo;
    private Date fechaInicio;
    private Date fechaFin;
    private Integer id;

    public Ciclo(Integer numCiclo, Date fechaInicio, Date fechaFin, Integer id) {
        this.numCiclo = numCiclo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.id = id;
    }

    public Ciclo() {
        this.fechaFin = null;
        this.fechaInicio = null;
        this.numCiclo = null;
        this.id = null;
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

    @Override
    public String toString() {
        return numCiclo.toString();
    } 
    
}
