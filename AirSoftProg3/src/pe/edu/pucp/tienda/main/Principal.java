package pe.edu.pucp.tienda.main;

import java.util.ArrayList;
import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import pe.edu.pucp.tienda.factura.dao.facturaDAO;
import pe.edu.pucp.tienda.factura.model.EstadoFactura;
import pe.edu.pucp.tienda.factura.model.Factura;
import pe.edu.pucp.tienda.factura.model.TipoPago;
import pe.edu.pucp.tienda.factura.mysql.facturaMYSQL;
import pe.edu.pucp.tienda.pedido.dao.detallePedidoDAO;
import pe.edu.pucp.tienda.pedido.dao.pedidoDAO;
import pe.edu.pucp.tienda.pedido.model.DetallePedido;
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
import pe.edu.pucp.tienda.producto.model.Almacen;
import pe.edu.pucp.tienda.producto.mysql.productoMYSQL;
import pe.edu.pucp.tienda.usuario.dao.ClienteIndividualDAO;
import pe.edu.pucp.tienda.usuario.dao.ClienteJuridicoDAO;
import pe.edu.pucp.tienda.usuario.mysql.ClienteIndividualMYSQL;
import pe.edu.pucp.tienda.usuario.model.ClienteIndividual;
import pe.edu.pucp.tienda.usuario.model.ClienteJuridico;
import pe.edu.pucp.tienda.usuario.mysql.ClienteJuridicoMYSQL;

public class Principal {

