/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Soporte
 */
public class ConexionSql {

    Connection cn = null;
    static ConexionSql instancia = null;
    String strConex = "jdbc:sqlserver://DESKTOP-4HOSKP8:1433;databaseName=PeluqueriaCanina;trustServerCertificate=true;";
    String strDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    public ConexionSql() {
        try {
            Class.forName(strDriver);
            cn = DriverManager.getConnection(strConex, "UserPro3", "User123*");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static ConexionSql getIntancia() {
        try {
            if (instancia == null) {
                instancia = new ConexionSql();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return instancia;
    }

    public Connection getConexion() {
        return cn;
    }
    
    
    public void cerrarConexion() {
    try {
        if (cn != null) {
            cn.close();
        }
    } catch (Exception ex) {
        ex.printStackTrace();
    }
}

}
