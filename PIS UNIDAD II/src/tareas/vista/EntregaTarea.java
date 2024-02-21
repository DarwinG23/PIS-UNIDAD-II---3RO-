/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tareas.vista;

import exeption.EmptyException;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import matricula.vista.EstudianteMatricula;
import matricula.vista.GuardarCiclo;
import tareas.controlador.controladorTarea.detalleTarea;
import tareas.controlador.controladorTarea.envioTarea;
import tareas.vista.modeloTabla.modeloTareaEstudiante;
import usuarios.modelo.Estudiante;
import usuarios.vista.LoginPrincipal;
import usuarios.vista.Menu;
    
 /*
 * @author ALEJANDRO
 */
public class EntregaTarea extends javax.swing.JFrame {
    private detalleTarea detalleTarea=new detalleTarea();
    private envioTarea controlEnvio=new envioTarea();
    modeloTareaEstudiante mte=new modeloTareaEstudiante();
    private Estudiante estudiante;
    
    /**
     * Creates new form TareaEstudiante
     */
   public EntregaTarea() {
        initComponents();
        this.setLocationRelativeTo(null);
        Limpiar();
        pnlAzul.setIcon(new ImageIcon("fotos/Azul.png"));
        pnlGris.setIcon(new ImageIcon("fotos/Celeste.jpg"));
    }

    public EntregaTarea(Estudiante estudiante) throws HeadlessException {
        this.estudiante = estudiante;
        initComponents();
        this.setLocationRelativeTo(null);
        Limpiar();
        this.estudiante = estudiante;
        pnlAzul.setIcon(new ImageIcon("fotos/Azul.png"));
        pnlGris.setIcon(new ImageIcon("fotos/Celeste.jpg"));
    }
    
    public void recibirDatosTarea(String tituloTarea, String descripcion){
        controlEnvio.getTareaEstudiante1().setTituloTarea(tituloTarea);
        txtTitulo.setText(controlEnvio.getTareaEstudiante1().getTituloTarea());
        controlEnvio.getTareaEstudiante1().setDescripcion(descripcion);
        txtDescripcion.setText(controlEnvio.getTareaEstudiante1().getDescripcion());
         
        
    }
    
    private void CargarTabla() {
        mte.setTarea(controlEnvio.getTareaEstudiante());
        tblMostrarDatos.setModel((TableModel) mte);
        tblMostrarDatos.updateUI();
    }
     private void Limpiar() {
         txtNombreTarea.setText(" ");
         txtLink.setText(" ");
        tblMostrarDatos.clearSelection();
        CargarTabla();
        controlEnvio.setTareaEstudiante1(null);
    }
     private Boolean Validar() {
        return (!txtTitulo.getText().trim().isEmpty()
                && !txtLink.getText().trim().isEmpty());
    }
    private void GuardarTarea(){
        detalleTarea.getTareaEstudiante1().setNombreArchivo(txtNombreTarea.getText());
        detalleTarea.getTareaEstudiante1().setLink(txtLink.getText());
        if (detalleTarea.persist()) {
                JOptionPane.showMessageDialog(null, "Datos guardados con exito");
                detalleTarea.setTareaEstudiante1(null);
                Limpiar();
                publicar();
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo guardar");
            }
    }
    private void Guardar() {
        
        if (Validar()) {          
            recibirDatosTarea(txtTitulo.getText(), txtLink.getText());
            if (controlEnvio.persist()) {
                JOptionPane.showMessageDialog(null, "Datos guardados con exito");
                controlEnvio.setTareaEstudiante1(null);
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
        int fila = tblMostrarDatos.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(null, "Escoja un registtro de la tabla");
        } else {
            try {
                controlEnvio.setTareaEstudiante1(mte.getTarea().getInfo(fila));
                txtTitulo.setText(controlEnvio.getTareaEstudiante1().getTituloTarea());
                txtDescripcion.setText(controlEnvio.getTareaEstudiante1().getDescripcion());
                
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }
    private void publicar() {
        EntregaTarea ea=new EntregaTarea();
        ea.recibirDatosTarea(txtNombreTarea.getText(), txtLink.getText());
        
    }
    
    
    

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlGris = new org.edisoncor.gui.panel.PanelImage();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMostrarDatos = new javax.swing.JTable();
        btnSeleccionar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        pnlAzul = new org.edisoncor.gui.panel.PanelImage();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtMateria = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtNombreTarea = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtLink = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        btnIncio1 = new javax.swing.JMenuItem();
        btnMatricula1 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        btnSalir1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlGris.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblMostrarDatos.setBackground(new java.awt.Color(255, 255, 255));
        tblMostrarDatos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tblMostrarDatos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblMostrarDatos);

        pnlGris.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 420, 260));

