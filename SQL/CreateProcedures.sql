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
    Update Usuario SET estadoCuenta='DESCTIVADO' WHERE idUsuario = p_idUsuario;
END$$


CREATE PROCEDURE ListaUsuariosNaturales()
BEGIN
    SELECT nombre, telefono, correo, fechaRegistro, estadoCuenta, tipoUsuario, fechaCreacion, nombreUsuario, apellidoPaterno, apellidoMaterno FROM Usuario;
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
    SELECT nombre, telefono, correo, fechaRegistro, estadoCuenta, tipoUsuario, fechaCreacion, nombreUsuario, apellidoPaterno, apellidoMaterno FROM Usuario;
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
    SELECT nombre, telefono, correo, fechaRegistro, estadoCuenta, fechaCreacion, nombreUsuario, contrasena, apellidoPaterno, apellidoMaterno FROM Usuario;
END$$






CREATE PROCEDURE InsertaProducto(
    OUT p_idProducto INT,
    IN p_nombre VARCHAR(150),
    IN p_descripcion VARCHAR(200),
    IN p_categoria TINYINT,
    IN p_precio DOUBLE,
    IN p_stock INT,
    IN p_idEstadoProducto TINYINT,
    IN p_idAlmacen INT
)
BEGIN
    INSERT INTO Producto(nombre, descripcion, categoria, precio, stock, idEstadoProducto, idAlmacen)
    VALUES (p_nombre, p_descripcion, p_categoria, p_precio, p_stock, p_idEstadoProducto, p_idAlmacen);
    SET p_idProducto = @@last_insert_id;
END$$





CREATE PROCEDURE ActualizaProducto(
    IN p_idProducto INT,
    IN p_nombre VARCHAR(150),
    IN p_descripcion VARCHAR(200),
    IN p_categoria TINYINT,
    IN p_precio DOUBLE,
    IN p_stock INT,
    IN p_idEstadoProducto TINYINT,
    IN p_idAlmacen INT
)
BEGIN
    UPDATE Producto
    SET nombre = p_nombre, descripcion = p_descripcion, categoria = p_categoria,
        precio = p_precio, stock = p_stock, idEstadoProducto = p_idEstadoProducto,
        idAlmacen = p_idAlmacen
    WHERE idProducto = p_idProducto;
END$$


CREATE PROCEDURE EliminaProducto(
    IN p_idProducto INT
)
BEGIN
    Update Producto SET idEstadoProducto=1 WHERE idProducto = p_idProducto;
END$$



CREATE PROCEDURE ListaProductos()
BEGIN
    SELECT nombre, descripcion, categoria, precio, idEstadoProducto FROM Producto;
END$$









CREATE PROCEDURE InsertaFactura(
    OUT p_idFactura INT,
    IN p_fecha DATE,
    IN p_total DOUBLE,
    IN p_idPago INT
)
BEGIN
    INSERT INTO Factura(fecha, total, idPago)
    VALUES (p_fecha, p_total, p_idPago);
    SET p_idFactura = @@last_insert_id;
END$$




CREATE PROCEDURE ActualizaFactura(
    IN p_idFactura INT,
    IN p_fecha DATE,
    IN p_total DOUBLE,
    IN p_idPago INT
)
BEGIN
    UPDATE Factura
    SET fecha = p_fecha, total = p_total, idPago = p_idPago
    WHERE idFactura = p_idFactura;
END$$



CREATE PROCEDURE EliminaFactura(
    IN p_idFactura INT
)
BEGIN
    --DELETE FROM Factura
    --WHERE idFactura = p_idFactura;
END$$


CREATE PROCEDURE ListaFacturas()
BEGIN
    SELECT fecha, total, idPago FROM Factura;
END$$







CREATE PROCEDURE InsertaPedido(
    OUT p_idPedido INT,
    IN p_idEstadoPedido TINYINT,
    IN p_fechaPedido DATE,
    IN p_fechaCreacion DATE,
    IN p_idPrioridad TINYINT,
    IN p_fechaEntrega DATE,
    IN p_idUsuario INT,
    IN p_idFactura INT
)
BEGIN
    INSERT INTO Pedido(idEstadoPedido, fechaPedido, fechaCreacion, idPrioridad, fechaEntrega, idUsuario, idFactura)
    VALUES (p_idEstadoPedido, p_fechaPedido, p_fechaCreacion, p_idPrioridad, p_fechaEntrega, p_idUsuario, p_idFactura);
    SET p_idPedido = @@last_insert_id;
END$$



CREATE PROCEDURE ActualizaPedido(
    IN p_idPedido INT,
    IN p_idEstadoPedido TINYINT,
    IN p_fechaPedido DATE,
    IN p_fechaCreacion DATE,
    IN p_idPrioridad TINYINT,
    IN p_fechaEntrega DATE,
    IN p_idUsuario INT,
    IN p_idFactura INT
)
BEGIN
    UPDATE Pedido
    SET idEstadoPedido = p_idEstadoPedido, fechaPedido = p_fechaPedido, fechaCreacion = p_fechaCreacion,
        idPrioridad = p_idPrioridad, fechaEntrega = p_fechaEntrega, idUsuario = p_idUsuario, idFactura = p_idFactura
    WHERE idPedido = p_idPedido;
END$$



CREATE PROCEDURE EliminaPedido(
    IN p_idPedido INT
)
BEGIN
    Update Pedido SET idEstadoPedido=3
    WHERE idPedido = p_idPedido;
END$$



CREATE PROCEDURE ListaPedidos()
BEGIN
    SELECT idEstadoPedido, fechaPedido, fechaCreacion, idPrioridad, fechaEntrega, idUsuario, idFactura FROM Pedido;
END$$
DELIMITER;




































