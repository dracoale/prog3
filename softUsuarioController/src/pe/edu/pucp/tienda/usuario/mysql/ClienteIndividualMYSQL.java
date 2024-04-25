/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.tienda.usuario.mysql;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.tienda.config.DBManager;
import pe.edu.pucp.tienda.usuario.dao.ClienteIndividualDAO;
import pe.edu.pucp.tienda.usuario.dao.ClienteJuridicoDAO;
import pe.edu.pucp.tienda.usuario.model.ClienteIndividual;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Connection;
//import java.util.Exception;


public class ClienteIndividualMYSQL implements ClienteIndividualDAO{
	private Connection con;
	private CallableStatement cs;

    @Override
    public int inserta(ClienteIndividual cliente) {
        try{
			con = DBManager.getInstance().getConnection();
			cs = con.prepareCall("{call INSERTAR_CLIENTE_INDIVIDUAL"
                    + "(?,?,?,?,?,?,?,?,?)}"); 	
			
		}catch(SQLException ex){
			System.out.println(ex.getMessage());
		}finally{
			try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
		} 
        return 1;
    }

//    @Override
//    public ClienteIndividual consultaPorId(int id) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }

    @Override
    public ArrayList<ClienteIndividual> lista() {
       ArrayList<ClienteIndividual> clientesInd = new ArrayList<>();
		try{
			con = DBManager.getInstance().getConnection();
			cs = con.prepareCall("{call LISTAR_CLIENTES_INDIVIDUALES"
                    + "(?,?,?,?,?,?,?,?,?)}"); 	
			
		}catch(SQLException ex){
			System.out.println(ex.getMessage());
		}finally{
			try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
		}
		return clientesInd;
    }

    @Override
    public int actualiza(ClienteIndividual cliente) {
        try{
			con = DBManager.getInstance().getConnection();
			cs = con.prepareCall("{call ACTUALIZAR_CLIENTE_INDIVIDUAL"
                    + "(?,?,?,?,?,?,?,?,?)}"); 
			
		}catch(SQLException ex){
			System.out.println(ex.getMessage());
		}finally{
			try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
		}
        return 1;
    }

    @Override
    public int elimina(int id) {
        try{
			con = DBManager.getInstance().getConnection();
			cs = con.prepareCall("{call ELIMINAR_CLIENTE_INDIVIDUAL"
                    + "(?,?,?,?,?,?,?,?,?)}"); 
			
		}catch(SQLException ex){
			System.out.println(ex.getMessage());
		}finally{
			try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
		}
        return 1;
    }
    

}
