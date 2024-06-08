package es.fitfemme.negocio.mapper;

import es.fitfemme.negocio.dto.ProductoDTO;
import es.fitfemme.negocio.entities.Producto;

public class ProductoMapper {

    public static ProductoDTO toDTO (Producto producto) {
        ProductoDTO productoDTO = new ProductoDTO();
        productoDTO.setId_producto(producto.getId_producto());
        productoDTO.setNombre(producto.getNombre());
        productoDTO.setDescripcion(producto.getDescripcion());
        productoDTO.setId_categoria(producto.getId_categoria());
        productoDTO.setPrecio(producto.getPrecio());

        return productoDTO;
    }

    public static Producto toEntity (ProductoDTO productoDTO) {
        Producto producto = new Producto();
        producto.setId_producto(productoDTO.getId_producto());
        producto.setNombre(productoDTO.getNombre());
        producto.setDescripcion(productoDTO.getDescripcion());
        producto.setPrecio(productoDTO.getPrecio());
        producto.setId_categoria(productoDTO.getId_categoria());

        return producto;
    }

}
