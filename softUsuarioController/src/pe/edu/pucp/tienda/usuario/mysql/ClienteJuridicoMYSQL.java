/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.tienda.usuario.mysql;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.tienda.usuario.dao.ClienteJuridicoDAO;
import pe.edu.pucp.tienda.usuario.model.ClienteJuridico;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import pe.edu.pucp.tienda.config.DBManager;
import pe.edu.pucp.tienda.usuario.model.EstadoCuenta;

public class ClienteJuridicoMYSQL implements ClienteJuridicoDAO{
	private Connection con;
	private CallableStatement cs;
        private ResultSet rs;

    @Override
    public int insertar(ClienteJuridico cliente) {
        int resultado=0;
        try{    
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call InsertaUsuarioJuridico"
                + "(?,?,?,?,?,?,?,?,?,?,?,?)}"); 	
            cs.registerOutParameter("p_idUsuario", java.sql.Types.INTEGER);
            cs.setString("p_nombre",cliente.getNombre());
            cs.setString("p_telefono", cliente.getTelefono());
            cs.setString("p_correo", cliente.getCorreo());
            cs.setDate("p_fechaRegistro",new java.sql.Date(cliente.getFechaRegistro().getTime()));
            cs.setDate("p_fechaCreacion", new java.sql.Date(cliente.getFechaCreacion().getTime()));
            cs.setString("p_nombreUsuario", cliente.getNombreUsuario());
            cs.setString("p_contrasena", cliente.getContraseña());
            cs.setString("p_apellidoPaterno", cliente.getApellidoPaterno());
            cs.setString("p_apellidoMaterno", cliente.getApellidoMaterno());
            cs.setString("p_RUC", cliente.getRUC());
            cs.setString("p_nombreEmpresa", cliente.getNombreEmpresa());
            cs.executeQuery();
            cliente.setIdUsuario(cs.getInt("p_idUsuario"));
            resultado=cliente.getIdUsuario();
        }catch(SQLException ex){
                System.out.println(ex.getMessage());
        }finally{
                try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }    
        return resultado;
    }


    @Override
    public ArrayList<ClienteJuridico> listar() {
       ArrayList<ClienteJuridico> clientesJud = new ArrayList<>();
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call ListaUsuariosJuridicos()}"); 	
            rs=cs.executeQuery();
            
            while(rs.next()){
                ClienteJuridico clienteJud=new ClienteJuridico();
                clienteJud.setNombre(rs.getString("nombre"));
                clienteJud.setTelefono(rs.getString("telefono"));
                clienteJud.setCorreo(rs.getString("correo"));
                clienteJud.setFechaRegistro(rs.getDate("fechaRegistro"));
                clienteJud.setEstadocuenta(EstadoCuenta.valueOf(rs.getString("EstadoCuenta")));
                clienteJud.setFechaCreacion(rs.getDate("fechaCreacion"));
                clienteJud.setNombreUsuario(rs.getString("nombreUsuario"));
                clienteJud.setApellidoPaterno(rs.getString("apellidoPaterno"));
                clienteJud.setApellidoMaterno(rs.getString("apellidoMaterno"));
                
                clientesJud.add(clienteJud);
            }
                
        }catch(SQLException ex){
                System.out.println(ex.getMessage());
        }finally{
                try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return clientesJud;
    }

    @Override
    public int actualizar(ClienteJuridico cliente) {
        int resultado=0;
        try{    
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call ActualizaUsuarioJuridico"
                + "(?,?,?,?,?,?,?,?)}"); 	
            cs.setInt("p_idUsuario", cliente.getIdUsuario());
            cs.setString("p_nombre",cliente.getNombre());
            cs.setString("p_telefono", cliente.getTelefono());
            cs.setString("p_correo", cliente.getCorreo());
            cs.setString("p_nombreUsuario", cliente.getNombreUsuario());
            cs.setString("p_contrasena", cliente.getContraseña());
            cs.setString("p_apellidoPaterno", cliente.getApellidoPaterno());
            cs.setString("p_apellidoMaterno", cliente.getApellidoMaterno());
            cs.executeUpdate();
            resultado=cliente.getIdUsuario();
        }catch(SQLException ex){
                System.out.println(ex.getMessage());
        }finally{
                try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }    
        return resultado;
    }

    @Override
    public int eliminar(int id) {
        int resultado=0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call EliminaUsuarioJuridico"
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

}
