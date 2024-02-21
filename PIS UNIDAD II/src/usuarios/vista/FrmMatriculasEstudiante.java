/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package usuarios.vista;

import exeption.EmptyException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import lista.DynamicList;
import matricula.modelo.Estado;
import matricula.modelo.Matricula;
import matricula.vista.GuardarCarrera;
import matricula.vista.GuardarCiclo;
import matricula.vista.GuardarCursa;
import matricula.vista.GuardarMalla;
import matricula.vista.GuardarMatricula;
import matricula.vista.GuardarPeriodoAcademico;
import matricula.vista.tabla.ModeloTablaMatricula;
import matricula.vista.util.UtilVistaEstado;
import usuarios.controlador.daoUsuario.EstudianteControlDao;
import usuarios.modelo.Docente;

/**
 *
 * @author darwin
 */
public class FrmMatriculasEstudiante extends javax.swing.JFrame {

    private Docente docente;
    private ModeloTablaMatricula mtm = new ModeloTablaMatricula();
    private EstudianteControlDao estudianteControl = new EstudianteControlDao();
    private int id;

    public FrmMatriculasEstudiante() {
        initComponents();
        pnlFondo.setIcon(new ImageIcon("fotos/Azul.png"));
        setLocationRelativeTo(null);
        UtilVistaEstado.cargarComboEstado(cbxEstado);
    }

    public FrmMatriculasEstudiante(Docente usuario, int fila) throws EmptyException {
        initComponents();
        pnlFondo.setIcon(new ImageIcon("fotos/Azul.png"));
        this.docente = usuario;
        setLocationRelativeTo(null);
        this.id = fila;
        cargarTabla();
        UtilVistaEstado.cargarComboEstado(cbxEstado);
    }

    private void cargarTabla() throws EmptyException {

        mtm.setMatriculas(estudianteControl.getListaEstudiante().getInfo(id).getMatriculas());
        tbMatricula.setModel(mtm);
        tbMatricula.updateUI();
        tbMatricula.setModel(mtm);
        tbMatricula.updateUI();
    }

    private DynamicList<Matricula> actulizarMatriculas(DynamicList<Matricula> matriculas, int idMatricula) throws EmptyException {
        System.out.println("actualizarMatricula");
        idMatricula++;
        System.out.println("IdMatricula: " + idMatricula);
        Matricula matriculaActual = new Matricula();
        DynamicList<Matricula> nuevaList = new DynamicList<>();
        for (int i = 0; i < matriculas.getLength(); i++) {
            matriculaActual = matriculas.getInfo(i);
            if (matriculaActual.getId() == idMatricula) { //sospecha
                System.out.println("matriculaActual id: " + matriculaActual.getId());
                System.out.println("break");
                break;
            }
        }

        switch (cbxEstado.getSelectedIndex()) {
            case 0:
                System.out.println("caso aporbed");
                matriculaActual.setEstado(Estado.APROBADO);
                break;
            case 1:
                System.out.println("ssssssssss");
                matriculaActual.setEstado(Estado.MATRICULADO);
                break;
            case 2:
                matriculaActual.setEstado(Estado.REPROBADO);
                break;
            case 3:
                matriculaActual.setEstado(Estado.DISPONIBLE);
                break;
            case 4:
                matriculaActual.setEstado(Estado.SOLICITADA);
                break;
            case 5:
                matriculaActual.setEstado(Estado.NO_DISPONIBLE);
                break;
        }

        System.out.println("matriculaActula id: " + matriculaActual.getId());
        System.out.println("*************");
        System.out.println(matriculas.getLength());
        DynamicList<Matricula> list = new DynamicList<>();
        Matricula m = new Matricula();
        for (int i = 0; i < matriculas.getLength(); i++) {
            m = matriculas.getInfo(i);
            if (m.getId() == matriculaActual.getId()) {
                System.out.println("if");
                list.add(matriculaActual);
            } else {
                System.out.println("else");
                list.add(m);
            }
        }
        //matriculas.extract(matriculaActual.getId());
        System.out.println("id-1: " + matriculaActual.getId());
        System.out.println("alsdlasdasd");
        System.out.println("matriculas extrac: " + matriculaActual);

        //matriculas.add(matriculaActual);
        return list;
    }

