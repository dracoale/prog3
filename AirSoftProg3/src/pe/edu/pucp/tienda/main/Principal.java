package pe.edu.pucp.tienda.main;

import java.util.ArrayList;
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
import pe.edu.pucp.tienda.producto.dao.productoDAO;
import pe.edu.pucp.tienda.producto.model.Almacen;
import pe.edu.pucp.tienda.producto.mysql.productoMYSQL;

public class Principal {

    public static void main(String[] args) {
//        int resultado;
//        Pedido pedido = new Pedido(1, EstadoPedido.CANCELADA, new Date(),
//                new Date(), Prioridad.NO_URGENTE, new Date());
//        DetallePedido detallePedido = new DetallePedido(0, 0, 0);
//        Factura factura = new Factura(1, new Date(), 0);
//
//        Usuario usuario = new Usuario("Juan", "123456789", ""
//                + "juan@example.com", EstadoCuenta.ACTIVO,
//                new Date(), "juanj", "contraseña",
//                "Pérez", "Gómez", TipoUsuario.ADMIN);
//        // detallePedido.getListaProductos().add(producto);
//        pedido.getListaDetallesPedidos().add(detallePedido);

        //////////////////////////////////////////
        productoDAO productodao = new productoMYSQL();
       // TipoProducto categoria = new TipoProducto(1, "drink", "fino");
//Almacen almacen =new Almacen("sdg");
        Producto producto = new Producto( "Manzana", "Manzanas frescas",
                1.50, 10,new Almacen(),new TipoProducto());
        System.out.println("el id es de insertado"+productodao.insertar(producto));

        //ArrayList<Producto> productos = new productoMYSQL().listar();
//        for (Producto item : productos) {
//            System.out.print(item.getNombre()+ " ");
//            System.out.print(item.getDescripcion());
//
//            System.out.println(item.getEstadoProducto());
//        }

      producto.setNombre("NARANJA");
        producto.setStock(20);
        producto.setEstadoProducto(EstadoProducto.DESCONTINUADO);
     producto.getTipoProducto().setIdTipoProducto(1);
      producto.getAlmacen().setIdAlmacen(1);
       System.out.println("Se ha modificado con exito el id "+productodao.actualizar(producto));
        
//
      productodao.eliminar(producto.getCodigo());

    }
}
