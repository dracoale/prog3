
DELIMITER $$
CREATE PROCEDURE InsertaUsuarioNatural(
    OUT p_idUsuario INT,
    IN p_nombre VARCHAR(100),
    IN p_genero CHAR(1),
    IN p_telefono VARCHAR(20),
    IN p_correo VARCHAR(100),
    IN p_direccion VARCHAR(200),
    IN p_fechaNacimiento DATE,
    IN p_nombreUsuario VARCHAR(100),
    IN p_contrasena VARCHAR(50),
    IN p_apellidoPaterno VARCHAR(100),
    IN p_apellidoMaterno VARCHAR(100),
    IN p_DNI VARCHAR(20)
)
BEGIN
    INSERT INTO Usuario(nombre, telefono, correo,direccion, fechaRegistro,genero, estadoCuenta, tipoUsuario, fechaNacimiento, nombreUsuario, contrasena, apellidoPaterno, apellidoMaterno, DNI)
    VALUES (p_nombre, p_telefono, p_correo,p_direccion, curdate(),p_genero, 'ACTIVO', 'USER_NATURAL', p_fechaNacimiento, p_nombreUsuario, p_contrasena, p_apellidoPaterno, p_apellidoMaterno, p_DNI);
    SET p_idUsuario = @@last_insert_id;
END$$


CREATE PROCEDURE InsertaUsuarioJuridico(
    OUT p_idUsuario INT,
    IN p_nombre VARCHAR(100),
    IN p_genero CHAR(1),
    IN p_telefono VARCHAR(20),
    IN p_correo VARCHAR(100),
    IN p_direccion VARCHAR(200),
    IN p_fechaNacimiento DATE,
    IN p_nombreUsuario VARCHAR(100),
    IN p_contrasena VARCHAR(50),
    IN p_apellidoPaterno VARCHAR(100),
    IN p_apellidoMaterno VARCHAR(100),
    IN p_RUC VARCHAR(20),
    IN p_nombreEmpresa VARCHAR(150)
)
BEGIN
    INSERT INTO Usuario(nombre, telefono, correo,direccion,genero, fechaRegistro, estadoCuenta, tipoUsuario, fechaNacimiento, nombreUsuario, contrasena, apellidoPaterno, apellidoMaterno, RUC, nombreEmpresa)
    VALUES (p_nombre, p_telefono, p_correo,p_direccion,p_genero, curdate(), 'ACTIVO', 'USER_JURIDICO', p_fechaNacimiento, p_nombreUsuario, p_contrasena, p_apellidoPaterno, p_apellidoMaterno, p_RUC, p_nombreEmpresa);
    SET p_idUsuario = @@last_insert_id;
END$$


#DELIMITER $$
CREATE PROCEDURE ActualizaUsuarioJuridico(
    IN p_idUsuario INT,
    IN p_nombre VARCHAR(100),
    IN p_genero CHAR(1),
    IN p_telefono VARCHAR(20),
    IN p_correo VARCHAR(100),
    IN p_direccion VARCHAR(200),
    IN p_contrasena VARCHAR(50),
    IN p_apellidoPaterno VARCHAR(100),
    IN p_apellidoMaterno VARCHAR(100),
    IN p_nombreEmpresa VARCHAR(150),
    IN p_contrasenanueva VARCHAR(100)
)
BEGIN
	DECLARE v_contrasena VARCHAR(100);
    
    SELECT contrasena
    INTO v_contrasena
    FROM Usuario
    WHERE CAST(idUsuario AS BINARY)= CAST(p_idUsuario AS BINARY);
    IF CAST(v_contrasena AS BINARY) = CAST(p_contrasena AS BINARY) THEN
		UPDATE Usuario
		SET nombre = p_nombre,genero=p_genero,telefono = p_telefono,
			correo = p_correo,direccion=p_direccion,contrasena = p_contrasenanueva,apellidoPaterno = p_apellidoPaterno,
			apellidoMaterno = p_apellidoMaterno,nombreEmpresa = p_nombreEmpresa
		WHERE idUsuario = p_idUsuario;
	ELSE
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'La contraseña proporcionada no es correcta';
    END IF;
END$$


