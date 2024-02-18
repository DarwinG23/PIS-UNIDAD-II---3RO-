/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package materias.vista;

import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import materias.controlador.registros.MateriaControl1;
import materias.vista.Tabla.ModeloTablaMateria;


/**
 *
 * @author Elías
 */
public class materia extends javax.swing.JFrame {
     private MateriaControl1 materiaControl = new MateriaControl1();
    private ModeloTablaMateria mta = new ModeloTablaMateria();
    /**
     * Creates new form materia
     */
    public materia() {
        initComponents();
        this.setLocationRelativeTo(null);
        Limpiar();
    }
    private void ordenar(){
        String criterio = cbxCriterio1.getSelectedItem().toString();
        Integer tipo = 0;
        if (btnOrden.isSelected()) {
            tipo = 1;
        }
        try {
            mta.setMaterias(materiaControl.ordenarQuickSort(materiaControl.all(), tipo, criterio));
            tblMostrar.setModel(mta);
            tblMostrar.updateUI();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
       
    }
    private void buscar(){
        String texto = txtBuscar.getText();
        String criterio= cbxCriterio2.getSelectedItem().toString();
        if(cbxMetodo.getSelectedItem().toString()=="Busqueda Binario"){
        try {
            System.out.println("Busqueda_Binario");
            mta.setMaterias(materiaControl.all());
            mta.setMaterias(materiaControl.busquedaBinaria(texto, mta.getMaterias(), criterio));
            tblMostrar.setModel(mta);
            tblMostrar.updateUI();
        } catch (Exception e) {
       JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        } else if(cbxMetodo.getSelectedItem().toString()=="Busqueda Lineal"){
           try {
            System.out.println("Busqueda_Lineal");
            mta.setMaterias(materiaControl.all());
            mta.setMaterias(materiaControl.buscarPorCriterioLineal(texto, mta.getMaterias(), criterio));
            tblMostrar.setModel(mta);
            tblMostrar.updateUI();
        } catch (Exception e) {
       JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }     
        }
    }

    private void CargarTabla() {
        mta.setMaterias(materiaControl.getMaterias());
        tblMostrar.setModel((TableModel) mta);
        tblMostrar.updateUI();
    }

    private void Limpiar() {

        txtIdMa.setEnabled(true);
        tblMostrar.clearSelection();
        txtNameMateria.setText(" ");
        txtParalelo.setText(" ");
        txtFecha.setText(" ");
        txtIdMa.setText(" ");
        txtCiclo.setText(" ");
        CargarTabla();
        materiaControl.setMateria(null);

    }

    private Boolean Validar() {
        return (!txtIdMa.getText().trim().isEmpty()
                && !txtCiclo.getText().trim().isEmpty()
                && !txtNameMateria.getText().trim().isEmpty()
                && !txtFecha.getText().trim().isEmpty()
                && !txtParalelo.getText().trim().isEmpty());
    }

    private void Guardar() {
        if (Validar()) {

            materiaControl.getMateria().setNombre(txtNameMateria.getText());
            materiaControl.getMateria().setId_Materia(txtIdMa.getText());
             materiaControl.getMateria().setCiclo(txtCiclo.getText());
            materiaControl.getMateria().setParalelo(txtParalelo.getText());
            materiaControl.getMateria().setFecha(txtFecha.getText());
            if (materiaControl.persit()) {
                JOptionPane.showMessageDialog(null, "Datos guardados con exito");
                materiaControl.setMateria(null);
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

    private void cargarVista() {
        int fila = tblMostrar.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(null, "Escoja un registro de la tabla");
        } else {
            try {
                materiaControl.setMateria(mta.getMaterias().getInfo(fila));
                txtNameMateria.setText(materiaControl.getMateria().getNombre());
                 txtCiclo.setText(materiaControl.getMateria().getCiclo());
                txtIdMa.setText(materiaControl.getMateria().getId_Materia());
                txtParalelo.setText(materiaControl.getMateria().getParalelo());
                txtFecha.setText(materiaControl.getMateria().getFecha());
            } catch (Exception e) {
            }

        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNameMateria = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtIdMa = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCiclo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtParalelo = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblMostrar = new javax.swing.JTable();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        jLabel6 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnSelect = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        cbxMetodo = new javax.swing.JComboBox<>();
        btnOrden = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        cbxCriterio1 = new javax.swing.JComboBox<>();
        cbxCriterio2 = new javax.swing.JComboBox<>();
        txtBuscar = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

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

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.setForeground(new java.awt.Color(255, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnGuardar.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        btnGuardar.setText("GUARDAR MATERIA");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, -1, -1));

        jLabel1.setFont(new java.awt.Font("Dialog", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setText("REGISTRO DE MATERIAS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setText("CICLO:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));
        jPanel1.add(txtNameMateria, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, 270, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 153));
        jLabel3.setText("NOMBRE DE LA MATERIA:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        txtIdMa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdMaKeyTyped(evt);
            }
        });
        jPanel1.add(txtIdMa, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 140, 270, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 153));
        jLabel4.setText("INGRESAR FECHA DE CREACIÓN");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 60, -1, -1));
        jPanel1.add(txtCiclo, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 220, 270, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 153));
        jLabel5.setText("ID MATERIA:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));
        jPanel1.add(txtParalelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 290, 270, -1));

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

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 420, 500, 150));

        jCalendar1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jCalendar1PropertyChange(evt);
            }
        });
        jPanel1.add(jCalendar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 100, -1, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 153));
        jLabel6.setText("BUSCAR:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 380, -1, -1));
        jPanel1.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 320, 270, -1));

        jLabel7.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 102));
        jLabel7.setText("¿DESEA MODIFICAR UN DATO?");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 420, -1, -1));

        btnSelect.setText("SELECCIONAR FILA");
        btnSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectActionPerformed(evt);
            }
        });
        jPanel1.add(btnSelect, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 450, -1, -1));

        btnModificar.setText("MODIFICAR DATO");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 490, 150, -1));

        jLabel8.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 153));
        jLabel8.setText("PARALELO:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));

        cbxMetodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Busqueda Binario", "Busqueda Lineal" }));
        jPanel1.add(cbxMetodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 380, -1, -1));

        btnOrden.setText("Descendente");
        jPanel1.add(btnOrden, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 340, -1, -1));

        jButton1.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jButton1.setText("ORDENAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 340, 90, 20));

        jLabel9.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 153, 153));
        jLabel9.setText("ORDENAR:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 340, -1, -1));

        cbxCriterio1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "nombre", "paralelo", "ciclo", "id_materia", "fecha" }));
        jPanel1.add(cbxCriterio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 340, -1, -1));

        cbxCriterio2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "nombre", "paralelo", "ciclo", "id_materia", "fecha" }));
        jPanel1.add(cbxCriterio2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 380, -1, -1));
        jPanel1.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 380, 70, -1));

        jButton2.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jButton2.setText("BUSCAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 380, -1, -1));

        jButton3.setText("INICIO");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 540, 160, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 950, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        Guardar();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void jCalendar1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jCalendar1PropertyChange
        if(evt.getOldValue()!=null){
           SimpleDateFormat ft=new SimpleDateFormat("dd/MM/yyyy");
           txtFecha.setText(ft.format(jCalendar1.getCalendar().getTime()));
       }
    }//GEN-LAST:event_jCalendar1PropertyChange

    private void txtIdMaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdMaKeyTyped
        String textoActual = txtIdMa.getText();
        char caracterIngresado = evt.getKeyChar();
        if (Character.isLowerCase(caracterIngresado)) {
            txtIdMa.setText(textoActual.toUpperCase() + caracterIngresado);
            evt.consume();
        }
    }//GEN-LAST:event_txtIdMaKeyTyped

    private void btnSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectActionPerformed
        cargarVista();
    }//GEN-LAST:event_btnSelectActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (Validar()) {
            materiaControl.getMateria().setNombre(txtNameMateria.getText());
            materiaControl.getMateria().setId_Materia(txtIdMa.getText());
             materiaControl.getMateria().setCiclo(txtCiclo.getText());
            materiaControl.getMateria().setParalelo(txtParalelo.getText());
            materiaControl.getMateria().setFecha(txtFecha.getText());
            if (materiaControl.marge(materiaControl.getMateria(), tblMostrar.getSelectedRow())) {
                JOptionPane.showMessageDialog(null, "Datos guardados con exito");
                materiaControl.setMateria(null);
                CargarTabla();
                Limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo guardar");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Falta llenar campos ");

        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ordenar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        buscar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(materia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(materia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(materia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(materia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new materia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JCheckBox btnOrden;
    private javax.swing.JButton btnSelect;
    private javax.swing.JComboBox<String> cbxCriterio1;
    private javax.swing.JComboBox<String> cbxCriterio2;
    private javax.swing.JComboBox<String> cbxMetodo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private com.toedter.calendar.JCalendar jCalendar1;
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
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCiclo;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtIdMa;
    private javax.swing.JTextField txtNameMateria;
    private javax.swing.JTextField txtParalelo;
    // End of variables declaration//GEN-END:variables
}
