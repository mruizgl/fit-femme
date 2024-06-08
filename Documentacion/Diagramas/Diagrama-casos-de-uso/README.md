# Diagrama de Casos de Uso


## Actores

<img src = "../../../img/actores.png">

| Actor            | Cliente                                                    |
|------------------|---------------------------------------------------------|
| Description      | _Cliente de la tienda que desea interactuar con los productos_ |
| Características  |                                                         |
| Relaciones      |                                                         |
| References       | _C.U.1_ _C.U.2_ _C.U.3_ _C.U.4_ _C.U.5_ _C.U.6_      |   
| Notes            |                                                         |
| Autora           | _Melissa Ruiz González_                             |
| Fecha             | _08/06/2024_                                            |

--------------------------------------------------------  
  


| Actor            | Administrador                                                    |
|------------------|---------------------------------------------------------|
| Description      | _Administrador de la tienda_ |
| Características  |                                                         |
| Relaciones      |                                                         |
| Referencias       | _C.U.2_ _C.U.7_ _C.U.8_ _C.U.9_ _C.U.10_ _C.U.11_       |   
| Notas            |                                                         |
| Autora           | _Melissa Ruiz González_                             |
| Fecha             | _08/06/2024_                                            |

## Casos de Uso

### Cliente
- __C. U. 1.__ Registrarse
- __C. U. 2.__ Iniciar Sesión
- __C.U. 3.__ Ver Productos
- __C.U. 4.__ Buscar Productos
- __C.U. 5__ Realizar Pedido
- __C.U. 6__ Ver Pedidos

### Administrador
- __C.U. 2__ Iniciar Sesión
- __C.U. 7__ Gestionar Usuarios
- __C.U. 8__ Gestionar Productos
- __C.U. 9__ Gestionar Categorías
- __C. U. 10__ Gestionar Pedidos
- __C. U. 11__ Gestionar Inventario
               

## Especificación de casos de Uso

| C.U.1   | Registrarse                                                         |
|------------------|---------------------------------------------------------------------------|
| Actor            | _Cliente_                                                                    |
| Description      | _Registrarse en la tienda_                                        |                                                                           |
| Autora           | _Melissa Ruiz González_                        |
| Date             | 08/06/2024                                                             |

| C.U 2   | Iniciar sesión                                                         |
|------------------|---------------------------------------------------------------------------|
| Actor            | _Cliente, Administrador_                                                                    |
| Descripción      | _Iniciar sesión en el sistema_                                        |
|   
| Requirements     | _Estar registrado_                                                        |
| Notes            |                                                                           |
| Author           | _Melissa Ruiz González_                        |
| Date             | _08/06/2024_                                                              |

| C.U. 3   | verProducto                                                         |
|------------------|---------------------------------------------------------------------------|
| Actor            | _Cliente_                                                                    |
| Description      | _Obtener listado de productos disponibles_                                        |                                                      |
| Notes            |                                                                           |
| Author           | _Melissa Ruiz González_                        |
| Date             | _08/06/2024_                                                              |

| C. U. 4   | buscarProducto                                                         |
|------------------|---------------------------------------------------------------------------|
| Actor            | _Cliente_                                                                    |
| Description      | _Buscar con cierto filtro or nombre algún producto_                                        |                                               |
| Notes            |                                                                           |
| Author           | _Melissa Ruiz González_                        |
| Date             | _08/06/2024_                                                              |

| C. U. 5   | realizarPedido                                                         |
|------------------|---------------------------------------------------------------------------|
| Actor            | _Cliente_                                                                    |
| Description      | _Realizar un pedido_                                        |
| Pre-condición  |                                                                           |  
| Post-condición |   _Hacer un pago_                                                                        |  
| Requerimientos     | _Estar registrado_                                                        |
| Notes            |                                                                           |
| Autora           | _Melissa Ruiz González_                        |
| Date             | _08/06/2024_                                                              |

| C. U. 6  | verPedidos                                                         |
|------------------|---------------------------------------------------------------------------|
| Actor            | _Cliente_                                                                    |
| Descripcion      | _Ver pedidos realizados_                                        |
| Pre-condiciones  |    _Haber hecho pedidos_                                                                       |  
| Post-condiciones |                                                                           |  
| Requerimientos     | _Estar registrado_                                                        |
| Notas            |                                                                           |
| Autora           | _Melissa Ruiz González_                        |
| Date             | _08/06/2024_                                                              |

| C. U. 7  | GestionarUsuarios                                                         |
|------------------|---------------------------------------------------------------------------|
| Actor            | _Administrador_                                                                    |
| Descripcion      | _Gestionar los usuarios del sistema_                                        |
| Pre-condiciones  |                                                                           |  
| Post-condiciones |                                                                           |  
| Requerimientos     |                                                         |
| Notas            |                                                                           |
| Autora           | _Melissa Ruiz González_                        |
| Date             | _08/06/2024_  

| C. U. 8  | gestionarProductos                                                         |
|------------------|---------------------------------------------------------------------------|
| Actor            | _Administrador_                                                                    |
| Descripcion      | _Gestionar los productos del sistema_                                        |
| Pre-condiciones  |                                                                           |  
| Post-condiciones |                                                                           |  
| Requerimientos     |                                                         |
| Notas            |                                                                           |
| Autora           | _Melissa Ruiz González_                        |
| Date             | _08/06/2024_  

| C. U. 9  | gestionarCategorías                                                         |
|------------------|---------------------------------------------------------------------------|
| Actor            | _Administrador_                                                                    |
| Descripcion      | _Gestionar las categorías del sistema_                                        |
| Pre-condiciones  |                                                                           |  
| Post-condiciones |                                                                           |  
| Requerimientos     |                                                         |
| Notas            |                                                                           |
| Autora           | _Melissa Ruiz González_                        |
| Date             | _08/06/2024_  

| C. U. 10  | gestionarPedidos                                                         |
|------------------|---------------------------------------------------------------------------|
| Actor            | _Administrador_                                                                    |
| Descripcion      | _Gestionar los pedidos del sistema_                                        |
| Pre-condiciones  |                                                                           |  
| Post-condiciones |                                                                           |  
| Requerimientos     |                                                         |
| Notas            |                                                                           |
| Autora           | _Melissa Ruiz González_                        |
| Date             | _08/06/2024_  

| C. U. 7  | GestionarUsuarios                                                         |
|------------------|---------------------------------------------------------------------------|
| Actor            | _Administrador_                                                                    |
| Descripcion      | _Gestionar el inventario de los productos del sistema_                                        |
| Pre-condiciones  |                                                                           |  
| Post-condiciones |                                                                           |  
| Requerimientos     |                                                         |
| Notas            |                                                                           |
| Autora           | _Melissa Ruiz González_                        |
| Date             | _08/06/2024_  




## Diagrama

<img src= "../../../img/diagrama-casos-de-uso.png">
