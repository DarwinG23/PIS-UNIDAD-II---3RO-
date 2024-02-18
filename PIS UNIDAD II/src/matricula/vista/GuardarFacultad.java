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
import matricula.vista.tabla.ModeloTablaCarrera;
import matricula.vista.tabla.ModeloTablaFacultad;
import matricula.vista.util.UtilVistaCarrera;


/**
 *
 * @author darwi
 */
public class GuardarFacultad extends javax.swing.JFrame {

    private ModeloTablaFacultad mtc = new ModeloTablaFacultad();
    private ModeloTablaCarrera mtf = new ModeloTablaCarrera();
    private FacultadControl facultadControl = new FacultadControl();

    public void cargarFacultades(DynamicList carreras) {
        mtc.setFacultades(carreras);
        initComponents();
    }

    public Boolean verificar() {
        return (!txtDescripcion.getText().trim().isEmpty()
                && !txtNombre.getText().trim().isEmpty()
                && !txtDescripcion.getText().trim().isEmpty()
                && !txtNumBloques.getText().trim().isEmpty());
    }

    private void cargarTabla() {
        mtc.setFacultades(facultadControl.getListFacultades());
        tbCarrera.setModel(mtf);
        tbCarrera.updateUI();
        tbFacultad.setModel(mtc);
        tbFacultad.updateUI();
    }

    private void guardar() throws EmptyException {
        if (verificar()) {
            facultadControl.getFacultad().setDescripcion(txtDescripcion.getText());
            facultadControl.getFacultad().setNombre(txtNombre.getText());
            facultadControl.getFacultad().setNumBloques(Integer.parseInt(txtNumBloques.getText()));
            //facultadControl.getFacultad().getCarreras().add(UtilVistaCarrera.obtenerCarrera(cbxCarrera));
            facultadControl.getFacultad().getUbicacion().setLatitud(Double.parseDouble(txtLatitud.getText()));
            facultadControl.getFacultad().getUbicacion().setLongitud(Double.parseDouble(txtLongitud.getText()));
            facultadControl.getFacultad().setUbicacion(facultadControl.getFacultad().getUbicacion());
            if (facultadControl.persist()) {
                JOptionPane.showMessageDialog(null, "Datos guardados");
                cargarTabla();
                limpiar();
                facultadControl.setFacultad(null);
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo guardar, hubo un error");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Falta llenar campos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiar() {
        txtNombre.setText("");
        txtDescripcion.setText(" ");
        txtNumBloques.setText("");
        txtLatitud.setText("Latitud");
        txtLongitud.setText("Longitud ");
        cargarTabla();
        facultadControl.setFacultad(null);
    }

    public GuardarFacultad() throws EmptyException {
        initComponents();
        this.setLocationRelativeTo(null);
        //UtilVistaCarrera.cargarcomboCarrera(cbxCarrera);
        cargarTabla();
        pnlAzul.setIcon(new ImageIcon("fotos/Azul.png"));
        pnlGris.setIcon(new ImageIcon("fotos/Gris.jpg"));
        txtLatitud.setText("Latitud");
        txtLongitud.setText("Longitud ");
    }

    private void ordenar() {
        String criterio = cbxCriterio.getSelectedItem().toString().toLowerCase();
        Integer tipo = 0;
        if (btnOrden.isSelected()) {
            tipo = 1;
        }
        try {
            mtc.setFacultades(facultadControl.ordenarQuickSort(facultadControl.all(), tipo, criterio));
            tbFacultad.setModel(mtc);
            tbFacultad.updateUI();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void buscar() {
        String texto = txtBuscar.getText();
        String criterio = cbxCriterio.getSelectedItem().toString();
        if (cbxMetodo.getSelectedItem().toString() == "Busqueda_Binaria") {
            try {
                System.out.println("Busqueda_Binaria");
                mtc.setFacultades(facultadControl.all());
                mtc.setFacultades(facultadControl.busquedaBinaria(texto, mtc.getFacultades(), criterio));
                tbFacultad.setModel(mtc);
                tbFacultad.updateUI();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } else if (cbxMetodo.getSelectedItem().toString() == "Busqueda_Lineal") {
            try {
                System.out.println("Busqueda_Lineal");
                mtc.setFacultades(facultadControl.all());
                mtc.setFacultades(facultadControl.buscarPorCriterioLineal(texto, mtc.getFacultades(), criterio));
                tbFacultad.setModel(mtc);
                tbFacultad.updateUI();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlAzul = new org.edisoncor.gui.panel.PanelImage();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnMostrarCarrera = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        AgregarCarrera = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        txtNumBloques = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtLatitud = new javax.swing.JTextField();
        txtLongitud = new javax.swing.JTextField();
        pnlGris = new org.edisoncor.gui.panel.PanelImage();
        jLabel9 = new javax.swing.JLabel();
        btnOrden = new javax.swing.JCheckBox();
        txtBuscar = new javax.swing.JTextField();
        btnOrdenar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cbxCriterio = new javax.swing.JComboBox<>();
        cbxMetodo = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbFacultad = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbCarrera = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        btnAdmCarrera = new javax.swing.JMenuItem();
        btnAdmMalla = new javax.swing.JMenuItem();
        btnAdmCiclo = new javax.swing.JMenuItem();
        btnAdmCursa = new javax.swing.JMenuItem();
        btnAdmMatricula = new javax.swing.JMenuItem();
        btnAdmPeriodo = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        btnIncio = new javax.swing.JMenuItem();
        btnMatricula = new javax.swing.JMenuItem();
        btnSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlAzul.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Ubicación:");
        pnlAzul.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Descripción:");
        pnlAzul.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Número de bloques:");
        pnlAzul.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Nombre:");
        pnlAzul.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        pnlAzul.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 540, 80, -1));

        btnMostrarCarrera.setText("Ver Carreras");
        btnMostrarCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarCarreraActionPerformed(evt);
            }
        });
        pnlAzul.add(btnMostrarCarrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 540, 120, -1));

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane2.setViewportView(txtDescripcion);

        pnlAzul.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, 310, 100));

