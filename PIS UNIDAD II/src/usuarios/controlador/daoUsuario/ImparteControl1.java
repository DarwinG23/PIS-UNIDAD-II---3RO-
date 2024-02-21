/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.controlador.daoUsuario;

import dao.DaoImplement;
import lista.DynamicList;
import usuarios.modelo.Imparte;

/**
 *
 * @author Alejandro
 */
public class ImparteControl1 extends DaoImplement<Imparte>{
    private DynamicList<Imparte> imparte;
    private Imparte imparte1;
    public  ImparteControl1() {
        super(Imparte.class);
    }

    public DynamicList<Imparte> getImparte() {
        imparte=all();
        return imparte;
    }

    public void setImparte(DynamicList<Imparte> contrato) {
        this.imparte = contrato;
    }

    public Imparte getImparte1() {
        if (imparte1 == null) {
            imparte1 = new Imparte();
        }
        return imparte1;
    }

    public void setImparte1(Imparte contrato1) {
        this.imparte1 = contrato1;
    }
    public Boolean persist(){
        imparte1.setId_Imparte(all().getLength()+ 1);
        return persist(imparte1);
        
    }
}
