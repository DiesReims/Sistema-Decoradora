package mx.com.diegoA.vistas.vistaEmpleado;

import mx.com.diegoA.vistas.vistaMarca.*;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import mx.com.diegoA.control.conexion.ctrlConexion;
import mx.com.diegoA.control.control.CtrlConfEmpleado;
import mx.com.diegoA.control.control.CtrlConfPerfiles;
import mx.com.diegoA.entidad.entity.ConfEmpleado;
import mx.com.diegoA.entidad.entity.ConfPMA;
import mx.com.diegoA.entidad.entity.ConfPerfiles;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Dies
 */
public class IfrmEmpleadoPrincipal extends javax.swing.JInternalFrame {

    //<editor-fold defaultstate="collapsed" desc="Cuerpo Empleado">
    //<editor-fold defaultstate="collapsed" desc="Variables">
    DefaultTableModel t;
    DefaultTableModel tc;
    private int id, idcentral;
    private int fila, filac;
    private String consultaE;
    private ctrlConexion conn = new ctrlConexion();
    private ConfEmpleado queryGlobal = new ConfEmpleado();
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Metodos">
    //<editor-fold defaultstate="collapsed" desc="Constructor">
    public IfrmEmpleadoPrincipal() throws SQLException {
        initComponents();
        jtEstado.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (jtEstado.getSelectedRow() != -1) {
                    fila = jtEstado.getSelectedRow();
                    id = (int) jtEstado.getValueAt(fila, 0);
                }
            }
        });
        this.getContentPane().setBackground(Color.DARK_GRAY);
        String[] head = {"ID", "Perfil"};
        String[] headc = {"ID", "Usuario", "Password"};
        Object[][] cuerpo = {};
        Object[][] cuerpoc = {};
        t = new DefaultTableModel(cuerpo, head);
        tc = new DefaultTableModel(cuerpoc, headc);
        this.loadInformation();
        jtEstado.setRowSelectionInterval(0, 0);
        this.setcentralgrid();
        jtCentral.setRowSelectionInterval(0, 0);
        this.jtCentralMouseClickedinitial();
         this.jLabel1.setVisible(false);
        this.lblid.setVisible(false);
    }

    public IfrmEmpleadoPrincipal(Object Permisos) throws SQLException {
//Constructor validando permisos 3ra Parte Arquitectura
        //<editor-fold defaultstate="collapsed" desc="Constructor Codigo de arriba">
        initComponents();
        ConfPMA PMA = (ConfPMA) Permisos;

        if (!PMA.isAgregar()) {
            this.btnAgregar.setVisible(false);
        }
        if (!PMA.isEditar()) {
            this.btnEditar.setVisible(false);
        }
        if (!PMA.isEliminar()) {
            this.btnEliminar.setVisible(false);
        }
        if (!PMA.isImprimir()) {
            this.btnImprimir.setVisible(false);
        }

        jtEstado.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (jtEstado.getSelectedRow() != -1) {
                    fila = jtEstado.getSelectedRow();
                    id = (int) jtEstado.getValueAt(fila, 0);

                }
            }

        });
        this.getContentPane().setBackground(Color.DARK_GRAY);
        String[] head = {"ID", "Perfil"};
        String[] headc = {"ID", "Usuario", "Password"};
        Object[][] cuerpo = {};
        Object[][] cuerpoc = {};
        t = new DefaultTableModel(cuerpo, head);
        tc = new DefaultTableModel(cuerpoc, headc);
        this.loadInformation();
        jtEstado.setRowSelectionInterval(0, 0);
        this.setcentralgrid();
        jtCentral.setRowSelectionInterval(0, 0);
        this.jtCentralMouseClickedinitial();
         this.jLabel1.setVisible(false);
        this.lblid.setVisible(false);
