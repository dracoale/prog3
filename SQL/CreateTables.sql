CREATE TABLE IF NOT EXISTS EstadoCuenta (
    idEstadoCuenta TINYINT AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(200)
);

CREATE TABLE IF NOT EXISTS TipoPago (
    idTipoPago TINYINT AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(200)
);

CREATE TABLE IF NOT EXISTS Prioridad (
    idPrioridad TINYINT AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(200)
);

CREATE TABLE IF NOT EXISTS EstadoPedido (
    idEstadoPedido TINYINT AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(200)
);

CREATE TABLE IF NOT EXISTS EstadoProducto (
    idEstadoProducto TINYINT AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(200)
);



CREATE TABLE IF NOT EXISTS Usuario (
    idUsuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    telefono VARCHAR(20),
    correo VARCHAR(100),
    fechaRegistro DATE,
    idEstadoCuenta TINYINT,
    fechaCreacion DATE,
    nombreUsuario VARCHAR(100),
    contrasena VARCHAR(50),
    apellidoPaterno VARCHAR(100),
    apellidoMaterno VARCHAR(100),
    contrasenaAntigua VARCHAR(100),
    RUC VARCHAR(20),
    nombreEmpresa VARCHAR(150),
    DNI VARCHAR(20),
    FOREIGN KEY (idEstadoCuenta) REFERENCES EstadoCuenta(idEstadoCuenta)
);

CREATE TABLE IF NOT EXISTS Administrador (
    idAdministrador INT AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(200),
    nombre VARCHAR(100),
    telefono VARCHAR(20),
    correo VARCHAR(100),
    fechaRegistro DATE,
    idEstadoCuenta TINYINT,
    fechaCreacion DATE,
    nombreUsuario VARCHAR(50),
    contrasena VARCHAR(100),
    apellidoPaterno VARCHAR(100),
    apellidoMaterno VARCHAR(100),
    contrasenaAntigua VARCHAR(100),
    FOREIGN KEY (idEstadoCuenta) REFERENCES EstadoCuenta(idEstadoCuenta)
);




CREATE TABLE IF NOT EXISTS Almacen (
    idAlmacen INT AUTO_INCREMENT PRIMARY KEY,
    direccion VARCHAR(150)
);

CREATE TABLE IF NOT EXISTS TipoProducto (
    idTipoProducto INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    descripcion VARCHAR(200),
);

CREATE TABLE IF NOT EXISTS Producto (
    idProducto INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(150),
    descripcion VARCHAR(200),
    categoria TINYINT,
    precio DOUBLE,
    stock INT,
    idEstadoProducto TINYINT,
    idAlmacen INT,
    idTipoProducto INT,
    FOREIGN KEY (idAlmacen) REFERENCES Almacen(idAlmacen),
    FOREIGN KEY (idEstadoProducto) REFERENCES EstadoProducto(idEstadoProducto),
    FOREIGN KEY (idTipoProducto) REFERENCES TipoProducto(idTipoProducto),
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


CREATE TABLE IF NOT EXISTS FormaDePago (
    idPago INT AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(200),
    idTipoPago TINYINT,
    FOREIGN KEY (idTipoPago) REFERENCES TipoPago(idTipoPago)
);

CREATE TABLE IF NOT EXISTS Factura (
    idFactura INT AUTO_INCREMENT PRIMARY KEY,
    fecha DATE,
    total DOUBLE,
    idPago INT,
    FOREIGN KEY (idPago) REFERENCES FormaDePago(idPago)
);

CREATE TABLE IF NOT EXISTS DetalleFactura (
    idDetalleFactura INT AUTO_INCREMENT PRIMARY KEY,
    idFactura INT,
    idProducto INT,
    cantidad INT,
    precioUnitario DOUBLE,
    subtotal DOUBLE,
    FOREIGN KEY (idFactura) REFERENCES Factura(idFactura),
    FOREIGN KEY (idProducto) REFERENCES Producto(idProducto)
);


CREATE TABLE IF NOT EXISTS Pedido (
    idPedido INT AUTO_INCREMENT PRIMARY KEY,
    idEstadoPedido TINYINT,
    fechaPedido DATE,
    fechaCreacion DATE,
    idPrioridad TINYINT,
    fechaEntrega DATE,
    idUsuario INT,
    idFactura INT,
    FOREIGN KEY (idUsuario) REFERENCES Usuario(idUsuario),
    FOREIGN KEY (idFactura) REFERENCES Factura(idFactura),
    FOREIGN KEY (idEstadoPedido) REFERENCES EstadoPedido(idEstadoPedido),
    FOREIGN KEY (idPrioridad) REFERENCES Prioridad(idPrioridad)
);

CREATE TABLE IF NOT EXISTS DetallePedido (
    idDetallePedido INT AUTO_INCREMENT PRIMARY KEY,
    idPedido INT,
    idProducto INT,
    cantidad INT,
    subtotal DOUBLE,
    FOREIGN KEY (idPedido) REFERENCES Pedido(idPedido),
    FOREIGN KEY (idProducto) REFERENCES Producto(idProducto)
);































