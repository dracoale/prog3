DELIMITER $$
CREATE PROCEDURE InsertaUsuarioNatural(
    OUT p_idUsuario INT,
    IN p_nombre VARCHAR(100),
    IN p_telefono VARCHAR(20),
    IN p_correo VARCHAR(100),
    IN p_fechaRegistro DATE,
    IN p_fechaCreacion DATE,
    IN p_nombreUsuario VARCHAR(100),
    IN p_contrasena VARCHAR(50),
    IN p_apellidoPaterno VARCHAR(100),
    IN p_apellidoMaterno VARCHAR(100),
    IN p_DNI VARCHAR(20)
)
BEGIN
    INSERT INTO Usuario(nombre, telefono, correo, fechaRegistro, estadoCuenta, tipoUsuario, fechaCreacion, nombreUsuario, contrasena, apellidoPaterno, apellidoMaterno, DNI)
    VALUES (p_nombre, p_telefono, p_correo, p_fechaRegistro, 'ACTIVO', 'USER_NATURAL', p_fechaCreacion, p_nombreUsuario, p_contrasena, p_apellidoPaterno, p_apellidoMaterno, p_DNI);
    SET p_idUsuario = @@last_insert_id;
END$$




CREATE PROCEDURE ActualizaUsuarioNatural(
    IN p_idUsuario INT,
    IN p_nombre VARCHAR(100),
    IN p_telefono VARCHAR(20),
    IN p_correo VARCHAR(100),
    IN p_nombreUsuario VARCHAR(100),
    IN p_contrasena VARCHAR(50),
    IN p_apellidoPaterno VARCHAR(100),
    IN p_apellidoMaterno VARCHAR(100)
)
BEGIN
    UPDATE Usuario
    SET nombre = p_nombre, telefono = p_telefono, correo = p_correo, nombreUsuario = p_nombreUsuario, contrasena = p_contrasena, apellidoPaterno = p_apellidoPaterno, apellidoMaterno = p_apellidoMaterno
    WHERE idUsuario = p_idUsuario;
END$$



CREATE PROCEDURE EliminaUsuarioNatural(
    IN p_idUsuario INT
)
BEGIN
    Update Usuario SET estadoCuenta='DESACTIVADO' WHERE idUsuario = p_idUsuario;
END$$


CREATE PROCEDURE ListaUsuariosNaturales()
BEGIN
    SELECT nombre, telefono, correo, fechaRegistro, estadoCuenta, tipoUsuario, fechaCreacion, nombreUsuario, apellidoPaterno, apellidoMaterno
    FROM Usuario
    WHERE tipoUsuario='USER_NATURAL';
END$$








CREATE PROCEDURE InsertaUsuarioJuridico(
    OUT p_idUsuario INT,
    IN p_nombre VARCHAR(100),
    IN p_telefono VARCHAR(20),
    IN p_correo VARCHAR(100),
    IN p_fechaRegistro DATE,
    IN p_fechaCreacion DATE,
    IN p_nombreUsuario VARCHAR(100),
    IN p_contrasena VARCHAR(50),
    IN p_apellidoPaterno VARCHAR(100),
    IN p_apellidoMaterno VARCHAR(100),
    IN p_RUC VARCHAR(20),
    IN p_nombreEmpresa VARCHAR(150)
)
BEGIN
    INSERT INTO Usuario(nombre, telefono, correo, fechaRegistro, estadoCuenta, tipoUsuario, fechaCreacion, nombreUsuario, contrasena, apellidoPaterno, apellidoMaterno, RUC, nombreEmpresa)
    VALUES (p_nombre, p_telefono, p_correo, p_fechaRegistro, 'ACTIVO', 'USER_JURIDICO', p_fechaCreacion, p_nombreUsuario, p_contrasena, p_apellidoPaterno, p_apellidoMaterno, p_RUC, p_nombreEmpresa);
    SET p_idUsuario = @@last_insert_id;
END$$




CREATE PROCEDURE ActualizaUsuarioJuridico(
    IN p_idUsuario INT,
    IN p_nombre VARCHAR(100),
    IN p_telefono VARCHAR(20),
    IN p_correo VARCHAR(100),
    IN p_nombreUsuario VARCHAR(100),
    IN p_contrasena VARCHAR(50),
    IN p_apellidoPaterno VARCHAR(100),
    IN p_apellidoMaterno VARCHAR(100)
)
BEGIN
    UPDATE Usuario
    SET nombre = p_nombre, telefono = p_telefono, correo = p_correo, nombreUsuario = p_nombreUsuario, contrasena = p_contrasena, apellidoPaterno = p_apellidoPaterno, apellidoMaterno = p_apellidoMaterno
    WHERE idUsuario = p_idUsuario;
