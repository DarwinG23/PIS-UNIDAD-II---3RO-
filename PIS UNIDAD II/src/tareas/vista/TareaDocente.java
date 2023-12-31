/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tareas.vista;

import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import tareas.controlador.controladorTarea.administrarTarea1;
import tareas.vista.modeloTabla.modeloTablaTarea;
import tareas.vista.utilVista.utilVistaEstadoTarea;
import tareas.vista.utilVista.utilVistaTipoTarea;


/**
 *
 * @author ALEJANDRO
 */
public class TareaDocente extends javax.swing.JFrame {
    private administrarTarea1 tareaControl = new administrarTarea1();
    private modeloTablaTarea mtp = new modeloTablaTarea();
    
    /**
     * Creates new form TareaDocente
     */
    public TareaDocente() {
        initComponents();
        this.setLocationRelativeTo(null);
        Limpiar();
    }
    private void CargarTabla() {
        mtp.setTarea(tareaControl.getTareas());
        cbxTipo.setSelectedIndex(0);
        cbxEstado.setSelectedIndex(-1);
        cbxTipo.setSelectedIndex(0);
        tblMostrar.setModel((TableModel) mtp);
        tblMostrar.updateUI();
    }
    private void Limpiar() {
        try {
            utilVistaEstadoTarea.CargarComboRolesL(cbxEstado);
            utilVistaTipoTarea.CargarComboRolesL(cbxTipo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        txtDescripcion.setEnabled(true);
        txtNota.setText(" ");
        txtDescripcion.setText(" ");
        txtTitulo.setText(" ");
        txtFechaInicio.setText(" ");
        txtFechaFInal.setText(" ");
        tblMostrar.clearSelection();
        CargarTabla();
        cbxEstado.setSelectedIndex(-1);//limpia combobo
        cbxTipo.setSelectedIndex(-1);//limpia combobo
        cbxTipo.setSelectedIndex(-1);
        tareaControl.setTarea1(null);
    }
    private Boolean Validar() {
        return (!txtDescripcion.getText().trim().isEmpty()
                && !txtNota.getText().trim().isEmpty()
                && !txtTitulo.getText().trim().isEmpty());
    }
    private void Guardar() {
        if (Validar()) {
            tareaControl.getTarea1().setDescripcion(txtDescripcion.getText());
            tareaControl.getTarea1().setId_tarea(utilVistaTipoTarea.ObtenerTipoTarea(cbxTipo));
            tareaControl.getTarea1().setId_estado(utilVistaEstadoTarea.ObtenerEstadoTarea(cbxEstado));
            tareaControl.getTarea1().setNota(Float.parseFloat(txtNota.getText()));
            tareaControl.getTarea1().setTituloTarea(txtTitulo.getText());
            tareaControl.getTarea1().setFechaInicio(txtFechaInicio.getText());
            tareaControl.getTarea1().setFechaFinal(txtFechaFInal.getText());
            if (tareaControl.persist()) {
                JOptionPane.showMessageDialog(null, "Datos guardados con exito");
                tareaControl.setTarea1(null);
                CargarTabla();
                Limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo guardar");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Falta llenar campos  ");

        }
    }
    private void cargarVista() {
        int fila = tblMostrar.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(null, "Escoja un registtro de la tabla");
        } else {
            try {
                tareaControl.setTarea1(mtp.getTarea().getInfo(fila));
                txtDescripcion.setText(tareaControl.getTarea1().getDescripcion());
                txtNota.setText(String.valueOf(tareaControl.getTarea1().getNota()));
                txtTitulo.setText(tareaControl.getTarea1().getTituloTarea());
                txtFechaInicio.setText(tareaControl.getTarea1().getFechaInicio());
                txtFechaFInal.setText(tareaControl.getTarea1().getFechaFinal());
                cbxEstado.setSelectedItem(tareaControl.getTarea1().getId_estado());
                cbxTipo.setSelectedItem(tareaControl.getTarea1().getId_tarea());
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbxTipo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cbxEstado = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtNota = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMostrar = new javax.swing.JTable();
        btnGuardar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        btnSeleccionar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtFechaInicio = new javax.swing.JTextField();
        txtFechaFInal = new javax.swing.JTextField();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        jCalendar2 = new com.toedter.calendar.JCalendar();
        jLabel10 = new javax.swing.JLabel();
        cbxEstudiante = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setForeground(new java.awt.Color(204, 255, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Ebrima", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 153));
        jLabel1.setText("TAREAS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, 155, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 0, 153));
        jLabel2.setText("TÍTULO TAREA:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        txtTitulo.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.add(txtTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 230, 50));

        jLabel3.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 0, 153));
        jLabel3.setText("TIPO TAREA:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        cbxTipo.setBackground(new java.awt.Color(204, 204, 255));
        cbxTipo.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        cbxTipo.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(cbxTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 144, 230, 40));

        jLabel4.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 0, 153));
        jLabel4.setText("DESCRIPCIÓN TAREA");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 200, 50));

        txtDescripcion.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 410, 70));

