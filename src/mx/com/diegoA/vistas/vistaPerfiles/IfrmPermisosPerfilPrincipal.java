package mx.com.diegoA.vistas.vistaPerfiles;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import mx.com.diegoA.control.control.CtrlConfModulos;
import mx.com.diegoA.control.control.CtrlConfPMA;
import mx.com.diegoA.control.control.CtrlConfPerfiles;
import mx.com.diegoA.entidad.entity.ConfModulos;
import mx.com.diegoA.entidad.entity.ConfPMA;
import mx.com.diegoA.entidad.entity.ConfPerfiles;

/**
 *
 * @author Dies
 */
public class IfrmPermisosPerfilPrincipal extends javax.swing.JInternalFrame {

    //<editor-fold defaultstate="collapsed" desc="Variables">
    private boolean Bandera1 = true;
    private boolean Bandera2 = true;
    private boolean Bandera3 = true;
    private boolean Bandera4 = true;
    private int IdPerfil = 1;
    DefaultTableModel TMod;
//</editor-fold>

    public IfrmPermisosPerfilPrincipal() throws SQLException {
        initComponents();

        String[] cabecera = {"ID", "IDModulo", "Modulo", "Agregar", "Editar", "Eliminar", "Imprimir"};

        final Class[] tiposColumnas = new Class[]{
            java.lang.String.class,
            java.lang.String.class,
            java.lang.String.class,
            java.lang.Boolean.class,
            java.lang.Boolean.class,
            java.lang.Boolean.class,
            java.lang.Boolean.class
        // <- noten que aquí se especifica que la última columna es un botón
        };
        final Class[] tipoFilas = new Class[]{
            java.lang.String.class,
            java.lang.String.class,
            java.lang.String.class,
            java.lang.Boolean.class,
            java.lang.Boolean.class,
            java.lang.Boolean.class,
            java.lang.Boolean.class
        // <- noten que aquí se especifica que la última columna es un botón
        };

        Object[][] datos = {};

        this.InitComponents();

        this.TMod = new DefaultTableModel(datos, cabecera);

        Tablita.setModel(new javax.swing.table.DefaultTableModel(datos, cabecera) {
            Class[] tipos = tiposColumnas;
            Class[] filas = tipoFilas;

            public Class getColumnClass(int columnIndex) {
                // Este método es invocado por el CellRenderer para saber que dibujar en la celda,
                // observen que estamos retornando la clase que definimos de antemano.
                return tipos[columnIndex];
            }

            public Class getRowCountClass(int getRowCount) {
                return filas[getRowCount];//To change body of generated methods, choose Tools | Templates.
            }
        });

        //<editor-fold defaultstate="collapsed" desc="Evento de seleccion de toda la columna">  
        this.Tablita.getTableHeader().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                System.out.println(Bandera1);
                int col = Tablita.columnAtPoint(e.getPoint());
                String name = Tablita.getColumnName(col);
                System.out.println("Column index selected " + col + " " + name);

                if (col == 3) {
                    if (Bandera1) {

                        if (col > 0) {
                            for (int i = 0; i < Tablita.getRowCount(); i++) {
                                if (Tablita.getValueAt(i, col) != null) {
                                    Tablita.setValueAt(true, i, col);
                                }
                            }
                        }
                        Bandera1 = false;
                    } else {
                        if (col > 0) {
                            for (int i = 0; i < Tablita.getRowCount(); i++) {
                                if (Tablita.getValueAt(i, col) != null) {
                                    Tablita.setValueAt(false, i, col);
                                }
                            }
                        }
                        Bandera1 = true;
                    }
                }
                if (col == 4) {
                    if (Bandera2) {

                        if (col > 0) {
                            for (int i = 0; i < Tablita.getRowCount(); i++) {
                                if (Tablita.getValueAt(i, col) != null) {
                                    Tablita.setValueAt(true, i, col);
                                }
                            }
                        }
                        Bandera2 = false;
                    } else {
                        if (col > 0) {
                            for (int i = 0; i < Tablita.getRowCount(); i++) {
                                if (Tablita.getValueAt(i, col) != null) {
                                    Tablita.setValueAt(false, i, col);
                                }
                            }
                        }
                        Bandera2 = true;
                    }
                }
                if (col == 5) {
                    if (Bandera3) {

                        if (col > 0) {
                            for (int i = 0; i < Tablita.getRowCount(); i++) {
                                if (Tablita.getValueAt(i, col) != null) {
                                    Tablita.setValueAt(true, i, col);
                                }
                            }
                        }
                        Bandera3 = false;
                    } else {
                        if (col > 0) {
                            for (int i = 0; i < Tablita.getRowCount(); i++) {
                                if (Tablita.getValueAt(i, col) != null) {
                                    Tablita.setValueAt(false, i, col);
                                }
                            }
                        }
                        Bandera3 = true;
                    }
                }
                if (col == 6) {
                    if (Bandera4) {

                        if (col > 0) {
                            for (int i = 0; i < Tablita.getRowCount(); i++) {
                                if (Tablita.getValueAt(i, col) != null) {
                                    Tablita.setValueAt(true, i, col);
                                }
                            }
                        }
                        Bandera4 = false;
                    } else {
                        if (col > 0) {
                            for (int i = 0; i < Tablita.getRowCount(); i++) {
                                if (Tablita.getValueAt(i, col) != null) {
                                    Tablita.setValueAt(false, i, col);
                                }
                            }
                        }
                        Bandera4 = true;
                    }
                }
            }
        });
        //</editor-fold>

        Tablita.getColumn("ID").setPreferredWidth(0);
        Tablita.getColumn("ID").setMinWidth(0);
        Tablita.getColumn("ID").setMaxWidth(0);
        Tablita.getColumn("ID").setWidth(0);
        Tablita.getColumn("IDModulo").setPreferredWidth(0);
        Tablita.getColumn("IDModulo").setMinWidth(0);
        Tablita.getColumn("IDModulo").setMaxWidth(0);
        Tablita.getColumn("IDModulo").setWidth(0);

    }

    public void InitComponents() throws SQLException {
        this.setComboBox();
    }

    public void setComboBox() throws SQLException {
        DefaultComboBoxModel CMod = new DefaultComboBoxModel();
        CtrlConfPerfiles CPerfil = new CtrlConfPerfiles();
        ArrayList<Object> list = CPerfil.ConsultaCompleja();
        for (int i = 0; i < list.size(); i++) {
            ConfPerfiles objTemp = (ConfPerfiles) list.get(i);

            CMod.addElement(objTemp);

        }
        this.cmbPerfiles.setModel(CMod);
    }

