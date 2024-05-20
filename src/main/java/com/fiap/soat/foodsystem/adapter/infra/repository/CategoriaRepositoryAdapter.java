package com.fiap.soat.foodsystem.adapter.infra.repository;

import java.util.List;
import java.util.stream.Collectors;

import com.fiap.soat.foodsystem.common.exception.NotFoundException;
import com.fiap.soat.foodsystem.domain.model.Categoria;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fiap.soat.foodsystem.adapter.entities.CategoriaEntity;
import com.fiap.soat.foodsystem.domain.ports.CategoriaRepositoryPort;

@Component
public class CategoriaRepositoryAdapter implements CategoriaRepositoryPort {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public Categoria buscarCategoriaPorId(Long id) {
        CategoriaEntity categoriaEntity = this.categoriaRepository.findById(id).orElseThrow(() -> new NotFoundException("Categoria não encontrada com o ID informado."));
        return this.mapper.map(categoriaEntity, Categoria.class);
    }

    @Override
    public Categoria salvarCategoria(Categoria categoria) {
        CategoriaEntity categoriaEntity = mapper.map(categoria, CategoriaEntity.class);
        CategoriaEntity categoriaSaved = this.categoriaRepository.save(categoriaEntity);
        return mapper.map(categoriaSaved, Categoria.class);
    }

    @Override
    public Categoria editarCategoria(Categoria categoria) {
        CategoriaEntity categoriaEntity = mapper.map(categoria, CategoriaEntity.class);
        CategoriaEntity categoriaSaved = this.categoriaRepository.save(categoriaEntity);
        return mapper.map(categoriaSaved, Categoria.class);
    }

    @Override
    public List<Categoria> buscarCategorias() {
        List<CategoriaEntity> listaCategoriaEntity = this.categoriaRepository.findAll();
        List<Categoria> listaCategoria = listaCategoriaEntity.stream().map(categoriaEntity -> this.mapper.map(categoriaEntity, Categoria.class)).collect(Collectors.toList());
        return listaCategoria;
    }

}
