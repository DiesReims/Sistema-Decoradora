package mx.com.diegoA.vistas.vistaDistribuidor;
//<editor-fold defaultstate="collapsed" desc="Paqueterias">


import mx.com.diegoA.vistas.vistaCliente.*;
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
import mx.com.diegoA.control.control.CtrlConfProveedor;
import mx.com.diegoA.control.control.CtrlConfDireccionProveedor;
import mx.com.diegoA.control.control.CtrlConfEstados;
import mx.com.diegoA.control.control.CtrlConfMunicipios;
import mx.com.diegoA.control.control.CtrlConfTipoProveedor;
import mx.com.diegoA.entidad.entity.ConfProveedor;
import mx.com.diegoA.entidad.entity.ConfDireccionProveedor;
import mx.com.diegoA.entidad.entity.ConfEstados;
import mx.com.diegoA.entidad.entity.ConfMunicipios;
import mx.com.diegoA.entidad.entity.ConfPMA;
import mx.com.diegoA.entidad.entity.ConfTipoProveedor;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
//</editor-fold>
/**
 *
 * @author Dies
 */
public class IfrmDistribuidorPrincipal extends javax.swing.JInternalFrame {

    //<editor-fold defaultstate="collapsed" desc="Cuerpo Clientes">
    //<editor-fold defaultstate="collapsed" desc="Variables">
    DefaultTableModel t;
    DefaultTableModel tc;
    DefaultTableModel tdet;
    private int id, idcentral, idultimo;
    private int fila, filac;
    private String consultaE;
    private  ctrlConexion conn = new ctrlConexion();
    ConfProveedor queryGlobal = new ConfProveedor();
//</editor-fold>
    private int idSexo;

