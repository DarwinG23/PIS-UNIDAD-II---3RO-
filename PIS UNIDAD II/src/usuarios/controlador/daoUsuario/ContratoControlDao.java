/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.controlador.daoUsuario;

import dao.DaoImplement;
import lista.DynamicList;
import usuarios.modelo.Contrato;

/**
 *
 * @author Alejandro
 */
public class ContratoControlDao extends DaoImplement<Contrato> {
     private DynamicList<Contrato> contrato;
    private Contrato contrato1;
    public ContratoControlDao() {
        super(Contrato.class);
    }

    public DynamicList<Contrato> getContrato() {
        contrato=all();
        return contrato;
    }

    public void setContrato(DynamicList<Contrato> contrato) {
        this.contrato = contrato;
    }

    public Contrato getContrato1() {
        if (contrato1 == null) {
            contrato1 = new Contrato();
        }
        return contrato1;
    }

    public void setContrato1(Contrato contrato1) {
        this.contrato1 = contrato1;
    }
    public Boolean persist(){
        contrato1.setId_Contrato(all().getLength()+ 1);
        return persist(contrato1);
        
    }
    
    
    
}
