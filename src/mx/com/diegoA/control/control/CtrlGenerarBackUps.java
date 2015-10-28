/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.diegoA.control.control;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import mx.com.diegoA.control.conexion.ctrlConexion;
import mx.com.diegoA.entidad.claseEstatica.ecConexion;

/**
 *
 * @author Dies
 */
public class CtrlGenerarBackUps {

    ctrlConexion BDC;

    public CtrlGenerarBackUps() throws SQLException {

        BDC = new ctrlConexion();

    }
    public String urlcero = "jdbc:mysql://localhost/";
    public Connection conn = null;
    public Statement stm;
    public static File nombrebackup = null;
    public static File rutabackup = null;
    public static int selecGuardaBack = 0;
    public static int selecRestauraBack = 0;
    public static int cantregsql = 0;
    public static int cantregsqlCA = 0;
    public static int conectadoMySQL = 0;
    public static String sqlcedulasopatend = null;
    public static String sqlingresos = null;
    public static String sqlegresos = null;
    
    public void conectar() throws SQLException {
        //try {
            System.out.print("Conectado metodos conectar");
            try {
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(ecConexion.getUrl(),ecConexion.getUser(),ecConexion.getPassword());
            if (conn != null) {

                System.out.print("Conectado metodos conectar");
                conectadoMySQL = 1;
                conn.close();
            }
            } catch (SQLException ex) {
            conectadoMySQL = 0;
            } catch (ClassNotFoundException ex) {
            conectadoMySQL = 0;
            }
        //} catch (ClassNotFoundException ex) {
           
    }

    public void conectarMySQL() throws SQLException, ClassNotFoundException {

        System.out.println("Conectado metodos conectarMySQL antes de try");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Conectado metodos conectarMySQLtry");
            conn = DriverManager.getConnection(urlcero, ecConexion.getUser(),ecConexion.getPassword());
            if (conn != null) {
                conectadoMySQL = 1;
                conn.close();
            }
        } catch (SQLException ex) {
            
            System.out.print("Conectado metodos conectarMySQL catch");
           conectadoMySQL = 0;
        } catch (ClassNotFoundException ex) {
            conectadoMySQL = 0;
        }
    }

    public void RestaurarBackup() throws SQLException {
ecConexion BDP = new ecConexion();

        java.sql.Statement sentencia = null;
        Connection coneccionini = null;
        //conectar();
        if (selecRestauraBack == 1) {
            if (conn != null) {
                try {
                    coneccionini = DriverManager.getConnection(urlcero,ecConexion.getUser(),ecConexion.getPassword());
                    sentencia = coneccionini.createStatement();
                    String SQLborra = "DROP DATABASE " + ecConexion.getBD();
                    sentencia.executeUpdate(SQLborra);
                    coneccionini = DriverManager.getConnection(urlcero,ecConexion.getUser(),ecConexion.getPassword());
                    sentencia = coneccionini.createStatement();
                    String SQL = "CREATE DATABASE " + ecConexion.getBD();
                    sentencia.executeUpdate(SQL);
                    Process child = Runtime.getRuntime().exec("cmd /c mysql --password=" + ecConexion.getPassword() + " --user=" + ecConexion.getUser() + " " + ecConexion.getBD() + " < " + nombrebackup);
                    JOptionPane.showMessageDialog(null, "Backup restaurado exitosamente!");
                } catch (SQLException ex) {
                } catch (IOException ex) {
                }
            } else if (conn == null) {
                try {
                    coneccionini = DriverManager.getConnection(urlcero, ecConexion.getUser(),ecConexion.getPassword());
                    sentencia = coneccionini.createStatement();
                    String SQLborra = "DROP DATABASE " + ecConexion.getBD();
                    sentencia.executeUpdate(SQLborra);
                    coneccionini = DriverManager.getConnection(urlcero, ecConexion.getUser(), ecConexion.getPassword());
                    sentencia = coneccionini.createStatement();
                    String SQL = "CREATE DATABASE " + ecConexion.getBD();
                    sentencia.executeUpdate(SQL);
                    Process child = Runtime.getRuntime().exec("cmd /c mysql --password=" + ecConexion.getPassword() + " --user=" + ecConexion.getUser() + " " + ecConexion.getBD() + " < " + nombrebackup);
                    JOptionPane.showMessageDialog(null, "Backup restaurado exitosamente!");
                } catch (SQLException ex) {
                } catch (IOException ex) {
                    Logger.getLogger(CtrlGenerarBackUps.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else if (selecRestauraBack == 0) {
            JOptionPane.showMessageDialog(null, "No se seleccionó ningun archivo de Backup!");
        }
    }
    
    public void AbrirRutaBackup() {
        JFileChooser chooser = new JFileChooser();
        chooser.setApproveButtonText("Abrir SQL");
        chooser.addChoosableFileFilter(new CtrlGenerarBackUps.SQLFilter());
        chooser.showOpenDialog(null);
        if (chooser.getSelectedFile() != null) {
            nombrebackup = chooser.getSelectedFile();
            selecRestauraBack = 1;
        } else if (chooser.getSelectedFile() == null) {
            selecRestauraBack = 0;
        }
    }
    
    public static class SQLFilter extends javax.swing.filechooser.FileFilter {

        final static String sql = "sql";

        public SQLFilter() {
        }

        public boolean accept(File f) {
            if (f.isDirectory()) {
                return true;
            }
            String s = f.getName();
            int i = s.lastIndexOf('.');

            if (i > 0 && i < s.length() - 1) {
                String extension = s.substring(i + 1).toLowerCase();
                if (sql.equals(extension)) {
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }

        @Override
        public String getDescription() {
            return "Archivos .sql";
        }
    }

    public void GuardarRutaBackup() {
        JFileChooser fc = new JFileChooser();
        fc.setApproveButtonText("Guardar Backup SQL");
        fc.addChoosableFileFilter(new CtrlGenerarBackUps.SQLFilter());
        fc.showSaveDialog(null);
        if (fc.getSelectedFile() != null) {
            rutabackup = fc.getSelectedFile();
            selecGuardaBack = 1;
        } else if (fc.getSelectedFile() == null) {
            selecGuardaBack = 0;
        }
    }
    
     public void CrearBackup() {
        if (selecGuardaBack == 1) {
            Runtime rt = Runtime.getRuntime();
            try {
                String command = "mysqldump --opt -u" + ecConexion.getUser() + " -p" + ecConexion.getPassword() + " " + ecConexion.getBD() + " -r" + rutabackup + ".sql";
                rt.exec(command);
                JOptionPane.showMessageDialog(null, "Backup creado exitosamente!");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else if (selecGuardaBack == 0) {
            JOptionPane.showMessageDialog(null, "No se creo ningún archivo de backup!");
        }
    }

}
