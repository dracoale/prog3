/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.tienda.pedido.dao;

import java.util.ArrayList;
import pe.edu.pucp.tienda.pedido.model.DetallePedido;

/**
 *
 * @author james
 */
public interface detallePedidoDAO {
        // Create
    public int insertar(DetallePedido detallepedido);
    
    // Read
    //public Factura consultarPorId(int id);
    public ArrayList<DetallePedido> listar();
    
    // Update
    public int actualizar(DetallePedido detallepedido);
    
    // Delete
    public int eliminar(int id);
}
