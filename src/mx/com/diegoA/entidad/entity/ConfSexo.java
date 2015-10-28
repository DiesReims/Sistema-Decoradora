package mx.com.diegoA.entidad.entity;

/**
 *
 * @author Dies
 */
public class ConfSexo {

    private int id;
    private String strValor;

    //<editor-fold defaultstate="collapsed" desc="Metodos">
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStrValor() {
        return strValor;
    }

    public void setStrValor(String strValor) {
        this.strValor = strValor;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(strValor);
        return sb.toString();

    }
       //</editor-fold>
}
