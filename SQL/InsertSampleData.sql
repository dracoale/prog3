INSERT INTO Almacen (direccion, estadoAlmacen) VALUES ('Av. Javier Prado Este 123, Lima', 'ACTIVO');
INSERT INTO Almacen (direccion, estadoAlmacen) VALUES ('Jr. de la Unión 456, Lima', 'ACTIVO');
INSERT INTO Almacen (direccion, estadoAlmacen) VALUES ('Av. Arequipa 789, Lima', 'ACTIVO');

INSERT INTO TipoProducto (nombre, descripcion, estadoTipoProducto) VALUES ('Lácteos', 'Productos lácteos como leche, queso, yogur, etc.', 'ACTIVO');
INSERT INTO TipoProducto (nombre, descripcion, estadoTipoProducto) VALUES ('Menestras', 'Productos como frijoles, lentejas, garbanzos, etc.', 'ACTIVO');
INSERT INTO TipoProducto (nombre, descripcion, estadoTipoProducto) VALUES ('Carnes', 'Productos cárnicos frescos y procesados como pollo, carne de res, embutidos, etc.', 'ACTIVO');
INSERT INTO TipoProducto (nombre, descripcion, estadoTipoProducto) VALUES ('Frutas y Verduras', 'Frutas y verduras frescas y de temporada.', 'ACTIVO');
INSERT INTO TipoProducto (nombre, descripcion, estadoTipoProducto) VALUES ('Bebidas', 'Bebidas no alcohólicas como jugos, refrescos, agua embotellada, etc.', 'ACTIVO');

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