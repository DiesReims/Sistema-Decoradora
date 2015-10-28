
package mx.com.diegoA.control.conexion;

import java.sql.*;
import mx.com.diegoA.entidad.claseEstatica.ecConexion;

/**
 *
 * @author Dies
 */
public class ctrlConexion {

    private Connection Con;
    private ecConexion ecCon = new ecConexion();

    //<editor-fold defaultstate="collapsed" desc="Constructor">
    public ctrlConexion() throws SQLException {

        try {

            Class.forName("com.mysql.jdbc.Driver");
            Con = DriverManager.getConnection(ecConexion.getUrl(), ecConexion.getUser(), ecConexion.getPassword());
        } catch (ClassNotFoundException classNotFound) {

            System.out.println(classNotFound.getMessage() + "Error, No se ha encontrado el Driver");
            System.exit(1);
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Metodos">
    public void cerrarConexion() throws SQLException {
        Con.close();

    }

    public Connection getCon() {
        return Con;
    }

    public void setCon(Connection Con) {
        this.Con = Con;
    }

    //</editor-fold>
}
