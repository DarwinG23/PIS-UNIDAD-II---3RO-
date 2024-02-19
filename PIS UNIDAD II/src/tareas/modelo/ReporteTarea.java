/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tareas.modelo;

/**
 *
 * @author Alejandro
 */
public class ReporteTarea{
    private Integer id;
    private Float Nota;
    private String Retroalimentacion;
    private tarea id_tarea;


    public ReporteTarea(Integer id, Float Nota, String Retroalimentacion,tarea id_tarea) {
        this.id = id;
        this.Nota = Nota;
        this.id_tarea=id_tarea;
        this.Retroalimentacion = Retroalimentacion;
    }
    public ReporteTarea() {
        this.id = null;
        this.Nota = null;
        this.Retroalimentacion = null;
   
    }

    public tarea getId_tarea() {
        return id_tarea;
    }

    public void setId_tarea(tarea id_tarea) {
        this.id_tarea = id_tarea;
    }
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getNota() {
        return Nota;
    }

    public void setNota(Float Nota) {
        this.Nota = Nota;
    }

    public String getRetroalimentacion() {
        return Retroalimentacion;
    }

    public void setRetroalimentacion(String Retroalimentacion) {
        this.Retroalimentacion = Retroalimentacion;
    }


    

    @Override
    public String toString() {
        return Nota + Retroalimentacion;
    }
    
    
    
}