    //<editor-fold defaultstate="collapsed" desc="Metodos">
    //<editor-fold defaultstate="collapsed" desc="Constructor">
    public IfrmDistribuidorPrincipal() throws SQLException {
        initComponents();
        jtEstado.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (jtEstado.getSelectedRow() != -1) {
                    fila = jtEstado.getSelectedRow();
                    id = (int) jtEstado.getValueAt(fila, 0);
                    queryGlobal.setId(id);
                }
            }

        });
        this.getContentPane().setBackground(Color.DARK_GRAY);
        String[] head = {"ID", "Sexo"};
        String[] headc = {"ID", "Contacto", "telefono1", "telefono2","IdSexo"};
        String[] headdet = {"ID", "IdCliente","IdEstado","IdMunicipio","Calle","Colonia","Estado","Municipio"};
        Object[][] cuerpo = {};
        Object[][] cuerpoc = {};
        Object[][] cuerpdet = {};
        t = new DefaultTableModel(cuerpo, head);
        tc = new DefaultTableModel(cuerpoc, headc);
        tdet = new DefaultTableModel(cuerpdet, headdet);
        this.jtDireccion.setModel(tdet);
        this.loadInformation();
        jtEstado.setRowSelectionInterval(0, 0);
        this.setcentralgrid();
        jtCentral.setRowSelectionInterval(0, 0);
        this.jtCentralMouseClickedinitial();
         this.jLabel1.setVisible(false);
        this.lblid.setVisible(false);
    }
    public IfrmDistribuidorPrincipal(Object Permisos) throws SQLException {
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
                    queryGlobal.setId(id);
                }
            }

        });
        this.getContentPane().setBackground(Color.DARK_GRAY);
        String[] head = {"ID", "Sexo"};
        String[] headc = {"ID", "Contacto", "telefono1", "telefono2","IdSexo"};
        String[] headdet = {"ID", "IdCliente","IdEstado","IdMunicipio","Calle","Colonia","Estado","Municipio"};
        Object[][] cuerpo = {};
        Object[][] cuerpoc = {};
        Object[][] cuerpdet = {};
        t = new DefaultTableModel(cuerpo, head);
        tc = new DefaultTableModel(cuerpoc, headc);
        tdet = new DefaultTableModel(cuerpdet, headdet);
        this.jtDireccion.setModel(tdet);
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
        this.setFiltroSexo();
    }

    private void setFiltroSexo() throws SQLException {

        CtrlConfTipoProveedor sexo = new CtrlConfTipoProveedor();
        ConfTipoProveedor entitysex = new ConfTipoProveedor();
        entitysex.setId(id);
        ArrayList<Object> lista = sexo.ConsultaEspecializada(sexo);
        
        Object[] filaTemp = new Object[2];
        for (int i = 0; i < lista.size(); i++) 
        {
            ConfTipoProveedor tempObject = (ConfTipoProveedor) lista.get(i);
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
        CtrlConfProveedor cliente = new CtrlConfProveedor();

        ArrayList<Object> lista = cliente.ConsultaCompleja(this.id);

        for (int i = 0; i < lista.size(); i++) {
            Object[] filaTemp1 = new Object[5];
            ConfProveedor tempObject = (ConfProveedor) lista.get(i);
            filaTemp1[0] = tempObject.getId();
            filaTemp1[1] = tempObject.getStrNombre();
            filaTemp1[2] = tempObject.getStrTelCasa();
            filaTemp1[3] = tempObject.getStrTelCel();
            filaTemp1[4] = tempObject.getIdConfProveedor();
            tc.addRow(filaTemp1);
            jtCentral.setModel(tc);
            jtCentral.getColumn("ID").setPreferredWidth(0);
            jtCentral.getColumn("ID").setMinWidth(0);
            jtCentral.getColumn("ID").setMaxWidth(0);
            jtCentral.getColumn("ID").setWidth(0);
            jtCentral.getColumn("telefono1").setPreferredWidth(0);
            jtCentral.getColumn("telefono1").setMinWidth(0);
            jtCentral.getColumn("telefono1").setMaxWidth(0);
            jtCentral.getColumn("telefono1").setWidth(0);
            jtCentral.getColumn("telefono2").setPreferredWidth(0);
            jtCentral.getColumn("telefono2").setMinWidth(0);
            jtCentral.getColumn("telefono2").setMaxWidth(0);
            jtCentral.getColumn("telefono2").setWidth(0);
            jtCentral.getColumn("IdSexo").setPreferredWidth(0);
            jtCentral.getColumn("IdSexo").setMinWidth(0);
            jtCentral.getColumn("IdSexo").setMaxWidth(0);
            jtCentral.getColumn("IdSexo").setWidth(0);
        }
    }

    private void Clear_Table() {
        for (int i = 0; i < jtCentral.getRowCount(); i++) {
            tc.removeRow(i);
            i -= 1;
        }
//        for (int i = 0; i < jtDireccion.getRowCount(); i++) {
//            tdet.removeRow(i);
//            i -= 1;
//        }
    }
    
    
//<editor-fold defaultstate="collapsed" desc="Limpia la Tabla Direccion">
    private void Clear_TableDir() {
        for (int i = 0; i < jtDireccion.getRowCount(); i++) {
            tdet.removeRow(i);
            i -= 1;
        }
    }
//</editor-fold>
    
    private void setAditionalTable() throws SQLException {
        //Tabla adicional en detalle 
        Clear_TableDir();
        CtrlConfDireccionProveedor ctrldir = new CtrlConfDireccionProveedor();
        ConfDireccionProveedor direcciones = new ConfDireccionProveedor();
        ArrayList<Object> lista = ctrldir.ConsultaCompleja(this.idcentral);

        for (int i = 0; i < lista.size(); i++) 
        {
            Object[] filaTemp = new Object[8];
            ConfDireccionProveedor tempObject = (ConfDireccionProveedor) lista.get(i);
            
            CtrlConfEstados estado = new CtrlConfEstados();
            ArrayList<Object> lista2 = estado.ConsultaEspecializada(tempObject.getIdConfEstado());
            ConfEstados tempObject2 = (ConfEstados) lista2.get(0);
            
            CtrlConfMunicipios muni = new CtrlConfMunicipios();
            ArrayList<Object> lista3 = muni.ConsultaEspecializada(tempObject.getIdConfMunicipio());
            ConfMunicipios tempObject3 = (ConfMunicipios) lista3.get(0);
            
            filaTemp[0]= tempObject.getId();
            filaTemp[1]= tempObject.getIdConfProveedor();
            filaTemp[2]= tempObject.getIdConfEstado();
            filaTemp[3]= tempObject.getIdConfMunicipio();
            filaTemp[4] = tempObject.getStrColonia();
            filaTemp[5] = tempObject.getStrValor();
            filaTemp[6] = tempObject2.getNombre();
            filaTemp[7] = tempObject3.getNombre();
            
            tdet.addRow(filaTemp);
            this.jtDireccion.setModel(tdet);

            jtDireccion.getColumn("ID").setPreferredWidth(0);
            jtDireccion.getColumn("ID").setMinWidth(0);
            jtDireccion.getColumn("ID").setMaxWidth(0);
            jtDireccion.getColumn("ID").setWidth(0);
            jtDireccion.getColumn("IdCliente").setPreferredWidth(0);
            jtDireccion.getColumn("IdCliente").setMinWidth(0);
            jtDireccion.getColumn("IdCliente").setMaxWidth(0);
            jtDireccion.getColumn("IdCliente").setWidth(0);
            jtDireccion.getColumn("IdEstado").setPreferredWidth(0);
            jtDireccion.getColumn("IdEstado").setMinWidth(0);
            jtDireccion.getColumn("IdEstado").setMaxWidth(0);
            jtDireccion.getColumn("IdEstado").setWidth(0);
            jtDireccion.getColumn("IdMunicipio").setPreferredWidth(0);
            jtDireccion.getColumn("IdMunicipio").setMinWidth(0);
            jtDireccion.getColumn("IdMunicipio").setMaxWidth(0);
            jtDireccion.getColumn("IdMunicipio").setWidth(0);
            
        }
    }


//select confdireccion.id,confdireccion.idconfcliente,confdireccion.idconfestado,confdireccion.idconfmunicipio,confdireccion.strvalor,confdireccion.strcolonia,confestados.nombre,confmunicipios.nombre from confdireccion,confestados,confmunicipios where confdireccion.idconfcliente = 1 and confestados.id=confdireccion.idconfestado and confdireccion.idconfmunicipio=confmunicipios.id\G;
//select * from confdireccion,confestados where confdireccion.idconfcliente = 1 and confestados.id=confdireccion.idconfestado\G;
        
    //</editor-fold>
//confdireccion.idconfestado= confestados.id and
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
        lblsexo = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbltce = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbltca = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtDireccion = new javax.swing.JTable();
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
        setTitle("-Distribuidor");

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
        jLabel3.setText("Tipo proveedor:");

        lblid.setForeground(new java.awt.Color(102, 102, 102));
        lblid.setText("1");

        lblvalor.setForeground(new java.awt.Color(102, 102, 102));
        lblvalor.setText("Mazahua");

        lblsexo.setForeground(new java.awt.Color(102, 102, 102));
        lblsexo.setText("Activa");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mx/com/diegoA/img/1412742102_Users_Group.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Telefono Celular:");

        lbltce.setForeground(new java.awt.Color(102, 102, 102));
        lbltce.setText("7731283845");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Telefono Fijo:");

        lbltca.setForeground(new java.awt.Color(102, 102, 102));
        lbltca.setText("7731283845");

        jtDireccion.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jtDireccion);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel4)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbltca, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lbltce, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(25, 25, 25)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblvalor, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblsexo, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblid, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel4)
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblid)
                    .addComponent(jLabel1))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblvalor))
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblsexo))
                .addGap(47, 47, 47)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lbltce))
                .addGap(45, 45, 45)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lbltca))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
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
        jLabel7.setText("Distribuidor");

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
                                .addGap(0, 0, Short.MAX_VALUE)
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
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //<editor-fold defaultstate="collapsed" desc="Botones y Eventos">

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        try {
            JdCDistribuidorManager manager;
            CtrlConfProveedor cliente;
            cliente = new CtrlConfProveedor();
            manager = new JdCDistribuidorManager();

//            manager.setVisible(true); no debe de ponerse
            Object objTemp = manager.showDialog(null);
            ConfProveedor conf = (ConfProveedor) objTemp;

            //si el conf es diferente de null
            if (objTemp != null) {
                //invocamos nuestra controladora para agregar

                if (cliente.Agregar(objTemp)) {
                    //si el guardado fue correcto manda un mensaje

                    CtrlConfDireccionProveedor ctrlDir = new CtrlConfDireccionProveedor();
                    CtrlConfProveedor ctrlCli = new CtrlConfProveedor();
                    this.idultimo = ctrlCli.ConsultarUltimo();

                    for (int i = 0; i < conf.getDireccion().size(); i++) {
                        ConfDireccionProveedor direccion;
                        direccion = (ConfDireccionProveedor) conf.getDireccion().get(i);
                        System.out.println("datos de dir no." + i + " " + direccion.getStrValor() + " " + direccion.getIdConfProveedor() + " " + direccion.getIdConfEstado() + " " + direccion.getIdConfMunicipio());
                        ctrlDir.insertarRepetitivo(direccion, this.idultimo);
                    }
                    JOptionPane.showMessageDialog(null, "Nuevo cliente registrado con exito");
                } else {
                    //delo contrario = pero indicando
                    JOptionPane.showMessageDialog(null, "No se ha podido registrar el cliente");
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

        filac = jtCentral.getSelectedRow();
        if (filac != -1) {
            try {
                this.idSexo = (int) jtCentral.getValueAt(filac, 4);
                CtrlConfTipoProveedor sex = new CtrlConfTipoProveedor();
                ArrayList<Object> list = sex.ConsultaCompleja(this.idSexo);
                ConfTipoProveedor tempObj = (ConfTipoProveedor) list.get(0);
                /// inicializa dspues de la clase
                lblid.setText(String.valueOf(jtCentral.getValueAt(filac, 0)));
                lblvalor.setText(String.valueOf(jtCentral.getValueAt(filac, 1)));
                lblsexo.setText(String.valueOf(tempObj.getStrValor()));
                lbltce.setText(String.valueOf(jtCentral.getValueAt(filac, 3)));
                lbltca.setText(String.valueOf(jtCentral.getValueAt(filac, 2)));
                this.idcentral = (int) jtCentral.getValueAt(filac, 0);
                try {
                    for (int i = 0; i < jtDireccion.getRowCount(); i++) {
                        tdet.removeRow(i);
                        i -= 1;
                    }
                    this.setAditionalTable();
                } catch (SQLException ex) {
                    Logger.getLogger(IfrmClientePrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (SQLException ex) {
                Logger.getLogger(IfrmClientePrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jtCentralMouseClicked

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // Boton para modificar
        if (tc.getRowCount() > 0) {
            JdCDistribuidorManager manager;
            CtrlConfProveedor ctrlCliente;
            ctrlConexion conexion;
            ConfProveedor cliente;
            ResultSet updateMarca;
            PreparedStatement cMarca;
            try {
                ctrlCliente = new CtrlConfProveedor();
                manager = new JdCDistribuidorManager();
                conexion = new ctrlConexion();
                cliente = new ConfProveedor();
                //<editor-fold defaultstate="collapsed" desc="Quitamos esto">
//                cMarca = conexion.getCon().prepareStatement("Select * from confcliente where id=" + this.idcentral);
//                updateMarca = cMarca.executeQuery();
//                while (updateMarca.next()) {
//                    cliente.setId(updateMarca.getInt(1));
//                    cliente.setStrNombre(updateMarca.getString(2));
//                    cliente.setStrTelCasa(updateMarca.getString(3));
//                    cliente.setStrTelCel(updateMarca.getString(4));
//                    cliente.setIdConfTipoProveedor(this.id);
//                }
                //</editor-fold>
                //Consulta simplificada de lo de arriba omitiendo realizar la consulta
                ArrayList<Object> lista = ctrlCliente.ConsultaParaManager(this.idcentral);
                for (int i = 0; i < lista.size(); i++) {
                    cliente = (ConfProveedor) lista.get(i);

                }

                Object objTemp = manager.showDialog(cliente);
                ConfProveedor conf = (ConfProveedor) objTemp;

                //si el conf es diferente de null
                if (objTemp != null) {
                    //invocamos nuestra controladora para agregar
                    if (ctrlCliente.Editar(objTemp)) {
                        //Aggregamos las controladoras de editar y modificar o insertar según sea el caso
                        CtrlConfDireccionProveedor ctrlDir = new CtrlConfDireccionProveedor();
                        CtrlConfProveedor ctrlCli = new CtrlConfProveedor();
                        // this.idultimo = ctrlCli.ConsultarUltimo();

                        for (int i = 0; i < conf.getDireccion().size(); i++) {
                            ConfDireccionProveedor direccion;
                            direccion = (ConfDireccionProveedor) conf.getDireccion().get(i);
                            System.out.println("datos de dir no." + i + " " + direccion.getStrValor() + " " + direccion.getIdConfProveedor());
                            if (direccion.getId() == 0) {
                                ctrlDir.insertarRepetitivo(direccion, this.idcentral);
                            } else {
                                ctrlDir.Editar(direccion);
                            }
                        }
                        //si el guardado fue correcto manda un mensaje
                        JOptionPane.showMessageDialog(null, "Cliente actualizado con exito");
                    } else {
                        //delo contrario = pero indicando
                        JOptionPane.showMessageDialog(null, "No se ha podido actualizar el cliente");
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
        if (tc.getRowCount() > -1) {
            JdMarcaManager manager;
            CtrlConfProveedor cli;
            ctrlConexion conexion;
            ConfProveedor Marca;
            ResultSet updateMarca;
            PreparedStatement cMarca;
            try {
                cli = new CtrlConfProveedor();
                manager = new JdMarcaManager();
                conexion = new ctrlConexion();
                Marca = new ConfProveedor();

                Marca.setId(this.idcentral);

                if (cli.Eliminar(Marca)) {
                    //si el guardado fue correcto manda un mensaje
                    JOptionPane.showMessageDialog(null, "Cliente eliminado con exito");
                } else {
                    //delo contrario = pero indicando
                    JOptionPane.showMessageDialog(null, "No se ha podido eliminar el cliente");
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
            JOptionPane.showMessageDialog(null, "No hay registros que Eliminar");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnBuscarEspecialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarEspecialActionPerformed
        // Aqui manda a llamar el metodo de consulta especializada

        try {
            CtrlConfProveedor cliente = new CtrlConfProveedor();
            this.consultaE = this.txtBuscar.getText();
            this.queryGlobal.setStrBusqueda(this.consultaE);
            this.queryGlobal.setIdConfProveedor(id);
            ArrayList<Object> lista = cliente.ConsultaEspecializada(this.queryGlobal);
            this.Clear_Table();
            for (int i = 0; i < lista.size(); i++) {
                Object[] filaTemp1 = new Object[5];
                ConfProveedor tempObject = (ConfProveedor) lista.get(i);
                filaTemp1[0] = tempObject.getId();
                filaTemp1[1] = tempObject.getStrNombre();
                filaTemp1[2] = tempObject.getStrTelCasa();
                filaTemp1[3] = tempObject.getStrTelCel();
                filaTemp1[4] = tempObject.getIdConfProveedor();
                tc.addRow(filaTemp1);
                jtCentral.setModel(tc);
                jtCentral.getColumn("ID").setPreferredWidth(0);
                jtCentral.getColumn("ID").setMinWidth(0);
                jtCentral.getColumn("ID").setMaxWidth(0);
                jtCentral.getColumn("ID").setWidth(0);
                jtCentral.getColumn("telefono1").setPreferredWidth(0);
                jtCentral.getColumn("telefono1").setMinWidth(0);
                jtCentral.getColumn("telefono1").setMaxWidth(0);
                jtCentral.getColumn("telefono1").setWidth(0);
                jtCentral.getColumn("telefono2").setPreferredWidth(0);
                jtCentral.getColumn("telefono2").setMinWidth(0);
                jtCentral.getColumn("telefono2").setMaxWidth(0);
                jtCentral.getColumn("telefono2").setWidth(0);
                jtCentral.getColumn("IdSexo").setPreferredWidth(0);
                jtCentral.getColumn("IdSexo").setMinWidth(0);
                jtCentral.getColumn("IdSexo").setMaxWidth(0);
                jtCentral.getColumn("IdSexo").setWidth(0);
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
        // Borra el texto dentro del txt cuando se selecciona
        this.txtBuscar.setText("");
    }//GEN-LAST:event_txtBuscarFocusGained

    private void jtCentralKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtCentralKeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        
        if (c == KeyEvent.VK_UP) {
                filac = jtCentral.getSelectedRow()-1;
            if (filac != -1) {
                    try {
                        this.idSexo = (int) jtCentral.getValueAt(filac, 4);
                        CtrlConfTipoProveedor sex = new CtrlConfTipoProveedor();
                        ArrayList<Object> list = sex.ConsultaCompleja(this.idSexo);
                        ConfTipoProveedor tempObj = (ConfTipoProveedor) list.get(0);
                        /// inicializa dspues de la clase
                        lblid.setText(String.valueOf(jtCentral.getValueAt(filac, 0)));
                        lblvalor.setText(String.valueOf(jtCentral.getValueAt(filac, 1)));
                        lblsexo.setText(String.valueOf(tempObj.getStrValor()));
                        lbltce.setText(String.valueOf(jtCentral.getValueAt(filac, 3)));
                        lbltca.setText(String.valueOf(jtCentral.getValueAt(filac, 2)));
                        this.idcentral = (int) jtCentral.getValueAt(filac, 0);
                        this.setAditionalTable();
                    } catch (SQLException ex) {
                        Logger.getLogger(IfrmClientePrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
                      
            System.out.println("arriba");
        }
        if (c == KeyEvent.VK_DOWN) {
                filac = jtCentral.getSelectedRow()+1;
            if (filac != -1) {
                    try {
                        this.idSexo = (int) jtCentral.getValueAt(filac, 4);
                        CtrlConfTipoProveedor sex = new CtrlConfTipoProveedor();
                        ArrayList<Object> list = sex.ConsultaCompleja(this.idSexo);
                        ConfTipoProveedor tempObj = (ConfTipoProveedor) list.get(0);
                        /// inicializa dspues de la clase
                        lblid.setText(String.valueOf(jtCentral.getValueAt(filac, 0)));
                        lblvalor.setText(String.valueOf(jtCentral.getValueAt(filac, 1)));
                        lblsexo.setText(String.valueOf(tempObj.getStrValor()));
                        lbltce.setText(String.valueOf(jtCentral.getValueAt(filac, 3)));
                        lbltca.setText(String.valueOf(jtCentral.getValueAt(filac, 2)));
                        this.idcentral = (int) jtCentral.getValueAt(filac, 0);
                        this.setAditionalTable();
                    } catch (SQLException ex) {
                        Logger.getLogger(IfrmClientePrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
            
            System.out.println("abajo");
        }
    }//GEN-LAST:event_jtCentralKeyPressed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        // Imprime reporte de Distribuidores
           try {
              JasperReport  reporte = JasperCompileManager.compileReport("ReporteDistribuidor.jrxml");
              JasperPrint print = JasperFillManager.fillReport(reporte, null,conn.getCon());
              JasperViewer.viewReport(print,false);
            } catch (JRException ex) {
                Logger.getLogger(IfrmMarca.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void jtCentralMouseClickedinitial() throws SQLException {
        //Realiza la accion del metodo de arriba pero al inicio
        filac = jtCentral.getSelectedRow();
        if (filac != -1) {

            this.idSexo = (int) jtCentral.getValueAt(filac, 4);
            CtrlConfTipoProveedor sex = new CtrlConfTipoProveedor();
            ArrayList<Object> list = sex.ConsultaCompleja(this.idSexo);
            ConfTipoProveedor tempObj = (ConfTipoProveedor) list.get(0);
            /// inicializa dspues de la clase
            lblid.setText(String.valueOf(jtCentral.getValueAt(filac, 0)));
            lblvalor.setText(String.valueOf(jtCentral.getValueAt(filac, 1)));
            lblsexo.setText(String.valueOf(tempObj.getStrValor()));
            lbltce.setText(String.valueOf(jtCentral.getValueAt(filac, 3)));
            lbltca.setText(String.valueOf(jtCentral.getValueAt(filac, 2)));
            this.idcentral = (int) jtCentral.getValueAt(filac, 0);
            this.setAditionalTable();
        }
    }
//</editor-fold>
    //</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Definición de Componentes">
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JTable jtCentral;
    private javax.swing.JTable jtDireccion;
    private javax.swing.JTable jtEstado;
    private javax.swing.JLabel lblid;
    private javax.swing.JLabel lblsexo;
    private javax.swing.JLabel lbltca;
    private javax.swing.JLabel lbltce;
    private javax.swing.JLabel lblvalor;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
//</editor-fold>
}
