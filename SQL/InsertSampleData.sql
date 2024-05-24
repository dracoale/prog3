INSERT INTO Almacen (direccion, estadoAlmacen) VALUES ('Av. Javier Prado Este 123, Lima', 'ACTIVO');
INSERT INTO Almacen (direccion, estadoAlmacen) VALUES ('Jr. de la Unión 456, Lima', 'ACTIVO');
INSERT INTO Almacen (direccion, estadoAlmacen) VALUES ('Av. Arequipa 789, Lima', 'ACTIVO');

INSERT INTO TipoProducto (nombre, descripcion, estadoTipoProducto) VALUES ('Lácteos', 'Productos lácteos como leche, queso, yogur, etc.', 'ACTIVO');
INSERT INTO TipoProducto (nombre, descripcion, estadoTipoProducto) VALUES ('Menestras', 'Productos como frijoles, lentejas, garbanzos, etc.', 'ACTIVO');
INSERT INTO TipoProducto (nombre, descripcion, estadoTipoProducto) VALUES ('Carnes', 'Productos cárnicos frescos y procesados como pollo, carne de res, embutidos, etc.', 'ACTIVO');
INSERT INTO TipoProducto (nombre, descripcion, estadoTipoProducto) VALUES ('Frutas y Verduras', 'Frutas y verduras frescas y de temporada.', 'ACTIVO');
INSERT INTO TipoProducto (nombre, descripcion, estadoTipoProducto) VALUES ('Bebidas', 'Bebidas no alcohólicas como jugos, refrescos, agua embotellada, etc.', 'ACTIVO');
INSERT INTO EstadoCuenta (descripcion) VALUES ('ACTIVO');
INSERT INTO EstadoCuenta (descripcion) VALUES ('DESACTIVADO');
INSERT INTO EstadoCuenta (descripcion) VALUES ('SUSPENDIDO');

INSERT INTO TipoPago (descripcion) VALUES ('VISA');
INSERT INTO TipoPago (descripcion) VALUES ('PAYPAL');
INSERT INTO TipoPago (descripcion) VALUES ('CUPON');

INSERT INTO Prioridad (descripcion) VALUES ('URGENTE');
INSERT INTO Prioridad (descripcion) VALUES ('NO URGENTE');

INSERT INTO EstadoPedido (descripcion) VALUES ('ENTREGADA');
INSERT INTO EstadoPedido (descripcion) VALUES ('PROCESADA');
INSERT INTO EstadoPedido (descripcion) VALUES ('CANCELADA');
INSERT INTO EstadoPedido (descripcion) VALUES ('EN_CAMINO');

INSERT INTO EstadoProducto (descripcion) VALUES ('DESCONTINUADO');
INSERT INTO EstadoProducto (descripcion) VALUES ('ACTIVO');
INSERT INTO EstadoProducto (descripcion) VALUES ('AGOTADO');


INSERT INTO Almacen (direccion) VALUES ('Av. Javier Prado Este 123, Lima');
INSERT INTO Almacen (direccion) VALUES ('Jr. de la Unión 456, Lima');
INSERT INTO Almacen (direccion) VALUES ('Av. Arequipa 789, Lima');

INSERT INTO TipoProducto (nombre, descripcion) VALUES ('Lácteos', 'Productos lácteos como leche, queso, yogur, etc.');
INSERT INTO TipoProducto (nombre, descripcion) VALUES ('Menestras', 'Productos como frijoles, lentejas, garbanzos, etc.');
INSERT INTO TipoProducto (nombre, descripcion) VALUES ('Carnes', 'Productos cárnicos frescos y procesados como pollo, carne de res, embutidos, etc.');
INSERT INTO TipoProducto (nombre, descripcion) VALUES ('Frutas y Verduras', 'Frutas y verduras frescas y de temporada.');
INSERT INTO TipoProducto (nombre, descripcion) VALUES ('Bebidas', 'Bebidas no alcohólicas como jugos, refrescos, agua embotellada, etc.');
CALL InsertaPedido(@idPedido,'2024-03-29','2024-04-29','URGENTE','2024-05-29',1);
CALL InsertaOferta(
	@idOferta,
    'Descuento de verano 20%',
    20,
    '2024-03-29',
    '2024-04-29',
    3
);
SELECT @idOferta AS idOferta;

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
SELECT @idUsuario AS idUsuario;


CALL InsertaProducto(
    @idProducto,
    'Camisa',
    'Camisa de algodón con estampado de rayas',
    29.99,
    100,
    1,
    1
);
SELECT @idProducto AS idProducto;
CALL ActualizaPedido(2,'CANCELADA','2024-04-29','NO_URGENTE');
CALL ListaPedidos();
CALL EliminaPedido(2);