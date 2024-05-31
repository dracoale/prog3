/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.tienda.model.pedido.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.tienda.pedido.dao.detallePedidoDAO;
import pe.edu.pucp.tienda.pedido.model.DetallePedido;
import pe.edu.pucp.tienda.pedido.mysql.detallePedidoMYSQL;
import pe.edu.pucp.tienda.producto.dao.productoDAO;
import pe.edu.pucp.tienda.producto.model.Producto;
import pe.edu.pucp.tienda.producto.mysql.productoMYSQL;

/**
 *
 * @author james
 */
@WebService(serviceName = "DetallePedidoWS", targetNamespace = "http://services.usuario.model.tienda.pucp.edu.pe/")
public class DetallePedidoWS {
    private detallePedidoDAO detallepedidodao;
    private productoDAO productodao;
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "insertarDetallePedido")
    public int insertarDetallePedido(@WebParam(name = "detallepedido") DetallePedido detallepedido) {
        //este insert tiene en cuenta que el detallepedido que se manda posee un Producto
        // el producto del detallePedido mandado solo necesita tener el idProducto para
        //que funcione, el resto de información lo va sacar de la base de datos asi que
        // solo llena el codigo del objeto producto
        int resultado = 0;
        Producto prod = new Producto();
        double precio;
        try{
            productodao = new productoMYSQL();
            prod = productodao.buscarProducto(detallepedido.getProducto().getCodigo());
            precio = prod.getPrecio();
            detallepedido.setSubtotal(precio*detallepedido.getCantidad());
            detallepedidodao = new detallePedidoMYSQL();
            resultado = detallepedidodao.insertar(detallepedido);
            
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    @WebMethod(operationName = "actualizarDetallePedido")
    public int actualizarDetallePedido(@WebParam(name = "detallepedido") DetallePedido detallepedido) {
        int resultado = 0;
        try{
            detallepedidodao = new detallePedidoMYSQL();
            resultado = detallepedidodao.actualizar(detallepedido);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    @WebMethod(operationName = "eliminarDetallePedido")
    public int eliminarDetallePedido(@WebParam(name = "intDetallePedido") int intDetallePedido) {
        int resultado = 0;
        try{
            detallepedidodao = new detallePedidoMYSQL();
            resultado = detallepedidodao.eliminar(intDetallePedido);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    @WebMethod(operationName = "listarDetallesPedidos")
    public ArrayList<DetallePedido> listarDetallesPedidos() {
        ArrayList<DetallePedido> detallespedidos = null;
        try{
            detallepedidodao = new detallePedidoMYSQL();
            detallespedidos = detallepedidodao.listar();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return detallespedidos;
    }
    @WebMethod(operationName = "listarDetallesDePedido")
    public ArrayList<DetallePedido> listarDetallesDePedido(@WebParam(name = "idPedido") int idPedido) {
        ArrayList<DetallePedido> detallespedidos = null;
        try{
            detallepedidodao = new detallePedidoMYSQL();
            detallespedidos = detallepedidodao.listarXPedido(idPedido);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return detallespedidos;
    }
    @WebMethod(operationName = "sumarTotalPedido")
    public double sumarTotalPedido(@WebParam(name = "idPedido") int idPedido) {
        double total=0;
        try{
            detallepedidodao = new detallePedidoMYSQL();
            total = detallepedidodao.sumarDetallesPedido(idPedido);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return total;
    }
}
