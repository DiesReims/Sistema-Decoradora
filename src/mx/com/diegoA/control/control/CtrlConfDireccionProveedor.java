package mx.com.diegoA.control.control;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.com.diegoA.control.Icontrol.IAccionesDB;
import mx.com.diegoA.control.conexion.ctrlConexion;
import mx.com.diegoA.entidad.entity.ConfDireccionProveedor;


/**
 *
 * @author Dies
 */
public class CtrlConfDireccionProveedor extends ctrlConexion implements IAccionesDB {

    private ctrlConexion ctrlConexion;

    public CtrlConfDireccionProveedor() throws SQLException {

        this.ctrlConexion = new ctrlConexion();

    }

    //<editor-fold defaultstate="collapsed" desc="Metodos">
    @Override
    //<editor-fold defaultstate="collapsed" desc="No Lo Ocupamos">
    public boolean Agregar(Object _O) {
        try {
            ConfDireccionProveedor objTemp = (ConfDireccionProveedor) _O;
            PreparedStatement Agregar;
            Agregar = ctrlConexion.getCon().prepareStatement("Insert into confdireccion(strvalor,idconfcliente,strcolonia,idconfestado,idconfmunicipio) values (?,?,?,?,?)");
            Agregar.setString(1, objTemp.getStrValor());
            Agregar.setInt(3, objTemp.getIdConfProveedor());
            Agregar.setString(4, objTemp.getStrColonia());
            Agregar.setInt(5, objTemp.getIdConfEstado());
            Agregar.setInt(6, objTemp.getIdConfMunicipio());
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
    //</editor-fold>

    @Override
    public boolean Editar(Object _O) {
        try {
            ConfDireccionProveedor objTemp = (ConfDireccionProveedor) _O;

            String temp = "Update confDireccion set strvalor ='" + objTemp.getStrValor() + "',idconfcliente = " + objTemp.getIdConfProveedor()
                    + ", strcolonia = '" + objTemp.getStrColonia() + "',idconfestado = " + objTemp.getIdConfEstado() + ", idconfmunicipio" + objTemp.getIdConfMunicipio() + " where ID = ?;";

            System.out.println(temp);
            PreparedStatement Modificar;
            Modificar = ctrlConexion.getCon().prepareStatement("Update confDireccionproveedor set strvalor ='" + objTemp.getStrValor() + "',idconfdistribuidor = " + objTemp.getIdConfProveedor()
                    + ", strcolonia = '" + objTemp.getStrColonia() + "',idconfestado = " + objTemp.getIdConfEstado() + ", idconfmunicipio =" + objTemp.getIdConfMunicipio() + " where ID = ?;");
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
        ConfDireccionProveedor objTemp = (ConfDireccionProveedor) O;
        try {
            PreparedStatement Eliminar;
            Eliminar = ctrlConexion.getCon().prepareStatement("Delete from confDireccionproveedor where id=?;");
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
        ArrayList<ConfDireccionProveedor> consulta = new ArrayList();
        PreparedStatement consultaCompleja;
        ResultSet resultado;

        try {
            consultaCompleja = ctrlConexion.getCon().prepareStatement("Select * from confDireccionproveedor;");
            resultado = consultaCompleja.executeQuery();
            while (resultado.next()) {
                ConfDireccionProveedor temp = new ConfDireccionProveedor();
                temp.setId(Integer.parseInt(resultado.getString(1)));
                temp.setStrValor(resultado.getString(2));
                temp.setIdConfProveedor(resultado.getInt(3));

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

        ArrayList<ConfDireccionProveedor> consulta = new ArrayList();
        PreparedStatement consultaCompleja;
        ResultSet resultado;
        int idEstado = (int) _obj;

        try {
            consultaCompleja = ctrlConexion.getCon().prepareStatement("Select * from confDireccionproveedor where idconfdistribuidor = " + idEstado + ";");
            resultado = consultaCompleja.executeQuery();
            while (resultado.next()) {
                ConfDireccionProveedor temp = new ConfDireccionProveedor();
                temp.setId(Integer.parseInt(resultado.getString(1)));
                temp.setStrValor(resultado.getString(2));
                temp.setIdConfProveedor(resultado.getInt(3));
                temp.setStrColonia(resultado.getString(4));
                temp.setIdConfEstado(resultado.getInt(5));
                temp.setIdConfMunicipio(resultado.getInt(6));

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
            ArrayList<ConfDireccionProveedor> consulta = new ArrayList();
            PreparedStatement consultaCompleja;
            ResultSet resultado;
            ConfDireccionProveedor objTemp = (ConfDireccionProveedor) _O;
            String consultaBusqueda = "SELECT * FROM confDireccionProveedor";

            if (objTemp.getIdConfProveedor() > 0) {
                consultaBusqueda += " where idconfdistribuidor = " + objTemp.getIdConfProveedor();
            }
//            if(null != objTemp.getStrValor())
//            {
//                if (!objTemp.getStrBusqueda().trim().equals("")) {
//                    consultaBusqueda += " and strvalor like '%" + objTemp.getStrBusqueda() + "%'";
//                }
//            }

            consultaBusqueda += ";";
            consultaCompleja = ctrlConexion.getCon().prepareStatement(consultaBusqueda);
            resultado = consultaCompleja.executeQuery();
            while (resultado.next()) {
                ConfDireccionProveedor temp = new ConfDireccionProveedor();
                temp.setId(Integer.parseInt(resultado.getString(1)));
                temp.setStrValor(resultado.getString(2));
                temp.setIdConfProveedor(resultado.getInt(3));
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
            consultaElUltimo = ctrlConexion.getCon().prepareStatement("select max(id) from confdireccionProveedor");
            elUltimo = consultaElUltimo.executeQuery();
            if (elUltimo.next()) {
                idUltimo = elUltimo.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CtrlConfDireccionProveedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idUltimo;
    }

    public boolean insertarRepetitivo(Object _O, int _id) throws SQLException {
        try {
            PreparedStatement insertar;
            ConfDireccionProveedor objTemp = (ConfDireccionProveedor) _O;
            insertar = ctrlConexion.getCon().prepareStatement("Insert into confDireccionProveedor (strvalor,idconfdistribuidor,strcolonia,idconfestado,idconfmunicipio)  values(?,?,?,?,?)");
            insertar.setString(1, objTemp.getStrValor());
            insertar.setInt(2, _id);
            insertar.setString(3, objTemp.getStrColonia());
            insertar.setInt(4, objTemp.getIdConfEstado());
            insertar.setInt(5, objTemp.getIdConfMunicipio());
            insertar.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getSQLState());
            System.out.println(e.getErrorCode());
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public ArrayList<Object> ConsultaParaManager(Object _obj) {
    
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    //</editor-fold>

    @Override
    public ArrayList<Object> ConsultaEspecializada2(Object O, Object _obj2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
