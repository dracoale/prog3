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
import java.sql.ResultSet;
import pe.edu.pucp.tienda.config.DBManager;
import pe.edu.pucp.tienda.pedido.model.EstadoPedido;
import pe.edu.pucp.tienda.pedido.model.Prioridad;

/**
 *
 * @author USER
 */
public class pedidoMYSQL implements pedidoDAO{
	private Connection con;
	private CallableStatement cs;
	private ResultSet rs;

    @Override
    public int insertar(Pedido pedido) {
        int resultado =0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{Call InsertaPedido"
            + "(?,?,?,?)}"); 	
            cs.registerOutParameter("p_idPedido", java.sql.Types.INTEGER);
            cs.setString("p_prioridad", pedido.getPrioridad().toString());
            cs.setDate("p_fechaEntrega", new java.sql.Date(pedido.getFechaEntrega().getTime()));
            cs.setInt("p_idUsuario", pedido.getIdUsuario());
            cs.executeUpdate();
            pedido.setIdPedido(cs.getInt("p_idPedido"));
            resultado = pedido.getIdPedido();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}finally{
			try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
		}
        return resultado ;
    }

    @Override
    public ArrayList<Pedido> listar() {
        
        ArrayList<Pedido> pedidos = new ArrayList<>();
		try{
			con = DBManager.getInstance().getConnection();
			cs = con.prepareCall("{call ListaPedidos"
                    + "()}"); 
			rs = cs.executeQuery();
            while(rs.next()){
                Pedido pedido = new Pedido();
                pedido.setIdPedido(rs.getInt("idPedido"));
                pedido.setEstado(EstadoPedido.valueOf(rs.getString("estadoPedido")));
                pedido.setFechaPedido(rs.getDate("fechaPedido"));
                pedido.setIdUsuario(rs.getInt("idUsuario"));
                pedido.setPrioridad(Prioridad.valueOf(rs.getString("prioridad")));
                pedido.setFechaEntrega(rs.getDate("fechaEntrega"));
                pedidos.add(pedido);
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
                    + "(?,?,?)}");
            cs.setInt("p_idPedido", pedido.getIdPedido());
            cs.setString("p_estadoPedido", pedido.getEstado().toString());
            cs.setString("p_prioridad", pedido.getPrioridad().toString());
            resultado = cs.executeUpdate();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}finally{
			try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
		}
        return resultado;
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
    return resultado;
 }
}
