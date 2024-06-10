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
    public int InsertarAdmin(Usuario usuario);
    public Usuario LoginUsuario(String usuario,String contra);
    public int ActualizaUsuarioPersona(Usuario usuario,String contra);
    public ArrayList<Usuario> ListaUsuarioXTipo(String tipo);
    public int eliminarUsuario(int id);
    public boolean existeUsuarioAdmin(Usuario user);
    public ArrayList<Usuario> mostrarUsuariosAAdmin();
    public Usuario BuscarUsuarioXId(int idUsuario);
    public int activarUsuario(int idUsuario);
    public int suspenderUsuario(int idUsuario);
}
