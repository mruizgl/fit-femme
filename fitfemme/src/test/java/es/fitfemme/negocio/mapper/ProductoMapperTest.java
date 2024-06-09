package es.fitfemme.negocio.mapper;

import es.fitfemme.negocio.dto.ProductoDTO;
import es.fitfemme.negocio.entities.Pedido;
import es.fitfemme.negocio.entities.Producto;
import org.hibernate.engine.spi.ManagedEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductoMapperTest {
    private int id_producto = 15;
    private String nombre = "nombreTest";
    private String descripcion = "descripcionTest";
    private float precio = 12.14f;
    private int id_categoria=15;
    private String MESSAGE_ERROR = "No se obtuvo el resultado esperado";

    @Test
    public void toDTO () {
        Producto producto = new Producto();
        producto.setId_producto(id_producto);
        producto.setNombre(nombre);
        producto.setPrecio(precio);
        producto.setDescripcion(descripcion);
        producto.setId_categoria(id_categoria);
        ProductoDTO productoDTO = ProductoMapper.toDTO(producto);

        Assertions.assertNotNull(productoDTO);
        Assertions.assertEquals(id_producto, productoDTO.getId_producto(), MESSAGE_ERROR);
        Assertions.assertEquals(nombre, productoDTO.getNombre(), MESSAGE_ERROR);
        Assertions.assertEquals(descripcion, productoDTO.getDescripcion(), MESSAGE_ERROR);
        Assertions.assertEquals(precio, productoDTO.getPrecio(), MESSAGE_ERROR);
        Assertions.assertEquals(id_categoria, productoDTO.getId_categoria(), MESSAGE_ERROR);
    }

    @Test
    public void toEntity() {
        ProductoDTO productoDTO = new ProductoDTO();
        productoDTO.setId_producto(id_producto);
        productoDTO.setNombre(nombre);
        productoDTO.setDescripcion(descripcion);
        productoDTO.setPrecio(precio);
        productoDTO.setId_categoria(id_categoria);
        Producto producto = ProductoMapper.toEntity(productoDTO);

        Assertions.assertNotNull(producto);
        Assertions.assertEquals(id_producto, producto.getId_producto(), MESSAGE_ERROR);
        Assertions.assertEquals(nombre, producto.getNombre(), MESSAGE_ERROR);
        Assertions.assertEquals(descripcion, producto.getDescripcion(), MESSAGE_ERROR);
        Assertions.assertEquals(precio, producto.getPrecio(), MESSAGE_ERROR);
        Assertions.assertEquals(id_categoria, producto.getId_categoria(), MESSAGE_ERROR);

    }
            ;
}
