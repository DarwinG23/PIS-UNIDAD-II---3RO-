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
import materias.vista.FrmMateria;
import matricula.controlador.CursaControl;
import matricula.vista.tabla.ModeloTablaCursa;
import usuarios.modelo.Docente;
import usuarios.vista.LoginPrincipal;
import usuarios.vista.Menu;
import usuarios.vista.Menu;

/**
 *
 * @author darwi
 */
public class GuardarCursa extends javax.swing.JFrame {

    private ModeloTablaCursa mtc = new ModeloTablaCursa();
    private CursaControl cursaControl = new CursaControl();
    private Docente docente;

    public void cargarFacultades(DynamicList cursas) {
        mtc.setCursas(cursas);
        initComponents();
    }

    public Boolean verificar() {
        return (!txtParalelo.getText().trim().isEmpty());
    }

    private void cargarTabla() {
        mtc.setCursas(cursaControl.getListCursa());
        tbCursa.setModel(mtc);
        tbCursa.updateUI();
    }

    private void guardar(Integer filaSeleccionada) throws EmptyException {
        if (verificar()) {
            cursaControl.getCursa().setId(cursaControl.getListCursa().getInfo(filaSeleccionada).getId());
            cursaControl.getCursa().setId_materia(cursaControl.getListCursa().getInfo(filaSeleccionada).getId_materia());
            cursaControl.getCursa().setId_matricula(cursaControl.getListCursa().getInfo(filaSeleccionada).getId_matricula());
            cursaControl.getCursa().setId_docente(cbxDocente.getSelectedIndex());
            cursaControl.getCursa().setParalelo(txtParalelo.getText());
            if (cursaControl.marge(cursaControl.getCursa(), filaSeleccionada)) {
                JOptionPane.showMessageDialog(null, "Datos guardados");
                cargarTabla();
                limpiar();
                cursaControl.setCursa(null);
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo guardar, hubo un error");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Falta llenar campos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiar() {
        txtParalelo.setText("");
    }

    public GuardarCursa() {
        initComponents();
        cargarTabla();
        this.setLocationRelativeTo(null);
        pnlAzul.setIcon(new ImageIcon("fotos/Azul.png"));
        pnlGris.setIcon(new ImageIcon("fotos/Celeste.jpg"));
    }

    public GuardarCursa(Docente usuario) {
        initComponents();
        cargarTabla();
        this.setLocationRelativeTo(null);
        pnlAzul.setIcon(new ImageIcon("fotos/Azul.png"));
        pnlGris.setIcon(new ImageIcon("fotos/Celeste.jpg"));
        this.docente = usuario;
    }

    private void ordenar() {
        String criterio = cbxCriterio.getSelectedItem().toString().toLowerCase();
        Integer tipo = 0;
        if (cbxOrden.isSelected()) {
            tipo = 1;
        }
        try {
            mtc.setCursas(cursaControl.ordenarQuickSort(cursaControl.all(), tipo, criterio));
            tbCursa.setModel(mtc);
            tbCursa.updateUI();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void buscar() {
        String texto = txtBuscar.getText();
        String criterio = cbxCriterio.getSelectedItem().toString();
        if (cbxMetodo.getSelectedItem().toString() == "Busqueda_Binaria") {
            try {
                System.out.println("Busqueda_Binaria");
                mtc.setCursas(cursaControl.all());
                mtc.setCursas(cursaControl.busquedaBinaria(texto, mtc.getCursas(), criterio));
                tbCursa.setModel(mtc);
                tbCursa.updateUI();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } else if (cbxMetodo.getSelectedItem().toString() == "Busqueda_Lineal") {
            try {
                System.out.println("Busqueda_Lineal");
                mtc.setCursas(cursaControl.all());
                mtc.setCursas(cursaControl.buscarPorCriterioLineal(texto, mtc.getCursas(), criterio));
                tbCursa.setModel(mtc);
                tbCursa.updateUI();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlAzul = new org.edisoncor.gui.panel.PanelImage();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtParalelo = new javax.swing.JTextField();
        cbxDocente = new javax.swing.JComboBox<>();
        btnAgregar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        pnlGris = new org.edisoncor.gui.panel.PanelImage();
        cbxCriterio = new javax.swing.JComboBox<>();
        cbxMetodo = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        cbxOrden = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnOrdenar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCursa = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        btnIncio = new javax.swing.JMenuItem();
        btnSalir = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        btnAdmFacultad = new javax.swing.JMenuItem();
        btnAdmCarrera = new javax.swing.JMenuItem();
        btnAdmMalla = new javax.swing.JMenuItem();
        btnAdmCiclo = new javax.swing.JMenuItem();
        btnAdmCursa = new javax.swing.JMenuItem();
        btnAdmMatricula = new javax.swing.JMenuItem();
        btnAdmPeriodo = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlAzul.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Paralelo:");
        pnlAzul.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Docente:");
        pnlAzul.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));
        pnlAzul.add(txtParalelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 237, -1));

        cbxDocente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        pnlAzul.add(cbxDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 240, -1));

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        pnlAzul.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 560, -1, -1));

        jButton3.setText("Modificar");
        pnlAzul.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 560, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("CURSA");
        pnlAzul.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, -1, -1));

