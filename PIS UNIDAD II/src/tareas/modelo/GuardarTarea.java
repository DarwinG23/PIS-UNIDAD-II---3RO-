/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tareas.modelo;

/**
 *
 * @author Alejandro
 */
public class GuardarTarea {
    private Integer Id;
    private String link;
    private String NombreArchivo;

    public GuardarTarea(String link, String NombreArchivo,Integer id) {
        this.Id=id;
        this.link = link;
        this.NombreArchivo = NombreArchivo;
    }
    public GuardarTarea() {
        this.link = null;
        this.Id=null;
        this.NombreArchivo = null;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }
    
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getNombreArchivo() {
        return NombreArchivo;
    }

    public void setNombreArchivo(String NombreArchivo) {
        this.NombreArchivo = NombreArchivo;
    }

    @Override
    public String toString() {
        return link  + NombreArchivo ;
    }
    
}
