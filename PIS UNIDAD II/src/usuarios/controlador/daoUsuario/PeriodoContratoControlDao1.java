/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.controlador.daoUsuario;

import dao.DaoImplement;
import lista.DynamicList;
import usuarios.modelo.PeriodoContrato;

/**
 *
 * @author Alejandro
 */
public class PeriodoContratoControlDao1 extends DaoImplement<PeriodoContrato> {
    private DynamicList<PeriodoContrato> periodo;
    private PeriodoContrato periodo1;
    public  PeriodoContratoControlDao1() {
        super(PeriodoContrato.class);
    }

    public DynamicList<PeriodoContrato> getPerido() {
        periodo=all();
        return periodo;
    }

    public void setPeriodo(DynamicList<PeriodoContrato> contrato) {
        this.periodo = contrato;
    }

    public PeriodoContrato getPeriodo1() {
        if (periodo1 == null) {
            periodo1 = new PeriodoContrato();
        }
        return periodo1;
    }

    public void setPeriodo1(PeriodoContrato contrato1) {
        this.periodo1 = contrato1;
    }
    public Boolean persist(){
        periodo1.setId_periodo(all().getLength()+ 1);
        return persist(periodo1);
        
    }
}
