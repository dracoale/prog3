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
public class ClienteJuridico extends Usuario{
    private String RUC;
    private String nombreEmpresa;

    public ClienteJuridico(){}
    
    public ClienteJuridico(Date fechaRegistro, String nombre, String telefono, String correo, 
            EstadoCuenta estadocuenta, Date fechaCreacion, String nombreUsuario, 
            String contraseña, String apellidoPaterno, String apellidoMaterno,String RUC, String nombreEmpresa) {
        super(fechaRegistro, nombre, telefono, correo, estadocuenta, fechaCreacion, nombreUsuario,
                contraseña, apellidoPaterno, apellidoMaterno,TipoUsuario.USER_JURIDICO);
        this.RUC = RUC;
        this.nombreEmpresa = nombreEmpresa;
    }
    
    public String getRUC() {
        return RUC;
    }

    public void setRUC(String RUC) {
        this.RUC = RUC;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

}
