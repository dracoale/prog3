/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.tienda.producto.model;

/**
 *
 * @author Windows 10
 */
public class TipoProducto {

    private int idTipoProducto;
    private String nombre;
    private String descripcion;

    public TipoProducto(int idTipoProducto, String nombre, String descripcion) {
        this.idTipoProducto = idTipoProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
   
    public TipoProducto() {

    }

    public int getIdTipoProducto() {
        return idTipoProducto;
    }

    public void setIdTipoProducto(int idTipoProducto) {
        this.idTipoProducto = idTipoProducto;
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

}
