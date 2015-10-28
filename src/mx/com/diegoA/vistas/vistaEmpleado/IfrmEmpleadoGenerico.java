/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.diegoA.vistas.vistaEmpleado;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import mx.com.diegoA.control.control.CtrlConfEmpleado;
import mx.com.diegoA.entidad.entity.ConfEmpleado;

/**
 *
 * @author Dies
 */
public class IfrmEmpleadoGenerico extends javax.swing.JInternalFrame {

    ConfEmpleado BaseEntity;

    /**
     * Creates new form IfrmEmpleadoGenerico
     */
    public IfrmEmpleadoGenerico() {
        initComponents();
    }

    public IfrmEmpleadoGenerico(Object Usuario) {
        initComponents();
        this.BaseEntity = (ConfEmpleado) Usuario;       
        this.SetInitial();
    }

    public void SetInitial() {
        if (this.BaseEntity != null) {
            this.lblU.setText(BaseEntity.getStrUsuario());
            this.lblP.setText(BaseEntity.getStrContraseña());
        } else {
            this.lblU.setText("Super Usuario");
            this.lblP.setText("Contraseña no visible");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtValidaP = new javax.swing.JTextField();
        txtNuevaP = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblP = new javax.swing.JLabel();
        lblU = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Modificar Contraseña");

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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mx/com/diegoA/img/1412742088_People.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Nueva Contraseña:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Verificar Contraseña:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Modificar Contraseña");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Contraseña Actual:");

        lblP.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblP.setForeground(new java.awt.Color(51, 51, 51));
        lblP.setText("Aqui va la contraseña");

        lblU.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblU.setForeground(new java.awt.Color(51, 51, 51));
        lblU.setText("Aqui va la contraseña");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Usuario:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAceptar)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(33, 33, 33)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(78, 78, 78))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(138, 138, 138)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblU, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                            .addComponent(txtValidaP)
                            .addComponent(txtNuevaP)
                            .addComponent(lblP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel4)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblU)
                    .addComponent(jLabel6))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblP)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNuevaP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtValidaP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        //Cierra la ventana sin hacer nada
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // Genera la opción de guardar cambios de contraseña
        if(this.BaseEntity != null){
        if (this.ValidaDatos()) {
            try {
                CtrlConfEmpleado CCE = new CtrlConfEmpleado();
                this.BaseEntity.setStrContraseña(this.txtNuevaP.getText());
                if (CCE.Editar(this.BaseEntity)) {
                     JOptionPane.showMessageDialog(null,"¡Cambio de contraseña exitoso! \n Reinicia el sistema para ver los cambios");
                }else{
                    JOptionPane.showMessageDialog(null,"Error en el cambio de contraseña","Error interno",JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {
                Logger.getLogger(IfrmEmpleadoGenerico.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            
        }
        }else{
            JOptionPane.showMessageDialog(null,"No se puede modificar","Sesión Root",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private boolean ValidaDatos() {
        if (this.txtNuevaP.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null,"Rellene el campo de nueva contraseña","Error falta de datos",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (this.txtValidaP.getText().trim().equals("")) {
             JOptionPane.showMessageDialog(null,"Rellene el campo de valida contraseña","Error falta de datos",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!this.txtNuevaP.getText().equals(this.txtValidaP.getText())) {
             JOptionPane.showMessageDialog(null,"Nuevas contraseñas no coinciden","Error Incongruencia",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblP;
    private javax.swing.JLabel lblU;
    private javax.swing.JTextField txtNuevaP;
    private javax.swing.JTextField txtValidaP;
    // End of variables declaration//GEN-END:variables
}