        getContentPane().add(pnlAzul, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 600));

        pnlGris.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbxCriterio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "id_estudiante", "id_matricula", "id_materia", "id_docente", "paralelo" }));
        pnlGris.add(cbxCriterio, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 120, -1));

        cbxMetodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Busqueda_Lineal", "Busqueda_Binaria" }));
        pnlGris.add(cbxMetodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Criterio:");
        pnlGris.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        cbxOrden.setText("Ascendente");
        pnlGris.add(cbxOrden, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, 100, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Texto:");
        pnlGris.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, -1, -1));
        pnlGris.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 90, 100, -1));

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        pnlGris.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, -1, -1));

        btnOrdenar.setText("Ordenar");
        btnOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenarActionPerformed(evt);
            }
        });
        pnlGris.add(btnOrdenar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        tbCursa.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbCursa);

        pnlGris.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 580, 90));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("CURSAS");
        pnlGris.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, -1, -1));

        getContentPane().add(pnlGris, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 0, 640, 600));

        jMenu2.setText("Menu");

        btnIncio.setText("Inicio");
        btnIncio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncioActionPerformed(evt);
            }
        });
        jMenu2.add(btnIncio);

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jMenu2.add(btnSalir);

        jMenuBar1.add(jMenu2);

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

        jMenuItem1.setText("Materias");
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

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        int filaSeleccionada = tbCursa.getSelectedRow();
        if (filaSeleccionada != -1) {
            try {
                guardar(filaSeleccionada);
            } catch (Exception ex) {
                Logger.getLogger(GuardarCiclo.class.getName()).log(Level.SEVERE, null, ex);
            }
            cargarTabla();
        } else {
            JOptionPane.showMessageDialog(null, "No ha seleccionado ningun ciclo", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenarActionPerformed
        ordenar();
    }//GEN-LAST:event_btnOrdenarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscar();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnAdmFacultadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdmFacultadActionPerformed
        try {
            new GuardarFacultad(this.docente).setVisible(true);
            this.dispose();
        } catch (EmptyException ex) {
            Logger.getLogger(GuardarCursa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAdmFacultadActionPerformed

    private void btnAdmCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdmCarreraActionPerformed
        try {
            new GuardarCarrera(this.docente).setVisible(true);
            this.dispose();
        } catch (EmptyException ex) {
            Logger.getLogger(GuardarCursa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAdmCarreraActionPerformed

    private void btnAdmMallaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdmMallaActionPerformed
        try {
            new GuardarMalla(this.docente).setVisible(true);
            this.dispose();
        } catch (EmptyException ex) {
            Logger.getLogger(GuardarCursa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAdmMallaActionPerformed

    private void btnAdmCicloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdmCicloActionPerformed
        try {
            new GuardarCiclo(this.docente).setVisible(true);
            this.dispose();
        } catch (EmptyException ex) {
            Logger.getLogger(GuardarCursa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAdmCicloActionPerformed

    private void btnAdmCursaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdmCursaActionPerformed
        new GuardarCursa(this.docente).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAdmCursaActionPerformed

    private void btnAdmMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdmMatriculaActionPerformed
        try {
            new GuardarMatricula(this.docente).setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(GuardarCursa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAdmMatriculaActionPerformed

    private void btnAdmPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdmPeriodoActionPerformed
        new GuardarPeriodoAcademico(this.docente).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAdmPeriodoActionPerformed

    private void btnIncioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncioActionPerformed
        new Menu(this.docente).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnIncioActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        new LoginPrincipal().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new FrmMateria(this.docente).setVisible(true);
        this.dispose();
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
            java.util.logging.Logger.getLogger(GuardarCursa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GuardarCursa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GuardarCursa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GuardarCursa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GuardarCursa().setVisible(true);
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
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JMenuItem btnIncio;
    private javax.swing.JButton btnOrdenar;
    private javax.swing.JMenuItem btnSalir;
    private javax.swing.JComboBox<String> cbxCriterio;
    private javax.swing.JComboBox<String> cbxDocente;
    private javax.swing.JComboBox<String> cbxMetodo;
    private javax.swing.JCheckBox cbxOrden;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private org.edisoncor.gui.panel.PanelImage pnlAzul;
    private org.edisoncor.gui.panel.PanelImage pnlGris;
    private javax.swing.JTable tbCursa;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtParalelo;
    // End of variables declaration//GEN-END:variables
}
