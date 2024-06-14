/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

/**
 *
 * @author Atermiter-X99
 */
public class dbObjetos {

    Connection cn =null;
    ResultSet rs;
    CallableStatement st;
    String Patron ="Pr09r@3";

    public ResultSet ValidarLogin(String UserName, String Clave) {
        try {
            cn =ConexionSql.getIntancia().getConexion();
            st =cn.prepareCall("{call SP_ValidarLogin(?,?,?)}");
            st.setString(1, UserName);
            st.setString(2, Clave);
            st.setString(3, Patron);
            rs = st.executeQuery();
        } catch (Exception ex) {
            ex.printStackTrace();
            rs = null;
        }
        return rs;
    }

   public ResultSet Rol(){
        try{
            cn = ConexionSql.getIntancia().getConexion();
            st = cn.prepareCall("{call SP_Rol()}");
            rs = st.executeQuery();
        }catch(Exception ex){
            ex.printStackTrace();
            rs = null;
        }
        return rs;
    }
    
    public int NuevoCliente(String Nombre, String Raza, String Color,boolean Alergico,boolean AtencionEsp,String NombreDueno,String Telefono, String Direccion, String DUI){
         int IdCliente = -1;

    try {
        cn = ConexionSql.getIntancia().getConexion();
        st = cn.prepareCall("{call SP_AgregarCliente(?,?,?,?,?,?,?,?,?,?)}");

        st.setString(1, Nombre);
        st.setString(2, Raza);
        st.setString(3, Color);
        st.setBoolean(4, Alergico);
        st.setBoolean(5, AtencionEsp);
        st.setString(6, NombreDueno);
        st.setString(7, Telefono);
        st.setString(8, Direccion);
        st.setString(9, DUI);

        // Registrar el parámetro de salida
        st.registerOutParameter(10, Types.INTEGER);

        st.execute();

        // Obtener el valor del parámetro de salida
        IdCliente = st.getInt(10);

    } catch (Exception ex) {
        ex.printStackTrace();
    }

    return IdCliente;
    }    
    
    public int ModificarCliente(int IdCliente, String Nombre ,String Raza, String Color, boolean Alergico,boolean AtencionEsp,String NombreDueno,String Telefono, String Direccion, String DUI){
        int Resp;
        try{
            cn = ConexionSql.getIntancia().getConexion();
            st = cn.prepareCall("{call SP_ModificarCliente(?,?,?,?,?,?,?,?,?,?,?)}");
            st.setInt(1, IdCliente);
            st.setString(2, Nombre);
            st.setString(3, Raza);
            st.setString(4, Color);
            st.setBoolean(5, Alergico);
            st.setBoolean(6, AtencionEsp);
            st.setString(7, NombreDueno);
            st.setString(8, Telefono);
            st.setString(9, Direccion);
            st.setString(10, DUI);
            st.registerOutParameter(11, Types.INTEGER);
            st.execute();
            Resp = st.getInt(11);
        }catch(Exception ex){
            ex.printStackTrace();
            Resp = -1;
        }
        return Resp;
    }

    public int EliminarCliente(int IdCliente){
        int Resp;
        try{
            cn = ConexionSql.getIntancia().getConexion();
            st = cn.prepareCall("{call SP_EliminarCliente(?,?)}");
            st.setInt(1, IdCliente);
            st.registerOutParameter(2, Types.INTEGER);
            st.execute();
            Resp = st.getInt(2);
        }catch(Exception ex){
            ex.printStackTrace();
            Resp = -1;
        }
        return Resp;
    }   
    
