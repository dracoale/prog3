/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.tienda.factura.dao;

import java.util.ArrayList;
import pe.edu.pucp.tienda.factura.model.FormaDePago;

/**
 *
 * @author james
 */
public interface formaDePagoDAO {
    public void insertar(FormaDePago formaDePago);
    
    // Read
    //public Factura consultarPorId(int id);
    public ArrayList<FormaDePago> listar();
    
    // Update
    public void actualizar(FormaDePago formaDePago);
    
    // Delete
    public void eliminar(int id);
}
