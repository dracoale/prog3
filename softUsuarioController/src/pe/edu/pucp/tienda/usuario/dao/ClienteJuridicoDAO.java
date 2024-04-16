package pe.edu.pucp.tienda.usuario.dao;

import java.util.ArrayList;
import pe.edu.pucp.tienda.usuario.model.ClienteJuridico;

public interface ClienteJuridicoDAO {
    
    // Método para insertar un nuevo cliente jurídico
    public void insertar(ClienteJuridico cliente);
    
    // Método para consultar un cliente jurídico por su ID
   // public ClienteJuridico consultarClienteJuridicoPorId(int id);
    
    // Método para listar todos los clientes jurídicos
    public ArrayList<ClienteJuridico> listar();
    
    // Método para actualizar la información de un cliente jurídico
    public void actualizar(ClienteJuridico cliente);
    
    // Método para eliminar un cliente jurídico por su ID
    public void eliminar(int id);
}