  public ResultSet BuscarCliente(int IdCliente, String Nombre, String Raza, String Color, String NombreDueno, String DUI) {
    try {
        cn = ConexionSql.getIntancia().getConexion();
        st = cn.prepareCall("{call SP_BuscarCliente(?,?,?,?,?,?)}");
        st.setInt(1, IdCliente);
        st.setString(2, Nombre);
        st.setString(3, Raza);
        st.setString(4, Color);
        st.setString(5, NombreDueno);
        st.setString(6, DUI);
        rs = st.executeQuery();
    } catch (Exception ex) {
        ex.printStackTrace();
        rs = null;
    }
    return rs;
}
    public int AgregarEmpleado(String Nombre, String UserName, String Clave,String Email,int IdRol,boolean Estado,boolean Confirmado,boolean Restablecer){
        int IdEmpleado;
        try{
            cn = ConexionSql.getIntancia().getConexion();
            st = cn.prepareCall("{call SP_AgregarEmpleado(?,?,?,?,?,?,?,?,?,?)}");
            st.setString(1, Nombre);
            st.setString(2, UserName);
            st.setString(3, Clave);
            st.setString(4, Email);
            st.setInt(5, IdRol);
            st.setBoolean(6, Estado);
            st.setBoolean(7, Confirmado);
            st.setBoolean(8, Restablecer);
            st.setString(9, Patron);
            st.registerOutParameter(10, Types.INTEGER);
            st.execute();
            IdEmpleado = st.getInt(10);
        }catch(Exception ex){
            ex.printStackTrace();
            IdEmpleado = -1;
        }
        return IdEmpleado;
    }    
    
    public int ModificarEmpleado(int IdEmpleado, String Nombre, String UserName, String Clave,String Email,int IdRol,boolean Estado,boolean Confirmado,boolean Restablecer){
        int Resp;
        try{
            cn = ConexionSql.getIntancia().getConexion();
            st = cn.prepareCall("{call SP_ModificarEmpleado(?,?,?,?,?,?,?,?,?,?,?)}");
            st.setInt(1, IdEmpleado);
            st.setString(2, Nombre);
            st.setString(3, UserName);
            st.setString(4, Clave);
            st.setString(5, Email);
            st.setInt(6, IdRol);
            st.setBoolean(7, Estado);
            st.setBoolean(8, Confirmado);
            st.setBoolean(9, Restablecer);
            st.setString(10, Patron);
            st.registerOutParameter(11, Types.INTEGER);
            st.execute();
            Resp = st.getInt(11);
        }catch(Exception ex){
            ex.printStackTrace();
            Resp = -1;
        }
        return Resp;
    }

    public int EliminarEmpleado(int IdEmpleado){
        int Resp;
        try{
            cn = ConexionSql.getIntancia().getConexion();
            st = cn.prepareCall("{call SP_EliminarEmpleado(?,?)}");
            st.setInt(1, IdEmpleado);
            st.registerOutParameter(2, Types.INTEGER);
            st.execute();
            Resp = st.getInt(2);
        }catch(Exception ex){
            ex.printStackTrace();
            Resp = -1;
        }
        return Resp;
    }   
    
    public ResultSet BuscarEmpleado(int IdEmpleado,String Nombre,String UserName, String Email, int IdRol, String Estado){
        try{
            cn = ConexionSql.getIntancia().getConexion();
            st = cn.prepareCall("{call SP_BuscarEmpleado(?,?,?,?,?,?)}");
            st.setInt(1, IdEmpleado);
            st.setString(2, Nombre);
            st.setString(3, UserName);
            st.setString(4, Email);
            st.setInt(5, IdRol);
            st.setString(6, Estado);
            rs = st.executeQuery();
        }catch(Exception ex){
            ex.printStackTrace();
            rs = null;
        }
        return rs;
    }
    
    public ResultSet Clientes() {
    try {
        cn = ConexionSql.getIntancia().getConexion();
        st = cn.prepareCall("{call SP_ListarClientes}");
        rs = st.executeQuery();
    } catch (SQLException ex) {
        rs = null;
    }
    return rs;
    }
    
    
     public ResultSet Empleados() {
    try {
        cn = ConexionSql.getIntancia().getConexion();
        st = cn.prepareCall("{call SP_ListarEmpleados}");
        rs = st.executeQuery();
    } catch (SQLException ex) {
        rs = null;
    }
    return rs;
    }
    
