/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package usuarios.vista;

import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import usuarios.controlador.daoUsuario.EstudianteControl1;
import vista.modelo.ModeloTablaEstudiante;

/**
 *
 * @author Alexander
 */
public class GestionEstudiante extends javax.swing.JFrame {
    private ModeloTablaEstudiante mta=new ModeloTablaEstudiante();
    private EstudianteControl1 estudianteControl=new EstudianteControl1();
    /**
     * Creates new form GestionEstudiante
     */
    public GestionEstudiante() {
        initComponents();
         this.setLocationRelativeTo(null);
        Limpiar();
    }
    
    private void CargarTabla() {
        mta.setEstudianteTabla(estudianteControl.getEstudiante());
        tblMostrar.setModel((TableModel) mta);
        tblMostrar.updateUI();
    }
    private void Limpiar() {

        txtPeriodo.setEnabled(false);
        tblMostrar.clearSelection();
        txtNombre.setText(" ");
        txtCedula.setText(" ");
        txtEdad.setText(" ");
        txtApellido.setText(" ");
        txtCorreo.setText(" ");
        txtPeriodo.setText(" ");
        CargarTabla();
        estudianteControl.setEstudiante(null);

    }
    private Boolean Validar() {
        return (!txtApellido.getText().trim().isEmpty()
                && !txtNombre.getText().trim().isEmpty()
                && !txtCorreo.getText().trim().isEmpty()
                && !txtEdad.getText().trim().isEmpty()
                && !txtCedula.getText().trim().isEmpty());
    }
    private void Guardar() {
        if (Validar()) {
            estudianteControl.getEstudiante1().setCedula(txtCedula.getText());
            estudianteControl.getEstudiante1().setNombre(txtNombre.getText());
            estudianteControl.getEstudiante1().setApellido(txtApellido.getText());
             estudianteControl.getEstudiante1().setEdad(txtEdad.getText());
              estudianteControl.getEstudiante1().setCorreo(txtCorreo.getText());
            estudianteControl.getEstudiante1().setPromedioAcademico(txtPeriodo.getText());     
        if (estudianteControl.persist()) {
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
    //}
}
     private void cargarVista(){
         int fila=tblMostrar.getSelectedRow();
         if(fila<0){
             JOptionPane.showMessageDialog(null, "Escoja un registro de la tabla");
         }else{
             try {
                 estudianteControl.setEstudiante1(mta.getEstudianteTabla().getInfo(fila));
                 txtNombre.setText(estudianteControl.getEstudiante1().getNombre());
                 txtApellido.setText(estudianteControl.getEstudiante1().getApellido());
                 txtEdad.setText(estudianteControl.getEstudiante1().getEdad());
                 txtCedula.setText(estudianteControl.getEstudiante1().getCedula());
                 txtCorreo.setText(estudianteControl.getEstudiante1().getCorreo());
                 txtPeriodo.setText(estudianteControl.getEstudiante1().getPromedioAcademico());
                 
                 
                 
             } catch (Exception e) {
                 System.out.println("Error seleccione una fila primero");
             }
             
         }
     }
     private void ordenar(){
        String criterio = cbxCriterio1.getSelectedItem().toString().toLowerCase();
        Integer tipo=0;
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
     private void buscar(){
        String texto = txtBuscar.getText();
        String criterio= cbxCriterio1.getSelectedItem().toString();
        if(cbxMetodo1.getSelectedItem().toString()=="Busqueda_Binaria"){
        try {
            System.out.println("Busqueda_Binaria");
            mta.setEstudianteTabla(estudianteControl.all());
            mta.setEstudianteTabla(estudianteControl.busquedaBinaria(texto, mta.getEstudianteTabla(), criterio));
            tblMostrar.setModel(mta);
            tblMostrar.updateUI();
        } catch (Exception e) {
       JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        } else if(cbxMetodo1.getSelectedItem().toString()=="Busqueda_Lineal"){
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
        jPanel1 = new javax.swing.JPanel();
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
        jButton1 = new javax.swing.JButton();

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

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("REGISTRO DEL ESTUDIANTE");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Promedio Académico:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 170, -1));

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Apellido:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Edad:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Cedula:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 400, -1));
        jPanel1.add(txtPeriodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, 410, -1));
        jPanel1.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 400, -1));

        txtEdad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEdadActionPerformed(evt);
            }
        });
        jPanel1.add(txtEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 410, -1));
        jPanel1.add(txtCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 410, -1));

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Correo:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));
        jPanel1.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 410, -1));

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
        jScrollPane2.setViewportView(tblMostrar);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 680, 150));

        btnGuardar.setBackground(new java.awt.Color(0, 0, 51));
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("GUARDAR DATOS");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, -1, -1));

        btnSeleccionar.setBackground(new java.awt.Color(0, 0, 51));
        btnSeleccionar.setForeground(new java.awt.Color(255, 255, 255));
        btnSeleccionar.setText("SELECCIONAR DATOS");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });
        jPanel1.add(btnSeleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, 160, -1));

        btnModificar.setBackground(new java.awt.Color(0, 0, 51));
        btnModificar.setForeground(new java.awt.Color(255, 255, 255));
        btnModificar.setText("MODIFICAR DATOS");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 350, 160, -1));

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Ordenar:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 560, -1, -1));

        cbxCriterio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "nombre", "apellido", "cedula", "edad", "correo", "promedioAcademico" }));
        jPanel1.add(cbxCriterio, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 600, -1, -1));

        cbxMetodo.setText("DESCENDENTE");
        jPanel1.add(cbxMetodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 560, -1, -1));

        btnOrdenar.setBackground(new java.awt.Color(0, 0, 51));
        btnOrdenar.setForeground(new java.awt.Color(255, 255, 255));
        btnOrdenar.setText("ORDENAR");
        btnOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenarActionPerformed(evt);
            }
        });
        jPanel1.add(btnOrdenar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 560, 120, -1));

        jLabel9.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Buscar:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 600, -1, -1));

        cbxCriterio1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "nombre", "apellido", "cedula", "edad", "correo", "promedioAcademico" }));
        jPanel1.add(cbxCriterio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 560, -1, -1));

        cbxMetodo1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Busqueda_Lineal", "Busqueda_Binaria" }));
        jPanel1.add(cbxMetodo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 600, 130, -1));
        jPanel1.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 600, 140, -1));

        btnBuscar.setBackground(new java.awt.Color(0, 0, 51));
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 600, 90, -1));

        jButton1.setText("IR ATRAS");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 350, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 655));

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
            estudianteControl.getEstudiante1().setCedula(txtCedula.getText());
            estudianteControl.getEstudiante1().setNombre(txtNombre.getText());
            estudianteControl.getEstudiante1().setApellido(txtApellido.getText());
             estudianteControl.getEstudiante1().setEdad(txtEdad.getText());
              estudianteControl.getEstudiante1().setCorreo(txtCorreo.getText());
            estudianteControl.getEstudiante1().setPromedioAcademico(txtPeriodo.getText());     
        if (estudianteControl.marge(estudianteControl.getEstudiante1(), tblMostrar.getSelectedRow())) {
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Menu m1=new Menu();
        m1.setVisible(true);
        this.dispose();
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tblMostrar;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPeriodo;
    // End of variables declaration//GEN-END:variables
}
