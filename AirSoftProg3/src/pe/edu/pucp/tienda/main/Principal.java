package pe.edu.pucp.tienda.main;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.tienda.factura.model.Factura;
import pe.edu.pucp.tienda.pedido.dao.detallePedidoDAO;
import pe.edu.pucp.tienda.pedido.dao.pedidoDAO;
import pe.edu.pucp.tienda.pedido.model.DetallePedido;
import pe.edu.pucp.tienda.pedido.model.EstadoDetallePedido;
import pe.edu.pucp.tienda.pedido.model.EstadoPedido;
import pe.edu.pucp.tienda.pedido.model.Pedido;
import pe.edu.pucp.tienda.pedido.model.Prioridad;
import pe.edu.pucp.tienda.pedido.mysql.detallePedidoMYSQL;
import pe.edu.pucp.tienda.pedido.mysql.pedidoMYSQL;
import pe.edu.pucp.tienda.producto.model.EstadoProducto;
import pe.edu.pucp.tienda.producto.model.Producto;
import pe.edu.pucp.tienda.producto.model.TipoProducto;
import pe.edu.pucp.tienda.usuario.model.EstadoCuenta;
import pe.edu.pucp.tienda.usuario.model.TipoUsuario;
import pe.edu.pucp.tienda.usuario.model.Usuario;
import pe.edu.pucp.tienda.producto.dao.productoDAO;
import pe.edu.pucp.tienda.producto.mysql.productoMYSQL;

public class Principal {

    public static void main(String[] args) {
        int resultado;
        Pedido pedido = new Pedido(EstadoPedido.CANCELADA, new Date(),
                new Date(), Prioridad.NO_URGENTE, new Date());
        Pedido pedido2 = new Pedido(EstadoPedido.ENTREGADA, new Date(),
                new Date(), Prioridad.URGENTE, new Date());
        DetallePedido detallePedido = new DetallePedido(0, 0);
        detallePedido.setEstado(EstadoDetallePedido.ACTIVO);
        detallePedido.setIdPedido(3);
        detallePedido.setProducto(new Producto());
        detallePedido.getProducto().setCodigo(4);
        Factura factura = new Factura(1, new Date(), 0);

        pedidoDAO pedidodao = new pedidoMYSQL();
        detallePedidoDAO detalledao = new detallePedidoMYSQL();
        // detallePedido.getListaProductos().add(producto);
        //pedido.getListaDetallesPedidos().add(detallePedido);

        //////////////////////////////////////////
        productoDAO productodao = new productoMYSQL();
        TipoProducto categoria = new TipoProducto(1, "drink", "fino");

//        Producto producto = new Producto(1, "Manzana", "Manzanas frescas",
//                categoria, 1.50, 10, EstadoProducto.ACTIVO);
//        productodao.insertar(producto);
//        pedido.setFactura(factura);
//        detallePedido.setProducto(producto);
        
        //Añadir Agregar
//        resultado = pedidodao.insertar(pedido);
//        System.out.println(resultado);
//        pedidodao.actualizar(pedido);
//        ArrayList<Pedido> pedidos = pedidodao.listar();
//        for (Pedido ped : pedidos) {
//            System.out.println(ped.getIdPedido());
//            System.out.println(ped.getIdUsuario());
//
//            System.out.println();
//        }
        resultado = detalledao.insertar(detallePedido);
        detallePedido.setSubtotal(100);
        detallePedido.setIdDetallePedido(15);
        detalledao.actualizar(detallePedido);
        detalledao.eliminar(14);
        ArrayList<DetallePedido> detalles = detalledao.listar();        ArrayList<Pedido> pedidos = pedidodao.listar();
        for (DetallePedido detalle : detalles) {
            System.out.println(detalle.getProducto().getCodigo());
            System.out.println(detalle.getSubtotal());

            System.out.println();
        }
//        System.out.println(resultado);
    //    resultado = detalledao.insertar(detallePedido);
        
//        ArrayList<Producto> productos = new productoMYSQL().listar();
//        for (Producto item : productos) {
//            System.out.println(item.getNombre());
//            System.out.println(item.getDescripcion());
//
//            System.out.println();
//        }
//
//        producto.setNombre("NARANJA");
//        producto.setStock(20);
//
//        resultado = productodao.actualizar(producto);
//        if (resultado != 0) {
//            System.out.println("Se ha modificado con exito");
//        }
//
//        productodao.eliminar(producto.getCodigo());

    }
}
