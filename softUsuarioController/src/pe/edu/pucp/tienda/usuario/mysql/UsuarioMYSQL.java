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
import pe.edu.pucp.tienda.usuario.model.EstadoCuenta;
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
    
}