END$$



CREATE PROCEDURE EliminaUsuarioJuridico(
    IN p_idUsuario INT
)
BEGIN
    Update Usuario SET estadoCuenta='DESACTIVADO' WHERE idUsuario = p_idUsuario;
END$$


CREATE PROCEDURE ListaUsuariosJuridicos()
BEGIN
    SELECT nombre, telefono, correo, fechaRegistro, estadoCuenta, tipoUsuario, fechaCreacion, nombreUsuario, apellidoPaterno, apellidoMaterno 
    FROM Usuario
    WHERE tipoUsuario='USER_JURIDICO';
END$$










CREATE PROCEDURE InsertaAdministrador(
    OUT p_idUsuario INT,
    IN p_nombre VARCHAR(100),
    IN p_telefono VARCHAR(20),
    IN p_correo VARCHAR(100),
    IN p_fechaRegistro DATE,
    IN p_fechaCreacion DATE,
    IN p_nombreUsuario VARCHAR(50),
    IN p_contrasena VARCHAR(100),
    IN p_apellidoPaterno VARCHAR(100),
    IN p_apellidoMaterno VARCHAR(100)
)
BEGIN
    INSERT INTO Usuario(nombre, telefono, correo, fechaRegistro, estadoCuenta, tipoUsuario, fechaCreacion, nombreUsuario, contrasena, apellidoPaterno, apellidoMaterno)
    VALUES (p_descripcion, p_nombre, p_telefono, p_correo, p_fechaRegistro, 'ACTIVO', 'ADMINISTRADOR', p_fechaCreacion, p_nombreUsuario, p_contrasena, p_apellidoPaterno, p_apellidoMaterno);
    SET p_idUsuario = @@last_insert_id;
END$$



CREATE PROCEDURE ActualizaAdministrador(
    IN p_idUsuario INT,
    IN p_descripcion VARCHAR(200),
    IN p_nombre VARCHAR(100),
    IN p_telefono VARCHAR(20),
    IN p_correo VARCHAR(100),
    IN p_idEstadoCuenta TINYINT,
    IN p_nombreUsuario VARCHAR(50),
    IN p_contrasena VARCHAR(100),
    IN p_apellidoPaterno VARCHAR(100),
    IN p_apellidoMaterno VARCHAR(100)
)
BEGIN
    UPDATE Usuario
    SET descripcion = p_descripcion,
        nombre = p_nombre,
        telefono = p_telefono,
        correo = p_correo,
        idEstadoCuenta = p_idEstadoCuenta,
        nombreUsuario = p_nombreUsuario,
        contrasena = p_contrasena,
        apellidoPaterno = p_apellidoPaterno,
        apellidoMaterno = p_apellidoMaterno
    WHERE idUsuario = p_idUsuario;
END$$



CREATE PROCEDURE EliminaAdministrador(
    IN p_idUsuario INT
)
BEGIN
    Update Usuario SET estadoCuenta='DESACTIVADO'
    WHERE idUsuario = p_idUsuario;
END$$



CREATE PROCEDURE ListaAdministradores()
BEGIN
    SELECT nombre, telefono, correo, fechaRegistro, estadoCuenta, fechaCreacion, nombreUsuario, contrasena, apellidoPaterno, apellidoMaterno 
    FROM Usuario
    WHERE tipoUsuario='USER_ADMINISTRADOR';
END$$






CREATE PROCEDURE InsertaProducto(
    OUT p_idProducto INT,
    IN p_nombre VARCHAR(150),
    IN p_descripcion VARCHAR(200),
    IN p_precio DOUBLE,
    IN p_stock INT,
    IN p_idAlmacen INT,
    IN p_idTipoProducto INT
)
BEGIN
    INSERT INTO Producto(nombre, descripcion, precio, stock, estadoProducto, idAlmacen, idTipoProducto)
    VALUES (p_nombre, p_descripcion, p_precio, p_stock, 'ACTIVO', p_idAlmacen, p_idTipoProducto);
    SET p_idProducto = @@last_insert_id;
END$$



CREATE PROCEDURE ActualizaProducto(
    IN p_idProducto INT,
    IN p_nombre VARCHAR(150),
    IN p_descripcion VARCHAR(200),
    IN p_precio DOUBLE,
    IN p_stock INT,
    IN p_estadoProducto ENUM('DESCONTINUADO', 'ACTIVO', 'AGOTADO'),
    IN p_idAlmacen INT,
    IN p_idTipoProducto INT
)
BEGIN
    UPDATE Producto
    SET nombre = p_nombre, descripcion = p_descripcion, precio = p_precio, stock = p_stock, estadoProducto = p_estadoProducto, idAlmacen = p_idAlmacen, idTipoProducto=p_idTipoProducto
    WHERE idProducto = p_idProducto;
