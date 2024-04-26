/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.tienda.producto.model;

import java.util.Date;

/**
 *
 * @author Windows 10
 */
public class Oferta {

    private int idOferta;
    private String descripcion;
    private double descuento;
    private Date fechaInicio;
    private Date fechaFin;
    private Producto producto;

    public Oferta() {

    }

    public Oferta(String descripcion, double descuento,
            Date fechaInicio, Date fechaFin, Producto producto) {

        this.descripcion = descripcion;
        this.descuento = descuento;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.producto = producto;
    }

    public int getIdOferta() {
        return idOferta;
    }

    public void setIdOferta(int idOferta) {
        this.idOferta = idOferta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String imprimirProducto() {
        String cadena = " ";
        return cadena;
    }

    public void actualizarStock(int cant) {
    }

    public void agregarProducto(Producto producto) {
    }

    public void modificarProducto(String nombre, Producto producto) {
    }

    public void eliminarProducto(String nombre) {
    }

    public String generarEstadisticas(Producto producto) {
        String cadena = "";
        return cadena;
    }

}
