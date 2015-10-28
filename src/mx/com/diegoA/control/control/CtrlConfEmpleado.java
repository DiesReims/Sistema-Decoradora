package mx.com.diegoA.control.control;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import mx.com.diegoA.control.Icontrol.IAccionesDB;
import mx.com.diegoA.control.conexion.ctrlConexion;
import mx.com.diegoA.entidad.entity.ConfEmpleado;
import mx.com.diegoA.entidad.entity.ConfSexo;

/**
 *
 * @author Dies
 */
public class CtrlConfEmpleado extends ctrlConexion implements IAccionesDB {

    ctrlConexion conexion;

    public CtrlConfEmpleado() throws SQLException {
        conexion = new ctrlConexion();
    }

    //<editor-fold defaultstate="collapsed" desc="Metodos">
    @Override
    public boolean Agregar(Object _O) {
        try {
            ConfEmpleado objTemp = (ConfEmpleado) _O;
            PreparedStatement Agregar;
            Agregar = conexion.getCon().prepareStatement("Insert into empleado (strUsuario,strpassword,idperfil) values (?,?,?)");
            Agregar.setString(1, objTemp.getStrUsuario());
            Agregar.setString(2, objTemp.getStrContraseña());
            Agregar.setInt(3, objTemp.getIdPerfil());
            Agregar.execute();
            Agregar.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
            System.out.println(e.getSQLState());
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean Editar(Object _O) {
        try {
            ConfEmpleado objTemp = (ConfEmpleado) _O;

            String temp = "Update Empleado set strusuario ='" + objTemp.getStrUsuario() + "',strpassword ='" + objTemp.getStrContraseña()
                    + "',idperfil=" + objTemp.getIdPerfil() + " where ID = ?;";

            System.out.println(temp);
            PreparedStatement Modificar;
            Modificar = conexion.getCon().prepareStatement("Update Empleado set strusuario ='" + objTemp.getStrUsuario() + "',strpassword ='" + objTemp.getStrContraseña()
                    + "',idperfil=" + objTemp.getIdPerfil() + " where ID = ?;");
            Modificar.setInt(1, objTemp.getId());
            Modificar.execute();
            Modificar.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
            System.out.println(e.getSQLState());
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean ConsultaSimple(Object O) {
        System.out.println("Entra a la consulta");
        try {
            ConfEmpleado objTemp = (ConfEmpleado) O;
            System.out.println("Resivio: Constraseña: " + objTemp.getStrContraseña() + " Usuario: " + objTemp.getStrUsuario());
            PreparedStatement consultaCompleja;
            ResultSet resultado;
            String prueba = "Select * from empleado"
                    + "where strusuario= '" + objTemp.getStrUsuario()
                    + "' and strpassword= '" + objTemp.getStrContraseña() + "';";
            System.out.println(prueba);
            consultaCompleja = conexion.getCon().prepareStatement("Select * from empleado "
                    + "where strusuario= '" + objTemp.getStrUsuario()
                    + "' and strpassword= '" + objTemp.getStrContraseña() + "';");
            resultado = consultaCompleja.executeQuery();
            while (resultado.next()) {
                System.out.println(resultado.getInt(4));
                if (resultado.getInt(4) > 0) {
                    return true;
                }
            }
            JOptionPane.showMessageDialog(null, "Tus datos son Incorrectos", "Error ingreso", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(CtrlConfEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No Puede Ingresar");
            return false;
        }
        return false;
    }

    @Override
    public boolean Eliminar(Object O) {
        ConfEmpleado objTemp = (ConfEmpleado) O;
        try {
            PreparedStatement Eliminar;
            Eliminar = conexion.getCon().prepareStatement("Delete from confmarca where id=?;");
            Eliminar.setInt(1, objTemp.getId());
            Eliminar.execute();
            Eliminar.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
            System.out.println(e.getSQLState());
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public ArrayList<Object> ConsultaEspecializada(Object O) {
        try {
            ArrayList<ConfEmpleado> consulta = new ArrayList();
            PreparedStatement consultaCompleja;
            ResultSet resultado;
            ConfEmpleado objTemp = (ConfEmpleado) O;
            consultaCompleja = conexion.getCon().prepareStatement("Select * from empleado "
                    + "where strusuario= '" + objTemp.getStrUsuario()
                    + "' and strpassword= '" + objTemp.getStrContraseña() + "';");
            resultado = consultaCompleja.executeQuery();
            while (resultado.next()) {
                ConfEmpleado temp = new ConfEmpleado();
                temp.setId(resultado.getInt(1));
                temp.setIdPerfil(resultado.getInt(4));
                temp.setStrUsuario(resultado.getString(2));
                temp.setStrContraseña(resultado.getString(3));
                consulta.add(temp);

            }
            consultaCompleja.close();
            return new ArrayList(consulta);
        } catch (SQLException ex) {
            Logger.getLogger(CtrlConfEstadoGlobal.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public ArrayList<Object> ConsultaCompleja(Object _obj) {

        ArrayList<ConfEmpleado> consulta = new ArrayList();
        PreparedStatement consultaCompleja;
        ResultSet resultado;
        int idPerf = (int) _obj;
        System.out.println("El id recibido es perfil: " + idPerf);
        try {
            consultaCompleja = conexion.getCon().prepareStatement("Select * from Empleado where idperfil =" + idPerf + ";");
            resultado = consultaCompleja.executeQuery();
            while (resultado.next()) {
                ConfEmpleado temp = new ConfEmpleado();
                temp.setId(Integer.parseInt(resultado.getString(1)));
                temp.setStrUsuario(resultado.getString(2));
                temp.setStrContraseña(resultado.getString(3));
               temp.setIdPerfil(Integer.parseInt(resultado.getString(4)));

                consulta.add(temp);

            }
            consultaCompleja.close();
            return new ArrayList(consulta);
        } catch (SQLException ex) {
            Logger.getLogger(CtrlConfEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public ArrayList<Object> ConsultaCompleja() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ConsultarUltimo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Object> ConsultaParaManager(Object _O) {
        ArrayList<ConfEmpleado> consulta = new ArrayList();
        PreparedStatement consultaCompleja;
        ResultSet resultado;
        int idEmpleado = (int) _O;

        try {
            consultaCompleja = conexion.getCon().prepareStatement("Select * from Empleado where id = " + idEmpleado + ";");
            resultado = consultaCompleja.executeQuery();
            while (resultado.next()) {
                ConfEmpleado temp = new ConfEmpleado();
                temp.setId(Integer.parseInt(resultado.getString(1)));
                temp.setStrUsuario(resultado.getString(2));
                temp.setStrContraseña(resultado.getString(3));
                temp.setIdPerfil(resultado.getInt(4));

                consulta.add(temp);

            }
            consultaCompleja.close();
            return new ArrayList(consulta);
        } catch (SQLException ex) {
            Logger.getLogger(CtrlConfEstadoGlobal.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    //</editor-fold>

    @Override
    public ArrayList<Object> ConsultaEspecializada2(Object _O, Object _obj2) {
        try {
            ArrayList<ConfEmpleado> consulta = new ArrayList();
            PreparedStatement consultaCompleja;
            ResultSet resultado;
            ConfEmpleado objTemp = (ConfEmpleado) _O;
            String consultaBusqueda = "SELECT * FROM Empleado";

            if (objTemp.getIdPerfil()> 0) {
                consultaBusqueda += " where idPerfil = " + objTemp.getIdPerfil();
            }
            if (null != objTemp.getStrBusqueda()) {
                if (!objTemp.getStrBusqueda().trim().equals("")) {
                    consultaBusqueda += " and strUsuario like '%" + objTemp.getStrBusqueda() + "%'";
                }
            }

            consultaBusqueda += ";";
            consultaCompleja = conexion.getCon().prepareStatement(consultaBusqueda);
            resultado = consultaCompleja.executeQuery();
            while (resultado.next()) {
                ConfEmpleado temp = new ConfEmpleado();
                temp.setId(Integer.parseInt(resultado.getString(1)));
                temp.setStrUsuario(resultado.getString(2));
                temp.setStrContraseña(resultado.getString(3));
                temp.setIdPerfil(resultado.getInt(4));
                consulta.add(temp);
            }
            consultaCompleja.close();
            return new ArrayList(consulta);

        } catch (SQLException ex) {
            Logger.getLogger(CtrlConfEstadoGlobal.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
