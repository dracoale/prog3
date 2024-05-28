/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.tienda.producto.dao;

import java.util.ArrayList;
import pe.edu.pucp.tienda.producto.model.Producto;


/**
 *
 * @author USER
 */
public interface productoDAO {
        // Create
    public int insertar(Producto producto);
    
    // Read
    //public Factura consultarPorId(int id);
    public ArrayList<Producto> listar();
    
    
    // Update
    public int actualizar(Producto producto);
    
    // Delete
    public int eliminar(int id);
    
    public ArrayList<Producto> listarXTipo(int idTipo);
    
    public ArrayList<Producto> listarXNombre(String nombre);
    
}
