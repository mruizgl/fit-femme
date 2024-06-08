## Diagrama de Clases

|           Producto           |
|------------------------------|
| - id: int                    |
| - nombre: string             |
| - precio: float              |
| - cantidad: int              |
| + crearProducto(): Producto     |
| + leerProductos(): List<Producto>     |
| + actualizarProducto(): Producto|
| + eliminarProducto(): void  |

|           Usuario            |
|------------------------------|
| - id: int                    |
| - nombreUsuario: string      |
| - contraseña: string         |
| + crearUsuario(): Usuario       |
| + leerUsuarios(): List<Usuario>       |
| + actualizarUsuario(): Usuario |
| + eliminarUsuario(): void    |

|            Pedido            |
|------------------------------|
| - id: int                    |
| - fecha: Date                |
| - estado: string             |
| + crearPedido(): Pedido        |
| + leerPedidos(): List<Pedido>        |
| + actualizarEstado(): Pedido  |
| + eliminarPedido(): void    |

|          Categoría           |
|------------------------------|
| - id: int                    |
| - nombre: string             |
| - descripción: string        |
| + crearCategoría(): Categoría    |
| + leerCategorías(): List<Categoría>     |
| + actualizarCategoría(): Categoría|
| + eliminarCategoría(): void |

|         Inventario           |
|------------------------------|
| - id: int                    |
| - productoId: int            |
| - cantidadDisponible: int    |
| + leerInventario(): List<Inventario>     |
| + actualizarInventario(): Inventario|

