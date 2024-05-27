/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.tienda.usuario.dao;

import java.util.ArrayList;
import pe.edu.pucp.tienda.usuario.model.Usuario;

/**
 *
 * @author james
 */
public interface UsuarioDAO {
    public ArrayList<Usuario> ListarUsuariosXNombre(String nombre);
}
