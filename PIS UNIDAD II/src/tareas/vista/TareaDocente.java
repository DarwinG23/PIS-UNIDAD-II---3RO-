/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tareas.vista;

import java.awt.HeadlessException;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.TableModel;
import tareas.controlador.controladorTarea.administrarTarea1;
import tareas.vista.modeloTabla.modeloTablaTarea;
import tareas.vista.utilVista.utilVistaEstadoTarea;
import tareas.vista.utilVista.utilVistaTipoTarea;
import usuarios.modelo.Docente;
import usuarios.vista.Menu;

/**
 *
 * @author ALEJANDRO
 */
public class TareaDocente extends javax.swing.JFrame {

    private administrarTarea1 tareaControl = new administrarTarea1();
    private modeloTablaTarea mtp = new modeloTablaTarea();
    private Docente docente;

    /**
     * Creates new form TareaDocente
     */
    public TareaDocente() {
        initComponents();
        this.setLocationRelativeTo(null);
        Limpiar();
        pnlAzul.setIcon(new ImageIcon("fotos/Azul.png"));
        pnlGris.setIcon(new ImageIcon("fotos/Celeste.jpg"));
    }

    public TareaDocente(Docente docente) throws HeadlessException {
        this.docente = docente;
        initComponents();
        this.setLocationRelativeTo(null);
        Limpiar();
        pnlAzul.setIcon(new ImageIcon("fotos/Azul.png"));
        pnlGris.setIcon(new ImageIcon("fotos/Celeste.jpg"));
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
            utilVistaEstadoTarea.CargarMaterias(cbxMateria);
            utilVistaEstadoTarea.CargarEstudiantes(cbxEstudiante);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        txtDescripcion.setEnabled(true);
        txtDescripcion.setText(" ");
        txtTitulo.setText(" ");
        txtFechaInicio.getDate( );
        txtFechaFinal.getDate( );
        tblMostrar.clearSelection();
        CargarTabla();
        cbxEstado.setSelectedIndex(-1);//limpia combobo
        cbxTipo.setSelectedIndex(-1);//limpia combobo
        cbxTipo.setSelectedIndex(-1);
        cbxEstudiante.setSelectedIndex(-1);
        cbxMateria.setSelectedIndex(-1);
        tareaControl.setTarea1(null);
    }

    private Boolean Validar() {
        return (!txtDescripcion.getText().trim().isEmpty()
                && !txtTitulo.getText().trim().isEmpty());
    }

    private void Guardar() {
        if (Validar()) {
            tareaControl.getTarea1().setDescripcion(txtDescripcion.getText());
            tareaControl.getTarea1().setId_tarea(utilVistaTipoTarea.ObtenerTipoTarea(cbxTipo));
            tareaControl.getTarea1().setId_estado(utilVistaEstadoTarea.ObtenerEstadoTarea(cbxEstado));
            tareaControl.getTarea1().setMateria(utilVistaEstadoTarea.ObtenerMateria(cbxMateria));
            tareaControl.getTarea1().setEstudiante(utilVistaEstadoTarea.ObtenerEstudiante(cbxEstudiante));
            tareaControl.getTarea1().setTituloTarea(txtTitulo.getText());
            tareaControl.getTarea1().setFecha_Inicio(txtFechaInicio.getDate());
            tareaControl.getTarea1().setFecha_Final(txtFechaFinal.getDate());

            if (tareaControl.persist()) {
                JOptionPane.showMessageDialog(null, "Datos guardados con exito");
                tareaControl.setTarea1(null);
                CargarTabla();
                Limpiar();
//                publicar();
                publicar1();
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo guardar");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Falta llenar campos  ");

        }
    }
    private void publicar() {
        EntregaTarea ea=new EntregaTarea();
        ea.recibirDatosTarea(txtTitulo.getText(), txtDescripcion.getText()); 
    }
    private void publicar1() {
        ReporteNotas ea=new ReporteNotas();
        ea.recibirDatosReporte(txtTitulo.getText(),txtDescripcion.getText());
    }

