package mx.com.diegoA.control.control;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.com.diegoA.control.Icontrol.IAccionesDB;
import mx.com.diegoA.control.conexion.ctrlConexion;
import mx.com.diegoA.entidad.entity.VenTrabajo;
import mx.com.diegoA.entidad.entity.ConfEstados;
import mx.com.diegoA.entidad.entity.ConfMunicipios;

/**
 *
 * @author Dies
 */
public class CtrlVenTrabajo extends ctrlConexion implements IAccionesDB {

    private ctrlConexion ctrlConexion;

    public CtrlVenTrabajo() throws SQLException {

        this.ctrlConexion = new ctrlConexion();

    }

    //<editor-fold defaultstate="collapsed" desc="Metodos">
    @Override
    //<editor-fold defaultstate="collapsed" desc="No Lo Ocupamos">
    public boolean Agregar(Object _O) {
        try {
            VenTrabajo objTemp = (VenTrabajo) _O;
            PreparedStatement Agregar;
            Agregar = ctrlConexion.getCon().prepareStatement("Insert into confdireccion(strvalor,idconfcliente,strcolonia,idconfestado,idconfmunicipio) values (?,?,?,?,?)");
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
            VenTrabajo objTemp = (VenTrabajo) _O;

            String temp = "Update venTrabajo set idconfproducto =" + objTemp.getIdConfProducto() + ",idvenPresupuesto = " + objTemp.getIdVenPresupuesto()
                    + ", medLargo = " + objTemp.getMedLargo() + ",medAncho = " + objTemp.getMedAncho() + " where ID = ?;";
            System.out.println(temp);
            PreparedStatement Modificar;
            Modificar = ctrlConexion.getCon().prepareStatement("Update venTrabajo set idconfproducto =" + objTemp.getIdConfProducto() + ",idvenPresupuesto = " + objTemp.getIdVenPresupuesto()
                    + ", medLargo = " + objTemp.getMedLargo() + ",medAncho = " + objTemp.getMedAncho() + " where ID = ?;");
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
        //No se usa
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
        VenTrabajo objTemp = (VenTrabajo) O;
        try {
            PreparedStatement Eliminar;
            Eliminar = ctrlConexion.getCon().prepareStatement("Delete from venTrabajo where id=?;");
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
        ArrayList<VenTrabajo> consulta = new ArrayList();
        PreparedStatement consultaCompleja;
        ResultSet resultado;

        try {
            consultaCompleja = ctrlConexion.getCon().prepareStatement("Select * from confDireccion;");
            resultado = consultaCompleja.executeQuery();
            while (resultado.next()) {
                VenTrabajo temp = new VenTrabajo();
                temp.setId(Integer.parseInt(resultado.getString(1)));
                temp.setIdConfProducto(Integer.parseInt(resultado.getString(2)));
                temp.setMedLargo(resultado.getDouble(3));
                temp.setMedAncho(resultado.getDouble(4));
                temp.setIdVenPresupuesto(resultado.getInt(5));

                consulta.add(temp);

            }
            consultaCompleja.close();
            return new ArrayList(consulta);
        } catch (SQLException ex) {
            Logger.getLogger(CtrlVenTrabajo.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public ArrayList<Object> ConsultaCompleja(Object _obj) {

        ArrayList<VenTrabajo> consulta = new ArrayList();
        PreparedStatement consultaCompleja;
        ResultSet resultado;
        int idPresupuesto = (int) _obj;

        try {
            consultaCompleja = ctrlConexion.getCon().prepareStatement("Select * from venTrabajo where idvenPresupuesto = " + idPresupuesto + ";");
            resultado = consultaCompleja.executeQuery();
            while (resultado.next()) {
                VenTrabajo temp = new VenTrabajo();
                temp.setId(Integer.parseInt(resultado.getString(1)));
                temp.setIdConfProducto(Integer.parseInt(resultado.getString(2)));
                temp.setMedLargo(resultado.getDouble(3));
                temp.setMedAncho(resultado.getDouble(4));
                temp.setIdVenPresupuesto(resultado.getInt(5));

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
            ArrayList<VenTrabajo> consulta = new ArrayList();
            PreparedStatement consultaCompleja;
            ResultSet resultado;
            VenTrabajo objTemp = (VenTrabajo) _O;
            String consultaBusqueda = "SELECT * FROM venTrabajo";

            if (objTemp.getIdVenPresupuesto() > 0) {
                consultaBusqueda += " where idvenPresupuesto = " + objTemp.getIdVenPresupuesto();
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
                VenTrabajo temp = new VenTrabajo();
                temp.setId(Integer.parseInt(resultado.getString(1)));
                temp.setIdConfProducto(Integer.parseInt(resultado.getString(2)));
                temp.setMedLargo(resultado.getDouble(3));
                temp.setMedAncho(resultado.getDouble(4));
                temp.setIdVenPresupuesto(resultado.getInt(5));
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
            consultaElUltimo = ctrlConexion.getCon().prepareStatement("select max(id) from venTrabajo");
            elUltimo = consultaElUltimo.executeQuery();
            if (elUltimo.next()) {
                idUltimo = elUltimo.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CtrlVenTrabajo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idUltimo;
    }

    public boolean insertarRepetitivo(Object _O, int _id) throws SQLException {
        try {
            PreparedStatement insertar;
            VenTrabajo objTemp = (VenTrabajo) _O;
            insertar = ctrlConexion.getCon().prepareStatement("Insert into venTrabajo (idconfproducto,medLargo,medAncho,idvenPresupuesto)  values(?,?,?,?)");
            insertar.setInt(1, objTemp.getIdConfProducto());
            insertar.setDouble(2, objTemp.getMedLargo());
            insertar.setDouble(3, objTemp.getMedAncho());
            insertar.setInt(4, _id);
            
            
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
