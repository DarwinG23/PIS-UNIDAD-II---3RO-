/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package usuarios.vista;

import exeption.EmptyException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import lista.DynamicList;
import materias.modelo.Materia;
import matricula.controlador.CicloControl;
import matricula.controlador.CursaControl;
import matricula.controlador.MallaControl;
import matricula.controlador.MatriculaControl;
import matricula.modelo.Ciclo;
import matricula.modelo.Cursa;
import matricula.modelo.Estado;
import matricula.modelo.Malla;
import matricula.modelo.Matricula;
import matricula.vista.EstudianteMatricula;
import matricula.vista.GuardarCarrera;
import matricula.vista.GuardarCiclo;
import matricula.vista.GuardarCursa;
import matricula.vista.GuardarMalla;
import matricula.vista.GuardarMatricula;
import matricula.vista.GuardarPeriodoAcademico;
import matricula.vista.util.UtilVistaCarrera;
import matricula.vista.util.UtilVistaMatricula;
import matricula.vista.util.UtilVistaModalidad;
import tareas.controlador.administrarTarea;
import usuarios.controlador.daoUsuario.EstudianteControlDao;
import usuarios.controlador.util.Util;
import usuarios.modelo.Docente;
import usuarios.modelo.Persona;
import vista.modelo.ModeloTablaEstudiante;

/**
 *
 * @author Alexander
 */
public class GestionEstudiante extends javax.swing.JFrame {

    private ModeloTablaEstudiante mta = new ModeloTablaEstudiante();
    private EstudianteControlDao estudianteControl = new EstudianteControlDao();
    private Docente docente;
    private Util util = new Util();

    private MatriculaControl mc = new MatriculaControl();
    private CursaControl cc = new CursaControl();
    private administrarTarea at = new administrarTarea();
    private CicloControl cicloC = new CicloControl();
    private MallaControl mallaC = new MallaControl();

    /**
     * Creates new form GestionEstudiante
     */
    public GestionEstudiante() throws EmptyException {
        initComponents();
        this.setLocationRelativeTo(null);
        Fondo2.setIcon(new ImageIcon("fotos/Azul.png"));
        Limpiar();
        try {
            UtilVistaCarrera.cargarcomboCarrera(cbxCarrera);
            UtilVistaModalidad.cargarComboModalidad(cbxModalidad);
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Necesita crear matriculas para registrar un estudiante");
        }
        //System.out.println(estudianteControl.getListaEstudiante().getInfo(0).getMatriculas());
    }

    public GestionEstudiante(Docente usuario) {
        initComponents();
        this.setLocationRelativeTo(null);
        Fondo2.setIcon(new ImageIcon("fotos/Azul.png"));
        Limpiar();
        this.docente = usuario;
        try {
            UtilVistaCarrera.cargarcomboCarrera(cbxCarrera);
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Necesita crear matriculas para registrar un estudiante");
        }
    }

    private void CargarTabla() {
        mta.setEstudianteTabla(estudianteControl.getListaEstudiante());
        tblMostrar.setModel((TableModel) mta);
        tblMostrar.updateUI();
    }

    private void Limpiar() {

//        txtPeriodo.setEnabled(false);
        tblMostrar.clearSelection();
        txtNombre.setText("");
        txtCedula.setText("");
        txtEdad.setText("");
        txtApellido.setText("");
        txtCorreo.setText("");
//        txtPeriodo.setText("");
        txtUsuario.setText("");
        txtContrasenia.setText("");
        CargarTabla();
        estudianteControl.setEstudiante(null);

    }

    private Boolean Validar() {
        return (!txtApellido.getText().trim().isEmpty()
                && !txtNombre.getText().trim().isEmpty()
                && !txtCorreo.getText().trim().isEmpty()
                && !txtEdad.getText().trim().isEmpty()
                && !txtCedula.getText().trim().isEmpty()
                && !txtUsuario.getText().trim().isEmpty()
                && !txtContrasenia.getText().trim().isEmpty());
    }

    private String generarCorreo() {
        String nombre = txtNombre.getText().trim();
        String apellido = txtApellido.getText().trim();
        String primerNombre = "";
        String primerApellido = "";

        if (!nombre.isEmpty()) {
            primerNombre = nombre.contains(" ") ? nombre.substring(0, nombre.indexOf(" ")) : nombre;
        }

        if (!apellido.isEmpty()) {
            primerApellido = apellido.contains(" ") ? apellido.substring(0, apellido.indexOf(" ")) : apellido;
        }
        String correo = primerNombre.toLowerCase() + "." + primerApellido.toLowerCase() + "@unl.edu.ec";

        return correo;
    }