#DELIMITER $$
CREATE PROCEDURE InsertaAdministrador(
    OUT p_idUsuario INT,
    IN p_nombre VARCHAR(100),
    IN p_genero CHAR(1),
    IN p_telefono VARCHAR(20),
    IN p_correo VARCHAR(100),
    IN p_direccion VARCHAR(200),
    IN p_fechaNacimiento DATE,
    IN p_nombreUsuario VARCHAR(50),
    IN p_contrasena VARCHAR(100),
    IN p_apellidoPaterno VARCHAR(100),
    IN p_apellidoMaterno VARCHAR(100)
)
BEGIN
    INSERT INTO Usuario(nombre, telefono, correo,direccion,genero, fechaRegistro, estadoCuenta, tipoUsuario, fechaNacimiento, nombreUsuario, contrasena, apellidoPaterno, apellidoMaterno)
    VALUES (p_nombre, p_telefono, p_correo,p_direccion,p_genero, curdate(), 'ACTIVO', 'ADMINISTRADOR', p_fechaNacimiento, p_nombreUsuario, p_contrasena, p_apellidoPaterno, p_apellidoMaterno);
    SET p_idUsuario = @@last_insert_id;
END$$


#DELIMITER $$
CREATE PROCEDURE ActualizaUsuarioPersona(
    IN p_idUsuario INT,
    IN p_nombre VARCHAR(100),
    IN p_genero CHAR(1),
    IN p_telefono VARCHAR(20),
    IN p_correo VARCHAR(100),
    IN p_direccion VARCHAR(200),
    IN p_contrasena VARCHAR(100),
    IN p_apellidoPaterno VARCHAR(100),
    IN p_apellidoMaterno VARCHAR(100),
    IN p_contrasenanueva VARCHAR(100)
)
BEGIN
	DECLARE v_contrasena VARCHAR(100);
    
    SELECT contrasena
    INTO v_contrasena
    FROM Usuario
    WHERE CAST(idUsuario AS BINARY)= CAST(p_idUsuario AS BINARY);
    IF CAST(v_contrasena AS BINARY) = CAST(p_contrasena AS BINARY) THEN
		UPDATE Usuario
		SET nombre = p_nombre,genero=p_genero,telefono = p_telefono,
			correo = p_correo,direccion=p_direccion,contrasena = p_contrasenanueva,apellidoPaterno = p_apellidoPaterno,
			apellidoMaterno = p_apellidoMaterno
		WHERE idUsuario = p_idUsuario;
	ELSE
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'La contraseña proporcionada no es correcta';
    END IF;
END$$



#DELIMITER $$
CREATE PROCEDURE ListarUsuariosXNombre(
	_nombre VARCHAR(300)
)
BEGIN
	SELECT idUsuario,nombre,apellidoPaterno,apellidoMaterno,genero, nombreUsuario, correo,direccion,telefono
    ,fechaNacimiento,estadoCuenta FROM Usuario where estadoCuenta = 'ACTIVO' 
    AND CONCAT(nombre,' ',apellidoPaterno,' ',apellidoMaterno, ' ',nombreUsuario) LIKE CONCAT('%',_nombre,'%');
END$$
#DELIMITER $$
CREATE PROCEDURE LoginUsuario(
	_usuario VARCHAR(300),
    _contra VARCHAR(300)
)
BEGIN
	SELECT idUsuario,nombre,apellidoPaterno,apellidoMaterno,
    nombreUsuario, correo, telefono,genero,direccion,fechaNacimiento, tipoUsuario, estadoCuenta FROM Usuario
    where estadoCuenta = 'ACTIVO' 
    AND (CAST(_usuario AS BINARY)=CAST(nombreUsuario AS BINARY) OR CAST(_usuario=correo AS BINARY)) AND CAST(_contra AS BINARY) = 
    CAST(contrasena AS BINARY);
END$$

CREATE PROCEDURE ListaUsuarioXTipo(
	IN tipo VARCHAR(20)
)
BEGIN
    SELECT nombre, telefono,genero, correo,direccion, fechaRegistro, estadoCuenta, fechaNacimiento,
    nombreUsuario, apellidoPaterno, apellidoMaterno,RUC,nombreEmpresa,DNI
    FROM Usuario
    WHERE tipoUsuario=tipo;
