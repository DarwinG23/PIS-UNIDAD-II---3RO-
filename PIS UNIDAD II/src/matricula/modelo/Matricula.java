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
public class Matricula { 
    private Date fechaEmision;
    private Estado estado;
    private Integer id;
    private Integer numCursas;

    public Matricula(Date fechaEmision, Estado estado, Integer id, Integer numCursas) {
        this.fechaEmision = fechaEmision;
        this.estado = estado;
        this.id = id;
        this.numCursas = numCursas;
    }
    
    

    

    public Matricula() {
        this.fechaEmision = null;
        this.estado = null;
        this.id = null;
        this.numCursas =  null;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumCursas() {
        return numCursas;
    }

    public void setNumCursas(Integer numCursas) {
        this.numCursas = numCursas;
    }
    
    
    
    


    @Override
    public String toString() {
        return  id + "";
    }
    
    
    
    
    
    
    
}
