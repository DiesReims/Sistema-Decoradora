/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.diegoA.entidad.entity;

/**
 *
 * @author Juan
 */
public class ConfEstados {

    private int Id;
    private String Nombre;

    public ConfEstados() {
        super();
    }

    //<editor-fold defaultstate="collapsed" desc="Metodos">
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.Nombre);
        return sb.toString();
    }
    //</editor-fold>
}
