package mx.com.diegoA.vistas.Direccion;

import java.awt.Dialog;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import mx.com.diegoA.control.Icontrol.IManager;
import mx.com.diegoA.control.conexion.ctrlConexion;
import mx.com.diegoA.control.control.CtrlConfEstados;
import mx.com.diegoA.control.control.CtrlConfMunicipios;
import mx.com.diegoA.entidad.entity.ConfDireccionProveedor;
import mx.com.diegoA.entidad.entity.ConfEstados;
import mx.com.diegoA.entidad.entity.ConfMunicipios;

public class JdDireccionProveedorManager extends javax.swing.JDialog implements IManager {

    //<editor-fold defaultstate="collapsed" desc="Cuerpo Direccion Manager">
    //<editor-fold defaultstate="collapsed" desc="Variables">
    private ConfDireccionProveedor baseEntity;
    private int idMunicipio = 0;
    private int idEstado;
    private String Estado;
    private String Muni;
    
    private ctrlConexion conexion;
    private int idAccion = 0;
    boolean conCambios = false;
    PreparedStatement consulta;
    ResultSet rConsulta;
    String prueba = "Hola";
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructor">
    /**
     * Creates new form JdMarcaManager
     */
    public JdDireccionProveedorManager(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public JdDireccionProveedorManager() throws SQLException {
        this.setDefaultCloseOperation(0);
        initComponents();
        this.setLocationRelativeTo(null);
        conexion = new ctrlConexion();
        this.setLoadInformation();
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

        jLabel4 = new javax.swing.JLabel();
        cmbEstado = new javax.swing.JComboBox();
        txtValor = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblTitulo = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblAccion = new javax.swing.JLabel();
        picImage = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cmbMunicipio = new javax.swing.JComboBox();
        lblMunicipio = new javax.swing.JLabel();
        txtColonia = new javax.swing.JTextField();

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Direccion proveedor");

        cmbEstado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbEstadoItemStateChanged(evt);
            }
        });

        txtValor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                verificaCajaSimple(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Calle:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Colonia:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Estado:");

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(51, 51, 51));
        lblTitulo.setText("Direccion P-");

        lblAccion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblAccion.setForeground(new java.awt.Color(51, 51, 51));
        lblAccion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAccion.setText("Insertar");

        picImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mx/com/diegoA/img/1412742109_House.png"))); // NOI18N

        btnAceptar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAceptar.setForeground(new java.awt.Color(51, 51, 51));
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(51, 51, 51));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("*");

        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("*");

        cmbMunicipio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbMunicipio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbMunicipioItemStateChanged(evt);
            }
        });

        lblMunicipio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblMunicipio.setForeground(new java.awt.Color(102, 102, 102));
        lblMunicipio.setText("Municipio:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(picImage)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(325, 325, 325)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(55, 55, 55)
                                        .addComponent(lblAccion, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(lblMunicipio))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbEstado, 0, 406, Short.MAX_VALUE)
                            .addComponent(txtValor)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnAceptar)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelar))
                            .addComponent(cmbMunicipio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtColonia))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(picImage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblTitulo)
                                    .addComponent(lblAccion, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMunicipio)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtColonia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //<editor-fold defaultstate="collapsed" desc="Botones y Eventos">
    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        try {
            
            if (this.validaDatos() == true) {
                this.baseEntity.setStrValor(this.txtValor.getText().trim());
                this.baseEntity.setStrColonia(this.txtColonia.getText().trim());
                //aqui falta la linea para obtener el combo seleccionado
                this.baseEntity.setIdConfEstado(this.idEstado);
                ConfMunicipios est1 = (ConfMunicipios) cmbMunicipio.getSelectedItem();
                this.idMunicipio = est1.getId();
                this.Muni = est1.getNombre();
                this.baseEntity.setIdConfMunicipio(this.idMunicipio);
                //se cierra la pantalla
                this.dispose();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getLocalizedMessage());
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void verificaCajaSimple(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_verificaCajaSimple
        // TODO add your handling code here:

    }//GEN-LAST:event_verificaCajaSimple

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // Boton cancelar vuelve el objeto NULL
        this.baseEntity = null;
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cmbEstadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbEstadoItemStateChanged
        // TODO add your handling code here:
        ConfEstados est = (ConfEstados) cmbEstado.getSelectedItem();
        this.idEstado = est.getId();
        this.Estado = est.getNombre();
        
        Clear_Combo();
    }//GEN-LAST:event_cmbEstadoItemStateChanged

    private void cmbMunicipioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbMunicipioItemStateChanged

    }//GEN-LAST:event_cmbMunicipioItemStateChanged
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Main">
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
            java.util.logging.Logger.getLogger(JdDireccionProveedorManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JdDireccionProveedorManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JdDireccionProveedorManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JdDireccionProveedorManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JdDireccionProveedorManager dialog = new JdDireccionProveedorManager(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Declaracion de componentes">

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox cmbEstado;
    private javax.swing.JComboBox cmbMunicipio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblAccion;
    private javax.swing.JLabel lblMunicipio;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel picImage;
    private javax.swing.JTextField txtColonia;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Metodos Implementar">
    @Override
    public Object showDialog(Object _obj) {
        this.baseEntity = (ConfDireccionProveedor) _obj;
        //this.idAccion = (this.baseEntity != null) ? this.baseEntity.getId():0;  

        if (this.baseEntity == null) {
            this.idAccion = 0;
        }
        if (this.baseEntity != null && this.baseEntity.getId() == 0) {
            this.idAccion = 1;
        }
        if (this.baseEntity != null && this.baseEntity.getId() > 0) {
            this.idAccion = this.baseEntity.getId();
        }
        //si entidad  == null = 0
        //si entidad  != null && id == 0 editar
        //si entidad != nul && id >0 edita

        if (this.idAccion == 0) {
            this.baseEntity = new ConfDireccionProveedor();
        }
        this.idEstado = this.baseEntity.getIdConfEstado();//obtener el id de estado para el combo de editar
        this.idMunicipio = this.baseEntity.getIdConfMunicipio();//obtiene el id para el combo de editar
        this.setLoadInformation();
        this.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        //this.setBounds(600, 500, 500, 500);
        this.setVisible(true);
        return (this.baseEntity != null) ? this.baseEntity : null;
    }

    @Override
    public boolean validaDatos() {
        if (this.txtValor.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "El campo de calle se encuentra vacio");
            return false;
        }
        if (this.txtColonia.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "El campo de Colonia se encuentra vacio");
            return false;
        }
        if (this.idAccion == 0) {
            if (this.cmbEstado.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "Seleccione una opción valida de Estado");
                return false;
            }
            if (this.cmbMunicipio.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "Seleccione una opción valida de Municipio");
                return false;
            }
            

        }
        

        return true;
    }

    @Override
    public void setInformacion(int _id) {
        if (_id == 0) {
            this.lblAccion.setText("[Agregar]");
        } else {
            this.lblAccion.setText("[Editar]");
        }
    }

    @Override
    public void setEstatus() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getInformacion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean setComboBoxInitial() {

        DefaultComboBoxModel x = new DefaultComboBoxModel();
        try {
            CtrlConfEstados estado = new CtrlConfEstados();
            ArrayList<Object> lista = estado.ConsultaCompleja();
            if (this.idAccion == 0) {
                //leyenda seleccionar
                x.addElement("SELECCIONA");
                for (int i = 0; i < lista.size(); i++) {
                    ConfEstados tempObject = (ConfEstados) lista.get(i);
                    x.addElement(tempObject);
                }

                cmbEstado.setModel(x);
                return true;
            } else {
                for (int i = 0; i < lista.size(); i++) {
                    ConfEstados tempObject = (ConfEstados) lista.get(i);
                    x.addElement(tempObject);
                }
                // selecciona el combo de estado correspondiente

            }
            cmbEstado.setModel(x);
            this.setComboBox();
            if (this.idEstado > 0) {
                for (int i = 0; i < this.cmbEstado.getItemCount(); i++) {
                    ConfEstados objTemp = (ConfEstados) this.cmbEstado.getItemAt(i);
                    if (this.idEstado == objTemp.getId()) {
                        this.cmbEstado.setSelectedIndex(i);
                    }

                }
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(JdDireccionProveedorManager.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    @Override
    public boolean setLoadInformation() {
        this.setInformacion(this.idAccion);
        if (this.setComboBoxInitial() == false) {
            this.dispose();
        }
        this.setTextField();
        this.setComboBox();
        this.setTabla();
        this.setFecha();
        this.setCheck();
        this.setExtra();

        return true;
    }

    @Override
    public void setComboBox() {

        DefaultComboBoxModel xy = new DefaultComboBoxModel();
        try {
            CtrlConfMunicipios muni = new CtrlConfMunicipios();
            ArrayList<Object> lista = muni.ConsultaCompleja(this.idEstado);
            if (this.idAccion == 0) {
                //leyenda seleccionar
                xy.addElement("SELECCIONA");
                for (int i = 0; i < lista.size(); i++) {
                    ConfMunicipios tempObject = (ConfMunicipios) lista.get(i);
                    xy.addElement(tempObject);
                }
                cmbMunicipio.setModel(xy);
            } else {

                for (int i = 0; i < lista.size(); i++) {
                    ConfMunicipios tempObject = (ConfMunicipios) lista.get(i);
                    xy.addElement(tempObject);
                }

                //Selecciona el combo box correspondiente de municipio
            }
            cmbMunicipio.setModel(xy);

            if (this.idMunicipio > 0) {

                for (int i = 0; i < this.cmbMunicipio.getItemCount(); i++) {
                    ConfMunicipios objTemp = (ConfMunicipios) this.cmbMunicipio.getItemAt(i);
                    if (this.idMunicipio == objTemp.getId()) {
                        this.cmbMunicipio.setSelectedIndex(i);
                    }

                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(JdDireccionProveedorManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void setTextField() {
        this.txtValor.setText(((this.baseEntity != null) ? this.baseEntity.getStrValor() : " "));
        this.txtColonia.setText(((this.baseEntity != null) ? this.baseEntity.getStrColonia() : " "));

    }

    @Override
    public void setFecha() {

    }

    @Override
    public void setTabla() {

    }

    @Override
    public void setCheck() {

    }

    @Override
    public void setRadio() {

    }

    @Override
    public void setExtra() {

    }

    @Override
    public void huboCambio() {
        this.conCambios = true;
    }

    public void Clear_Combo() {
        int itemCount = cmbMunicipio.getItemCount();
        for (int i = 0; i < itemCount; i++) {
            cmbMunicipio.removeItemAt(0);
        }
        setComboBox();
    }
   //</editor-fold> 
    //</editor-fold>
}
