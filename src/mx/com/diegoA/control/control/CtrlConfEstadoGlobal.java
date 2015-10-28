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
public class CtrlConfEstadoGlobal extends ctrlConexion implements IAccionesDB {

    ctrlConexion ctrlConexion;

    public CtrlConfEstadoGlobal() throws SQLException {
        this.ctrlConexion = new ctrlConexion();
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
    public boolean Eliminar(Object O) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean ConsultaSimple(Object O) {
        return false;
    }

    @Override
    public ArrayList<Object> ConsultaCompleja() {
        ArrayList<ConfEstadoGlobal> consulta = new ArrayList();
        PreparedStatement consultaCompleja;
        ResultSet resultado;

        try {
            consultaCompleja = ctrlConexion.getCon().prepareStatement("Select * from confestadoglobal");
            resultado = consultaCompleja.executeQuery();
            while (resultado.next()) {//System.out.println(resultado.getString(1)+" "+resultado.getString(2)+" "+resultado.getString(3));
                ConfEstadoGlobal temp = new ConfEstadoGlobal();
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
    public ArrayList<Object> ConsultaCompleja(Object O) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Object> ConsultaEspecializada(Object O) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
