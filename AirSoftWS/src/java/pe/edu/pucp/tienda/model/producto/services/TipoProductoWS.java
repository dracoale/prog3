/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.tienda.model.producto.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.tienda.producto.dao.TipoProductoDAO;
import pe.edu.pucp.tienda.producto.model.TipoProducto;
import pe.edu.pucp.tienda.producto.mysql.TipoProductoMYSQL;

/**
 *
 * @author james
 */
@WebService(serviceName = "TipoProductoWS", targetNamespace = "http://services.usuario.model.tienda.pucp.edu.pe/")
public class TipoProductoWS {
    private TipoProductoDAO tipoproddao;
    /**
     * This is a sample web service operation
     * @param tipoprod
     * @return 
     */
    @WebMethod(operationName = "insertarTipoProducto")
    public int insertarTipoProducto(@WebParam(name = "tipoprod") TipoProducto tipoprod) {
        int resultado = 0;
        try{
            tipoproddao = new TipoProductoMYSQL();
            resultado = tipoproddao.insertar(tipoprod);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    @WebMethod(operationName = "actualizarTipoProducto")
    public int actualizarTipoProducto(@WebParam(name = "tipoprod") TipoProducto tipoprod) {
        int resultado = 0;
        try{
            tipoproddao = new TipoProductoMYSQL();
            resultado = tipoproddao.insertar(tipoprod);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    @WebMethod(operationName = "eliminarTipoProducto")
    public int eliminarTipoProducto(@WebParam(name = "idTipoProducto") int idTipoProducto) {
        int resultado = 0;
        try{
            tipoproddao = new TipoProductoMYSQL();
            resultado = tipoproddao.eliminar(idTipoProducto);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    @WebMethod(operationName = "listarTipoProductos")
    public ArrayList<TipoProducto> listarTipoProductos() {
        ArrayList<TipoProducto> tiposprod = null;
        try{
            tipoproddao = new TipoProductoMYSQL();
            tiposprod = tipoproddao.listar();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return tiposprod;
    }
}
