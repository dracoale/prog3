/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.tienda.model.producto.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.tienda.producto.dao.productoDAO;
import pe.edu.pucp.tienda.producto.model.Producto;
import pe.edu.pucp.tienda.producto.mysql.productoMYSQL;
/**
 *
 * @author james
 */
@WebService(serviceName = "ProductoWS")
public class ProductoWS {
    private productoDAO productodao;
    /**
     * This is a sample web service operation
     * @param producto
     * @return 
     */
    @WebMethod(operationName = "insertarProducto")
    public int insertarProducto(@WebParam(name = "producto") Producto producto) {
        int resultado = 0;
        try{
            productodao = new productoMYSQL();
            resultado = productodao.insertar(producto);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    @WebMethod(operationName = "actualizarProducto")
    public int actualizarProducto(@WebParam(name = "producto") Producto producto) {
        int resultado = 0;
        try{
            productodao = new productoMYSQL();
            resultado = productodao.actualizar(producto);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    @WebMethod(operationName = "eliminarProducto")
    public int eliminarProducto(@WebParam(name = "idProducto") int idProducto) {
        int resultado = 0;
        try{
            productodao = new productoMYSQL();
            resultado = productodao.eliminar(idProducto);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    @WebMethod(operationName = "listarProductos")
    public ArrayList<Producto> listarProductos() {
        ArrayList<Producto> productos = null;
        try{
            productodao = new productoMYSQL();
            productos = productodao.listar();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return productos;
    }
    @WebMethod(operationName = "buscarProducto")
    public ArrayList<Producto> buscarProducto(@WebParam(name = "nombre") String nombre) {
        ArrayList<Producto> productos = null;
        try{
            productodao = new productoMYSQL();
            productos = productodao.listarXNombre(nombre);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return productos;
    }
    @WebMethod(operationName = "buscarProductoXTipo")
    public ArrayList<Producto> buscarProductoXTipo(@WebParam(name = "idTipo") int idTipo) {
        ArrayList<Producto> productos = null;
        try{
            productodao = new productoMYSQL();
            productos = productodao.listarXTipo(idTipo);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return productos;
    }
    @WebMethod(operationName = "buscarPrecioProducto")
    public double buscarPrecioProducto(@WebParam(name = "idProducto") int idProducto) {
        Producto prod = new Producto();
        try{
            productodao = new productoMYSQL();
            prod = productodao.buscarProducto(idProducto);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return prod.getPrecio();
    }
}
