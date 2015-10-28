

package mx.com.diegoA.entidad.entity;

/**
 *
 * @author Dies
 */
public class ConfColeccion {
    private int id;
    private String strvalor;
    private String strDescripcion;
    private String strBusqueda;
    private int idConfMarca;
    
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

    public String getStrDescripcion() {
        return strDescripcion;
    }

    public void setStrDescripcion(String strDescripcion) {
        this.strDescripcion = strDescripcion;
    }

    public int getIdConfMarca() {
        return idConfMarca;
    }

    public void setIdConfMarca(int idConfMarca) {
        this.idConfMarca = idConfMarca;
    }

    public String getStrBusqueda() {
        return strBusqueda;
    }

    public void setStrBusqueda(String strBusqueda) {
        this.strBusqueda = strBusqueda;
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.strvalor);
        return sb.toString();
    }
    
     //</editor-fold>
}
