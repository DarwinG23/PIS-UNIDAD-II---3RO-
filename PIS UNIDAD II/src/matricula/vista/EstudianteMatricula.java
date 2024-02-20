/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package matricula.vista;

import exeption.EmptyException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import lista.DynamicList;
import materias.controlador.MateriaControl;
import materias.controlador.MateriasControl.ControlMateria;
import materias.modelo.Materia;
import materias.vista.Tabla.ModeloTablaMateria;
import matricula.controlador.CursaControl;
import matricula.controlador.MatriculaControl;
import matricula.modelo.Cursa;
import matricula.modelo.Estado;
import matricula.modelo.Matricula;
import matricula.modelo.Modalidad;
import matricula.vista.tabla.ModeloTablaMatricula;
import usuarios.modelo.Estudiante;
import usuarios.vista.Menu;

/**
 *
 * @author darwi
 */
public class EstudianteMatricula extends javax.swing.JFrame {

    private ModeloTablaMatricula mtm = new ModeloTablaMatricula();
    private ModeloTablaMatricula mtmd = new ModeloTablaMatricula();
    private MatriculaControl matriculaControl = new MatriculaControl();
    private CursaControl cursaControl = new CursaControl();
    private Estudiante estudiante;
    private ModeloTablaMateria mtt = new ModeloTablaMateria();
    private ControlMateria materiaControl = new ControlMateria();

    public Boolean verificar() {
        return true;
    }

    private void cargarTabla() throws EmptyException {

        DynamicList<Matricula> matriculasFiltradas = new DynamicList<>();
;
        int id = estudiante.getMatriculas().getInfo(0).getId_Carrera();
        Modalidad md = estudiante.getMatriculas().getInfo(0).getModalidad();

        Matricula matriculaActual;

        for (int i = 0; i < matriculaControl.getListMatricula().getLength(); i++) {

            matriculaActual = matriculaControl.getListMatricula().getInfo(i);


            if (matriculaActual.getEstado() == Estado.DISPONIBLE && matriculaActual.getId_Carrera() == id && matriculaActual.getModalidad() == md) {
                matriculasFiltradas.add(matriculaActual);
                System.out.println("if");
            }
        }
        Date fecha;
        DynamicList<Matricula> matriculasDisponibles = new DynamicList<>();
        Matricula aux = new Matricula();
        Matricula matriculaDisponible = new Matricula();
        for (int i = 0; i < matriculasFiltradas.getLength(); i++) {
            System.out.println("for");
            matriculaDisponible = matriculasFiltradas.getInfo(i);
            System.out.println(matriculaDisponible.getFechaEmision());
            for (int j = 0; j < matriculasFiltradas.getLength(); j++) {
                aux = matriculasFiltradas.getInfo(j);
                System.out.println(aux.getFechaEmision());
                if (matriculaDisponible.getFechaEmision().compareTo(aux.getFechaEmision()) < 0) {
                    matriculaDisponible = aux;

                }
            }
        }
        matriculasDisponibles.add(matriculaDisponible);

        mtm.setMatriculas(estudiante.getMatriculas());
        mtmd.setMatriculas(matriculasDisponibles);

        tbMatriculasDisponibles.setModel(mtmd);
        tbMatricula.setModel(mtm);
        tbMaterias.setModel(mtt);
        tbMaterias.updateUI();
        tbMatricula.updateUI();
        tbMatriculasDisponibles.updateUI();
    }

