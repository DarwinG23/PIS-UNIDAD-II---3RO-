/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package usuarios.vista;

import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import usuarios.controlador.daoUsuario.EstudianteControlDao;
import usuarios.modelo.Usuario;
import vista.modelo.ModeloTablaEstudiante;

/**
 *
 * @author Alexander
 */
public class GestionEstudiante extends javax.swing.JFrame {

    ModeloTablaEstudiante mta = new ModeloTablaEstudiante();
    EstudianteControlDao estudianteControl = new EstudianteControlDao();

    /**
     * Creates new form GestionEstudiante
     */
    public GestionEstudiante() {
        initComponents();
        this.setLocationRelativeTo(null);
        Limpiar();
    }

    private void CargarTabla() {
        mta.setEstudianteTabla(estudianteControl.getListaEstudiante());
        tblMostrar.setModel((TableModel) mta);
        tblMostrar.updateUI();
    }

    private void Limpiar() {

        txtPeriodo.setEnabled(false);
        tblMostrar.clearSelection();
        txtNombre.setText("");
        txtCedula.setText("");
        txtEdad.setText("");
        txtApellido.setText("");
        txtCorreo.setText("");
        txtPeriodo.setText("");
        txtUsuario.setText("");
        txtContrasenia.setText("");
        CargarTabla();
        estudianteControl.setEstudiante(null);

    }

    private Boolean Validar() {
        return (!txtApellido.getText().trim().isEmpty()
                && !txtNombre.getText().trim().isEmpty()
                && !txtCorreo.getText().trim().isEmpty()
                && !txtEdad.getText().trim().isEmpty()
                && !txtCedula.getText().trim().isEmpty()
                && !txtUsuario.getText().trim().isEmpty()
                && !txtContrasenia.getText().trim().isEmpty());
    }
    
    private String generarCorreo() {
        String nombre = txtNombre.getText().trim();
        String apellido = txtApellido.getText().trim();
        String primerNombre = "";
        String primerApellido = "";

        if (!nombre.isEmpty()) {
            primerNombre = nombre.contains(" ") ? nombre.substring(0, nombre.indexOf(" ")) : nombre;
        }

        if (!apellido.isEmpty()) {
            primerApellido = apellido.contains(" ") ? apellido.substring(0, apellido.indexOf(" ")) : apellido;
        }
        String correo = primerNombre.toLowerCase() + "." + primerApellido.toLowerCase() + "@unl.edu.ec";

        return correo;
    }

    private void Guardar() {
        if (Validar()) {
            
            Usuario uc = new Usuario();
            uc.setCedula(txtCedula.getText());
            uc.setNombre(txtNombre.getText());
            uc.setApellido(txtApellido.getText());
            uc.setEdad(txtEdad.getText());
            uc.setCorreo(txtCorreo.getText());
            
            estudianteControl.getEstudiante().setDatosUsuario(uc);
            estudianteControl.getEstudiante().getDatosUsuario().setEdad(txtEdad.getText());
            estudianteControl.getEstudiante().setPromedioAcademico(txtPeriodo.getText());
            estudianteControl.getEstudiante().setCorreoUsuario(txtUsuario.getText());
//            char[] contrase = jTextField1.getPassword();
//            String contrasena = new String(contrase);
            estudianteControl.getEstudiante().setContraseniaUsuario(txtContrasenia.getText());
            
            if (estudianteControl.Persist()) {
                JOptionPane.showMessageDialog(null, "Datos guardados con exito");
                estudianteControl.setEstudiante(null);
                CargarTabla();
                Limpiar();
            } 
            else {
                JOptionPane.showMessageDialog(null, "No se pudo guardar");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Falta llenar campos ");

        }
    }

    private void cargarVista() {
        int fila = tblMostrar.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(null, "Escoja un registro de la tabla");
        } 
        else {
            try {
                estudianteControl.setEstudiante(mta.getEstudianteTabla().getInfo(fila));
                txtNombre.setText(estudianteControl.getEstudiante().getDatosUsuario().getNombre());
                txtApellido.setText(estudianteControl.getEstudiante().getDatosUsuario().getApellido());
                txtEdad.setText(estudianteControl.getEstudiante().getDatosUsuario().getEdad());
                txtCedula.setText(estudianteControl.getEstudiante().getDatosUsuario().getCedula());
                txtCorreo.setText(estudianteControl.getEstudiante().getDatosUsuario().getCorreo());
                txtPeriodo.setText(estudianteControl.getEstudiante().getPromedioAcademico());
                txtUsuario.setText(estudianteControl.getEstudiante().getCorreoUsuario());
                txtContrasenia.setText(estudianteControl.getEstudiante().getContraseniaUsuario());

            } catch (Exception e) {
                System.out.println("Error seleccione una fila primero");
            }

        }
    }

