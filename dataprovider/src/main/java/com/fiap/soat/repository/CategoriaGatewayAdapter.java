package com.fiap.soat.repository;

import com.fiap.soat.entities.Categoria;
import com.fiap.soat.entities.CategoriaEntity;
import com.fiap.soat.exceptions.NotFoundException;
import com.fiap.soat.mapper.CategoriaMapper;
import com.fiap.soat.ports.gateways.CategoriaGatewayPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoriaGatewayAdapter implements CategoriaGatewayPort {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private CategoriaMapper categoriaMapper;

    @Override
    public Categoria buscarCategoriaPorId(Long id) {
        CategoriaEntity categoriaEntity = this.categoriaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Categoria não encontrada com o ID informado."));
        return categoriaMapper.categoriaEntityToCategoria(categoriaEntity);
    }

    @Override
    public Categoria salvarCategoria(Categoria categoria) {
        CategoriaEntity categoriaEntity = this.categoriaRepository.save(categoriaMapper.categoriaToCategoriaEntity(categoria));
        return categoriaMapper.categoriaEntityToCategoria(categoriaEntity);
    }

    @Override
    public Categoria editarCategoria(Categoria categoria) {
        CategoriaEntity categoriaEntity = this.categoriaRepository.save(categoriaMapper.categoriaToCategoriaEntity(categoria));
        return categoriaMapper.categoriaEntityToCategoria(categoriaEntity);
    }

    @Override
    public List<Categoria> buscarCategorias() {
        List<CategoriaEntity> listaCategoriaEntity = this.categoriaRepository.findAll();
        return listaCategoriaEntity.stream().map(categoriaEntity -> categoriaMapper.categoriaEntityToCategoria(categoriaEntity)).toList();
    }

}
