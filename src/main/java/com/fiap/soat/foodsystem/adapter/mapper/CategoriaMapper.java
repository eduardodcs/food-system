package com.fiap.soat.foodsystem.adapter.mapper;

import com.fiap.soat.foodsystem.modules.dto.CategoriaDTO;
import com.fiap.soat.foodsystem.modules.domain.entities.CategoriaEntity;
import com.fiap.soat.foodsystem.modules.domain.model.Categoria;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoriaMapper {

    @Autowired
    private ModelMapper mapper;

    public CategoriaDTO categoriaToCategoriaDTO(Categoria categoria) {
        return this.mapper.map(categoria, CategoriaDTO.class);
    }

    public Categoria categoriaDTOToCategoria(CategoriaDTO categoriaDTO) {
        return this.mapper.map(categoriaDTO, Categoria.class);
    }

    public CategoriaEntity categoriaToCategoriaEntity(Categoria categoria) {
        return this.mapper.map(categoria, CategoriaEntity.class);
    }

    public Categoria categoriaEntityToCategoria(CategoriaEntity categoriaEntity) {
        return this.mapper.map(categoriaEntity, Categoria.class);
    }

}
