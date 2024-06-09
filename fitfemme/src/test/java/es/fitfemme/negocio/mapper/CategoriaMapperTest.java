package es.fitfemme.negocio.mapper;

import es.fitfemme.negocio.dto.CategoriaDTO;
import es.fitfemme.negocio.entities.Categoria;
import es.fitfemme.negocio.entities.Producto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CategoriaMapperTest {
    private int id_categoria = 1;
    private String nombre = "nombreTest";
    private int total_productos_categoria = 10;
    private String MESSAGE_ERROR = "No se obtuvo el resultado esperado";

    @Test
    public void toDTOTest() {
        Categoria categoria = new Categoria();
        categoria.setId_categoria(id_categoria);
        categoria.setNombre(nombre);
        List<Producto> productos = new ArrayList<>() ;
        productos.add(new Producto(1));
        categoria.setProductos(productos);

        CategoriaDTO categoriaDTO = CategoriaMapper.toDTO(categoria);

        Assertions.assertNotNull(categoriaDTO, MESSAGE_ERROR);
        Assertions.assertEquals(id_categoria, categoriaDTO.getId_categoria(), MESSAGE_ERROR);
        Assertions.assertEquals(nombre, categoriaDTO.getNombre(), MESSAGE_ERROR);
        Assertions.assertEquals(productos.size(), categoriaDTO.getTotal_productos_categoria(), MESSAGE_ERROR);
    }

    @Test
    public void toEntityTest() {
        CategoriaDTO categoriaDTO = new CategoriaDTO();
        categoriaDTO.setId_categoria(id_categoria);
        categoriaDTO.setNombre(nombre);
        categoriaDTO.setTotal_productos_categoria(total_productos_categoria);

        Categoria categoria = CategoriaMapper.toEntity(categoriaDTO);

        Assertions.assertNotNull(categoria, MESSAGE_ERROR);
        Assertions.assertEquals(id_categoria, categoriaDTO.getId_categoria(), MESSAGE_ERROR);
        Assertions.assertEquals(nombre, categoriaDTO.getNombre(), MESSAGE_ERROR);
        Assertions.assertEquals(total_productos_categoria, categoriaDTO.getTotal_productos_categoria(), MESSAGE_ERROR);

    }
}
