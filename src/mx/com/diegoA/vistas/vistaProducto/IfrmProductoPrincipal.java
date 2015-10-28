package mx.com.diegoA.vistas.vistaProducto;

import mx.com.diegoA.vistas.vistaColección.*;
import mx.com.diegoA.vistas.vistaMarca.*;
import java.awt.Color;
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
import mx.com.diegoA.control.control.CtrlConfProducto;
import mx.com.diegoA.control.control.CtrlConfTipoProducto;
import mx.com.diegoA.control.control.ctrlconfColeccion;
import mx.com.diegoA.control.control.ctrlconfMarca;
import mx.com.diegoA.entidad.entity.ConfColeccion;
import mx.com.diegoA.entidad.entity.ConfMarca;
import mx.com.diegoA.entidad.entity.ConfPMA;
import mx.com.diegoA.entidad.entity.ConfProducto;
import mx.com.diegoA.entidad.entity.ConfTipoProducto;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Dies
 */
public class IfrmProductoPrincipal extends javax.swing.JInternalFrame {

    //<editor-fold defaultstate="collapsed" desc="Cuerpo Producto">
    //<editor-fold defaultstate="collapsed" desc="Variables">
    DefaultTableModel t;
    DefaultTableModel tc;
    private int id, idcentral;
    private int fila, filac;
    private String consultaE;
    private ctrlConexion conn = new ctrlConexion();
    private ConfProducto queryGlobal = new ConfProducto();
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Metodos">
    //<editor-fold defaultstate="collapsed" desc="Constructor">
    public IfrmProductoPrincipal() throws SQLException {
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
        String[] head = {"ID", "Tipo productos"};
        String[] headc = {"ID", "Producto", "IDMarca", "IDColeccion", "IDMaterial", "IDColor", "Precio"};
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

    public IfrmProductoPrincipal(Object Permisos) throws SQLException {
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
        String[] head = {"ID", "Tipo productos"};
        String[] headc = {"ID", "Producto", "IDMarca", "IDColeccion", "IDMaterial", "IDColor", "Precio"};
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
//</editor-fold>

    public void loadInformation() throws SQLException {
        this.setFiltroEstado();
    }

    private void setFiltroEstado() throws SQLException {

        CtrlConfTipoProducto ctrlCole = new CtrlConfTipoProducto();
        ArrayList<Object> lista = ctrlCole.ConsultaCompleja();

        for (int i = 0; i < lista.size(); i++) {
            Object[] filaTemp = new Object[2];
            ConfTipoProducto tempObject = (ConfTipoProducto) lista.get(i);
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
        CtrlConfProducto coleccion = new CtrlConfProducto();
        ArrayList<Object> lista = coleccion.ConsultaCompleja(this.id);

        for (int i = 0; i < lista.size(); i++) {
            Object[] filaTemp1 = new Object[7];
            ConfProducto tempObject = (ConfProducto) lista.get(i);
            filaTemp1[0] = tempObject.getId();
            filaTemp1[1] = tempObject.getStrValor();
            filaTemp1[2] = tempObject.getIdConfMarca();
            filaTemp1[3] = tempObject.getIdConfColeccion();
            filaTemp1[4] = tempObject.getIdConfMaterial();
            filaTemp1[5] = tempObject.getIdConfColor();
            filaTemp1[6] = tempObject.getCurPrecio();
            tc.addRow(filaTemp1);
            jtCentral.setModel(tc);
            jtCentral.getColumn("ID").setPreferredWidth(0);
            jtCentral.getColumn("ID").setMinWidth(0);
            jtCentral.getColumn("ID").setMaxWidth(0);
            jtCentral.getColumn("ID").setWidth(0);
            //ocultamos idMarca
            jtCentral.getColumn("IDMarca").setPreferredWidth(0);
            jtCentral.getColumn("IDMarca").setMinWidth(0);
            jtCentral.getColumn("IDMarca").setMaxWidth(0);
            jtCentral.getColumn("IDMarca").setWidth(0);
            //ocultamos idColeccion
            jtCentral.getColumn("IDColeccion").setPreferredWidth(0);
            jtCentral.getColumn("IDColeccion").setMinWidth(0);
            jtCentral.getColumn("IDColeccion").setMaxWidth(0);
            jtCentral.getColumn("IDColeccion").setWidth(0);
            //Ocultamos idmaterial
            jtCentral.getColumn("IDMaterial").setPreferredWidth(0);
            jtCentral.getColumn("IDMaterial").setMinWidth(0);
            jtCentral.getColumn("IDMaterial").setMaxWidth(0);
            jtCentral.getColumn("IDMaterial").setWidth(0);
            //ocultamos idcolor
            jtCentral.getColumn("IDColor").setPreferredWidth(0);
            jtCentral.getColumn("IDColor").setMinWidth(0);
            jtCentral.getColumn("IDColor").setMaxWidth(0);
            jtCentral.getColumn("IDColor").setWidth(0);
            //ocultamos precio
            jtCentral.getColumn("Precio").setPreferredWidth(0);
            jtCentral.getColumn("Precio").setMinWidth(0);
            jtCentral.getColumn("Precio").setMaxWidth(0);
            jtCentral.getColumn("Precio").setWidth(0);
        }
    }

    private void Clear_Table() {
        for (int i = 0; i < jtCentral.getRowCount(); i++) {
            tc.removeRow(i);
            i -= 1;
        }
    }

    private void jtCentralMouseClickedinitial() throws SQLException {
        //Realiza la accion del metodo de arriba pero al inicio
        filac = jtCentral.getSelectedRow();
        if (filac != -1) {

            lblid.setText(String.valueOf(jtCentral.getValueAt(filac, 0)));
            lblvalor.setText(String.valueOf(jtCentral.getValueAt(filac, 1)));
            lbldescripcion.setText(String.valueOf(jtEstado.getValueAt(fila, 1)));
            this.txtCosto.setText(String.valueOf(jtCentral.getValueAt(filac, 6)));

            //<editor-fold defaultstate="collapsed" desc="imprimiremos  los valores de la marca y coleccion con sus respectivas controladoras">
            ctrlconfMarca cMarca = new ctrlconfMarca();
            ctrlconfColeccion cColeccion = new ctrlconfColeccion();
            ArrayList<Object> listaMarca = cMarca.ConsultaParaManager(this.jtCentral.getValueAt(filac, 2));
            ArrayList<Object> listaColeccion = cColeccion.ConsultaParaManager(this.jtCentral.getValueAt(filac, 3));
            for (int i = 0; i < listaMarca.size(); i++) {
                ConfMarca marca = (ConfMarca) listaMarca.get(i);
                if (marca.getId() == (int) this.jtCentral.getValueAt(filac, 2)) {
                    this.txtMarca.setText(String.valueOf(marca));
                }
            }
            for (int i = 0; i < listaColeccion.size(); i++) {
                ConfColeccion coleccion = (ConfColeccion) listaColeccion.get(i);
                if (coleccion.getId() == (int) this.jtCentral.getValueAt(filac, 3)) {
                    this.txtColeccion.setText(String.valueOf(coleccion));
                }
            }
            //</editor-fold>

            this.idcentral = (int) jtCentral.getValueAt(filac, 0);
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
        lblMarca = new javax.swing.JLabel();
        lblColección = new javax.swing.JLabel();
        lblCosto = new javax.swing.JLabel();
        txtMarca = new javax.swing.JLabel();
        txtColeccion = new javax.swing.JLabel();
        txtCosto = new javax.swing.JLabel();
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
        setTitle("-Producto");

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
        jLabel1.setText("Identificador:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Nombre:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("T. producto:");

        lblid.setForeground(new java.awt.Color(102, 102, 102));
        lblid.setText("1");

        lblvalor.setForeground(new java.awt.Color(102, 102, 102));
        lblvalor.setText("Mazahua");

        lbldescripcion.setForeground(new java.awt.Color(102, 102, 102));
        lbldescripcion.setText("Activa");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mx/com/diegoA/img/1412742116_Internet.png"))); // NOI18N

        lblMarca.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblMarca.setForeground(new java.awt.Color(51, 51, 51));
        lblMarca.setText("Marca:");

        lblColección.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblColección.setForeground(new java.awt.Color(51, 51, 51));
        lblColección.setText("Coleccion:");

        lblCosto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblCosto.setForeground(new java.awt.Color(51, 51, 51));
        lblCosto.setText("Costo m2:");

        txtMarca.setForeground(new java.awt.Color(102, 102, 102));
        txtMarca.setText("Activa");

        txtColeccion.setForeground(new java.awt.Color(102, 102, 102));
        txtColeccion.setText("Activa");

        txtCosto.setForeground(new java.awt.Color(102, 102, 102));
        txtCosto.setText("Activa");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblid, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblColección, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCosto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtColeccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtMarca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbldescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblvalor, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(55, 55, 55)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblid)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblvalor))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lbldescripcion))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMarca)
                    .addComponent(txtMarca))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblColección)
                    .addComponent(txtColeccion))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCosto)
                    .addComponent(txtCosto))
                .addContainerGap(121, Short.MAX_VALUE))
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
        jScrollPane1.setViewportView(jtCentral);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
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
        jLabel7.setText("Producto");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mx/com/diegoA/img/1412742116_Internet.png"))); // NOI18N

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

        JdProductoManager manager;
        CtrlConfProducto ctrlCole;
        try {
            ctrlCole = new CtrlConfProducto();
            manager = new JdProductoManager();

            //manager.setVisible(true);
            Object objTemp = manager.showDialog(null);
            ConfProducto conf = (ConfProducto) objTemp;

            //si el conf es diferente de null
            if (objTemp != null) {
                //invocamos nuestra controladora para agregar

                if (ctrlCole.Agregar(objTemp)) {
                    //si el guardado fue correcto manda un mensaje
                    JOptionPane.showMessageDialog(null, "Nuevo Producto registrado con exito");
                } else {
                    //delo contrario = pero indicando
                    JOptionPane.showMessageDialog(null, "No se ha podido registrar el Producto");
                }

            }
            //actualiza los datos del jtable de resultado
            this.Clear_Table();
            this.setcentralgrid();
            jtCentral.setRowSelectionInterval(0, 0);
        } catch (SQLException ex) {
            Logger.getLogger(IfrmMarca.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void jtEstadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtEstadoMouseClicked
        try {

            this.Clear_Table();
            this.setcentralgrid();
            jtCentral.setRowSelectionInterval(0, 0);
            this.jtCentralMouseClickedinitial();
        } catch (SQLException ex) {
            Logger.getLogger(IfrmMarca.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jtEstadoMouseClicked

    private void jtCentralMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtCentralMouseClicked
        try {
            filac = jtCentral.getSelectedRow();
            if (filac != -1) {

                lblid.setText(String.valueOf(jtCentral.getValueAt(filac, 0)));
                lblvalor.setText(String.valueOf(jtCentral.getValueAt(filac, 1)));
                lbldescripcion.setText(String.valueOf(jtEstado.getValueAt(fila, 1)));
                this.txtCosto.setText(String.valueOf(jtCentral.getValueAt(filac, 6)));

                //<editor-fold defaultstate="collapsed" desc="imprimiremos  los valores de la marca y coleccion con sus respectivas controladoras">
                ctrlconfMarca cMarca = new ctrlconfMarca();
                ctrlconfColeccion cColeccion = new ctrlconfColeccion();
                ArrayList<Object> listaMarca = cMarca.ConsultaParaManager(this.jtCentral.getValueAt(filac, 2));
                ArrayList<Object> listaColeccion = cColeccion.ConsultaParaManager(this.jtCentral.getValueAt(filac, 3));
                for (int i = 0; i < listaMarca.size(); i++) {
                    ConfMarca marca = (ConfMarca) listaMarca.get(i);
                    if (marca.getId() == (int) this.jtCentral.getValueAt(filac, 2)) {
                        this.txtMarca.setText(String.valueOf(marca));
                    }
                }
                for (int i = 0; i < listaColeccion.size(); i++) {
                    ConfColeccion coleccion = (ConfColeccion) listaColeccion.get(i);
                    if (coleccion.getId() == (int) this.jtCentral.getValueAt(filac, 3)) {
                        this.txtColeccion.setText(String.valueOf(coleccion));
                    }
                }
                //</editor-fold>

                this.idcentral = (int) jtCentral.getValueAt(filac, 0);
            }
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
        }
    }//GEN-LAST:event_jtCentralMouseClicked

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // Boton para modificar
        if (tc.getRowCount() > 0) {
            JdProductoManager manager;
            CtrlConfProducto ctrlCole;
            ctrlConexion conexion;
            ConfProducto Cole;
            ResultSet updateMarca;
            PreparedStatement cMarca;
            try {
                ctrlCole = new CtrlConfProducto();
                manager = new JdProductoManager();
                conexion = new ctrlConexion();
                Cole = new ConfProducto();
                //<editor-fold defaultstate="collapsed" desc="Quitamos esto">

//                cMarca = conexion.getCon().prepareStatement("Select * from confColeccion where id=" + this.idcentral);
//                updateMarca = cMarca.executeQuery();
//                while (updateMarca.next()) {
//                    Cole.setId(updateMarca.getInt(1));
//                    Cole.setStrvalor(updateMarca.getString(2));
//                    Cole.setStrDescripcion(updateMarca.getString(3));
//                    Cole.setIdConfMarca(updateMarca.getInt(4));
//                }
                //</editor-fold>
                //Consulta simplificada de lo de arriba omitiendo realizar la consulta
                ArrayList<Object> lista = ctrlCole.ConsultaParaManager(this.idcentral);
                for (int i = 0; i < lista.size(); i++) {
                    Cole = (ConfProducto) lista.get(i);

                }

                Object objTemp = manager.showDialog(Cole);
                ConfProducto conf = (ConfProducto) objTemp;

                //si el conf es diferente de null
                if (objTemp != null) {
                    //invocamos nuestra controladora para agregar
                    if (ctrlCole.Editar(objTemp)) {
                        //si el guardado fue correcto manda un mensaje
                        JOptionPane.showMessageDialog(null, "Coleccion actualizada con exito");
                    } else {
                        //delo contrario = pero indicando
                        JOptionPane.showMessageDialog(null, "No se ha podido actualizar la coleccion");
                    }

                }
                //actualiza los datos del jtable de resultado
                this.Clear_Table();
                this.setcentralgrid();
                jtCentral.setRowSelectionInterval(0, 0);
                this.jtCentralMouseClickedinitial();
            } catch (SQLException ex) {
                Logger.getLogger(IfrmMarca.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay registros que editar");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // 
        if (tc.getRowCount() > 0) {
            JdMarcaManager manager;
            CtrlConfProducto coleccion;
            ctrlConexion conexion;
            ConfProducto Marca;
            ResultSet updateMarca;
            PreparedStatement cMarca;
            try {
                coleccion = new CtrlConfProducto();
                manager = new JdMarcaManager();
                conexion = new ctrlConexion();
                Marca = new ConfProducto();

                Marca.setId(this.idcentral);

                if (coleccion.Eliminar(Marca)) {
                    //si el guardado fue correcto manda un mensaje
                    JOptionPane.showMessageDialog(null, "Producto eliminado con exito");
                } else {
                    //delo contrario = pero indicando
                    JOptionPane.showMessageDialog(null, "No se ha podido eliminar el producto");
                }
                //actualiza los datos del jtable de resultado
                this.Clear_Table();
                this.setcentralgrid();
                jtCentral.setRowSelectionInterval(0, 0);
            } catch (SQLException ex) {
                Logger.getLogger(IfrmMarca.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay registros que Eliminar");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnBuscarEspecialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarEspecialActionPerformed
        // Llama a consulta especializada
        try {
            CtrlConfProducto cMarca = new CtrlConfProducto();
            this.consultaE = this.txtBuscar.getText();
            this.queryGlobal.setStrBusqueda(this.consultaE);
            this.queryGlobal.setIdConfTipoProducto(id);
            ArrayList<Object> lista = cMarca.ConsultaEspecializada(this.queryGlobal);
            this.Clear_Table();
            for (int i = 0; i < lista.size(); i++) {
                Object[] filaTemp1 = new Object[7];
                ConfProducto tempObject = (ConfProducto) lista.get(i);
                filaTemp1[0] = tempObject.getId();
                filaTemp1[1] = tempObject.getStrValor();
                filaTemp1[2] = tempObject.getIdConfMarca();
                filaTemp1[3] = tempObject.getIdConfColeccion();
                filaTemp1[4] = tempObject.getIdConfMaterial();
                filaTemp1[5] = tempObject.getIdConfColor();
                filaTemp1[6] = tempObject.getCurPrecio();
                tc.addRow(filaTemp1);
                jtCentral.setModel(tc);
                jtCentral.getColumn("ID").setPreferredWidth(0);
                jtCentral.getColumn("ID").setMinWidth(0);
                jtCentral.getColumn("ID").setMaxWidth(0);
                jtCentral.getColumn("ID").setWidth(0);
                if (jtCentral.getRowCount() > -1) {
                    jtCentral.setRowSelectionInterval(0, 0);
                    this.jtCentralMouseClickedinitial();
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(IfrmMarca.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnBuscarEspecialActionPerformed

    private void txtBuscarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarFocusGained
        // Borra el texto cuando se selecciona
        this.txtBuscar.setText("");
    }//GEN-LAST:event_txtBuscarFocusGained

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        // imprimira el reporte de Productos
        try {
            JasperReport reporte = JasperCompileManager.compileReport("ReporteProducto.jrxml");
            JasperPrint print = JasperFillManager.fillReport(reporte, null, conn.getCon());
            JasperViewer.viewReport(print, false);
        } catch (JRException ex) {
            Logger.getLogger(IfrmMarca.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnImprimirActionPerformed
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
    private javax.swing.JLabel lblColección;
    private javax.swing.JLabel lblCosto;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lbldescripcion;
    private javax.swing.JLabel lblid;
    private javax.swing.JLabel lblvalor;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JLabel txtColeccion;
    private javax.swing.JLabel txtCosto;
    private javax.swing.JLabel txtMarca;
    // End of variables declaration//GEN-END:variables
//</editor-fold>
}
