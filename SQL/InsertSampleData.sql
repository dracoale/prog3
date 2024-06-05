INSERT INTO Almacen (direccion, estadoAlmacen) VALUES ('Av. Javier Prado Este 123, Lima', 'ACTIVO');
INSERT INTO Almacen (direccion, estadoAlmacen) VALUES ('Jr. de la Unión 456, Lima', 'ACTIVO');
INSERT INTO Almacen (direccion, estadoAlmacen) VALUES ('Av. Arequipa 789, Lima', 'ACTIVO');

INSERT INTO TipoProducto (nombre, descripcion, estadoTipoProducto) VALUES ('Lácteos', 'Productos lácteos como leche, queso, yogur, etc.', 'ACTIVO');
INSERT INTO TipoProducto (nombre, descripcion, estadoTipoProducto) VALUES ('Menestras', 'Productos como frijoles, lentejas, garbanzos, etc.', 'ACTIVO');
INSERT INTO TipoProducto (nombre, descripcion, estadoTipoProducto) VALUES ('Carnes', 'Productos cárnicos frescos y procesados como pollo, carne de res, embutidos, etc.', 'ACTIVO');
INSERT INTO TipoProducto (nombre, descripcion, estadoTipoProducto) VALUES ('Frutas y Verduras', 'Frutas y verduras frescas y de temporada.', 'ACTIVO');
INSERT INTO TipoProducto (nombre, descripcion, estadoTipoProducto) VALUES ('Bebidas', 'Bebidas no alcohólicas como jugos, refrescos, agua embotellada, etc.', 'ACTIVO');
INSERT INTO TipoProducto (nombre, descripcion, estadoTipoProducto) VALUES ('Piqueos', 'Productos tipo piqueos.', 'ACTIVO');

CALL InsertaUsuarioNatural(@idUsuario,'Juan','M','123456789','juan@example.com',
'Av. Rosas','2014-04-29',
'juanito','contrasena123','Perez','Gonzalez','12345678A');
CALL InsertaUsuarioJuridico(@idUsuario,'Pablo','M','12321312','xXpabloXx@example.com',
'Av. Arequipa40','2025-04-27',
'pablomarmol','1232','Marmol','Guinea','asdasdRUC','ASD S.A.');
CALL InsertaAdministrador(@idUsuario,'Ana','F','1232132111','ann@example.com',
'Av. JavierPrado 322','2011-08-10',
'anita','maxwynn','Fernandez','Villalobos');
CALL InsertaUsuarioNatural(@idUsuario,'Pablo','M','9795123213','pablomarmolXXxX@example.com',
'Av. SiempreViva123','2009-04-30',
'BilletePuertas123','1232','Marmol','Benites','123213BF');
CALL InsertaAdministrador(@idUsuario,'Billete','M','999999','billetinportas@example.com',
'Av. Del Carmen4321','2000-10-10',
'BilletePuertas123','contraseña9','Puertas','Borjas');
CALL InsertaUsuarioJuridico(@idUsuario,'Norma','F','111111','normax@example.com',
'Av. Anonimo','2020-04-27',
'normanda','1234','Veramendi','Guinea','asdsaRUC','Norma S.A.');
CALL InsertaPedido(@idPedido,'URGENTE','2024-05-29',1);
CALL InsertaProducto(@idProducto,'Camisa','Camisa de algodón con estampado de rayas',
29.99,100,1,1,0);
CALL InsertaProducto(@idProducto,'Gaseosa INCA KOLA','1L',25.99,
100,1,5,0);
CALL InsertaProducto(@idProducto,'Gaseosa INCA KOLA','2L',
29.99,100,1,5,0);
CALL InsertaProducto(@idProducto,'Gaseosa INCA KOLA',
'3L',35.99,100,1,5,0);
CALL InsertaProducto(@idProducto,'Piqueos Snack','2KG',
35.99,100,1,5,0);
CALL InsertaOferta(@idOferta,'Descuento de verano 20%',20,
'2024-03-29','2024-04-29',1);
CALL InsertaOferta(@idOferta,'Descuento de invierno',15,
'2024-05-29','2024-06-02',4);
CALL InsertaOferta(@idOferta,'Descuento de otoño',10,
'2024-05-29','2024-06-03',3);

#CALL ActualizaPedido(1,'CANCELADA','2024-04-29','NO_URGENTE');
CALL ListaPedidos();
#CALL EliminaPedido(1);
CALL LISTAR_PRODUCTOS_POR_NOMBRE('KG');
CALL ListarUsuariosXNombre('Juan');
#CALL EliminaUsuarioNatural(1);
CALL ListaProductosXTipo(5);
CALL LoginUsuario('xXpabloXx@example.com','1234');
CALL ListaDetallesDePedido(3);
CALL buscarProducto(5);
CALL InsertaDetallePedido(@idDetallePedido,1,5,4);
#CALL ActualizaPedido(1,'EN_CAMINO','URGENTE');
CALL buscarFactura(1);
CALL ListaUsuarioXTipo('USER_JURIDICO');
CALL ActualizaUsuarioPersona(1,'Mar','M','123456789','marito@example.com','Av. Rosas',
'contrasena123','Perez','Gonzalez','nuevacontra');
CALL ActualizaUsuarioJuridico(6,'Jaime','M','123231123','jaime@example.com','Av. Arequipa30',
'1234','Marmol','Portilla','jaimeCorp S.A.','contrasenanueva');
#CALL EliminaUsuario(2);
CALL ActualizaPedido(1,'PROCESADA','NO_URGENTE');
CALL ListaPedidosXUsuario(1);
CALL InsertaDetallePedido(@idDetallePedido,1,4,2);
CALL InsertaDetallePedido(@idDetallePedido,1,3,1);
CALL InsertaDetallePedido(@idDetallePedido,1,2,3);
CALL InsertaDetallePedido(@idDetallePedido,1,1,1);
#INSERT INTO ProductoPrueba (nombre, descripcion,precio,stock) VALUES ('Manzana', 'roja',10,5);
#SELECT nombre, LENGTH(foto) FROM ProductoPrueba WHERE idProducto = 4;
CALL ActualizaPedido(1,'EN_CAMINO','URGENTE');
CALL top3_productos_mas_vendidos();
CALL EliminaDetallePedido(6);
CALL top3_productos_mas_vendidos();
CALL InsertaPedido(@idPedido,'URGENTE','2024-04-29',2);
CALL InsertaDetallePedido(@idDetallePedido,2,5,1);
CALL InsertaDetallePedido(@idDetallePedido,2,4,1);
CALL InsertaDetallePedido(@idDetallePedido,2,3,1);
CALL InsertaDetallePedido(@idDetallePedido,2,2,1);
CALL InsertaDetallePedido(@idDetallePedido,2,1,5);
CALL ActualizaPedido(2,'EN_CAMINO','URGENTE');
CALL buscarOfertasXProducto(3);
CALL calcular_crecimiento_ventas(2,2024,5,@crecimiento);
Select @crecimiento;
CALL MostrarUsuariosAAdmin();
CALL BuscarUsuarioXId(4);