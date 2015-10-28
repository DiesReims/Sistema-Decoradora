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
import mx.com.diegoA.entidad.entity.ConfMarca;

/**
 *
 * @author Dies
 */
public class ctrlconfMarca extends ctrlConexion implements IAccionesDB {

    private ctrlConexion ctrlConexion;

    public ctrlconfMarca() throws SQLException {

        this.ctrlConexion = new ctrlConexion();

    }

    //<editor-fold defaultstate="collapsed" desc="Metodos">
    @Override
    public boolean Agregar(Object _O) {
        try {
            ConfMarca objTemp = (ConfMarca) _O;
            PreparedStatement Agregar;
            Agregar = ctrlConexion.getCon().prepareStatement("Insert into confMarca (strvalor,strdescripcion,idconfestadoglobal) values (?,?,?)");
            Agregar.setString(1, objTemp.getStrvalor());
            Agregar.setString(2, objTemp.getStrdescripcion());
            Agregar.setInt(3, objTemp.getIdconfestadoglobal());
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
            ConfMarca objTemp = (ConfMarca) _O;

            String temp = "Update confMarca set strvalor ='" + objTemp.getStrvalor() + "',strDescripcion ='" + objTemp.getStrdescripcion()
                    + "',idconfestadoglobal=" + objTemp.getIdconfestadoglobal() + " where ID = ?;";

            System.out.println(temp);
            PreparedStatement Modificar;
            Modificar = ctrlConexion.getCon().prepareStatement("Update confMarca set strvalor ='" + objTemp.getStrvalor() + "',strDescripcion ='" + objTemp.getStrdescripcion()
                    + "',idconfestadoglobal=" + objTemp.getIdconfestadoglobal() + " where ID = ?");
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
        try {
            ResultSet todo;
            PreparedStatement Consultar;
            String uno, dos;
            int forey;
            Consultar = ctrlConexion.getCon().prepareStatement("select * from confmarca;");
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
        ConfMarca objTemp = (ConfMarca) O;
        try {
            PreparedStatement Eliminar;
            Eliminar = ctrlConexion.getCon().prepareStatement("Delete from confmarca where id=?;");
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
        ArrayList<ConfMarca> consulta = new ArrayList();
        PreparedStatement consultaCompleja;
        ResultSet resultado;

        try {
            consultaCompleja = ctrlConexion.getCon().prepareStatement("Select * from confMarca;");
            resultado = consultaCompleja.executeQuery();
            while (resultado.next()) {
                ConfMarca temp = new ConfMarca();
                temp.setId(Integer.parseInt(resultado.getString(1)));
                temp.setStrvalor(resultado.getString(2));
                temp.setStrdescripcion(resultado.getString(3));

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

        ArrayList<ConfMarca> consulta = new ArrayList();
        PreparedStatement consultaCompleja;
        ResultSet resultado;
        int idEstado = (int) _obj;

        try {
            consultaCompleja = ctrlConexion.getCon().prepareStatement("Select * from confMarca where idconfestadoglobal = " + idEstado + ";");
            resultado = consultaCompleja.executeQuery();
            while (resultado.next()) {
                ConfMarca temp = new ConfMarca();
                temp.setId(Integer.parseInt(resultado.getString(1)));
                temp.setStrvalor(resultado.getString(2));
                temp.setStrdescripcion(resultado.getString(3));

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
    public ArrayList<Object> ConsultaEspecializada(Object _O) {
        try {
            ArrayList<ConfMarca> consulta = new ArrayList();
            PreparedStatement consultaCompleja;
            ResultSet resultado;
            ConfMarca objTemp = (ConfMarca) _O;
            String consultaBusqueda = "SELECT * FROM confmarca";

            if (objTemp.getIdconfestadoglobal() > 0) {
                consultaBusqueda += " where idconfestadoglobal = " + objTemp.getIdconfestadoglobal();
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
                ConfMarca temp = new ConfMarca();
                temp.setId(Integer.parseInt(resultado.getString(1)));
                temp.setStrvalor(resultado.getString(2));
                temp.setStrdescripcion(resultado.getString(3));
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Object> ConsultaParaManager(Object _O) {
        ArrayList<ConfMarca> consulta = new ArrayList();
        PreparedStatement consultaCompleja;
        ResultSet resultado;
        int idMarca = (int) _O;

        try {
            consultaCompleja = ctrlConexion.getCon().prepareStatement("Select * from confMarca where id = " + idMarca + ";");
            resultado = consultaCompleja.executeQuery();
            while (resultado.next()) {
                ConfMarca temp = new ConfMarca();
                temp.setId(Integer.parseInt(resultado.getString(1)));
                temp.setStrvalor(resultado.getString(2));
                temp.setStrdescripcion(resultado.getString(3));
                temp.setIdconfestadoglobal(resultado.getInt(4));

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
