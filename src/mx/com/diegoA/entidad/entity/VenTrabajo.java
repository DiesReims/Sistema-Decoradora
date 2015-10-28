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
public class VenTrabajo {

    private int Id;
    private int IdConfProducto;
    private int IdVenPresupuesto;
    private double MedAncho;
    private double MedLargo;
    private String strBusqueda;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getIdConfProducto() {
        return IdConfProducto;
    }

    public void setIdConfProducto(int IdConfProducto) {
        this.IdConfProducto = IdConfProducto;
    }

    public int getIdVenPresupuesto() {
        return IdVenPresupuesto;
    }

    public void setIdVenPresupuesto(int IdVenPresupuesto) {
        this.IdVenPresupuesto = IdVenPresupuesto;
    }

    public double getMedAncho() {
        return MedAncho;
    }

    public void setMedAncho(double MedAncho) {
        this.MedAncho = MedAncho;
    }

    public double getMedLargo() {
        return MedLargo;
    }

    public void setMedLargo(double MedLargo) {
        this.MedLargo = MedLargo;
    }

    public String getStrBusqueda() {
        return strBusqueda;
    }

    public void setStrBusqueda(String strBusqueda) {
        this.strBusqueda = strBusqueda;
    }
    
    

}
