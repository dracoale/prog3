/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.tienda.model.producto.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.tienda.producto.dao.AlmacenDAO;
import pe.edu.pucp.tienda.producto.model.Almacen;
import pe.edu.pucp.tienda.producto.mysql.AlmacenMYSQL;

/**
 *
 * @author james
 */
@WebService(serviceName = "AlmacenWS", targetNamespace = "http://services.usuario.model.tienda.pucp.edu.pe/")
public class AlmacenWS {
    private AlmacenDAO almacendao;
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "insertaAlmacen")
    public int insertaAlmacen(@WebParam(name = "almacen") Almacen almacen) {
        int resultado = 0;
        try{
            almacendao = new AlmacenMYSQL();
            resultado = almacendao.insertar(almacen);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    @WebMethod(operationName = "actualizaAlmacen")
    public int actualizaAlmacen(@WebParam(name = "almacen") Almacen almacen) {
        int resultado = 0;
        try{
            almacendao = new AlmacenMYSQL();
            resultado = almacendao.actualizar(almacen);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    @WebMethod(operationName = "eliminaAlmacen")
    public int eliminaAlmacen(@WebParam(name = "idAlmacen") int idAlmacen) {
        int resultado = 0;
        try{
            almacendao = new AlmacenMYSQL();
            resultado = almacendao.eliminar(idAlmacen);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    @WebMethod(operationName = "listarAlmacenes")
    public ArrayList<Almacen> listarAlmacenes() {
        ArrayList<Almacen> almacenes = null;
        try{
            almacendao = new AlmacenMYSQL();
            almacenes = almacendao.listar();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return almacenes;
    }
}
