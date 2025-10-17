package com.unipar.questaobackend.questao.back.end.services;

import com.unipar.questaobackend.questao.back.end.model.Produto;
import com.unipar.questaobackend.questao.back.end.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    // Listar todos
    public List<Produto> getAll() {
        return produtoRepository.findAll();
    }

    // Buscar por id
    public Optional<Produto> getById(Long id) {
        return produtoRepository.findById(id);
    }

    // Criar novo
    public Produto create(Produto produto) {
        return produtoRepository.save(produto);
    }

    // Atualizar existente
    public Produto update(Long id, Produto produto) {
        return produtoRepository.findById(id)
                .map(p -> {
                    p.setNome(produto.getNome());
                    p.setPreco(produto.getPreco());
                    return produtoRepository.save(p);
                })
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    // Deletar por id
    public void delete(Long id) {
        produtoRepository.deleteById(id);
    }
}
