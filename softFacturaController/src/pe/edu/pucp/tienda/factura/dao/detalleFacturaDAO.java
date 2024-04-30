/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.tienda.factura.dao;

import java.util.ArrayList;
import pe.edu.pucp.tienda.factura.model.DetalleFactura;

/**
 *
 * @author james
 */
public interface detalleFacturaDAO {
    public void insertar(DetalleFactura detallefactura);
    
    // Read
    //public Factura consultarPorId(int id);
    public ArrayList<DetalleFactura> listar();
    
    // Update
    public void actualizar(DetalleFactura detallefactura);
    
    // Delete
    public void eliminar(int id);
}
