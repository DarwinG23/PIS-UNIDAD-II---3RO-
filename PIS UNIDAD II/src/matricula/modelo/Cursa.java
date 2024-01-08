/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matricula.modelo;

/**
 *
 * @author darwin
 */
public class Cursa {
    private Integer id;
    private Integer id_estudiante;
    private Integer id_matricula;
    private Integer id_materia;
    private String paralelo;
    private Integer id_docente;

    public Cursa(Integer id, Integer id_estudiante, Integer id_matricula, Integer id_materia, String paralelo, Integer id_docente) {
        this.id = id;
        this.id_estudiante = id_estudiante;
        this.id_matricula = id_matricula;
        this.id_materia = id_materia;
        this.paralelo = paralelo;
        this.id_docente = id_docente;
    }

    public Cursa() {
        this.id = null;
        this.id_docente = null;
        this.id_estudiante = null;
        this.id_materia = null;
        this.id_matricula = null;
        this.paralelo = null;
    }
    
    
    
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_matricula() {
        return id_matricula;
    }

    public void setId_matricula(Integer id_matricula) {
        this.id_matricula = id_matricula;
    }

    public Integer getId_materia() {
        return id_materia;
    }

    public void setId_materia(Integer id_materia) {
        this.id_materia = id_materia;
    }

    public String getParalelo() {
        return paralelo;
    }

    public void setParalelo(String paralelo) {
        this.paralelo = paralelo;
    }

    public Integer getId_docente() {
        return id_docente;
    }

    public void setId_docente(Integer id_docente) {
        this.id_docente = id_docente;
    }

    public Integer getId_estudiante() {
        return id_estudiante;
    }

    public void setId_estudiante(Integer id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    @Override
    public String toString() {
        return  id_estudiante +" "+ id_materia +" " +  paralelo;
    }
    public Boolean compare( Cursa p, String field, Integer type){
        switch (type) {
            case 0:
                if(field.equalsIgnoreCase("id_estudiante")){
                    return id_estudiante.compareTo(p.getId_estudiante()) < 0;
                } else if(field.equalsIgnoreCase("id_matricula")){
                    return id_matricula.compareTo(p.getId_matricula()) < 0;
                }else if(field.equalsIgnoreCase("id_materia")){
                    return id_materia.compareTo(p.getId_materia()) < 0;
                 }else if(field.equalsIgnoreCase("id_docente")){
                    return id_docente.compareTo(p.getId_docente()) < 0;
                 }else if(field.equalsIgnoreCase("paralelo")){
                    return paralelo.compareTo(p.getParalelo()) < 0;
                 }else if(field.equalsIgnoreCase("id")){
                    return id.compareTo(p.getId()) < 0;
                }
            case 1:
            if(field.equalsIgnoreCase("id_estudiante")){
                    return id_estudiante.compareTo(p.getId_estudiante()) > 0;
                } else if(field.equalsIgnoreCase("id_matricula")){
                    return id_matricula.compareTo(p.getId_matricula()) > 0;
                }else if(field.equalsIgnoreCase("id_materia")){
                    return id_materia.compareTo(p.getId_materia()) > 0;
                }else if(field.equalsIgnoreCase("id_docente")){
                    return id_docente.compareTo(p.getId_docente()) > 0;
                }else if(field.equalsIgnoreCase("paralelo")){
                    return paralelo.compareTo(p.getParalelo()) > 0;
                }else if(field.equalsIgnoreCase("id")){
                    return id.compareTo(p.getId()) > 0;
                }
            default:
                throw new AssertionError();
                
        }
     }
    

    
    
    
    
    
    
}
