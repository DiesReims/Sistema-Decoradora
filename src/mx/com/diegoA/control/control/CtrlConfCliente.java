
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
import mx.com.diegoA.entidad.entity.ConfCliente;
import mx.com.diegoA.entidad.entity.ConfDireccion;


/**
 *
 * @author Dies
 */
public class CtrlConfCliente extends ctrlConexion implements IAccionesDB {

    ctrlConexion conexion;

    public CtrlConfCliente() throws SQLException {
        conexion = new ctrlConexion();
    }

    //<editor-fold defaultstate="collapsed" desc="Metodos Implementar">
    @Override
    public boolean Agregar(Object _O) {
        try {
            ConfCliente objTemp = (ConfCliente) _O;
            PreparedStatement Agregar;
            Agregar = conexion.getCon().prepareStatement("Insert into confCliente (strNombre,strtelefonocasa,strtelefonocelular,idconfsexo) values (?,?,?,?)");
            Agregar.setString(1, objTemp.getStrNombre());
            Agregar.setString(2, objTemp.getStrTelCasa());
            Agregar.setString(3, objTemp.getStrTelCel());
            Agregar.setInt(4, objTemp.getIdConfSexo());
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
            ConfCliente objTemp = (ConfCliente) _O;

            String temp = "Update confCliente set strNombre ='" + objTemp.getStrNombre() + "',strTelefonoCasa ='" + objTemp.getStrTelCasa()
                    + "',strtelefonocelular=" + objTemp.getStrTelCel() + "',idconfsexo=" + objTemp.getIdConfSexo() + " where ID = ?;";

            System.out.println(temp);
            PreparedStatement Modificar;
            Modificar = conexion.getCon().prepareStatement("Update confCliente set strNombre ='" + objTemp.getStrNombre() + "',strTelefonoCasa ='" + objTemp.getStrTelCasa()
                    + "',strtelefonocelular='" + objTemp.getStrTelCel() + "',idconfsexo=" + objTemp.getIdConfSexo() + " where ID = ?;");
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
        ConfCliente objTemp = (ConfCliente) O;
        PreparedStatement Eliminar = null;
        
        conexion.getCon();
        try 
        {
            CtrlConfDireccion ctrlDir = new CtrlConfDireccion();
            ConfDireccion dir = new ConfDireccion();
            
            ArrayList<Object> list = ctrlDir.ConsultaCompleja(objTemp.getId());
//            for (int i = 0; i< list.size(); i++) {
//                dir = (ConfDireccion) list.get(i);
            conexion.getCon().setAutoCommit(false);
            if (list.size() > 0) {
                 Eliminar = conexion.getCon().prepareStatement("Delete from confdireccion where idconfcliente=?;");
                 Eliminar.setInt(1, objTemp.getId());
                 System.out.println("Si borro los registros de direcciones :D");
                 Eliminar.execute();
            }    
               
//            }
            try{
            
            Eliminar = conexion.getCon().prepareStatement("Delete from confCliente where id=?;");
            Eliminar.setInt(1, objTemp.getId());
            Eliminar.execute();
            Eliminar.getConnection().commit();
            Eliminar.close(); 
            }catch(SQLException ex)
            {
                Eliminar.getConnection().rollback();
                Eliminar.close();
            }
            return true;
                    
        } catch (SQLException e) 
        {
            System.out.println(e.getErrorCode());
            System.out.println(e.getSQLState());
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null,"No se pudo eliminar","Hay referencias",JOptionPane.ERROR_MESSAGE );
            return false;
        }
    }

    @Override
    public ArrayList<Object> ConsultaEspecializada(Object _O) {
        try {
            ArrayList<ConfCliente> consulta = new ArrayList();
            PreparedStatement consultaCompleja;
            ResultSet resultado;
            ConfCliente objTemp = (ConfCliente) _O;
            String consultaBusqueda = "SELECT * FROM confcliente";
            if (objTemp.getIdConfSexo() > 0) {
                consultaBusqueda += " where idconfsexo = " + objTemp.getIdConfSexo();
            }
            if (!objTemp.getStrBusqueda().trim().equals("")) {
                consultaBusqueda += " and strnombre like '%" + objTemp.getStrBusqueda() + "%'";
            }
            consultaBusqueda += ";";
            consultaCompleja = conexion.getCon().prepareStatement(consultaBusqueda);
            resultado = consultaCompleja.executeQuery();
            while (resultado.next()) {
                ConfCliente temp = new ConfCliente();
                temp.setId(Integer.parseInt(resultado.getString(1)));
                temp.setStrNombre(resultado.getString(2));
                temp.setStrTelCasa(resultado.getString(3));
                temp.setStrTelCel(resultado.getString(4));
                temp.setIdConfSexo(resultado.getInt(5));
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
        ArrayList<ConfCliente> consulta = new ArrayList();
        PreparedStatement consultaCompleja;
        ResultSet resultado;
        int idSexo = (int) _O;

        try {
            consultaCompleja = conexion.getCon().prepareStatement("Select * from confcliente where idconfsexo = " + idSexo + ";");
            resultado = consultaCompleja.executeQuery();
            while (resultado.next()) {
                ConfCliente temp = new ConfCliente();
                temp.setId(Integer.parseInt(resultado.getString(1)));
                temp.setStrNombre(resultado.getString(2));
                temp.setStrTelCasa(resultado.getString(3));
                temp.setStrTelCel(resultado.getString(4));
                temp.setIdConfSexo(resultado.getInt(5));

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
    public ArrayList<Object> ConsultaCompleja() {
        ArrayList<ConfCliente> consulta = new ArrayList();
        PreparedStatement consultaCompleja;
        ResultSet resultado;

        try {
            consultaCompleja = conexion.getCon().prepareStatement("Select * from confCliente;");
            resultado = consultaCompleja.executeQuery();
            while (resultado.next()) {
                ConfCliente temp = new ConfCliente();
                temp.setId(Integer.parseInt(resultado.getString(1)));
                temp.setStrNombre(resultado.getString(2));
                temp.setStrTelCasa(resultado.getString(3));
                temp.setStrTelCel(resultado.getString(4));
                temp.setIdConfSexo(resultado.getInt(5));

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
            consultaElUltimo = conexion.getCon().prepareStatement("select max(id) from confcliente");
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
      ArrayList<ConfCliente> consulta = new ArrayList();
        PreparedStatement consultaCompleja;
        ResultSet resultado;
        int idCliente = (int) _O;

        try {
            consultaCompleja = conexion.getCon().prepareStatement("Select * from confcliente where id = " + idCliente + ";");
            resultado = consultaCompleja.executeQuery();
            while (resultado.next()) {
                ConfCliente temp = new ConfCliente();
                temp.setId(Integer.parseInt(resultado.getString(1)));
                temp.setStrNombre(resultado.getString(2));
                temp.setStrTelCasa(resultado.getString(3));
                temp.setStrTelCel(resultado.getString(4));
                temp.setIdConfSexo(resultado.getInt(5));

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
