/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package matricula.vista;

import exeption.EmptyException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import lista.DynamicList;
import matricula.controlador.PeriodoAcademicoControl;
import matricula.vista.tabla.ModeloTablaPeriodoAcademico;
import usuarios.vista.Menu;

/**
 *
 * @author darwi
 */
public class GuardarPeriodoAcademico extends javax.swing.JFrame {

    ModeloTablaPeriodoAcademico mtp = new ModeloTablaPeriodoAcademico();
    PeriodoAcademicoControl periodoAcademicoControl = new PeriodoAcademicoControl();

    public void cargarFacultades(DynamicList carreras) {
        mtp.setPeridosAcademicos(carreras);
        initComponents();
    }

    public Boolean verificar() {
        return (!txtNombre.getText().trim().isEmpty());
    }

    private void cargarTabla() {
        mtp.setPeridosAcademicos(periodoAcademicoControl.getListPeriodoAcademico());
        tbPeriodo.setModel(mtp);
        tbPeriodo.updateUI();
    }

    private void guardar() throws EmptyException {
        if (verificar()) {
            periodoAcademicoControl.getPeriodoAcademico().setFecha_Fin(cldFechaFin.getDate());
            periodoAcademicoControl.getPeriodoAcademico().setFecha_Inicio(cldFechaInicio.getDate());
            periodoAcademicoControl.getPeriodoAcademico().setNombre(txtNombre.getText());
            if (periodoAcademicoControl.persist()) {
                JOptionPane.showMessageDialog(null, "Datos guardados");
                cargarTabla();
                limpiar();
                periodoAcademicoControl.setPeriodoAcademico(null);
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo guardar, hubo un error");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Falta llenar campos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiar() {
        txtNombre.setText("");
        cldFechaInicio.setDate(null);
        cldFechaInicio.setDate(null);
    }

    public GuardarPeriodoAcademico() {
        initComponents();
        cargarTabla();
        this.setLocationRelativeTo(null);
        pnlAzul.setIcon(new ImageIcon("fotos/Azul.png"));
        pnlGris.setIcon(new ImageIcon("fotos/Celeste.jpg"));
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlAzul = new org.edisoncor.gui.panel.PanelImage();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        cldFechaInicio = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        cldFechaFin = new com.toedter.calendar.JDateChooser();
        btnGuardar = new javax.swing.JButton();
        pnlGris = new org.edisoncor.gui.panel.PanelImage();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPeriodo = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        btnAdmFacultad = new javax.swing.JMenuItem();
        btnAdmCarrera = new javax.swing.JMenuItem();
        btnAdmMalla = new javax.swing.JMenuItem();
        btnAdmCiclo = new javax.swing.JMenuItem();
        btnAdmCursa = new javax.swing.JMenuItem();
        btnAdmMatricula = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        btnIncio = new javax.swing.JMenuItem();
        btnMatricula = new javax.swing.JMenuItem();
        btnSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlAzul.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("PERIODO ACADÉMICO");
        pnlAzul.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre:");
        pnlAzul.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Inicia:");
        pnlAzul.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));
        pnlAzul.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 250, -1));
        pnlAzul.add(cldFechaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 250, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Termina:");
        pnlAzul.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, -1));
        pnlAzul.add(cldFechaFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 250, -1));

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        pnlAzul.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 560, -1, -1));

        getContentPane().add(pnlAzul, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 600));

        pnlGris.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbPeriodo.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbPeriodo);

        pnlGris.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 930, 130));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Tabla de periodos académicos");
        pnlGris.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Criterio:");
        pnlGris.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        pnlGris.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 190, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Texto:");
        pnlGris.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, -1, -1));
        pnlGris.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, 260, -1));

        getContentPane().add(pnlGris, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 0, 640, 600));

        jMenu1.setText("Administración");

        btnAdmFacultad.setText("Facultad");
        btnAdmFacultad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdmFacultadActionPerformed(evt);
            }
        });
        jMenu1.add(btnAdmFacultad);

        btnAdmCarrera.setText("Carrera");
        btnAdmCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdmCarreraActionPerformed(evt);
            }
        });
        jMenu1.add(btnAdmCarrera);

        btnAdmMalla.setText("Malla");
        btnAdmMalla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdmMallaActionPerformed(evt);
            }
        });
        jMenu1.add(btnAdmMalla);

        btnAdmCiclo.setText("Ciclo");
        btnAdmCiclo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdmCicloActionPerformed(evt);
            }
        });
        jMenu1.add(btnAdmCiclo);

        btnAdmCursa.setText("Cursa");
        btnAdmCursa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdmCursaActionPerformed(evt);
            }
        });
        jMenu1.add(btnAdmCursa);

        btnAdmMatricula.setText("Matricula");
        btnAdmMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdmMatriculaActionPerformed(evt);
            }
        });
        jMenu1.add(btnAdmMatricula);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Menu");

        btnIncio.setText("Inicio");
        btnIncio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncioActionPerformed(evt);
            }
        });
        jMenu3.add(btnIncio);

        btnMatricula.setText("Matriculas");
        btnMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMatriculaActionPerformed(evt);
            }
        });
        jMenu3.add(btnMatricula);

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jMenu3.add(btnSalir);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            guardar();
        } catch (EmptyException ex) {
            Logger.getLogger(GuardarPeriodoAcademico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnAdmFacultadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdmFacultadActionPerformed
        try {
            new GuardarFacultad().setVisible(true);
            this.dispose();
        } catch (EmptyException ex) {
            Logger.getLogger(GuardarPeriodoAcademico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAdmFacultadActionPerformed

    private void btnAdmCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdmCarreraActionPerformed
        try {
            new GuardarCarrera().setVisible(true);
            this.dispose();
        } catch (EmptyException ex) {
            Logger.getLogger(GuardarPeriodoAcademico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAdmCarreraActionPerformed

    private void btnAdmMallaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdmMallaActionPerformed
        try {
            new GuardarMalla().setVisible(true);
            this.dispose();
        } catch (EmptyException ex) {
            Logger.getLogger(GuardarPeriodoAcademico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAdmMallaActionPerformed

    private void btnAdmCicloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdmCicloActionPerformed
        try {
            new GuardarCiclo().setVisible(true);
            this.dispose();
        } catch (EmptyException ex) {
            Logger.getLogger(GuardarPeriodoAcademico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAdmCicloActionPerformed

    private void btnAdmCursaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdmCursaActionPerformed
        new GuardarCursa().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAdmCursaActionPerformed

    private void btnAdmMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdmMatriculaActionPerformed
        try {
            new GuardarMatricula().setVisible(true);
            this.dispose();
        } catch (Exception ex) {
            Logger.getLogger(GuardarPeriodoAcademico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAdmMatriculaActionPerformed

    private void btnIncioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncioActionPerformed
        new Menu().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnIncioActionPerformed

    private void btnMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMatriculaActionPerformed
        try {
            new EstudianteMatricula().setVisible(true);
            this.dispose();
        } catch (EmptyException ex) {
            java.util.logging.Logger.getLogger(GuardarCiclo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnMatriculaActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalirActionPerformed

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
            java.util.logging.Logger.getLogger(GuardarPeriodoAcademico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GuardarPeriodoAcademico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GuardarPeriodoAcademico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GuardarPeriodoAcademico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GuardarPeriodoAcademico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btnAdmCarrera;
    private javax.swing.JMenuItem btnAdmCiclo;
    private javax.swing.JMenuItem btnAdmCursa;
    private javax.swing.JMenuItem btnAdmFacultad;
    private javax.swing.JMenuItem btnAdmMalla;
    private javax.swing.JMenuItem btnAdmMatricula;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JMenuItem btnIncio;
    private javax.swing.JMenuItem btnMatricula;
    private javax.swing.JMenuItem btnSalir;
    private com.toedter.calendar.JDateChooser cldFechaFin;
    private com.toedter.calendar.JDateChooser cldFechaInicio;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private org.edisoncor.gui.panel.PanelImage pnlAzul;
    private org.edisoncor.gui.panel.PanelImage pnlGris;
    private javax.swing.JTable tbPeriodo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
