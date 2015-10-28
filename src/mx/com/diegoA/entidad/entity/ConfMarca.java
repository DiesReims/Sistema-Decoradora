package mx.com.diegoA.entidad.entity;

/**
 *
 * @author Dies
 */
public class ConfMarca {

    private int id;
    private String strvalor;
    private String strdescripcion;
    private int idconfestadoglobal;
    private String strBusqueda;

    //<editor-fold defaultstate="collapsed" desc="Metodos">
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStrvalor() {
        return strvalor;
    }

    public void setStrvalor(String strvalor) {
        this.strvalor = strvalor;
    }

    public String getStrdescripcion() {
        return strdescripcion;
    }

    public void setStrdescripcion(String strdescripcion) {
        this.strdescripcion = strdescripcion;
    }

    public int getIdconfestadoglobal() {
        return idconfestadoglobal;
    }

    public void setIdconfestadoglobal(int idconfestadoglobal) {
        this.idconfestadoglobal = idconfestadoglobal;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(strvalor);
        return sb.toString();

    }

    public String getStrBusqueda() {
        return strBusqueda;
    }

    public void setStrBusqueda(String strBusqueda) {
        this.strBusqueda = strBusqueda;
    }
    //</editor-fold>
}
