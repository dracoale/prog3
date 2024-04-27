/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.tienda.factura.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import pe.edu.pucp.tienda.config.DBManager;
import pe.edu.pucp.tienda.factura.dao.detalleFacturaDAO;
import pe.edu.pucp.tienda.factura.model.DetalleFactura;
import pe.edu.pucp.tienda.factura.model.Factura;
import pe.edu.pucp.tienda.factura.model.TipoPago;
import pe.edu.pucp.tienda.producto.model.Producto;
import  pe.edu.pucp.tienda.factura.model.EstadoDetalleFactura;
/**
 *
 * @author james
 */
public class detalleFacturaMYSQL implements detalleFacturaDAO{
    private Connection con;
    private CallableStatement cs;
    private ResultSet rs;
    
    @Override
    public int insertar(DetalleFactura detallefactura) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call InsertaDetalleFactura (?,?,?,?,?,?)}");
            cs.registerOutParameter("p_idDetalleFactura ", java.sql.Types.INTEGER);
            cs.setInt("p_id_factura ", detallefactura.getFactura().getIdFactura() );
            cs.setInt("p_id_producto ", detallefactura.getProducto().getCodigo() );
            cs.setInt("p_cantidad ", detallefactura.getCantidad());
            cs.setDouble("p_precioUnitario ", detallefactura.getPrecioUnitario());
            cs.setDouble("p_subtotal ", detallefactura.getSubtotal());
            cs.setString("p_estado ", detallefactura.getEstado().toString());
            cs.executeUpdate();
            
            detallefactura.setIdDetalleFactura(cs.getInt("p_idDetalleFactura"));
            resultado = detallefactura.getIdDetalleFactura();
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public ArrayList<DetalleFactura> listar() {
        ArrayList<DetalleFactura> detalle =  new ArrayList<>();
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call ListaDetalleFacturas()}");
            rs = cs.executeQuery();
            
            while(rs.next()){
                DetalleFactura detalles = new DetalleFactura();
                detalles.setIdDetalleFactura(rs.getInt("idDetalleFactura"));
                detalles.setCantidad(rs.getInt("cantidad"));
                detalles.setPrecioUnitario(rs.getDouble("precioUnitario"));
                detalles.setSubtotal(rs.getDouble("subtotal"));
                detalles.getProducto().setCodigo(rs.getInt("codigo_producto"));
                detalles.getProducto().setNombre(rs.getString("nombre_producto"));
                detalles.getFactura().setIdFactura(rs.getInt("idFactura"));
                detalles.getFactura().setFecha(rs.getDate("fecha_factura"));
                detalles.setEstado(EstadoDetalleFactura.valueOf(rs.getString("estado") )   );
                detalle.add(detalles);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return detalle;
    }

    @Override
    public int actualizar(DetalleFactura detallefactura) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call ActualizaDetalleFactura (?,?,?,?,?, ?)}");
            
            cs.setInt("p_idDetalleFactura ", detallefactura.getIdDetalleFactura());
            
            cs.setInt("p_id_factura ", detallefactura.getFactura().getIdFactura());
            cs.setInt("p_id_producto ", detallefactura.getProducto().getCodigo());
            
            //p_cantidad   p_precioUnitario     p_subtotal
            cs.setInt("p_cantidad", detallefactura.getCantidad());
            cs.setDouble("p_precioUnitario ", detallefactura.getPrecioUnitario());
            cs.setDouble("p_subtotal ", detallefactura.getSubtotal());

            cs.setString("p_estado ", detallefactura.getEstado().toString());
            
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
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call EliminaDetalleFactura (?)}");
            cs.setInt("p_idDetalleFactura",id);
            resultado = cs.executeUpdate();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return resultado;  
    }
    
}