END$$


CREATE PROCEDURE EliminaProducto(
    IN p_idProducto INT
)
BEGIN
    Update Producto SET estadoProducto='DESCONTINUADO' WHERE idProducto = p_idProducto;
END$$



CREATE PROCEDURE ListaProductos()
BEGIN
    SELECT nombre, descripcion, idTipoProducto, precio, estadoProducto FROM Producto;
END$$








CREATE PROCEDURE InsertaFactura(
    OUT p_idFactura INT,
    IN p_fecha DATE,
    IN p_total DOUBLE,
    IN p_tipoPago ENUM('VISA','PAYPAL','CUPON'),
	in p_estadoFactura ENUM('ACTIVO','DESACTIVADO')
)
BEGIN
    INSERT INTO Factura(fecha, total, tipoPago, estadoFactura)
    VALUES (p_fecha, p_total, p_tipoPago, 'ACTIVO');
    SET p_idFactura = @@last_insert_id;
END$$




CREATE PROCEDURE ActualizaFactura(
    IN p_idFactura INT,
    IN p_fecha DATE,
    IN p_total DOUBLE,
    IN p_tipoPago ENUM('VISA','PAYPAL','CUPON'),
	IN p_estadoFactura ENUM('ACTIVO','DESACTIVADO')
)
BEGIN
    UPDATE Factura
    SET fecha = p_fecha, total = p_total, tipoPago = p_tipoPago, estadoFactura=p_estadoFactura
    WHERE idFactura = p_idFactura;
END$$



CREATE PROCEDURE EliminaFactura(
    IN p_idFactura INT
)
BEGIN
    Update Factura SET estadoFactura='DESACTIVADO'
    WHERE idFactura = p_idFactura;
END$$


CREATE PROCEDURE ListaFacturas()
BEGIN
    SELECT fecha, total, tipoPago, estadoFactura FROM Factura;
END$$








CREATE PROCEDURE InsertaPedido(
    OUT p_idPedido INT,
    IN p_fechaPedido DATE,
    IN p_fechaCreacion DATE,
    IN p_prioridad ENUM('URGENTE', 'NO_URGENTE'),
    IN p_fechaEntrega DATE,
    IN p_idUsuario INT,
    IN p_idFactura INT
)
BEGIN
    INSERT INTO Pedido(estadoPedido, fechaPedido, fechaCreacion, prioridad, fechaEntrega, idUsuario, idFactura)
    VALUES ('PROCESADA', p_fechaPedido, p_fechaCreacion, p_prioridad, p_fechaEntrega, p_idUsuario, p_idFactura);
    SET p_idPedido = @@last_insert_id;
END$$



CREATE PROCEDURE ActualizaPedido(
    IN p_idPedido INT,
    IN p_estadoPedido ENUM('ENTREGADA', 'PROCESADA', 'CANCELADA','EN_CAMINO'),
    IN p_fechaPedido DATE,
    IN p_prioridad ENUM('URGENTE', 'NO_URGENTE')
)
BEGIN
    UPDATE Pedido
    SET estadoPedido = p_estadoPedido, fechaPedido = p_fechaPedido, prioridad = p_prioridad
    WHERE idPedido = p_idPedido;
END$$



CREATE PROCEDURE EliminaPedido(
    IN p_idPedido INT
)
BEGIN
    Update Pedido SET estadoPedido='CANCELADA'
    WHERE idPedido = p_idPedido;
END$$



CREATE PROCEDURE ListaPedidos()
BEGIN
    SELECT estadoPedido, fechaPedido, fechaCreacion, prioridad, fechaEntrega, idUsuario, idFactura FROM Pedido;
END$$




CREATE PROCEDURE InsertaDetallePedido (
    OUT p_idDetallePedido INT,
    IN p_idPedido INT,
    IN p_idProducto INT,
    IN p_cantidad INT,
    IN p_subtotal DOUBLE
)
BEGIN
    INSERT INTO DetallePedido (idPedido, idProducto, cantidad, subtotal, estadoDetallePedido)
    VALUES (p_idPedido, p_idProducto, p_cantidad, p_subtotal, 'ACTIVO');
    SET p_idDetallePedido = @@last_insert_id;
END $$


CREATE PROCEDURE ActualizaDetallePedido (
    IN p_idDetallePedido INT,
    IN p_cantidad INT,
    IN p_subtotal DOUBLE
)
BEGIN
    UPDATE DetallePedido
    SET cantidad = p_cantidad, subtotal = p_subtotal
    WHERE idDetallePedido = p_idDetallePedido;
