
package mx.com.diegoA.vistas;

import Ventanas.SplashScream;
import java.awt.Dimension;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.com.diegoA.entidad.entity.ConfEmpleado;
import mx.com.diegoA.entidad.entity.ConfPMA;
import mx.com.diegoA.vistas.vistaAcerca.IfrmAcerca;
import mx.com.diegoA.vistas.vistaBackUps.IfrmGeneraBackUps;
import mx.com.diegoA.vistas.vistaCliente.IfrmClientePrincipal;
import mx.com.diegoA.vistas.vistaColección.IfrmColeccionPrincipal;
import mx.com.diegoA.vistas.vistaColor.IfrmColorPrincipal;
import mx.com.diegoA.vistas.vistaDistribuidor.IfrmDistribuidorPrincipal;
import mx.com.diegoA.vistas.vistaEmpleado.IfrmEmpleadoGenerico;
import mx.com.diegoA.vistas.vistaEmpleado.IfrmEmpleadoPrincipal;
import mx.com.diegoA.vistas.vistaMarca.IfrmMarca;
import mx.com.diegoA.vistas.vistaMaterial.IfrmMaterialPrincipal;
import mx.com.diegoA.vistas.vistaPerfiles.IfrmPermisosPerfilPrincipal;
import mx.com.diegoA.vistas.vistaPersona.IfrmManagerPersona;
import mx.com.diegoA.vistas.vistaPersona.IfrmPersona;
import mx.com.diegoA.vistas.vistaPresupuesto.IfrmPresupuestoPrincipal;
import mx.com.diegoA.vistas.vistaProducto.IfrmProductoPrincipal;
import mx.com.diegoA.vistas.vistaVenta.IfrmVentaPrincipal;

/**
 *
 * @author Dies
 */
public class frmMenu extends javax.swing.JFrame {

    /**
     * Creates new form frmMenu
     */
    
    //<editor-fold defaultstate="collapsed" desc="Variables">
    IfrmPersona persona = new IfrmPersona();
    IfrmManagerPersona Mpersona = new IfrmManagerPersona();
    private int idPerfil;
    ArrayList<Object> listapermisos;
    ConfPMA PMATemp = new ConfPMA();
    ConfEmpleado Empleado;
    //<editor-fold defaultstate="collapsed" desc="Variables de menus">
    private boolean BoolCatMarca=true;
    private boolean BoolCatColeccion=true;
    private boolean BoolCatCliente=true;
    private boolean BoolCatDistribuidores=true;
    private boolean BoolCatMaterial=true;
    private boolean BoolCatColor=true;
    private boolean BoolCatProductos=true;
    private boolean BoolVenPresupuesto=true;
    private boolean BoolVenVenta=true;
    private boolean BoolAdPanelAdministrador=true; 
    private boolean BoolAdEmpleados = true;
//</editor-fold>
//</editor-fold>
    
   
    

