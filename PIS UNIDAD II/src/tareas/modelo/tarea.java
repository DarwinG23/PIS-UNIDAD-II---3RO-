/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tareas.modelo;

import java.util.Date;
import materias.modelo.Materia;
import usuarios.modelo.Estudiante;

/**
 *
 * @author ALEJANDRO
 */
public class tarea {
    private tipoTarea Id_TipoTarea;
    private String Titulo_Tarea;
    private Integer Id;
    private Date Fecha_Inicio;
    private Date Fecha_Final;
    private String Descripcion;
    private estadoTarea Id_EstadoTarea;
    private Estudiante estudiante;
    private Materia materia;
   

    public tarea(tipoTarea id_tarea,Materia materia,Estudiante estudiante ,String Descripcion, String tipoTarea, Integer Id, Date Fecha_Inicio, Date Fecha_Final,estadoTarea id_estado) {
        this.Id_TipoTarea = id_tarea;
        this.Titulo_Tarea = tipoTarea;
        this.Id = Id;
        this.materia=materia;
        this.estudiante=estudiante;
        this.Descripcion=Descripcion;
        this.Fecha_Inicio = Fecha_Inicio;
        this.Fecha_Final = Fecha_Final;
        this.Id_EstadoTarea=id_estado;
    }

   
    public tarea() {
        this.Id_TipoTarea =null;
        this.Fecha_Final=null;
        this.Fecha_Inicio=null;
        this.Titulo_Tarea = null;
        this.Id=null;
        this.Descripcion=null;
        this.Id_EstadoTarea=null;
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

    public Date getFecha_Inicio() {
        return Fecha_Inicio;
    }

    public void setFecha_Inicio(Date Fecha_Inicio) {
        this.Fecha_Inicio = Fecha_Inicio;
    }

    public Date getFecha_Final() {
        return Fecha_Final;
    }

    public void setFecha_Final(Date Fecha_Final) {
        this.Fecha_Final = Fecha_Final;
    }

    public tipoTarea getId_tarea() {
        return Id_TipoTarea;
    }

    public void setId_tarea(tipoTarea id_tarea) {
        this.Id_TipoTarea = id_tarea;
    }

    public String getTituloTarea() {
        return Titulo_Tarea;
    }

    public void setTituloTarea(String tituloTarea) {
        this.Titulo_Tarea = tituloTarea;
    }

    public estadoTarea getId_estado() {
        return Id_EstadoTarea;
    }

    public void setId_estado(estadoTarea id_estado) {
        this.Id_EstadoTarea = id_estado;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }
    
    
    public Integer compare(tarea p, String field, Integer type) {
        // 0 menor, 1 mayor
        switch (type) {
            case 0:
                if (field.equalsIgnoreCase("Titulo_Tarea")) {
                    return Titulo_Tarea.compareTo(p.getTituloTarea());
                } else if (field.equalsIgnoreCase("Fecha_Inicio")) {
                    return Fecha_Inicio.compareTo(p.getFecha_Inicio());
                } else if (field.equalsIgnoreCase("Fecha_Final")) {
                    return Fecha_Final.compareTo(p.getFecha_Final());
                } else if (field.equalsIgnoreCase("Descripcion")) {
                    return Descripcion.compareTo(p.getDescripcion());
                } else if (field.equalsIgnoreCase("Id_TipoTarea")) {
                    return this.Id_TipoTarea.compareTo(p.getId_tarea(),"nombre");
                 } else if (field.equalsIgnoreCase("Id_EstadoTarea")) {
                    return this.Id_EstadoTarea.compareTo(p.getId_estado(),"estado");
                } else if (field.equalsIgnoreCase("Id")) {
                    return Id.compareTo(p.getId());
                }
            case 1:
                if (field.equalsIgnoreCase("Titulo_Tarea")) {
                    return p.getTituloTarea().compareTo(Titulo_Tarea);
                } else if (field.equalsIgnoreCase("Fecha_Inicio")) {
                    return p.getFecha_Inicio().compareTo(Fecha_Inicio);
                } else if (field.equalsIgnoreCase("Fecha_Final")) {
                    return p.getFecha_Final().compareTo(Fecha_Final);
                } else if (field.equalsIgnoreCase("Descripcion")) {
                    return p.getDescripcion().compareTo(Descripcion);
                } else if (field.equalsIgnoreCase("Id_TipoTarea")) {
                    return p.getId_tarea().compareTo(Id_TipoTarea,"nombre");
                } else if (field.equalsIgnoreCase("Id_EstadoTarea")) {
                    return p.getId_estado().compareTo(Id_EstadoTarea,"estado");   
                } else if (field.equalsIgnoreCase("Id")) {
                    return p.getId().compareTo(Id);
                }
            default:
                throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return "Estado=" + Id_EstadoTarea ;
    }

    
    

    
}
