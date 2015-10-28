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
public class ConfProducto {

    private int id;
    private int idConfMarca;
    private int idConfTipoProducto;
    private int idConfColeccion;
    private int idConfMaterial;
    private int idConfColor;
    private String strValor;
    private String strDescripcion;
    private Double curPrecio;
    private String strBusqueda;

    //<editor-fold defaultstate="collapsed" desc="Metodos">
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdConfMarca() {
        return idConfMarca;
    }

    public void setIdConfMarca(int idConfMarca) {
        this.idConfMarca = idConfMarca;
    }

    public int getIdConfTipoProducto() {
        return idConfTipoProducto;
    }

    public void setIdConfTipoProducto(int idConfTipoProducto) {
        this.idConfTipoProducto = idConfTipoProducto;
    }

    public int getIdConfColeccion() {
        return idConfColeccion;
    }

    public void setIdConfColeccion(int idConfColeccion) {
        this.idConfColeccion = idConfColeccion;
    }

    public int getIdConfMaterial() {
        return idConfMaterial;
    }

    public void setIdConfMaterial(int idConfMaterial) {
        this.idConfMaterial = idConfMaterial;
    }

    public int getIdConfColor() {
        return idConfColor;
    }

    public void setIdConfColor(int idConfColor) {
        this.idConfColor = idConfColor;
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

    public Double getCurPrecio() {
        return curPrecio;
    }

    public void setCurPrecio(Double curPrecio) {
        this.curPrecio = curPrecio;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(strValor);
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