    public static void main(String[] args) {
// Prueba Pedido
//        int resultado;
//        Pedido ped = new Pedido(new Date(),
//                new Date(), Prioridad.NO_URGENTE, new Date());
//        pedidoDAO pedidodao = new pedidoMYSQL();
//        ped.setIdUsuario(1);
//        pedidodao.insertar(ped);
//        ped.setPrioridad(Prioridad.URGENTE);
//        ped.setEstado(EstadoPedido.PROCESADA);
//        pedidodao.actualizar(ped);
//        pedidodao.eliminar(10);
//        DetallePedido detallePedido = new DetallePedido(0, 0, 0);
//        Factura factura = new Factura(1, new Date(), 0);
//
// Prueba Factura
//
//          int resultado;
//          Factura fac = new Factura();
//          fac.setFecha(new Date());
//          fac.setIdPedido(10);
//          fac.setTipoPago(TipoPago.VISA);
//          fac.setTotal(20);
//          fac.setEstado(EstadoFactura.ACTIVO);
//          facturaDAO facturadao = new facturaMYSQL();
//          facturadao.insertar(fac);
//
//
//        Usuario usuario = new Usuario("Juan", "123456789", ""
//                + "juan@example.com", EstadoCuenta.ACTIVO,
//                new Date(), "juanj", "contraseña",
//                "Pérez", "Gómez", TipoUsuario.ADMIN);

        // detallePedido.getListaProductos().add(producto);
//        pedido.getListaDetallesPedidos().add(detallePedido);
//
//        //////////////////////////////////////////
//        productoDAO productodao = new productoMYSQL();
//        TipoProducto categoria = new TipoProducto(1, "drink", "fino");
//
//        Producto producto = new Producto(1, "Manzana", "Manzanas frescas",
//                categoria, 1.50, 10, EstadoProducto.ACTIVO);
//        productodao.insertar(producto);
//
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
//        resultado=0;
//        
//        ClienteIndividual clienteI=new ClienteIndividual();
//        clienteI.setIdUsuario(1);
//        clienteI.setNombre("Sapito");
//        clienteI.setApellidoPaterno("Jara");
//        clienteI.setApellidoMaterno("Pepito");
//        clienteI.setDNI("894612354");
//        clienteI.setCorreo("drStr0ng@hotmail.com");
//        LocalDate fechaActual=LocalDate.now();
//        clienteI.setFechaCreacion(Date.from(fechaActual.atStartOfDay(ZoneId.systemDefault()).toInstant()));
//        clienteI.setTelefono("987654321");
//        clienteI.setFechaRegistro(Date.from(fechaActual.atStartOfDay(ZoneId.systemDefault()).toInstant()));
//        clienteI.setNombreUsuario("BilletePuertas123");
//        clienteI.setContraseña("contraseña9");
//        
//        ClienteJuridico clienteJ=new ClienteJuridico();
//        clienteJ.setIdUsuario(2);
//        clienteJ.setNombre("Manolo");
//        clienteJ.setApellidoPaterno("Neyra");
//        clienteJ.setApellidoMaterno("Yara");
//        clienteJ.setRUC("89121544612354");
//        clienteJ.setNombreEmpresa("Doof MyA INC");
//        clienteJ.setCorreo("FC_Prog03@hotmail.com");
//        clienteJ.setFechaCreacion(Date.from(fechaActual.atStartOfDay(ZoneId.systemDefault()).toInstant()));
//        clienteJ.setTelefono("994512833");
//        clienteJ.setFechaRegistro(Date.from(fechaActual.atStartOfDay(ZoneId.systemDefault()).toInstant()));
//        clienteJ.setNombreUsuario("VendedorDeSapitos");
//        clienteJ.setContraseña("Ezzzzzzzzz");
//    //    productoDAO productodao = new productoMYSQL();
////        TipoProducto categoria = new TipoProducto(1, "drink", "fino");
//        ClienteIndividualDAO clienteIndDao=new ClienteIndividualMYSQL();
//        ClienteJuridicoDAO clienteJudDao=new ClienteJuridicoMYSQL();
//        //resultado=clienteJudDao.actualizar(clienteJ);
//        //resultado=clienteIndDao.actualiza(clienteI);
//        ArrayList<ClienteIndividual> clientesI= new ArrayList<ClienteIndividual>();
//        clientesI=clienteIndDao.lista();
//        for(ClienteIndividual item: clientesI){
//            System.out.println(item.getNombre());
//        }
//        System.out.println("aea "+resultado);
//        Pedido p = new Pedido();
//        if(resultado!=0) System.out.println("Se ha actualizado con exito");
//
//        Pedido pedido = new Pedido(EstadoPedido.CANCELADA, new Date(),
//                new Date(), Prioridad.NO_URGENTE, new Date());
//        Pedido pedido2 = new Pedido(EstadoPedido.ENTREGADA, new Date(),
//                new Date(), Prioridad.URGENTE, new Date());
//        DetallePedido detallePedido = new DetallePedido(0, 0);
//        Factura factura = new Factura(1, new Date(), 0);
//
//        Usuario usuario = new Usuario("Juan", "123456789", ""
//                + "juan@example.com", EstadoCuenta.ACTIVO,
//                new Date(), "juanj", "contraseña",
//                "Pérez", "Gómez", TipoUsuario.ADMINISTRADOR);
//        pedidoDAO pedidodao = new pedidoMYSQL();
//        detallePedidoDAO detalledao = new detallePedidoMYSQL();
        // detallePedido.getListaProductos().add(producto);
        //pedido.getListaDetallesPedidos().add(detallePedido);

//        // detallePedido.getListaProductos().add(producto);
//        pedido.getListaDetallesPedidos().add(detallePedido);

        //////////////////////////////////////////
//        productoDAO productodao = new productoMYSQL();
//       // TipoProducto categoria = new TipoProducto(1, "drink", "fino");
////Almacen almacen =new Almacen("sdg");
//        Producto producto = new Producto( "Manzana", "Manzanas frescas",
//                1.50, 10,new Almacen(),new TipoProducto());
//        System.out.println("el id es de insertado"+productodao.insertar(producto));
//
//
////        Producto producto = new Producto(1, "Manzana", "Manzanas frescas",
////                categoria, 1.50, 10, EstadoProducto.ACTIVO);
//        productodao.insertar(producto);
//        pedido.setFactura(factura);
////        detallePedido.setProducto(producto);
//        
//        //Añadir Agregar
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
/////////////////  productos///////////////////////////////////
////////////////////////////////////////////////////////////////        
  

       
//        productoDAO productodao = new productoMYSQL();

//        Producto producto = new Producto("Manzana", "Manzanas frescas",
//                1.50, 10, new Almacen(), new TipoProducto());
//       System.out.println("el id es de insertado" + productodao.insertar(producto));
////
//        productodao.insertar(producto);
//
//       ArrayList<Producto> productos = new productoMYSQL().listar();
//        for (Producto item : productos) {
//            System.out.println(item.getNombre());
//            System.out.println(item.getDescripcion());
//
//            System.out.println();
//        }
//
//        producto.setNombre("NARANJA");
//        producto.setStock(20);
//        producto.setEstadoProducto(EstadoProducto.DESCONTINUADO);
//        producto.getTipoProducto().setIdTipoProducto(1);
//        producto.getAlmacen().setIdAlmacen(1);
//
//        resultado = productodao.actualizar(producto);
//        if (resultado != 0) {
//            System.out.println("Se ha modificado con exito");
//        }
//
//        productodao.eliminar(producto.getCodigo());
//
//        ArrayList<Producto> productoss = new productoMYSQL().listar();
//        for (Producto item : productoss) {
//            System.out.print(item.getNombre() + " ");
//            System.out.print(item.getDescripcion());
//
//            System.out.println(item.getEstadoProducto());
//        }


/////////////////////////////////////////////////////
    }

}

