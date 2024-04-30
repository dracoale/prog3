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

INSERT INTO FormaDePago (descripcion, idTipoPago) VALUES ('Pago en efectivo', 1);
INSERT INTO FormaDePago (descripcion, idTipoPago) VALUES ('Transferencia bancaria', 2);
INSERT INTO FormaDePago (descripcion, idTipoPago) VALUES ('Pago con tarjeta', 1);