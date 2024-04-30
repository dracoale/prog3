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
import pe.edu.pucp.tienda.config.DBManager;

public class ClienteJuridicoMYSQL implements ClienteJuridicoDAO{
	private Connection con;
	private CallableStatement cs;


    @Override
    public int insertar(ClienteJuridico cliente) {
        try{
			con = DBManager.getInstance().getConnection();
			cs = con.prepareCall("{call INSERTAR_CLIENTE_JURIDICO"
                    + "(?,?,?,?,?,?,?,?,?)}"); 	
			
		}catch(SQLException ex){
			System.out.println(ex.getMessage());
		}finally{
			try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
		}    
        return 1;
    }


    @Override
    public ArrayList<ClienteJuridico> listar() {
       ArrayList<ClienteJuridico> clientesJud = new ArrayList<>();
		try{
			con = DBManager.getInstance().getConnection();
			cs = con.prepareCall("{call LISTAR_CLIENTES_JURIDICOS"
                    + "(?,?,?,?,?,?,?,?,?)}"); 	
			
		}catch(SQLException ex){
			System.out.println(ex.getMessage());
		}finally{
			try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
		}
		return clientesJud;
    }

    @Override
    public int actualizar(ClienteJuridico cliente) {
        try{
			con = DBManager.getInstance().getConnection();
			cs = con.prepareCall("{call ACTUALIZAR_CLIENTE_JURIDICO"
                    + "(?,?,?,?,?,?,?,?,?)}"); 
			
		}catch(SQLException ex){
			System.out.println(ex.getMessage());
		}finally{
			try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
		}
        return 1;
    }

    @Override
    public int eliminar(int id) {
        try{
			con = DBManager.getInstance().getConnection();
			cs = con.prepareCall("{call ELIMINAR_CLIENTE_JURIDICO"
                    + "(?,?,?,?,?,?,?,?,?)}"); 
			
		}catch(SQLException ex){
			System.out.println(ex.getMessage());
		}finally{
			try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
		}
        return 1;
    }

}
