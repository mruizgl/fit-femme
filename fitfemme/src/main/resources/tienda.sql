CREATE TABLE Usuarios (
    id_usuario INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    nombre TEXT NOT NULL,
    email TEXT NOT NULL,
    contraseña TEXT NOT NULL,
    dirección TEXT
);

CREATE TABLE Categorias (
    id_categoria INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    nombre TEXT NOT NULL
);

CREATE TABLE Productos (
    id_producto INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    nombre TEXT NOT NULL,
    descripción TEXT,
    precio REAL NOT NULL,
    id_categoria INTEGER NOT NULL,
    FOREIGN KEY (id_categoria) REFERENCES Categorías(id_categoria)
);

CREATE TABLE Pedidos (
    id_pedido INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    id_usuario INTEGER NOT NULL,
    fecha_pedido DATETIME NOT NULL,
    total REAL NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES Usuarios(id_usuario)
);



CREATE TABLE Inventario (
    id_producto INTEGER PRIMARY KEY NOT NULL,
    cantidad INTEGER NOT NULL,
    FOREIGN KEY (id_producto) REFERENCES Productos(id_producto)
);

CREATE TABLE Pedidos_Productos (
    id_pedido INTEGER NOT NULL,
    id_producto INTEGER NOT NULL,
    cantidad INTEGER NOT NULL,
    PRIMARY KEY (id_pedido, id_producto),
    FOREIGN KEY (id_pedido) REFERENCES Pedidos(id_pedido),
    FOREIGN KEY (id_producto) REFERENCES Productos(id_producto)
);