        btnSeleccionar.setText("SELECCIONAR");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });
        pnlGris.add(btnSeleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 380, 150, -1));

        btnEliminar.setText("ELIMINAR");
        pnlGris.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 490, 150, -1));

        btnModificar.setText("MODIFICAR");
        pnlGris.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 440, 150, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("TAREAS");
        pnlGris.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 140, -1));

        getContentPane().add(pnlGris, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, 450, 530));

        pnlAzul.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ENTREGA DE TAREAS");
        pnlAzul.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 360, -1));

        jLabel1.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Materia:");
        pnlAzul.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, -1, -1));

        txtMateria.setBackground(new java.awt.Color(255, 255, 204));
        txtMateria.setEnabled(false);
        txtMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMateriaActionPerformed(evt);
            }
        });
        pnlAzul.add(txtMateria, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, 250, -1));

        jLabel8.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Título  Tarea:");
        pnlAzul.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, -1, -1));

        txtTitulo.setBackground(new java.awt.Color(255, 255, 204));
        txtTitulo.setEnabled(false);
        pnlAzul.add(txtTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, 240, -1));

        jLabel7.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Descripción:");
        pnlAzul.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, -1, -1));

        txtDescripcion.setBackground(new java.awt.Color(255, 255, 204));
        txtDescripcion.setEnabled(false);
        pnlAzul.add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, 260, -1));

        jLabel10.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Nombre Archivo:");
        pnlAzul.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, -1, -1));

        txtNombreTarea.setBackground(new java.awt.Color(255, 255, 204));
        pnlAzul.add(txtNombreTarea, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 380, 270, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Link de tarea:");
        pnlAzul.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, -1, -1));

        txtLink.setBackground(new java.awt.Color(255, 255, 204));
        pnlAzul.add(txtLink, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 460, 270, -1));

        getContentPane().add(pnlAzul, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 530));

        jMenu3.setText("Menu");
        jMenu3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        btnIncio1.setText("Inicio");
        btnIncio1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncio1ActionPerformed(evt);
            }
        });
        jMenu3.add(btnIncio1);

        btnMatricula1.setText("Matriculas");
        btnMatricula1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMatricula1ActionPerformed(evt);
            }
        });
        jMenu3.add(btnMatricula1);

        jMenuItem4.setText("Enviar Tarea");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuItem6.setText("Reporte Califiacion");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem6);

        btnSalir1.setText("Salir");
        btnSalir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir1ActionPerformed(evt);
            }
        });
        jMenu3.add(btnSalir1);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMateriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMateriaActionPerformed

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        cargarVista();
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void btnIncio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncio1ActionPerformed
       new Menu(this.estudiante).setVisible(true);
       this.dispose();
    }//GEN-LAST:event_btnIncio1ActionPerformed

    private void btnMatricula1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMatricula1ActionPerformed
        try {
            new EstudianteMatricula(this.estudiante).setVisible(true);
            this.dispose();
        } catch (EmptyException ex) {
            java.util.logging.Logger.getLogger(GuardarCiclo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnMatricula1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        EntregaTarea et=new EntregaTarea(this.estudiante);
        this.dispose();
        et.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        ReporteNotas rp=new ReporteNotas(this.estudiante);
        this.dispose();
        rp.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void btnSalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir1ActionPerformed
        new LoginPrincipal().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSalir1ActionPerformed

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
            java.util.logging.Logger.getLogger(EntregaTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EntregaTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EntregaTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EntregaTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EntregaTarea().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JMenuItem btnIncio1;
    private javax.swing.JMenuItem btnMatricula1;
    private javax.swing.JButton btnModificar;
    private javax.swing.JMenuItem btnSalir1;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JScrollPane jScrollPane1;
    private org.edisoncor.gui.panel.PanelImage pnlAzul;
    private org.edisoncor.gui.panel.PanelImage pnlGris;
    private javax.swing.JTable tblMostrarDatos;
    public static javax.swing.JTextField txtDescripcion;
    public static javax.swing.JTextField txtLink;
    public static javax.swing.JTextField txtMateria;
    public static javax.swing.JTextField txtNombreTarea;
    public static javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables

}
