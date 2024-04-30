package pe.edu.pucp.tienda.usuario.dao;

import java.util.ArrayList;
import pe.edu.pucp.tienda.usuario.model.Administrador;

public interface AdministradorDAO {
    
    // Método para insertar un nuevo administrador
    public int insertar(Administrador administrador);
    
    // Método para consultar un administrador por su ID
//    public Administrador consultarPorId(int id);
    
    // Método para listar todos los administradores
    public ArrayList<Administrador> listar();
    
    // Método para actualizar la información de un administrador
    public int actualizar(Administrador administrador);
    
    // Método para eliminar un administrador por su ID
    public int eliminar(int id);
}
