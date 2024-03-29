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
import materias.modelo.Materia;
import materias.vista.util.UtilVista1;
import matricula.controlador.CicloControl;


/**
 *
 * @author darwi
 */
public class AgregarMateria extends javax.swing.JFrame {

    private CicloControl cicloControl = new CicloControl();
    private Integer fila;

    public void agregar() throws EmptyException {
        DynamicList<Materia> materias = cicloControl.getListCiclo().getInfo(fila).getMaterias();
        materias.add(UtilVista1.obtenerMateria(cbxMateria));
        cicloControl.getCiclo().setMaterias(cicloControl.getListCiclo().getInfo(fila).getMaterias());
        cicloControl.getCiclo().setNumCiclo(cicloControl.getListCiclo().getInfo(fila).getNumCiclo());
        cicloControl.getCiclo().setId_Malla(cicloControl.getListCiclo().getInfo(fila).getId_Malla());
        cicloControl.getCiclo().setMaterias(materias);
        cicloControl.getCiclo().setId(cicloControl.getListCiclo().getInfo(fila).getId());
        if (cicloControl.marge(cicloControl.getCiclo(), fila)) {
            JOptionPane.showMessageDialog(null, "Materia Aregada");
            cicloControl.setCiclo(null);
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo guardar, hubo un error");
        }
    }

    public AgregarMateria (Integer filaSeleccionada) throws EmptyException, Exception {
        initComponents();
        UtilVista1.cargarcomboRolesL(cbxMateria);
        fila = filaSeleccionada;
        this.setLocationRelativeTo(null);
        pnlFondo.setIcon(new ImageIcon("fotos/AzulGris.jpg"));
    }

    public AgregarMateria() throws EmptyException, Exception {
        initComponents();
        UtilVista1.cargarcomboRolesL(cbxMateria);
        this.setLocationRelativeTo(null);
        pnlFondo.setIcon(new ImageIcon("fotos/AzulGris.jpg"));
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFondo = new org.edisoncor.gui.panel.PanelImage();
        btnAgregar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cbxMateria = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        pnlFondo.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 64, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 51));
        jLabel1.setText("Seleccione la materia que desea agregar al ciclo");
        pnlFondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        cbxMateria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        pnlFondo.add(cbxMateria, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 246, -1));

        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        pnlFondo.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 56, -1));

        getContentPane().add(pnlFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 130));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        try {
            agregar();
        } catch (EmptyException ex) {
            Logger.getLogger(AgregarMateria.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_btnAgregarActionPerformed

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
            java.util.logging.Logger.getLogger(AgregarMateria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarMateria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarMateria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarMateria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new AgregarMateria().setVisible(true);
                } catch (EmptyException ex) {
                    Logger.getLogger(AgregarMateria.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(AgregarMateria.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JComboBox<String> cbxMateria;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private org.edisoncor.gui.panel.PanelImage pnlFondo;
    // End of variables declaration//GEN-END:variables
}
