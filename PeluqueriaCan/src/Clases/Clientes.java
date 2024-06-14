/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Enzor Reyes
 */
public class Clientes {
    int IdCliente;
    String Nombre;
    String Raza;
    String Color;
    boolean Alergico;
    boolean AtencionEsp;
    String NombreDueno;
    String Telefono;
    String Observaciones;
    String Error;

    public int getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente (int IdCliente) {
        this.IdCliente = IdCliente;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getRaza() {
        return Raza;
    }

    public void setRaza(String Raza) {
        this.Raza = Raza;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }


    public boolean isAlergico() {
        return Alergico;
    }

    public void setAlergico(boolean Alergico) {
        this.Alergico = Alergico;
    }

    public boolean isAtencionEsp() {
        return AtencionEsp;
    }

    public void setAtencionEspecial(boolean AtencionEsp) {
        this.AtencionEsp = AtencionEsp;
    }

    public String getNombreDueno() {
        return NombreDueno;
    }

    public void setNombreDueno(String NombreDueno) {
        this.NombreDueno = NombreDueno;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }
    
       public String getObservaciones() {
        return Observaciones;
    }

    public void setObservaciones(String Observaciones) {
        this.Observaciones = Observaciones;
    }

    public String getError() {
        return Error;
    }

    public void setError(String Error) {
        this.Error = Error;
    }
}