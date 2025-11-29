package com.example.trabalho2b.sistema.escola.repository;

import com.example.trabalho2b.sistema.escola.model.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
    boolean existsByCodigo(String codigo);

}
