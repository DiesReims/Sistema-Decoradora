/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.diegoA.entidad.claseEstatica;

/**
 *
 * @author Dies
 */
public class ecConexion {

    private static String user = "root";
    private static String Url = "jdbc:mysql://localhost:3306/PERSIANASYCORTINAS";
    private static String password = "furimmer";
    private static String BD= "PersianasyCortinas";

    //<editor-fold defaultstate="collapsed" desc="Metodos">
    public static String getUser() {
        return user;
    }

    public static void setUser(String aUser) {
        user = aUser;
    }

    public static String getUrl() {
        return Url;
    }

    public static void setUrl(String aUrl) {
        Url = aUrl;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String aPassword) {
        password = aPassword;
    }
    
//</editor-fold>

    public static  String getBD() {
        return BD;
    }

    public static void setBD(String aBD) {
        BD = aBD;
    }
}