    private void cargarVista() {
        int fila = tblMostrar.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(null, "Escoja un registtro de la tabla");
        } else {
            try {
                tareaControl.setTarea1(mtp.getTarea().getInfo(fila));
                txtDescripcion.setText(tareaControl.getTarea1().getDescripcion());
                txtTitulo.setText(tareaControl.getTarea1().getTituloTarea());
                txtFechaInicio.setDate(tareaControl.getTarea1().getFecha_Inicio());
                txtFechaFinal.setDate(tareaControl.getTarea1().getFecha_Final());
                cbxEstado.setSelectedItem(tareaControl.getTarea1().getId_estado());
                cbxTipo.setSelectedItem(tareaControl.getTarea1().getId_tarea());
                cbxMateria.setSelectedItem(tareaControl.getTarea1().getMateria());
                cbxEstudiante.setSelectedItem(tareaControl.getTarea1().getEstudiante());
            } catch (Exception e) {
            }

        }
    }

    private void ordenar() {
        String criterio = cbxCriterio.getSelectedItem().toString().toLowerCase();
        Integer tipo = 0;
        if (cbxOrden.isSelected()) {
            tipo = 1;
        }
        try {
            System.out.println("QuickSort");
            mtp.setTarea(tareaControl.ordenarQuickSort(tareaControl.all(), tipo, criterio));
            tblMostrar.setModel(mtp);
            tblMostrar.updateUI();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void buscar() {
        String texto = txtBuscar.getText();
        String criterio = cbxCriterio.getSelectedItem().toString();
        if ("Nota".equals(cbxCriterio.getSelectedItem().toString())) {
            try {
                System.out.println("Busqueda_Binaria");
                mtp.setTarea(tareaControl.all());
                mtp.setTarea(tareaControl.busquedaBinaria(texto, mtp.getTarea(), criterio));
                tblMostrar.setModel(mtp);
                tblMostrar.updateUI();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } else if ("Descripcion".equals(cbxCriterio.getSelectedItem().toString())
                || "Id_TipoTarea".equals(cbxCriterio.getSelectedItem().toString())
                ||"Id_EstadoTarea".equals(cbxCriterio.getSelectedItem().toString())
                ||"Fecha_Inicio".equals(cbxCriterio.getSelectedItem().toString())
                ||"Fecha_Final".equals(cbxCriterio.getSelectedItem().toString())
                ||"Titulo_Tarea".equals(cbxCriterio.getSelectedItem().toString())){
                 
            try {
                System.out.println("Busqueda_Lineal");
                mtp.setTarea(tareaControl.all());
                mtp.setTarea(tareaControl.busquedaLineal(texto, mtp.getTarea(), criterio));
                tblMostrar.setModel(mtp);
                tblMostrar.updateUI();
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

        pnlGris = new org.edisoncor.gui.panel.PanelImage();
        jLabel14 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cbxCriterio = new javax.swing.JComboBox<>();
        cbxOrden = new javax.swing.JCheckBox();
        jLabel11 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMostrar = new javax.swing.JTable();
        btnOrdenar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        pnlAzul = new org.edisoncor.gui.panel.PanelImage();
        jLabel13 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbxMateria = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbxTipo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtFechaInicio = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        txtFechaFinal = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        cbxEstado = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        cbxEstudiante = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        btnSeleccionar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlGris.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("BUSCAR TAREAS");
        pnlGris.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 270, 40));

        jLabel12.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("ORDENAR DATOS:");
        pnlGris.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 210, -1));

        cbxCriterio.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        cbxCriterio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Id_TipoTarea", "Id_EstadoTarea", "Titulo_Tarea", "Fecha_Inicio", "Fecha_Final", "Descripcion", " " }));
        cbxCriterio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCriterioActionPerformed(evt);
            }
        });
        pnlGris.add(cbxCriterio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        cbxOrden.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        cbxOrden.setForeground(new java.awt.Color(255, 102, 102));
        cbxOrden.setText("Descendente");
        pnlGris.add(cbxOrden, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 140, -1));

        jLabel11.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("BUSCAR DATOS:");
        pnlGris.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        txtBuscar.setBackground(new java.awt.Color(204, 204, 255));
        txtBuscar.setForeground(new java.awt.Color(153, 153, 255));
        pnlGris.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 140, 30));

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

        pnlGris.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 490, 300));

        btnOrdenar.setBackground(new java.awt.Color(0, 0, 0));
        btnOrdenar.setForeground(new java.awt.Color(255, 255, 255));
        btnOrdenar.setText("ORDENAR");
        btnOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenarActionPerformed(evt);
            }
        });
        pnlGris.add(btnOrdenar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, 190, -1));

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("BUSCAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        pnlGris.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, 190, -1));

        getContentPane().add(pnlGris, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 0, 610, 620));

        pnlAzul.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("ENVIO DE TAREAS");
        pnlAzul.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 300, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("MATERIA:");
        pnlAzul.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 130, -1));

        pnlAzul.add(cbxMateria, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 340, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("TÍTULO TAREA:");
        pnlAzul.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        txtTitulo.setBackground(new java.awt.Color(204, 204, 255));
        pnlAzul.add(txtTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 340, 30));

        jLabel3.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("TIPO TAREA:");
        pnlAzul.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        cbxTipo.setBackground(new java.awt.Color(204, 204, 255));
        cbxTipo.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        cbxTipo.setForeground(new java.awt.Color(0, 0, 0));
        pnlAzul.add(cbxTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, 340, 40));

        jLabel4.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("DESCRIPCIÓN TAREA");
        pnlAzul.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 200, 50));

        txtDescripcion.setBackground(new java.awt.Color(204, 204, 255));
        pnlAzul.add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 310, 40));

        jLabel8.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("FECHA INICIO:");
        pnlAzul.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, -1, -1));

        txtFechaInicio.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                txtFechaInicioMouseWheelMoved(evt);
            }
        });
        pnlAzul.add(txtFechaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, 300, -1));

        jLabel9.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("FECHA FINAL:");
        pnlAzul.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, -1, -1));

        txtFechaFinal.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                txtFechaFinalMouseWheelMoved(evt);
            }
        });
        pnlAzul.add(txtFechaFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 350, 300, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("ESTADO TAREA:");
        pnlAzul.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, -1, -1));

        cbxEstado.setBackground(new java.awt.Color(204, 204, 255));
        cbxEstado.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        pnlAzul.add(cbxEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 420, 310, 40));

        jLabel10.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("ESTUDIANTE");
        pnlAzul.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, -1, -1));

        pnlAzul.add(cbxEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 490, 300, -1));

        btnGuardar.setBackground(new java.awt.Color(0, 0, 0));
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("GUARDAR DATOS");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        pnlAzul.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, 190, 60));

        jLabel7.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("¿DESEA CAMBIAR ALGUN DATO?");
        pnlAzul.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 530, -1, -1));

        btnSeleccionar.setBackground(new java.awt.Color(0, 0, 0));
        btnSeleccionar.setForeground(new java.awt.Color(255, 255, 255));
        btnSeleccionar.setText("SELECCIONAR DATO");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });
        pnlAzul.add(btnSeleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 560, -1, 40));

        btnModificar.setBackground(new java.awt.Color(0, 0, 0));
        btnModificar.setForeground(new java.awt.Color(255, 255, 255));
        btnModificar.setText("GUARDAR DATOS MODIFICADOS");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        pnlAzul.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 560, 200, 40));

        getContentPane().add(pnlAzul, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 620));

        jMenu3.setText("OPCIONES DOCENTE");
        jMenu3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jMenuItem2.setText("Calificar Tarea");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("OTROS");
        jMenu4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jMenuItem3.setText("INICIO");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem3);

        jMenuItem4.setText("SALIR");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem4);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenarActionPerformed
        ordenar();
    }//GEN-LAST:event_btnOrdenarActionPerformed
