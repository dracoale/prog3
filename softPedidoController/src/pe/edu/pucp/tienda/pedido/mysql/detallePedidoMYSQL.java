/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.tienda.pedido.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import pe.edu.pucp.tienda.config.DBManager;
import pe.edu.pucp.tienda.pedido.dao.detallePedidoDAO;
import pe.edu.pucp.tienda.pedido.model.DetallePedido;
import pe.edu.pucp.tienda.producto.model.Producto;

/**
 *
 * @author james
 */
public class detallePedidoMYSQL implements detallePedidoDAO{
	private Connection con;
	private CallableStatement cs;
	private ResultSet rs;
    @Override
    public int insertar(DetallePedido detallepedido) {
        int resultado =0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{Call InsertaDetallePedido"
            + "(?,?,?,?)}"); 	
            cs.registerOutParameter("p_idDetallePedido", java.sql.Types.INTEGER);
            cs.setInt("p_idPedido", detallepedido.getIdPedido());
            cs.setInt("p_idProducto", detallepedido.getProducto().getCodigo());
            cs.setInt("p_cantidad",detallepedido.getCantidad());
            cs.executeUpdate();
            detallepedido.setIdDetallePedido(cs.getInt("p_idDetallePedido"));
            resultado = detallepedido.getIdDetallePedido();
            }catch(Exception ex){
                    System.out.println(ex.getMessage());
            }finally{
                    try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            }
        return resultado;
    }

    @Override
    public ArrayList<DetallePedido> listar() {
      ArrayList<DetallePedido> detalles = new ArrayList<>();
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call ListaDetallePedidos()}");
            rs = cs.executeQuery();
            while(rs.next()){
                DetallePedido detalle = new DetallePedido();
                detalle.setCantidad(rs.getInt("cantidad"));
                detalle.setProducto(new Producto());
                detalle.getProducto().setCodigo(rs.getInt("idProducto"));
                detalle.setSubtotal(rs.getDouble("subtotal"));
                detalles.add(detalle);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return detalles;
    }

    @Override
    public int actualizar(DetallePedido detallepedido) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call ActualizaDetallePedido(?,?,?)}");
            cs.setInt("p_idDetallePedido", detallepedido.getIdDetallePedido());
            cs.setInt("p_cantidad", detallepedido.getCantidad());
            cs.setDouble("p_subtotal", detallepedido.getSubtotal());
            resultado = cs.executeUpdate();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        return resultado;    
    }

    @Override
    public int eliminar(int id) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call EliminaDetallePedido(?)}");
            cs.setInt("p_idDetallePedido", id);
            resultado = cs.executeUpdate();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        return resultado;   
    }

    @Override
    public ArrayList<DetallePedido> listarXPedido(int idPedido) {
        ArrayList<DetallePedido> detalles = new ArrayList<>();
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call ListaDetallesDePedido"
                    + "(?)}");
            cs.setInt("p_idPedido", idPedido);
            rs = cs.executeQuery();
            while(rs.next()){
                DetallePedido detalle = new DetallePedido();
                detalle.setCantidad(rs.getInt("cantidad"));
                detalle.setProducto(new Producto());
                detalle.getProducto().setCodigo(rs.getInt("idProducto"));
                detalle.setSubtotal(rs.getDouble("subtotal"));
                detalles.add(detalle);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return detalles;
    }

    @Override
    public double sumarDetallesPedido(int idPedido) {
        double total=0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call ListaDetallesDePedido"
                    + "(?)}");
            cs.setInt("p_idPedido", idPedido);
            rs = cs.executeQuery();
            while(rs.next()){
                total += rs.getDouble("subtotal");
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return total;
    }
    
}