//</editor-fold>
    }

    //</editor-fold>
    public void loadInformation() throws SQLException {
        this.setFiltroEstado();
    }

    private void setFiltroEstado() throws SQLException {

        CtrlConfPerfiles estado = new CtrlConfPerfiles();
        ArrayList<Object> lista = estado.ConsultaCompleja();

        for (int i = 0; i < lista.size(); i++) {
            Object[] filaTemp = new Object[2];
            ConfPerfiles tempObject = (ConfPerfiles) lista.get(i);
            filaTemp[0] = tempObject.getId();
            filaTemp[1] = tempObject.getStrValor();
            t.addRow(filaTemp);
            jtEstado.setModel(t);

            jtEstado.getColumn("ID").setPreferredWidth(0);
            jtEstado.getColumn("ID").setMinWidth(0);
            jtEstado.getColumn("ID").setMaxWidth(0);
            jtEstado.getColumn("ID").setWidth(0);
        }

    }

    private void setcentralgrid() throws SQLException {
        CtrlConfEmpleado marca = new CtrlConfEmpleado();
        ArrayList<Object> lista = marca.ConsultaCompleja(this.id);

        for (int i = 0; i < lista.size(); i++) {
            Object[] filaTemp1 = new Object[3];
            ConfEmpleado tempObject = (ConfEmpleado) lista.get(i);
            filaTemp1[0] = tempObject.getId();
            filaTemp1[1] = tempObject.getStrUsuario();
            filaTemp1[2] = tempObject.getStrContraseña();
            tc.addRow(filaTemp1);
            jtCentral.setModel(tc);
            jtCentral.getColumn("ID").setPreferredWidth(0);
            jtCentral.getColumn("ID").setMinWidth(0);
            jtCentral.getColumn("ID").setMaxWidth(0);
            jtCentral.getColumn("ID").setWidth(0);
            jtCentral.getColumn("Password").setPreferredWidth(0);
            jtCentral.getColumn("Password").setMinWidth(0);
            jtCentral.getColumn("Password").setMaxWidth(0);
            jtCentral.getColumn("Password").setWidth(0);
        }
    }

    private void Clear_Table() {
        for (int i = 0; i < jtCentral.getRowCount(); i++) {
            tc.removeRow(i);
            i -= 1;
        }
    }
