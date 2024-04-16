package pe.edu.pucp.tienda.usuario.dao;

import java.util.ArrayList;
import pe.edu.pucp.tienda.usuario.model.ClienteIndividual;

public interface ClienteIndividualDAO {
    
    void inserta(ClienteIndividual cliente);
    
   // ClienteIndividual consultaPorId(int id);
    
    ArrayList<ClienteIndividual> lista();
    
    void actualiza(ClienteIndividual cliente);
    
    void elimina(int id);
}
