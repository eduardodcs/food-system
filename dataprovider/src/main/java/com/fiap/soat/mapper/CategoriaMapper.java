package com.fiap.soat.mapper;

import com.fiap.soat.entities.Categoria;
import com.fiap.soat.entities.CategoriaEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoriaMapper {

    @Autowired
    private ModelMapper mapper;

    public CategoriaEntity categoriaToCategoriaEntity(Categoria categoria) {
        return this.mapper.map(categoria, CategoriaEntity.class);
    }

    public Categoria categoriaEntityToCategoria(CategoriaEntity categoriaEntity) {
        return this.mapper.map(categoriaEntity, Categoria.class);
    }

}
