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
public class ConfPMA {
    private int Id;
    private int IdPerfil;
    private int IdModulo;
    private boolean Agregar;
    private boolean Editar;
    private boolean Eliminar;
    private boolean Imprimir;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getIdPerfil() {
        return IdPerfil;
    }

    public void setIdPerfil(int IdPerfil) {
        this.IdPerfil = IdPerfil;
    }

    public int getIdModulo() {
        return IdModulo;
    }

    public void setIdModulo(int IdModulo) {
        this.IdModulo = IdModulo;
    }

    public boolean isAgregar() {
        return Agregar;
    }

    public void setAgregar(boolean Agregar) {
        this.Agregar = Agregar;
    }

    public boolean isEditar() {
        return Editar;
    }

    public void setEditar(boolean Editar) {
        this.Editar = Editar;
    }

    public boolean isEliminar() {
        return Eliminar;
    }

    public void setEliminar(boolean Eliminar) {
        this.Eliminar = Eliminar;
    }

    public boolean isImprimir() {
        return Imprimir;
    }

    public void setImprimir(boolean Imprimir) {
        this.Imprimir = Imprimir;
    }
    
    
}
