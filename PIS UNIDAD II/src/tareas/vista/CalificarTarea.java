/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tareas.vista;

import java.awt.Desktop;
import java.awt.HeadlessException;
import java.net.URI;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import tareas.controlador.controladorTarea.administrarTarea1;
import tareas.controlador.controladorTarea.detalleTarea;
import tareas.controlador.controladorTarea.reporteTarea1;
import tareas.vista.modeloTabla.modeloTablaCalificar;
import usuarios.modelo.Docente;
import usuarios.vista.MenuDocente;

/**
 *
 * @author Alejandro
 */
public class CalificarTarea extends javax.swing.JFrame {
    private detalleTarea detalleTarea=new detalleTarea();
    modeloTablaCalificar mtc=new modeloTablaCalificar();
    private administrarTarea1 tareaControl = new administrarTarea1();
    private reporteTarea1 reporteControl=new reporteTarea1();
    private Docente docente;
    /**
     * Creates new form CalificarTarea
     */
    public CalificarTarea() {
        initComponents();
        this.setLocationRelativeTo(null);
        Limpiar();
        pnlAzul.setIcon(new ImageIcon("fotos/Azul.png"));
        pnlGris.setIcon(new ImageIcon("fotos/Celeste.jpg"));
    }

    public CalificarTarea(Docente docente) throws HeadlessException {
        this.docente = docente;
        initComponents();
        this.setLocationRelativeTo(null);
        Limpiar();
        pnlAzul.setIcon(new ImageIcon("fotos/Azul.png"));
        pnlGris.setIcon(new ImageIcon("fotos/Celeste.jpg"));
    }
    
    
    public void AbrirNavegador(String enlace){ 
        try {
            URI uri = new URI(enlace);
            
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(uri);
            } else {
                System.out.println("No se puede abrir el enlace. El escritorio no es compatible o no es compatible con la acción de navegación.");
            }
        } catch (Exception e) {
            System.out.println("Error al intentar abrir el enlace: " + e.getMessage());
        }
    }
    public void receptarDatosTarea(String tituloTarea, String link){
        detalleTarea.getTareaEstudiante1().setNombreArchivo(tituloTarea);
        txtNombre.setText(detalleTarea.getTareaEstudiante1().getNombreArchivo());
        detalleTarea.getTareaEstudiante1().setLink(link);
        txtLink.setText(detalleTarea.getTareaEstudiante1().getLink());
         
        
    }
     private void CargarTabla() {
        mtc.setTarea(detalleTarea.getTareaEstudiante());
        tblMostrar.setModel((TableModel) mtc);
        tblMostrar.updateUI();
    }
     private void Limpiar() {
         txtNota.setText(" ");
         txtComentario.setText(" ");
        tblMostrar.clearSelection();
        CargarTabla();
        detalleTarea.setTareaEstudiante1(null);
    }
     private Boolean Validar() {
        return (!txtNota.getText().trim().isEmpty());
    }
    private void Guardar() {
        
        if (Validar()) {          
            receptarDatosTarea(txtNombre.getText(), txtLink.getText());
            if (detalleTarea.persist()) {
                JOptionPane.showMessageDialog(null, "Datos guardados con exito");
                detalleTarea.setTareaEstudiante1(null);
                CargarTabla();
                Limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo guardar");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Falta llenar campos  ");

        }
    }
    private void cargarVista() {
        int fila = tblMostrar.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(null, "Escoja un registtro de la tabla");
        } else {
            try {
               detalleTarea.setTareaEstudiante1(mtc.getTarea().getInfo(fila));
                txtNombre.setText(detalleTarea.getTareaEstudiante1().getNombreArchivo());
                txtLink.setText(detalleTarea.getTareaEstudiante1().getLink());
                
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }
    private void GuardarNota(){
        reporteControl.getTareaEstudiante1().setNota(Float.parseFloat(txtNota.getText()));
        reporteControl.getTareaEstudiante1().setRetroalimentacion(txtComentario.getText());
        if (reporteControl.persist()) {
                JOptionPane.showMessageDialog(null, "Datos guardados con exito");
                reporteControl.setTareaEstudiante1(null);
                Limpiar();
                publicar();
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo guardar");
            }
    }
     private void publicar() {
        ReporteNotas ea=new ReporteNotas();
        ea.recibirDatos1(txtNota.getText(),txtComentario.getText());
        
    }
  

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlGris = new org.edisoncor.gui.panel.PanelImage();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMostrar = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnSeleccionar4 = new javax.swing.JButton();
        btnSeleccionar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        pnlAzul = new org.edisoncor.gui.panel.PanelImage();
        jLabel4 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtLink = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtEstudiante = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtNota = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtComentario = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlGris.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblMostrar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblMostrar);

        pnlGris.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 460, 170));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable1);

        pnlGris.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 450, 170));

        btnSeleccionar4.setText("MODIFICAR");
        btnSeleccionar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionar4ActionPerformed(evt);
            }
        });
        pnlGris.add(btnSeleccionar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 240, -1));

        btnSeleccionar.setText("GUARDAR");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });
        pnlGris.add(btnSeleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 240, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("NOTAS TAREAS");
        pnlGris.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("TAREAS ENVIADAS");
        pnlGris.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, -1, -1));

        getContentPane().add(pnlGris, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 480, 533));

        pnlAzul.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("CALIFICACIÓN DE TAREAS");
        pnlAzul.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        jLabel14.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Nombre de la tarea:");
        pnlAzul.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        txtNombre.setEnabled(false);
        pnlAzul.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 300, -1));

        jLabel10.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Link de la tarea:");
        pnlAzul.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        txtLink.setEnabled(false);
        txtLink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtLinkMouseClicked(evt);
            }
        });
        pnlAzul.add(txtLink, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 290, -1));

        jLabel13.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Estudiante:");
        pnlAzul.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));
        pnlAzul.add(txtEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 230, 290, -1));

        jLabel12.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Nota:");
        pnlAzul.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, -1, -1));
        pnlAzul.add(txtNota, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 320, 280, -1));

        jLabel11.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Comentario:");
        pnlAzul.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, -1, -1));
        pnlAzul.add(txtComentario, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 380, 280, 80));

        getContentPane().add(pnlAzul, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 533));

        jMenu1.setText("OPCIONES DOCENTE");
        jMenu1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jMenuItem1.setText("Inicio");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtLinkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtLinkMouseClicked
         if (evt.getClickCount() >= 2) {
             String enlaceDesdeCampo = txtLink.getText();
            AbrirNavegador(enlaceDesdeCampo);
    }   
    }//GEN-LAST:event_txtLinkMouseClicked

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        GuardarNota();
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        try {
            new MenuDocente(this.docente).setVisible(true);
            this.dispose();
        } catch (Exception e) {
            new MenuDocente().setVisible(true);
            this.dispose();
        }
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btnSeleccionar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionar4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSeleccionar4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CalificarTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CalificarTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CalificarTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CalificarTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CalificarTarea().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JButton btnSeleccionar4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private org.edisoncor.gui.panel.PanelImage pnlAzul;
    private org.edisoncor.gui.panel.PanelImage pnlGris;
    private javax.swing.JTable tblMostrar;
    private javax.swing.JTextField txtComentario;
    private javax.swing.JTextField txtEstudiante;
    private javax.swing.JTextField txtLink;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNota;
    // End of variables declaration//GEN-END:variables
}
