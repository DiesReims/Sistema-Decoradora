package mx.com.diegoA.entidad.entity;

import java.sql.ResultSet;

/**
 *
 * @author Dies
 */
public class ConfEstadoGlobal {

    private int id;
    private String strValor;
    private String strDescripcion;
    private ResultSet resultado;

    //<editor-fold defaultstate="collapsed" desc="Metodos">
    public int getId() {
        return id;
    }

    public void setId(int Id) {
        this.id = Id;
    }

    public String getStrValor() {
        return strValor;
    }

    public void setStrValor(String strValor) {
        this.strValor = strValor;
    }

    public String getStrDescripcion() {
        return strDescripcion;
    }

    public void setStrDescripcion(String strDescripcion) {
        this.strDescripcion = strDescripcion;
    }

    public ResultSet getResultado() {
        return resultado;
    }

    public void setResultado(ResultSet resultado) {
        this.resultado = resultado;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(strValor);       
        return sb.toString();

    }
    //</editor-fold>
}
