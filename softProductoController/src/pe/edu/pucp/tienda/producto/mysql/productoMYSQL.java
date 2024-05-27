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
import pe.edu.pucp.tienda.producto.model.EstadoProducto;

/**
 *
 * @author USER
 */
public class productoMYSQL implements productoDAO {

    private Connection con;
    private CallableStatement cs;
    private ResultSet rs;

    @Override
    public int insertar(Producto producto) {
        int resultado = 0;
        try {
            con = DBManager.getInstance().getConnection();
            System.out.println(con);
            cs = con.prepareCall("{call InsertaProducto"
                    + "(?,?,?,?,?,?,?)}");
            cs.registerOutParameter("p_idProducto", java.sql.Types.INTEGER);
            //cs.setString("_DNI", cliente.getDNI());
            cs.setString("p_nombre", producto.getNombre());
            cs.setString("p_descripcion", producto.getDescripcion());
           cs.setInt("p_idTipoProducto", 1);
            cs.setInt("p_idAlmacen", 1);
            
            cs.setDouble("p_precio", producto.getPrecio());
            //  cs.setDouble("_linea_credito", producto.getLineaCredito());
           // cs.setInt("p_idEstadoProducto", 1);
            cs.setInt("p_stock", producto.getStock());
            //System.out.println(producto.getStock());
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
    public ArrayList<Producto> listar() {
        ArrayList<Producto> productos = new ArrayList<>();
        try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call ListaProductos()}");
            rs = cs.executeQuery();
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setCodigo(rs.getInt("idTipoProducto"));
                
                
                //int idtipo=rs.getInt("categoria");
                producto.setEstadoProducto(EstadoProducto.valueOf( rs.getString("estadoProducto")));
                producto.setPrecio(rs.getDouble("precio"));

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
    public int actualizar(Producto producto) {
        int resultado = 0;
        try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call ActualizaProducto"
                    + "(?,?,?,?,?,?,?,?)}");
            cs.setInt("p_idProducto", producto.getCodigo());
            //System.out.println(producto.getCodigo());
            cs.setString("p_nombre", producto.getNombre());
            cs.setString("p_descripcion", producto.getDescripcion());

            cs.setInt("p_idTipoProducto", producto.getTipoProducto().getIdTipoProducto());
            cs.setString("p_estadoProducto", producto.getEstadoProducto().toString());
            cs.setDouble("p_precio", producto.getPrecio());
            cs.setInt("p_stock", producto.getStock());
            cs.setInt("p_idAlmacen", producto.getAlmacen().getIdAlmacen());
            
            resultado = cs.executeUpdate();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                con.close();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        return resultado;
    }

    @Override
    public int eliminar(int id) {
        int resultado = 0;
        try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call EliminaProducto"
                    + "(?)}");
            cs.setInt("p_idProducto", id);
            cs.executeUpdate();
            resultado = 1;
            cs.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                con.close();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        return resultado;
    }

    @Override
    public ArrayList<Producto> listarXNombre(String nombre) {
        ArrayList<Producto> productos = new ArrayList<>();
        try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_PRODUCTOS_POR_NOMBRE"
                    + "(?)}");
            cs.setString("_nombre", nombre);
            rs = cs.executeQuery();
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setCodigo(rs.getInt("idTipoProducto"));
                
                
                //int idtipo=rs.getInt("categoria");
                producto.setEstadoProducto(EstadoProducto.valueOf( rs.getString("estadoProducto")));
                producto.setPrecio(rs.getDouble("precio"));

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
    }

    

}
