CREATE TABLE IF NOT EXISTS Usuario (
    idUsuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    telefono VARCHAR(20),
    correo VARCHAR(100),
    fechaRegistro DATE,
    estadoCuenta ENUM('ACTIVO', 'DESACTIVADO', 'SUSPENDIDO'),
    tipoUsuario ENUM('ADMINISTRADOR', 'USER_NATURAL', 'USER_JURIDICO', 'EMPLEADO'),
    fechaCreacion DATE,
    nombreUsuario VARCHAR(100),
    contrasena VARCHAR(50),
    apellidoPaterno VARCHAR(100),
    apellidoMaterno VARCHAR(100),
    RUC VARCHAR(20),
    nombreEmpresa VARCHAR(150),
    DNI VARCHAR(20)
);


CREATE TABLE IF NOT EXISTS Almacen (
    idAlmacen INT AUTO_INCREMENT PRIMARY KEY,
    direccion VARCHAR(150)
);

CREATE TABLE IF NOT EXISTS TipoProducto (
    idTipoProducto INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    descripcion VARCHAR(200),
    estadoTipoProducto ENUM('ACTIVO', 'Desactivado')
);

CREATE TABLE IF NOT EXISTS Producto (
    idProducto INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(150),
    descripcion VARCHAR(200),
    precio DOUBLE,
    stock INT,
    estadoProducto ENUM('DESCONTINUADO', 'ACTIVO', 'AGOTADO'),
    idAlmacen INT,
    idTipoProducto INT,
    FOREIGN KEY (idAlmacen) REFERENCES Almacen(idAlmacen),
    FOREIGN KEY (idTipoProducto) REFERENCES TipoProducto(idTipoProducto)
);

CREATE TABLE IF NOT EXISTS Oferta (
    idOferta INT AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(200),
    descuento DOUBLE,
    fechaInicio DATE,
    fechaFin DATE,
    idProducto INT,
    FOREIGN KEY (idProducto) REFERENCES Producto(idProducto)
);


CREATE TABLE IF NOT EXISTS Factura (
    idFactura INT AUTO_INCREMENT PRIMARY KEY,
    fecha DATE,
    total DOUBLE,
    tipoPago ENUM('VISA', 'PAYPAL', 'CUPON'),
    estadoFactura ENUM('ACTIVO', 'DESACTIVO')
);

CREATE TABLE IF NOT EXISTS DetalleFactura (
    idDetalleFactura INT AUTO_INCREMENT PRIMARY KEY,
    idFactura INT,
    idProducto INT,
    cantidad INT,
    precioUnitario DOUBLE,
    subtotal DOUBLE,
    estadoDetalleFactura ENUM('ACTIVO', 'DESACTIVO'),
    FOREIGN KEY (idFactura) REFERENCES Factura(idFactura),
    FOREIGN KEY (idProducto) REFERENCES Producto(idProducto)
);


CREATE TABLE IF NOT EXISTS Pedido (
    idPedido INT AUTO_INCREMENT PRIMARY KEY,
    estadoPedido ENUM('ENTREGADA', 'PROCESADA', 'CANCELADA', 'EN_CAMINO'),
    prioridad ENUM('URGENTE', 'NO_URGENTE'),
    fechaPedido DATE,
    fechaCreacion DATE,
    fechaEntrega DATE,
    idUsuario INT,
    idFactura INT,
    FOREIGN KEY (idUsuario) REFERENCES Usuario(idUsuario),
    FOREIGN KEY (idFactura) REFERENCES Factura(idFactura)
);

CREATE TABLE IF NOT EXISTS DetallePedido (
    idDetallePedido INT AUTO_INCREMENT PRIMARY KEY,
    idPedido INT,
    idProducto INT,
    cantidad INT,
    subtotal DOUBLE,
    estadoDetallePedido ENUM('ACTIVO', 'DESACTIVO'),
    FOREIGN KEY (idPedido) REFERENCES Pedido(idPedido),
    FOREIGN KEY (idProducto) REFERENCES Producto(idProducto)
);































