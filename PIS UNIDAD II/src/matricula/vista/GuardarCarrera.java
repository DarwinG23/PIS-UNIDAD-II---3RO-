/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package matricula.vista;

import lista.DynamicList;
import exeption.EmptyException;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import matricula.controlador.CarreraControl;
import matricula.vista.tabla.ModeloTablaCarrera;
import matricula.vista.tabla.ModeloTablaMalla;
import matricula.vista.util.UtilVistaMalla;
import usuarios.vista.Inicio;

/**
 *
 * @author darwi
 */
public class GuardarCarrera extends javax.swing.JFrame {
    private ModeloTablaCarrera mtc = new ModeloTablaCarrera();
    private ModeloTablaMalla mtm = new  ModeloTablaMalla();
    private CarreraControl carreraControl = new CarreraControl();

    public void cargarFacultades(DynamicList carreras) {
        mtc.setCarreras(carreras);
        initComponents();
    }

    public Boolean verificar() {
        return (!txtDescripcion.getText().trim().isEmpty()
                && !txtNombre.getText().trim().isEmpty()
                && !txtDescripcion.getText().trim().isEmpty()
                && !txtAnios.getText().trim().isEmpty()
                && !txtCiclos.getText().trim().isEmpty());
    }
    
    private void cargarTabla(){
        mtc.setCarreras(carreraControl.getListCarrera());
        tbCarrera.setModel(mtc);
        tbCarrera.updateUI();
        tbMallas.setModel(mtm);
        tbMallas.updateUI();
    }
    
    private void guardar() throws EmptyException{
        if (verificar()) {
            carreraControl.getCarrera().setDescripcion(txtDescripcion.getText());
            carreraControl.getCarrera().setNombre(txtNombre.getText());
            carreraControl.getCarrera().setDuracionAnios(Integer.parseInt(txtAnios.getText()));
            carreraControl.getCarrera().setNumCiclos(Integer.parseInt(txtCiclos.getText()));
            carreraControl.getCarrera().getMallas().add(UtilVistaMalla.obtenerCarrera(cbxMalla));
            if (carreraControl.persist()) {
                JOptionPane.showMessageDialog(null, "Datos guardados");
                cargarTabla();
                limpiar();
                carreraControl.setCarrera(null);
            }else{
                JOptionPane.showMessageDialog(null, "No se pudo guardar, hubo un error");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Falta llenar campos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void limpiar(){
        txtNombre.setText("");
        txtDescripcion.setText(" ");
        txtAnios.setText("");
        txtCiclos.setText(" ");
        cargarTabla();
        carreraControl.setCarrera(null);
    }

    public GuardarCarrera() throws EmptyException {
        initComponents();
        this.setLocationRelativeTo(null);
        UtilVistaMalla.cargarcomboCarrera(cbxMalla);
        cargarTabla();
    }
     private void ordenar(){
        String criterio = cbxCriterio.getSelectedItem().toString().toLowerCase();
        Integer tipo=0;
        if (btnOrden1.isSelected()) {
            tipo = 1;
        } 
        try {
            mtc.setCarreras(carreraControl.ordenarQuickSort(carreraControl.all(), tipo, criterio));
             tbCarrera.setModel(mtc);
            tbCarrera.updateUI();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    
    }
     private void buscar(){
        String texto = txtBuscar.getText();
        String criterio= cbxCriterio.getSelectedItem().toString();
        if(cbxMetodo1.getSelectedItem().toString()=="Busqueda_Binaria"){
        try {
            System.out.println("Busqueda_Binaria");
            mtc.setCarreras(carreraControl.all());
            mtc.setCarreras(carreraControl.busquedaBinaria(texto, mtc.getCarreras(), criterio));
            tbCarrera.setModel(mtc);
            tbCarrera.updateUI();
        } catch (Exception e) {
       JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        } else if(cbxMetodo1.getSelectedItem().toString()=="Busqueda_Lineal"){
           try {
            System.out.println("Busqueda_Lineal");
            mtc.setCarreras(carreraControl.all());
            mtc.setCarreras(carreraControl.buscarPorCriterioLineal(texto, mtc.getCarreras(), criterio));
            tbCarrera.setModel(mtc);
            tbCarrera.updateUI();
        } catch (Exception e) {
       JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }     
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtAnios = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCiclos = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbCarrera = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbMallas = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        cbxCriterio1 = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtBuscar1 = new javax.swing.JTextField();
        btnOrdenar1 = new javax.swing.JButton();
        btnBuscar2 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        cbxCriterio = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnOrdenar = new javax.swing.JButton();
        btnBuscar1 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        cbxMalla = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        btnAgregarMalla = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        brnMostrarMallas = new javax.swing.JButton();
        cbxMetodo1 = new javax.swing.JComboBox<>();
        cbxMetodo2 = new javax.swing.JComboBox<>();
        btnOrden = new javax.swing.JCheckBox();
        btnOrden1 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("CARRERA");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Duracion Años:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, -1, -1));

        txtNombre.setBackground(new java.awt.Color(255, 255, 255));
        txtNombre.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(362, 53, 258, -1));

        txtAnios.setBackground(new java.awt.Color(255, 255, 255));
        txtAnios.setForeground(new java.awt.Color(0, 0, 0));
        txtAnios.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAniosKeyTyped(evt);
            }
        });
        jPanel1.add(txtAnios, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 100, 260, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Malla:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, -1, -1));

