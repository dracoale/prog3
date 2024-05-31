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
            cs.setString("p_genero", String.valueOf(cliente.getGenero()));
            cs.setString("p_telefono", cliente.getTelefono());
            cs.setString("p_correo", cliente.getCorreo());
            cs.setDate("p_fechaNacimiento", new java.sql.Date(cliente.getFechaNacimiento().getTime()));
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

}
