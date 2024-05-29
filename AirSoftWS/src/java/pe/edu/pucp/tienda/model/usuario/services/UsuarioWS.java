/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.tienda.model.usuario.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.tienda.usuario.dao.UsuarioDAO;
import pe.edu.pucp.tienda.usuario.model.Usuario;
import pe.edu.pucp.tienda.usuario.mysql.UsuarioMYSQL;

/**
 *
 * @author james
 */
@WebService(serviceName = "UsuarioWS")
public class UsuarioWS {
    private UsuarioDAO usuariodao;
    /**
     * This is a sample web service operation
     * @param nombre
     * @return 
     */
    @WebMethod(operationName = "buscarUsuario")
    public ArrayList<Usuario> buscarUsuario(@WebParam(name = "nombre") String nombre) {
        ArrayList<Usuario> usuarios = null;
        try{
            usuariodao = new UsuarioMYSQL();
            usuarios = usuariodao.ListarUsuariosXNombre(nombre);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return usuarios;
    }
    @WebMethod(operationName = "loginUsuario")
    public Usuario loginUsuario(@WebParam(name = "usuario") String usuario,
            @WebParam(name = "contraseña") String contraseña) {
        Usuario user = new Usuario();
        try{
            usuariodao = new UsuarioMYSQL();
            user = usuariodao.LoginUsuario(usuario,contraseña);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return user;
    }
}