        jLabel5.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 0, 153));
        jLabel5.setText("ESTADO TAREA:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, -1, -1));

        cbxEstado.setBackground(new java.awt.Color(204, 204, 255));
        cbxEstado.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jPanel1.add(cbxEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 330, 220, 40));

        jLabel6.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 0, 153));
        jLabel6.setText("NOTA DE LA TAREA:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, -1, -1));

        txtNota.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.add(txtNota, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 400, 220, -1));

        tblMostrar.setBackground(new java.awt.Color(204, 255, 204));
        tblMostrar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tblMostrar.setForeground(new java.awt.Color(51, 153, 255));
        tblMostrar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ));
        jScrollPane1.setViewportView(tblMostrar);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 520, 580, 120));

        btnGuardar.setBackground(new java.awt.Color(255, 255, 255));
        btnGuardar.setForeground(new java.awt.Color(255, 153, 153));
        btnGuardar.setText("GUARDAR DATOS");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 490, -1, -1));

        jLabel7.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 0, 51));
        jLabel7.setText("¿DESEA CAMBIAR ALGUN DATO?");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 520, -1, -1));

        btnSeleccionar.setBackground(new java.awt.Color(255, 255, 255));
        btnSeleccionar.setForeground(new java.awt.Color(255, 153, 204));
        btnSeleccionar.setText("SELECCIONAR DATO");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });
        jPanel1.add(btnSeleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 550, -1, -1));

        btnModificar.setBackground(new java.awt.Color(255, 255, 255));
        btnModificar.setForeground(new java.awt.Color(255, 153, 204));
        btnModificar.setText("GUARDAR DATOS MDIFICADOS");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 590, -1, -1));

        jLabel8.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 0, 153));
        jLabel8.setText("FECHA INICIO:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, -1, -1));

        jLabel9.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 0, 153));
        jLabel9.setText("FECHA FINAL:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 290, -1, -1));
        jPanel1.add(txtFechaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 80, 200, -1));
        jPanel1.add(txtFechaFInal, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 290, 200, -1));

        jCalendar1.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jCalendar1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jCalendar1PropertyChange(evt);
            }
        });
        jPanel1.add(jCalendar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 320, 390, 160));

        jCalendar2.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jCalendar2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jCalendar2PropertyChange(evt);
            }
        });
        jPanel1.add(jCalendar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 110, 390, 160));

        jLabel10.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 0, 153));
        jLabel10.setText("Estudiante:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, -1, -1));

        jPanel1.add(cbxEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 450, 300, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 886, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        cargarVista();
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        Guardar();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (Validar()) {
            tareaControl.getTarea1().setDescripcion(txtDescripcion.getText());
            tareaControl.getTarea1().setId_tarea(utilVistaTipoTarea.ObtenerTipoTarea(cbxTipo));
            tareaControl.getTarea1().setId_estado(utilVistaEstadoTarea.ObtenerEstadoTarea(cbxEstado));
            tareaControl.getTarea1().setNota(Float.parseFloat(txtNota.getText()));
            tareaControl.getTarea1().setTituloTarea(txtTitulo.getText());
            tareaControl.getTarea1().setFechaInicio(txtFechaInicio.getText());
            tareaControl.getTarea1().setFechaFinal(txtFechaFInal.getText());
            if (tareaControl.marge(tareaControl.getTarea1(), tblMostrar.getSelectedRow())) {
                JOptionPane.showMessageDialog(null, "Datos guardados con exito");
                tareaControl.setTarea1(null);
                CargarTabla();
                Limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo guardar");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Falta llenar campos  ");

        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void jCalendar2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jCalendar2PropertyChange
        if(evt.getOldValue()!=null){
           SimpleDateFormat ft=new SimpleDateFormat("dd/MM/yyyy");
           txtFechaInicio.setText(ft.format(jCalendar2.getCalendar().getTime()));
       }
    }//GEN-LAST:event_jCalendar2PropertyChange

    private void jCalendar1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jCalendar1PropertyChange
       if(evt.getOldValue()!=null){
           SimpleDateFormat ft=new SimpleDateFormat("dd/MM/yyyy");
           txtFechaFInal.setText(ft.format(jCalendar1.getCalendar().getTime()));
       }
    }//GEN-LAST:event_jCalendar1PropertyChange

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
            java.util.logging.Logger.getLogger(TareaDocente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TareaDocente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TareaDocente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TareaDocente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TareaDocente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JComboBox<String> cbxEstado;
    private javax.swing.JComboBox<String> cbxEstudiante;
    private javax.swing.JComboBox<String> cbxTipo;
    private com.toedter.calendar.JCalendar jCalendar1;
    private com.toedter.calendar.JCalendar jCalendar2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JTable tblMostrar;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtFechaFInal;
    private javax.swing.JTextField txtFechaInicio;
    private javax.swing.JTextField txtNota;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
