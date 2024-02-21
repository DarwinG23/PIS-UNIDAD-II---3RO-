/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package usuarios.vista;

import exeption.EmptyException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import lista.DynamicList;
import usuarios.controlador.daoUsuario.DocenteControlDao;
import usuarios.controlador.daoUsuario.EstudianteControlDao;
import usuarios.controlador.daoUsuario.RegistroControl1;
import usuarios.modelo.Docente;
import usuarios.modelo.Estudiante;

/**
 *
 * @author Alexander
 */
public class LoginPrincipal extends javax.swing.JFrame {

    EstudianteControlDao estudianteDao = new EstudianteControlDao();
    DocenteControlDao dcd = new DocenteControlDao();

    RegistroControl1 registroControl = new RegistroControl1();

    public LoginPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    private void Limpiar() {

        txtUsuario.setText(" ");
        txtContrasenia.setText(" ");
//        CargarTabla();
//        estudianteControl.setEstudiante(null);

    }

    private Boolean Validar() {
        return (!txtUsuario.getText().trim().isEmpty()
                && !txtContrasenia.getText().trim().isEmpty());
    }

    private void Guardar() {
        if (Validar()) {
            registroControl.getRegistro1().setUsuario(txtUsuario.getText());
            registroControl.getRegistro1().setContrasenia(txtContrasenia.getText());
//             estudianteControl.getEstudiante1().setEdad(txtEdad.getText());
//              estudianteControl.getEstudiante1().setCorreo(txtCorreo.getText());
//            estudianteControl.getEstudiante1().setPromedioAcademico(txtPeriodo.getText());     
            if (registroControl.persist()) {
                JOptionPane.showMessageDialog(null, "Datos guardados con exito");
                registroControl.setRegistro(null);
//                CargarTabla();
                Limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo guardar");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Falta llenar campos ");

        }
        //}
    }

    private void VerificarEstudiante() {

        DynamicList<Estudiante> listaEstudiantes = estudianteDao.all();
        DynamicList<Docente> listaDocentes = dcd.all();

        String usuarioIngresado = txtUsuario.getText();
        String contrasenaIngresada = new String(txtContrasenia.getPassword());

        boolean credencialesCorrectas = false;

        for (Estudiante estudiante : listaEstudiantes.toArray()) {
            if (estudiante.getCorreoUsuario().equals(usuarioIngresado) && estudiante.getContraseniaUsuario().equals(contrasenaIngresada)) {
                credencialesCorrectas = true;
                Menu abrirMenu = new Menu(estudiante);
                abrirMenu.setVisible(true);
                dispose();
                break;
            }
        }

        for (Docente docente : listaDocentes.toArray()) {
            if (docente.getCorreoUsuario().equals(usuarioIngresado) && docente.getContraseniaUsuario().equals(contrasenaIngresada)) {
                credencialesCorrectas = true;
                String rol = docente.getRolDocente();
                if (rol.equals("Docente")) {
                    new Menu(docente).setVisible(true);
                    this.dispose();
                } else if (rol.equals("Personal Administrativo")) {         
                    new Menu(docente).setVisible(true);
                    this.dispose();
                }
                dispose();
                break;
            }
        }

        if (!credencialesCorrectas) {
            JOptionPane.showMessageDialog(null, "Inicio de sesión fallido. Verifique sus credenciales.", "CREDENCIALES INCORRECTAS", JOptionPane.WARNING_MESSAGE);
            txtUsuario.setText("");
            txtContrasenia.setText("");
        }
//        DynamicList<Estudiante> listaEstudiantes = estudianteDao.all();
//        DynamicList<Docente> listaDocente = dcd.all();
//
//        String usuarioIngresado = txtUsuario.getText();
//        char[] contra = txtContrasenia.getPassword();
//        String contrasenaIngresada = new String(contra);
//
//        boolean credencialesCorrectas = false;
//
//        for (Estudiante estudiante : listaEstudiantes.toArray()) {
//            if (estudiante.getCorreoUsuario().equals(usuarioIngresado) && estudiante.getContraseniaUsuario().equals(contrasenaIngresada)) {
//                credencialesCorrectas = true;
//                Menu abrirMenu = new Menu();
//                abrirMenu.setVisible(true);
//                txtNombreMenu.setText("Usuario: Estudiante - " + estudiante.getDatosUsuario().getNombre());
//                dispose();
//                break;
//            }
//        }
//
//        if (!credencialesCorrectas) {
//            JOptionPane.showMessageDialog(null, "Inicio de sesión fallido. Verifique sus credenciales.", "CREDENCIALES INCORRECTAS", JOptionPane.WARNING_MESSAGE);
//            txtUsuario.setText("");
//            txtContrasenia.setText("");
//        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnIniciar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtContrasenia = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("            INICIO DE SESIÓN");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 40, 429, 88));

        jPanel3.setBackground(new java.awt.Color(0, 0, 40));
        jPanel3.setForeground(new java.awt.Color(0, 0, 0));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(143, 252, 41, -1));

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Contraseña:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 123, 93, 32));

        btnIniciar.setBackground(new java.awt.Color(0, 0, 51));
        btnIniciar.setForeground(new java.awt.Color(255, 255, 255));
        btnIniciar.setText("INICIAR SESION");
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });
        jPanel3.add(btnIniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 202, 163, -1));

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Usuario:");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 73, 75, 32));
        jPanel3.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(232, 78, 202, -1));
        jPanel3.add(txtContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(232, 129, 202, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 134, 550, 320));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 601, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed

        VerificarEstudiante();
    }//GEN-LAST:event_btnIniciarActionPerformed

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
            java.util.logging.Logger.getLogger(LoginPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField txtContrasenia;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

}
