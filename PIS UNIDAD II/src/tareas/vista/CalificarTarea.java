/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tareas.vista;

import java.awt.Desktop;
import java.awt.HeadlessException;
import java.net.URI;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import tareas.controlador.controladorTarea.administrarTarea1;
import tareas.controlador.controladorTarea.detalleTarea;
import tareas.controlador.controladorTarea.reporteTarea1;
import tareas.vista.modeloTabla.modeloTablaCalificar;
import usuarios.modelo.Docente;
import usuarios.vista.Menu;

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
    }

    public CalificarTarea(Docente docente) throws HeadlessException {
        this.docente = docente;
        initComponents();
        this.setLocationRelativeTo(null);
        Limpiar();
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

        panel1 = new org.edisoncor.gui.panel.Panel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMostrar = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtComentario = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtNota = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtEstudiante = new javax.swing.JTextField();
        txtLink = new javax.swing.JTextField();
        btnSeleccionar = new javax.swing.JButton();
        btnSeleccionar1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("CALIFICACIÓN DE TAREAS");
        panel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

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

        panel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, 130));

        jLabel10.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Link de la tarea:");
        panel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));

        jLabel11.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Comentario:");
        panel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, -1, -1));

        jLabel12.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Nota:");
        panel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, -1, -1));
        panel1.add(txtComentario, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 390, 280, 80));

        txtNombre.setEnabled(false);
        panel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, 280, -1));
        panel1.add(txtNota, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 350, 280, -1));

        jLabel13.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Estudiante:");
        panel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, -1));

        jLabel14.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Nombre de la tarea:");
        panel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));
        panel1.add(txtEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 300, 280, -1));

        txtLink.setEnabled(false);
        txtLink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtLinkMouseClicked(evt);
            }
        });
        panel1.add(txtLink, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, 280, -1));

        btnSeleccionar.setText("GUARDAR");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });
        panel1.add(btnSeleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 200, 240, -1));

        btnSeleccionar1.setText("SELECCIONAR");
        btnSeleccionar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionar1ActionPerformed(evt);
            }
        });
        panel1.add(btnSeleccionar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 130, 240, -1));

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSeleccionar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionar1ActionPerformed
        cargarVista();  
    }//GEN-LAST:event_btnSeleccionar1ActionPerformed

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
            new Menu(this.docente).setVisible(true);
            this.dispose();
        } catch (Exception e) {
            new Menu().setVisible(true);
            this.dispose();
        }
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
    private javax.swing.JButton btnSeleccionar1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private org.edisoncor.gui.panel.Panel panel1;
    private javax.swing.JTable tblMostrar;
    private javax.swing.JTextField txtComentario;
    private javax.swing.JTextField txtEstudiante;
    private javax.swing.JTextField txtLink;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNota;
    // End of variables declaration//GEN-END:variables
}