  public int AgregarProducto(String Nombre, double Precio, int Stock)
{
    int IdProducto = -1;
    try
    {
        cn = ConexionSql.getIntancia().getConexion();
        st = cn.prepareCall("{call SP_AgregarProducto(?, ?, ?, ?)}");
        st.setString(1, Nombre);
        st.setDouble(2, Precio);
        st.setInt(3, Stock);
        st.registerOutParameter(4, Types.INTEGER);
        st.execute();
        IdProducto = st.getInt(4);
    }
    catch (Exception ex)
    {
        ex.printStackTrace();
    }
    return IdProducto;
}
    public ResultSet Productos() {
    try {
        cn = ConexionSql.getIntancia().getConexion();
        st = cn.prepareCall("{call SP_ListarProductos}");
        rs = st.executeQuery();
    } catch (SQLException ex) {
        rs = null;
    }
    return rs;
}
    
   public ResultSet BuscarProducto(String IdProducto, String Nombre, String Precio, String Stock) { 
    try {
        cn = ConexionSql.getIntancia().getConexion();
        st = cn.prepareCall("{call SP_BuscarProducto(?,?,?,?)}");
        
        int idProducto = IdProducto.isEmpty() ? 0 : Integer.parseInt(IdProducto);
        double precio = Precio.isEmpty() ? 0.0 : Double.parseDouble(Precio);
        int cantidad = Stock.isEmpty() ? 0 : Integer.parseInt(Stock);
        
        st.setInt(1, idProducto);
        st.setString(2, Nombre);
        st.setDouble(3, precio);
        st.setInt(4, cantidad);
        
        rs = st.executeQuery();
    } catch (Exception ex) {
        ex.printStackTrace();
        rs = null; 
    }
    return rs;
}
    public int ModificarProducto(int IdProducto, String Nombre, double Precio, int Stock, String Fecha) {
    int resp = 0;
    try {
        cn = ConexionSql.getIntancia().getConexion();
        st = cn.prepareCall("{call SP_ModificarProducto(?, ?, ?, ?, ?, ?)}");
        st.setInt(1, IdProducto);
        st.setString(2, Nombre);
        st.setDouble(3, Precio);
        st.setInt(4, Stock);
        st.setString(5, Fecha);
        st.registerOutParameter(6, Types.INTEGER);
        st.execute();
        resp = st.getInt(6);
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    return resp;
}
    
public boolean EliminarProducto(int idProducto) {
    boolean resultado = false;
    try {
        cn = ConexionSql.getIntancia().getConexion();
        st = cn.prepareCall("{call SP_EliminarProducto(?, ?)}");
        st.setInt(1, idProducto);
        st.registerOutParameter(2, Types.INTEGER);
        st.execute();
        int resp = st.getInt(2);
        resultado = resp == 1;
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    return resultado;
}
    
  public int GenerarVenta(String DUI, int IdProducto, int Cantidad, double PrecioTotal, double SubTotal, double IVA, double Total) {
    int IdVenta = -1;
    try (Connection cn = ConexionSql.getIntancia().getConexion()) {
        try (CallableStatement st = cn.prepareCall("{call GenerarVenta(?, ?, ?, ?, ?, ?, ?, ?)}")) {
            st.setString(1, DUI);
            st.setInt(2, IdProducto);
            st.setInt(3, Cantidad);
            st.setDouble(4, PrecioTotal);
            st.setDouble(5, SubTotal);
            st.setDouble(6, IVA);
            st.setDouble(7, Total);
            st.registerOutParameter(8, Types.INTEGER); // Parámetro de salida para el IdVenta

            st.execute();

            // Obtener el valor del parámetro de salida
            IdVenta = st.getInt(8);
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return IdVenta;
}
public ResultSet ListarMascotas() {
    try {
        cn = ConexionSql.getIntancia().getConexion();
        st = cn.prepareCall("{call SP_ListarMascotas}");
        rs = st.executeQuery();
    } catch (SQLException ex) {
        rs = null;
    }
    return rs;
}

public ResultSet ListarServicio() {
    try {
        cn = ConexionSql.getIntancia().getConexion();
        st = cn.prepareCall("{call SP_ListarServicio}");
        rs = st.executeQuery();
    } catch (SQLException ex) {
        rs = null;
    }
    return rs;
}
public ResultSet ObtenerPrecioServicio(String nombreServicio) {
    try {
        cn = ConexionSql.getIntancia().getConexion();
        st = cn.prepareCall("{call SP_ObtenerPrecioServicio(?)}");
        st.setString(1, nombreServicio);
        rs = st.executeQuery();
    } catch (SQLException ex) {
        rs = null;
    }
    return rs;
}
public int InsertarReserva(java.sql.Date fechaReserva, java.sql.Time hora, String nombreMascota, String nombreServicio, double total) {
    int codigoReserva = -1;
    try {
        cn = ConexionSql.getIntancia().getConexion();
        st = cn.prepareCall("{call SP_InsertarReserva(?, ?, ?, ?, ?, ?)}");
        st.setDate(1, fechaReserva);
        st.setTime(2, hora);
        st.setString(3, nombreMascota);
        st.setString(4, nombreServicio);
        st.setDouble(5, total);
        st.registerOutParameter(6, Types.INTEGER);
        st.execute();
        codigoReserva = st.getInt(6);
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    return codigoReserva;
}
public boolean ActualizarReserva(int codigoReserva, java.sql.Date fechaReserva, java.sql.Time hora, String nombreMascota, String nombreServicio, double total) {
    boolean actualizado = false;
    try {
        cn = ConexionSql.getIntancia().getConexion();
        st = cn.prepareCall("{call SP_ActualizarReserva(?, ?, ?, ?, ?, ?)}");
        st.setInt(1, codigoReserva);
        st.setDate(2, fechaReserva);
        st.setTime(3, hora);
        st.setString(4, nombreMascota);
        st.setString(5, nombreServicio);
        st.setDouble(6, total);
        st.execute();
        actualizado = true;
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    return actualizado;
}

public boolean EliminarReserva(int codigoReserva) {
    boolean eliminado = false;
    try {
        cn = ConexionSql.getIntancia().getConexion();
        st = cn.prepareCall("{call SP_EliminarReserva(?)}");
        st.setInt(1, codigoReserva);
        st.execute();
        eliminado = true;
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    return eliminado;
}

public ResultSet BuscarReserva(int codigoReserva) {
    ResultSet rs = null;
    try {
        cn = ConexionSql.getIntancia().getConexion();
        st = cn.prepareCall("{call SP_BuscarReserva(?)}");
        st.setInt(1, codigoReserva);
        rs = st.executeQuery();
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    return rs;
}


    public int AgregarServicio(String Nombre, double Precio) {
        int IdServicio;
        try {
            cn = ConexionSql.getIntancia().getConexion();
            st = cn.prepareCall("{call SP_AgregarServicio(?, ?,?)}");
            st.setString(1, Nombre);
            st.setDouble(2, Precio);
            st.registerOutParameter(3, Types.INTEGER); // Parámetro de salida para el IdProducto
            st.execute();
            // Obtener el valor del parámetro de salida
            IdServicio = st.getInt(3);

        } catch (SQLException ex) {
            ex.printStackTrace();
            IdServicio = -1;
        }
        return IdServicio;
    }
    
     public int ModificarServicio(int IdServicio, String Nombre, double Precio) {
        int Resp;
        try {
            cn = ConexionSql.getIntancia().getConexion();
            st = cn.prepareCall("{call SP_ModificarServicio(?, ?,?)}");
            st.setString(1, Nombre);
            st.setDouble(2, Precio);
            st.registerOutParameter(3, Types.INTEGER);
            st.execute();
            Resp = st.getInt(3);
        } catch (Exception ex) {
            ex.printStackTrace();
            Resp = -1;
        }
        return Resp;
    }
     
     
     public ResultSet BuscarServicio(int IdServicio, String Nombre, double Precio) {
        try {
            cn = ConexionSql.getIntancia().getConexion();
            st = cn.prepareCall("{call SP_BuscarServicio(?,?,?)}");
            st.setInt(1, IdServicio);
            st.setString(2, Nombre);
            st.setDouble(3, Precio);
            rs = st.executeQuery();
        } catch (Exception ex) {
            ex.printStackTrace();
            rs = null;
        }
        return rs;
    }
     
     
      public ResultSet Servicios() {
        try {
            cn = ConexionSql.getIntancia().getConexion();
            st = cn.prepareCall("{call SP_ListarServicio}");
            rs = st.executeQuery();
        } catch (SQLException ex) {
            rs = null;
        }
        return rs;
    }
}