/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tareas.vista;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import tareas.controlador.controladorTarea.administrarTarea1;
import tareas.controlador.controladorTarea.detalleTarea;
import tareas.controlador.controladorTarea.envioTarea;
import tareas.controlador.controladorTarea.reporteTarea1;
import tareas.vista.modeloTabla.modeloReporteCalificacion;
import tareas.vista.modeloTabla.modeloTareaEstudiante;
    
 /*
 * @author ALEJANDRO
 */
public class ReporteNotas extends javax.swing.JFrame {
    private detalleTarea detalleTarea=new detalleTarea();
    private envioTarea controlEnvio=new envioTarea();
    private modeloReporteCalificacion mpc=new modeloReporteCalificacion();
    private reporteTarea1 controlReporte=new reporteTarea1();
    modeloTareaEstudiante mte=new modeloTareaEstudiante();
    
    /**
     * Creates new form TareaEstudiante
     */
   public ReporteNotas() {
        initComponents();
        this.setLocationRelativeTo(null);
        Limpiar();
        Limpiar1();
    }
    public void recibirDatosReporte(String tituloTarea, String descripcion){
        controlEnvio.getTareaEstudiante1().setTituloTarea(tituloTarea);
        txtTitulo.setText(controlEnvio.getTareaEstudiante1().getTituloTarea());
        controlEnvio.getTareaEstudiante1().setDescripcion(descripcion);
        txtDescripcion.setText(controlEnvio.getTareaEstudiante1().getDescripcion());
 
    }
    public void recibirDatos1(String nota,String retroaliemtnacion){
        controlReporte.getTareaEstudiante1().setNota(Float.parseFloat(nota));
        String Nota=String.valueOf(controlReporte.getTareaEstudiante1().getNota());
        txtNota.setText(Nota);
        controlReporte.getTareaEstudiante1().setRetroalimentacion(retroaliemtnacion);
        txtRetroaliemntacion.setText(controlReporte.getTareaEstudiante1().getRetroalimentacion());
    }
    
    private void CargarTabla() {
        mpc.setReporte(controlReporte.getTareaEstudiante());
        tblMostrarDatos.setModel((TableModel) mpc);
        tblMostrarDatos.updateUI();
    }
    private void CargarTabla1() {
        mte.setTarea(controlEnvio.getTareaEstudiante());
        tblMostrarDatos1.setModel((TableModel) mte);
        tblMostrarDatos1.updateUI();
    }
     private void Limpiar() {
        tblMostrarDatos.clearSelection();
        CargarTabla();
        controlReporte.setTareaEstudiante1(null);
    }
      private void Limpiar1() {
        tblMostrarDatos1.clearSelection();
        CargarTabla1();
        controlEnvio.setTareaEstudiante1(null);
    }
     private Boolean Validar() {
        return (!txtTitulo.getText().trim().isEmpty()
                && !txtRetroaliemntacion.getText().trim().isEmpty());
    }
    private void Guardar() {
        
        if (Validar()) {          
            recibirDatosReporte(txtTitulo.getText(), txtDescripcion.getText());
            recibirDatos1(txtNota.getText(), txtRetroaliemntacion.getText());
            if (controlEnvio.persist()) {
                JOptionPane.showMessageDialog(null, "Datos guardados con exito");
                controlEnvio.setTareaEstudiante1(null);
                CargarTabla();
                Limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo guardar");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Falta llenar campos  ");

        }
    }
    

   
    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new org.edisoncor.gui.panel.Panel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        txtMateria = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtRetroaliemntacion = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMostrarDatos = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtNota = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblMostrarDatos1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("REPORTE DE NOTAS");
        panel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, -1, -1));

        jLabel1.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Materia:");
        panel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jLabel7.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Descripción:");
        panel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        txtTitulo.setBackground(new java.awt.Color(255, 255, 204));
        txtTitulo.setEnabled(false);
        panel1.add(txtTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 360, -1));

        txtMateria.setBackground(new java.awt.Color(255, 255, 204));
        txtMateria.setEnabled(false);
        txtMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMateriaActionPerformed(evt);
            }
        });
        panel1.add(txtMateria, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 360, -1));

        jLabel8.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Título  Tarea:");
        panel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        txtRetroaliemntacion.setBackground(new java.awt.Color(255, 255, 204));
        txtRetroaliemntacion.setEnabled(false);
        panel1.add(txtRetroaliemntacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, 370, -1));

        tblMostrarDatos.setBackground(new java.awt.Color(255, 255, 255));
        tblMostrarDatos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tblMostrarDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane1.setViewportView(tblMostrarDatos);

        panel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 330, 290, 110));

        jLabel5.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Retroalimentación:");
        panel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, -1));

        txtDescripcion.setBackground(new java.awt.Color(255, 255, 204));
        txtDescripcion.setEnabled(false);
        panel1.add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 174, 370, 40));

        jLabel10.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Nota:");
        panel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

        txtNota.setBackground(new java.awt.Color(255, 255, 204));
        txtNota.setEnabled(false);
        panel1.add(txtNota, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 240, 370, -1));

        btnGuardar.setText("REGRESAR AL MENÚ");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        panel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 470, 250, -1));

        tblMostrarDatos1.setBackground(new java.awt.Color(255, 255, 255));
        tblMostrarDatos1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tblMostrarDatos1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane2.setViewportView(tblMostrarDatos1);

        panel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 270, 110));

        getContentPane().add(panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMateriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMateriaActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        MenuGestion mg=new MenuGestion(this, rootPaneCheckingEnabled);
        mg.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnGuardarActionPerformed

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
            java.util.logging.Logger.getLogger(ReporteNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReporteNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReporteNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReporteNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReporteNotas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private org.edisoncor.gui.panel.Panel panel1;
    private javax.swing.JTable tblMostrarDatos;
    private javax.swing.JTable tblMostrarDatos1;
    public static javax.swing.JTextField txtDescripcion;
    public static javax.swing.JTextField txtMateria;
    public static javax.swing.JTextField txtNota;
    public static javax.swing.JTextField txtRetroaliemntacion;
    public static javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables

}
