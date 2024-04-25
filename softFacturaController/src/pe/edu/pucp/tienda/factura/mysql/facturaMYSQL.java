/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.tienda.factura.mysql;

import java.util.ArrayList;
import pe.edu.pucp.tienda.config.DBManager;
import pe.edu.pucp.tienda.factura.dao.facturaDAO;
import pe.edu.pucp.tienda.factura.model.Factura;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
/**
 *
 * @author USER
 */
public class facturaMYSQL implements facturaDAO{

    private Connection con;
    private PreparedStatement  pst;
    private ResultSet rs;
    private Statement st;
    
    @Override
    public int insertar(Factura factura) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            String sql = "INSERT INTO Factura(fecha, total) VALUES (?, ?)";
            pst = con.prepareStatement(sql);
            pst.setDate(1, (java.sql.Date) factura.getFecha());
            pst.setDouble(2, factura.getTotal());
            resultado = pst.executeUpdate(sql);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public ArrayList<Factura> listar() {
        ArrayList<Factura> facturas =  new ArrayList<>();
        try{
            con = DBManager.getInstance().getConnection();
            String sql = "SELECT * FROM Factura WHERE activo = 1";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                Factura factura = new Factura();
                factura.setIdFactura(rs.getInt("idFactura"));
                factura.setFecha(rs.getDate("fecha"));
                factura.setTotal(rs.getDouble("total"));
                facturas.add(factura);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return facturas;
    }

    @Override
    public int actualizar(Factura factura) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            String sql = "UPDATE Factura SET total = ?, fecha = ? WHERE idFactura = ?";
            pst = con.prepareStatement(sql);
            pst.setDouble(1, factura.getTotal());
            pst.setDate(2, (java.sql.Date) factura.getFecha());
            pst.setInt(3, factura.getIdFactura());
            resultado = pst.executeUpdate(sql);
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
            String sql = "UPDATE Factura SET total = -1 WHERE idFactura = ?";
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            resultado = pst.executeUpdate(sql);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return resultado;   
    }
    
    
}
