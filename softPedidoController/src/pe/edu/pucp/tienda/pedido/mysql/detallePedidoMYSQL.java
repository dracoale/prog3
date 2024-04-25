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
            cs = con.prepareCall("{Call InsertaPedido"
            + "(?,?,?,?,?)}"); 	
            cs.registerOutParameter("_id_detalle_pedido", java.sql.Types.INTEGER);
            cs.setInt("_id_Pedido", detallepedido.getIdPedido());
            cs.setInt("_id_Producto", detallepedido.getProducto().getCodigo());
            cs.setInt("_cantidad",detallepedido.getCantidad());
            cs.setDouble("_subtotal",detallepedido.getSubtotal());
            cs.executeUpdate();
            detallepedido.setIdDetallePedido(cs.getInt("_id_detalle_pedido"));
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
            cs = con.prepareCall("{call LISTAR_DETALLES_TODOS()}");
            rs = cs.executeQuery();
            while(rs.next()){
                DetallePedido detalle = new DetallePedido();
                detalle.setCantidad(rs.getInt("cantidad"));
                detalle.setProducto(new Producto());
                detalle.getProducto().setCodigo(rs.getInt("id_producto"));
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
            cs = con.prepareCall("{call ACTUALIZA_DETALLE_PEDIDO(?,?,?)}");
            cs.setInt("_id_detalle_pedido", detallepedido.getIdDetallePedido());
            cs.setInt("_cantidad", detallepedido.getCantidad());
            cs.setBoolean("_activo", detallepedido.isActivo());
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
            cs = con.prepareCall("{call ELIMINAR_DETALLE_PEDIDO(?)}");
            cs.setInt("_id_detalle_pedido", id);
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
    
}
