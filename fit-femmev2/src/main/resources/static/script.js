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
                                      '<p>Precio: ' + data.precio + '</p>';
            }
        })
        .catch(error => {
            console.error('Error:', error);
            var resultado = document.getElementById('resultado');
            resultado.innerHTML = '<p>Error al realizar la solicitud.</p>';
        });
});
