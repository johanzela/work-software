/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabajo;


/**
 *
 * @author leoch
 */
public class Hotel {
    private String nombre;
    private String direccion;
    private String distrito;
    private String telefono;

    public Hotel() {
    }

    public Hotel(String nombre, String direccion, String distrito, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.distrito = distrito;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
    @Override
    public String toString() {
        return "Hotel: " + nombre +
               " | Dirección: " + direccion +
               " | Distrito: " + distrito +
               " | Teléfono: " + telefono;
    }
}
