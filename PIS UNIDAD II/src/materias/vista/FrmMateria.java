/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package materias.vista;

import exeption.EmptyException;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import materias.controlador.registros.MateriaControl1;
import materias.vista.Tabla.ModeloTablaMateria;
import matricula.vista.EstudianteMatricula;
import matricula.vista.GuardarCarrera;
import matricula.vista.GuardarCiclo;
import matricula.vista.GuardarCursa;
import matricula.vista.GuardarMalla;
import matricula.vista.GuardarMatricula;
import matricula.vista.GuardarPeriodoAcademico;
import usuarios.modelo.Docente;
import usuarios.modelo.Estudiante;
import usuarios.vista.GestionDocente;
import usuarios.vista.GestionEstudiante;
import usuarios.vista.Menu;
import usuarios.vista.MenuAdmin;
import java.util.logging.Level;
import java.util.logging.Logger;
import usuarios.vista.LoginPrincipal;

/**
 *
 * @author Alejandro
 */
public class FrmMateria extends javax.swing.JFrame {

    private MateriaControl1 materiaControl = new MateriaControl1();
    private ModeloTablaMateria mta = new ModeloTablaMateria();
    private Estudiante estudiante;
    private Docente docente;

    /**
     * Creates new form Materia
     */
    public FrmMateria() {
        initComponents();
        this.setLocationRelativeTo(null);
        Limpiar();
        pnlAzul.setIcon(new ImageIcon("fotos/Azul.png"));
        pnlGris.setIcon(new ImageIcon("fotos/Celeste.jpg"));
    }

    public FrmMateria(Docente docente) {
        initComponents();
        this.setLocationRelativeTo(null);
        Limpiar();
        pnlAzul.setIcon(new ImageIcon("fotos/Azul.png"));
        pnlGris.setIcon(new ImageIcon("fotos/Celeste.jpg"));
        this.docente = docente;
    }


    private void ordenar() {
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

    private void buscar() {
        String texto = txtBuscar.getText();
        String criterio = cbxCriterio1.getSelectedItem().toString();
        if ("ciclo".equals(cbxCriterio1.getSelectedItem().toString())) {
            try {
                mta.setMaterias(materiaControl.all());
                mta.setMaterias(materiaControl.busquedaBinaria(texto, mta.getMaterias(), criterio));
                tblMostrar.setModel(mta);
                tblMostrar.updateUI();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } else if ("nombre".equals(cbxCriterio1.getSelectedItem().toString())
                || "paralelo".equals(cbxCriterio1.getSelectedItem().toString())
                || "fecha".equals(cbxCriterio1.getSelectedItem().toString())) {
            try {
                mta.setMaterias(materiaControl.all());
                mta.setMaterias(materiaControl.busquedaLineal(texto, mta.getMaterias(), criterio));
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
        cbxCiclo.setSelectedIndex(0);
    }

    private void Limpiar() {
        cbxCiclo.setSelectedIndex(-1);
        tblMostrar.clearSelection();
        txtNameMateria.setText(" ");
        txtParalelo.setText(" ");
        txtFecha.getDate();
        CargarTabla();
        materiaControl.setMateria(null);

    }

    private Boolean Validar() {
        return (!txtNameMateria.getText().trim().isEmpty()
                && !txtParalelo.getText().trim().isEmpty());
    }

    private void Guardar() {
        if (Validar()) {

            materiaControl.getMateria().setNombre(txtNameMateria.getText());
            materiaControl.getMateria().setCiclo(cbxCiclo.getSelectedItem().toString());
            materiaControl.getMateria().setParalelo(txtParalelo.getText());
            materiaControl.getMateria().setFecha(txtFecha.getDate());

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

    }

    private void cargarVista() {
        int fila = tblMostrar.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(null, "Escoja un registro de la tabla");
        } else {
            try {
                materiaControl.setMateria(mta.getMaterias().getInfo(fila));
                txtNameMateria.setText(materiaControl.getMateria().getNombre());
                cbxCiclo.setSelectedItem(materiaControl.getMateria().getCiclo());
                txtParalelo.setText(materiaControl.getMateria().getParalelo());
                txtFecha.setDate(materiaControl.getMateria().getFecha());
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

        pnlAzul = new org.edisoncor.gui.panel.PanelImage();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNameMateria = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtParalelo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtFecha = new com.toedter.calendar.JDateChooser();
        btnGuardar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        btnSelect = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        cbxCiclo = new javax.swing.JComboBox<>();
        pnlGris = new org.edisoncor.gui.panel.PanelImage();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblMostrar = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        cbxCriterio1 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        btnOrden = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        btnIncio = new javax.swing.JMenuItem();
        btnSalir = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        btnAdmCarrera = new javax.swing.JMenuItem();
        btnAdmMalla = new javax.swing.JMenuItem();
        btnAdmCiclo = new javax.swing.JMenuItem();
        btnAdmCursa = new javax.swing.JMenuItem();
        btnAdmMatricula = new javax.swing.JMenuItem();
        btnAdmPeriodo = new javax.swing.JMenuItem();
        btnAdmEstudiante = new javax.swing.JMenuItem();
        btnAdmDocente = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlAzul.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Dialog", 3, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 51));
        jLabel3.setText("REGISTRO DE MATERIAS");
        pnlAzul.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, -1, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 153));
        jLabel4.setText("NOMBRE DE LA MATERIA:");
        pnlAzul.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));
        pnlAzul.add(txtNameMateria, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, 290, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 153));
        jLabel5.setText("CICLO:");
        pnlAzul.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 240, -1));

