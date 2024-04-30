/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.tienda.usuario.mysql;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.tienda.config.DBManager;
import pe.edu.pucp.tienda.usuario.dao.ClienteIndividualDAO;
import pe.edu.pucp.tienda.usuario.model.ClienteIndividual;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import pe.edu.pucp.tienda.usuario.model.EstadoCuenta;
import pe.edu.pucp.tienda.usuario.model.TipoUsuario;
//import java.util.Exception;


public class ClienteIndividualMYSQL implements ClienteIndividualDAO{
	private Connection con;
	private CallableStatement cs;
        private ResultSet rs;

    @Override
    public int inserta(ClienteIndividual cliente) {
        int resultado=0;
        try{    
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call InsertaUsuarioNatural"
                + "(?,?,?,?,?,?,?,?,?,?,?)}"); 	
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
            cs.setString("p_DNI", cliente.getDNI());
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

//    @Override
//    public ClienteIndividual consultaPorId(int id) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }

    @Override
    public ArrayList<ClienteIndividual> lista() {
       ArrayList<ClienteIndividual> clientesJud = new ArrayList<>();
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call ListaUsuariosNaturales()}"); 	
            rs=cs.executeQuery();
            
            while(rs.next()){
                ClienteIndividual clientInd=new ClienteIndividual();
                clientInd.setNombre(rs.getString("nombre"));
                clientInd.setTelefono(rs.getString("telefono"));
                clientInd.setCorreo(rs.getString("correo"));
                clientInd.setFechaRegistro(rs.getDate("fechaRegistro"));
                clientInd.setEstadocuenta(EstadoCuenta.valueOf(rs.getString("EstadoCuenta")));
                clientInd.setTipoUsuario(TipoUsuario.valueOf(rs.getString("tipoUsuario")));
                clientInd.setFechaCreacion(rs.getDate("fechaCreacion"));
                clientInd.setNombreUsuario(rs.getString("nombreUsuario"));
                clientInd.setApellidoPaterno(rs.getString("apellidoPaterno"));
                clientInd.setApellidoMaterno(rs.getString("apellidoMaterno"));
                
                clientesJud.add(clientInd);
            }
                
        }catch(SQLException ex){
                System.out.println(ex.getMessage());
        }finally{
                try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return clientesJud;
    }

    @Override
    public int actualiza(ClienteIndividual cliente) {
       int resultado=0;
        try{    
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call ActualizaUsuarioNatural"
                + "(?,?,?,?,?,?,?,?)}"); 	
            cs.setInt("p_idUsuario", cliente.getIdUsuario());
            cs.setString("p_nombre",cliente.getNombre());
            cs.setString("p_telefono", cliente.getTelefono());
            cs.setString("p_correo", cliente.getCorreo());
            cs.setString("p_nombreUsuario", cliente.getNombreUsuario());
            cs.setString("p_contrasena", cliente.getContraseña());
            cs.setString("p_apellidoPaterno", cliente.getApellidoPaterno());
            cs.setString("p_apellidoMaterno", cliente.getApellidoMaterno());
            resultado=cs.executeUpdate();
        }catch(SQLException ex){
                System.out.println(ex.getMessage());
        }finally{
                try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }    
        return resultado;
    }

    @Override
    public int elimina(int id) {
        int resultado=0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call EliminaUsuarioNatural"
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
