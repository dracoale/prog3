/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.tienda.pedido.mysql;

import java.util.ArrayList;
import pe.edu.pucp.tienda.pedido.dao.pedidoDAO;
import pe.edu.pucp.tienda.pedido.model.Pedido;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import pe.edu.pucp.tienda.config.DBManager;

/**
 *
 * @author USER
 */
public class pedidoMYSQL implements pedidoDAO{
	private Connection con;
	private CallableStatement cs;
	private ResultSet rs;

    @Override
    public int insertar(Pedido pedido,int idFactura) {
        int resultado =0;
        try{
			con = DBManager.getInstance().getConnection();
			cs = con.prepareCall("{call InsertaPedido"
                    + "(?,?,?,?,?,?,?)}"); 	
			cs.setInt("p_idPedido", pedido.getIdPedido());
            cs.setInt("p_idEstadoPedido", pedido.getEstado().ordinal()+1);
            cs.setDate("p_fechaPedido", new java.sql.Date(pedido.getFechaPedido().getTime()));
            cs.setDate("p_fechaCreacion", new java.sql.Date(pedido.getFechaCreacion().getTime()));
            cs.setInt("p_idPrioridad", pedido.getPrioridad().ordinal()+1);
            cs.setDate("p_fechaEntrega", new java.sql.Date(pedido.getFechaEntrega().getTime()));
			//cs.setInt("p_idUsuario",idUsuario);
            cs.setInt("p_idFactura", idFactura);
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}finally{
			try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
		}
        return 1;
    }

    @Override
    public ArrayList<Pedido> listar() {
        int resultado =0;
        ArrayList<Pedido> pedidos = new ArrayList<>();
		try{
			con = DBManager.getInstance().getConnection();
			cs = con.prepareCall("{call ListaPedidos"
                    + "(?,?,?,?,?,?)}"); 
			rs = cs.executeQuery();
            while(rs.next()){
                Pedido pedido = new Pedido();
                pedido.setIdPedido(rs.getInt("idPedido"));
               // pedido.setEstado(rs.getInt("idEstadoPedido"));
                pedido.setFechaPedido(rs.getDate("fechaPedido"));
                pedido.setFechaCreacion(rs.getDate("fechaCreacion"));
               // pedido.setPrioridad(rs.getInt("idPrioridad"));
                pedido.setFechaEntrega(rs.getDate("fechaEntrega"));
              //  clientes.add(cliente);
            }
			
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}finally{
			try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
		}
		return pedidos;
    }

    @Override
    public int actualizar(Pedido pedido) {
        int resultado =0;
        try{
			con = DBManager.getInstance().getConnection();
			cs = con.prepareCall("{call ActualizaPedido"
                    + "(?,?,?,?,?,?)}"); 
			cs.setInt("p_idPedido", pedido.getIdPedido());
            cs.setInt("p_idEstadoPedido", pedido.getEstado().ordinal()+1);
            cs.setDate("p_fechaPedido", new java.sql.Date(pedido.getFechaPedido().getTime()));
            cs.setDate("p_fechaCreacion", new java.sql.Date(pedido.getFechaCreacion().getTime()));
            cs.setInt("p_idPrioridad", pedido.getPrioridad().ordinal()+1);
            cs.setDate("p_fechaEntrega", new java.sql.Date(pedido.getFechaEntrega().getTime()));           
            resultado = cs.executeUpdate();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}finally{
			try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
		}
        return 1;
    }

    @Override
    public int eliminar(int id) {
        int resultado =0;
        try{
			con = DBManager.getInstance().getConnection();
			cs = con.prepareCall("{call EliminaPedido"
                    + "(?)}");
			cs.setInt("p_idPedido",id);
			resultado=cs.executeUpdate();
			
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}finally{
			try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
		}
    return 1;
 }
}
