/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelo;

import java.util.Date;

/**
 *
 * @author darwin
 */
public class PeriodoContrato {
    private Integer Id_periodo;
    private Date FechaInicio;
    private Date FechaFinal;

    public PeriodoContrato(Integer Id_periodo, Date FechaInicio, Date FechaFinal) {
        this.Id_periodo = Id_periodo;
        this.FechaInicio = FechaInicio;
        this.FechaFinal = FechaFinal;
    }
    public PeriodoContrato() {
        this.Id_periodo = null;
        this.FechaInicio = null;
        this.FechaFinal = null;
    }

    public Integer getId_periodo() {
        return Id_periodo;
    }

    public void setId_periodo(Integer Id_periodo) {
        this.Id_periodo = Id_periodo;
    }

    public Date getFechaInicio() {
        return FechaInicio;
    }

    public void setFechaInicio(Date FechaInicio) {
        this.FechaInicio = FechaInicio;
    }

    public Date getFechaFinal() {
        return FechaFinal;
    }

    public void setFechaFinal(Date FechaFinal) {
        this.FechaFinal = FechaFinal;
    }

    @Override
    public String toString() {
        return "FechaInicio=" + FechaInicio + ", FechaFinal=" + FechaFinal;
    }
    
    
}
