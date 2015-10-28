/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.diegoA.entidad.entity;

import java.util.ArrayList;

/**
 *
 * @author Dies
 */
public class VenPresupuesto {
    private int Id;
    private int IdConfCliente;
    private String strValor;
    private String strBusqueda;
     private ArrayList<VenTrabajo> Trabajo = new ArrayList();

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getIdConfCliente() {
        return IdConfCliente;
    }

    public void setIdConfCliente(int IdConfCliente) {
        this.IdConfCliente = IdConfCliente;
    }

    public String getStrValor() {
        return strValor;
    }

    public void setStrValor(String strValor) {
        this.strValor = strValor;
    }

    public String getStrBusqueda() {
        return strBusqueda;
    }

    public void setStrBusqueda(String strBusqueda) {
        this.strBusqueda = strBusqueda;
    }
    
    
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(strValor);
        return sb.toString();
    }

    public ArrayList<VenTrabajo> getTrabajo() {
        return Trabajo;
    }

    public void setTrabajo(ArrayList<VenTrabajo> Trabajo) {
        this.Trabajo = Trabajo;
    }
}
