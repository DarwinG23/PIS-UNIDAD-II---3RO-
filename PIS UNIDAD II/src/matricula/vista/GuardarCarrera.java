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
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import matricula.controlador.CarreraControl;
import matricula.controlador.MallaControl;
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
                && !txtAnios.getText().trim().isEmpty());
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
            //carreraControl.getCarrera().getMallas().add(UtilVistaMalla.obtenerCarrera(cbxMalla));
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
        cargarTabla();
        carreraControl.setCarrera(null);
    }

    public GuardarCarrera() throws EmptyException {
        initComponents();
        this.setLocationRelativeTo(null);
        //UtilVistaMalla.cargarcomboCarrera(cbxMalla);
        pnlAzul.setIcon(new ImageIcon("fotos/Azul.jpg"));
        pnlGris.setIcon(new ImageIcon("fotos/Gris.jpg"));
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

        pnlAzul = new org.edisoncor.gui.panel.PanelImage();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtAnios = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        btnGuardar = new javax.swing.JButton();
        btnAgregarMalla = new javax.swing.JButton();
        brnMostrarMallas = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        pnlGris = new org.edisoncor.gui.panel.PanelImage();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbCarrera = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        cbxCriterio = new javax.swing.JComboBox<>();
        cbxMetodo1 = new javax.swing.JComboBox<>();
        btnOrdenar = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        btnOrden1 = new javax.swing.JCheckBox();
        btnBuscar1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbMallas = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        cbxCriterio1 = new javax.swing.JComboBox<>();
        btnOrden = new javax.swing.JCheckBox();
        cbxMetodo2 = new javax.swing.JComboBox<>();
        btnOrdenar1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtBuscar1 = new javax.swing.JTextField();
        btnBuscar2 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        btnAdmMalla = new javax.swing.JMenuItem();
        btnAdmFacultad = new javax.swing.JMenuItem();
        btnAdmCiclo = new javax.swing.JMenuItem();
        btnAdmCursa = new javax.swing.JMenuItem();
        btnAdmMatricula = new javax.swing.JMenuItem();
        btnAdmPerido = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlAzul.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre:");
        pnlAzul.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Duracion Años:");
        pnlAzul.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        txtNombre.setBackground(new java.awt.Color(255, 255, 255));
        txtNombre.setForeground(new java.awt.Color(0, 0, 0));
        pnlAzul.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 258, -1));

        txtAnios.setBackground(new java.awt.Color(255, 255, 255));
        txtAnios.setForeground(new java.awt.Color(0, 0, 0));
        txtAnios.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAniosKeyTyped(evt);
            }
        });
        pnlAzul.add(txtAnios, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 260, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Descripcion:");
        pnlAzul.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

        txtDescripcion.setBackground(new java.awt.Color(255, 255, 255));
        txtDescripcion.setColumns(20);
        txtDescripcion.setForeground(new java.awt.Color(0, 0, 0));
        txtDescripcion.setRows(5);
        jScrollPane1.setViewportView(txtDescripcion);

        pnlAzul.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, 258, 109));

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        pnlAzul.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 540, -1, -1));

        btnAgregarMalla.setText("Agregar Malla");
        btnAgregarMalla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarMallaActionPerformed(evt);
            }
        });
        pnlAzul.add(btnAgregarMalla, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 540, 130, -1));

        brnMostrarMallas.setText("Ver Mallas");
        brnMostrarMallas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brnMostrarMallasActionPerformed(evt);
            }
        });
        pnlAzul.add(brnMostrarMallas, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 540, 100, -1));

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        pnlAzul.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 540, 100, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("CARRERA");
        pnlAzul.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, -1, -1));

        getContentPane().add(pnlAzul, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 600));

        pnlGris.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        pnlGris.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 580, 88));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 51));
        jLabel10.setText("Criterio:");
        pnlGris.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));

        cbxCriterio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "nombre", "descripcion", "duracionAnios", "numCiclos" }));
        pnlGris.add(cbxCriterio, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 100, -1));

        cbxMetodo1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Busqueda_Lineal", "Busqueda_Binaria" }));
        pnlGris.add(cbxMetodo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 100, -1));

        btnOrdenar.setText("Ordenar");
        btnOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenarActionPerformed(evt);
            }
        });
        pnlGris.add(btnOrdenar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, -1, -1));
        pnlGris.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 70, 120, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 51));
        jLabel11.setText("Texto:");
        pnlGris.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, -1, -1));

        btnOrden1.setText("Ascendente");
        pnlGris.add(btnOrden1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, -1, -1));

        btnBuscar1.setText("Buscar");
        btnBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar1ActionPerformed(evt);
            }
        });
        pnlGris.add(btnBuscar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));

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

        pnlGris.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 580, 90));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 51));
        jLabel9.setText("Criterio:");
        pnlGris.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, -1, -1));

        cbxCriterio1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "nombre", "descripcion", "duracionAnios", "numCiclos" }));
        pnlGris.add(cbxCriterio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 290, 100, -1));

        btnOrden.setText("Ascendente");
        btnOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenActionPerformed(evt);
            }
        });
        pnlGris.add(btnOrden, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 290, -1, -1));

        cbxMetodo2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Busqueda_Lineal", "Busqueda_Binaria" }));
        pnlGris.add(cbxMetodo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 290, 100, -1));

        btnOrdenar1.setText("Ordenar");
        pnlGris.add(btnOrdenar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 430, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 51));
        jLabel7.setText("Texto:");
        pnlGris.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 300, -1, -1));
        pnlGris.add(txtBuscar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 290, 120, -1));

        btnBuscar2.setText("Buscar");
        pnlGris.add(btnBuscar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, -1, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("MALLAS");
        pnlGris.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 230, -1, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("CARRERAS");
        pnlGris.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, -1, -1));

        getContentPane().add(pnlGris, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 0, 640, 600));

        jMenu1.setText("Administración");

        btnAdmMalla.setText("Malla");
        btnAdmMalla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdmMallaActionPerformed(evt);
            }
        });
        jMenu1.add(btnAdmMalla);

        btnAdmFacultad.setText("Facultad");
        btnAdmFacultad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdmFacultadActionPerformed(evt);
            }
        });
        jMenu1.add(btnAdmFacultad);

        btnAdmCiclo.setText("Ciclo");
        btnAdmCiclo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdmCicloActionPerformed(evt);
            }
        });
        jMenu1.add(btnAdmCiclo);

        btnAdmCursa.setText("Cursa");
        btnAdmCursa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdmCursaActionPerformed(evt);
            }
        });
        jMenu1.add(btnAdmCursa);

        btnAdmMatricula.setText("Matricula");
        btnAdmMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdmMatriculaActionPerformed(evt);
            }
        });
        jMenu1.add(btnAdmMatricula);

        btnAdmPerido.setText("Perido Académico");
        btnAdmPerido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdmPeridoActionPerformed(evt);
            }
        });
        jMenu1.add(btnAdmPerido);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents
        
    private void btnOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenarActionPerformed
        ordenar();
    }//GEN-LAST:event_btnOrdenarActionPerformed

    private void btnOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnOrdenActionPerformed

    private void btnBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar1ActionPerformed
        buscar();
    }//GEN-LAST:event_btnBuscar1ActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        this.dispose();
        try {
            new GuardarCarrera().setVisible(true);
        } catch (EmptyException ex) {
            Logger.getLogger(GuardarCarrera.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

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
            JOptionPane.showConfirmDialog(null, "No ha seleccionado una carrera de la tabla carreras", "ADVERTENCIA", JOptionPane.OK_CANCEL_OPTION);
    }//GEN-LAST:event_brnMostrarMallasActionPerformed
    }
    private void btnAgregarMallaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarMallaActionPerformed
        int filaSeleccionada = tbCarrera.getSelectedRow();
        if (filaSeleccionada != -1) {
            try {
                new AgregarMalla(filaSeleccionada).setVisible(true);
            } catch (Exception ex) {
                int i = JOptionPane.showConfirmDialog(null, "No hay mallas para agregar \n ¿Desea crearla?", "ADVERTENCIA", JOptionPane.OK_CANCEL_OPTION);
                if (i == JOptionPane.OK_OPTION) {
                    try {
                        new GuardarMalla().setVisible(true);
                        this.dispose();
                    } catch (EmptyException ex1) {
                        JOptionPane.showConfirmDialog(null, "Hubo un problema al intentar crear la malla :c");
                    }
                }
            }
            cargarTabla();
        } else {
            JOptionPane.showConfirmDialog(null, "No ha seleccionado una carrera de la tabla carreras", "ADVERTENCIA", JOptionPane.OK_CANCEL_OPTION);
    }//GEN-LAST:event_btnAgregarMallaActionPerformed
    }
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            guardar();
        } catch (EmptyException ex) {
            Logger.getLogger(GuardarCarrera.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtAniosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAniosKeyTyped
        char tecla = evt.getKeyChar();
        if((tecla > '<' || tecla > '9') && tecla != KeyEvent.VK_BACK_SPACE){
            evt.consume();
        }
    }//GEN-LAST:event_txtAniosKeyTyped

    private void btnAdmMallaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdmMallaActionPerformed
        try {
            new GuardarMalla().setVisible(true);
            this.dispose();
        } catch (EmptyException ex) {
            Logger.getLogger(GuardarFacultad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAdmMallaActionPerformed

    private void btnAdmFacultadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdmFacultadActionPerformed
         try {
            new GuardarFacultad().setVisible(true);
            this.dispose();
        } catch (EmptyException ex) {
            Logger.getLogger(GuardarFacultad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAdmFacultadActionPerformed

    private void btnAdmCicloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdmCicloActionPerformed
        try {
            new GuardarCiclo().setVisible(true);
            this.dispose();
        } catch (EmptyException ex) {
            Logger.getLogger(GuardarFacultad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAdmCicloActionPerformed

    private void btnAdmCursaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdmCursaActionPerformed
        new GuardarCursa().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAdmCursaActionPerformed

    private void btnAdmMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdmMatriculaActionPerformed
        try {
            new GuardarMatricula().setVisible(true);
            this.dispose();
        } catch (Exception ex) {
            Logger.getLogger(GuardarCarrera.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAdmMatriculaActionPerformed

    private void btnAdmPeridoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdmPeridoActionPerformed
        new GuardarPeriodoAcademico().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAdmPeridoActionPerformed

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
    private javax.swing.JMenuItem btnAdmCiclo;
    private javax.swing.JMenuItem btnAdmCursa;
    private javax.swing.JMenuItem btnAdmFacultad;
    private javax.swing.JMenuItem btnAdmMalla;
    private javax.swing.JMenuItem btnAdmMatricula;
    private javax.swing.JMenuItem btnAdmPerido;
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
    private javax.swing.JComboBox<String> cbxMetodo1;
    private javax.swing.JComboBox<String> cbxMetodo2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private org.edisoncor.gui.panel.PanelImage pnlAzul;
    private org.edisoncor.gui.panel.PanelImage pnlGris;
    private javax.swing.JTable tbCarrera;
    private javax.swing.JTable tbMallas;
    private javax.swing.JTextField txtAnios;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtBuscar1;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
