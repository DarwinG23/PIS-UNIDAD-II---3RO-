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
import matricula.controlador.FacultadControl;
import matricula.modelo.Carrera;
import matricula.vista.util.UtilVistaCarrera;
//import usuarios.vista.Inicio;

/**
 *
 * @author darwi
 */
public class AgregarCarrera extends javax.swing.JFrame {

    private Integer fila;
    private FacultadControl facultadControl = new FacultadControl();

    public void agregar() throws EmptyException {
        DynamicList<Carrera> carreras = facultadControl.getListFacultades().getInfo(fila).getCarreras();
        carreras.add(UtilVistaCarrera.obtenerCarrera(cbxCarrera));
        facultadControl.getFacultad().setCarreras(carreras);
        facultadControl.getFacultad().setNombre(facultadControl.getListFacultades().getInfo(fila).getNombre());
        facultadControl.getFacultad().setDescripcion(facultadControl.getListFacultades().getInfo(fila).getDescripcion());
        facultadControl.getFacultad().setId(facultadControl.getListFacultades().getInfo(fila).getId());
        facultadControl.getFacultad().setNumBloques(facultadControl.getListFacultades().getInfo(fila).getNumBloques());
        facultadControl.getFacultad().setUbicacion(facultadControl.getListFacultades().getInfo(fila).getUbicacion());
        if (facultadControl.marge(facultadControl.getFacultad(), fila)) {
            JOptionPane.showMessageDialog(null, "Malla Aregada");
            facultadControl.setFacultad(null);
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo agregar, hubo un error");
        }
    }

    public AgregarCarrera() {
        initComponents();
        this.setLocationRelativeTo(null);
        pnlFondo.setIcon(new ImageIcon("fotos/AzulGris.jpg"));
    }

    public AgregarCarrera(Integer filaSeleccionada) throws EmptyException, Exception {
        initComponents();
        UtilVistaCarrera.cargarcomboCarreraFiltro(cbxCarrera);
        fila = filaSeleccionada;
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
        btnSalir = new javax.swing.JButton();
        cbxCarrera = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        pnlFondo.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        pnlFondo.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 57, -1));

        cbxCarrera.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        pnlFondo.add(cbxCarrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 221, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 51));
        jLabel1.setText("Seleccione la carrera que desea agregar a la facultad");
        pnlFondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 20));

        getContentPane().add(pnlFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 140));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed

        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        try {
            agregar();
        } catch (EmptyException ex) {
            Logger.getLogger(AgregarCarrera.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            java.util.logging.Logger.getLogger(AgregarCarrera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarCarrera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarCarrera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarCarrera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarCarrera().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cbxCarrera;
    private javax.swing.JLabel jLabel1;
    private org.edisoncor.gui.panel.PanelImage pnlFondo;
    // End of variables declaration//GEN-END:variables
}
