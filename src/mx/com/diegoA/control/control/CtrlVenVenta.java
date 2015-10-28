package mx.com.diegoA.control.control;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.com.diegoA.control.Icontrol.IAccionesDB;
import mx.com.diegoA.control.conexion.ctrlConexion;
import mx.com.diegoA.entidad.entity.ConfEstadoGlobal;
import mx.com.diegoA.entidad.entity.VenVenta;
import mx.com.diegoA.entidad.entity.VenVenta;

/**
 *
 * @author Dies
 */
public class CtrlVenVenta extends ctrlConexion implements IAccionesDB {

    private ctrlConexion ctrlConexion;

    public CtrlVenVenta() throws SQLException {

        this.ctrlConexion = new ctrlConexion();

    }

    //<editor-fold defaultstate="collapsed" desc="Metodos">
    @Override
    public boolean Agregar(Object _O) {
        try {
            VenVenta objTemp = (VenVenta) _O;
            PreparedStatement Agregar;
            Agregar = ctrlConexion.getCon().prepareStatement("Insert into VenVenta (IdVenPresupuesto,dtFecha,IdVenEstadoVenta) values (?,?,?)");
            Agregar.setInt(1, objTemp.getIdVenPresupuesto());
            Agregar.setDate(2, objTemp.getDtFecha());
            Agregar.setInt(3, objTemp.getIdVenEstadoVenta());
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
            VenVenta objTemp = (VenVenta) _O;

            String temp = "Update VenVenta set IdVenPresupuesto =" + objTemp.getIdVenPresupuesto() + ",IdVenEstadoVenta =" + objTemp.getIdVenEstadoVenta()
                    + ",DtFecha='" + objTemp.getDtFecha() + "' where ID = ?;";

            System.out.println(temp);
            PreparedStatement Modificar;
            Modificar = ctrlConexion.getCon().prepareStatement("Update VenVenta set IdVenPresupuesto =" + objTemp.getIdVenPresupuesto() + ",IdVenEstadoVenta =" + objTemp.getIdVenEstadoVenta()
                    + ",DtFecha='" + objTemp.getDtFecha() + "' where ID = ?;");
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
    public boolean ConsultaSimple(Object _O) {
        //Nunca se usa
        try {
            ResultSet todo;
            PreparedStatement Consultar;
            String uno, dos;
            int forey;
            Consultar = ctrlConexion.getCon().prepareStatement("select * from VenVenta;");
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
        VenVenta objTemp = (VenVenta) O;
        try {
            PreparedStatement Eliminar;
            Eliminar = ctrlConexion.getCon().prepareStatement("Delete from VenVenta where id=?;");
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
    public ArrayList<Object> ConsultaCompleja() {
        ArrayList<VenVenta> consulta = new ArrayList();
        PreparedStatement consultaCompleja;
        ResultSet resultado;

        try {
            consultaCompleja = ctrlConexion.getCon().prepareStatement("Select * from VenVenta;");
            resultado = consultaCompleja.executeQuery();
            while (resultado.next()) {
                VenVenta temp = new VenVenta();
                temp.setId(Integer.parseInt(resultado.getString(1)));
                temp.setIdVenPresupuesto(resultado.getInt(2));
                temp.setDtFecha(resultado.getDate(3));
                temp.setIdVenEstadoVenta(resultado.getInt(4));

                consulta.add(temp);

            }
            consultaCompleja.close();
            return new ArrayList(consulta);
        } catch (SQLException ex) {
            Logger.getLogger(CtrlVenVenta.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public ArrayList<Object> ConsultaCompleja(Object _obj) {

        ArrayList<VenVenta> consulta = new ArrayList();
        PreparedStatement consultaCompleja;
        ResultSet resultado;
        int idEstado = (int) _obj;

        try {
            consultaCompleja = ctrlConexion.getCon().prepareStatement("Select * from VenVenta where IdVenEstadoVenta = " + idEstado + ";");
            resultado = consultaCompleja.executeQuery();
            while (resultado.next()) {
                VenVenta temp = new VenVenta();
                temp.setId(Integer.parseInt(resultado.getString(1)));
                temp.setIdVenPresupuesto(resultado.getInt(2));
                temp.setDtFecha(resultado.getDate(3));
                temp.setIdVenEstadoVenta(resultado.getInt(4));

                consulta.add(temp);

            }
            consultaCompleja.close();
            return new ArrayList(consulta);
        } catch (SQLException ex) {
            Logger.getLogger(CtrlVenVenta.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public ArrayList<Object> ConsultaEspecializada(Object _O) {
        try {
            ArrayList<VenVenta> consulta = new ArrayList();
            PreparedStatement consultaCompleja;
            ResultSet resultado;
            VenVenta objTemp = (VenVenta) _O;
            String consultaBusqueda = "SELECT * FROM VenVenta";

            if (objTemp.getIdVenEstadoVenta() > 0) {
                consultaBusqueda += " where idconfestadoglobal = " + objTemp.getIdVenEstadoVenta();
            }
            if (null != objTemp.getStrBusqueda()) {
                if (!objTemp.getStrBusqueda().trim().equals("")) {
                    consultaBusqueda += " and strvalor like '%" + objTemp.getStrBusqueda() + "%'";
                }
            }
            consultaBusqueda += ";";
            consultaCompleja = ctrlConexion.getCon().prepareStatement(consultaBusqueda);
            resultado = consultaCompleja.executeQuery();
            while (resultado.next()) {
                VenVenta temp = new VenVenta();
                temp.setId(Integer.parseInt(resultado.getString(1)));
                temp.setIdVenPresupuesto(resultado.getInt(2));
                temp.setDtFecha(resultado.getDate(3));
                temp.setIdVenEstadoVenta(resultado.getInt(4));
                consulta.add(temp);
            }
            consultaCompleja.close();
            return new ArrayList(consulta);

        } catch (SQLException ex) {
            Logger.getLogger(CtrlVenVenta.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public int ConsultarUltimo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Object> ConsultaParaManager(Object _O) {
        ArrayList<VenVenta> consulta = new ArrayList();
        PreparedStatement consultaCompleja;
        ResultSet resultado;
        int idVenta = (int) _O;

        try {
            consultaCompleja = ctrlConexion.getCon().prepareStatement("Select * from VenVenta where id = " + idVenta + ";");
            resultado = consultaCompleja.executeQuery();
            while (resultado.next()) {
                VenVenta temp = new VenVenta();
                temp.setId(Integer.parseInt(resultado.getString(1)));
                temp.setIdVenPresupuesto(resultado.getInt(2));
                temp.setDtFecha(resultado.getDate(3));
                temp.setIdVenEstadoVenta(resultado.getInt(4));

                consulta.add(temp);

            }
            consultaCompleja.close();
            return new ArrayList(consulta);
        } catch (SQLException ex) {
            Logger.getLogger(CtrlVenVenta.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    //</editor-fold>

    @Override
    public ArrayList<Object> ConsultaEspecializada2(Object O, Object _obj2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
