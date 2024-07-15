package com.fiap.soat.usecases;

import com.fiap.soat.entities.Categoria;
import com.fiap.soat.ports.CategoriaGatewayPort;
import com.fiap.soat.ports.CategoriaUseCasePort;

import java.util.List;

public class CategoriaUseCase implements CategoriaUseCasePort {

    private CategoriaGatewayPort categoriaRepositoryPort;

    public CategoriaUseCase(CategoriaGatewayPort categoriaRepositoryPort) {
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
