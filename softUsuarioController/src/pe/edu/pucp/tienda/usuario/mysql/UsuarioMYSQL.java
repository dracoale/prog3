/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.tienda.usuario.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.tienda.config.DBManager;
import pe.edu.pucp.tienda.usuario.dao.UsuarioDAO;
import pe.edu.pucp.tienda.usuario.model.ClienteIndividual;
import pe.edu.pucp.tienda.usuario.model.ClienteJuridico;
import pe.edu.pucp.tienda.usuario.model.EstadoCuenta;
import pe.edu.pucp.tienda.usuario.model.TipoUsuario;
import pe.edu.pucp.tienda.usuario.model.Usuario;

/**
 *
 * @author james
 */
public class UsuarioMYSQL implements UsuarioDAO {
    private Connection con;
    private CallableStatement cs;
    private ResultSet rs;

    @Override
    public ArrayList<Usuario> ListarUsuariosXNombre(String nombre) {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call ListarUsuariosXNombre"
                    + "(?)}"); 	
            cs.setString("_nombre", nombre);
            rs=cs.executeQuery();
            
            while(rs.next()){
                Usuario usuario=new Usuario();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setNombre(rs.getString("NombreCompleto"));
                usuario.setTelefono(rs.getString("telefono"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setEstadocuenta(EstadoCuenta.valueOf(rs.getString("estadoCuenta")));
                usuario.setNombreUsuario(rs.getString("nombreUsuario"));
                
                usuarios.add(usuario);
            }
                
        }catch(SQLException ex){
                System.out.println(ex.getMessage());
        }finally{
                try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return usuarios;
    }

    @Override
    public Usuario LoginUsuario(String usuario,String contra) {
        Usuario user= new Usuario();
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LoginUsuario"
                    + "(?,?)}"); 	
            cs.setString("_usuario", usuario);
            cs.setString("_contra", contra);
            rs=cs.executeQuery();
            if(rs.next()){
                user.setIdUsuario(rs.getInt("idUsuario"));
                user.setNombre(rs.getString("NombreCompleto"));
                user.setNombreUsuario(rs.getString("nombreUsuario"));
                user.setTelefono(rs.getString("telefono"));
                user.setCorreo(rs.getString("correo"));
                user.setEstadocuenta(EstadoCuenta.valueOf(rs.getString("estadoCuenta")));
                user.setTipoUsuario(TipoUsuario.valueOf(rs.getString("tipoUsuario")));
                user.setContraseña(rs.getString("contrasena"));
            }else{
                user.setIdUsuario(0);
            }
                
        }catch(SQLException ex){
                System.out.println(ex.getMessage());
        }finally{
                try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
                try{rs.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return user;
    }
    @Override
    public int ActualizaUsuarioPersona(Usuario usuario) {
       int resultado=0;
        try{    
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call ActualizaUsuarioPersona"
                + "(?,?,?,?,?,?,?,?,?,?)}"); 	
            cs.setInt("p_idUsuario", usuario.getIdUsuario());
            cs.setString("p_nombre",usuario.getNombre());
            cs.setString("p_genero", String.valueOf(usuario.getGenero()));
            cs.setString("p_telefono", usuario.getTelefono());
            cs.setString("p_correo", usuario.getCorreo());
            cs.setDate("p_fechaNacimiento", new java.sql.Date(usuario.getFechaNacimiento().getTime()));
            cs.setString("p_nombreUsuario", usuario.getNombreUsuario());
            cs.setString("p_contrasena", usuario.getContraseña());
            cs.setString("p_apellidoPaterno", usuario.getApellidoPaterno());
            cs.setString("p_apellidoMaterno", usuario.getApellidoMaterno());
            resultado=cs.executeUpdate();
        }catch(SQLException ex){
                System.out.println(ex.getMessage());
        }finally{
                try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }    
        return resultado;
    }    
    @Override
    public ArrayList<Usuario> ListaUsuarioXTipo(String tipo) {
       ArrayList<Usuario> usuarios = new ArrayList<>();
       
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call ListaUsuarioXTipo"+
                    "(?)}"); 	
            cs.setString("tipo", tipo);
            rs=cs.executeQuery();
            while(rs.next()){
                if(tipo.equalsIgnoreCase("USER_JURIDICO")){
                    ClienteJuridico usuarioJuridico=new ClienteJuridico();
                    usuarioJuridico.setNombre(rs.getString("nombre"));
                    usuarioJuridico.setTelefono(rs.getString("telefono"));
                    usuarioJuridico.setCorreo(rs.getString("correo"));
                    usuarioJuridico.setFechaRegistro(rs.getDate("fechaRegistro"));
                    usuarioJuridico.setEstadocuenta(EstadoCuenta.valueOf(rs.getString("EstadoCuenta")));
                    usuarioJuridico.setFechaNacimiento(rs.getDate("fechaNacimiento"));
                    usuarioJuridico.setNombreUsuario(rs.getString("nombreUsuario"));
                    usuarioJuridico.setApellidoPaterno(rs.getString("apellidoPaterno"));
                    usuarioJuridico.setApellidoMaterno(rs.getString("apellidoMaterno"));
                    usuarioJuridico.setRUC(rs.getString("RUC"));
                    usuarioJuridico.setNombreEmpresa(rs.getString("nombreEmpresa"));

                    usuarios.add(usuarioJuridico);
                }else if(tipo.equalsIgnoreCase("USER_NATURAL")){
                    ClienteIndividual usuarioIndividual=new ClienteIndividual();
                    usuarioIndividual.setNombre(rs.getString("nombre"));
                    usuarioIndividual.setTelefono(rs.getString("telefono"));
                    usuarioIndividual.setCorreo(rs.getString("correo"));
                    usuarioIndividual.setFechaRegistro(rs.getDate("fechaRegistro"));
                    usuarioIndividual.setEstadocuenta(EstadoCuenta.valueOf(rs.getString("EstadoCuenta")));
                    usuarioIndividual.setFechaNacimiento(rs.getDate("fechaNacimiento"));
                    usuarioIndividual.setNombreUsuario(rs.getString("nombreUsuario"));
                    usuarioIndividual.setApellidoPaterno(rs.getString("apellidoPaterno"));
                    usuarioIndividual.setApellidoMaterno(rs.getString("apellidoMaterno"));
                    usuarioIndividual.setDNI(rs.getString("DNI"));

                    usuarios.add(usuarioIndividual);
                }else{
                    Usuario user=new Usuario();
                    user.setNombre(rs.getString("nombre"));
                    user.setTelefono(rs.getString("telefono"));
                    user.setCorreo(rs.getString("correo"));
                    user.setFechaRegistro(rs.getDate("fechaRegistro"));
                    user.setEstadocuenta(EstadoCuenta.valueOf(rs.getString("EstadoCuenta")));
                    user.setFechaNacimiento(rs.getDate("fechaNacimiento"));
                    user.setNombreUsuario(rs.getString("nombreUsuario"));
                    user.setApellidoPaterno(rs.getString("apellidoPaterno"));
                    user.setApellidoMaterno(rs.getString("apellidoMaterno"));
                    usuarios.add(user);
                }
            }
                
        }catch(SQLException ex){
                System.out.println(ex.getMessage());
        }finally{
                try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return usuarios;
    }
    @Override
    public int eliminarUsuario(int id) {
        int resultado=0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call EliminaUsuario"
                + "(?)}"); 
            cs.setInt("p_idUsuario", id);
            cs.executeUpdate();
            resultado=id;

        }catch(SQLException ex){
                System.out.println(ex.getMessage());
        }finally{
                try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int InsertarAdmin(Usuario usuario) {
        int resultado=0;
        try{    
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call InsertaAdministrador"
                + "(?,?,?,?,?,?,?,?,?,?)}"); 	
            cs.registerOutParameter("p_idUsuario", java.sql.Types.INTEGER);
            cs.setString("p_nombre",usuario.getNombre());
            cs.setString("p_genero", String.valueOf(usuario.getGenero()));
            cs.setString("p_telefono", usuario.getTelefono());
            cs.setString("p_correo", usuario.getCorreo());
            cs.setDate("p_fechaNacimiento", new java.sql.Date(usuario.getFechaNacimiento().getTime()));
            cs.setString("p_nombreUsuario", usuario.getNombreUsuario());
            cs.setString("p_contrasena", usuario.getContraseña());
            cs.setString("p_apellidoPaterno", usuario.getApellidoPaterno());
            cs.setString("p_apellidoMaterno", usuario.getApellidoMaterno());
            cs.executeQuery();
            usuario.setIdUsuario(cs.getInt("p_idUsuario"));
            
            resultado=usuario.getIdUsuario();
        }catch(SQLException ex){
                System.out.println(ex.getMessage());
        }finally{
                try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }    
        return resultado;
    }
    
}
