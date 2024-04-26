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

    //private static int contador=0;
    private int idUsuario;
    private String nombre;
    private String telefono;
    private String correo;
    private Date fechaRegistro;
    private EstadoCuenta estadocuenta;
    private Date fechaCreacion;
    private String nombreUsuario;
    private String contraseña;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String contraseñaAntigua;
    private TipoUsuario tipoUsuario;
    private ArrayList<Pedido> pedidos;

    public Usuario(){}
    
    public Usuario(String nombre, String telefono, String correo, EstadoCuenta estadocuenta,
            Date fechaCreacion, String nombreUsuario, String contraseña,
            String apellidoPaterno, String apellidoMaterno, TipoUsuario tipoUsuario) {
        //contador++;
        //this.idUsuario = contador;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.fechaRegistro = new Date();
        this.estadocuenta = estadocuenta;
        this.fechaCreacion = fechaCreacion;
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

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
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

    public void actualizarContraseña(String contraseña, String contraseñaNueva) {
        if (contraseña.equals(this.contraseña)) {
            this.contraseña = contraseñaNueva;
        } else {
            System.out.println("La contraseña dada es incorrecta");
        }
    }

    public void mostrarOfertas() {

    }

    public void agregarUsuario() {

    }

    public void modificarUsuario() {

    }

    public void eliminarUsuario(String DNI) {

    }
    
     public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

}
