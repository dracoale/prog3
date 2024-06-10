package pe.edu.pucp.tienda.producto.dao;
import java.util.ArrayList;
import pe.edu.pucp.tienda.producto.model.Oferta;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author alexis
 */
public interface OfertaDAO {
    int insertar(Oferta oferta);
    ArrayList<Oferta> listar();
    int eliminar(int id);
    int actualizar(Oferta oferta);
    double buscarOferta(int idProducto);
    Oferta buscarOfertaXId(int idOferta);
}
