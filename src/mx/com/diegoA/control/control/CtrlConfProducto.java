package mx.com.diegoA.control.control;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.com.diegoA.control.Icontrol.IAccionesDB;
import mx.com.diegoA.control.conexion.ctrlConexion;
import mx.com.diegoA.entidad.entity.ConfProducto;

/**
 *
 * @author Dies
 */
public class CtrlConfProducto extends ctrlConexion implements IAccionesDB {

    ctrlConexion ctrlConexion;

    public CtrlConfProducto() throws SQLException {

        this.ctrlConexion = new ctrlConexion();

    }

    //<editor-fold defaultstate="collapsed" desc="Metodos">
    @Override
    public boolean Agregar(Object _O) {
        try {
            ConfProducto objTemp = (ConfProducto) _O;
            PreparedStatement Agregar;
            Agregar = ctrlConexion.getCon().prepareStatement("Insert into confProducto (idconfmarca,idconftipoproducto,idconfcoleccion,idconfmaterial,idconfcolor,strvalor,strdescripcion,currprecio) "
                    + "values (?,?,?,?,?,?,?,?)");
            Agregar.setInt(1, objTemp.getIdConfMarca());
            Agregar.setInt(2, objTemp.getIdConfTipoProducto());
            Agregar.setInt(3, objTemp.getIdConfColeccion());
            Agregar.setInt(4, objTemp.getIdConfMaterial());
            Agregar.setInt(5, objTemp.getIdConfColor());
            Agregar.setString(6, objTemp.getStrValor());
            Agregar.setString(7, objTemp.getStrDescripcion());
            Agregar.setDouble(8, objTemp.getCurPrecio());
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
            ConfProducto objTemp = (ConfProducto) _O;

            String temp = "Update confProducto set "
                    + "idconfmarca =" + objTemp.getIdConfMarca()
                    + ",idconftipoproducto =" + objTemp.getIdConfTipoProducto()
                    + ",idconfcoleccion =" + objTemp.getIdConfColeccion()
                    + ",idconfmaterial =" + objTemp.getIdConfMaterial()
                    + ",idconfcolor =" + objTemp.getIdConfColor()
                    + ",strvalor = '" + objTemp.getStrValor()
                    + "', strdescripcion ='" + objTemp.getStrDescripcion()
                    + "', currprecio =" + objTemp.getCurPrecio()
                    + " where id = ?";

            System.out.println(temp);
            PreparedStatement Modificar;
            Modificar = ctrlConexion.getCon().prepareStatement("Update confProducto set "
                    + "idconfmarca =" + objTemp.getIdConfMarca()
                    + ",idconftipoproducto =" + objTemp.getIdConfTipoProducto()
                    + ",idconfcoleccion =" + objTemp.getIdConfColeccion()
                    + ",idconfmaterial =" + objTemp.getIdConfMaterial()
                    + ",idconfcolor =" + objTemp.getIdConfColor()
                    + ",strvalor = '" + objTemp.getStrValor()
                    + "', strdescripcion ='" + objTemp.getStrDescripcion()
                    + "', currprecio =" + objTemp.getCurPrecio()
                    + " where id = ?");
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

    // @Override
    public boolean ConsultaSimple(Object O) {
        try {
            ResultSet todo;
            PreparedStatement Consultar;
            String uno, dos;
            int forey;
            Consultar = ctrlConexion.getCon().prepareStatement("select * from confColeccion;");
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
        ConfProducto objTemp = (ConfProducto) O;
        try {
            PreparedStatement Eliminar;
            Eliminar = ctrlConexion.getCon().prepareStatement("Delete from confProducto where id=?;");
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
        ArrayList<ConfProducto> consulta = new ArrayList();
        PreparedStatement consultaCompleja;
        ResultSet resultado;

        try {
            consultaCompleja = ctrlConexion.getCon().prepareStatement("Select * from confProducto;");
            resultado = consultaCompleja.executeQuery();
            while (resultado.next()) {
                ConfProducto temp = new ConfProducto();
                temp.setId(Integer.parseInt(resultado.getString(1)));
                temp.setIdConfMarca((resultado.getInt(2)));
                temp.setIdConfTipoProducto(resultado.getInt(3));
                temp.setIdConfColeccion(resultado.getInt(4));
                temp.setIdConfMaterial(resultado.getInt(5));
                temp.setIdConfColor(resultado.getInt(6));
                temp.setStrValor(resultado.getString(7));
                temp.setStrDescripcion(resultado.getString(8));
                temp.setCurPrecio(resultado.getDouble(9));

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
        ArrayList<ConfProducto> consulta = new ArrayList();
        PreparedStatement consultaCompleja;
        ResultSet resultado;
        int idTProducto = (int) _O;

        try {
            consultaCompleja = ctrlConexion.getCon().prepareStatement("Select * from confProducto where idconftipoproducto = " + idTProducto + ";");
            resultado = consultaCompleja.executeQuery();
            while (resultado.next()) {
                ConfProducto temp = new ConfProducto();
                temp.setId(Integer.parseInt(resultado.getString(1)));
                temp.setIdConfMarca((resultado.getInt(2)));
                temp.setIdConfTipoProducto(resultado.getInt(3));
                temp.setIdConfColeccion(resultado.getInt(4));
                temp.setIdConfMaterial(resultado.getInt(5));
                temp.setIdConfColor(resultado.getInt(6));
                temp.setStrValor(resultado.getString(7));
                temp.setStrDescripcion(resultado.getString(8));
                temp.setCurPrecio(resultado.getDouble(9));

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
            ArrayList<ConfProducto> consulta = new ArrayList();
            PreparedStatement consultaCompleja;
            ResultSet resultado;
            ConfProducto objTemp = (ConfProducto) _O;
            String consultaBusqueda = "SELECT * FROM confProducto ";

            if (objTemp.getIdConfTipoProducto() > 0) {
                consultaBusqueda += " where idconftipoproducto = " + objTemp.getIdConfTipoProducto();
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
                ConfProducto temp = new ConfProducto();
                temp.setId(Integer.parseInt(resultado.getString(1)));
                temp.setIdConfMarca((resultado.getInt(2)));
                temp.setIdConfTipoProducto(resultado.getInt(3));
                temp.setIdConfColeccion(resultado.getInt(4));
                temp.setIdConfMaterial(resultado.getInt(5));
                temp.setIdConfColor(resultado.getInt(6));
                temp.setStrValor(resultado.getString(7));
                temp.setStrDescripcion(resultado.getString(8));
                temp.setCurPrecio(resultado.getDouble(9));
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
        ArrayList<ConfProducto> consulta = new ArrayList();
        PreparedStatement consultaCompleja;
        ResultSet resultado;
        int idProducto = (int) _O;

        try {
            consultaCompleja = ctrlConexion.getCon().prepareStatement("Select * from confProducto where id = " + idProducto + ";");
            resultado = consultaCompleja.executeQuery();
            while (resultado.next()) {
                ConfProducto temp = new ConfProducto();
                temp.setId(Integer.parseInt(resultado.getString(1)));
                temp.setIdConfMarca((resultado.getInt(2)));
                temp.setIdConfTipoProducto(resultado.getInt(3));
                temp.setIdConfColeccion(resultado.getInt(4));
                temp.setIdConfMaterial(resultado.getInt(5));
                temp.setIdConfColor(resultado.getInt(6));
                temp.setStrValor(resultado.getString(7));
                temp.setStrDescripcion(resultado.getString(8));
                temp.setCurPrecio(resultado.getDouble(9));

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