    public void guardar(Integer filaSeleccionada, Cursa cursa) {
        if (verificar()) {
            if (cursaControl.marge(cursa, filaSeleccionada)) {
                JOptionPane.showMessageDialog(null, "Se ha matriculado con exito");
                cursaControl.setCursa(null);
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo guardar, hubo un error");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Falta llenar campos", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void modificarCursa(Integer filaSeleccionada) throws EmptyException {
        DynamicList<Matricula> matriculasFiltradas = new DynamicList<>();
        boolean asignado = false;
        for (int i = 0; i < matriculaControl.getListMatricula().getInfo(filaSeleccionada).getCursas().getLength(); i++) {
            Cursa cursaActual = matriculaControl.getListMatricula().getInfo(filaSeleccionada).getCursas().getInfo(i);
            if (cursaActual.getId_estudiante() == null && !asignado) {
                cursaControl.getCursa().setId(cursaControl.getListCursa().getInfo(i).getId());
                cursaControl.getCursa().setId_materia(cursaControl.getListCursa().getInfo(i).getId_materia());
                cursaControl.getCursa().setId_matricula(cursaControl.getListCursa().getInfo(i).getId_matricula());
                cursaControl.getCursa().setId_docente(cursaControl.getListCursa().getInfo(i).getId_docente());
                cursaControl.getCursa().setParalelo(cursaControl.getListCursa().getInfo(i).getParalelo());
                cursaControl.getCursa().setId_estudiante(cbxEstudiante.getSelectedIndex());
                asignado = true;
                if (cursaControl.marge(cursaControl.getCursa(), i)) {
                    JOptionPane.showMessageDialog(null, "Se ha matriculado con exito");
                    cursaControl.setCursa(null);
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo guardar, hubo un error");
                }

            }

        }

    }

    public EstudianteMatricula() throws EmptyException {
        initComponents();
        cargarTabla();
        this.setLocationRelativeTo(null);
        pnlFondo.setIcon(new ImageIcon("fotos/Azul.png"));
        pnlLogo.setIcon(new ImageIcon("fotos/unlLogo.png"));
    }

    public EstudianteMatricula(Estudiante usuario) throws EmptyException {
        initComponents();
        this.estudiante = usuario;
        cargarTabla();
        this.setLocationRelativeTo(null);
        pnlFondo.setIcon(new ImageIcon("fotos/Azul.png"));
        pnlLogo.setIcon(new ImageIcon("fotos/unlLogo.png"));
        System.out.println(estudiante.getNombre());

    }

    private DynamicList<Materia> obtenerMaterias(int fila) throws EmptyException {
        DynamicList<Materia> materias = new DynamicList<>();
        DynamicList<Cursa> cursas = estudiante.getMatriculas().getInfo(fila).getCursas();
        System.out.println("cursas ppp: " + cursas);
        Materia materiaActual = new Materia();
        Cursa cursaActual = new Cursa();
        
        for (int i = 0; i < materiaControl.getMateria().getLength(); i++) {
            materiaActual = materiaControl.getMateria().getInfo(i);
            int idMateria = materiaActual.getId();
            System.out.println("materia: " + materiaActual.getId());
            for (int j = 0; j < cursas.getLength(); j++) {
                cursaActual = cursas.getInfo(j);
                System.out.println("cursa: " + cursaActual.getId_materia());
                if (idMateria == cursaActual.getId_materia()) {
                    materias.add(materiaActual);
                    System.out.println("si");
                }
            }
        }
        return materias;
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFondo = new org.edisoncor.gui.panel.PanelImage();
        jLabel16 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        cbxEstudiante = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbMatricula = new javax.swing.JTable();
        pnlLogo = new org.edisoncor.gui.panel.PanelImage();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbMatriculasDisponibles = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbMaterias = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        btnIncio = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Criterio:");
        pnlFondo.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        pnlFondo.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 170, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Texto");
        pnlFondo.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, -1, -1));

        jButton1.setText("Ordenar");
        pnlFondo.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 540, -1, -1));

        cbxEstudiante.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        pnlFondo.add(cbxEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 120, 220, -1));

        jButton2.setText("Buscar");
        pnlFondo.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 540, -1, -1));

        tbMatricula.setModel(new javax.swing.table.DefaultTableModel(
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
        tbMatricula.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbMatriculaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbMatricula);

        pnlFondo.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 600, 110));
        pnlFondo.add(pnlLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 10, 320, 100));

        tbMatriculasDisponibles.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tbMatriculasDisponibles);

        pnlFondo.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, 600, 110));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Matriculas Disponibles");
        pnlFondo.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 360, -1, -1));

        jButton3.setText("Buscar");
        pnlFondo.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, -1, -1));

        jButton4.setText("Ordenar");
        pnlFondo.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 300, -1, -1));

        jButton5.setText("Ver Materias");
        pnlFondo.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 300, -1, -1));

        jButton6.setText("Matricularse");
        pnlFondo.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 300, -1, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Materias");
        pnlFondo.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 110, -1, -1));

        tbMaterias.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tbMaterias);

        pnlFondo.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 170, -1, 360));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Tus Matriculas");
        pnlFondo.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, -1, -1));

        getContentPane().add(pnlFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1180, 580));

        jMenu2.setText("Menu");

        btnIncio.setText("Inicio");
        btnIncio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncioActionPerformed(evt);
            }
        });
        jMenu2.add(btnIncio);

        jMenuItem2.setText("Salir");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIncioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncioActionPerformed
        new Menu(this.estudiante).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnIncioActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void tbMatriculaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMatriculaMouseClicked
        int filaSeleccionada = tbMatricula.rowAtPoint(evt.getPoint());
        System.out.println("hola");
        if (filaSeleccionada != -1) {
            try {
                System.out.println("try");
                DynamicList<Materia> materias = obtenerMaterias(filaSeleccionada);
                System.out.println("materias jeje: " + materias);
                mtt.setMaterias(materias);
                tbMaterias.setModel(mtt);
                tbMaterias.updateUI();
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, "No se puede cargar materias");
            }

        } else {
            JOptionPane.showConfirmDialog(null, "No ha seleccionado una matricula de la tabla tus matriculas", "ADVERTENCIA", JOptionPane.OK_CANCEL_OPTION);
    }//GEN-LAST:event_tbMatriculaMouseClicked
    }

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
            java.util.logging.Logger.getLogger(EstudianteMatricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EstudianteMatricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EstudianteMatricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EstudianteMatricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new EstudianteMatricula().setVisible(true);
                } catch (EmptyException ex) {
                    Logger.getLogger(EstudianteMatricula.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btnIncio;
    private javax.swing.JComboBox<String> cbxEstudiante;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private org.edisoncor.gui.panel.PanelImage pnlFondo;
    private org.edisoncor.gui.panel.PanelImage pnlLogo;
    private javax.swing.JTable tbMaterias;
    private javax.swing.JTable tbMatricula;
    private javax.swing.JTable tbMatriculasDisponibles;
    // End of variables declaration//GEN-END:variables
}