END$$
CREATE PROCEDURE EliminaUsuario(
    IN p_idUsuario INT
)
BEGIN
    Update Usuario SET estadoCuenta='DESACTIVADO' WHERE idUsuario = p_idUsuario;
END$$
#DELIMITER $$
CREATE PROCEDURE buscarUsuarioExistenteAdmin(
	IN p_usuario VARCHAR(20)
)
BEGIN
    SELECT *
    FROM Usuario
    WHERE nombreUsuario=p_usuario AND estadoCuenta<>'DESACTIVADO';
END$$
#DELIMITER $$
CREATE PROCEDURE buscarUsuarioExistenteNatural(
	IN p_usuario VARCHAR(20),
    IN p_DNI VARCHAR(20)
)
BEGIN
    SELECT *
    FROM Usuario
    WHERE (nombreUsuario=p_usuario OR DNI=p_DNI) AND estadoCuenta<>'DESACTIVADO';
END$$
#DELIMITER $$
CREATE PROCEDURE buscarUsuarioExistenteJuridico(
	IN p_usuario VARCHAR(20),
    IN p_RUC VARCHAR(20)
)
BEGIN
    SELECT *
    FROM Usuario
    WHERE (nombreUsuario=p_usuario OR RUC=p_RUC) AND estadoCuenta<>'DESACTIVADO';
END$$



#DELIMITER $$
CREATE PROCEDURE MostrarUsuariosAAdmin()
BEGIN
    SELECT *
    FROM Usuario
    WHERE tipoUsuario<>'ADMINISTRADOR';
END$$
#DELIMITER $$
CREATE PROCEDURE BuscarUsuarioXId(
	IN p_idUsuario INT
)
BEGIN
    SELECT *
    FROM Usuario
    WHERE p_idUsuario = idUsuario;
END$$
#DELIMITER $$
CREATE PROCEDURE ActivarUsuario(
	IN p_idUsuario INT
)
BEGIN
    Update Usuario SET estadoCuenta='ACTIVO' WHERE idUsuario = p_idUsuario;
END$$
#DELIMITER $$
CREATE PROCEDURE SuspenderUsuario(
	IN p_idUsuario INT
)
BEGIN
    Update Usuario SET estadoCuenta='SUSPENDIDO' WHERE idUsuario = p_idUsuario;
END$$
CREATE PROCEDURE InsertaProducto(
    OUT p_idProducto INT,
    IN p_nombre VARCHAR(150),
    IN p_descripcion VARCHAR(200),
    IN p_precio DOUBLE,
    IN p_stock INT,
    IN p_idAlmacen INT,
    IN p_idTipoProducto INT,
    IN p_foto BLOB
)
BEGIN
    INSERT INTO Producto(nombre, descripcion, precio, stock, estadoProducto, idAlmacen, idTipoProducto,foto)
    VALUES (p_nombre, p_descripcion, p_precio, p_stock, 'ACTIVO', p_idAlmacen, p_idTipoProducto,p_foto);
    SET p_idProducto = @@last_insert_id;
END$$


#DELIMITER $$
CREATE PROCEDURE ActualizaProducto(
    IN p_idProducto INT,
    IN p_nombre VARCHAR(150),
    IN p_descripcion VARCHAR(200),
    IN p_precio DOUBLE,
    IN p_stock INT,
    IN p_estadoProducto ENUM('DESCONTINUADO', 'ACTIVO', 'AGOTADO'),
    IN p_idAlmacen INT,
    IN p_idTipoProducto INT,
    IN p_foto BLOB
)
BEGIN
    UPDATE Producto
    SET nombre = p_nombre, descripcion = p_descripcion, precio = p_precio, stock = p_stock, estadoProducto = p_estadoProducto,
    idAlmacen = p_idAlmacen, idTipoProducto=p_idTipoProducto, foto = p_foto
    WHERE idProducto = p_idProducto;
END$$


CREATE PROCEDURE EliminaProducto(
    IN p_idProducto INT
)
BEGIN
    Update Producto SET estadoProducto='DESCONTINUADO' WHERE idProducto = p_idProducto;
END$$


