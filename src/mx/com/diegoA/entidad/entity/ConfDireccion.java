package mx.com.diegoA.entidad.entity;

/**
 *
 * @author Dies
 */
public class ConfDireccion {

    private int id;
    private int idConfCliente;
    private String strValor;
    private String strColonia;
    private int idConfEstado;
    private int idConfMunicipio;

    //<editor-fold defaultstate="collapsed" desc="Metodos">
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdConfCliente() {
        return idConfCliente;
    }

    public void setIdConfCliente(int idConfCliente) {
        this.idConfCliente = idConfCliente;
    }

    public String getStrValor() {
        return strValor;
    }

    public void setStrValor(String strValor) {
        this.strValor = strValor;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(id + " ");
        sb.append(strValor + " ");

        return sb.toString();

    }

    public String getStrColonia() {
        return strColonia;
    }

    public void setStrColonia(String strColonia) {
        this.strColonia = strColonia;
    }

    public int getIdConfEstado() {
        return idConfEstado;
    }

    public void setIdConfEstado(int idConfEstado) {
        this.idConfEstado = idConfEstado;
    }

    public int getIdConfMunicipio() {
        return idConfMunicipio;
    }

    public void setIdConfMunicipio(int idConfMunicipio) {
        this.idConfMunicipio = idConfMunicipio;
    }

     //</editor-fold>
}
