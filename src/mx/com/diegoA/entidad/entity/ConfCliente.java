package mx.com.diegoA.entidad.entity;

import java.util.ArrayList;

/**
 *
 * @author Dies
 */
public class ConfCliente {

    private String strBusqueda;
    private int id;
    private int idConfSexo;
    private String strNombre;
    private String strTelCasa;
    private String strTelCel;
    private ArrayList<ConfDireccion> direccion = new ArrayList();

//<editor-fold defaultstate="collapsed" desc="Metodos">
    public String getStrNombre() {
        return strNombre;
    }

    public void setStrNombre(String strNombre) {
        this.strNombre = strNombre;
    }

    public String getStrTelCasa() {
        return strTelCasa;
    }

    public void setStrTelCasa(String strTelCasa) {
        this.strTelCasa = strTelCasa;
    }

    public String getStrTelCel() {
        return strTelCel;
    }

    public void setStrTelCel(String strTelCel) {
        this.strTelCel = strTelCel;
    }

    public ArrayList<ConfDireccion> getDireccion() {
        return direccion;
    }

    public void setDireccion(ArrayList<ConfDireccion> direccion) {
        this.direccion = direccion;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(strNombre);
        return sb.toString();

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdConfSexo() {
        return idConfSexo;
    }

    public void setIdConfSexo(int idConfSexo) {
        this.idConfSexo = idConfSexo;
    }

    public String getStrBusqueda() {
        return strBusqueda;
    }

    public void setStrBusqueda(String strBusqueda) {
        this.strBusqueda = strBusqueda;
    }
    //</editor-fold>
}
