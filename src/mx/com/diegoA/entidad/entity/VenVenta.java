package mx.com.diegoA.entidad.entity;

import java.sql.Date;

/**
 *
 * @author Dies
 */
public class VenVenta {

    private int Id;
    private int IdVenPresupuesto;
    private int IdVenEstadoVenta;
    private Date DtFecha;
    private String strBusqueda;

    //<editor-fold defaultstate="collapsed" desc="Metodos">
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getIdVenPresupuesto() {
        return IdVenPresupuesto;
    }

    public void setIdVenPresupuesto(int IdVenPresupuesto) {
        this.IdVenPresupuesto = IdVenPresupuesto;
    }

    public int getIdVenEstadoVenta() {
        return IdVenEstadoVenta;
    }

    public void setIdVenEstadoVenta(int IdVenEstadoVenta) {
        this.IdVenEstadoVenta = IdVenEstadoVenta;
    }

    public Date getDtFecha() {
        return DtFecha;
    }

    public void setDtFecha(Date DtFecha) {
        this.DtFecha = DtFecha;
    }

    public String getStrBusqueda() {
        return strBusqueda;
    }

    public void setStrBusqueda(String strBusqueda) {
        this.strBusqueda = strBusqueda;
    }
    //</editor-fold>

}
