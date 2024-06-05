/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.tienda.producto.dao;

import java.util.ArrayList;
import pe.edu.pucp.tienda.producto.model.Almacen;

/**
 *
 * @author james
 */
public interface AlmacenDAO {
    public int insertar(Almacen almacen);
    
    // Read
    //public Factura consultarPorId(int id);
    public ArrayList<Almacen> listar();
    
    
    // Update
    public int actualizar(Almacen almacen);
    
    // Delete
    public int eliminar(int id);
}
