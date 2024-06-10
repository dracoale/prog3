/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.tienda.pedido.model;
import java.util.ArrayList;
import java.util.Date;

public class Pedido {

    private int idPedido;
    private EstadoPedido estado;
    private int idUsuario;
    private Date fechaPedido;
    private Prioridad prioridad;
    private Date fechaEntrega;
    private ArrayList<DetallePedido> detallePedidos; 
    
    public Pedido() {
    }

  
    public Pedido(Date fechaPedido, Date fechaCreacion, Prioridad prioridad, Date fechaEntrega) {
        this.fechaPedido = fechaPedido;
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


    public Prioridad getPrioridad() {
        return prioridad;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
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

    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }
    public ArrayList<DetallePedido> getDetallePedidos() {
        return detallePedidos;
    }

    public void setDetallePedidos(ArrayList<DetallePedido> detallePedidos) {
        this.detallePedidos = detallePedidos;
    }
   
}
