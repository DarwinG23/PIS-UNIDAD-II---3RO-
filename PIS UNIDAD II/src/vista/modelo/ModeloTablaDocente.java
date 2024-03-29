/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.modelo;

import javax.swing.table.AbstractTableModel;
import lista.DynamicList;
import usuarios.modelo.Docente;

/**
 *
 * @author Alexander
 */
public class ModeloTablaDocente extends AbstractTableModel  {


    private DynamicList<Docente> docente;

    public DynamicList<Docente> getDocente() {
        return docente;
    }

    public void setDocente(DynamicList<Docente> docente) {
        this.docente = docente;
    }
   
    @Override
    public int getRowCount() {
        return docente.getLength();
    }

    @Override
    public int getColumnCount() {
        return 9;
    }

    @Override
    public Object getValueAt(int Fila, int Columna) {

        try {
            Docente p = docente.getInfo(Fila);

            switch (Columna) {
                case 0:
                    return (p != null) ? p.getNombre(): "";
                case 1:
                    return (p != null) ? p.getApellido(): "";
                case 2:
                    return (p != null) ? p.getEdad(): "";
                case 3:
                    return (p != null) ? p.getCedula(): "";
                case 4:
                    return (p != null) ? p.getCorreo(): "";
                case 5:
                    return (p != null) ? p.getAniosExperiencia(): "";
                case 6:
                    return (p != null) ? p.getTituloProfesional(): "";
                case 7:
                    return (p != null) ? p.getCorreoUsuario(): "";
                case 8:
                    return (p != null) ? p.getRolDocente(): "";
                default:
                    return null;
            }
     } catch (Exception e) {
             System.out.println("ERROR");
        }
        return docente;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Nombre";
            case 1:
                return "Apellido";
            case 2:
                return "Edad";
            case 3:
                return "Cedula";
            case 4:
                return "Correo";
            case 5:
                return "Años Experiencia";  
            case 6:
                return "Titulo";
            case 7:
                return "Usuario"; 
            case 8:
                return "Rol"; 
            default:
                return null;
        }
    }

   

   
}
