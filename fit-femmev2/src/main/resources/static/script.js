// GETPRODUCTOBYID

document.getElementById('getProducto').addEventListener('click', function() {
    var productId = document.getElementById('productId').value;
    fetch('http://localhost:8080/api-rest/producto/find/' + productId)
        .then(response => response.json())
        .then(data => {
            var resultado = document.getElementById('resultado');
            resultado.innerHTML = '';
            if (data.error) {
                resultado.innerHTML = '<p>Error: ' + data.error + '</p>';
            } else {
                resultado.innerHTML = '<p>ID: ' + data.id + '</p>' +
                                      '<p>Nombre: ' + data.nombre + '</p>' +
                                      '<p>Precio: ' + data.precio + '</p>' +
                                      '<p>Descripcion: ' + data.descripcion + '</p>'
                                      '<p>Categoria: ' + data.categoria.nombre + '</p>';
            }
        })
        .catch(error => {
            console.error('Error:', error);
            var resultado = document.getElementById('resultado');
            resultado.innerHTML = '<p>Error al realizar la solicitud.</p>';
        });
});

// OBTENER TODOS LOS PRODUCTOS AQUI

document.getElementById('getAllProductos').addEventListener('click', function() {
    fetch('http://localhost:8080/api-rest/producto/findAll')
        .then(response => response.json())
        .then(data => {
            var resultadoAll = document.getElementById('resultadoAll');
            resultadoAll.innerHTML = '';
            if (data.error) {
                resultadoAll.innerHTML = '<p>Error: ' + data.error + '</p>';
            } else {
                mostrarProductos(data, resultadoAll);
                if (data.length > 10) {
                    var mostrarMasBtn = document.getElementById('mostrarMas');
                    mostrarMasBtn.style.display = 'block';
                    var contador = 10;
                    mostrarMasBtn.addEventListener('click', function() {
                        var siguienteProductos = data.slice(contador, contador + 10);
                        mostrarProductos(siguienteProductos, resultadoAll, true);
                        contador += 10;
                        if (contador >= data.length) {
                            mostrarMasBtn.style.display = 'none';
                        }
                    });
                }
            }
        })
        .catch(error => {
            console.error('Error:', error);
            var resultadoAll = document.getElementById('resultadoAll');
            resultadoAll.innerHTML = '<p>Error al realizar la solicitud.</p>';
        });
});

var contador = 0; // Inicializamos el contador aquí

function mostrarProductos(productos, contenedor, append = false) {
    if (!append) {
        contenedor.innerHTML = ''; // Limpiar el contenedor si no se está añadiendo
        contador = 0; // Reiniciamos el contador si no estamos agregando
    }

    // Obtenemos la cantidad de productos que mostraremos en esta iteración
    var cantidadAMostrar = Math.min(10, productos.length - contador);

    for (var i = 0; i < cantidadAMostrar; i++) {
        var producto = productos[contador + i]; // Obtenemos el producto actual
        var productoHTML = '<div>' +
                            '<p>ID: ' + producto.id + '</p>' +
                            '<p>Nombre: ' + producto.nombre + '</p>' +
                            '<p>Precio: ' + producto.precio + '</p>' +
                            '<p>Descripción: ' + producto.descripcion + '</p>' +
                            '<p>Categoria: ' + producto.categoria.nombre + '</p>' +
                            '</div>';
        contenedor.innerHTML += productoHTML; // Agregamos el producto al contenedor
    }

    contador += cantidadAMostrar; // Actualizamos el contador
}

// Enviar datos para guardar un producto
document.getElementById('saveProduct').addEventListener('click', function(event) {
    event.preventDefault(); // Evita que el formulario se envíe automáticamente

    // Aquí puedes obtener los valores de los campos del formulario y enviarlos al servidor
    var productName = document.getElementById('productName').value;
    var productPrice = document.getElementById('productPrice').value;
    var productCategory = document.getElementById('productCategory').value;
    var productDescription = document.getElementById('productDescription').value;

    // Crea un objeto con los datos del producto
    var productoDTO = {
        nombre: productName,
        precio: productPrice,
        categoria: productCategory,
        descripcion: productDescription
    };

    // Llama a la función para guardar el producto, pasando el objeto productoDTO
    guardarProducto(productoDTO);
});

function guardarProducto(productoDTO) {
    var producto = {
        nombre: productoDTO.nombre,
        descripcion: productoDTO.descripcion,
        precio: productoDTO.precio,
        categoria: {
            id: productoDTO.productCategory // Cambiar a productCategory
        }
    };

    fetch('http://localhost:8080/api-rest/producto/save', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(producto)
    })
    .then(response => {
        if (response.ok) {
            console.log('Producto guardado exitosamente.');
            // Realizar alguna acción adicional si es necesario
        } else {
            console.error('Error al guardar el producto:', response.statusText);
            // Manejar el error de alguna manera si es necesario
        }
    })
    .catch(error => {
        console.error('Error al realizar la solicitud:', error);
        // Manejar el error de alguna manera si es necesario
    });
}

document.getElementById('deleteProduct').addEventListener('click', function(event) {
    event.preventDefault(); // Evita que el formulario se envíe automáticamente

    // Obtener el ID del producto a borrar
    var productIdToDelete = document.getElementById('productIdToDelete').value;

    // Llama a la función para borrar el producto, pasando el ID del producto
    borrarProducto(productIdToDelete);
});

function borrarProducto(productId) {
    fetch('http://localhost:8080/api-rest/producto/delete/' + productId, {
        method: 'DELETE'
    })
    .then(response => {
        if (response.ok) {
            var deleteMessage = document.getElementById('deleteMessage');
            deleteMessage.innerText = 'Producto eliminado exitosamente.';
            // Realizar alguna acción adicional si es necesario
            setTimeout(function() {
                if (deleteMessage.innerText === 'Producto eliminado exitosamente.') {
                    deleteMessage.innerText = ''; // Borra el mensaje después de 5 segundos si no ha sido modificado
                }
            }, 10000); // 5000 milisegundos = 5 segundos
        } else {
            document.getElementById('deleteMessage').innerText = 'Error al eliminar el producto: ' + response.statusText;
            // Manejar el error de alguna manera si es necesario
        }
    })
    .catch(error => {
        document.getElementById('deleteMessage').innerText = 'Error al realizar la solicitud: ' + error;
        // Manejar el error de alguna manera si es necesario
    });
}

