package pe.edu.pucp.tienda.main;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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
import pe.edu.pucp.tienda.producto.model.Producto;
import pe.edu.pucp.tienda.producto.model.TipoProducto;
import pe.edu.pucp.tienda.usuario.model.EstadoCuenta;
import pe.edu.pucp.tienda.usuario.model.TipoUsuario;
import pe.edu.pucp.tienda.usuario.model.Usuario;
import pe.edu.pucp.tienda.usuario.dao.UsuarioDAO;
import pe.edu.pucp.tienda.usuario.mysql.UsuarioMYSQL;
import pe.edu.pucp.tienda.producto.dao.productoDAO;
import pe.edu.pucp.tienda.producto.dao.productoPruebaDAO;
import pe.edu.pucp.tienda.producto.model.Almacen;
import pe.edu.pucp.tienda.producto.model.EstadoProducto;
import pe.edu.pucp.tienda.producto.model.ProductoPrueba;
import pe.edu.pucp.tienda.producto.mysql.productoMYSQL;
import pe.edu.pucp.tienda.producto.mysql.productoPruebaMYSQL;
import pe.edu.pucp.tienda.usuario.dao.ClienteIndividualDAO;
import pe.edu.pucp.tienda.usuario.dao.ClienteJuridicoDAO;
import pe.edu.pucp.tienda.usuario.mysql.ClienteIndividualMYSQL;
import pe.edu.pucp.tienda.usuario.model.ClienteIndividual;
import pe.edu.pucp.tienda.usuario.model.ClienteJuridico;
import pe.edu.pucp.tienda.usuario.mysql.ClienteJuridicoMYSQL;