#DELIMITER $$
CREATE PROCEDURE ListaProductos()
BEGIN
    SELECT idProducto,nombre,descripcion, idTipoProducto, precio, estadoProducto,foto,stock FROM Producto;
END$$
#DELIMITER $$
CREATE PROCEDURE ListaProductosXTipo(
	p_idTipo INT
)
BEGIN
    SELECT idProducto,nombre,descripcion, idTipoProducto, precio, estadoProducto,foto,stock FROM Producto 
    WHERE idTipoProducto = p_idTipo AND estadoProducto = 'ACTIVO';
END$$

#DELIMITER $$
CREATE PROCEDURE LISTAR_PRODUCTOS_POR_NOMBRE(
	_nombre VARCHAR(300)
)
BEGIN
	SELECT idProducto, nombre,descripcion,idTipoProducto, precio,estadoProducto,foto,stock FROM Producto where estadoProducto = 'ACTIVO' AND CONCAT(nombre,' ',descripcion) LIKE CONCAT('%',_nombre,'%');
END$$

#DELIMITER $$
CREATE PROCEDURE buscarProducto(
	IN p_idProducto INT
)
BEGIN	
	SELECT idProducto,nombre,descripcion,idTipoProducto,precio,estadoProducto,foto,stock FROM Producto WHERE p_idProducto=idProducto;
END$$
#DELIMITER $$
CREATE PROCEDURE top3_productos_mas_vendidos()
BEGIN
    SELECT 
        p.idProducto,p.nombre,p.descripcion,p.foto,
        SUM(dp.cantidad) AS total_vendido
    FROM 
        Producto p
    INNER JOIN 
        DetallePedido dp ON p.idProducto = dp.idProducto
    INNER JOIN 
        Pedido ped ON dp.idPedido = ped.idPedido
    WHERE 
        (ped.estadoPedido = 'EN_CAMINO' OR ped.estadoPedido ='ENTREGADA') and dp.estadoDetallePedido = 'ACTIVO'
    GROUP BY 
        p.nombre, p.descripcion
    ORDER BY 
        total_vendido DESC
    LIMIT 3;
END $$
#DELIMITER $$
CREATE PROCEDURE top3_productos_menos_vendidos()
BEGIN
    SELECT 
        p.idProducto,p.nombre,p.descripcion,p.foto,
        SUM(dp.cantidad) AS total_vendido
    FROM 
        Producto p
    INNER JOIN 
        DetallePedido dp ON p.idProducto = dp.idProducto
    INNER JOIN 
        Pedido ped ON dp.idPedido = ped.idPedido
    WHERE 
        (ped.estadoPedido = 'EN_CAMINO' OR ped.estadoPedido ='ENTREGADA') and dp.estadoDetallePedido = 'ACTIVO'
    GROUP BY 
        p.nombre, p.descripcion
    ORDER BY 
        total_vendido ASC
    LIMIT 3;
END $$

#DELIMITER $$
CREATE PROCEDURE calcular_crecimiento_ventas(
    IN producto_id INT,
    IN anio_actual INT,
    IN mes_actual INT,
    OUT crecimiento DOUBLE
)
BEGIN
    DECLARE ventas_mes_actual DOUBLE;
    DECLARE ventas_mes_anterior DOUBLE;
    DECLARE anio_anterior INT;
    DECLARE mes_anterior INT;
    IF mes_actual = 1 THEN
        SET mes_anterior = 12;
        SET anio_anterior = anio_actual - 1;
    ELSE
        SET mes_anterior = mes_actual - 1;
        SET anio_anterior = anio_actual;
    END IF;
    -- Obtener las ventas del mes actual
    SELECT IFNULL(SUM(dp.cantidad), 0) INTO ventas_mes_actual
    FROM DetallePedido dp
    INNER JOIN Pedido ped ON dp.idPedido = ped.idPedido
    WHERE dp.idProducto = producto_id AND estadoDetallePedido='ACTIVO'
      AND ped.estadoPedido = 'ENTREGADA'
      AND YEAR(ped.fechaEntrega) = anio_actual
      AND MONTH(ped.fechaEntrega) = mes_actual;

    -- Obtener las ventas del mes anterior
    SELECT IFNULL(SUM(dp.cantidad), 0) INTO ventas_mes_anterior
    FROM DetallePedido dp
    INNER JOIN Pedido ped ON dp.idPedido = ped.idPedido
    WHERE dp.idProducto = producto_id AND estadoDetallePedido='ACTIVO'
      AND ped.estadoPedido = 'ENTREGADA'
      AND YEAR(ped.fechaEntrega) = anio_anterior
      AND MONTH(ped.fechaEntrega) = mes_anterior;

    -- Calcular el crecimiento de ventas
    IF ventas_mes_anterior = 0 THEN
        SET crecimiento = NULL; -- Evita división por cero
    ELSE
        SET crecimiento = (ventas_mes_actual - ventas_mes_anterior)*100 / ventas_mes_anterior;
    END IF;
