/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.diegoA.entidad.entity;

/**
 *
 * @author Dies
 */
public class ConfMaterial {

    private int id;
    private String strValor;
    private String strDescripcion;
    private int idConfTipoMaterial;
    private String strBusqueda;

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

    public String getStrDescripcion() {
        return strDescripcion;
    }

    public void setStrDescripcion(String strDescripcion) {
        this.strDescripcion = strDescripcion;
    }

    public int getIdConfTipoMaterial() {
        return idConfTipoMaterial;
    }

    public void setIdConfTipoMaterial(int idConfTipoMaterial) {
        this.idConfTipoMaterial = idConfTipoMaterial;
    }

    public String getStrBusqueda() {
        return strBusqueda;
    }

    public void setStrBusqueda(String strBusqueda) {
        this.strBusqueda = strBusqueda;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(strValor);

        return sb.toString();

    }
    //</editor-fold>
}
