package pe.edu.pucp.tienda.usuario.dao;

import java.util.ArrayList;
import pe.edu.pucp.tienda.usuario.model.ClienteIndividual;

public interface ClienteIndividualDAO {
    
    int inserta(ClienteIndividual cliente);
    
   // ClienteIndividual consultaPorId(int id);
    
    ArrayList<ClienteIndividual> lista();
    
    int actualiza(ClienteIndividual cliente);
    
    int elimina(int id);
}