END $$



CREATE PROCEDURE InsertaFactura(
    OUT p_idFactura INT,
    IN p_idPedido INT,
    IN p_fecha DATE,
    IN p_total DOUBLE,
    IN p_tipoPago ENUM('VISA','PAYPAL','CUPON'),
	IN p_estadoFactura ENUM('ACTIVO','DESACTIVADO')
)
BEGIN
    INSERT INTO Factura(idPedido,fecha, total, tipoPago, estadoFactura)
    VALUES (p_idPedido,p_fecha, p_total, p_tipoPago, 'ACTIVO');
    SET p_idFactura = @@last_insert_id;
END $$




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

#DELIMITER $$
CREATE PROCEDURE ListaFacturas()
BEGIN
    SELECT idFactura,idPedido,fecha, total, tipoPago, estadoFactura FROM Factura;
END$$
#DELIMITER $$
CREATE PROCEDURE buscarFacturaXPedido(
	IN f_idPedido INT
)
BEGIN
    SELECT idFactura,idPedido,fecha, total, tipoPago, estadoFactura FROM Factura WHERE f_idPedido=idPedido;
END$$
#DELIMITER $$
CREATE PROCEDURE buscarFactura(
	IN f_idFactura INT
)
BEGIN
    SELECT idFactura,idPedido,fecha, total, tipoPago, estadoFactura FROM Factura WHERE f_idFactura=idFactura;
END$$
#DELIMITER $$
CREATE TRIGGER after_pedido_update
AFTER UPDATE ON Pedido
FOR EACH ROW
BEGIN
    IF NEW.estadoPedido = 'EN_CAMINO' AND OLD.estadoPedido != 'EN_CAMINO' THEN
        INSERT INTO Factura (idPedido, fecha, total, tipoPago, estadoFactura)
        VALUES (NEW.idPedido, CURDATE(), 0.0, NULL, 'ACTIVO');
    END IF;
END $$





#DELIMITER $$
CREATE PROCEDURE InsertaPedido(
	OUT	p_idPedido INT,
    IN p_prioridad ENUM('URGENTE', 'NO_URGENTE'),
    IN p_idUsuario INT
)
BEGIN
    INSERT INTO Pedido(estadoPedido, fechaPedido, prioridad, fechaEntrega, idUsuario)
    VALUES ('PROCESADA', curdate(), p_prioridad, curdate()+1, p_idUsuario);
    SET p_idPedido = @@last_insert_id;
END$$



CREATE PROCEDURE ActualizaPedido(
    IN p_idPedido INT,
    IN p_estadoPedido ENUM('ENTREGADA', 'PROCESADA', 'CANCELADA','EN_CAMINO'),
    IN p_prioridad ENUM('URGENTE', 'NO_URGENTE')
)
BEGIN
    UPDATE Pedido
    SET estadoPedido = p_estadoPedido, prioridad = p_prioridad
    WHERE idPedido = p_idPedido;
END$$



CREATE PROCEDURE EliminaPedido(
    IN p_idPedido INT
)
BEGIN
    Update Pedido SET estadoPedido='CANCELADA'
    WHERE idPedido = p_idPedido;
END$$


#DELIMITER $$
CREATE PROCEDURE ListaPedidos()
BEGIN
    SELECT idPedido,estadoPedido, fechaPedido, prioridad, fechaEntrega, idUsuario FROM Pedido;
END$$
#DELIMITER $$
CREATE PROCEDURE ListaPedidosXUsuario(
	IN id INT
)
BEGIN
    SELECT idPedido,idUsuario, fechaPedido, prioridad, fechaEntrega,estadoPedido FROM Pedido WHERE id=idUsuario AND estadoPedido<>'CANCELADA';
