INSERT INTO Almacen (direccion, estadoAlmacen) VALUES ('Av. Javier Prado Este 123, Lima', 'ACTIVO');
INSERT INTO Almacen (direccion, estadoAlmacen) VALUES ('Jr. de la Unión 456, Lima', 'ACTIVO');
INSERT INTO Almacen (direccion, estadoAlmacen) VALUES ('Av. Arequipa 789, Lima', 'ACTIVO');

INSERT INTO TipoProducto (nombre, descripcion, estadoTipoProducto) VALUES ('Lácteos', 'Productos lácteos como leche, queso, yogur, etc.', 'ACTIVO');
INSERT INTO TipoProducto (nombre, descripcion, estadoTipoProducto) VALUES ('Menestras', 'Productos como frijoles, lentejas, garbanzos, etc.', 'ACTIVO');
INSERT INTO TipoProducto (nombre, descripcion, estadoTipoProducto) VALUES ('Carnes', 'Productos cárnicos frescos y procesados como pollo, carne de res, embutidos, etc.', 'ACTIVO');
INSERT INTO TipoProducto (nombre, descripcion, estadoTipoProducto) VALUES ('Frutas y Verduras', 'Frutas y verduras frescas y de temporada.', 'ACTIVO');
INSERT INTO TipoProducto (nombre, descripcion, estadoTipoProducto) VALUES ('Bebidas', 'Bebidas no alcohólicas como jugos, refrescos, agua embotellada, etc.', 'ACTIVO');
INSERT INTO TipoProducto (nombre, descripcion, estadoTipoProducto) VALUES ('Piqueos', 'Productos tipo piqueos.', 'ACTIVO');

CALL InsertaUsuarioNatural(@idUsuario,'Juan','M','123456789','juan@example.com','2014-04-29',
'juanito','contrasena123','Perez','Gonzalez','12345678A');
CALL InsertaUsuarioJuridico(@idUsuario,'Pablo','M','12321312','xXpabloXx@example.com','2025-04-27',
'pablomarmol','1232','Marmol','Guinea','asdasdRUC','ASD S.A.');
CALL InsertaAdministrador(@idUsuario,'Ana','F','1232132111','ann@example.com','2011-08-10',
'anita','maxwynn','Fernandez','Villalobos');
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
CALL ActualizaPedido(1,'EN_CAMINO','URGENTE');
CALL buscarFactura(1);
CALL ListaUsuarioXTipo('USER_JURIDICO');
CALL ActualizaUsuarioPersona(1,'Mario','M','123456789','marito@example.com','2010-04-29',
'juancho','contrasena321','Perez','Gonzalez');
CALL ActualizaUsuarioJuridico(2,'Jaime','M','123231123','jaime@example.com','2008-04-29',
'jaimexdd','contra','Marmol','Portilla','fdfdfdfRUC','jaimeCorp S.A.');
CALL EliminaUsuario(2);
CALL ActualizaPedido(1,'PROCESADA','NO_URGENTE');

#INSERT INTO ProductoPrueba (nombre, descripcion,precio,stock) VALUES ('Manzana', 'roja',10,5);
#SELECT nombre, LENGTH(foto) FROM ProductoPrueba WHERE idProducto = 4;