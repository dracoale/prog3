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
import pe.edu.pucp.tienda.producto.dao.AlmacenDAO;
import pe.edu.pucp.tienda.producto.model.Almacen;
import pe.edu.pucp.tienda.producto.model.EstadoAlmacen;

/**
 *
 * @author james
 */
public class AlmacenMYSQL implements AlmacenDAO{
    private Connection con;
    private CallableStatement cs;
    private ResultSet rs;
    @Override
    public int insertar(Almacen almacen) {
        int resultado = 0;
        try {
            con = DBManager.getInstance().getConnection();
            System.out.println(con);
            cs = con.prepareCall("{call InsertaAlmacen"
                    + "(?,?)}");
            cs.registerOutParameter("p_idAlmacen", java.sql.Types.INTEGER);
            cs.setString("p_direccion", almacen.getDireccion());
            cs.executeUpdate();
            almacen.setDireccion(cs.getString("p_idAlmacen"));
            resultado = almacen.getIdAlmacen();
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
    public ArrayList<Almacen> listar() {
        ArrayList<Almacen> almacenes = new ArrayList<>();
        try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call ListaAlmacenes()}");
            rs = cs.executeQuery();
            while (rs.next()) {
                Almacen almacen = new Almacen();
                almacen.setDireccion(rs.getString("direccion"));
                almacen.setIdAlmacen(rs.getInt("idAlmacen"));
                almacen.setEstado(EstadoAlmacen.valueOf( rs.getString("estadoAlmacen")));

                almacenes.add(almacen);
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
        return almacenes;
    }

    @Override
    public int actualizar(Almacen almacen) {
        int resultado = 0;
        try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call ActualizaAlmacen"
                    + "(?,?)}");
            cs.setString("p_direccion", almacen.getDireccion());
            cs.setInt("p_idAlmacen", almacen.getIdAlmacen());
            
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
            cs = con.prepareCall("{call EliminaAlmacen"
                    + "(?)}");
            cs.setInt("p_idAlmacen", id);
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
    
}