        AgregarCarrera.setText("Agregar Carrera");
        AgregarCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarCarreraActionPerformed(evt);
            }
        });
        pnlAzul.add(AgregarCarrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 540, 130, -1));

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        pnlAzul.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 540, 90, -1));
        pnlAzul.add(txtNumBloques, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 310, -1));
        pnlAzul.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 310, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("FACULTAD");
        pnlAzul.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, -1, -1));
        pnlAzul.add(txtLatitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 360, 150, -1));
        pnlAzul.add(txtLongitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 360, 150, -1));

        getContentPane().add(pnlAzul, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 580));

        pnlGris.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 51));
        jLabel9.setText("Facultades");
        pnlGris.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, -1));

        btnOrden.setText("Ascendente");
        pnlGris.add(btnOrden, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 100, -1));
        pnlGris.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 120, 150, -1));

        btnOrdenar.setText("Ordenar");
        btnOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenarActionPerformed(evt);
            }
        });
        pnlGris.add(btnOrdenar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, 70, -1));

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        pnlGris.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 70, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 51));
        jLabel12.setText("Texto:");
        pnlGris.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 120, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 51));
        jLabel11.setText("Criterio:");
        pnlGris.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        cbxCriterio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "nombre", "ubicacion", "numBloques" }));
        pnlGris.add(cbxCriterio, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 90, -1));

        cbxMetodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Busqueda_Lineal", "Busqueda_Binaria" }));
        pnlGris.add(cbxMetodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 130, -1));

        tbFacultad.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tbFacultad);

        pnlGris.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 610, 90));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 51));
        jLabel5.setText("CARRERAS");
        pnlGris.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 280, -1, -1));
        pnlGris.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 350, 130, -1));

        jButton3.setText("Ordenar");
        pnlGris.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 480, 60, -1));

        jButton5.setText("Buscar");
        pnlGris.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, 60, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 51));
        jLabel10.setText("Texto:");
        pnlGris.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 350, -1, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        pnlGris.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 150, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 51));
        jLabel8.setText("Criterio:");
        pnlGris.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 60, -1));

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
        jScrollPane4.setViewportView(tbCarrera);

        pnlGris.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 610, 90));

        getContentPane().add(pnlGris, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 0, 640, 580));

        jMenu1.setText("Administracion");

        btnAdmCarrera.setText("Carrera");
        btnAdmCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdmCarreraActionPerformed(evt);
            }
        });
        jMenu1.add(btnAdmCarrera);

        btnAdmMalla.setText("Malla");
        btnAdmMalla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdmMallaActionPerformed(evt);
            }
        });
        jMenu1.add(btnAdmMalla);

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

        btnAdmPeriodo.setText("Periodo Académico");
        btnAdmPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdmPeriodoActionPerformed(evt);
            }
        });
        jMenu1.add(btnAdmPeriodo);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Menu");

        btnIncio.setText("Inicio");
        btnIncio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncioActionPerformed(evt);
            }
        });
        jMenu2.add(btnIncio);

        btnMatricula.setText("Matriculas");
        btnMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMatriculaActionPerformed(evt);
            }
        });
        jMenu2.add(btnMatricula);

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

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        this.dispose();
        try {
            new GuardarFacultad().setVisible(true);
        } catch (EmptyException ex) {
            Logger.getLogger(GuardarFacultad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void AgregarCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarCarreraActionPerformed
        int filaSeleccionada = tbFacultad.getSelectedRow();
        if (filaSeleccionada != -1) {
            try {
                new AgregarCarrera(filaSeleccionada).setVisible(true);
            } catch (Exception ex) {
                int i = JOptionPane.showConfirmDialog(null, "No hay carrera para agregar \n ¿Desea crearla?", "ADVERTENCIA", JOptionPane.OK_CANCEL_OPTION);
                if (i == JOptionPane.OK_OPTION) {
                    try {
                        new GuardarCarrera().setVisible(true);
                        this.dispose();
                    } catch (EmptyException ex1) {
                        JOptionPane.showConfirmDialog(null, "Hubo un problema al intentar crear la  carrera :c");
                    }
                }
            }
            cargarTabla();
        } else {
            JOptionPane.showConfirmDialog(null, "No ha seleccionado una facultad de la tabla facultades", "ADVERTENCIA", JOptionPane.OK_CANCEL_OPTION);
        }
    }//GEN-LAST:event_AgregarCarreraActionPerformed

    private void btnMostrarCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarCarreraActionPerformed
        int filaSeleccionada = tbFacultad.getSelectedRow();
        if (filaSeleccionada != -1) {
            try {
                if (facultadControl.getListFacultades().getInfo(filaSeleccionada).getCarreras().getLength() == 0) {
                    JOptionPane.showConfirmDialog(null, "Esta facultad no tiene carreras", "ADVERTENCIA", JOptionPane.OK_CANCEL_OPTION);
                } else {
                    mtf.setCarreras(facultadControl.getListFacultades().getInfo(filaSeleccionada).getCarreras());
                    tbCarrera.setModel(mtf);
                    tbCarrera.updateUI();
                }
            } catch (EmptyException ex) {
                Logger.getLogger(GuardarCiclo.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showConfirmDialog(null, "No ha seleccionado una facultad de la tabla facultades", "ADVERTENCIA", JOptionPane.OK_CANCEL_OPTION);
    }//GEN-LAST:event_btnMostrarCarreraActionPerformed
    }
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            guardar();
        } catch (EmptyException ex) {
            Logger.getLogger(GuardarFacultad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscar();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenarActionPerformed
        ordenar();
    }//GEN-LAST:event_btnOrdenarActionPerformed

    private void btnAdmMallaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdmMallaActionPerformed
        try {
            new GuardarMalla().setVisible(true);
            this.dispose();
        } catch (EmptyException ex) {
            Logger.getLogger(GuardarFacultad.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_btnAdmMallaActionPerformed

    private void btnAdmCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdmCarreraActionPerformed
        try {
            new GuardarCarrera().setVisible(true);
            this.dispose();
        } catch (EmptyException ex) {
            Logger.getLogger(GuardarFacultad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAdmCarreraActionPerformed

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
            Logger.getLogger(GuardarFacultad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAdmMatriculaActionPerformed

    private void btnAdmPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdmPeriodoActionPerformed
        new GuardarPeriodoAcademico().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAdmPeriodoActionPerformed

    private void btnIncioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnIncioActionPerformed

    private void btnMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMatriculaActionPerformed
        try {
            new EstudianteMatricula().setVisible(true);
             this.dispose();
        } catch (EmptyException ex) {
            java.util.logging.Logger.getLogger(GuardarCiclo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnMatriculaActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalirActionPerformed

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
            java.util.logging.Logger.getLogger(GuardarFacultad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GuardarFacultad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GuardarFacultad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GuardarFacultad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new GuardarFacultad().setVisible(true);
                } catch (EmptyException ex) {
                    Logger.getLogger(GuardarFacultad.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AgregarCarrera;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JMenuItem btnAdmCarrera;
    private javax.swing.JMenuItem btnAdmCiclo;
    private javax.swing.JMenuItem btnAdmCursa;
    private javax.swing.JMenuItem btnAdmMalla;
    private javax.swing.JMenuItem btnAdmMatricula;
    private javax.swing.JMenuItem btnAdmPeriodo;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JMenuItem btnIncio;
    private javax.swing.JMenuItem btnMatricula;
    private javax.swing.JButton btnMostrarCarrera;
    private javax.swing.JCheckBox btnOrden;
    private javax.swing.JButton btnOrdenar;
    private javax.swing.JMenuItem btnSalir;
    private javax.swing.JComboBox<String> cbxCriterio;
    private javax.swing.JComboBox<String> cbxMetodo;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
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
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTextField2;
    private org.edisoncor.gui.panel.PanelImage pnlAzul;
    private org.edisoncor.gui.panel.PanelImage pnlGris;
    private javax.swing.JTable tbCarrera;
    private javax.swing.JTable tbFacultad;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtLatitud;
    private javax.swing.JTextField txtLongitud;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumBloques;
    // End of variables declaration//GEN-END:variables
}