    //<editor-fold defaultstate="collapsed" desc="Constructores">
    public frmMenu() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    public frmMenu(int idRoot) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.idPerfil = idRoot;
    }

    public frmMenu(ArrayList ListaControl,Object O) {
        initComponents();
        this.setLocationRelativeTo(null);
        ArrayList<Object> list = ListaControl;
        listapermisos = ListaControl;
        this.Empleado = (ConfEmpleado) O;
        for (int i = 0; i < list.size(); i++) {
            ConfPMA PMA = (ConfPMA) list.get(i);
            if (PMA.getIdModulo() == 1) {
                if ((PMA.isAgregar() == false) && (PMA.isEditar() == false) && (PMA.isEliminar() == false) && (PMA.isImprimir() == false)) {
                    this.jmMarca.setVisible(false);
                    this.BoolCatMarca = false;
                }
            }
            if (PMA.getIdModulo() == 2) {
                if ((PMA.isAgregar() == false) && (PMA.isEditar() == false) && (PMA.isEliminar() == false) && (PMA.isImprimir() == false)) {
                    this.jmColeccion.setVisible(false);
                    this.BoolCatColeccion = false;
                }

            }
            if (PMA.getIdModulo() == 3) {
                if ((!PMA.isAgregar()) && (!PMA.isEditar()) && (!PMA.isEliminar()) && (!PMA.isImprimir())) {
                    this.JmMaterial.setVisible(false);
                    this.BoolCatMaterial = false;
                }
            }
            if (PMA.getIdModulo() == 4) {
                if ((!PMA.isAgregar()) && (!PMA.isEditar()) && (!PMA.isEliminar()) && (!PMA.isImprimir())) {
                    this.jmColor.setVisible(false);
                    this.BoolCatColor = false;
                }
            }
            if (PMA.getIdModulo() == 5) {
                if ((!PMA.isAgregar()) && (!PMA.isEditar()) && (!PMA.isEliminar()) && (!PMA.isImprimir())) {
                    this.jmCliente.setVisible(false);
                    this.BoolCatCliente = false;
                }
            }
            if (PMA.getIdModulo() == 6) {
                if ((!PMA.isAgregar()) && (!PMA.isEditar()) && (!PMA.isEliminar()) && (!PMA.isImprimir())) {
                    this.jmDistribuidor.setVisible(false);
                    this.BoolCatDistribuidores = false;
                }
            }
            if (PMA.getIdModulo() == 7) {
                if ((!PMA.isAgregar()) && (!PMA.isEditar()) && (!PMA.isEliminar()) && (!PMA.isImprimir())) {
                    this.jmPresupuesto.setVisible(false);
                    this.BoolVenPresupuesto = false;
                }
            }
            if (PMA.getIdModulo() == 8) {
                if ((!PMA.isAgregar()) && (!PMA.isEditar()) && (!PMA.isEliminar()) && (!PMA.isImprimir())) {
                    this.jmVenta.setVisible(false);
                    this.BoolVenVenta = false;
                }
            }
            if (PMA.getIdModulo() == 9) {
                if ((!PMA.isAgregar()) && (!PMA.isEditar()) && (!PMA.isEliminar()) && (!PMA.isImprimir())) {
                    this.jmProductos.setVisible(false);
                    this.BoolCatProductos = false;
                }
            }
            if (PMA.getIdModulo() == 10) {
                if ((!PMA.isAgregar()) && (!PMA.isEditar()) && (!PMA.isEliminar()) && (!PMA.isImprimir())) {
                    this.jmPanelAdministrador.setVisible(false);
                    this.BoolAdPanelAdministrador = false;
                }
            }
             if (PMA.getIdModulo() == 11) {
                if ((!PMA.isAgregar()) && (!PMA.isEditar()) && (!PMA.isEliminar()) && (!PMA.isImprimir())) {
                    this.jmPanelAdministrador.setVisible(false);
                    this.BoolAdEmpleados = false;
                }
            }

        }
        this.HideMenu();
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Componentes de JAVA">
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        Escritorio = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        MCatalogos = new javax.swing.JMenu();
        jmMarca = new javax.swing.JMenuItem();
        jmColeccion = new javax.swing.JMenuItem();
        jmCliente = new javax.swing.JMenuItem();
        jmDistribuidor = new javax.swing.JMenuItem();
        JmMaterial = new javax.swing.JMenuItem();
        jmColor = new javax.swing.JMenuItem();
        jmProductos = new javax.swing.JMenuItem();
        MVentas = new javax.swing.JMenu();
        jmPresupuesto = new javax.swing.JMenuItem();
        jmVenta = new javax.swing.JMenuItem();
        MAdministrador = new javax.swing.JMenu();
        jmPanelAdministrador = new javax.swing.JMenuItem();
        jmUsuarios = new javax.swing.JMenuItem();
        jmBackup = new javax.swing.JMenu();
        jmGBackup = new javax.swing.JMenuItem();
        mUserLog = new javax.swing.JMenu();
        jmLogUser = new javax.swing.JMenuItem();
        jmCerrarSesión = new javax.swing.JMenuItem();
        jmReiniciarSistema = new javax.swing.JMenuItem();
        jmCerrarSistema = new javax.swing.JMenuItem();
        mAcerca = new javax.swing.JMenu();
        jmAcercaDe = new javax.swing.JMenuItem();

        jMenuItem3.setText("jMenuItem3");

        jMenuItem4.setText("jMenuItem4");

        jMenuItem5.setText("jMenuItem5");

        jMenuItem6.setText("jMenuItem6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Diego Sistema");
        setResizable(false);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dies\\Documents\\Paginas de ejemplos\\img\\pixel.png")); // NOI18N

        javax.swing.GroupLayout EscritorioLayout = new javax.swing.GroupLayout(Escritorio);
        Escritorio.setLayout(EscritorioLayout);
        EscritorioLayout.setHorizontalGroup(
            EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EscritorioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1253, Short.MAX_VALUE)
                .addContainerGap())
        );
        EscritorioLayout.setVerticalGroup(
            EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EscritorioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
                .addContainerGap())
        );
        Escritorio.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        MCatalogos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mx/com/diegoA/img/1412742147_Folder.png"))); // NOI18N

        jmMarca.setText("Registro Marcas");
        jmMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmMarcaActionPerformed(evt);
            }
        });
        MCatalogos.add(jmMarca);

        jmColeccion.setText("Registro Colecciones");
        jmColeccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmColeccionActionPerformed(evt);
            }
        });
        MCatalogos.add(jmColeccion);

        jmCliente.setText("Registro Cliente ");
        jmCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmClienteActionPerformed(evt);
            }
        });
        MCatalogos.add(jmCliente);

        jmDistribuidor.setText("Registro Distribuidores");
        jmDistribuidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmDistribuidorActionPerformed(evt);
            }
        });
        MCatalogos.add(jmDistribuidor);

        JmMaterial.setText("Registro Material");
        JmMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmMaterialActionPerformed(evt);
            }
        });
        MCatalogos.add(JmMaterial);

        jmColor.setText("Registro Color");
        jmColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmColorActionPerformed(evt);
            }
        });
        MCatalogos.add(jmColor);

        jmProductos.setText("Registro Productos");
        jmProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmProductosActionPerformed(evt);
            }
        });
        MCatalogos.add(jmProductos);

        jMenuBar1.add(MCatalogos);

        MVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mx/com/diegoA/img/1412742111_Calculator.png"))); // NOI18N

        jmPresupuesto.setText("Presupuesto");
        jmPresupuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmPresupuestoActionPerformed(evt);
            }
        });
        MVentas.add(jmPresupuesto);

        jmVenta.setText("Venta");
        jmVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmVentaActionPerformed(evt);
            }
        });
        MVentas.add(jmVenta);

        jMenuBar1.add(MVentas);

        MAdministrador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mx/com/diegoA/img/1412742103_Key.png"))); // NOI18N

        jmPanelAdministrador.setText("Panel de Administrador");
        jmPanelAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmPanelAdministradorActionPerformed(evt);
            }
        });
        MAdministrador.add(jmPanelAdministrador);

        jmUsuarios.setText("Usuarios");
        jmUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmUsuariosActionPerformed(evt);
            }
        });
        MAdministrador.add(jmUsuarios);

        jMenuBar1.add(MAdministrador);

        jmBackup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mx/com/diegoA/img/1412742100_Tool.png"))); // NOI18N
        jmBackup.setToolTipText("");
        jmBackup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmBackupActionPerformed(evt);
            }
        });

        jmGBackup.setText("Panel de Back-Up");
        jmGBackup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmGBackupActionPerformed(evt);
            }
        });
        jmBackup.add(jmGBackup);

        jMenuBar1.add(jmBackup);

        mUserLog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mx/com/diegoA/img/1412742115_User_info.png"))); // NOI18N

        jmLogUser.setText("Cambiar Contraseña");
        jmLogUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmLogUserActionPerformed(evt);
            }
        });
        mUserLog.add(jmLogUser);

        jmCerrarSesión.setText("Cerrar Sesión");
        jmCerrarSesión.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmCerrarSesiónActionPerformed(evt);
            }
        });
        mUserLog.add(jmCerrarSesión);

        jmReiniciarSistema.setText("Reiniciar Sistema");
        jmReiniciarSistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmReiniciarSistemaActionPerformed(evt);
            }
        });
        mUserLog.add(jmReiniciarSistema);

        jmCerrarSistema.setText("Cerrar Sistema");
        jmCerrarSistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmCerrarSistemaActionPerformed(evt);
            }
        });
        mUserLog.add(jmCerrarSistema);

        jMenuBar1.add(mUserLog);

        mAcerca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mx/com/diegoA/img/1412742097_Help.png"))); // NOI18N

        jmAcercaDe.setText("Acerca de...");
        jmAcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmAcercaDeActionPerformed(evt);
            }
        });
        mAcerca.add(jmAcercaDe);

        jMenuBar1.add(mAcerca);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//</editor-fold>
    
    private void JmMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmMaterialActionPerformed
        // Llama a personas
        IfrmMaterialPrincipal material;
        try {
            Escritorio.removeAll();
            Escritorio.repaint();

            if (this.idPerfil == -1) {
                material = new IfrmMaterialPrincipal();
            } else {
                for (int i = 0; i < this.listapermisos.size(); i++) {
                    ConfPMA PMA = (ConfPMA) this.listapermisos.get(i);

                    if (PMA.getIdModulo() == 3) {
                        this.PMATemp.setId(PMA.getId());
                        this.PMATemp.setIdModulo(PMA.getIdModulo());
                        this.PMATemp.setIdPerfil(PMA.getIdPerfil());
                        this.PMATemp.setAgregar(PMA.isAgregar());
                        this.PMATemp.setEditar(PMA.isEditar());
                        this.PMATemp.setEliminar(PMA.isEliminar());
                        this.PMATemp.setImprimir(PMA.isImprimir());
                    }

                }
                material = new IfrmMaterialPrincipal(this.PMATemp);
            }
            Escritorio.add(material);
            material.show();

        } catch (SQLException ex) {
            Logger.getLogger(frmMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_JmMaterialActionPerformed

    private void jmGBackupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmGBackupActionPerformed
        //Boton que generará el backup
        Escritorio.removeAll();
        Escritorio.repaint();
          IfrmGeneraBackUps BKUP;
        Escritorio.removeAll();
        Escritorio.repaint();
        BKUP = new IfrmGeneraBackUps();
        Escritorio.add(BKUP);
        Dimension EscritorioSize = Escritorio.getSize();
        Dimension jInternalFrameSize = BKUP.getSize();
        BKUP.setLocation((EscritorioSize.width - jInternalFrameSize.width) / 2,
                (EscritorioSize.height - jInternalFrameSize.height) / 2);
        BKUP.show();
    }//GEN-LAST:event_jmGBackupActionPerformed

    private void jmMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmMarcaActionPerformed
        // Abre formulario Marcas
        IfrmMarca marca;
        try {
            Escritorio.removeAll();
            Escritorio.repaint();

            if (this.idPerfil == -1) {
                marca = new IfrmMarca();
            } else {
                for (int i = 0; i < this.listapermisos.size(); i++) {
                    ConfPMA PMA = (ConfPMA) this.listapermisos.get(i);

                    if (PMA.getIdModulo() == 1) {
                        this.PMATemp.setId(PMA.getId());
                        this.PMATemp.setIdModulo(PMA.getIdModulo());
                        this.PMATemp.setIdPerfil(PMA.getIdPerfil());
                        this.PMATemp.setAgregar(PMA.isAgregar());
                        this.PMATemp.setEditar(PMA.isEditar());
                        this.PMATemp.setEliminar(PMA.isEliminar());
                        this.PMATemp.setImprimir(PMA.isImprimir());
                    }

                }
                marca = new IfrmMarca(this.PMATemp);
            }
            Escritorio.add(marca);
            marca.show();

        } catch (SQLException ex) {
            Logger.getLogger(frmMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jmMarcaActionPerformed

    private void jmClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmClienteActionPerformed
        // Abre formulario Clientes
        IfrmClientePrincipal cliente;
        try {
            Escritorio.removeAll();
            Escritorio.repaint();
            if (this.idPerfil == -1) {
                cliente = new IfrmClientePrincipal();
            } else {
                for (int i = 0; i < this.listapermisos.size(); i++) {
                    ConfPMA PMA = (ConfPMA) this.listapermisos.get(i);

                    if (PMA.getIdModulo() == 5) {
                        this.PMATemp.setId(PMA.getId());
                        this.PMATemp.setIdModulo(PMA.getIdModulo());
                        this.PMATemp.setIdPerfil(PMA.getIdPerfil());
                        this.PMATemp.setAgregar(PMA.isAgregar());
                        this.PMATemp.setEditar(PMA.isEditar());
                        this.PMATemp.setEliminar(PMA.isEliminar());
                        this.PMATemp.setImprimir(PMA.isImprimir());
                    }
                }
                cliente = new IfrmClientePrincipal(this.PMATemp);
            }
            Escritorio.add(cliente);
            cliente.show();
        } catch (SQLException ex) {
            Logger.getLogger(frmMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jmClienteActionPerformed

    private void jmColeccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmColeccionActionPerformed
        // Abre formulario Coleccion
        IfrmColeccionPrincipal coleccion;
        try {
            Escritorio.removeAll();
            Escritorio.repaint();
            if (this.idPerfil == -1) {
                coleccion = new IfrmColeccionPrincipal();
            } else {
                for (int i = 0; i < this.listapermisos.size(); i++) {
                    ConfPMA PMA = (ConfPMA) this.listapermisos.get(i);

                    if (PMA.getIdModulo() == 2) {
                        this.PMATemp.setId(PMA.getId());
                        this.PMATemp.setIdModulo(PMA.getIdModulo());
                        this.PMATemp.setIdPerfil(PMA.getIdPerfil());
                        this.PMATemp.setAgregar(PMA.isAgregar());
                        this.PMATemp.setEditar(PMA.isEditar());
                        this.PMATemp.setEliminar(PMA.isEliminar());
                        this.PMATemp.setImprimir(PMA.isImprimir());
                    }
                }
                coleccion = new IfrmColeccionPrincipal(this.PMATemp);
            }
            Escritorio.add(coleccion);
            coleccion.show();
        } catch (SQLException ex) {
            Logger.getLogger(frmMenu.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jmColeccionActionPerformed

    private void jmColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmColorActionPerformed
        IfrmColorPrincipal color;
        try {
            Escritorio.removeAll();
            Escritorio.repaint();
            if (this.idPerfil == -1) {
                color = new IfrmColorPrincipal();
            } else {
                for (int i = 0; i < this.listapermisos.size(); i++) {
                    ConfPMA PMA = (ConfPMA) this.listapermisos.get(i);

                    if (PMA.getIdModulo() == 4) {
                        this.PMATemp.setId(PMA.getId());
                        this.PMATemp.setIdModulo(PMA.getIdModulo());
                        this.PMATemp.setIdPerfil(PMA.getIdPerfil());
                        this.PMATemp.setAgregar(PMA.isAgregar());
                        this.PMATemp.setEditar(PMA.isEditar());
                        this.PMATemp.setEliminar(PMA.isEliminar());
                        this.PMATemp.setImprimir(PMA.isImprimir());
                    }
                }
                color = new IfrmColorPrincipal(this.PMATemp);
            }
            Escritorio.add(color);
            color.show();
        } catch (SQLException ex) {
            Logger.getLogger(frmMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jmColorActionPerformed

    private void jmDistribuidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmDistribuidorActionPerformed
        IfrmDistribuidorPrincipal distribuidor;
        try {
            Escritorio.removeAll();
            Escritorio.repaint();
            if (this.idPerfil == -1) {
                distribuidor = new IfrmDistribuidorPrincipal();
            } else {
                for (int i = 0; i < this.listapermisos.size(); i++) {
                    ConfPMA PMA = (ConfPMA) this.listapermisos.get(i);

                    if (PMA.getIdModulo() == 6) {
                        this.PMATemp.setId(PMA.getId());
                        this.PMATemp.setIdModulo(PMA.getIdModulo());
                        this.PMATemp.setIdPerfil(PMA.getIdPerfil());
                        this.PMATemp.setAgregar(PMA.isAgregar());
                        this.PMATemp.setEditar(PMA.isEditar());
                        this.PMATemp.setEliminar(PMA.isEliminar());
                        this.PMATemp.setImprimir(PMA.isImprimir());
                    }
                }
                distribuidor = new IfrmDistribuidorPrincipal(this.PMATemp);
            }
            Escritorio.add(distribuidor);
            distribuidor.show();
        } catch (SQLException ex) {
            Logger.getLogger(frmMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jmDistribuidorActionPerformed

    private void jmProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmProductosActionPerformed
        IfrmProductoPrincipal producto;
        try {
            Escritorio.removeAll();
            Escritorio.repaint();
            if (this.idPerfil == -1) {
                producto = new IfrmProductoPrincipal();
            } else {
                for (int i = 0; i < this.listapermisos.size(); i++) {
                    ConfPMA PMA = (ConfPMA) this.listapermisos.get(i);

                    if (PMA.getIdModulo() == 9) {
                        this.PMATemp.setId(PMA.getId());
                        this.PMATemp.setIdModulo(PMA.getIdModulo());
                        this.PMATemp.setIdPerfil(PMA.getIdPerfil());
                        this.PMATemp.setAgregar(PMA.isAgregar());
                        this.PMATemp.setEditar(PMA.isEditar());
                        this.PMATemp.setEliminar(PMA.isEliminar());
                        this.PMATemp.setImprimir(PMA.isImprimir());
                    }
                }
                producto = new IfrmProductoPrincipal(this.PMATemp);
            }
            Escritorio.add(producto);
            producto.show();
        } catch (SQLException ex) {
            Logger.getLogger(frmMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jmProductosActionPerformed

    private void jmPresupuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmPresupuestoActionPerformed
        // Abre formulario principal de 
        IfrmPresupuestoPrincipal presupuesto;
        try {
            Escritorio.removeAll();
            Escritorio.repaint();
            if (this.idPerfil == -1) {
                presupuesto = new IfrmPresupuestoPrincipal();
            } else {
                for (int i = 0; i < this.listapermisos.size(); i++) {
                    ConfPMA PMA = (ConfPMA) this.listapermisos.get(i);

                    if (PMA.getIdModulo() == 7) {
                        this.PMATemp.setId(PMA.getId());
                        this.PMATemp.setIdModulo(PMA.getIdModulo());
                        this.PMATemp.setIdPerfil(PMA.getIdPerfil());
                        this.PMATemp.setAgregar(PMA.isAgregar());
                        this.PMATemp.setEditar(PMA.isEditar());
                        this.PMATemp.setEliminar(PMA.isEliminar());
                        this.PMATemp.setImprimir(PMA.isImprimir());
                    }
                }
                presupuesto = new IfrmPresupuestoPrincipal(this.PMATemp);
            }
            Escritorio.add(presupuesto);
            presupuesto.show();
        } catch (SQLException ex) {
            Logger.getLogger(frmMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jmPresupuestoActionPerformed

    private void jmVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmVentaActionPerformed
        // Abre formulario principal de 
        IfrmVentaPrincipal presupuesto;
        try {
            Escritorio.removeAll();
            Escritorio.repaint();
            if (this.idPerfil == -1) {
                presupuesto = new IfrmVentaPrincipal();
            } else {
                for (int i = 0; i < this.listapermisos.size(); i++) {
                    ConfPMA PMA = (ConfPMA) this.listapermisos.get(i);

                    if (PMA.getIdModulo() == 8) {
                        this.PMATemp.setId(PMA.getId());
                        this.PMATemp.setIdModulo(PMA.getIdModulo());
                        this.PMATemp.setIdPerfil(PMA.getIdPerfil());
                        this.PMATemp.setAgregar(PMA.isAgregar());
                        this.PMATemp.setEditar(PMA.isEditar());
                        this.PMATemp.setEliminar(PMA.isEliminar());
                        this.PMATemp.setImprimir(PMA.isImprimir());
                    }
                }
                presupuesto = new IfrmVentaPrincipal(this.PMATemp);
            }
            Escritorio.add(presupuesto);
            presupuesto.show();
        } catch (SQLException ex) {
            Logger.getLogger(frmMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jmVentaActionPerformed

    private void jmPanelAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmPanelAdministradorActionPerformed
        // Abre gestion de perfiles
        IfrmPermisosPerfilPrincipal perfil;
        try {
            Escritorio.removeAll();
            Escritorio.repaint();
            perfil = new IfrmPermisosPerfilPrincipal();
            Escritorio.add(perfil);
            Dimension EscritorioSize = Escritorio.getSize();
            Dimension jInternalFrameSize = perfil.getSize();
            perfil.setLocation((EscritorioSize.width - jInternalFrameSize.width) / 2,
                    (EscritorioSize.height - jInternalFrameSize.height) / 2);
            perfil.show();
        } catch (SQLException ex) {
            Logger.getLogger(frmMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jmPanelAdministradorActionPerformed

    private void jmAcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmAcercaDeActionPerformed
        // Abre el formulario de Acerca de...
        IfrmAcerca acerca;
        Escritorio.removeAll();
        Escritorio.repaint();
        acerca = new IfrmAcerca();
        Escritorio.add(acerca);
        Dimension EscritorioSize = Escritorio.getSize();
        Dimension jInternalFrameSize = acerca.getSize();
        acerca.setLocation((EscritorioSize.width - jInternalFrameSize.width) / 2,
                (EscritorioSize.height - jInternalFrameSize.height) / 2);
        acerca.show();
    }//GEN-LAST:event_jmAcercaDeActionPerformed

    private void jmUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmUsuariosActionPerformed
        // Abre catalogo de Empleados
           // Abre formulario principal de 
        IfrmEmpleadoPrincipal presupuesto;
        try {
            Escritorio.removeAll();
            Escritorio.repaint();
            if (this.idPerfil == -1) {
                presupuesto = new IfrmEmpleadoPrincipal();
            } else {
                for (int i = 0; i < this.listapermisos.size(); i++) {
                    ConfPMA PMA = (ConfPMA) this.listapermisos.get(i);

                    if (PMA.getIdModulo() == 11) {
                        this.PMATemp.setId(PMA.getId());
                        this.PMATemp.setIdModulo(PMA.getIdModulo());
                        this.PMATemp.setIdPerfil(PMA.getIdPerfil());
                        this.PMATemp.setAgregar(PMA.isAgregar());
                        this.PMATemp.setEditar(PMA.isEditar());
                        this.PMATemp.setEliminar(PMA.isEliminar());
                        this.PMATemp.setImprimir(PMA.isImprimir());
                    }
                }
                presupuesto = new IfrmEmpleadoPrincipal(this.PMATemp);
            }
            Escritorio.add(presupuesto);
            presupuesto.show();
        } catch (SQLException ex) {
            Logger.getLogger(frmMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jmUsuariosActionPerformed

    private void jmLogUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmLogUserActionPerformed
        // Modifica la contraseña del usuario actual
        IfrmEmpleadoGenerico MU;
        Escritorio.removeAll();
        Escritorio.repaint();
        MU = new IfrmEmpleadoGenerico(this.Empleado);
        Escritorio.add(MU);
        Dimension EscritorioSize = Escritorio.getSize();
        Dimension jInternalFrameSize = MU.getSize();
        MU.setLocation((EscritorioSize.width - jInternalFrameSize.width) / 2,
                (EscritorioSize.height - jInternalFrameSize.height) / 2);
        MU.show();
    }//GEN-LAST:event_jmLogUserActionPerformed

    private void jmBackupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmBackupActionPerformed
        // Backup Panel
         IfrmGeneraBackUps BKUP;
        Escritorio.removeAll();
        Escritorio.repaint();
        BKUP = new IfrmGeneraBackUps();
        Escritorio.add(BKUP);
        Dimension EscritorioSize = Escritorio.getSize();
        Dimension jInternalFrameSize = BKUP.getSize();
        BKUP.setLocation((EscritorioSize.width - jInternalFrameSize.width) / 2,
                (EscritorioSize.height - jInternalFrameSize.height) / 2);
        BKUP.show();
    }//GEN-LAST:event_jmBackupActionPerformed

    private void jmCerrarSesiónActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmCerrarSesiónActionPerformed
        // Abre la ventana de logueo
       frmLogueo LogA = new frmLogueo();
       LogA.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_jmCerrarSesiónActionPerformed

    private void jmCerrarSistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmCerrarSistemaActionPerformed
        // Cierra el sistema
        this.dispose();
        System.exit(1);
    }//GEN-LAST:event_jmCerrarSistemaActionPerformed

    private void jmReiniciarSistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmReiniciarSistemaActionPerformed
        // Carga el sistema de nuevo
        new Thread(new SplashScream()).start();
        this.dispose();
    }//GEN-LAST:event_jmReiniciarSistemaActionPerformed

    public void HideMenu(){
        //Menu Catalogos
        if((this.BoolCatMarca == false)&&(this.BoolCatColeccion == false)&&(this.BoolCatColor == false)&&(this.BoolCatCliente == false)&&(this.BoolCatMaterial== false)&&(this.BoolCatProductos ==false)&&(this.BoolCatDistribuidores==false)){
            this.MCatalogos.setVisible(false);
        }
        if((this.BoolVenPresupuesto == false)&&(this.BoolVenVenta == false)){
            this.MVentas.setVisible(false);
        }
        if((this.BoolAdPanelAdministrador == false)&&(this.BoolAdEmpleados == false)){
            this.MAdministrador.setVisible(false);
        }
        
        if ((this.idPerfil != -1)||(this.idPerfil != 1)) {
            this.jmBackup.setVisible(false);
        }
        
    }
    //<editor-fold defaultstate="collapsed" desc="Cosas de JAVA">
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
            java.util.logging.Logger.getLogger(frmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new frmMenu().setVisible(true);
                frmMenu Menu = new frmMenu();
                Menu.setExtendedState(MAXIMIZED_BOTH);
                Menu.setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane Escritorio;
    private javax.swing.JMenuItem JmMaterial;
    private javax.swing.JMenu MAdministrador;
    private javax.swing.JMenu MCatalogos;
    private javax.swing.JMenu MVentas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jmAcercaDe;
    private javax.swing.JMenu jmBackup;
    private javax.swing.JMenuItem jmCerrarSesión;
    private javax.swing.JMenuItem jmCerrarSistema;
    private javax.swing.JMenuItem jmCliente;
    private javax.swing.JMenuItem jmColeccion;
    private javax.swing.JMenuItem jmColor;
    private javax.swing.JMenuItem jmDistribuidor;
    private javax.swing.JMenuItem jmGBackup;
    private javax.swing.JMenuItem jmLogUser;
    private javax.swing.JMenuItem jmMarca;
    private javax.swing.JMenuItem jmPanelAdministrador;
    private javax.swing.JMenuItem jmPresupuesto;
    private javax.swing.JMenuItem jmProductos;
    private javax.swing.JMenuItem jmReiniciarSistema;
    private javax.swing.JMenuItem jmUsuarios;
    private javax.swing.JMenuItem jmVenta;
    private javax.swing.JMenu mAcerca;
    private javax.swing.JMenu mUserLog;
    // End of variables declaration//GEN-END:variables
//</editor-fold>
}
