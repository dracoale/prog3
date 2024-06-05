/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.tienda.usuario.model;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.tienda.pedido.model.Pedido;

/**
 *
 * @author james
 */
public class Usuario {
	//Hola no me borres B´v
    //:´´´´´v
    //private static int contador=0;
    private int idUsuario;
    private String nombre;
    private char genero;
    private String telefono;
    private String correo;
    private String direccion;
    private Date fechaRegistro;
    private EstadoCuenta estadocuenta;
    private Date fechaNacimiento;
    private String nombreUsuario;
    private String contraseña;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String contraseñaAntigua;
    private TipoUsuario tipoUsuario;
    private ArrayList<Pedido> pedidos;

    public Usuario(){}
    
    public Usuario(String nombre, String telefono, String correo, EstadoCuenta estadocuenta,
            Date fechaNacimiento, String nombreUsuario, String contraseña,
            String apellidoPaterno, String apellidoMaterno, TipoUsuario tipoUsuario) {
        //contador++;
        //this.idUsuario = contador;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.fechaRegistro = new Date();
        this.estadocuenta = estadocuenta;
        this.fechaNacimiento = fechaNacimiento;
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.tipoUsuario = tipoUsuario;
        pedidos = new ArrayList<>();
    }

    
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public EstadoCuenta getEstadocuenta() {
        return estadocuenta;
    }

    public void setEstadocuenta(EstadoCuenta estadocuenta) {
        this.estadocuenta = estadocuenta;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getContraseñaAntigua() {
        return contraseñaAntigua;
    }

    public void setContraseñaAntigua(String contraseñaAntigua) {
        this.contraseñaAntigua = contraseñaAntigua;
    }

    public void actualizarNombre(String nombre) {
        setNombre(nombre);
    }

    public void actualizarCorreo(String correo) {
        setCorreo(correo);
    }

    public void actualizarTelefono(String telefono) {
        setTelefono(telefono);
    }

    public ArrayList<Pedido> getListaPedidos() {
        return pedidos;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
    
    public void actualizarContraseña(String contraseña, String contraseñaNueva) {
        if (contraseña.equals(this.contraseña)) {
            this.contraseña = contraseñaNueva;
        } else {
            System.out.println("La contraseña dada es incorrecta");
        }
    }
    
     public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    public String getNombreCompleto() {
        return nombre + ' ' + apellidoPaterno + ' ' + apellidoMaterno + ' ';
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

}
