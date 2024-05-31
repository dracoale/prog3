/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.tienda.producto.dao;

import java.util.ArrayList;
import pe.edu.pucp.tienda.producto.model.Producto;
import pe.edu.pucp.tienda.producto.model.ProductoPrueba;


/**
 *
 * @author USER
 */
public interface productoPruebaDAO {
        // Create
    public int insertar(ProductoPrueba producto);
    
    // Read
    //public Factura consultarPorId(int id);
    public ArrayList<ProductoPrueba> listar();
    
    public ProductoPrueba seleccionarProductoPrueba(int id);
    
    // Update
    
    
}
