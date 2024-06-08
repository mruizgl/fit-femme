## Diagrama de Clases

|           Producto           |
--------------------------------
| - id: int                    |
| - nombre: string             |
| - precio: float              |
| - cantidad: int              |
| + crearProducto(): void     |
| + leerProductos(): void     |
| + actualizarProducto(): void|
| + eliminarProducto(): void  |



|           Usuario            |
--------------------------------
| - id: int                    |
| - nombreUsuario: string      |
| - contraseña: string         |
| + crearUsuario(): void       |
| + leerUsuarios(): void       |
| + actualizarUsuario(): void |
| + eliminarUsuario(): void    |



|            Pedido            |
--------------------------------
| - id: int                    |
| - fecha: Date                |
| - estado: string             |
| + crearPedido(): void        |
| + leerPedidos(): void        |
| + actualizarEstado(): void  |
| + eliminarPedido(): void    |



|          Categoría           |
--------------------------------
| - id: int                    |
| - nombre: string             |
| - descripción: string        |
| + crearCategoría(): void    |
| + leerCategorías(): void     |
| + actualizarCategoría(): void|
| + eliminarCategoría(): void |



|         Inventario           |
--------------------------------
| - id: int                    |
| - productoId: int            |
| - cantidadDisponible: int    |
| + leerInventario(): void     |
| + actualizarInventario(): void|
--------------------------------
