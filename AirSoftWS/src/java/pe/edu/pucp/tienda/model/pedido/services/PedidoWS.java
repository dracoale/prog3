/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.tienda.model.pedido.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.tienda.pedido.dao.pedidoDAO;
import pe.edu.pucp.tienda.pedido.model.Pedido;
import pe.edu.pucp.tienda.pedido.mysql.pedidoMYSQL;

/**
 *
 * @author james
 */
@WebService(serviceName = "PedidoWS")
public class PedidoWS {
    private pedidoDAO pedidodao;
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "insertarPedido")
    public int insertarPedido(@WebParam(name = "pedido") Pedido pedido) {
        int resultado = 0;
        try{
            pedidodao = new pedidoMYSQL();
            resultado = pedidodao.insertar(pedido);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    @WebMethod(operationName = "actualizarPedido")
    public int actualizarPedido(@WebParam(name = "pedido") Pedido pedido) {
        int resultado = 0;
        try{
            pedidodao = new pedidoMYSQL();
            resultado = pedidodao.actualizar(pedido);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    @WebMethod(operationName = "eliminarPedido")
    public int eliminarPedido(@WebParam(name = "intPedido") int intPedido) {
        int resultado = 0;
        try{
            pedidodao = new pedidoMYSQL();
            resultado = pedidodao.eliminar(intPedido);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    @WebMethod(operationName = "listarPedidos")
    public ArrayList<Pedido> listarPedidos() {
        ArrayList<Pedido> pedidos = null;
        try{
            pedidodao = new pedidoMYSQL();
            pedidos = pedidodao.listar();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return pedidos;
    }
}
