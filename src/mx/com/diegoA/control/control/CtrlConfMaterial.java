package mx.com.diegoA.control.control;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.com.diegoA.control.Icontrol.IAccionesDB;
import mx.com.diegoA.control.conexion.ctrlConexion;
import mx.com.diegoA.entidad.entity.ConfMaterial;

/**
 *
 * @author Dies
 */
public class CtrlConfMaterial extends ctrlConexion implements IAccionesDB {

    ctrlConexion ctrlConexion;

    public CtrlConfMaterial() throws SQLException {

        this.ctrlConexion = new ctrlConexion();
    }

    //<editor-fold defaultstate="collapsed" desc="Metodos">
    @Override
    public boolean Agregar(Object _O) {
       try {
            ConfMaterial objTemp = (ConfMaterial) _O;
            PreparedStatement Agregar;
            Agregar = ctrlConexion.getCon().prepareStatement("Insert into confMaterial (strvalor,strdescripcion,idconftipomaterial) values (?,?,?)");
            Agregar.setString(1, objTemp.getStrValor());
            Agregar.setString(2, objTemp.getStrDescripcion());
            Agregar.setInt(3, objTemp.getIdConfTipoMaterial());
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
            ConfMaterial objTemp = (ConfMaterial) _O;

            String temp = "Update confMarca set strvalor ='" + objTemp.getStrValor() + "',strDescripcion ='" + objTemp.getStrDescripcion()
                    + "',idconfestadoglobal=" + objTemp.getIdConfTipoMaterial() + " where ID = ?;";

            System.out.println(temp);
            PreparedStatement Modificar;
            Modificar = ctrlConexion.getCon().prepareStatement("Update confMaterial set strvalor ='" + objTemp.getStrValor() + "',strDescripcion ='" + objTemp.getStrDescripcion()
                    + "',idconftipomaterial=" + objTemp.getIdConfTipoMaterial() + " where ID = ?");
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
        try {
            ResultSet todo;
            PreparedStatement Consultar;
            String uno, dos;
            int forey;
            Consultar = ctrlConexion.getCon().prepareStatement("select * from confmaterial;");
            todo = Consultar.executeQuery();
            while (todo.next()) {
                System.out.println(todo.getString("strvalor") + " " + todo.getString("strdescripcion") + " " + todo.getInt("idconfmarca"));
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
        ConfMaterial objTemp = (ConfMaterial) O;
        try {
            PreparedStatement Eliminar;
            Eliminar = ctrlConexion.getCon().prepareStatement("Delete from confMaterial where id=?;");
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
         ArrayList<ConfMaterial> consulta = new ArrayList();
        PreparedStatement consultaCompleja;
        ResultSet resultado;

        try {
            consultaCompleja = ctrlConexion.getCon().prepareStatement("Select * from confMaterial;");
            resultado = consultaCompleja.executeQuery();
            while (resultado.next()) {
                ConfMaterial temp = new ConfMaterial();
                temp.setId(Integer.parseInt(resultado.getString(1)));
                temp.setStrValor(resultado.getString(2));
                temp.setStrDescripcion(resultado.getString(3));

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
    public ArrayList<Object> ConsultaCompleja(Object _O) {
        ArrayList<ConfMaterial> consulta = new ArrayList();
        PreparedStatement consultaCompleja;
        ResultSet resultado;
        int idEstado = (int) _O;

        try {
            consultaCompleja = ctrlConexion.getCon().prepareStatement("Select * from confMaterial where idconftipoMaterial = " + idEstado + ";");
            resultado = consultaCompleja.executeQuery();
            while (resultado.next()) {
                ConfMaterial temp = new ConfMaterial();
                temp.setId(Integer.parseInt(resultado.getString(1)));
                temp.setStrValor(resultado.getString(2));
                temp.setStrDescripcion(resultado.getString(3));

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
            ArrayList<ConfMaterial> consulta = new ArrayList();
            PreparedStatement consultaCompleja;
            ResultSet resultado;
            ConfMaterial objTemp = (ConfMaterial) _O;
            String consultaBusqueda = "SELECT * FROM confMaterial";

            if (objTemp.getIdConfTipoMaterial() > 0) {
                consultaBusqueda += " where idConfTipoMaterial = " + objTemp.getIdConfTipoMaterial();
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
                ConfMaterial temp = new ConfMaterial();
                temp.setId(Integer.parseInt(resultado.getString(1)));
                temp.setStrValor(resultado.getString(2));
                temp.setStrDescripcion(resultado.getString(3));
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
         ArrayList<ConfMaterial> consulta = new ArrayList();
        PreparedStatement consultaCompleja;
        ResultSet resultado;
        int idMarca = (int) _O;

        try {
            consultaCompleja = ctrlConexion.getCon().prepareStatement("Select * from confMaterial where id = " + idMarca + ";");
            resultado = consultaCompleja.executeQuery();
            while (resultado.next()) {
                ConfMaterial temp = new ConfMaterial();
                temp.setId(Integer.parseInt(resultado.getString(1)));
                temp.setStrValor(resultado.getString(2));
                temp.setStrDescripcion(resultado.getString(3));
                temp.setIdConfTipoMaterial(resultado.getInt(4));

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