END $$




CREATE PROCEDURE EliminaDetallePedido (
    IN p_idDetallePedido INT
)
BEGIN
    UPDATE DetallePedido
    SET estadoDetallePedido='DESACTIVO'
    WHERE idDetallePedido = p_idDetallePedido;
END $$


CREATE PROCEDURE ListaDetallePedidos()
BEGIN
    SELECT * FROM DetallePedido WHERE estadoDetallePedido='ACTIVO';
END $$





CREATE PROCEDURE InsertaAlmacen(
	OUT p_idAlmacen INT,
    IN p_direccion VARCHAR(150)
)
BEGIN
    INSERT INTO Almacen (direccion, estadoAlmacen) VALUES (p_direccion, 'ACTIVO');
    SET p_idAlmacen = @@last_insert_id;
END $$


CREATE PROCEDURE ActualizaAlmacen(
    IN p_idAlmacen INT,
    IN p_direccion VARCHAR(150)
)
BEGIN
    UPDATE Almacen SET direccion = p_direccion WHERE idAlmacen = p_idAlmacen;
END $$


CREATE PROCEDURE EliminaAlmacen(
    IN p_idAlmacen INT
)
BEGIN
    UPDATE Almacen SET estadoAlmacen = 'DESACTIVADO' WHERE idAlmacen = p_idAlmacen;
END $$


CREATE PROCEDURE ListaAlmacenes()
BEGIN
    SELECT * FROM Almacen WHERE estadoAlmacen='ACTIVO';
END $$





CREATE PROCEDURE InsertaTipoProducto(
	OUT p_idTipoProducto INT,
    IN p_nombre VARCHAR(100),
    IN p_descripcion VARCHAR(200),
    IN p_estadoTipoProducto ENUM('ACTIVO', 'DESACTIVADO')
)
BEGIN
    INSERT INTO TipoProducto (nombre, descripcion, estadoTipoProducto) VALUES (p_nombre, p_descripcion, p_estadoTipoProducto);
    SET p_idTipoProducto = @@last_insert_id;
END $$


CREATE PROCEDURE ActualizaTipoProducto(
    IN p_idTipoProducto INT,
    IN p_nombre VARCHAR(100),
    IN p_descripcion VARCHAR(200)
)
BEGIN
    UPDATE TipoProducto 
    SET nombre = p_nombre, descripcion = p_descripcion
    WHERE idTipoProducto = p_idTipoProducto;
END $$


CREATE PROCEDURE EliminaTipoProducto(
    IN p_idTipoProducto INT
)
BEGIN
    UPDATE TipoProducto SET estadoTipoProducto='DESACTIVADO'
    WHERE idTipoProducto = p_idTipoProducto;
END $$

CREATE PROCEDURE ListaTiposProducto()
BEGIN
    SELECT * FROM TipoProducto WHERE estadoTipoProducto='ACTIVO';
END $$








CREATE PROCEDURE InsertaOferta(
	OUT p_idOferta INT,
    IN p_descripcion VARCHAR(200),
    IN p_descuento DOUBLE,
    IN p_fechaInicio DATE,
    IN p_fechaFin DATE,
    IN p_idProducto INT
)
BEGIN
    INSERT INTO Oferta (descripcion, descuento, fechaInicio, fechaFin, idProducto, estadoOferta)
    VALUES (p_descripcion, p_descuento, p_fechaInicio, p_fechaFin, p_idProducto, 'ACTIVO');
    SET p_idOferta = @@last_insert_id;
END$$

CREATE PROCEDURE ActualizaOferta(
    IN p_idOferta INT,
    IN p_descripcion VARCHAR(200),
    IN p_descuento DOUBLE,
    IN p_fechaInicio DATE,
    IN p_fechaFin DATE,
    IN p_idProducto INT
)
BEGIN
    UPDATE Oferta 
    SET descripcion = p_descripcion, 
        descuento = p_descuento, 
        fechaInicio = p_fechaInicio, 
        fechaFin = p_fechaFin, 
        idProducto = p_idProducto
    WHERE idOferta = p_idOferta;
END$$

CREATE PROCEDURE EliminaOferta(
    IN p_idOferta INT
)
BEGIN
    UPDATE Oferta SET estadoOferta = 'DESACTIVADO' WHERE idOferta = p_idOferta;
END$$

CREATE PROCEDURE ListaOfertas()
BEGIN
    SELECT * FROM Oferta WHERE estadoOferta='ACTIVO';
END$$


















