/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.tienda.model.usuario.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.tienda.usuario.dao.ClienteJuridicoDAO;
import pe.edu.pucp.tienda.usuario.model.ClienteJuridico;
import pe.edu.pucp.tienda.usuario.mysql.ClienteJuridicoMYSQL;

/**
 *
 * @author james
 */
@WebService(serviceName = "ClienteJuridicoWS")
public class ClienteJuridicoWS {
    private ClienteJuridicoDAO clientejuridicodao;
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "insertarClienteJuridico")
    public int insertarClienteJuridico(@WebParam(name = "clientej") ClienteJuridico clientej) {
        int resultado = 0;
        try{
            clientejuridicodao = new ClienteJuridicoMYSQL();
            resultado = clientejuridicodao.insertar(clientej);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    @WebMethod(operationName = "actualizarClienteJuridico")
    public int actualizarClienteJuridico(@WebParam(name = "clientej") ClienteJuridico clientej) {
        int resultado = 0;
        try{
            clientejuridicodao = new ClienteJuridicoMYSQL();
            resultado = clientejuridicodao.actualizar(clientej);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    @WebMethod(operationName = "eliminarClienteJ")
    public int eliminarClienteJ(@WebParam(name = "idClientej") int idClientej) {
        int resultado = 0;
        try{
            clientejuridicodao = new ClienteJuridicoMYSQL();
            resultado = clientejuridicodao.eliminar(idClientej);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    @WebMethod(operationName = "listarClientesJ")
    public ArrayList<ClienteJuridico> listarClientesJ() {
        ArrayList<ClienteJuridico> clientesj = null;
        try{
            clientejuridicodao = new ClienteJuridicoMYSQL();
            clientesj = clientejuridicodao.listar();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return clientesj;
    }
}