    private void modificar(int idMatricula) throws EmptyException {
        System.out.println("$$$$$$$$$$$$$$$$4");
        System.out.println("modificar");
        System.out.println("id: " + id);
        System.out.println("matriculas del estududiante: " + estudianteControl.getListaEstudiante().getInfo(id).getMatriculas());
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        DynamicList<Matricula> matriculas = actulizarMatriculas(estudianteControl.getListaEstudiante().getInfo(id).getMatriculas(), idMatricula);
        System.out.println("matriculas  " + matriculas);
        estudianteControl.getEstudiante().setApellido(estudianteControl.getListaEstudiante().getInfo(id).getApellido());
        estudianteControl.getEstudiante().setNombre(estudianteControl.getListaEstudiante().getInfo(id).getNombre());
        estudianteControl.getEstudiante().setCedula(estudianteControl.getListaEstudiante().getInfo(id).getCedula());
        estudianteControl.getEstudiante().setContraseniaUsuario(estudianteControl.getListaEstudiante().getInfo(id).getContraseniaUsuario());
        estudianteControl.getEstudiante().setCorreo(estudianteControl.getListaEstudiante().getInfo(id).getCorreo());
        estudianteControl.getEstudiante().setCorreoUsuario(estudianteControl.getListaEstudiante().getInfo(id).getCorreoUsuario());
        estudianteControl.getEstudiante().setEdad(estudianteControl.getListaEstudiante().getInfo(id).getEdad());
        estudianteControl.getEstudiante().setIdEstudiante(estudianteControl.getListaEstudiante().getInfo(id).getIdEstudiante());
        estudianteControl.getEstudiante().setMatriculas(matriculas);
        if (estudianteControl.marge(estudianteControl.getEstudiante(), id)) {
            System.out.println(":D");

        } else {
            System.out.println(":c");
        }

    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFondo = new org.edisoncor.gui.panel.PanelImage();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbMatricula = new javax.swing.JTable();
        cbxEstado = new javax.swing.JComboBox<>();
        btnCambiar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        btnIncio = new javax.swing.JMenuItem();
        btnSalir = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        btnAdmCarrera = new javax.swing.JMenuItem();
        btnAdmMalla = new javax.swing.JMenuItem();
        btnAdmCiclo = new javax.swing.JMenuItem();
        btnAdmCursa = new javax.swing.JMenuItem();
        btnAdmMatricula = new javax.swing.JMenuItem();
        btnAdmPeriodo = new javax.swing.JMenuItem();
        btnAdmDocente = new javax.swing.JMenuItem();
        btnAdmEstudiante = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jScrollPane1.setViewportView(tbMatricula);

        pnlFondo.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 650, 380));

        cbxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        pnlFondo.add(cbxEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 250, -1));

        btnCambiar.setText("Cambiar Estado");
        btnCambiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarActionPerformed(evt);
            }
        });
        pnlFondo.add(btnCambiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 580, 160, 30));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ESTADO MATRICULAS");
        pnlFondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, 403, 24));

        getContentPane().add(pnlFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -4, 1090, 660));

        jMenu2.setText("Menu");

        btnIncio.setText("Inicio");
        btnIncio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncioActionPerformed(evt);
            }
        });
        jMenu2.add(btnIncio);

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jMenu2.add(btnSalir);

        jMenuBar1.add(jMenu2);

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

        btnAdmDocente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/docente.png"))); // NOI18N
        btnAdmDocente.setText("Registro Docente");
        btnAdmDocente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdmDocenteActionPerformed(evt);
            }
        });
        jMenu1.add(btnAdmDocente);

        btnAdmEstudiante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/estudiante.png"))); // NOI18N
        btnAdmEstudiante.setText("Registro Estudiante");
        btnAdmEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdmEstudianteActionPerformed(evt);
            }
        });
        jMenu1.add(btnAdmEstudiante);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIncioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncioActionPerformed

        new Menu(this.docente).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnIncioActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        new LoginPrincipal().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnAdmCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdmCarreraActionPerformed
        try {
            new GuardarCarrera(this.docente).setVisible(true);
            this.dispose();
        } catch (EmptyException ex) {
            //            Logger.getLogger(GuardarFacultad.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    private void btnAdmDocenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdmDocenteActionPerformed
        new GestionDocente(this.docente).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAdmDocenteActionPerformed

    private void btnAdmEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdmEstudianteActionPerformed
        new GestionEstudiante(this.docente).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAdmEstudianteActionPerformed

    private void btnCambiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarActionPerformed
        int filaSeleccionada = tbMatricula.getSelectedRow();
        System.out.println("holaaaaaaaaaaa");
        System.out.println("fila: " + filaSeleccionada);
        if (filaSeleccionada != -1) {

            try {
                System.out.println("holas");
                modificar(filaSeleccionada);
                System.out.println("adios");
                cargarTabla();
                System.out.println("adio2");
            } catch (EmptyException ex) {
                JOptionPane.showConfirmDialog(null, "Ocurrio un problema");
            }

        } else {
            JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna matricula de la tabla", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCambiarActionPerformed

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
            java.util.logging.Logger.getLogger(FrmMatriculasEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMatriculasEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMatriculasEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMatriculasEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMatriculasEstudiante().setVisible(true);
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
    private javax.swing.JButton btnCambiar;
    private javax.swing.JMenuItem btnIncio;
    private javax.swing.JMenuItem btnSalir;
    private javax.swing.JComboBox<String> cbxEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private org.edisoncor.gui.panel.PanelImage pnlFondo;
    private javax.swing.JTable tbMatricula;
    // End of variables declaration//GEN-END:variables
}
