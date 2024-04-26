/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.tienda.producto.dao;


import java.util.ArrayList;
import pe.edu.pucp.tienda.producto.model.TipoProducto;
/**
 *
 * @author alexis
 */
public interface TipoProductoDAO {
    int insertar(TipoProducto tipoProducto);
    ArrayList<TipoProducto> listar();
    int eliminar(int id);
    int actualizar(TipoProducto tipoProducto);
    
}
