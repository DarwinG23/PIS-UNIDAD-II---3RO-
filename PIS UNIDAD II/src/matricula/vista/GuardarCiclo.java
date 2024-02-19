/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package matricula.vista;

import exeption.EmptyException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import lista.DynamicList;
import materias.vista.Tabla.ModeloTablaMateria;
import materias.vista.util.UtilVista1;
import matricula.controlador.CarreraControl;
import matricula.controlador.CicloControl;
import matricula.controlador.MallaControl;
import matricula.modelo.Ciclo;
import matricula.modelo.Malla;
import matricula.vista.tabla.ModeloTablaCiclo;
import matricula.vista.util.UtilVistaMalla;
import usuarios.vista.Menu;

/**
 *
 * @author darwin
 */
public class GuardarCiclo extends javax.swing.JFrame {

    private ModeloTablaCiclo mtc = new ModeloTablaCiclo();
    private ModeloTablaMateria mtm = new ModeloTablaMateria();
    private CicloControl cicloControl = new CicloControl();
    private MallaControl mallaControl = new MallaControl();
    private CarreraControl carreraControl = new CarreraControl();

    public void cargarFacultades(DynamicList carreras) {
        mtc.setCiclos(carreras);
        initComponents();

    }

    public Boolean verificar() {
        return true; //(!txtNuCiclo.getText().trim().isEmpty());
    }

    private void cargarTabla() {
        mtc.setCiclos(cicloControl.getListCiclo());
        tbMateria.setModel(mtm);
        tbCiclo.setModel(mtc);
        tbMateria.updateUI();
        tbCiclo.updateUI();
    }

