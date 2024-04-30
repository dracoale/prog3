/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.tienda.usuario.model;

import java.util.Date;

/**
 *
 * @author james
 */
public class Administrador extends Usuario{
  //  private static int contador=0;
    private int idAdministrador;
    private String descripcion;
    
    public Administrador(String nombre, String telefono, String correo, EstadoCuenta estadocuenta, Date fechaCreacion, String nombreUsuario, String contraseña, String apellidoPaterno, String apellidoMaterno,String descripcion) {
        super(nombre,telefono,correo,estadocuenta,fechaCreacion,nombreUsuario,contraseña,apellidoPaterno,apellidoMaterno,TipoUsuario.ADMIN);
       // contador++;
        //this.idAdministrador=contador;
        this.descripcion = descripcion;
    }

    public int getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(int idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
