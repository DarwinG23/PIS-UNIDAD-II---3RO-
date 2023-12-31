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
    private String nombreEstudiante; 
    private Carrera carrera;
    private Date fechaEmision;
    private Date fechaVencimiento;
    private Integer id;

    public Matricula(String nombreEstudiante, Carrera carrera, Date fechaEmision, Date fechaVencimiento, Integer id) {
        this.nombreEstudiante = nombreEstudiante;
        this.carrera = carrera;
        this.fechaEmision = fechaEmision;
        this.fechaVencimiento = fechaVencimiento;
        this.id = id;
    }

    public Matricula() {
        this.nombreEstudiante = null;
        this.carrera = null;
        this.fechaEmision = null;
        this.fechaVencimiento = null;
        this.id = null;
    }
    
    
    
    

    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Matricula" + id + "Estudiante" + nombreEstudiante;
    }
    
    
    
    
    
    
    
}
