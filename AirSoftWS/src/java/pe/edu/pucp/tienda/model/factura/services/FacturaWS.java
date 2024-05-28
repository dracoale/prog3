/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.tienda.model.factura.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.tienda.factura.dao.facturaDAO;
import pe.edu.pucp.tienda.factura.model.Factura;
import pe.edu.pucp.tienda.factura.mysql.facturaMYSQL;

/**
 *
 * @author james
 */
@WebService(serviceName = "FacturaWS")
public class FacturaWS {
    private facturaDAO facturadao;
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "insertarFactura")
    public int insertarFactura(@WebParam(name = "factura") Factura factura) {
        int resultado = 0;
        try{
            facturadao = new facturaMYSQL();
            resultado = facturadao.insertar(factura);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    @WebMethod(operationName = "actualizarFactura")
    public int actualizarFactura(@WebParam(name = "factura") Factura factura) {
        int resultado = 0;
        try{
            facturadao = new facturaMYSQL();
            resultado = facturadao.actualizar(factura);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    @WebMethod(operationName = "eliminarFactura")
    public int eliminarFactura(@WebParam(name = "idFactura") int idFactura) {
        int resultado = 0;
        try{
            facturadao = new facturaMYSQL();
            resultado = facturadao.eliminar(idFactura);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    @WebMethod(operationName = "listarFacturas")
    public ArrayList<Factura> listarFacturas() {
        ArrayList<Factura> facturas = null;
        try{
            facturadao = new facturaMYSQL();
            facturas = facturadao.listar();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return facturas;
    }
}
