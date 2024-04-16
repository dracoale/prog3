package pe.edu.pucp.tienda.main;

import java.util.Date;
import pe.edu.pucp.tienda.factura.model.Factura;
import pe.edu.pucp.tienda.pedido.model.DetallePedido;
import pe.edu.pucp.tienda.pedido.model.EstadoPedido;
import pe.edu.pucp.tienda.pedido.model.Pedido;
import pe.edu.pucp.tienda.pedido.model.Prioridad;
import pe.edu.pucp.tienda.producto.model.EstadoProducto;
import pe.edu.pucp.tienda.producto.model.Producto;
import pe.edu.pucp.tienda.producto.model.TipoProducto;
import pe.edu.pucp.tienda.usuario.model.EstadoCuenta;
import pe.edu.pucp.tienda.usuario.model.TipoUsuario;
import pe.edu.pucp.tienda.usuario.model.Usuario;

public class Principal {

    public static void main(String[] args) {
        TipoProducto categoria = new TipoProducto (1,"drink","fino");
     
        // Crear una instancia de EstadoProducto (suponiendo que tienes una clase EstadoProducto)
        //EstadoProducto estadoProducto = EstadoProducto.DISPONIBLE;
//Producto

        // Crear una instancia de Producto utilizando el constructor
        Producto producto = new Producto(1, "Manzana", "Manzanas frescas",
                categoria, 1.50, 100, EstadoProducto.ACTIVO);
        
        Pedido pedido = new Pedido(1, EstadoPedido.CANCELADA, new Date(), 
                new Date(),Prioridad.NO_URGENTE, new Date());
        DetallePedido detallePedido=new DetallePedido(0, 0, 0);
        Factura factura= new Factura(1,new Date(),0);
        
        Usuario usuario = new Usuario("Juan", "123456789", ""
                + "juan@example.com", EstadoCuenta.ACTIVO, 
                new Date(), "juanj", "contraseña", 
                "Pérez", "Gómez",TipoUsuario.ADMIN);
        detallePedido.getListaProductos().add(producto);
        pedido.getListaDetallesPedidos().add(detallePedido);

    }
}
