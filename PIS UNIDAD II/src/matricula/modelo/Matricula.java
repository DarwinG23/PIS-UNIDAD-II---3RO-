/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matricula.modelo;

import java.util.Date;
import lista.DynamicList;

/**
 *
 * @author darwi
 */
public class Matricula { 
    private Date fechaEmision;
    private Estado estado;
    private Integer id;
    private Integer id_Carrera;
    private Modalidad modalidad;
    private DynamicList<Cursa> cursas;

    public Matricula(Date fechaEmision, Estado estado, Integer id, Integer id_Carrera, Modalidad modalidad, DynamicList<Cursa> cursas) {
        this.fechaEmision = fechaEmision;
        this.estado = estado;
        this.id = id;
        this.id_Carrera = id_Carrera;
        this.modalidad = modalidad;
        this.cursas = cursas;
    }

   

    

    
    public Matricula() {
        this.fechaEmision = null;
        this.estado = null;
        this.id = null;
        this.id_Carrera = null;
        this.cursas = null;
        this.modalidad = null;
        
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


    public Integer getId_Carrera() {
        return id_Carrera;
    }

    public void setId_Carrera(Integer id_Carrera) {
        this.id_Carrera = id_Carrera;
    }

    public DynamicList<Cursa> getCursas() {
        if(cursas == null){
            cursas = new DynamicList<>();
        }
        return cursas;
    }

    public void setCursas(DynamicList<Cursa> cursas) {
        this.cursas = cursas;
    }

    public Modalidad getModalidad() {
        return modalidad;
    }

    public void setModalidad(Modalidad modalidad) {
        this.modalidad = modalidad;
    }
    
    
    
    


    @Override
    public String toString() {
        return  id + "";
    }
    
    
    
    
    
    
    
}
