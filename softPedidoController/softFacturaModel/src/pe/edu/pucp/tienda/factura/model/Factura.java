/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.tienda.factura.model;

import java.util.Date;
//import pe.edu.pucp.tienda.pedido.model.Pedido;

public class Factura {

    private int idFactura;
    private Date fecha;
    private double total;
    //private Pedido pedido;
    public Factura(){
        
    };
    public Factura(int idFactura, Date fecha, double total) {
        this.idFactura = idFactura;
        this.fecha = fecha;
        this.total = total;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}


