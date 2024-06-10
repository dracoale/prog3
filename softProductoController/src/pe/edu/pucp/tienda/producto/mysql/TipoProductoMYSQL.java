/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.tienda.producto.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import pe.edu.pucp.tienda.config.DBManager;
import pe.edu.pucp.tienda.producto.dao.TipoProductoDAO;
import pe.edu.pucp.tienda.producto.model.EstadoTipoProducto;
import pe.edu.pucp.tienda.producto.model.TipoProducto;
//import pe.edu.pucp.tienda.producto.model.Oferta;

/**
 *
 * @author alexis
 */
public class TipoProductoMYSQL implements TipoProductoDAO {

    private Connection con;
    private CallableStatement cs;
    private ResultSet rs;

    @Override
    public int insertar(TipoProducto tipoProducto) {
        int resultado = 0;
        try {
            con = DBManager.getInstance().getConnection();
            //System.out.println(con);
            cs = con.prepareCall("{call InsertaTipoProducto"
                    + "(?,?,?,?,?,?)}");
            cs.registerOutParameter("p_idTipoProducto", java.sql.Types.INTEGER);
            //cs.setString("_DNI", cliente.getDNI());
            cs.setString("p_nombre", tipoProducto.getNombre());
            cs.setString("p_descripcion", tipoProducto.getDescripcion());

            cs.executeUpdate();
            tipoProducto.setIdTipoProducto(cs.getInt("p_idTipoProducto"));
            resultado = tipoProducto.getIdTipoProducto();
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
        //System.out.println(resultado);
        return resultado;
    }

    @Override
    public ArrayList<TipoProducto> listar() {
        ArrayList<TipoProducto> tipoProductos = new ArrayList<>();
        try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call ListaTiposProducto()}");
            rs = cs.executeQuery();
            while (rs.next()) {
                TipoProducto tipoProducto = new TipoProducto();
                tipoProducto.setIdTipoProducto(rs.getInt("idTipoProducto"));
                tipoProducto.setNombre(rs.getString("nombre"));
                tipoProducto.setDescripcion(rs.getString("descripcion"));
                tipoProducto.setEstadoTipoProducto(EstadoTipoProducto.valueOf(rs.getString("estadoTipoProducto")));
                tipoProductos.add(tipoProducto);
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
        return tipoProductos;
    }

    @Override
    public int eliminar(int id) {
        int resultado = 0;
        try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call EliminaTipoProducto"
                    + "(?)}");
            cs.setInt("p_idTipoProducto", id);
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
    public int actualizar(TipoProducto tipoProducto) {
        int resultado = 0;
        try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call ActualizaTipoProducto"
                    + "(?,?,?,?)}");
            cs.setInt("p_idTipoProducto", tipoProducto.getIdTipoProducto());
            //System.out.println(producto.getCodigo());
            cs.setString("p_nombre", tipoProducto.getNombre());
            cs.setString("p_descripcion", tipoProducto.getDescripcion());

            cs.setString("p_estadoTipoProducto", tipoProducto.getEstadoTipoProducto().toString());
            
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
        return resultado;    }

}
