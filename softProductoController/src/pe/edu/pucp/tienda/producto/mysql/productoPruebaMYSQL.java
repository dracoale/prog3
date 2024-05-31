/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.tienda.producto.mysql;

import java.util.ArrayList;
import pe.edu.pucp.tienda.producto.dao.productoDAO;
import pe.edu.pucp.tienda.producto.model.Producto;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import pe.edu.pucp.tienda.config.DBManager;
import java.sql.ResultSet;
import pe.edu.pucp.tienda.producto.dao.productoPruebaDAO;
import pe.edu.pucp.tienda.producto.model.EstadoProducto;
import pe.edu.pucp.tienda.producto.model.ProductoPrueba;

/**
 *
 * @author USER
 */
public class productoPruebaMYSQL implements productoPruebaDAO {

    private Connection con;
    private CallableStatement cs;
    private ResultSet rs;

    @Override
    public int insertar(ProductoPrueba producto) {
        int resultado = 0;
        try {
//            System.out.println("Foto length: " + producto.getFoto().length);
            con = DBManager.getInstance().getConnection();
            System.out.println(con);
            cs = con.prepareCall("{call InsertaProductoPrueba"
                    + "(?,?,?,?,?,?)}");
            cs.registerOutParameter("p_idProducto", java.sql.Types.INTEGER);
            cs.setString("p_nombre", producto.getNombre());
            cs.setString("p_descripcion", producto.getDescripcion());
            cs.setDouble("p_precio", producto.getPrecio());
            cs.setInt("p_stock", producto.getStock());
            cs.setBytes("p_foto",producto.getFoto());
            cs.executeUpdate();
            producto.setCodigo(cs.getInt("p_idProducto"));
            resultado = producto.getCodigo();
            
        } catch (Exception ex) {
            // System.out.println("no entrio");
            System.out.println(ex.getMessage());
        } finally {
            try {
                con.close();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        System.out.println(resultado);
        return resultado;
    }

    @Override
    public ArrayList<ProductoPrueba> listar() {
        ArrayList<ProductoPrueba> productos = new ArrayList<>();
        try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call ListaProductosPrueba()}");
            rs = cs.executeQuery();
            while (rs.next()) {
                ProductoPrueba producto = new ProductoPrueba();
                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setStock(rs.getInt("stock"));
                producto.setFoto(rs.getBytes("foto"));

                productos.add(producto);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                con.close();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        return productos;
        //  return null;

    }    

    @Override
    public ProductoPrueba seleccionarProductoPrueba(int id) {
        ProductoPrueba prod = new ProductoPrueba();
        try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call seleccionarProductoPrueba"
                    + "(?)}");
            cs.setInt("p_id", id);
            rs = cs.executeQuery();
            if (rs.next()) {
                prod.setCodigo(id);
                prod.setNombre(rs.getString("nombre"));
                prod.setDescripcion(rs.getString("descripcion"));
                prod.setPrecio(rs.getDouble("precio"));
                prod.setStock(rs.getInt("stock"));
                prod.setFoto(rs.getBytes("foto"));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                con.close();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        return prod;
    }
}
