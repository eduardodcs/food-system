package com.fiap.soat.foodsystem.domain.services;

import com.fiap.soat.foodsystem.domain.model.Categoria;
import com.fiap.soat.foodsystem.domain.ports.CategoriaRepositoryPort;
import com.fiap.soat.foodsystem.domain.ports.CategoriaServicePort;

import java.util.List;

public class CategoriaService implements CategoriaServicePort {

    private CategoriaRepositoryPort categoriaRepositoryPort;

    public CategoriaService(CategoriaRepositoryPort categoriaRepositoryPort) {
        this.categoriaRepositoryPort = categoriaRepositoryPort;
    }

    @Override
    public Categoria buscarCategoriaPorId(Long id) {
        return this.categoriaRepositoryPort.buscarCategoriaPorId(id);
    }

    @Override
    public Categoria salvarCategoria(Categoria categoria) {
        categoria.setStatusAtivo(true);
        return this.categoriaRepositoryPort.salvarCategoria(categoria);
    }

    @Override
    public Categoria editarCategoria(Categoria categoria) {
        Categoria categoriaOriginal = this.buscarCategoriaPorId(categoria.getId());
        categoriaOriginal.setNome(categoria.getNome());
        return this.categoriaRepositoryPort.editarCategoria(categoriaOriginal);
    }

    @Override
    public void inativarCategoria(Long id) {
        Categoria categoria = this.buscarCategoriaPorId(id);
        categoria.setStatusAtivo(!categoria.isStatusAtivo());
        this.categoriaRepositoryPort.salvarCategoria(categoria);
    }

    @Override
    public List<Categoria> buscarCategorias() {
        return this.categoriaRepositoryPort.buscarCategorias();
    }

}