    private void Guardar() throws EmptyException {
        if (Validar()) {

            //Persona uc = new Persona();
            if (util.validadorDeCedula(txtCedula.getText())) {
                Matricula matricula = matricular();
                if (matricula == null) {
                    JOptionPane.showMessageDialog(null, "No hay matriculas disponible");
                } else {

                    estudianteControl.getEstudiante().setCedula(txtCedula.getText());
                    estudianteControl.getEstudiante().setNombre(txtNombre.getText());
                    estudianteControl.getEstudiante().setApellido(txtApellido.getText());
                    estudianteControl.getEstudiante().setEdad(txtEdad.getText());
                    estudianteControl.getEstudiante().setCorreo(txtCorreo.getText());

                    estudianteControl.getEstudiante().getMatriculas().add(matricula);
                    estudianteControl.getEstudiante().setMatriculas(estudianteControl.getEstudiante().getMatriculas());

                    estudianteControl.getEstudiante().setCorreoUsuario(txtUsuario.getText());

                    estudianteControl.getEstudiante().setContraseniaUsuario(txtContrasenia.getText());

                    if (estudianteControl.Persist()) {
                        DynamicList<Cursa> cursas = obtenerMaterias();
                        if (agregarCursas(cursas)) {
                            estudianteControl.setEstudiante(null);
                            CargarTabla();
                            Limpiar();
                            JOptionPane.showMessageDialog(null, "Datos guardados con exito");

                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo guardar");
                    }

                }
            } else {
                JOptionPane.showMessageDialog(null, "La cedula no es valida ");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Falta llenar campos ");

        }
    }

    private Boolean agregarCursas(DynamicList<Cursa> cursas) throws EmptyException {
        Integer id = estudianteControl.getListaEstudiante().getInfo(estudianteControl.getListaEstudiante().getLength() - 1).getIdEstudiante();
        Matricula matricula = estudianteControl.getListaEstudiante().getInfo(id - 1).getMatriculas().getInfo(0);
        matricula.setCursas(cursas);
        DynamicList<Matricula> matriculas = new DynamicList<>();
        matriculas.add(matricula);

        estudianteControl.getEstudiante().setCedula(estudianteControl.getListaEstudiante().getInfo(id - 1).getCedula());
        estudianteControl.getEstudiante().setNombre(estudianteControl.getListaEstudiante().getInfo(id - 1).getNombre());
        estudianteControl.getEstudiante().setApellido(estudianteControl.getListaEstudiante().getInfo(id - 1).getApellido());
        estudianteControl.getEstudiante().setEdad(estudianteControl.getListaEstudiante().getInfo(id - 1).getEdad());
        estudianteControl.getEstudiante().setCorreo(estudianteControl.getListaEstudiante().getInfo(id - 1).getCorreo());

        estudianteControl.getEstudiante().setCorreoUsuario(estudianteControl.getListaEstudiante().getInfo(id - 1).getCorreoUsuario());
        estudianteControl.getEstudiante().setContraseniaUsuario(estudianteControl.getListaEstudiante().getInfo(id - 1).getContraseniaUsuario());
        estudianteControl.getEstudiante().setMatriculas(matriculas);

        if (estudianteControl.marge(estudianteControl.getEstudiante(), id - 1)) {
            return true;

        } else {
            return false;
        }
    }

    private DynamicList<Cursa> obtenerMaterias() throws EmptyException {
        Ciclo cicloActual = new Ciclo();
        Malla mallaActual = new Malla();
        Integer id_malla = 0;

        for (int i = 0; i < mallaC.getListMalla().getLength(); i++) {
            mallaActual = mallaC.getListMalla().getInfo(i);
            if (mallaActual.getId_Carrera() == cbxCarrera.getSelectedIndex() + 1) {
                id_malla = mallaActual.getId_Carrera();
                System.out.println("break id malla: " + id_malla);
                break;
            }
        }

        DynamicList<Cursa> cursas = new DynamicList<>();

        for (int i = 0; i < cicloC.getListCiclo().getLength(); i++) {
            cicloActual = cicloC.getListCiclo().getInfo(i);
            int id_malla_CicloActual = cicloActual.getId_Malla();
            if (id_malla_CicloActual == id_malla && cicloActual.getNumCiclo() == 1) {
                break;
            }
        }

        for (int k = 0; k < cicloActual.getMaterias().getLength(); k++) {
            Cursa cs = crearCursa(k, cicloActual.getMaterias().getInfo(k).getId());
            cursas.add(cs);
        }
        return cursas;

    }

    private Cursa crearCursa(Integer id, Integer id_Materia) throws EmptyException {
        Cursa cursa = new Cursa();
        cursa.setId(id + 1);
        cursa.setId_matricula(1);
        cursa.setId_materia(id_Materia);
        cursa.setParalelo("A");
        cursa.setId_docente(0);
        cursa.setId_estudiante(estudianteControl.getListaEstudiante().getInfo(estudianteControl.getListaEstudiante().getLength() - 1).getIdEstudiante());
        return cursa;

    }

    private Matricula matricular() throws EmptyException {
        Matricula matriculaActual = new Matricula();
        DynamicList<Matricula> list = new DynamicList<>();
        Matricula matriculaDisponible = new Matricula();
        Date fecha = new Date();

        for (int i = 0; i < mc.getListMatricula().getLength(); i++) {
            matriculaActual = mc.getListMatricula().getInfo(i);
            if (matriculaActual.getId_Carrera() == cbxCarrera.getSelectedIndex() + 1 && matriculaActual.getEstado() == Estado.DISPONIBLE && matriculaActual.getModalidad() == cbxModalidad.getSelectedItem()) {
                list.add(mc.getListMatricula().getInfo(i));

            }
        }

        Matricula aux = new Matricula();
        for (int i = 0; i < list.getLength(); i++) {
            matriculaDisponible = list.getInfo(i);
            for (int j = 0; j < list.getLength(); j++) {
                aux = list.getInfo(j);
                if (matriculaDisponible.getFechaEmision().compareTo(aux.getFechaEmision()) < 0) {
                    matriculaDisponible = aux;
                }
            }
        }
        matriculaDisponible.setEstado(Estado.MATRICULADO);
        matriculaDisponible.setId(1);
        return matriculaDisponible;
    }

    private void cargarVista() {
        int fila = tblMostrar.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(null, "Escoja un registro de la tabla");
        } else {
            try {
                estudianteControl.setEstudiante(mta.getEstudianteTabla().getInfo(fila));
                txtNombre.setText(estudianteControl.getEstudiante().getNombre());
                txtApellido.setText(estudianteControl.getEstudiante().getApellido());
                txtEdad.setText(estudianteControl.getEstudiante().getEdad());
                txtCedula.setText(estudianteControl.getEstudiante().getCedula());
                txtCorreo.setText(estudianteControl.getEstudiante().getCorreo());
//                txtPeriodo.setText(estudianteControl.getEstudiante().getPromedioAcademico());
                txtUsuario.setText(estudianteControl.getEstudiante().getCorreoUsuario());
                txtContrasenia.setText(estudianteControl.getEstudiante().getContraseniaUsuario());

            } catch (Exception e) {
                System.out.println("Error seleccione una fila primero");
            }

        }
    }

    private void ordenar() {
        String criterio = cbxCriterio1.getSelectedItem().toString().toLowerCase();
        Integer tipo = 0;
        if (cbxMetodo.isSelected()) {
            tipo = 1;
        }
        try {
            System.out.println("QuickSort");
            mta.setEstudianteTabla(estudianteControl.ordenarQuickSort(estudianteControl.all(), tipo, criterio));
            tblMostrar.setModel(mta);
            tblMostrar.updateUI();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void buscar() {
        String texto = txtBuscar.getText();
        String criterio = cbxCriterio1.getSelectedItem().toString();
        if (cbxMetodo1.getSelectedItem().toString() == "Busqueda_Binaria") {
            try {
                System.out.println("Busqueda_Binaria");
                mta.setEstudianteTabla(estudianteControl.all());
                mta.setEstudianteTabla(estudianteControl.busquedaBinaria(texto, mta.getEstudianteTabla(), criterio));
                tblMostrar.setModel(mta);
                tblMostrar.updateUI();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } else if (cbxMetodo1.getSelectedItem().toString() == "Busqueda_Lineal") {
            try {
                System.out.println("Busqueda Lineal");
                mta.setEstudianteTabla(estudianteControl.all());
                mta.setEstudianteTabla(estudianteControl.buscarPorCriterioLineal(texto, mta.getEstudianteTabla(), criterio));
                tblMostrar.setModel(mta);
                tblMostrar.updateUI();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        PN = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtEdad = new javax.swing.JTextField();
        txtCedula = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblMostrar = new javax.swing.JTable();
        cbxCriterio = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        cbxMetodo1 = new javax.swing.JComboBox<>();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        cbxCarrera = new javax.swing.JComboBox<>();
        txtContrasenia = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btnMatriculas = new javax.swing.JButton();
        Fondo2 = new org.edisoncor.gui.panel.PanelImage();
        cbxCriterio1 = new javax.swing.JComboBox<>();
        btnOrdenar = new javax.swing.JButton();
        cbxMetodo = new javax.swing.JCheckBox();
        btnSeleccionar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        cbxModalidad = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
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

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PN.setBackground(new java.awt.Color(0, 0, 51));
        PN.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("REGISTRO DEL ESTUDIANTE");
        PN.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 10, 670, -1));

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre:");
        PN.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Apellido:");
        PN.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Edad:");
        PN.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Cedula:");
        PN.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        PN.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 290, -1));
        PN.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 290, -1));

        txtEdad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEdadActionPerformed(evt);
            }
        });
        PN.add(txtEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 90, -1));
        PN.add(txtCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 290, -1));
        PN.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 290, -1));

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
        tblMostrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMostrarMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblMostrar);

        PN.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 180, 610, 460));

        cbxCriterio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "nombre", "apellido", "cedula", "edad", "correo", "promedioAcademico" }));
        PN.add(cbxCriterio, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 60, 260, -1));

        jLabel9.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Buscar:");
        PN.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 60, -1, -1));

        cbxMetodo1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Busqueda_Lineal", "Busqueda_Binaria" }));
        PN.add(cbxMetodo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 60, 150, -1));
        PN.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 120, 260, 30));

        btnBuscar.setBackground(new java.awt.Color(0, 0, 51));
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        PN.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 120, 110, 30));

        jLabel10.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Correo:");
        PN.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));

        jLabel11.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Usuario:");
        PN.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));

        txtUsuario.setEditable(false);
        PN.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 290, -1));

        jButton1.setText("GENERAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        PN.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 260, -1, -1));

        cbxCarrera.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        PN.add(cbxCarrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, 290, -1));

        txtContrasenia.setEditable(false);
        PN.add(txtContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, 290, -1));

        jLabel12.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Contraseña:");
        PN.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, -1));

        jLabel13.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Contraseña:");
        PN.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, -1));

        btnMatriculas.setText("Matriculas");
        btnMatriculas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMatriculasActionPerformed(evt);
            }
        });
        PN.add(btnMatriculas, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 500, 120, 30));

        Fondo2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbxCriterio1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "nombre", "apellido", "cedula", "edad", "correo", "promedioAcademico" }));
        Fondo2.add(cbxCriterio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 450, 160, -1));

        btnOrdenar.setBackground(new java.awt.Color(0, 0, 51));
        btnOrdenar.setForeground(new java.awt.Color(255, 255, 255));
        btnOrdenar.setText("ORDENAR");
        btnOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenarActionPerformed(evt);
            }
        });
        Fondo2.add(btnOrdenar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 490, 120, -1));

        cbxMetodo.setBackground(new java.awt.Color(255, 255, 255));
        cbxMetodo.setForeground(new java.awt.Color(255, 255, 255));
        cbxMetodo.setText("DESCENDENTE");
        Fondo2.add(cbxMetodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 450, -1, -1));

        btnSeleccionar.setBackground(new java.awt.Color(0, 0, 51));
        btnSeleccionar.setForeground(new java.awt.Color(255, 255, 255));
        btnSeleccionar.setText("SELECCIONAR DATOS");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });
        Fondo2.add(btnSeleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 420, 160, -1));

        btnModificar.setBackground(new java.awt.Color(0, 0, 51));
        btnModificar.setForeground(new java.awt.Color(255, 255, 255));
        btnModificar.setText("MODIFICAR DATOS");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        Fondo2.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 420, 160, -1));

        btnGuardar.setBackground(new java.awt.Color(0, 0, 51));
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("GUARDAR DATOS");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        Fondo2.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, -1, -1));

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Modalidad:");
        Fondo2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, -1, -1));

        cbxModalidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Fondo2.add(cbxModalidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 380, 290, -1));

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Ordenar:");
        Fondo2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, 100, -1));

        PN.add(Fondo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 1410, 700));

        jLabel14.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Matricula:");
        PN.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, -1, -1));

        getContentPane().add(PN, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, 690));

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

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            Guardar();
        } catch (EmptyException ex) {
            JOptionPane.showConfirmDialog(null, "No se pudo guardar");
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        cargarVista();
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed

        if (Validar()) {
//            Persona uc = new Persona();
//            uc.setCedula(txtCedula.getText());
//            uc.setNombre(txtNombre.getText());
//            uc.setApellido(txtApellido.getText());
//            uc.setEdad(txtEdad.getText());
//            uc.setCorreo(txtCorreo.getText());

            estudianteControl.getEstudiante().setCedula(txtCedula.getText());
            estudianteControl.getEstudiante().setNombre(txtNombre.getText());
            estudianteControl.getEstudiante().setApellido(txtApellido.getText());
            estudianteControl.getEstudiante().setEdad(txtEdad.getText());
            estudianteControl.getEstudiante().setCorreo(txtCorreo.getText());

            // estudianteControl.getEstudiante().setDatosUsuario(uc);
//            estudianteControl.getEstudiante().setPromedioAcademico(txtPeriodo.getText());
            estudianteControl.getEstudiante().setCorreoUsuario(txtUsuario.getText());
//            char[] contrase = txtContrasenia.getPassword();
//            String contrasena = new String(contrase);
            estudianteControl.getEstudiante().setContraseniaUsuario(txtContrasenia.getText());

            if (estudianteControl.marge(estudianteControl.getEstudiante(), tblMostrar.getSelectedRow())) {
                JOptionPane.showMessageDialog(null, "Datos guardados con exito");
                estudianteControl.setEstudiante(null);
                CargarTabla();
                Limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo guardar");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Falta llenar campos ");
        }

    }//GEN-LAST:event_btnModificarActionPerformed

    private void txtEdadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEdadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEdadActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void btnOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenarActionPerformed
        ordenar();
    }//GEN-LAST:event_btnOrdenarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscar();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void tblMostrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMostrarMouseClicked
        cargarVista();
    }//GEN-LAST:event_tblMostrarMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        txtUsuario.setText(generarCorreo());
        txtContrasenia.setText(txtCedula.getText());
    }//GEN-LAST:event_jButton1ActionPerformed

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

    private void btnIncioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncioActionPerformed

        new Menu(this.docente).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnIncioActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        new LoginPrincipal().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnMatriculasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMatriculasActionPerformed
        int filaSeleccionada = tblMostrar.getSelectedRow();
        if (filaSeleccionada != -1) {
            try {
                new FrmMatriculasEstudiante(this.docente, filaSeleccionada).setVisible(true);
            } catch (EmptyException ex) {
                JOptionPane.showConfirmDialog(null, "Error al intentar ver las matriculas");
            }
            this.dispose();
        } else {
            JOptionPane.showConfirmDialog(null, "No ha seleccionado un estudiante de la tabla", "ADVERTENCIA", JOptionPane.OK_CANCEL_OPTION);
        }
    }//GEN-LAST:event_btnMatriculasActionPerformed

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
            java.util.logging.Logger.getLogger(GestionEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new GestionEstudiante().setVisible(true);
                } catch (EmptyException ex) {
                    Logger.getLogger(GestionEstudiante.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.panel.PanelImage Fondo2;
    private javax.swing.JPanel PN;
    private javax.swing.JMenuItem btnAdmCarrera;
    private javax.swing.JMenuItem btnAdmCiclo;
    private javax.swing.JMenuItem btnAdmCursa;
    private javax.swing.JMenuItem btnAdmMalla;
    private javax.swing.JMenuItem btnAdmMatricula;
    private javax.swing.JMenuItem btnAdmPeriodo;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JMenuItem btnIncio;
    private javax.swing.JButton btnMatriculas;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnOrdenar;
    private javax.swing.JMenuItem btnSalir;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JComboBox<String> cbxCarrera;
    private javax.swing.JComboBox<String> cbxCriterio;
    private javax.swing.JComboBox<String> cbxCriterio1;
    private javax.swing.JCheckBox cbxMetodo;
    private javax.swing.JComboBox<String> cbxMetodo1;
    private javax.swing.JComboBox<String> cbxModalidad;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tblMostrar;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtContrasenia;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