    private void ordenar() {
        String criterio = cbxCriterio1.getSelectedItem().toString().toLowerCase();
        Integer tipo = 0;
        if (cbxMetodo.isSelected()) {
            tipo = 1;
        }
        try {
            System.out.println("QuickSort");
            mta.setEstudianteTabla(estudianteControl.ordenarQuickSort(estudianteControl.all(), tipo, criterio));
            tblMostrar.setModel(mta);
            tblMostrar.updateUI();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void buscar() {
        String texto = txtBuscar.getText();
        String criterio = cbxCriterio1.getSelectedItem().toString();
        if (cbxMetodo1.getSelectedItem().toString() == "Busqueda_Binaria") {
            try {
                System.out.println("Busqueda_Binaria");
                mta.setEstudianteTabla(estudianteControl.all());
                mta.setEstudianteTabla(estudianteControl.busquedaBinaria(texto, mta.getEstudianteTabla(), criterio));
                tblMostrar.setModel(mta);
                tblMostrar.updateUI();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } else if (cbxMetodo1.getSelectedItem().toString() == "Busqueda_Lineal") {
            try {
                System.out.println("Busqueda Lineal");
                mta.setEstudianteTabla(estudianteControl.all());
                mta.setEstudianteTabla(estudianteControl.buscarPorCriterioLineal(texto, mta.getEstudianteTabla(), criterio));
                tblMostrar.setModel(mta);
                tblMostrar.updateUI();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        PN = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtPeriodo = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtEdad = new javax.swing.JTextField();
        txtCedula = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblMostrar = new javax.swing.JTable();
        btnGuardar = new javax.swing.JButton();
        btnSeleccionar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        cbxCriterio = new javax.swing.JComboBox<>();
        cbxMetodo = new javax.swing.JCheckBox();
        btnOrdenar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        cbxCriterio1 = new javax.swing.JComboBox<>();
        cbxMetodo1 = new javax.swing.JComboBox<>();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        txtContrasenia = new javax.swing.JTextField();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PN.setBackground(new java.awt.Color(0, 0, 51));
        PN.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("REGISTRO DEL ESTUDIANTE");
        PN.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 10, 670, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Promedio Académico:");
        PN.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 150, -1));

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre:");
        PN.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Apellido:");
        PN.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Edad:");
        PN.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Cedula:");
        PN.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        PN.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 520, -1));
        PN.add(txtPeriodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 340, 490, -1));
        PN.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 520, -1));

        txtEdad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEdadActionPerformed(evt);
            }
        });
        PN.add(txtEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 520, -1));
        PN.add(txtCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 520, -1));

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Contraseña:");
        PN.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, -1));
        PN.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 520, -1));

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
        tblMostrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMostrarMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblMostrar);

        PN.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 680, 160));

        btnGuardar.setBackground(new java.awt.Color(0, 0, 51));
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("GUARDAR DATOS");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        PN.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 390, -1, -1));

        btnSeleccionar.setBackground(new java.awt.Color(0, 0, 51));
        btnSeleccionar.setForeground(new java.awt.Color(255, 255, 255));
        btnSeleccionar.setText("SELECCIONAR DATOS");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });
        PN.add(btnSeleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 390, 160, -1));

        btnModificar.setBackground(new java.awt.Color(0, 0, 51));
        btnModificar.setForeground(new java.awt.Color(255, 255, 255));
        btnModificar.setText("MODIFICAR DATOS");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        PN.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 390, 160, -1));

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Ordenar:");
        PN.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 610, -1, -1));

        cbxCriterio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "nombre", "apellido", "cedula", "edad", "correo", "promedioAcademico" }));
        PN.add(cbxCriterio, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 650, -1, -1));

        cbxMetodo.setText("DESCENDENTE");
        PN.add(cbxMetodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 610, -1, -1));

        btnOrdenar.setBackground(new java.awt.Color(0, 0, 51));
        btnOrdenar.setForeground(new java.awt.Color(255, 255, 255));
        btnOrdenar.setText("ORDENAR");
        btnOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenarActionPerformed(evt);
            }
        });
        PN.add(btnOrdenar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 610, 120, -1));

        jLabel9.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Buscar:");
        PN.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 650, -1, -1));

        cbxCriterio1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "nombre", "apellido", "cedula", "edad", "correo", "promedioAcademico" }));
        PN.add(cbxCriterio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 610, -1, -1));

        cbxMetodo1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Busqueda_Lineal", "Busqueda_Binaria" }));
        PN.add(cbxMetodo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 650, 130, -1));
        PN.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 650, 140, -1));

        btnBuscar.setBackground(new java.awt.Color(0, 0, 51));
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        PN.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 650, 90, -1));

        jLabel10.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Correo:");
        PN.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));

        jLabel11.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Usuario:");
        PN.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));

        txtUsuario.setEditable(false);
        PN.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 420, -1));

        jButton1.setText("GENERAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        PN.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 260, -1, -1));

        txtContrasenia.setEditable(false);
        PN.add(txtContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, 520, -1));

        getContentPane().add(PN, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 690));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        Guardar();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        cargarVista();
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        
        if (Validar()) {
            Usuario uc = new Usuario();
            uc.setCedula(txtCedula.getText());
            uc.setNombre(txtNombre.getText());
            uc.setApellido(txtApellido.getText());
            uc.setEdad(txtEdad.getText());
            uc.setCorreo(txtCorreo.getText());

            estudianteControl.getEstudiante().setDatosUsuario(uc);
            estudianteControl.getEstudiante().setPromedioAcademico(txtPeriodo.getText());
            estudianteControl.getEstudiante().setCorreoUsuario(txtUsuario.getText());
//            char[] contrase = txtContrasenia.getPassword();
//            String contrasena = new String(contrase);
            estudianteControl.getEstudiante().setContraseniaUsuario(txtContrasenia.getText());

            if (estudianteControl.marge(estudianteControl.getEstudiante(), tblMostrar.getSelectedRow())) {
                JOptionPane.showMessageDialog(null, "Datos guardados con exito");
                estudianteControl.setEstudiante(null);
                CargarTabla();
                Limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo guardar");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Falta llenar campos ");
        }
        
    }//GEN-LAST:event_btnModificarActionPerformed

    private void txtEdadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEdadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEdadActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void btnOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenarActionPerformed
        ordenar();
    }//GEN-LAST:event_btnOrdenarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscar( );
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void tblMostrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMostrarMouseClicked
         cargarVista();
    }//GEN-LAST:event_tblMostrarMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        txtUsuario.setText(generarCorreo());
        txtContrasenia.setText(txtCedula.getText());
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(GestionEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionEstudiante().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PN;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnOrdenar;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JComboBox<String> cbxCriterio;
    private javax.swing.JComboBox<String> cbxCriterio1;
    private javax.swing.JCheckBox cbxMetodo;
    private javax.swing.JComboBox<String> cbxMetodo1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tblMostrar;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtContrasenia;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPeriodo;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