//<editor-fold defaultstate="collapsed" desc="Codigo de java">
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbPerfiles = new javax.swing.JComboBox();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tablita = new javax.swing.JTable();
        btnCancelar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();

        setClosable(true);
        setTitle("-Permisos Perfil");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mx/com/diegoA/img/1412742123_User Card.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Permisos-Perfil");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Perfil:");

        cmbPerfiles.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbPerfiles.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbPerfilesItemStateChanged(evt);
            }
        });

        btnBuscar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(51, 51, 51));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        Tablita.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(Tablita);

        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(51, 51, 51));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnAceptar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAceptar.setForeground(new java.awt.Color(51, 51, 51));
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1))
                                .addGap(95, 95, 95)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cmbPerfiles, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnBuscar))))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAceptar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbPerfiles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnAceptar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try {
            this.clearTable();
            CtrlConfPMA CPMA = new CtrlConfPMA();
            CtrlConfModulos CMod = new CtrlConfModulos();
            ArrayList listPMA = CPMA.ConsultaCompleja(this.IdPerfil);
            ArrayList listCMod = CMod.ConsultaCompleja();
            for (int i = 0; i < listPMA.size(); i++) {
                Object[] filaTemp = new Object[7];
                ConfPMA tempObject = (ConfPMA) listPMA.get(i);
                filaTemp[0] = tempObject.getId();
                filaTemp[1] = tempObject.getIdModulo();
                for (int j = 0; j < listCMod.size(); j++) {
                    ConfModulos Modulo = (ConfModulos) listCMod.get(j);
                    if (tempObject.getIdModulo() == Modulo.getId()) {
                        filaTemp[2] = Modulo.getStrValor();
                    }
                }

                filaTemp[3] = tempObject.isAgregar();
                filaTemp[4] = tempObject.isEditar();
                filaTemp[5] = tempObject.isEliminar();
                filaTemp[6] = tempObject.isImprimir();
                this.TMod = (DefaultTableModel) this.Tablita.getModel();
                this.TMod.addRow(filaTemp);
                this.Tablita.setModel(TMod);

                Tablita.getColumn("ID").setPreferredWidth(0);
                Tablita.getColumn("ID").setMinWidth(0);
                Tablita.getColumn("ID").setMaxWidth(0);
                Tablita.getColumn("ID").setWidth(0);
                Tablita.getColumn("IDModulo").setPreferredWidth(0);
                Tablita.getColumn("IDModulo").setMinWidth(0);
                Tablita.getColumn("IDModulo").setMaxWidth(0);
                Tablita.getColumn("IDModulo").setWidth(0);
            }
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
            System.out.println(e.getMessage());
            System.out.println(e.getSQLState());
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void cmbPerfilesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbPerfilesItemStateChanged
        // Obtiene  el id del perfil
        ConfPerfiles objTemp = (ConfPerfiles) this.cmbPerfiles.getSelectedItem();
        this.IdPerfil = objTemp.getId();
        System.out.println("Id de perfil es: " + this.IdPerfil);
    }//GEN-LAST:event_cmbPerfilesItemStateChanged

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // Desencadena evento de modificar los registros del table
        if (this.Tablita.getRowCount() > 0) {
            try {
                CtrlConfPMA CPMA = new CtrlConfPMA();
                ArrayList<ConfPMA> listaEditar = new ArrayList();
                for (int i = 0; i < Tablita.getRowCount(); i++) {
                    ConfPMA PMA = new ConfPMA();
                    PMA.setId((Integer) this.Tablita.getValueAt(i, 0));
                    PMA.setIdModulo((Integer) this.Tablita.getValueAt(i, 1));
                    PMA.setIdPerfil(IdPerfil);
                    PMA.setAgregar((Boolean) this.Tablita.getValueAt(i, 3));
                    PMA.setEditar((Boolean) this.Tablita.getValueAt(i, 4));
                    PMA.setEliminar((Boolean) this.Tablita.getValueAt(i, 5));
                    PMA.setImprimir((Boolean) this.Tablita.getValueAt(i, 6));
                    if (CPMA.Editar(PMA)) {
//                      JOptionPane.showMessageDialog(null,"Configuración guardada con exito");
                        System.out.println("Registro guardado con exito");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al guardar configuración", "Error de perfiles", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(IfrmPermisosPerfilPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay datos que actualizar", "Ningun perfil", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // Boton para cerrar frame
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void clearTable() {
        for (int i = 0; i < Tablita.getRowCount(); i++) {
            TMod.removeRow(i);
            i -= 1;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tablita;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox cmbPerfiles;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
//</editor-fold>

}
