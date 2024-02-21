/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelo;

/**
 *
 * @author darwin
 */
public class Contrato {
    private Integer Id_Contrato;
    private Double Salario;
    private Imparte Id_Imparte;
    private PeriodoContrato Id_periodo;

    public Contrato(Integer Id_Contrato,PeriodoContrato Id_periodo ,Double Salario, Imparte Id_Imparte) {
        this.Id_Contrato = Id_Contrato;
        this.Id_periodo=Id_periodo;
        this.Salario = Salario;
        this.Id_Imparte = Id_Imparte;
    }
    public Contrato() {
        this.Id_Contrato = null;
        this.Salario = null;
        this.Id_Imparte = null;
        this.Id_periodo=null;
    }
    public Integer getId_Contrato() {
        return Id_Contrato;
    }

    public void setId_Contrato(Integer Id_Contrato) {
        this.Id_Contrato = Id_Contrato;
    }


    public Double getSalario() {
        return Salario;
    }

    public void setSalario(Double Salario) {
        this.Salario = Salario;
    }

    public Imparte getId_Imparte() {
        return Id_Imparte;
    }

    public void setId_Imparte(Imparte Id_Imparte) {
        this.Id_Imparte = Id_Imparte;
    }

    public PeriodoContrato getId_periodo() {
        return Id_periodo;
    }

    public void setId_periodo(PeriodoContrato Id_periodo) {
        this.Id_periodo = Id_periodo;
    }

    @Override
    public String toString() {
        return  Salario.toString();
    }
    
    
    
}
