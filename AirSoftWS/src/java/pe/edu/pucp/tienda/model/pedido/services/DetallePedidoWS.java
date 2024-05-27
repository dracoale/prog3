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

/**
 *
 * @author james
 */
@WebService(serviceName = "DetallePedidoWS")
public class DetallePedidoWS {
    private detallePedidoDAO detallepedidodao;
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "insertarDetallePedido")
    public int insertarDetallePedido(@WebParam(name = "detallepedido") DetallePedido detallepedido) {
        int resultado = 0;
        try{
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
}
