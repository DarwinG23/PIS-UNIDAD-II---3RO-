/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tareas.modelo;

/**
 *
 * @author ALEJANDRO
 */
public class tarea {
    private tipoTarea id_tarea;
    private String tituloTarea;
    private Integer Id;
    private String fechaInicio;
    private String fechaFinal;
    private String Descripcion;
    private Float nota;
    private estadoTarea id_estado;

    public tarea(tipoTarea id_tarea,Float nota, String Descripcion, String tipoTarea, Integer Id, String fechaInicio, String fechaFinal,estadoTarea id_estado) {
        this.id_tarea = id_tarea;
        this.tituloTarea = tipoTarea;
        this.Id = Id;
        this.Descripcion=Descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.nota=nota;
        this.id_estado=id_estado;
    }

   
    public tarea() {
        this.id_tarea =null;
        this.fechaFinal=null;
        this.fechaInicio=null;
        this.tituloTarea = null;
        this.Id=null;
        this.Descripcion=null;
        this.nota=null;
        this.id_estado=null;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    
    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public Float getNota() {
        return nota;
    }

    public void setNota(Float nota) {
        this.nota = nota;
    }
    
    
    
    public tipoTarea getId_tarea() {
        return id_tarea;
    }

    public void setId_tarea(tipoTarea id_tarea) {
        this.id_tarea = id_tarea;
    }

    public String getTituloTarea() {
        return tituloTarea;
    }

    public void setTituloTarea(String tituloTarea) {
        this.tituloTarea = tituloTarea;
    }

    public estadoTarea getId_estado() {
        return id_estado;
    }

    public void setId_estado(estadoTarea id_estado) {
        this.id_estado = id_estado;
    }
    

    @Override
    public String toString() {
        return "Control{" + "id_tarea="+ id_tarea+"id_estado"+id_estado+"nota"+nota+ "descripcion=" +Descripcion+ ", tipoTarea=" + tituloTarea + ", fechaInicio=" + fechaInicio + ", fechaFinal=" + fechaFinal + '}';
    }
}
