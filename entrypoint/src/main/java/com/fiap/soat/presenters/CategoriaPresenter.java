package com.fiap.soat.presenters;

import com.fiap.soat.dto.CategoriaDTO;
import com.fiap.soat.entities.Categoria;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoriaPresenter {

    @Autowired
    private ModelMapper mapper;

    public CategoriaDTO categoriaToCategoriaDTO(Categoria categoria) {
        return this.mapper.map(categoria, CategoriaDTO.class);
    }

    public Categoria categoriaDTOToCategoria(CategoriaDTO categoriaDTO) {
        return this.mapper.map(categoriaDTO, Categoria.class);
    }

}
