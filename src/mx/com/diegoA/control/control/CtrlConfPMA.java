package mx.com.diegoA.control.control;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.com.diegoA.control.Icontrol.IAccionesDB;
import mx.com.diegoA.control.conexion.ctrlConexion;
import mx.com.diegoA.entidad.entity.ConfPMA;

/**
 *
 * @author Dies
 */
public class CtrlConfPMA extends ctrlConexion implements IAccionesDB {

    private ctrlConexion ctrlConexion;

    public CtrlConfPMA() throws SQLException {

        this.ctrlConexion = new ctrlConexion();

    }

    //<editor-fold defaultstate="collapsed" desc="Metodos">
    @Override
    public boolean Agregar(Object _O) {
        try {
            ConfPMA objTemp = (ConfPMA) _O;
            PreparedStatement Agregar;
            Agregar = ctrlConexion.getCon().prepareStatement("Insert into confMarca (strvalor,strdescripcion,idconfestadoglobal) values (?,?,?)");
//            Agregar.setString(1, objTemp.getStrvalor());
//            Agregar.setString(2, objTemp.getStrdescripcion());
//            Agregar.setInt(3, objTemp.getIdconfestadoglobal());
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
            ConfPMA objTemp = (ConfPMA) _O;

            String temp = "Update Perfil_Modulo_Accion set boolAgregar =" + objTemp.isAgregar() + ",boolEditar =" + objTemp.isEditar()
                    + ",boolEliminar = " + objTemp.isEliminar() + ",boolImprimir =" + objTemp.isImprimir() + " where ID = "+objTemp.getId()+";";

            System.out.println(temp);
            PreparedStatement Modificar;
            Modificar = ctrlConexion.getCon().prepareStatement("Update Perfil_Modulo_Accion set boolAgregar =" + objTemp.isAgregar() + ",boolEditar =" + objTemp.isEditar()
                    + ",boolEliminar = " + objTemp.isEliminar() + ",boolImprimir=" + objTemp.isImprimir() + " where ID = "+objTemp.getId()+";");
//            Modificar.setInt(1, objTemp.getId());
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
            Consultar = ctrlConexion.getCon().prepareStatement("select * from Perfil_Modulo_Accion;");
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
        ConfPMA objTemp = (ConfPMA) O;
        try {
            PreparedStatement Eliminar;
            Eliminar = ctrlConexion.getCon().prepareStatement("Delete from Perfil_Modulo_Accion where id=?;");
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
        ArrayList<ConfPMA> consulta = new ArrayList();
        PreparedStatement consultaCompleja;
        ResultSet resultado;

        try {
            consultaCompleja = ctrlConexion.getCon().prepareStatement("Select * from Perfil_Modulo_Accion;");
            resultado = consultaCompleja.executeQuery();
            while (resultado.next()) {
                ConfPMA temp = new ConfPMA();
                temp.setId(Integer.parseInt(resultado.getString(1)));
                temp.setIdPerfil(resultado.getInt(2));
                temp.setIdModulo(resultado.getInt(3));
                temp.setAgregar(resultado.getBoolean(4));
                temp.setEditar(resultado.getBoolean(5));
                temp.setEliminar(resultado.getBoolean(6));
                temp.setImprimir(resultado.getBoolean(7));

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

        ArrayList<ConfPMA> consulta = new ArrayList();
        PreparedStatement consultaCompleja;
        ResultSet resultado;
        int idPerfil = (int) _obj;

        try {
            consultaCompleja = ctrlConexion.getCon().prepareStatement("Select * from Perfil_Modulo_Accion where idPerfil = " + idPerfil + ";");
            resultado = consultaCompleja.executeQuery();
            while (resultado.next()) {
                ConfPMA temp = new ConfPMA();
                temp.setId(Integer.parseInt(resultado.getString(1)));
                temp.setIdPerfil(resultado.getInt(2));
                temp.setIdModulo(resultado.getInt(3));
                temp.setAgregar(resultado.getBoolean(4));
                temp.setEditar(resultado.getBoolean(5));
                temp.setEliminar(resultado.getBoolean(6));
                temp.setImprimir(resultado.getBoolean(7));

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
//        try {
        ArrayList<ConfPMA> consulta = new ArrayList();
//            PreparedStatement consultaCompleja;
//            ResultSet resultado;
//            ConfPMA objTemp = (ConfPMA) _O;
//            String consultaBusqueda = "SELECT * FROM Perfil_Modulo_Accion";

//            if (objTemp.getIdconfestadoglobal() > 0) {
//                consultaBusqueda += " where idconfestadoglobal = " + objTemp.getIdconfestadoglobal();
//            }
//            if (null != objTemp.getStrBusqueda()) {
//                if (!objTemp.getStrBusqueda().trim().equals("")) {
//                    consultaBusqueda += " and strvalor like '%" + objTemp.getStrBusqueda() + "%'";
//                }
//            }
//
//            consultaBusqueda += ";";
//            consultaCompleja = ctrlConexion.getCon().prepareStatement(consultaBusqueda);
//            resultado = consultaCompleja.executeQuery();
//            while (resultado.next()) {
//                ConfPMA temp = new ConfPMA();
//                temp.setId(Integer.parseInt(resultado.getString(1)));
//                temp.setStrvalor(resultado.getString(2));
//                temp.setStrdescripcion(resultado.getString(3));
//                consulta.add(temp);
//            }
//            consultaCompleja.close();
        return new ArrayList(consulta);
//
//        } catch (SQLException ex) {
//            Logger.getLogger(CtrlConfEstadoGlobal.class.getName()).log(Level.SEVERE, null, ex);
//            return null;
//        }
    }

    @Override
    public int ConsultarUltimo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Object> ConsultaParaManager(Object _O) {
        ArrayList<ConfPMA> consulta = new ArrayList();
        PreparedStatement consultaCompleja;
        ResultSet resultado;
        int idMarca = (int) _O;

        try {
            consultaCompleja = ctrlConexion.getCon().prepareStatement("Select * from Perfil_Modulo_Accion where id = " + idMarca + ";");
            resultado = consultaCompleja.executeQuery();
            while (resultado.next()) {
                ConfPMA temp = new ConfPMA();
                temp.setId(Integer.parseInt(resultado.getString(1)));
                temp.setIdPerfil(resultado.getInt(2));
                temp.setIdModulo(resultado.getInt(3));
                temp.setAgregar(resultado.getBoolean(4));
                temp.setEditar(resultado.getBoolean(5));
                temp.setEliminar(resultado.getBoolean(6));
                temp.setImprimir(resultado.getBoolean(7));

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
    public ArrayList<Object> ConsultaEspecializada2(Object O, Object _obj2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
      //</editor-fold>
}