public class Principal {
//    public static byte[] leerImagen(String ruta) {
//        File file = new File(ruta);
//        byte[] imagen = new byte[(int) file.length()];
//
//        try (FileInputStream fis = new FileInputStream(file)) {
//            fis.read(imagen);
//            System.out.println("Imagen leída correctamente de " + ruta);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return imagen;
//    }
//
//    // Método para escribir una imagen en un archivo
//    public static void escribirImagen(String ruta, byte[] imagen) {
//        if (imagen == null) {
//            System.out.println("El array de bytes de la imagen es nulo. Verifica la recuperación de la imagen.");
//            return;
//        }
//
//        try (FileOutputStream fos = new FileOutputStream(ruta)) {
//            fos.write(imagen);
//            System.out.println("Imagen escrita correctamente en " + ruta);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    public static void main(String[] args) {
// Prueba Pedidos Modificados en SQL
//
//
//    pedidoDAO pedidodao = new pedidoMYSQL();
//    Pedido pedidoprueba = new Pedido();
//    pedidoprueba.setIdPedido(1);
//    pedidoprueba.setEstado(EstadoPedido.ENTREGADA);
//    pedidoprueba.setPrioridad(Prioridad.NO_URGENTE);
//    pedidoprueba.setFechaEntrega(new Date());
//    pedidodao.eliminar(5);
//    ArrayList<Pedido> pedidos= new ArrayList<Pedido>();
//        pedidos=pedidodao.listar();
//        for(Pedido ped: pedidos){
//            System.out.println(ped.getIdPedido());
//        }
////  Prueba Usuarios Modificados en SQL
//
//
//    UsuarioDAO usuariodao = new UsuarioMYSQL();
//    ClienteIndividualDAO clienteinddao = new ClienteIndividualMYSQL();
//    ClienteJuridicoDAO clientejurdao = new ClienteJuridicoMYSQL();
//    Usuario usuarioprueba= new Usuario();
//    ClienteIndividual clienteInd = new ClienteIndividual();
//    ClienteJuridico clienteJur = new ClienteJuridico();
//    usuariodao.eliminarUsuario(1);
//    ArrayList<Usuario> usuarios= new ArrayList<Usuario>();
//        usuarios=usuariodao.ListaUsuarioXTipo("ADMINISTRADOR");
//        for(Usuario user: usuarios){
//            System.out.println(user.getNombre());
//        }
//    usuarioprueba.setIdUsuario(4);
//    usuarioprueba.setNombre("Deivy");
//    usuarioprueba.setGenero('M');
//    usuarioprueba.setTelefono("123456789");
//    usuarioprueba.setCorreo("david1234@example.pucp.edu");
//    usuarioprueba.setFechaNacimiento(new Date());
//    usuarioprueba.setNombreUsuario("xDdavidXx");
//    usuarioprueba.setApellidoPaterno("Juarez");
//    usuarioprueba.setApellidoMaterno("Manzanal");
//    usuarioprueba.setContraseña("pollito1234");
//    usuariodao.ActualizaUsuarioPersona(usuarioprueba);
//    clienteInd.setIdUsuario(5);
//    clienteInd.setNombre("Pepe");
//    clienteInd.setGenero('M');
//    clienteInd.setTelefono("12312312");
//    clienteInd.setCorreo("joselito123@example.pucp.edu");
//    clienteInd.setFechaNacimiento(new Date());
//    clienteInd.setNombreUsuario("Jose1929");
//    clienteInd.setApellidoPaterno("Montes");
//    clienteInd.setApellidoMaterno("Norte");
//    clienteInd.setContraseña("joselito12312");
//    clienteInd.setDNI("123912312");
//    usuariodao.ActualizaUsuarioPersona(clienteInd);
//    clienteJur.setIdUsuario(6);
//    clienteJur.setNombre("Marcia");
//    clienteJur.setGenero('F');
//    clienteJur.setTelefono("12312321");
//    clienteJur.setCorreo("marcia1929@example.pucp.edu");
//    clienteJur.setFechaNacimiento(new Date());
//    clienteJur.setNombreUsuario("marc929");
//    clienteJur.setApellidoPaterno("Morales");
//    clienteJur.setApellidoMaterno("Duarez");
//    clienteJur.setContraseña("marcia1929");
//    clienteJur.setRUC("marciaRUC");
//    clienteJur.setNombreEmpresa("marcia S.A.C.");
//    clientejurdao.actualizar(clienteJur);
//        // Ruta de la imagen de prueba
//        String rutaImagen = "C:/Users/james/OneDrive/Escritorio/Imagenes/pickeosnack.jpg";
//        byte[] foto = leerImagen(rutaImagen);
//        if (foto == null || foto.length == 0) {
//            System.out.println("No se pudo leer la imagen. Verifique la ruta y el archivo.");
//            return;
//        }
//        // Crear un objeto GrupoInvestigacion
//        Producto prod = new Producto();
//        Almacen alma = new Almacen();
//        TipoProducto tipo = new TipoProducto();
//        tipo.setIdTipoProducto(6);
//        alma.setIdAlmacen(1);
//        prod.setCodigo(5);
//        prod.setDescripcion("2KG");
//        prod.setNombre("Piqueos Snack");
//        prod.setPrecio(10);
//        prod.setStock(200);
//        prod.setAlmacen(alma);
//        prod.setEstadoProducto(EstadoProducto.ACTIVO);
//        prod.setTipoProducto(tipo);
//        prod.setFoto(foto);
//
//        // Guardar el grupo de investigación en la base de datos
//        productoDAO dao = new productoMYSQL();
//        dao.actualizar(prod);
//
//        // Recuperar el grupo de investigación de la base de datos
//        Producto prodrecuperado = dao.buscarProducto(5);
//        System.out.println("Foto length: " + prodrecuperado.getFoto().length);
//        if (prodrecuperado == null) {
//            System.out.println("No se pudo recuperar el producto de la base de datos.");
//            return;
//        }
//
//        if (prodrecuperado.getFoto() == null) {
//            System.out.println("No se pudo recuperar la imagen de la base de datos.");
//            return;
//        }
//        // Guardar la imagen recuperada en un archivo
//        escribirImagen("C:/Users/james/OneDrive/Escritorio/Imagenes/imagen_recuperada.jpg", prodrecuperado.getFoto());

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
//Prueba Busqueda Productos
//
//      
//           productoDAO productodao = new productoMYSQL();
//           ArrayList<Producto> productos = productodao.listarXNombre("KG");
//            for (Producto item : productos) {
//                System.out.println(item.getNombre());
//                System.out.println(item.getDescripcion());
//
//                System.out.println();
//            }
//
//
//Prueba Busqueda Usuarios
//
//
//           UsuarioDAO usuariodao = new UsuarioMYSQL();
//           ArrayList<Usuario> usuarios = usuariodao.ListarUsuariosXNombre("P");
//            for (Usuario p : usuarios) {
//                System.out.println(p.getNombreCompleto());
//                System.out.println(p.getNombreUsuario());
//
//                System.out.println();
//            }
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
    }

}

