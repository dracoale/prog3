/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.tienda.producto.model;

//import java.util.ArrayList;

/**
 *
 * @author Windows 10
 */
public class Almacen {
    private int idAlmacen;
    private String direccion;
    //private ArrayList<Producto> productos;

    public Almacen(int idAlmacen, String direccion) {
        this.idAlmacen = idAlmacen;
        this.direccion = direccion;
       // this.productos = productos;
    }
    public Almacen(){}
    public int getIdAlmacen() {
        return idAlmacen;
    }

    public void setIdAlmacen(int idAlmacen) {
        this.idAlmacen = idAlmacen;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

//    public ArrayList<Producto> getProductos() {
//        return productos;
//    }
//
//    public void setProductos(ArrayList<Producto> productos) {
//        this.productos = productos;
//    }
//    
    
    
    
}