//</editor-fold>

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtEstado = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblid = new javax.swing.JLabel();
        lblvalor = new javax.swing.JLabel();
        lbldescripcion = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtCentral = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        btnBuscarEspecial = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("-Empleados");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), javax.swing.BorderFactory.createTitledBorder(null, "Filtrar por", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(102, 102, 102)))); // NOI18N

        jtEstado.setModel(new javax.swing.table.DefaultTableModel(
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
        jtEstado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtEstadoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtEstado);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), javax.swing.BorderFactory.createTitledBorder(null, "Detalles", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(102, 102, 102)))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Contraseña");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Usuario:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Perfil:");

        lblid.setForeground(new java.awt.Color(102, 102, 102));
        lblid.setText("1");

        lblvalor.setForeground(new java.awt.Color(102, 102, 102));
        lblvalor.setText("Mazahua");

        lbldescripcion.setForeground(new java.awt.Color(102, 102, 102));
        lbldescripcion.setText("Activa");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mx/com/diegoA/img/1412742102_Users_Group.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(31, 31, 31)
                        .addComponent(lblvalor, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbldescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblid, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(68, 68, 68)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblvalor))
                .addGap(63, 63, 63)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblid))
                .addGap(76, 76, 76)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lbldescripcion))
                .addContainerGap(104, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jtCentral.setModel(new javax.swing.table.DefaultTableModel(
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
        jtCentral.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtCentralMouseClicked(evt);
            }
        });
        jtCentral.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtCentralKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtCentral);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnAgregar.setBackground(new java.awt.Color(204, 204, 204));
        btnAgregar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(102, 102, 102));
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(204, 204, 204));
        btnEditar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(102, 102, 102));
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(204, 204, 204));
        btnEliminar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(102, 102, 102));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnImprimir.setBackground(new java.awt.Color(204, 204, 204));
        btnImprimir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnImprimir.setForeground(new java.awt.Color(102, 102, 102));
        btnImprimir.setText("Imprimir");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        txtBuscar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtBuscar.setForeground(new java.awt.Color(102, 102, 102));
        txtBuscar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBuscar.setText("Buscar...");
        txtBuscar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBuscarFocusGained(evt);
            }
        });

        btnBuscarEspecial.setBackground(new java.awt.Color(204, 204, 204));
        btnBuscarEspecial.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnBuscarEspecial.setForeground(new java.awt.Color(102, 102, 102));
        btnBuscarEspecial.setText("Buscar");
        btnBuscarEspecial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarEspecialActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Empleados");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mx/com/diegoA/img/1412742102_Users_Group.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(0, 240, Short.MAX_VALUE)
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscarEspecial)
                                .addGap(97, 97, 97)
                                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminar)
                                .addGap(18, 18, 18)
                                .addComponent(btnImprimir))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(jSeparator6))
                    .addComponent(btnAgregar))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnImprimir)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(btnAgregar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnBuscarEspecial, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //<editor-fold defaultstate="collapsed" desc="Botones y Eventos">
    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed

        JdEmpleadoManager manager;
        CtrlConfEmpleado marca;
        try {
            marca = new CtrlConfEmpleado();
            manager = new JdEmpleadoManager();

            //manager.setVisible(true);
            Object objTemp = manager.showDialog(null);
            ConfEmpleado conf = (ConfEmpleado) objTemp;

            //si el conf es diferente de null
            if (objTemp != null) {
                //invocamos nuestra controladora para agregar

                if (marca.Agregar(objTemp)) {
                    //si el guardado fue correcto manda un mensaje
                    JOptionPane.showMessageDialog(null, "Nuevo empleado registrado con exito");
                } else {
                    //delo contrario = pero indicando
                    JOptionPane.showMessageDialog(null, "No se ha podido registrar el empleado");
                }

            }
            //actualiza los datos del jtable de resultado
            this.Clear_Table();
            this.setcentralgrid();
            jtCentral.setRowSelectionInterval(0, 0);
        } catch (SQLException ex) {
            Logger.getLogger(IfrmEmpleadoPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void jtEstadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtEstadoMouseClicked
        try {

            this.Clear_Table();
            this.setcentralgrid();
            jtCentral.setRowSelectionInterval(0, 0);
            this.jtCentralMouseClickedinitial();
        } catch (SQLException ex) {
            Logger.getLogger(IfrmEmpleadoPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jtEstadoMouseClicked

    private void jtCentralMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtCentralMouseClicked
        filac = jtCentral.getSelectedRow();
        if (filac != -1) {
            lblid.setText(String.valueOf(jtCentral.getValueAt(filac, 2)));
            lblvalor.setText(String.valueOf(jtCentral.getValueAt(filac, 1)));
            lbldescripcion.setText(String.valueOf(jtEstado.getValueAt(fila, 1)));
            this.idcentral = (int) jtCentral.getValueAt(filac, 0);
        }
    }//GEN-LAST:event_jtCentralMouseClicked

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // Boton para modificar
        if (tc.getRowCount() > 0) {
            JdEmpleadoManager manager;
            CtrlConfEmpleado marca;
            ctrlConexion conexion;
            ConfEmpleado Marca;
            ResultSet updateMarca;
            PreparedStatement cMarca;
            try {
                marca = new CtrlConfEmpleado();
                manager = new JdEmpleadoManager();
                conexion = new ctrlConexion();
                Marca = new ConfEmpleado();
                //<editor-fold defaultstate="collapsed" desc="Quitamos esto">
//                cMarca = conexion.getCon().prepareStatement("Select * from confmarca where id=" + this.idcentral);
//                updateMarca = cMarca.executeQuery();
//                while (updateMarca.next()) {
//                    Marca.setId(updateMarca.getInt(1));
//                    Marca.setStrvalor(updateMarca.getString(2));
//                    Marca.setStrdescripcion(updateMarca.getString(3));
//                    Marca.setIdconfestadoglobal(updateMarca.getInt(4));
//                }
                //</editor-fold>
                //Consulta simplificada de lo de arriba omitiendo realizar la consulta
                ArrayList<Object> lista = marca.ConsultaParaManager(this.idcentral);
                for (int i = 0; i < lista.size(); i++) {
                    Marca = (ConfEmpleado) lista.get(i);

                }

                Object objTemp = manager.showDialog(Marca);
                ConfEmpleado conf = (ConfEmpleado) objTemp;

                //si el conf es diferente de null
                if (objTemp != null) {
                    //invocamos nuestra controladora para agregar
                    if (marca.Editar(objTemp)) {
                        //si el guardado fue correcto manda un mensaje
                        JOptionPane.showMessageDialog(null, "Empleado actualizado con exito");
                    } else {
                        //delo contrario = pero indicando
                        JOptionPane.showMessageDialog(null, "No se ha podido actualizar el empleado");
                    }

                }
                //actualiza los datos del jtable de resultado
                this.Clear_Table();
                this.setcentralgrid();
                jtCentral.setRowSelectionInterval(0, 0);
            } catch (SQLException ex) {
                Logger.getLogger(IfrmEmpleadoPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay registros que editar");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // 
        if (tc.getRowCount() > 0) {
            JdEmpleadoManager manager;
            CtrlConfEmpleado marca;
            ctrlConexion conexion;
            ConfEmpleado Empleado;
            ResultSet updateMarca;
            PreparedStatement cMarca;
            try {
                marca = new CtrlConfEmpleado();
                manager = new JdEmpleadoManager();
                conexion = new ctrlConexion();
                Empleado = new ConfEmpleado();

                Empleado.setId(this.idcentral);

                if (marca.Eliminar(Empleado)) {
                    //si el guardado fue correcto manda un mensaje
                    JOptionPane.showMessageDialog(null, "Empleado eliminado con exito");
                } else {
                    //delo contrario = pero indicando
                    JOptionPane.showMessageDialog(null, "No se ha podido eliminar el empleado");
                }
                //actualiza los datos del jtable de resultado
                this.Clear_Table();
                this.setcentralgrid();
                jtCentral.setRowSelectionInterval(0, 0);
            } catch (SQLException ex) {
                Logger.getLogger(IfrmEmpleadoPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay registros que Eliminar");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnBuscarEspecialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarEspecialActionPerformed
        // Llama a consulta especializada
        try {
            CtrlConfEmpleado cMarca = new CtrlConfEmpleado();
            this.consultaE = this.txtBuscar.getText();
            this.queryGlobal.setStrBusqueda(this.consultaE);
            this.queryGlobal.setIdPerfil(id);
            ArrayList<Object> lista = cMarca.ConsultaEspecializada2(this.queryGlobal, null);
            this.Clear_Table();
            for (int i = 0; i < lista.size(); i++) {
                Object[] filaTemp1 = new Object[3];
                ConfEmpleado tempObject = (ConfEmpleado) lista.get(i);
                filaTemp1[0] = tempObject.getId();
                filaTemp1[1] = tempObject.getStrUsuario();
                filaTemp1[2] = tempObject.getStrContraseña();
                tc.addRow(filaTemp1);
                jtCentral.setModel(tc);
                jtCentral.getColumn("ID").setPreferredWidth(0);
                jtCentral.getColumn("ID").setMinWidth(0);
                jtCentral.getColumn("ID").setMaxWidth(0);
                jtCentral.getColumn("ID").setWidth(0);
                jtCentral.getColumn("Password").setPreferredWidth(0);
                jtCentral.getColumn("Password").setMinWidth(0);
                jtCentral.getColumn("Password").setMaxWidth(0);
                jtCentral.getColumn("Password").setWidth(0);
                if (jtCentral.getRowCount() > -1) {
                    jtCentral.setRowSelectionInterval(0, 0);
                    this.jtCentralMouseClickedinitial();
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(IfrmEmpleadoPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnBuscarEspecialActionPerformed

    private void txtBuscarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarFocusGained
        // Borra el texto cuando se selecciona
        this.txtBuscar.setText("");
    }//GEN-LAST:event_txtBuscarFocusGained

    private void jtCentralKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtCentralKeyPressed
        // Key pressed para table central
        int c = evt.getKeyCode();

        if (c == KeyEvent.VK_UP) {
            filac = jtCentral.getSelectedRow() - 1;
            if (filac != -1) {

                lblid.setText(String.valueOf(jtCentral.getValueAt(filac, 2)));
                lblvalor.setText(String.valueOf(jtCentral.getValueAt(filac, 1)));
                lbldescripcion.setText(String.valueOf(jtEstado.getValueAt(fila, 1)));
                this.idcentral = (int) jtCentral.getValueAt(filac, 0);

            }

            System.out.println("arriba");
        }
        if (c == KeyEvent.VK_DOWN) {
            filac = jtCentral.getSelectedRow() + 1;
            if (filac != -1) {

                lblid.setText(String.valueOf(jtCentral.getValueAt(filac, 2)));
                lblvalor.setText(String.valueOf(jtCentral.getValueAt(filac, 1)));
                lbldescripcion.setText(String.valueOf(jtEstado.getValueAt(fila, 1)));
                this.idcentral = (int) jtCentral.getValueAt(filac, 0);

            }

            System.out.println("abajo");
        }
    }//GEN-LAST:event_jtCentralKeyPressed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed

        try {
            JasperReport reporte = JasperCompileManager.compileReport("ReporteEmpleados.jrxml");
            JasperPrint print = JasperFillManager.fillReport(reporte, null, conn.getCon());
            JasperViewer.viewReport(print, false);
        } catch (JRException ex) {
            Logger.getLogger(IfrmEmpleadoPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnImprimirActionPerformed

    private void jtCentralMouseClickedinitial() {
        //Realiza la accion del metodo de arriba pero al inicio
        filac = jtCentral.getSelectedRow();
        if (filac != -1) {

            lblid.setText(String.valueOf(jtCentral.getValueAt(filac, 2)));
            lblvalor.setText(String.valueOf(jtCentral.getValueAt(filac, 1)));
            lbldescripcion.setText(String.valueOf(jtEstado.getValueAt(fila, 1)));
            this.idcentral = (int) jtCentral.getValueAt(filac, 0);
        }
    }
//</editor-fold>
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Declaración de componentes">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscarEspecial;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JTable jtCentral;
    private javax.swing.JTable jtEstado;
    private javax.swing.JLabel lbldescripcion;
    private javax.swing.JLabel lblid;
    private javax.swing.JLabel lblvalor;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
//</editor-fold>
}
