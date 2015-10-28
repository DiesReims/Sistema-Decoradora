package mx.com.diegoA.entidad.entity;

import java.util.ArrayList;

/**
 *
 * @author Dies
 */
public class ConfProveedor {

    private String strBusqueda;
    private int id;
    private int idConfTipoProveedor;
    private String strNombre;
    private String strTelCasa;
    private String strTelCel;
    private String strRazonSocial;
    private ArrayList<ConfDireccionProveedor> direccion = new ArrayList();

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

    public ArrayList<ConfDireccionProveedor> getDireccion() {
        return direccion;
    }

    public void setDireccion(ArrayList<ConfDireccionProveedor> direccion) {
        this.direccion = direccion;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(id + " ");
        sb.append(strNombre + " ");
        sb.append(strTelCel + " ");
        sb.append(strTelCasa + " ");

        return sb.toString();

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdConfProveedor() {
        return idConfTipoProveedor;
    }

    public void setIdConfProveedor(int idConfTipoProveedor) {
        this.idConfTipoProveedor = idConfTipoProveedor;
    }

    public String getStrBusqueda() {
        return strBusqueda;
    }

    public void setStrBusqueda(String strBusqueda) {
        this.strBusqueda = strBusqueda;
    }
    

    public String getStrRazonSocial() {
        return strRazonSocial;
    }

    public void setStrRazonSocial(String strRazonSocial) {
        this.strRazonSocial = strRazonSocial;
    }
    //</editor-fold>
}
