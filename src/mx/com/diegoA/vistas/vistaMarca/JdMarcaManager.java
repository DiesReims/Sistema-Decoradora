package mx.com.diegoA.vistas.vistaMarca;

import java.awt.Dialog;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import mx.com.diegoA.control.Icontrol.IManager;
import mx.com.diegoA.control.conexion.ctrlConexion;
import mx.com.diegoA.control.control.CtrlConfEstadoGlobal;
import mx.com.diegoA.entidad.entity.ConfEstadoGlobal;
import mx.com.diegoA.entidad.entity.ConfMarca;


/**
 *
 * @author Dies
 */
public class JdMarcaManager extends javax.swing.JDialog implements IManager {

    //<editor-fold defaultstate="collapsed" desc="Cuerpo Marca Manager">
    //<editor-fold defaultstate="collapsed" desc="Variables">
    private ConfMarca baseEntity;
    private int idEstado;
    private ctrlConexion conexion;
    private int idAccion = 0;
    boolean conCambios = false;
    private boolean camTxt = false;
    private boolean camCombo = false;
    private boolean camJTable = false;
    PreparedStatement consulta;
    ResultSet rConsulta;
    String prueba = "Hola";
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructor">
    /**
     * Creates new form JdMarcaManager
     */
    public JdMarcaManager(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public JdMarcaManager() throws SQLException {
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
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblTitulo = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblAccion = new javax.swing.JLabel();
        picImage = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(" Marca");

        txtValor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtValorMouseClicked(evt);
            }
        });
        txtValor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                verificaCajaSimple(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Nombre:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Descripción:");

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        txtDescripcion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtDescripcionMouseClicked(evt);
            }
        });
        txtDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDescripcionKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(txtDescripcion);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Estado:");

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(51, 51, 51));
        lblTitulo.setText("Marca -");

        lblAccion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblAccion.setForeground(new java.awt.Color(51, 51, 51));
        lblAccion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAccion.setText("Insertar");

        picImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mx/com/diegoA/img/1412742095_marked_price.png"))); // NOI18N

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cmbEstado, 0, 406, Short.MAX_VALUE)
                                .addComponent(txtValor))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnAceptar)
                                .addGap(20, 20, 20)
                                .addComponent(btnCancelar)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(picImage)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(325, 325, 325)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(lblTitulo)
                                .addGap(120, 120, 120)
                                .addComponent(lblAccion, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
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
                    .addComponent(jLabel1)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //<editor-fold defaultstate="collapsed" desc="Botones y eventos">

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        try {
            this.DetectaCambioCombo();
            if (camCombo == true || camTxt == true || camJTable == true) {
                int res = JOptionPane.showConfirmDialog(null, "Has realizado Cambio, estas seguro de guardarlos");
                if (res == 0) {
                    JOptionPane.showMessageDialog(null, "Hubo un Cambio");
                    if (this.validaDatos() == true) {
                        this.baseEntity.setStrvalor(this.txtValor.getText().trim());
                        this.baseEntity.setStrdescripcion(this.txtDescripcion.getText().trim());
                        //aqui falta la linea para obtener el combo seleccionado
                        if (this.idAccion == 0) {
                            this.baseEntity.setIdconfestadoglobal(this.cmbEstado.getSelectedIndex());
                        } else {
                            this.baseEntity.setIdconfestadoglobal(this.cmbEstado.getSelectedIndex() + 1);
                        }
                        //se cierra la pantalla
                        this.conCambios = false;
                        this.camCombo = false;
                        this.camJTable = false;
                        this.camTxt = false;
                        this.dispose();
                    }
                }
            } else {
                this.dispose();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getLocalizedMessage());
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void txtDescripcionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyPressed

    }//GEN-LAST:event_txtDescripcionKeyPressed

    private void verificaCajaSimple(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_verificaCajaSimple
        // TODO add your handling code here:

    }//GEN-LAST:event_verificaCajaSimple

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // Boton cancelar vuelve el objeto NULL
        this.baseEntity = null;
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtValorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtValorMouseClicked
        // Llama el evento de cambio
        this.DetectaCambio(this.txtValor);
    }//GEN-LAST:event_txtValorMouseClicked

    private void txtDescripcionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDescripcionMouseClicked
        // Llama el evento de cambio
        this.DetectaCambioJTArea( this.txtDescripcion);
    }//GEN-LAST:event_txtDescripcionMouseClicked
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
            java.util.logging.Logger.getLogger(JdMarcaManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JdMarcaManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JdMarcaManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JdMarcaManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JdMarcaManager dialog = new JdMarcaManager(new javax.swing.JFrame(), true);
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

    //<editor-fold defaultstate="collapsed" desc="Declaración de componentes">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox cmbEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblAccion;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel picImage;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Metodos Implementar">
    @Override
    public Object showDialog(Object _obj) {
        this.baseEntity = (ConfMarca) _obj;
        this.idAccion = (this.baseEntity != null) ? this.baseEntity.getId() : 0;
        if (this.idAccion == 0) {
            this.baseEntity = new ConfMarca();
        }
        this.idEstado = this.baseEntity.getIdconfestadoglobal();//obtener el id de estado para el combo de editar
        this.setLoadInformation();
        this.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        this.setVisible(true);
        return (this.baseEntity != null) ? this.baseEntity : null;
    }

    @Override
    public boolean validaDatos() {
        if (this.txtValor.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "El campo de nombre se encuentra vacio");
            return false;
        }
        if (this.idAccion == 0) {
            if (this.cmbEstado.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "Seleccione una opción valida de Estado");
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
            CtrlConfEstadoGlobal estadoG = new CtrlConfEstadoGlobal();
            ArrayList<Object> lista = estadoG.ConsultaCompleja();
            if (this.idAccion == 0) {
                //leyenda seleccionar
                x.addElement("SELECCIONA");
                for (int i = 0; i < lista.size(); i++) {
                    ConfEstadoGlobal tempObject = (ConfEstadoGlobal) lista.get(i);
                    x.addElement(tempObject);
                }

                cmbEstado.setModel(x);
            } else {
                for (int i = 0; i < lista.size(); i++) {
                    ConfEstadoGlobal tempObject = (ConfEstadoGlobal) lista.get(i);
                    x.addElement(tempObject);
                }
                cmbEstado.setModel(x);
                this.setComboBox();
            }

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(JdMarcaManager.class.getName()).log(Level.SEVERE, null, ex);
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
        if (this.idEstado > 0) {
            this.cmbEstado.setSelectedIndex(this.idEstado - 1);
        }
    }

    @Override
    public void setTextField() {
        this.txtValor.setText(((this.baseEntity != null) ? this.baseEntity.getStrvalor() : " "));
        this.txtDescripcion.setText(((this.baseEntity != null) ? this.baseEntity.getStrdescripcion() : " "));

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

    //<editor-fold defaultstate="collapsed" desc="Detecta cambio combo: Evento">
    private void DetectaCambioCombo() {
        if (this.idAccion == 0) {
            if (this.cmbEstado.getSelectedIndex() >= 0) {
                this.camCombo = true;
            }

        } else if (this.idAccion > 0) {

            ConfEstadoGlobal x = (ConfEstadoGlobal) cmbEstado.getSelectedItem();
            System.out.println(x.getId() + this.baseEntity.getIdconfestadoglobal());
            if (x.getId() != this.baseEntity.getIdconfestadoglobal()) {
                this.camCombo = true;
            }
        }
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Detecta cambio JTArea">
    private void DetectaCambioJTArea(JTextArea txt){
         DocumentListener documentListener = new DocumentListener() {

            @Override
            public void changedUpdate(DocumentEvent documentEvent) {
                camTxt = true;
            }

            @Override
            public void insertUpdate(DocumentEvent documentEvent) {
                camTxt = true;
            }

            @Override
            public void removeUpdate(DocumentEvent documentEvent) {
                camTxt = true;
            }
        };
        txt.getDocument().addDocumentListener(documentListener);
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Detecta cambio JTField ">
    private void DetectaCambio(JTextField txt) {
        DocumentListener documentListener = new DocumentListener() {

            @Override
            public void changedUpdate(DocumentEvent documentEvent) {
                camTxt = true;
            }

            @Override
            public void insertUpdate(DocumentEvent documentEvent) {
                camTxt = true;
            }

            @Override
            public void removeUpdate(DocumentEvent documentEvent) {
                camTxt = true;
            }
        };
        txt.getDocument().addDocumentListener(documentListener);

    }
    //</editor-fold>
//</editor-fold>
    //</editor-fold>
}
