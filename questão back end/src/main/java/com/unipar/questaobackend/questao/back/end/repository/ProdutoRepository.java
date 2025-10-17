package com.unipar.questaobackend.questao.back.end.repository;

import com.unipar.questaobackend.questao.back.end.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