        jLabel8.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 153));
        jLabel8.setText("PARALELO:");
        pnlAzul.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));
        pnlAzul.add(txtParalelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 250, 270, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 153));
        jLabel6.setText("FECHA DE CREACIÓN:");
        pnlAzul.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, -1));
        pnlAzul.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 320, 260, -1));

        btnGuardar.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        btnGuardar.setText("GUARDAR MATERIA");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        pnlAzul.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, -1, -1));

        jLabel7.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 51, 51));
        jLabel7.setText("¿DESEA MODIFICAR UN DATO?");
        pnlAzul.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 420, -1, -1));

        btnSelect.setText("SELECCIONAR FILA");
        btnSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectActionPerformed(evt);
            }
        });
        pnlAzul.add(btnSelect, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 450, -1, -1));

        btnModificar.setText("MODIFICAR DATO");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        pnlAzul.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 490, 150, -1));

        cbxCiclo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        pnlAzul.add(cbxCiclo, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 170, 270, -1));

        pnlGris.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Dialog", 3, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 51));
        jLabel2.setText("BUSCAR MATERIAS");
        pnlGris.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, -1, -1));

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

        pnlGris.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 500, 280));

        jLabel9.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 153, 153));
        jLabel9.setText("ORDENAR:");
        pnlGris.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        cbxCriterio1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "nombre", "paralelo", "ciclo", "fecha" }));
        pnlGris.add(cbxCriterio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 170, -1));

        jLabel10.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 153, 153));
        jLabel10.setText("BUSCAR:");
        pnlGris.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));

        btnOrden.setText("Descendente");
        pnlGris.add(btnOrden, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, -1, -1));

        jButton1.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jButton1.setText("ORDENAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        pnlGris.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 90, 90, 20));
        pnlGris.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 230, -1));

        jButton2.setText("BUSCAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        pnlGris.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 160, 150, -1));

        jMenu3.setText("Menu");

        btnIncio.setText("Inicio");
        btnIncio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncioActionPerformed(evt);
            }
        });
        jMenu3.add(btnIncio);

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jMenu3.add(btnSalir);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Administracion");

        btnAdmCarrera.setText("Carrera");
        btnAdmCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdmCarreraActionPerformed(evt);
            }
        });
        jMenu4.add(btnAdmCarrera);

        btnAdmMalla.setText("Malla");
        btnAdmMalla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdmMallaActionPerformed(evt);
            }
        });
        jMenu4.add(btnAdmMalla);

        btnAdmCiclo.setText("Ciclo");
        btnAdmCiclo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdmCicloActionPerformed(evt);
            }
        });
        jMenu4.add(btnAdmCiclo);

        btnAdmCursa.setText("Cursa");
        btnAdmCursa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdmCursaActionPerformed(evt);
            }
        });
        jMenu4.add(btnAdmCursa);

        btnAdmMatricula.setText("Matricula");
        btnAdmMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdmMatriculaActionPerformed(evt);
            }
        });
        jMenu4.add(btnAdmMatricula);

        btnAdmPeriodo.setText("Periodo Académico");
        btnAdmPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdmPeriodoActionPerformed(evt);
            }
        });
        jMenu4.add(btnAdmPeriodo);

        btnAdmEstudiante.setText("Registro Estudiante");
        btnAdmEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdmEstudianteActionPerformed(evt);
            }
        });
        jMenu4.add(btnAdmEstudiante);

        btnAdmDocente.setText("Registro Docente");
        btnAdmDocente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdmDocenteActionPerformed(evt);
            }
        });
        jMenu4.add(btnAdmDocente);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlAzul, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlGris, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlGris, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlAzul, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdmCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdmCarreraActionPerformed
        try {
            new GuardarCarrera(this.docente).setVisible(true);
        } catch (EmptyException ex) {
            Logger.getLogger(MenuAdmin.class.getName()).log(Level.SEVERE, null, ex);

        }
        this.dispose();
    }//GEN-LAST:event_btnAdmCarreraActionPerformed

    private void btnAdmMallaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdmMallaActionPerformed
        try {
            new GuardarMalla(this.docente).setVisible(true);
            this.dispose();
        } catch (EmptyException ex) {
            //            Logger.getLogger(GuardarFacultad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAdmMallaActionPerformed

    private void btnAdmCicloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdmCicloActionPerformed
        try {
            new GuardarCiclo(this.docente).setVisible(true);
            this.dispose();
        } catch (EmptyException ex) {
            //            Logger.getLogger(GuardarFacultad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAdmCicloActionPerformed

    private void btnAdmCursaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdmCursaActionPerformed
        new GuardarCursa(this.docente).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAdmCursaActionPerformed

    private void btnAdmMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdmMatriculaActionPerformed
        try {
            new GuardarMatricula(this.docente).setVisible(true);
            this.dispose();
        } catch (Exception ex) {
            //            Logger.getLogger(GuardarFacultad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAdmMatriculaActionPerformed

    private void btnAdmPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdmPeriodoActionPerformed
        new GuardarPeriodoAcademico(this.docente).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAdmPeriodoActionPerformed

    private void btnAdmEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdmEstudianteActionPerformed
        new GestionEstudiante(this.docente).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAdmEstudianteActionPerformed

    private void btnAdmDocenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdmDocenteActionPerformed
        new GestionDocente(this.docente).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAdmDocenteActionPerformed

    private void btnIncioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncioActionPerformed
        new MenuAdmin(this.docente).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnIncioActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
       new LoginPrincipal().setVisible(true);
       this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        Guardar();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectActionPerformed
        cargarVista();
    }//GEN-LAST:event_btnSelectActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (Validar()) {

            materiaControl.getMateria().setNombre(txtNameMateria.getText());
            materiaControl.getMateria().setCiclo(cbxCiclo.getSelectedItem().toString());
            materiaControl.getMateria().setParalelo(txtParalelo.getText());
            materiaControl.getMateria().setFecha(txtFecha.getDate());

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
            java.util.logging.Logger.getLogger(FrmMateria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMateria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMateria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMateria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMateria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btnAdmCarrera;
    private javax.swing.JMenuItem btnAdmCiclo;
    private javax.swing.JMenuItem btnAdmCursa;
    private javax.swing.JMenuItem btnAdmDocente;
    private javax.swing.JMenuItem btnAdmEstudiante;
    private javax.swing.JMenuItem btnAdmMalla;
    private javax.swing.JMenuItem btnAdmMatricula;
    private javax.swing.JMenuItem btnAdmPeriodo;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JMenuItem btnIncio;
    private javax.swing.JButton btnModificar;
    private javax.swing.JCheckBox btnOrden;
    private javax.swing.JMenuItem btnSalir;
    private javax.swing.JButton btnSelect;
    private javax.swing.JComboBox<String> cbxCiclo;
    private javax.swing.JComboBox<String> cbxCriterio1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private org.edisoncor.gui.panel.PanelImage pnlAzul;
    private org.edisoncor.gui.panel.PanelImage pnlGris;
    private javax.swing.JTable tblMostrar;
    private javax.swing.JTextField txtBuscar;
    private com.toedter.calendar.JDateChooser txtFecha;
    private javax.swing.JTextField txtNameMateria;
    private javax.swing.JTextField txtParalelo;
    // End of variables declaration//GEN-END:variables
}
