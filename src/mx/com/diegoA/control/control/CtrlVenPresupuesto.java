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
import mx.com.diegoA.entidad.entity.VenPresupuesto;
import mx.com.diegoA.entidad.entity.VenTrabajo;

/**
 *
 * @author Dies
 */
public class CtrlVenPresupuesto extends ctrlConexion implements IAccionesDB {

    ctrlConexion conexion;

    public CtrlVenPresupuesto() throws SQLException {
        conexion = new ctrlConexion();
    }

    //<editor-fold defaultstate="collapsed" desc="Metodos Implementar">
    @Override
    public boolean Agregar(Object _O) {
        try {
            VenPresupuesto objTemp = (VenPresupuesto) _O;
            PreparedStatement Agregar;
            Agregar = conexion.getCon().prepareStatement("Insert into venPresupuesto (IdConfCliente,strValor) values (?,?)");
            Agregar.setInt(1, objTemp.getIdConfCliente());
            Agregar.setString(2, objTemp.getStrValor());
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
            VenPresupuesto objTemp = (VenPresupuesto) _O;

            String temp = "Update venPresupuesto set strValor ='" + objTemp.getStrValor() + "', idconfCliente=" + objTemp.getIdConfCliente() + " where ID = ?;";

            System.out.println(temp);
            PreparedStatement Modificar;
            Modificar = conexion.getCon().prepareStatement("Update venPresupuesto set strValor ='" + objTemp.getStrValor() + "', idconfCliente=" + objTemp.getIdConfCliente() + " where ID = ?;");
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
        //Nunca se usa
        try {
            ResultSet todo;
            PreparedStatement Consultar;
            String uno, dos;
            int forey;
            Consultar = conexion.getCon().prepareStatement("select * from confcliente;");
            todo = Consultar.executeQuery();
            while (todo.next()) {
                System.out.println(todo.getString("strvalor") + " " + todo.getString("strdescripcion") + " " + todo.getInt("idconfestadoglobal"));
            }
            Consultar.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
            System.out.println(e.getSQLState());
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean Eliminar(Object O) {
        VenPresupuesto objTemp = (VenPresupuesto) O;
        PreparedStatement Eliminar = null;

        conexion.getCon();
        try {
            CtrlVenTrabajo ctrlDir = new CtrlVenTrabajo();
            VenTrabajo dir = new VenTrabajo();

            ArrayList<Object> list = ctrlDir.ConsultaCompleja(objTemp.getId());
//            for (int i = 0; i< list.size(); i++) {
//                dir = (ConfDireccion) list.get(i);
            conexion.getCon().setAutoCommit(false);
            if (list.size() > 0) {
                Eliminar = conexion.getCon().prepareStatement("Delete from confTrabajo where idvenpresupuesto=?;");
                Eliminar.setInt(1, objTemp.getId());
                System.out.println("Si borro los registros de Trabajo :D");
                Eliminar.execute();
            }

//            }
            try {

                Eliminar = conexion.getCon().prepareStatement("Delete from venPresupuesto where id=?;");
                Eliminar.setInt(1, objTemp.getId());
                Eliminar.execute();
                Eliminar.getConnection().commit();
                Eliminar.close();
            } catch (SQLException ex) {
                Eliminar.getConnection().rollback();
                Eliminar.close();
            }
            return true;

        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
            System.out.println(e.getSQLState());
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "No se pudo eliminar", "Hay referencias", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    @Override
    public ArrayList<Object> ConsultaEspecializada(Object _O) {
        try {
            ArrayList<VenPresupuesto> consulta = new ArrayList();
            PreparedStatement consultaCompleja;
            ResultSet resultado;
            VenPresupuesto objTemp = (VenPresupuesto) _O;
            String consultaBusqueda = "SELECT * FROM venPresupuesto";
            if (objTemp.getIdConfCliente() > 0) {
                consultaBusqueda += " where idconfcliente = " + objTemp.getIdConfCliente();
            }
            if (!objTemp.getStrBusqueda().trim().equals("")) {
                consultaBusqueda += " and strValor like '%" + objTemp.getStrBusqueda() + "%'";
            }
            consultaBusqueda += ";";
            consultaCompleja = conexion.getCon().prepareStatement(consultaBusqueda);
            resultado = consultaCompleja.executeQuery();
            while (resultado.next()) {
                VenPresupuesto temp = new VenPresupuesto();
                temp.setId(Integer.parseInt(resultado.getString(1)));
                temp.setIdConfCliente(Integer.parseInt(resultado.getString(2)));
                temp.setStrValor(resultado.getString(3));
                consulta.add(temp);
            }
            consultaCompleja.close();
            return new ArrayList(consulta);

        } catch (SQLException ex) {
            Logger.getLogger(CtrlVenPresupuesto.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public ArrayList<Object> ConsultaCompleja(Object _O) {
        ArrayList<VenPresupuesto> consulta = new ArrayList();
        PreparedStatement consultaCompleja;
        ResultSet resultado;
        int idCliente = (int) _O;

        try {
            consultaCompleja = conexion.getCon().prepareStatement("Select * from venPresupuesto where idconfCliente = " + idCliente + ";");
            resultado = consultaCompleja.executeQuery();
            while (resultado.next()) {
                VenPresupuesto temp = new VenPresupuesto();
                temp.setId(Integer.parseInt(resultado.getString(1)));
                temp.setIdConfCliente(Integer.parseInt(resultado.getString(2)));
                temp.setStrValor(resultado.getString(3));

                consulta.add(temp);

            }
            consultaCompleja.close();
            return new ArrayList(consulta);
        } catch (SQLException ex) {
            Logger.getLogger(CtrlVenPresupuesto.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public ArrayList<Object> ConsultaCompleja() {
        ArrayList<VenPresupuesto> consulta = new ArrayList();
        PreparedStatement consultaCompleja;
        ResultSet resultado;

        try {
            consultaCompleja = conexion.getCon().prepareStatement("Select * from venPresupuesto;");
            resultado = consultaCompleja.executeQuery();
            while (resultado.next()) {
                VenPresupuesto temp = new VenPresupuesto();
                temp.setId(Integer.parseInt(resultado.getString(1)));
                temp.setIdConfCliente(Integer.parseInt(resultado.getString(2)));
                temp.setStrValor(resultado.getString(3));
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
    public int ConsultarUltimo() {
        PreparedStatement consultaElUltimo;
        ResultSet elUltimo;
        int idUltimo = 0;
        try {
            consultaElUltimo = conexion.getCon().prepareStatement("select max(id) from venPresupuesto");
            elUltimo = consultaElUltimo.executeQuery();
            if (elUltimo.next()) {
                idUltimo = elUltimo.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CtrlConfDireccion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idUltimo;
    }

    @Override
    public ArrayList<Object> ConsultaParaManager(Object _O) {
        ArrayList<VenPresupuesto> consulta = new ArrayList();
        PreparedStatement consultaCompleja;
        ResultSet resultado;
        int idPresupuesto = (int) _O;

        try {
            consultaCompleja = conexion.getCon().prepareStatement("Select * from venPresupuesto where id = " + idPresupuesto + ";");
            resultado = consultaCompleja.executeQuery();
            while (resultado.next()) {
                VenPresupuesto temp = new VenPresupuesto();
                temp.setId(Integer.parseInt(resultado.getString(1)));
                temp.setIdConfCliente(Integer.parseInt(resultado.getString(2)));
                temp.setStrValor(resultado.getString(3));

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
    public ArrayList<Object> ConsultaEspecializada2(Object O, Object _obj2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
