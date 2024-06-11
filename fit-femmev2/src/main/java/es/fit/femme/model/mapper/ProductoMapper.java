package es.fit.femme.model.mapper;

import es.fit.femme.model.entities.Producto;
import es.fit.femme.model.dto.ProductoDTO;

public class ProductoMapper {

    public static Producto toEntity (ProductoDTO productoDTO) {
        Producto producto = new Producto();
        producto.setId(productoDTO.getId());
        producto.setNombre(productoDTO.getNombre());
        producto.setDescripcion(productoDTO.getDescripcion());
        producto.setCategoria(productoDTO.getCategoria());
        producto.setPrecio(productoDTO.getPrecio());
        return producto;
    }

    public static ProductoDTO toDto (Producto producto) {
        ProductoDTO productoDTO = new ProductoDTO();
        productoDTO.setId(producto.getId());
        productoDTO.setNombre(producto.getNombre());
        productoDTO.setDescripcion(producto.getDescripcion());
        productoDTO.setCategoria(producto.getCategoria());
        productoDTO.setPrecio(producto.getPrecio());
        return productoDTO;
    }
}
