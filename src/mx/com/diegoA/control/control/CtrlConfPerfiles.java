package mx.com.diegoA.control.control;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.com.diegoA.control.Icontrol.IAccionesDB;
import mx.com.diegoA.control.conexion.ctrlConexion;
import mx.com.diegoA.entidad.entity.ConfPerfiles;
import mx.com.diegoA.entidad.entity.ConfSexo;

/**
 *
 * @author Dies
 */
public class CtrlConfPerfiles extends ctrlConexion implements IAccionesDB {

    ctrlConexion conexion;

    public CtrlConfPerfiles() throws SQLException {
        conexion = new ctrlConexion();
    }

    //<editor-fold defaultstate="collapsed" desc="Metodos">
    @Override
    public boolean Agregar(Object O) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Editar(Object O) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean ConsultaSimple(Object O) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Eliminar(Object O) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Object> ConsultaEspecializada(Object O) {
        try {
            ArrayList<ConfPerfiles> consulta = new ArrayList();
            PreparedStatement consultaCompleja;
            ResultSet resultado;
            consultaCompleja = conexion.getCon().prepareStatement("Select * from Perfil;");
            resultado = consultaCompleja.executeQuery();
            while (resultado.next()) {
                ConfPerfiles temp = new ConfPerfiles();
                temp.setId(Integer.parseInt(resultado.getString(1)));
                temp.setStrValor(resultado.getString(2));
                consulta.add(temp);

            }
            consultaCompleja.close();
            return new ArrayList(consulta);
        } catch (SQLException ex) {
            Logger.getLogger(CtrlConfPerfiles.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public ArrayList<Object> ConsultaCompleja(Object _obj) {

        ArrayList<ConfPerfiles> consulta = new ArrayList();
        PreparedStatement consultaCompleja;
        ResultSet resultado;
        int idPerf = (int) _obj;
        System.out.println("El id recibido es IdPerfil: " + idPerf);
        try {
            consultaCompleja = conexion.getCon().prepareStatement("Select * from perfil where id =" + idPerf + ";");
            resultado = consultaCompleja.executeQuery();
            while (resultado.next()) {
                ConfPerfiles temp = new ConfPerfiles();
                temp.setId(Integer.parseInt(resultado.getString(1)));
                temp.setStrValor(resultado.getString(2));
//                temp.setIdEstado(Integer.parseInt(resultado.getString(3)));

                consulta.add(temp);

            }
            consultaCompleja.close();
            return new ArrayList(consulta);
        } catch (SQLException ex) {
            Logger.getLogger(CtrlConfPerfiles.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public ArrayList<Object> ConsultaCompleja() {
        try {
            ArrayList<ConfPerfiles> consulta = new ArrayList();
            PreparedStatement consultaCompleja;
            ResultSet resultado;
            consultaCompleja = conexion.getCon().prepareStatement("Select * from Perfil;");
            resultado = consultaCompleja.executeQuery();
            while (resultado.next()) {
                ConfPerfiles temp = new ConfPerfiles();
                temp.setId(Integer.parseInt(resultado.getString(1)));
                temp.setStrValor(resultado.getString(2));
                consulta.add(temp);

            }
            consultaCompleja.close();
            return new ArrayList(consulta);
        } catch (SQLException ex) {
            Logger.getLogger(CtrlConfPerfiles.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public int ConsultarUltimo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Object> ConsultaParaManager(Object O) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    //</editor-fold>

    @Override
    public ArrayList<Object> ConsultaEspecializada2(Object O, Object _obj2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
