package pe.edu.pucp.tienda.usuario.dao;

import java.util.ArrayList;
import pe.edu.pucp.tienda.usuario.model.ClienteIndividual;

public interface ClienteIndividualDAO {
    
    public int inserta(ClienteIndividual cliente);
    public boolean existeClienteIndividual(ClienteIndividual cliente);
}
