package es.fit.femme.model.mapper;

import es.fit.femme.business.entities.Categoria;
import es.fit.femme.model.dto.CategoriaDTO;

public class CategoriaMapper {

    public static Categoria toEntity (CategoriaDTO categoriaDTO) {
        Categoria categoria = new Categoria();
        categoria.setId(categoriaDTO.getId());
        categoria.setNombre(categoriaDTO.getNombre());
        categoria.setDescripcion(categoriaDTO.getDescripcion());
        categoria.setProductos(categoriaDTO.getProductos());

        return categoria;
    }

    public static CategoriaDTO toDto (Categoria categoria) {
        CategoriaDTO categoriaDTO = new CategoriaDTO();
        categoriaDTO.setId(categoria.getId());
        categoriaDTO.setNombre(categoria.getNombre());
        categoriaDTO.setDescripcion(categoria.getDescripcion());
        categoriaDTO.setProductos(categoria.getProductos());
        return categoriaDTO;
    }
}
