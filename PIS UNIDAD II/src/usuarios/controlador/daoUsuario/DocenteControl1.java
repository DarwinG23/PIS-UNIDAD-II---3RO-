/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.controlador.daoUsuario;

import dao.DaoImplement;
import lista.DynamicList;
import usuarios.modelo.Docente;

/**
 *
 * @author USUARIO
 */
public class DocenteControl1 extends DaoImplement<Docente> {
      private DynamicList<Docente> docente;
    private Docente docente1;
     public DocenteControl1() {
         super(Docente.class);
    }

    public DynamicList<Docente> getDocente() {
        docente=all();
        return docente;
    }

    public void setDocente(DynamicList<Docente> docente) {
        this.docente= docente;
    }

    public Docente getDocente1() {
        if (docente1 == null) {
            docente1 = new Docente();
        }
        return docente1;
    }

    public void setVendedor1(Docente docente1) {
        this.docente1 = docente1;
    }

    public Boolean persist(){
        docente1.setId(all().getLength()+ 1);
        return persist(docente1);
    }
}