END$$
#DELIMITER $$
CREATE PROCEDURE ListaPedidosXIdPedido(
	IN p_idPedido INT
)
BEGIN
    SELECT idPedido,idUsuario, fechaPedido, prioridad, fechaEntrega,estadoPedido FROM Pedido WHERE idPedido=p_idPedido AND estadoPedido<>'CANCELADA';
END$$


#DELIMITER $$
CREATE TRIGGER restar_stock_al_actualizar_pedido
AFTER UPDATE ON Pedido
FOR EACH ROW
BEGIN
    -- Variables y cursores deben declararse al inicio del bloque BEGIN...END
    DECLARE cantidad_producto INT;
    DECLARE id_producto INT;
    DECLARE done INT DEFAULT FALSE;
    
    -- Cursor para recorrer los detalles del pedido
    DECLARE detalles_cursor CURSOR FOR 
    SELECT idProducto, cantidad FROM DetallePedido WHERE idPedido = NEW.idPedido;
    
    -- Handler para el fin del cursor
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

    -- Verificar si el estado del pedido ha cambiado a 'EN_CAMINO'
    IF NEW.estadoPedido = 'EN_CAMINO' AND OLD.estadoPedido <> 'EN_CAMINO' THEN
        -- Abrir el cursor
        OPEN detalles_cursor;
        
        -- Bucle para recorrer cada fila del cursor
        read_loop: LOOP
            FETCH detalles_cursor INTO id_producto, cantidad_producto;
            IF done THEN
                LEAVE read_loop;
            END IF;
            
            -- Actualizar el stock del producto
            UPDATE Producto
            SET stock = stock - cantidad_producto
            WHERE idProducto = id_producto;
        END LOOP;
        
        -- Cerrar el cursor
        CLOSE detalles_cursor;
    END IF;
END $$



#DELIMITER $$
CREATE PROCEDURE InsertaDetallePedido (
    OUT p_idDetallePedido INT,
    IN p_idPedido INT,
    IN p_idProducto INT,
    IN p_cantidad INT
)
BEGIN
	DECLARE v_precio DECIMAL(10,2);
    SELECT precio INTO v_precio FROM Producto WHERE idProducto = p_idProducto;
    INSERT INTO DetallePedido (idPedido, idProducto, cantidad, estadoDetallePedido,subtotal)
    VALUES (p_idPedido, p_idProducto, p_cantidad, 'ACTIVO',p_cantidad*v_precio);
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
#DELIMITER $$
CREATE PROCEDURE ListaDetallesDePedido(
	IN p_idPedido INT
)
BEGIN
    SELECT * FROM DetallePedido WHERE estadoDetallePedido='ACTIVO' AND p_idPedido=idPedido;
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
#DELIMITER $$
CREATE PROCEDURE ListaTiposProducto()
BEGIN
    SELECT * FROM TipoProducto;
END $$
#DELIMITER $$
CREATE PROCEDURE InsertarOferta(
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
#DELIMITER $$
CREATE PROCEDURE ListaOfertas()
BEGIN
    SELECT * FROM Oferta;
END$$
#DELIMITER $$
CREATE PROCEDURE buscarOfertasXProducto(
	IN p_idProducto INT
)
BEGIN
    SELECT * FROM Oferta WHERE p_idProducto=idProducto AND estadoOferta='ACTIVO';
END$$
#DELIMITER $$
CREATE PROCEDURE buscardOfertaXId(
	IN p_idOferta INT
)
BEGIN
    SELECT * FROM Oferta WHERE idOferta=p_idOferta;
END$$
#DELIMITER $$
CREATE EVENT IF NOT EXISTS desactivar_ofertas
ON SCHEDULE EVERY 1 DAY
STARTS CURRENT_TIMESTAMP
DO
BEGIN
    -- Actualiza el estado de las ofertas cuya fechaFin ha pasado
    UPDATE Oferta
    SET estadoOferta = 'DESACTIVADO'
    WHERE fechaFin <= CURRENT_DATE() AND estadoOferta = 'ACTIVO';
END $$















