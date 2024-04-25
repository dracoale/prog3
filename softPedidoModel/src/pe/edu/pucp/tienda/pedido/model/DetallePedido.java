/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.tienda.pedido.model;

import pe.edu.pucp.tienda.producto.model.Producto;

public class DetallePedido {
    private int idDetallePedido;
    private int idPedido;
    private int cantidad;
    private double subtotal;
    private Producto producto;
    private boolean activo;
    
    public DetallePedido() {
    }

    
    public DetallePedido(int cantidad, double subtotal) {
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    // Getters
    public int getIdDetallePedido() {
        return idDetallePedido;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }
    
    public Producto getProducto() {
        return producto;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    // Setters
    public void setIdDetallePedido(int idDetallePedido) {
        this.idDetallePedido = idDetallePedido;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

   
}