    private void guardar() throws EmptyException {
        if (verificar()) {
            cicloControl.getCiclo().setNumCiclo(cbxNumCiclo.getSelectedIndex() + 1);
            cicloControl.getCiclo().setId_Malla(UtilVistaMalla.obtenerCarrera(cbxMalla).getId());
            if (cicloControl.persist()) {

                cargarTabla();
                limpiar();
                cicloControl.setCiclo(null);
                DynamicList<Ciclo> ciclos = mallaControl.getListMalla().getInfo(cbxMalla.getSelectedIndex()).getCiclos();
                ciclos.add(cicloControl.getListCiclo().getInfo(cicloControl.getListCiclo().getLength() - 1));

                mallaControl.getMalla().setCiclos(ciclos);
                mallaControl.getMalla().setFechaCreacion(mallaControl.getListMalla().getInfo(cbxMalla.getSelectedIndex()).getFechaCreacion());
                mallaControl.getMalla().setId(mallaControl.getListMalla().getInfo(cbxMalla.getSelectedIndex()).getId());
                mallaControl.getMalla().setId_Carrera(mallaControl.getListMalla().getInfo(cbxMalla.getSelectedIndex()).getId_Carrera());
                mallaControl.getMalla().setNombre(mallaControl.getListMalla().getInfo(cbxMalla.getSelectedIndex()).getNombre());

                if (mallaControl.marge(mallaControl.getMalla(), cbxMalla.getSelectedIndex())) {
                    actualizarCarrera(mallaControl.getMalla());
                    JOptionPane.showMessageDialog(null, "Datos guardados");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al agregar a el ciclo a la malla");

                }

            } else {
                JOptionPane.showMessageDialog(null, "No se pudo guardar, hubo un error");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Falta llenar campos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void actualizarCarrera(Malla malla) throws EmptyException {
        for (int i = 0; i < carreraControl.getListCarrera().getLength(); i++) {
            DynamicList<Malla> mallas = carreraControl.getListCarrera().getInfo(i).getMallas();
            for (int j = 0; j < mallas.getLength(); j++) {
                System.out.println(mallas.getInfo(j).getId() +"/" + cbxMalla.getSelectedIndex()+1);
                if (mallas.getInfo(j).getId() == cbxMalla.getSelectedIndex()+1) {
                    mallas.extract(j);
                    mallas.add(malla);
                    carreraControl.getCarrera().setDescripcion(carreraControl.getListCarrera().getInfo(i).getDescripcion());
                    carreraControl.getCarrera().setDuracionAnios(carreraControl.getListCarrera().getInfo(i).getDuracionAnios());
                    carreraControl.getCarrera().setId(carreraControl.getListCarrera().getInfo(i).getId());
                    carreraControl.getCarrera().setMallas(mallas);
                    carreraControl.getCarrera().setNombre(carreraControl.getListCarrera().getInfo(i).getNombre());
                    if (carreraControl.marge(carreraControl.getCarrera(), i)) {
                        System.out.println("si");
                    } else {
                        System.out.println(":c");
                    }
                }
            }
        }

    }

    private void limpiar() {
        cargarTabla();
        cicloControl.setCiclo(null);
    }

    private void ordenar() {
        String criterio = cbxCriterio.getSelectedItem().toString().toLowerCase();
        Integer tipo = 0;
        if (btnOrden.isSelected()) {
            tipo = 1;
        }
        try {
            mtc.setCiclos(cicloControl.ordenarQuickSort(cicloControl.all(), tipo, criterio));
            tbCiclo.setModel(mtc);
            tbCiclo.updateUI();
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
                mtc.setCiclos(cicloControl.all());
                mtc.setCiclos(cicloControl.busquedaBinaria(texto, mtc.getCiclos(), criterio));
                tbCiclo.setModel(mtc);
                tbCiclo.updateUI();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } else if (cbxMetodo.getSelectedItem().toString() == "Busqueda_Lineal") {
            try {
                System.out.println("Busqueda_Lineal");
                mtc.setCiclos(cicloControl.all());
                mtc.setCiclos(cicloControl.buscarPorCriterioLineal(texto, mtc.getCiclos(), criterio));
                tbCiclo.setModel(mtc);
                tbCiclo.updateUI();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public GuardarCiclo() throws EmptyException {
        initComponents();
        pnlAzul.setIcon(new ImageIcon("fotos/Azul.png"));
         pnlGris.setIcon(new ImageIcon("fotos/Celeste.jpg"));
        setLocationRelativeTo(null);
        cargarTabla();
        UtilVistaMalla.cargarcomboCarrera(cbxMalla);
        //UtilVista1.cargarcomboRolesL(cbxMateria);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlAzul = new org.edisoncor.gui.panel.PanelImage();
        jLabel17 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        cbxNumCiclo = new javax.swing.JComboBox<>();
        cbxMalla = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        btnAgregarMateria = new javax.swing.JButton();
        btnCargarMateria = new javax.swing.JButton();
        pnlGris = new org.edisoncor.gui.panel.PanelImage();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbCiclo = new javax.swing.JTable();
        cbxCriterio = new javax.swing.JComboBox<>();
        cbxMetodo = new javax.swing.JComboBox<>();
        btnOrdenar = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        btnOrden1 = new javax.swing.JCheckBox();
        btnBuscar1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbMateria = new javax.swing.JTable();
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
        jLabel13 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        btnAdmFacultad = new javax.swing.JMenuItem();
        btnAdmCarrera = new javax.swing.JMenuItem();
        btnAdmMalla = new javax.swing.JMenuItem();
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

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("CICLO");
        pnlAzul.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Número:");
        pnlAzul.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Malla:");
        pnlAzul.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        cbxNumCiclo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        pnlAzul.add(cbxNumCiclo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 260, -1));

        cbxMalla.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        pnlAzul.add(cbxMalla, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 260, -1));

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        pnlAzul.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 560, -1, -1));

        btnAgregarMateria.setText("Agregar Materia");
        btnAgregarMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarMateriaActionPerformed(evt);
            }
        });
        pnlAzul.add(btnAgregarMateria, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 560, -1, -1));

        btnCargarMateria.setText("Mostrar Materias");
        btnCargarMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarMateriaActionPerformed(evt);
            }
        });
        pnlAzul.add(btnCargarMateria, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 560, -1, -1));

        getContentPane().add(pnlAzul, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 600));

        pnlGris.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbCiclo.setBackground(new java.awt.Color(255, 255, 255));
        tbCiclo.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tbCiclo);

        pnlGris.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 580, 88));

        cbxCriterio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "nombre", "descripcion", "duracionAnios", "numCiclos" }));
        pnlGris.add(cbxCriterio, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 100, -1));

        cbxMetodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Busqueda_Lineal", "Busqueda_Binaria" }));
        pnlGris.add(cbxMetodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 100, -1));

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

        tbMateria.setBackground(new java.awt.Color(255, 255, 255));
        tbMateria.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tbMateria);

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
        jLabel16.setForeground(new java.awt.Color(0, 0, 51));
        jLabel16.setText("MATERIAS");
        pnlGris.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 230, -1, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 51));
        jLabel18.setText("CICLOS");
        pnlGris.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 51));
        jLabel13.setText("Criterio:");
        pnlGris.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));

        getContentPane().add(pnlGris, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 0, 640, 600));

        jMenu1.setText("Administración");

        btnAdmFacultad.setText("Facultad");
        btnAdmFacultad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdmFacultadActionPerformed(evt);
            }
        });
        jMenu1.add(btnAdmFacultad);

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

        btnAdmPeriodo.setText("Perido Académico");
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

    private void btnOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenarActionPerformed

    }//GEN-LAST:event_btnOrdenarActionPerformed

    private void btnBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar1ActionPerformed

    }//GEN-LAST:event_btnBuscar1ActionPerformed

    private void btnOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnOrdenActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            guardar();
        } catch (EmptyException ex) {
            //Logger.getLogger(GuardarCiclo1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnAgregarMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarMateriaActionPerformed
        int filaSeleccionada = tbCiclo.getSelectedRow();
        if (filaSeleccionada != -1) {
            try {
                new AgregarMateria(filaSeleccionada).setVisible(true);
            } catch (Exception ex) {
                //Logger.getLogger(GuardarCiclo1.class.getName()).log(Level.SEVERE, null, ex);
            }
            cargarTabla();
        } else {
            JOptionPane.showMessageDialog(null, "No ha seleccionado ningun ciclo", "Error", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_btnAgregarMateriaActionPerformed
    }
    private void btnCargarMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarMateriaActionPerformed
        int filaSeleccionada = tbCiclo.getSelectedRow();
        if (filaSeleccionada != -1) {
            try {
                mtm.setMaterias(cicloControl.getListCiclo().getInfo(filaSeleccionada).getMaterias());
                tbMateria.setModel(mtm);
                tbMateria.updateUI();
            } catch (EmptyException ex) {
                JOptionPane.showConfirmDialog(null, "Error al cargar la tabla de Materias");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No ha seleccionado ningun ciclo", "Error", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_btnCargarMateriaActionPerformed
    }
    private void btnAdmFacultadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdmFacultadActionPerformed
        try {
            new GuardarFacultad().setVisible(true);
            this.dispose();
        } catch (EmptyException ex) {
            java.util.logging.Logger.getLogger(GuardarFacultad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAdmFacultadActionPerformed

    private void btnAdmCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdmCarreraActionPerformed
        try {
            new GuardarCarrera().setVisible(true);
            this.dispose();
        } catch (EmptyException ex) {
            java.util.logging.Logger.getLogger(GuardarFacultad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAdmCarreraActionPerformed

    private void btnAdmMallaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdmMallaActionPerformed
        try {
            new GuardarMalla().setVisible(true);
            this.dispose();
        } catch (EmptyException ex) {
            java.util.logging.Logger.getLogger(GuardarFacultad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAdmMallaActionPerformed

    private void btnAdmCursaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdmCursaActionPerformed
        new GuardarCursa().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAdmCursaActionPerformed

    private void btnAdmMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdmMatriculaActionPerformed
        try {
            new GuardarMatricula().setVisible(true);
            this.dispose();
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(GuardarCiclo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAdmMatriculaActionPerformed

    private void btnAdmPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdmPeriodoActionPerformed
        new GuardarPeriodoAcademico().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAdmPeriodoActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnIncioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncioActionPerformed
        new Menu().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnIncioActionPerformed

    private void btnMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMatriculaActionPerformed
        try {
            new EstudianteMatricula().setVisible(true);
            this.dispose();
        } catch (EmptyException ex) {
            java.util.logging.Logger.getLogger(GuardarCiclo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnMatriculaActionPerformed

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
            java.util.logging.Logger.getLogger(GuardarCiclo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GuardarCiclo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GuardarCiclo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GuardarCiclo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new GuardarCiclo().setVisible(true);
                } catch (EmptyException ex) {
                    java.util.logging.Logger.getLogger(GuardarCiclo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btnAdmCarrera;
    private javax.swing.JMenuItem btnAdmCursa;
    private javax.swing.JMenuItem btnAdmFacultad;
    private javax.swing.JMenuItem btnAdmMalla;
    private javax.swing.JMenuItem btnAdmMatricula;
    private javax.swing.JMenuItem btnAdmPeriodo;
    private javax.swing.JButton btnAgregarMateria;
    private javax.swing.JButton btnBuscar1;
    private javax.swing.JButton btnBuscar2;
    private javax.swing.JButton btnCargarMateria;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JMenuItem btnIncio;
    private javax.swing.JMenuItem btnMatricula;
    private javax.swing.JCheckBox btnOrden;
    private javax.swing.JCheckBox btnOrden1;
    private javax.swing.JButton btnOrdenar;
    private javax.swing.JButton btnOrdenar1;
    private javax.swing.JMenuItem btnSalir;
    private javax.swing.JComboBox<String> cbxCriterio;
    private javax.swing.JComboBox<String> cbxCriterio1;
    private javax.swing.JComboBox<String> cbxMalla;
    private javax.swing.JComboBox<String> cbxMetodo;
    private javax.swing.JComboBox<String> cbxMetodo2;
    private javax.swing.JComboBox<String> cbxNumCiclo;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private org.edisoncor.gui.panel.PanelImage pnlAzul;
    private org.edisoncor.gui.panel.PanelImage pnlGris;
    private javax.swing.JTable tbCiclo;
    private javax.swing.JTable tbMateria;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtBuscar1;
    // End of variables declaration//GEN-END:variables
}
