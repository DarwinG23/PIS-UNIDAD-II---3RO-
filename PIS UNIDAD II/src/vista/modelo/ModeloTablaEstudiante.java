/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.modelo;

import exeption.EmptyException;
import exeption.EmptyList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import lista.DynamicList;
import usuarios.modelo.Estudiante;

/**
 *
 * @author Alexander
 */
    public class ModeloTablaEstudiante extends AbstractTableModel {

    private DynamicList<Estudiante> estudiantesTabla;

    public DynamicList<Estudiante> getEstudianteTabla() {
        return estudiantesTabla;
    }

    public void setEstudianteTabla(DynamicList<Estudiante> estudiantesTabla) {
        this.estudiantesTabla = estudiantesTabla;
    }

    @Override
    public int getRowCount() {
        return estudiantesTabla.getLength();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int Fila, int Columna) {

        try {
            Estudiante p = estudiantesTabla.getInfo(Fila);

            switch (Columna) {
                case 0:
                    return (p != null) ? p.getDatosUsuario().getNombre(): "";
                case 1:
                    return (p != null) ? p.getDatosUsuario().getApellido(): "";
                case 2:
                    return (p != null) ? p.getDatosUsuario().getEdad(): "";
                case 3:
                    return (p != null) ? p.getDatosUsuario().getCedula(): "";
                case 4:
                    return (p != null) ? p.getDatosUsuario().getCorreo(): "";
                case 5:
                    return (p != null) ? p.getCorreoUsuario(): "";
                default:
                    return null;
            }
//        } catch (EmptyList ex) {
        } catch (IndexOutOfBoundsException ex) {
        } catch (EmptyException ex) {
            Logger.getLogger(ModeloTablaEstudiante.class.getName()).log(Level.SEVERE, null, ex);
        }
        return estudiantesTabla;
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
                return "Correo personal";
            case 5:
                return "Correo usuario";

            default:
                return null;
        }
    }
    
    
}
