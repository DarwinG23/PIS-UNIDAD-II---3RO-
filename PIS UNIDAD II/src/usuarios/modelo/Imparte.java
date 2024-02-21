/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelo;

import materias.modelo.Materia;

/**
 *
 * @author darwin
 */
public class Imparte {
  private Integer Id_Imparte;
    private Materia Id_Materia;
    private Docente Id_Docente;
    private Contrato Id_Contrato;

    public Imparte(Integer Id_Imparte, Materia Id_Materia, Docente Id_Docente, Contrato Id_Contrato) {
        this.Id_Imparte = Id_Imparte;
        this.Id_Materia = Id_Materia;
        this.Id_Docente = Id_Docente;
        this.Id_Contrato = Id_Contrato;
    }
    public Imparte() {
        this.Id_Imparte = null;
        this.Id_Materia = null;
        this.Id_Docente = null;
    }
    public Integer getId_Imparte() {
        return Id_Imparte;
    }

    public void setId_Imparte(Integer Id_Imparte) {
        this.Id_Imparte = Id_Imparte;
    }

    public Materia getId_Materia() {
        return Id_Materia;
    }

    public void setId_Materia(Materia Id_Materia) {
        this.Id_Materia = Id_Materia;
    }

    public Docente getId_Docente() {
        return Id_Docente;
    }

    public void setId_Docente(Docente Id_Docente) {
        this.Id_Docente = Id_Docente;
    }

    public Contrato getId_Contrato() {
        return Id_Contrato;
    }

    public void setId_Contrato(Contrato Id_Contrato) {
        this.Id_Contrato = Id_Contrato;
    }

    @Override
    public String toString() {
        return Id_Docente.getNombre()+Id_Contrato.getSalario();
    
}
