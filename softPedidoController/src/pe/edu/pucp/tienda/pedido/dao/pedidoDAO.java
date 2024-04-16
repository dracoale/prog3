/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.tienda.pedido.dao;

import java.util.ArrayList;
import pe.edu.pucp.tienda.pedido.model.Pedido;


/**
 *
 * @author USER
 */
public interface pedidoDAO {
        // Create
    public void insertar(Pedido pedido);
    
    // Read
    //public Factura consultarPorId(int id);
    public ArrayList<Pedido> listar();
    
    // Update
    public void actualizar(Pedido pedido);
    
    // Delete
    public void eliminar(int id);
    
}
