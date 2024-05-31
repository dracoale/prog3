/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.tienda.model.usuario.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.tienda.usuario.dao.ClienteIndividualDAO;
import pe.edu.pucp.tienda.usuario.model.ClienteIndividual;
import pe.edu.pucp.tienda.usuario.mysql.ClienteIndividualMYSQL;

/**
 *
 * @author james
 */
@WebService(serviceName = "ClienteIndividualWS")
public class ClienteIndividualWS {
    private ClienteIndividualDAO clienteindividualdao;
    /**
     * This is a sample web service operation
     * @param clientei
     * @return 
     */
    @WebMethod(operationName = "insertarClienteIndividual")
    public int insertarClienteIndividual(@WebParam(name = "clientei") ClienteIndividual clientei) {
        int resultado = 0;
        try{
            clienteindividualdao = new ClienteIndividualMYSQL();
            resultado = clienteindividualdao.inserta(clientei);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
}
