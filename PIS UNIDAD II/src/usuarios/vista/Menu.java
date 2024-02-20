/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package usuarios.vista;

import exeption.EmptyException;
import java.awt.FontMetrics;
import java.awt.HeadlessException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import lista.DynamicList;
import materias.vista.FrmMateria;
import matricula.vista.EstudianteMatricula;
import matricula.vista.GuardarCarrera;
import matricula.vista.GuardarCiclo;
import matricula.vista.GuardarCursa;
import matricula.vista.GuardarMalla;
import matricula.vista.GuardarMatricula;
import matricula.vista.GuardarPeriodoAcademico;
import org.edisoncor.gui.panel.PanelImage;
import tareas.vista.CalificarTarea;
import tareas.vista.EntregaTarea;
import tareas.vista.ReporteNotas;
import tareas.vista.TareaDocente;
import usuarios.controlador.daoUsuario.RegistroControl1;
import usuarios.modelo.Docente;
import usuarios.modelo.Estudiante;
import usuarios.modelo.Registro;
import usuarios.modelo.Persona;

/**
 *
 * @author Alexander
 */
public class Menu extends javax.swing.JFrame {

    RegistroControl1 registroDao = new RegistroControl1();
    Estudiante estudiante;
    Docente docente;

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
        Fondo3.setIcon(new ImageIcon("fotos/MenuInicio.jpg"));
        this.setLocationRelativeTo(null);
//        asignarNombre();
    }

    public Menu(Estudiante usuario) {
        initComponents();
        Fondo3.setIcon(new ImageIcon("fotos/MenuInicio.jpg"));
        this.setLocationRelativeTo(null);
        this.estudiante = usuario;
        txtNombre.setText(estudiante.getNombre().toUpperCase() + " " + estudiante.getApellido().toUpperCase());

        btnAdmMenu.setEnabled(false);
        btnAdmMenu.setVisible(false);
        btnDoCreaTarea.setEnabled(false);
        btnDoCreaTarea.setVisible(false);
        btnDocCalifTarea.setEnabled(false);
        btnDocCalifTarea.setVisible(false);
//        asignarNombre();
    }

    public Menu(Docente usuario) {
        initComponents();
        Fondo3.setIcon(new ImageIcon("fotos/MenuInicio.jpg"));
        this.setLocationRelativeTo(null);
        this.docente = usuario;
        txtNombre.setText(docente.getNombre().toUpperCase() + " " + docente.getApellido().toUpperCase());
        if (usuario.getRolDocente().equalsIgnoreCase("Docente")) {
            btnAdmMenu.setEnabled(false);
            btnAdmMenu.setVisible(false);
            btnEstMatriculas.setEnabled(false);
            btnEstNota.setEnabled(false);
            btnEstMatriculas.setVisible(false);
            btnEstNota.setVisible(false);
        }else{
            btnEstMatriculas.setEnabled(false);
            btnEstNota.setEnabled(false);
            btnEstMatriculas.setVisible(false);
            btnEstNota.setVisible(false);
        
        }
        
//        asignarNombre();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Fondo3 = new org.edisoncor.gui.panel.PanelImage();
        txtNombre = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        btnMenu = new javax.swing.JMenu();
        btnEstMatriculas = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        btnEstNota = new javax.swing.JMenuItem();
        btnDoCreaTarea = new javax.swing.JMenuItem();
        btnDocCalifTarea = new javax.swing.JMenuItem();
        btnSalir = new javax.swing.JMenuItem();
        btnAdmMenu = new javax.swing.JMenu();
        btnAdmCarrera = new javax.swing.JMenuItem();
        btnAdmMalla = new javax.swing.JMenuItem();
        btnAdmCiclo = new javax.swing.JMenuItem();
        btnAdmCursa = new javax.swing.JMenuItem();
        btnAdmMatricula = new javax.swing.JMenuItem();
        btnAdmMateria = new javax.swing.JMenuItem();
        btnAdmPeriodo = new javax.swing.JMenuItem();
        btnAdmEstudiante = new javax.swing.JMenuItem();
        btnAdmDocente = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Fondo3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNombre.setBackground(new java.awt.Color(153, 153, 255));
        txtNombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(255, 102, 51));
        txtNombre.setText("NOMBRE APELLIDO");
        Fondo3.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 550, 270, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/usuario.png"))); // NOI18N
        Fondo3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 520, 60, 60));

        getContentPane().add(Fondo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, 580));

        btnMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/casa.png"))); // NOI18N
        btnMenu.setText("Inicio");
        btnMenu.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        btnEstMatriculas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/credencial.png"))); // NOI18N
        btnEstMatriculas.setText("Matriculas");
        btnEstMatriculas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstMatriculasActionPerformed(evt);
            }
        });
        btnMenu.add(btnEstMatriculas);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/carpeta.png"))); // NOI18N
        jMenuItem3.setText("Tarea");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        btnMenu.add(jMenuItem3);

        btnEstNota.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/estrella.png"))); // NOI18N
        btnEstNota.setText("Calificaciones");
        btnEstNota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstNotaActionPerformed(evt);
            }
        });
        btnMenu.add(btnEstNota);

        btnDoCreaTarea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/documento.png"))); // NOI18N
        btnDoCreaTarea.setText("Crear Tarea");
        btnDoCreaTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoCreaTareaActionPerformed(evt);
            }
        });
        btnMenu.add(btnDoCreaTarea);

        btnDocCalifTarea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/notas.png"))); // NOI18N
        btnDocCalifTarea.setText("Calificar Tarea");
        btnDocCalifTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDocCalifTareaActionPerformed(evt);
            }
        });
        btnMenu.add(btnDocCalifTarea);

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/puerta.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        btnMenu.add(btnSalir);

        jMenuBar1.add(btnMenu);

        btnAdmMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/herramientas.png"))); // NOI18N
        btnAdmMenu.setText("Administración");

        btnAdmCarrera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/carrera.png"))); // NOI18N
        btnAdmCarrera.setText("Carrera");
        btnAdmCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdmCarreraActionPerformed(evt);
            }
        });
        btnAdmMenu.add(btnAdmCarrera);

        btnAdmMalla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/malla.png"))); // NOI18N
        btnAdmMalla.setText("Malla");
        btnAdmMalla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdmMallaActionPerformed(evt);
            }
        });
        btnAdmMenu.add(btnAdmMalla);

        btnAdmCiclo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/ciclo.png"))); // NOI18N
        btnAdmCiclo.setText("Ciclo");
        btnAdmCiclo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdmCicloActionPerformed(evt);
            }
        });
        btnAdmMenu.add(btnAdmCiclo);

        btnAdmCursa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cursa.png"))); // NOI18N
        btnAdmCursa.setText("Cursa");
        btnAdmCursa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdmCursaActionPerformed(evt);
            }
        });
        btnAdmMenu.add(btnAdmCursa);

        btnAdmMatricula.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/matricula.png"))); // NOI18N
        btnAdmMatricula.setText("Matricula");
        btnAdmMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdmMatriculaActionPerformed(evt);
            }
        });
        btnAdmMenu.add(btnAdmMatricula);

        btnAdmMateria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/materias.png"))); // NOI18N
        btnAdmMateria.setText("Materias");
        btnAdmMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdmMateriaActionPerformed(evt);
            }
        });
        btnAdmMenu.add(btnAdmMateria);

        btnAdmPeriodo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/periodo.png"))); // NOI18N
        btnAdmPeriodo.setText("Periodo Académico");
        btnAdmPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdmPeriodoActionPerformed(evt);
            }
        });
        btnAdmMenu.add(btnAdmPeriodo);

        btnAdmEstudiante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/estudiante.png"))); // NOI18N
        btnAdmEstudiante.setText("Registro Estudiante");
        btnAdmEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdmEstudianteActionPerformed(evt);
            }
        });
        btnAdmMenu.add(btnAdmEstudiante);

        btnAdmDocente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/docente.png"))); // NOI18N
        btnAdmDocente.setText("Registro Docente");
        btnAdmDocente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdmDocenteActionPerformed(evt);
            }
        });
        btnAdmMenu.add(btnAdmDocente);

        jMenuBar1.add(btnAdmMenu);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEstMatriculasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstMatriculasActionPerformed
        try {
            new EstudianteMatricula(this.estudiante).setVisible(true);
            this.dispose();
        } catch (EmptyException ex) {
            java.util.logging.Logger.getLogger(GuardarCiclo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEstMatriculasActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        new LoginPrincipal().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        EntregaTarea et = new EntregaTarea(this.estudiante);
        this.dispose();
        et.setVisible(true);

    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void btnEstNotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstNotaActionPerformed
        ReporteNotas rp = new ReporteNotas(this.estudiante);
        this.dispose();
        rp.setVisible(true);

    }//GEN-LAST:event_btnEstNotaActionPerformed

    private void btnAdmCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdmCarreraActionPerformed
        try {
            new GuardarCarrera(this.docente).setVisible(true);
        } catch (EmptyException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
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

    private void btnAdmMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdmMateriaActionPerformed
        new FrmMateria(this.docente).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAdmMateriaActionPerformed

    private void btnDoCreaTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoCreaTareaActionPerformed
        TareaDocente td = new TareaDocente(this.docente);
        this.dispose();
        td.setVisible(true);
    }//GEN-LAST:event_btnDoCreaTareaActionPerformed

    private void btnDocCalifTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDocCalifTareaActionPerformed

        CalificarTarea cf = new CalificarTarea(this.docente);
        this.dispose();
        cf.setVisible(true);
    }//GEN-LAST:event_btnDocCalifTareaActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.panel.PanelImage Fondo3;
    private javax.swing.JMenuItem btnAdmCarrera;
    private javax.swing.JMenuItem btnAdmCiclo;
    private javax.swing.JMenuItem btnAdmCursa;
    private javax.swing.JMenuItem btnAdmDocente;
    private javax.swing.JMenuItem btnAdmEstudiante;
    private javax.swing.JMenuItem btnAdmMalla;
    private javax.swing.JMenuItem btnAdmMateria;
    private javax.swing.JMenuItem btnAdmMatricula;
    private javax.swing.JMenu btnAdmMenu;
    private javax.swing.JMenuItem btnAdmPeriodo;
    private javax.swing.JMenuItem btnDoCreaTarea;
    private javax.swing.JMenuItem btnDocCalifTarea;
    private javax.swing.JMenuItem btnEstMatriculas;
    private javax.swing.JMenuItem btnEstNota;
    private javax.swing.JMenu btnMenu;
    private javax.swing.JMenuItem btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JLabel txtNombre;
    // End of variables declaration//GEN-END:variables
}
