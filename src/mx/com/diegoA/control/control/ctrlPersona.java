package mx.com.diegoA.control.control;

import java.sql.PreparedStatement;
import mx.com.diegoA.control.Icontrol.IAccionesDB;
import mx.com.diegoA.control.conexion.ctrlConexion;
import java.sql.SQLException;
import java.util.ArrayList;
import mx.com.diegoA.entidad.entity.PersonaDiego;

/**
 *
 * @author Dies
 */
public class ctrlPersona extends ctrlConexion implements IAccionesDB {

    //Esta es una controladora de prueba
    PreparedStatement Agregar;
    ctrlConexion ctrlCon;
    PersonaDiego Persona = new PersonaDiego();

    public ctrlPersona() throws SQLException {
        this.ctrlCon = new ctrlConexion();
    }

    //<editor-fold defaultstate="collapsed" desc="Metodos">
    @Override
    public boolean Agregar(Object _O) {
        try {
            Agregar = ctrlCon.getCon().prepareStatement("insert into PersonaDiego(strNombre,StrAPaterno)"
                    + "values(?,?)");
            Agregar.setString(1, Persona.getStrNombre());
            Agregar.setString(2, Persona.getStrApellidoPaterno());

            Agregar.execute();
        } catch (Exception e) {
            System.out.println("Error ControlPersona al Agregar Empleado:" + e);
        } finally {
            try {
                Agregar.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return true;
    }

    @Override
    public boolean Editar(Object _O) {

        return true;
    }

    @Override
    public boolean ConsultaSimple(Object _O) {

        return true;
    }

    @Override
    public boolean Eliminar(Object O) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Object> ConsultaCompleja() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