        txtCiclos.setBackground(new java.awt.Color(255, 255, 255));
        txtCiclos.setForeground(new java.awt.Color(0, 0, 0));
        txtCiclos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCiclosKeyTyped(evt);
            }
        });
        jPanel1.add(txtCiclos, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 160, 260, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tabla de mallas:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 240, -1, -1));

        txtDescripcion.setBackground(new java.awt.Color(255, 255, 255));
        txtDescripcion.setColumns(20);
        txtDescripcion.setForeground(new java.awt.Color(0, 0, 0));
        txtDescripcion.setRows(5);
        jScrollPane1.setViewportView(txtDescripcion);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 280, 258, 109));

        tbCarrera.setBackground(new java.awt.Color(255, 255, 255));
        tbCarrera.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tbCarrera);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 140, 540, 88));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jButton1.setText("INICIO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(303, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(205, 205, 205))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 540));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Descripcion:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Texto:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 270, -1, -1));

        tbMallas.setBackground(new java.awt.Color(255, 255, 255));
        tbMallas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tbMallas);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 330, 540, 88));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Tabla de carreras:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 50, -1, -1));

        cbxCriterio1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "nombre", "descripcion", "duracionAnios", "numCiclos" }));
        jPanel1.add(cbxCriterio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 270, 100, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Criterio:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 270, -1, -1));
        jPanel1.add(txtBuscar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 270, 120, -1));

        btnOrdenar1.setText("Ordenar");
        jPanel1.add(btnOrdenar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 300, -1, -1));

        btnBuscar2.setText("Buscar");
        jPanel1.add(btnBuscar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 270, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Criterio:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 80, -1, -1));

        cbxCriterio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "nombre", "descripcion", "duracionAnios", "numCiclos" }));
        jPanel1.add(cbxCriterio, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 80, 100, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Texto:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 80, -1, -1));
        jPanel1.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 80, 120, -1));

        btnOrdenar.setText("Ordenar");
        btnOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenarActionPerformed(evt);
            }
        });
        jPanel1.add(btnOrdenar, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 110, -1, -1));

        btnBuscar1.setText("Buscar");
        btnBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 80, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Total Ciclos:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, -1, -1));

        cbxMalla.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cbxMalla, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 220, 260, -1));

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 450, -1, -1));

        btnAgregarMalla.setText("Agregar malla");
        btnAgregarMalla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarMallaActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregarMalla, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 450, -1, -1));

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 450, -1, -1));

        brnMostrarMallas.setText("Mostrar Mallas");
        brnMostrarMallas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brnMostrarMallasActionPerformed(evt);
            }
        });
        jPanel1.add(brnMostrarMallas, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 450, 100, -1));

        cbxMetodo1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Busqueda_Lineal", "Busqueda_Binaria" }));
        jPanel1.add(cbxMetodo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 80, 100, -1));

        cbxMetodo2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Busqueda_Lineal", "Busqueda_Binaria" }));
        jPanel1.add(cbxMetodo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 270, 100, -1));

        btnOrden.setText("Ascendente");
        btnOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenActionPerformed(evt);
            }
        });
        jPanel1.add(btnOrden, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 300, -1, -1));

        btnOrden1.setText("Ascendente");
        jPanel1.add(btnOrden1, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 110, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtAniosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAniosKeyTyped
        char tecla = evt.getKeyChar();
        if((tecla > '<' || tecla > '9') && tecla != KeyEvent.VK_BACK_SPACE){
            evt.consume();     
        }
    }//GEN-LAST:event_txtAniosKeyTyped

    private void txtCiclosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCiclosKeyTyped
        char tecla = evt.getKeyChar();
        if((tecla > '<' || tecla > '9') && tecla != KeyEvent.VK_BACK_SPACE){
            evt.consume();            
        }
    }//GEN-LAST:event_txtCiclosKeyTyped
    
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            guardar();
        } catch (EmptyException ex) {
            Logger.getLogger(GuardarCarrera.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        this.dispose();
        try {
            new GuardarCarrera().setVisible(true);
        } catch (EmptyException ex) {
            Logger.getLogger(GuardarCarrera.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnAgregarMallaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarMallaActionPerformed
        int filaSeleccionada = tbCarrera.getSelectedRow();
        if (filaSeleccionada != -1) {
            try {
                new AgregarMalla(filaSeleccionada).setVisible(true);
            } catch (Exception ex) {
                Logger.getLogger(GuardarCiclo.class.getName()).log(Level.SEVERE, null, ex);
            }
            cargarTabla();
        } else {
            JOptionPane.showMessageDialog(null, "No ha seleccionado ningun ciclo", "Error", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_btnAgregarMallaActionPerformed
    }
    private void brnMostrarMallasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brnMostrarMallasActionPerformed
        int filaSeleccionada = tbCarrera.getSelectedRow();
        if (filaSeleccionada != -1) {
            try {
                mtm.setMallas(carreraControl.getListCarrera().getInfo(filaSeleccionada).getMallas());
                tbMallas.setModel(mtm);
                tbMallas.updateUI();
            } catch (EmptyException ex) {
                Logger.getLogger(GuardarCiclo.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No ha seleccionado ningun ciclo", "Error", JOptionPane.ERROR_MESSAGE);}
    }//GEN-LAST:event_brnMostrarMallasActionPerformed

    private void btnOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenarActionPerformed
        ordenar();
    }//GEN-LAST:event_btnOrdenarActionPerformed

    private void btnOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnOrdenActionPerformed

    private void btnBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar1ActionPerformed
        buscar();
    }//GEN-LAST:event_btnBuscar1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Inicio n1=new Inicio();
        n1.setVisible(true);
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
            java.util.logging.Logger.getLogger(GuardarCarrera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GuardarCarrera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GuardarCarrera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GuardarCarrera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new GuardarCarrera().setVisible(true);
                } catch (EmptyException ex) {
                    Logger.getLogger(GuardarCarrera.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton brnMostrarMallas;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregarMalla;
    private javax.swing.JButton btnBuscar1;
    private javax.swing.JButton btnBuscar2;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JCheckBox btnOrden;
    private javax.swing.JCheckBox btnOrden1;
    private javax.swing.JButton btnOrdenar;
    private javax.swing.JButton btnOrdenar1;
    private javax.swing.JComboBox<String> cbxCriterio;
    private javax.swing.JComboBox<String> cbxCriterio1;
    private javax.swing.JComboBox<String> cbxMalla;
    private javax.swing.JComboBox<String> cbxMetodo1;
    private javax.swing.JComboBox<String> cbxMetodo2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tbCarrera;
    private javax.swing.JTable tbMallas;
    private javax.swing.JTextField txtAnios;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtBuscar1;
    private javax.swing.JTextField txtCiclos;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
