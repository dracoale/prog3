package pe.edu.pucp.tienda.usuario.dao;

import java.util.ArrayList;
import pe.edu.pucp.tienda.usuario.model.ClienteJuridico;

public interface ClienteJuridicoDAO {
    
    // Método para insertar un nuevo cliente jurídico
    public int insertar(ClienteJuridico cliente);
    // Método para actualizar la información de un cliente jurídico
    public int actualizar(ClienteJuridico cliente,String contra);
    public boolean existeClienteJuridico(ClienteJuridico cliente);
}
