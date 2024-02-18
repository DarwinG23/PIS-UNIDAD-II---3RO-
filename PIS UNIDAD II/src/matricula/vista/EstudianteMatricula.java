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
import matricula.controlador.CursaControl;
import matricula.controlador.MatriculaControl;
import matricula.modelo.Cursa;
import matricula.modelo.Estado;
import matricula.modelo.Matricula;
import matricula.vista.tabla.ModeloTablaMatricula;


/**
 *
 * @author darwi
 */
public class EstudianteMatricula extends javax.swing.JFrame {

    ModeloTablaMatricula mtm = new ModeloTablaMatricula();
    MatriculaControl matriculaControl = new MatriculaControl();
    CursaControl cursaControl = new CursaControl();

    public void cargarFacultades(DynamicList carreras) {
        mtm.setMatriculas(carreras);
        initComponents();
    }

    public Boolean verificar() {
        return true;
    }

    private void cargarTabla() throws EmptyException {
        DynamicList<Matricula> matriculasFiltradas = new DynamicList<>();

        for (int i = 0; i < matriculaControl.getListMatricula().getLength(); i++) {
            Matricula matriculaActual = matriculaControl.getListMatricula().getInfo(i);

            if (matriculaActual.getEstado() == Estado.DISPONIBLE) {
                matriculasFiltradas.add(matriculaActual);
            }
        }
        mtm.setMatriculas(matriculasFiltradas);
        tbMatricula.setModel(mtm);
        tbMatricula.updateUI();
    }

    public void guardar(Integer filaSeleccionada, Cursa cursa) {
        if (verificar()) {
            if (cursaControl.marge(cursa, filaSeleccionada)) {
                JOptionPane.showMessageDialog(null, "Se ha matriculado con exito");
                cursaControl.setCursa(null);
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo guardar, hubo un error");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Falta llenar campos", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void modificarCursa(Integer filaSeleccionada) throws EmptyException {
        DynamicList<Matricula> matriculasFiltradas = new DynamicList<>();
        boolean asignado = false;
        for (int i = 0; i < matriculaControl.getListMatricula().getInfo(filaSeleccionada).getCursas().getLength(); i++) {
            Cursa cursaActual = matriculaControl.getListMatricula().getInfo(filaSeleccionada).getCursas().getInfo(i);
            if (cursaActual.getId_estudiante() == null && !asignado) {
                cursaControl.getCursa().setId(cursaControl.getListCursa().getInfo(i).getId());
                cursaControl.getCursa().setId_materia(cursaControl.getListCursa().getInfo(i).getId_materia());
                cursaControl.getCursa().setId_matricula(cursaControl.getListCursa().getInfo(i).getId_matricula());
                cursaControl.getCursa().setId_docente(cursaControl.getListCursa().getInfo(i).getId_docente());
                cursaControl.getCursa().setParalelo(cursaControl.getListCursa().getInfo(i).getParalelo());
                cursaControl.getCursa().setId_estudiante(cbxEstudiante.getSelectedIndex());
                asignado = true;
                if (cursaControl.marge(cursaControl.getCursa(), i)) {
                    JOptionPane.showMessageDialog(null, "Se ha matriculado con exito");
                    cursaControl.setCursa(null);
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo guardar, hubo un error");
                }

            }

        }

    }

    public EstudianteMatricula() throws EmptyException {
        initComponents();
        cargarTabla();
        this.setLocationRelativeTo(null);
        pnlFondo.setIcon(new ImageIcon("fotos/Azul.png"));
        pnlLogo.setIcon(new ImageIcon("fotos/unlLogo.png"));
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFondo = new org.edisoncor.gui.panel.PanelImage();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        cbxEstudiante = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbMatricula = new javax.swing.JTable();
        pnlLogo = new org.edisoncor.gui.panel.PanelImage();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        btnAdmFacultad = new javax.swing.JMenuItem();
        btnAdmCarrera = new javax.swing.JMenuItem();
        btnAdmMalla = new javax.swing.JMenuItem();
        btnAdmCiclo = new javax.swing.JMenuItem();
        btnAdmCursa = new javax.swing.JMenuItem();
        btnAdmMatricula = new javax.swing.JMenuItem();
        btnAdmPeriodo = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Matriculas");
        pnlFondo.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 40, -1, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Criterio:");
        pnlFondo.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 200, -1, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        pnlFondo.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 200, 150, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Texto");
        pnlFondo.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 200, -1, -1));
        pnlFondo.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 430, 170, -1));

        jButton1.setText("Ordenar");
        pnlFondo.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 380, -1, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Estudiante:");
        pnlFondo.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 430, -1, -1));

        cbxEstudiante.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        pnlFondo.add(cbxEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 200, 220, -1));

        jButton2.setText("Buscar");
        pnlFondo.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 380, -1, -1));

        tbMatricula.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbMatricula);

        pnlFondo.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 260, 600, 110));
        pnlFondo.add(pnlLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 320, 100));

        getContentPane().add(pnlFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1180, 580));

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

        btnAdmPeriodo.setText("Periodo Academico");
        btnAdmPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdmPeriodoActionPerformed(evt);
            }
        });
        jMenu1.add(btnAdmPeriodo);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Menu");

        jMenuItem1.setText("Inicio");
        jMenu2.add(jMenuItem1);

        jMenuItem2.setText("Salir");
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdmFacultadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdmFacultadActionPerformed
        try {
            new GuardarFacultad().setVisible(true);
            this.dispose();
        } catch (EmptyException ex) {
            Logger.getLogger(GuardarCursa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAdmFacultadActionPerformed

    private void btnAdmCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdmCarreraActionPerformed
        try {
            new GuardarCarrera().setVisible(true);
            this.dispose();
        } catch (EmptyException ex) {
            Logger.getLogger(GuardarCursa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAdmCarreraActionPerformed

    private void btnAdmMallaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdmMallaActionPerformed
        try {
            new GuardarMalla().setVisible(true);
            this.dispose();
        } catch (EmptyException ex) {
            Logger.getLogger(GuardarCursa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAdmMallaActionPerformed

    private void btnAdmCicloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdmCicloActionPerformed
        try {
            new GuardarCiclo().setVisible(true);
            this.dispose();
        } catch (EmptyException ex) {
            Logger.getLogger(GuardarCursa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAdmCicloActionPerformed

    private void btnAdmCursaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdmCursaActionPerformed
        new GuardarCursa().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAdmCursaActionPerformed

    private void btnAdmMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdmMatriculaActionPerformed
        try {
            new GuardarMatricula().setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(GuardarCursa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAdmMatriculaActionPerformed

    private void btnAdmPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdmPeriodoActionPerformed
        new GuardarPeriodoAcademico().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAdmPeriodoActionPerformed
    

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
            java.util.logging.Logger.getLogger(EstudianteMatricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EstudianteMatricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EstudianteMatricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EstudianteMatricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new EstudianteMatricula().setVisible(true);
                } catch (EmptyException ex) {
                    Logger.getLogger(EstudianteMatricula.class.getName()).log(Level.SEVERE, null, ex);
                }
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
    private javax.swing.JMenuItem btnAdmPeriodo;
    private javax.swing.JComboBox<String> cbxEstudiante;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private org.edisoncor.gui.panel.PanelImage pnlFondo;
    private org.edisoncor.gui.panel.PanelImage pnlLogo;
    private javax.swing.JTable tbMatricula;
    // End of variables declaration//GEN-END:variables
}
