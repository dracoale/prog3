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
import java.sql.CallableStatement;
import java.sql.ResultSet;
import  pe.edu.pucp.tienda.factura.model.TipoPago;
import java.util.Date;
import  pe.edu.pucp.tienda.factura.model.EstadoFactura;
/**
 *
 * @author USER
 */
public class facturaMYSQL implements facturaDAO{

    private Connection con;
    private CallableStatement cs;
    private ResultSet rs;
    
    @Override
    public int insertar(Factura factura) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call InsertaFactura (?,?,?,?,?,?)}");
            cs.registerOutParameter("p_idFactura", java.sql.Types.INTEGER);
            cs.setInt("p_idPedido", factura.getIdPedido());
            cs.setDate("p_fecha", new java.sql.Date(factura.getFecha().getTime()) );
            cs.setDouble("p_total", factura.getTotal());
            cs.setString("p_tipoPago", factura.getTipoPago().toString());
            cs.setString("p_estadoFactura", factura.getEstado().toString());
            cs.executeUpdate();
            
            factura.setIdFactura(cs.getInt("p_idFactura"));
            resultado = factura.getIdFactura();
            
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
            cs = con.prepareCall("{call ListaFacturas()}");
            rs = cs.executeQuery();
            
            while(rs.next()){
                Factura factura = new Factura();
                factura.setIdFactura(rs.getInt("idFactura"));
                factura.setIdPedido(rs.getInt("idPedido"));
                factura.setFecha(rs.getDate("fecha"));
                factura.setTotal(rs.getDouble("total"));
                factura.setTipoPago(  TipoPago.valueOf(rs.getString("tipoPago") )   );
                factura.setEstado( EstadoFactura.valueOf(rs.getString("estadoFactura")));
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
            cs = con.prepareCall("{call ActualizaFactura (?,?,?,?,?)}");
            cs.setInt("p_idFactura", factura.getIdFactura());
            cs.setDate("p_fecha", new java.sql.Date(factura.getFecha().getTime()) );
            cs.setDouble("p_total", factura.getTotal());
            cs.setString("p_tipoPago", factura.getTipoPago().toString());
            cs.setString("p_estadoFactura", factura.getEstado().toString());
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
            cs = con.prepareCall("{call EliminaFactura (?)}");
            cs.setInt("p_idFactura",id);
            resultado = cs.executeUpdate();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return resultado;   
    }

    @Override
    public Factura buscarFacturaXPedido(int idPedido) {
        Factura fact =  new Factura();
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call buscarFacturaXPedido"
            + "(?)}");
            cs.setInt("f_idPedido", idPedido);
            rs = cs.executeQuery();
            
            if(rs.next()){
                fact.setIdFactura(rs.getInt("idFactura"));
                fact.setIdPedido(rs.getInt("idPedido"));
                fact.setFecha(rs.getDate("fecha"));
                fact.setTotal(rs.getDouble("total"));
                fact.setTipoPago(  TipoPago.valueOf(rs.getString("tipoPago") )   );
                fact.setEstado( EstadoFactura.valueOf(rs.getString("estadoFactura")));
            }else{
                fact.setIdFactura(0);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return fact;
    }

    @Override
    public Factura buscarFactura(int idFactura) {
        Factura fact =  new Factura();
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call buscarFactura"
            + "(?)}");
            cs.setInt("f_idFactura", idFactura);
            rs = cs.executeQuery();
            
            if(rs.next()){
                fact.setIdFactura(rs.getInt("idFactura"));
                fact.setIdPedido(rs.getInt("idPedido"));
                fact.setFecha(rs.getDate("fecha"));
                fact.setTotal(rs.getDouble("total"));
                fact.setTipoPago(  TipoPago.valueOf(rs.getString("tipoPago") )   );
                fact.setEstado( EstadoFactura.valueOf(rs.getString("estadoFactura")));
            }else{
                fact.setIdFactura(0);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return fact;
    }
    
    
}
