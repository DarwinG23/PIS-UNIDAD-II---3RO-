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
public class PeriodoAcademico {
    private Integer id;
    private String nombre;
    private Date fecha_Inicio;
    private Date fecha_Fin;

    public PeriodoAcademico(Integer id, String nombre, Date fecha_Inicio, Date fecha_Fin) {
        this.id = id;
        this.nombre = nombre;
        this.fecha_Inicio = fecha_Inicio;
        this.fecha_Fin = fecha_Fin;
    }

    public PeriodoAcademico() {
        this.id = null;
        this.nombre = null;
        this.fecha_Fin = null;
        this.fecha_Inicio = null;
    }
    
    
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha_Inicio() {
        return fecha_Inicio;
    }

    public void setFecha_Inicio(Date fecha_Inicio) {
        this.fecha_Inicio = fecha_Inicio;
    }

    public Date getFecha_Fin() {
        return fecha_Fin;
    }

    public void setFecha_Fin(Date fecha_Fin) {
        this.fecha_Fin = fecha_Fin;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    
    
    
    
    
}
