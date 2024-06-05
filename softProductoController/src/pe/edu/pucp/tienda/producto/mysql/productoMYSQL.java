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
import pe.edu.pucp.tienda.producto.model.TipoProducto;

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
                    + "(?,?,?,?,?,?,?,?)}");
            cs.registerOutParameter("p_idProducto", java.sql.Types.INTEGER);
            //cs.setString("_DNI", cliente.getDNI());
            cs.setString("p_nombre", producto.getNombre());
            cs.setString("p_descripcion", producto.getDescripcion());
            cs.setInt("p_idTipoProducto", producto.getTipoProducto().getIdTipoProducto());
            cs.setInt("p_idAlmacen", producto.getAlmacen().getIdAlmacen());
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
                producto.setCodigo(rs.getInt("idProducto"));
                producto.setFoto(rs.getBytes("foto"));
                producto.setTipoProducto(new TipoProducto());
                producto.getTipoProducto().setIdTipoProducto(rs.getInt("idTipoProducto"));
                //int idtipo=rs.getInt("categoria");
                producto.setEstadoProducto(EstadoProducto.valueOf( rs.getString("estadoProducto")));
                producto.setPrecio(rs.getDouble("precio"));
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
    public int actualizar(Producto producto) {
        int resultado = 0;
        try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call ActualizaProducto"
                    + "(?,?,?,?,?,?,?,?,?)}");
            cs.setInt("p_idProducto", producto.getCodigo());
            //System.out.println(producto.getCodigo());
            cs.setString("p_nombre", producto.getNombre());
            cs.setString("p_descripcion", producto.getDescripcion());

            cs.setInt("p_idTipoProducto", producto.getTipoProducto().getIdTipoProducto());
            cs.setString("p_estadoProducto", producto.getEstadoProducto().toString());
            cs.setDouble("p_precio", producto.getPrecio());
            cs.setInt("p_stock", producto.getStock());
            cs.setInt("p_idAlmacen", producto.getAlmacen().getIdAlmacen());
            cs.setBytes("p_foto",producto.getFoto());
            
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
                producto.setCodigo(rs.getInt("idProducto"));
                producto.setTipoProducto(new TipoProducto());
                producto.getTipoProducto().setIdTipoProducto(rs.getInt("idTipoProducto"));
                //int idtipo=rs.getInt("categoria");
                producto.setEstadoProducto(EstadoProducto.valueOf( rs.getString("estadoProducto")));
                producto.setPrecio(rs.getDouble("precio"));
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
    }

    @Override
    public ArrayList<Producto> listarXTipo(int idTipo) {
        ArrayList<Producto> productos = new ArrayList<>();
        try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call ListaProductosXTipo"
                    + "(?)}");
            cs.setInt("p_idTipo", idTipo);
            rs = cs.executeQuery();
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setCodigo(rs.getInt("idProducto"));
                producto.setTipoProducto(new TipoProducto());
                producto.getTipoProducto().setIdTipoProducto(rs.getInt("idTipoProducto"));
                //int idtipo=rs.getInt("categoria");
                producto.setEstadoProducto(EstadoProducto.valueOf( rs.getString("estadoProducto")));
                producto.setPrecio(rs.getDouble("precio"));
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
    }

    @Override
    public Producto buscarProducto(int idProducto) {
        Producto prod = new Producto();
        try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call buscarProducto"
                    + "(?)}");
            cs.setInt("p_idProducto", idProducto);
            rs = cs.executeQuery();
            if (rs.next()) {
                prod.setNombre(rs.getString("nombre"));
                prod.setDescripcion(rs.getString("descripcion"));
                prod.setCodigo(rs.getInt("idProducto"));
                prod.setTipoProducto(new TipoProducto());
                prod.getTipoProducto().setIdTipoProducto(rs.getInt("idTipoProducto"));
                prod.setEstadoProducto(EstadoProducto.valueOf( rs.getString("estadoProducto")));
                prod.setPrecio(rs.getDouble("precio"));
                prod.setFoto(rs.getBytes("foto"));
            }else{
                prod.setCodigo(0);
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
        return prod;    }

    @Override
    public ArrayList<Producto> productosMasVendidos() {
    ArrayList<Producto> productos = new ArrayList<>();
        try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call top3_productos_mas_vendidos"
                    + "()}");
            rs = cs.executeQuery();
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setCodigo(rs.getInt("p.idProducto"));
                producto.setNombre(rs.getString("p.nombre"));
                producto.setDescripcion(rs.getString("p.descripcion"));
                producto.setFoto(rs.getBytes("p.foto"));
                producto.setStock(rs.getInt("total_vendido"));
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

    @Override
    public ArrayList<Producto> productosMenosVendidos() {
        ArrayList<Producto> productos = new ArrayList<>();
        try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call top3_productos_menos_vendidos"
                    + "()}");
            rs = cs.executeQuery();
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setCodigo(rs.getInt("p.idProducto"));
                producto.setNombre(rs.getString("p.nombre"));
                producto.setDescripcion(rs.getString("p.descripcion"));
                producto.setFoto(rs.getBytes("p.foto"));
                producto.setStock(rs.getInt("total_vendido"));

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

    @Override
    public double crecimientoVentas(int idproducto, int año, int mes) {
        double crecimiento = 0;
        try {
            con = DBManager.getInstance().getConnection();
            System.out.println(con);
            cs = con.prepareCall("{call calcular_crecimiento_ventas"
                    + "(?,?,?,?)}");
            cs.registerOutParameter("crecimiento", java.sql.Types.DOUBLE);
            cs.setInt("producto_id", idproducto);
            cs.setInt("anio_actual", año);
            cs.setInt("mes_actual", mes);
            cs.executeUpdate();
            crecimiento = cs.getDouble("crecimiento");
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
        return crecimiento;
    }
}
