package mx.com.diegoA.entidad.entity;


public class ConfEmpleado {

    private int id;
    private String strUsuario;
    private String strContraseña;
    private int idPerfil;
    private String strBusqueda;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStrUsuario() {
        return strUsuario;
    }

    public void setStrUsuario(String strUsuario) {
        this.strUsuario = strUsuario;
    }

    public String getStrContraseña() {
        return strContraseña;
    }

    public void setStrContraseña(String strContraseña) {
        this.strContraseña = strContraseña;
    }

    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.id);
        sb.append(this.idPerfil);
        sb.append(this.strContraseña);
        sb.append(this.strUsuario);

        return sb.toString();

    }

    public String getStrBusqueda() {
        return strBusqueda;
    }

    public void setStrBusqueda(String strBusqueda) {
        this.strBusqueda = strBusqueda;
    }
    
    

}
