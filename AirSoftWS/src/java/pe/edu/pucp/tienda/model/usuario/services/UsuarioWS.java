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
    @WebMethod(operationName = "insertarAdmin")
    public int insertarAdmin(@WebParam(name = "admin") Usuario admin) {
        int resultado = 0;
        try{
            usuariodao = new UsuarioMYSQL();
            if(usuariodao.existeUsuarioAdmin(admin)) return -1;
            resultado = usuariodao.InsertarAdmin(admin);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    @WebMethod(operationName = "ActualizaUsuarioPersona")
    public int ActualizaUsuarioPersona(@WebParam(name = "usuario") Usuario usuario,String contra) {
        int resultado = 0;
        try{
            usuariodao = new UsuarioMYSQL();
            resultado = usuariodao.ActualizaUsuarioPersona(usuario,contra);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    @WebMethod(operationName = "ListaUsuarioXTipo")
    public ArrayList<Usuario> ListaUsuarioXTipo(@WebParam(name = "tipo") String tipo) {
        ArrayList<Usuario> usuarios = null;
        try{
            usuariodao = new UsuarioMYSQL();
            usuarios = usuariodao.ListaUsuarioXTipo(tipo);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return usuarios;
    }
    @WebMethod(operationName = "eliminaUsuario")
    public int eliminaUsuario(@WebParam(name = "idUsuario") int idUsuario) {
        int resultado = 0;
        try{
            usuariodao = new UsuarioMYSQL();
            resultado = usuariodao.eliminarUsuario(idUsuario);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    @WebMethod(operationName = "mostarUsuariosAAdmin")
    public ArrayList<Usuario> mostarUsuariosAAdmin() {
        ArrayList<Usuario> usuarios = null;
        try{
            usuariodao = new UsuarioMYSQL();
            usuarios = usuariodao.mostrarUsuariosAAdmin();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return usuarios;
    }
    @WebMethod(operationName = "BuscarUsuarioXId")
    public Usuario BuscarUsuarioXId(@WebParam(name = "idUsuario") int idUsuario) {
        Usuario user = new Usuario();
        try{
            usuariodao = new UsuarioMYSQL();
            user = usuariodao.BuscarUsuarioXId(idUsuario);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return user;
    }
}
