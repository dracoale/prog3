/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.tienda.factura.dao;

import java.util.ArrayList;
import pe.edu.pucp.tienda.factura.model.Factura;

/**
 *
 * @author USER
 */
public interface facturaDAO {
        // Create
    public int insertar(Factura factura);
    
    // Read
    //public Factura consultarPorId(int id);
    public ArrayList<Factura> listar();
    
    // Update
    public int actualizar(Factura factura);
    
    // Delete
    public int eliminar(int id);
    
    public Factura buscarFacturaXPedido(int idPedido);
    public Factura buscarFactura(int idFactura);
    
}
