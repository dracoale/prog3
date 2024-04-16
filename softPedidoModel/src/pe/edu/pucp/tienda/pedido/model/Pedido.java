/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.tienda.pedido.model;
import  pe.edu.pucp.tienda.factura.model.Factura;
import java.util.ArrayList;
import java.util.Date;

public class Pedido {

    private int idPedido;
    private EstadoPedido estado;
    private Date fechaPedido;
    private Date fechaCreacion;
    private Prioridad prioridad;
    private Date fechaEntrega;
    private Factura factura;
    private ArrayList<DetallePedido> detallePedidos; 
    
    public Pedido() {
    }

  
    public Pedido(int idPedido, EstadoPedido estado, Date fechaPedido, Date fechaCreacion, Prioridad prioridad, Date fechaEntrega) {
        this.idPedido = idPedido;
        this.estado = estado;
        this.fechaPedido = fechaPedido;
        this.fechaCreacion = fechaCreacion;
        this.prioridad = prioridad;
        this.fechaEntrega = fechaEntrega;
        
        detallePedidos=new ArrayList<>();
        
    }

    // Getters
    public int getIdPedido() {
        return idPedido;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    // Setters
    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }
    public ArrayList<DetallePedido> getListaDetallesPedidos() {
        return detallePedidos;
    }
    public void generarBoleta(String type) {

    }

    public EstadoPedido validarPedido() {
    return null;
    }
}
