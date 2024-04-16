/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.tienda.pedido.model;

import java.util.ArrayList;
import pe.edu.pucp.tienda.producto.model.Producto;

public class DetallePedido {
    private int idDetallePedido;
    private int cantidad;
    private double subtotal;
    private ArrayList<Producto> productos;
    
    public DetallePedido() {
    }

    
    public DetallePedido(int idDetallePedido, int cantidad, double subtotal) {
        this.idDetallePedido = idDetallePedido;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        productos=new ArrayList<>();
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

    // Setters
    public void setIdDetallePedido(int idDetallePedido) {
        this.idDetallePedido = idDetallePedido;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public ArrayList<Producto> getListaProductos() {
        return productos;
    }
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
}
