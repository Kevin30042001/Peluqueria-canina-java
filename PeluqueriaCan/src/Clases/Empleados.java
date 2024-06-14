/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Soporte
 */
public class Empleados {
    int IdEmpleado;
    String Nombre;
    String UserName;
    String Clave;
    String Email;
    int IdRol;
    boolean Estado;
    boolean Confirmado;
    boolean Restablecer;
    String Token;
    String Fecha;
    String Rol;
    String Error;

    public int getIdEmpleado() {
        return IdEmpleado;
    }

    public void setIdEmpleado (int IdEmpleado) {
        this.IdEmpleado = IdEmpleado;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String Clave) {
        this.Clave = Clave;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getIdRol() {
        return IdRol;
    }

    public void setIdRol(int IdRol) {
        this.IdRol = IdRol;
    }

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }

    public boolean isConfirmado() {
        return Confirmado;
    }

    public void setConfirmado(boolean Confirmado) {
        this.Confirmado = Confirmado;
    }

    public boolean isRestablecer() {
        return Restablecer;
    }

    public void setRestablecer(boolean Restablecer) {
        this.Restablecer = Restablecer;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String Token) {
        this.Token = Token;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }
    
       public String getRol() {
        return Rol;
    }

    public void setRol(String Rol) {
        this.Rol = Rol;
    }

    public String getError() {
        return Error;
    }

    public void setError(String Error) {
        this.Error = Error;
    }
    
    
}