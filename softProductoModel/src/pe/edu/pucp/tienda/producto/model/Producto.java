/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.tienda.producto.model;

/**
 *
 * @author Windows 10
 */
public class Producto {

  
    private int codigo;
    private String nombre;
    private String descripcion;
    private TipoProducto tipoProducto;
    private double precio;
    private int stock;
    private EstadoProducto estadoProducto;
    private Almacen almacen;
    public Producto() {

    }

    
    public Producto( String nombre, String descripcion,
             double precio, int stock,Almacen almacen,TipoProducto tipoProducto) {
        
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipoProducto = tipoProducto;
        this.precio = precio;
        this.stock = stock;
        this.almacen=almacen;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public EstadoProducto getEstadoProducto() {
        return estadoProducto;
    }

    public void setEstadoProducto(EstadoProducto estadoProducto) {
        this.estadoProducto = estadoProducto;
    }

    public Almacen getAlmacen() {
        return almacen;
    }


    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
    }

}
