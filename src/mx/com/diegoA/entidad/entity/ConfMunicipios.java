package mx.com.diegoA.entidad.entity;

public class ConfMunicipios {

    private int Id;
    private String Nombre;
    private int IdEstado;

    public ConfMunicipios() {
        super();
    }

    //<editor-fold defaultstate="collapsed" desc="Metodos">
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getIdEstado() {
        return IdEstado;
    }

    public void setIdEstado(int IdEstado) {
        this.IdEstado = IdEstado;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.Nombre);
        return sb.toString();
    }
//</editor-fold>
}
