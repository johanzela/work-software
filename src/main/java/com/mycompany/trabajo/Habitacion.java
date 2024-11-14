/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabajo;

/**
 *
 * @author leoch
 */
public class Habitacion {
    private int numero;
    private int camas;
    private int piso;
    private double precio;
    private String estado;

    public Habitacion() {
    }

    public Habitacion(int numero, int camas, int piso, double precio, String estado) {
        this.numero = numero;
        this.camas = camas;
        this.piso = piso;
        this.precio = precio;
        this.estado = estado;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCamas() {
        return camas;
    }

    public void setCamas(int camas) {
        this.camas = camas;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public void cambiarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
    }
    @Override
    public String toString() {
        return  numero + "\t" +
                camas + "\t"+
                piso + "\t"+
                "S/."+precio + "\t" +
                estado;
    }
}
