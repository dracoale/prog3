INSERT INTO Almacen (direccion, estadoAlmacen) VALUES ('Av. Javier Prado Este 123, Lima', 'ACTIVO');
INSERT INTO Almacen (direccion, estadoAlmacen) VALUES ('Jr. de la Unión 456, Lima', 'ACTIVO');
INSERT INTO Almacen (direccion, estadoAlmacen) VALUES ('Av. Arequipa 789, Lima', 'ACTIVO');

INSERT INTO TipoProducto (nombre, descripcion, estadoTipoProducto) VALUES ('Lácteos', 'Productos lácteos como leche, queso, yogur, etc.', 'ACTIVO');
INSERT INTO TipoProducto (nombre, descripcion, estadoTipoProducto) VALUES ('Menestras', 'Productos como frijoles, lentejas, garbanzos, etc.', 'ACTIVO');
INSERT INTO TipoProducto (nombre, descripcion, estadoTipoProducto) VALUES ('Carnes', 'Productos cárnicos frescos y procesados como pollo, carne de res, embutidos, etc.', 'ACTIVO');
INSERT INTO TipoProducto (nombre, descripcion, estadoTipoProducto) VALUES ('Frutas y Verduras', 'Frutas y verduras frescas y de temporada.', 'ACTIVO');
INSERT INTO TipoProducto (nombre, descripcion, estadoTipoProducto) VALUES ('Bebidas', 'Bebidas no alcohólicas como jugos, refrescos, agua embotellada, etc.', 'ACTIVO');


INSERT INTO Almacen (direccion) VALUES ('Av. Javier Prado Este 123, Lima');
INSERT INTO Almacen (direccion) VALUES ('Jr. de la Unión 456, Lima');
INSERT INTO Almacen (direccion) VALUES ('Av. Arequipa 789, Lima');

INSERT INTO TipoProducto (nombre, descripcion) VALUES ('Lácteos', 'Productos lácteos como leche, queso, yogur, etc.');
INSERT INTO TipoProducto (nombre, descripcion) VALUES ('Menestras', 'Productos como frijoles, lentejas, garbanzos, etc.');
INSERT INTO TipoProducto (nombre, descripcion) VALUES ('Carnes', 'Productos cárnicos frescos y procesados como pollo, carne de res, embutidos, etc.');
INSERT INTO TipoProducto (nombre, descripcion) VALUES ('Frutas y Verduras', 'Frutas y verduras frescas y de temporada.');
INSERT INTO TipoProducto (nombre, descripcion) VALUES ('Bebidas', 'Bebidas no alcohólicas como jugos, refrescos, agua embotellada, etc.');
CALL InsertaUsuarioNatural(
    @idUsuario,
    'Juan',
    '123456789',
    'juan@example.com',
    '2024-04-29',
    '2024-04-29',
    'juanito',
    'contrasena123',
    'Perez',
    'Gonzalez',
    '12345678A'
);
CALL InsertaUsuarioNatural(
    @idUsuario,
    'Pablo',
    '12321312',
    'xXpabloXx@example.com',
    '2024-04-27',
    '2024-04-27',
    'pablomarmol',
    '1232',
    'Marmol',
    'Guinea',
    '1234567B'
);
CALL InsertaPedido(@idPedido,'2024-03-29','2024-04-29','URGENTE','2024-05-29',1);
CALL InsertaProducto(
    @idProducto,
    'Camisa',
    'Camisa de algodón con estampado de rayas',
    29.99,
    100,
    1,
    1
);
CALL InsertaProducto(
    @idProducto,
    'Gaseosa INCA KOLA',
    '1L',
    25.99,
    100,
    1,
    5
);
CALL InsertaProducto(
    @idProducto,
    'Gaseosa INCA KOLA',
    '2L',
    29.99,
    100,
    1,
    5
);
CALL InsertaProducto(
    @idProducto,
    'Gaseosa INCA KOLA',
    '3L',
    35.99,
    100,
    1,
    5
);
CALL InsertaProducto(
    @idProducto,
    'Piqueos Snack',
    '2KG',
    35.99,
    100,
    1,
    5
);
CALL InsertaOferta(
	@idOferta,
    'Descuento de verano 20%',
    20,
    '2024-03-29',
    '2024-04-29',
    1
);
SELECT @idOferta AS idOferta;


SELECT @idUsuario AS idUsuario;



SELECT @idProducto AS idProducto;
CALL ActualizaPedido(1,'CANCELADA','2024-04-29','NO_URGENTE');
CALL ListaPedidos();
CALL EliminaPedido(1);
CALL LISTAR_PRODUCTOS_POR_NOMBRE('KG');
CALL ListarUsuariosXNombre('Juan');
CALL EliminaUsuarioNatural(1);
CALL ListaProductosXTipo(5);
CALL LoginUsuario('xXpabloXx@example.com','dsa');
CALL ListaDetallesDePedido(3);
CALL buscarProducto(5);
CALL InsertaDetallePedido(@idDetallePedido,3,5,4);