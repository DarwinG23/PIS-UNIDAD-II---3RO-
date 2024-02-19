/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package usuarios.vista;

import exeption.EmptyException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import lista.DynamicList;
import matricula.vista.EstudianteMatricula;
import matricula.vista.GuardarCarrera;
import matricula.vista.GuardarCiclo;
import matricula.vista.GuardarCursa;
import matricula.vista.GuardarMalla;
import matricula.vista.GuardarMatricula;
import matricula.vista.GuardarPeriodoAcademico;
import tareas.vista.EntregaTarea;
import tareas.vista.ReporteNotas;
import usuarios.controlador.daoUsuario.RegistroControl1;
import usuarios.modelo.Estudiante;
import usuarios.modelo.Registro;
import usuarios.modelo.Usuario;

/**
 *
 * @author Alexander
 */
public class Menu extends javax.swing.JFrame {
  
    RegistroControl1 registroDao = new RegistroControl1();
    Estudiante estudiante;

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
        Fondo3.setIcon(new ImageIcon("fotos/MenuInicio.jpg"));
        this.setLocationRelativeTo(null);
        pnlUsuario.setIcon(new ImageIcon("fotos/usuario.png"));
//        asignarNombre();
    }
    
     public Menu(Estudiante usuario) {
        initComponents();
        Fondo3.setIcon(new ImageIcon("fotos/MenuInicio.jpg"));
        this.setLocationRelativeTo(null);
        this.estudiante = usuario;
        txtNombre.setText( estudiante.getDatosUsuario().getNombre().toUpperCase() + " " + estudiante.getDatosUsuario().getApellido().toUpperCase() );
        pnlUsuario.setIcon(new ImageIcon("fotos/usuario.png"));
//        asignarNombre();
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Fondo3 = new org.edisoncor.gui.panel.PanelImage();
        pnlUsuario = new org.edisoncor.gui.panel.PanelImage();
        txtNombre = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        btnMatricula = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        btnSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Fondo3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout pnlUsuarioLayout = new javax.swing.GroupLayout(pnlUsuario);
        pnlUsuario.setLayout(pnlUsuarioLayout);
        pnlUsuarioLayout.setHorizontalGroup(
            pnlUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        pnlUsuarioLayout.setVerticalGroup(
            pnlUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        Fondo3.add(pnlUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, 50, 50));

        txtNombre.setBackground(new java.awt.Color(153, 153, 255));
        txtNombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(0, 204, 204));
        txtNombre.setText("NOMBRE APELLIDO");
        Fondo3.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 540, 270, 30));

        getContentPane().add(Fondo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, 580));

        jMenu2.setText("Menu");
        jMenu2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        btnMatricula.setText("Matriculas");
        btnMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMatriculaActionPerformed(evt);
            }
        });
        jMenu2.add(btnMatricula);

        jMenuItem3.setText("Tarea");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem5.setText("Calificaciones");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jMenu2.add(btnSalir);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMatriculaActionPerformed
        try {
            new EstudianteMatricula(this.estudiante).setVisible(true);
            this.dispose();
        } catch (EmptyException ex) {
            java.util.logging.Logger.getLogger(GuardarCiclo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnMatriculaActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        new LoginPrincipal().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        EntregaTarea et=new EntregaTarea(this.estudiante);
        this.dispose();
        et.setVisible(true);

    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        ReporteNotas rp=new ReporteNotas(this.estudiante);
        this.dispose();
        rp.setVisible(true);

    }//GEN-LAST:event_jMenuItem5ActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.panel.PanelImage Fondo3;
    private javax.swing.JMenuItem btnMatricula;
    private javax.swing.JMenuItem btnSalir;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem5;
    private org.edisoncor.gui.panel.PanelImage pnlUsuario;
    private javax.swing.JLabel txtNombre;
    // End of variables declaration//GEN-END:variables
}