//
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         buscar( );
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbxCriterioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCriterioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxCriterioActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        CalificarTarea cf=new CalificarTarea();
        this.dispose();
        cf.setVisible(true);

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        dispose();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        try {
            new Menu(this.docente).setVisible(true);
            this.dispose();
        } catch (Exception e) {
            new Menu().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void txtFechaInicioMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_txtFechaInicioMouseWheelMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaInicioMouseWheelMoved

    private void txtFechaFinalMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_txtFechaFinalMouseWheelMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaFinalMouseWheelMoved

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (Validar()) {
            tareaControl.getTarea1().setDescripcion(txtDescripcion.getText());
            tareaControl.getTarea1().setId_tarea(utilVistaTipoTarea.ObtenerTipoTarea(cbxTipo));
            tareaControl.getTarea1().setId_estado(utilVistaEstadoTarea.ObtenerEstadoTarea(cbxEstado));
            tareaControl.getTarea1().setMateria(utilVistaEstadoTarea.ObtenerMateria(cbxMateria));
            tareaControl.getTarea1().setEstudiante(utilVistaEstadoTarea.ObtenerEstudiante(cbxEstudiante));
            tareaControl.getTarea1().setTituloTarea(txtTitulo.getText());
            tareaControl.getTarea1().setFecha_Inicio(txtFechaInicio.getDate());
            tareaControl.getTarea1().setFecha_Final(txtFechaFinal.getDate());
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

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        cargarVista();
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        Guardar();
    }//GEN-LAST:event_btnGuardarActionPerformed

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
        //</editor-fold>
        //</editor-fold>
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
    private javax.swing.JButton btnOrdenar;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JComboBox<String> cbxCriterio;
    private javax.swing.JComboBox<String> cbxEstado;
    private javax.swing.JComboBox<Object> cbxEstudiante;
    private javax.swing.JComboBox<Object> cbxMateria;
    private javax.swing.JCheckBox cbxOrden;
    private javax.swing.JComboBox<String> cbxTipo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JScrollPane jScrollPane1;
    private org.edisoncor.gui.panel.PanelImage pnlAzul;
    private org.edisoncor.gui.panel.PanelImage pnlGris;
    private javax.swing.JTable tblMostrar;
    private javax.swing.JTextField txtBuscar;
    public static javax.swing.JTextField txtDescripcion;
    private com.toedter.calendar.JDateChooser txtFechaFinal;
    private com.toedter.calendar.JDateChooser txtFechaInicio;
    public static javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
