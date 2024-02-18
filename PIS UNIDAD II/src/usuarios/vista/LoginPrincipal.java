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
import static usuarios.vista.Menu.txtNombreMenu;

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
        return (
                !txtUsuario.getText().trim().isEmpty()
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
                Menu abrirMenu = new Menu();
                abrirMenu.setVisible(true);
                txtNombreMenu.setText("Usuario: Estudiante - " + estudiante.getDatosUsuario().getNombre());
                dispose();
                break;
            }
        }

        for (Docente docente : listaDocentes.toArray()) {
            if (docente.getCorreoUsuario().equals(usuarioIngresado) && docente.getContraseniaUsuario().equals(contrasenaIngresada)) {
                credencialesCorrectas = true;
                String rol = docente.getRolDocente();
                if (rol.equals("Docente")) {
                    System.out.println("Docente normal");
                    /*
                    Aqui mandan la interfaz del docente que asigna tareas y revisa las tareas o la interfaz intermedia que les decia
                    En este formato 
                    InterfazDocente abrirMenu = new InterfazDocente();
                    abrirMenu.setVisible(true);
                    */
                } else if (rol.equals("Personal Administrativo")) {
                    System.out.println("Docente administrativo");
                    /*
                    Aqui mandan la interfaz del docente administrativo en la que gestiona todo lo administrativo
                    lo mismo que la otra interfaz
                    */
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

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("            INICIO DE SESIÓN");

        jPanel3.setBackground(new java.awt.Color(0, 0, 40));
        jPanel3.setForeground(new java.awt.Color(0, 0, 0));

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Contraseña:");

        btnIniciar.setBackground(new java.awt.Color(0, 0, 51));
        btnIniciar.setForeground(new java.awt.Color(255, 255, 255));
        btnIniciar.setText("INICIAR SESION");
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Usuario:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(54, 54, 54)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                            .addComponent(txtContrasenia)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(btnIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(113, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addComponent(btnIniciar)
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(233, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
            //        Guardar();
//        Menu A = new Menu();
//        A.setVisible(true);
//        this.dispose();
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
