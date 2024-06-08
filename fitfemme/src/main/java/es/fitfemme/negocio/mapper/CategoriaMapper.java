package es.fitfemme.negocio.mapper;

import es.fitfemme.negocio.dto.CategoriaDTO;
import es.fitfemme.negocio.entities.Categoria;

public class CategoriaMapper {
    public static CategoriaDTO toDTO(Categoria categoria) {
        if (categoria == null) {
            return null;
        }

        CategoriaDTO categoriaDTO = new CategoriaDTO();
        categoriaDTO.setId_categoria(categoria.getId_categoria());
        categoriaDTO.setNombre(categoria.getNombre());

        if (categoria.getProductos() != null) {
            categoriaDTO.setTotal_productos_categoria(categoria.getProductos().size());
        } else {
            categoriaDTO.setTotal_productos_categoria(0);
        }

        return categoriaDTO;
    }

    public static Categoria toEntity(CategoriaDTO categoriaDTO) {
        if (categoriaDTO == null) {
            return null;
        }

        Categoria categoria = new Categoria();
        categoria.setId_categoria(categoriaDTO.getId_categoria());
        categoria.setNombre(categoriaDTO.getNombre());


        return categoria;
    }
}
