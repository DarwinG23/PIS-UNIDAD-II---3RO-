/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tareas.ConexionesDB.Tabla;

import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import lista.DynamicList;
import tareas.ConexionesDB.Dao.PdfDao;
import tareas.ConexionesDB.Vo.PdfVo;

/**
 *
 * @author ALEJANDRO
 */
public class TablaPdf_Vo {
     PdfDao dao = null;

    public void visualizar_PdfVO(JTable tabla) {
        tabla.setDefaultRenderer(Object.class, new imgTabla());
        DefaultTableModel dt = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dt.addColumn("codigopdf");
        dt.addColumn("nombrepdf");
        dt.addColumn("archivopdf");

        ImageIcon icono = null;
        if (get_Image("/Imagen/32pdf.png") != null) {
            icono = new ImageIcon(get_Image("/Imagen/32pdf.png"));
        }

        dao = new PdfDao();
        PdfVo vo = new PdfVo();
        DynamicList<PdfVo> list = dao.Listar_Pdfvo();

        if (list.getLength()> 0) {
            for (int i = 0; i < list.getLength(); i++) {
                Object fila[] = new Object[3];
                try {
                    vo = list.getInfo(i);
                } catch (Exception ex) {
                    Logger.getLogger(TablaPdf_Vo.class.getName()).log(Level.SEVERE, null, ex);
                }
                fila[0] = vo.getCodigopdf();
                fila[1] = vo.getNombrepdf();
                if (vo.getArchivopdf() != null) {
                    fila[2] = new JButton(icono);
                } else {
                    fila[2] = new JButton("Vacio");
                }

                dt.addRow(fila);
            }
            tabla.setModel(dt);
            tabla.setRowHeight(32);
        }
    }

    public Image get_Image(String ruta) {
        try {
            ImageIcon imageIcon = new ImageIcon(getClass().getResource(ruta));
            Image mainIcon = imageIcon.getImage();
            return mainIcon;
        } catch (Exception e) {
        }
        return null;
    }
}
