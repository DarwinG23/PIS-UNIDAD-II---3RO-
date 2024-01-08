/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matricula.controlador;

import dao.DaoImplement;
import lista.DynamicList;
import java.util.Date;
import matricula.modelo.PeriodoAcademico;

/**
 *
 * @author darwi
 */
public class PeriodoAcademicoControl extends DaoImplement<PeriodoAcademico>{
    private DynamicList<PeriodoAcademico> listPeriodoAcademico;
    private PeriodoAcademico periodoAcademico;

    public PeriodoAcademicoControl() {
        super(PeriodoAcademico.class);
    }
    

    public DynamicList<PeriodoAcademico> getListPeriodoAcademico() {
        listPeriodoAcademico= all();
        return listPeriodoAcademico;
    }

    public void setListPeridoAcademico(DynamicList<PeriodoAcademico> ListPeriodoAcademico) {
        this.listPeriodoAcademico = ListPeriodoAcademico;
    }

    public PeriodoAcademico getPeriodoAcademico() {
        if(periodoAcademico ==null){
            periodoAcademico = new PeriodoAcademico();
        }
        return periodoAcademico;
    }

    public void setPeriodoAcademico(PeriodoAcademico periodoAcademico) {
        this.periodoAcademico = periodoAcademico;
    }
    
    public Boolean persist(){
        periodoAcademico.setId(all().getLength()+1);
        return persist(periodoAcademico);
    }
    
//    public static void main(String[] args) {
//        PeriodoAcademicoControl pa = new PeriodoAcademicoControl();
//        
//        System.out.println(pa.all().toString());
//       
//    }
   
    
}
