/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelo;

/**
 *
 * @author USUARIO
 */
public class Periodo {
    private Integer id;
    private Integer id_materia;
    private Integer id_docente;

    public Periodo(Integer id, Integer id_materia, Integer id_docente) {
        this.id = id;
        this.id_materia = id_materia;
        this.id_docente = id_docente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_materia() {
        return id_materia;
    }

    public void setId_materia(Integer id_materia) {
        this.id_materia = id_materia;
    }

    public Integer getId_docente() {
        return id_docente;
    }

    public void setId_docente(Integer id_docente) {
        this.id_docente = id_docente;
    }

    @Override
    public String toString() {
        return "Periodo{" + "id=" + id + ", id_materia=" + id_materia + ", id_docente=" + id_docente + '}';
    }
    
    
    
    
}
