package com.example.trabalho2b.sistema.escola.repository;

import com.example.trabalho2b.sistema.escola.model.AulaDada;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AulaDadaRepository extends JpaRepository<AulaDada, Long> {
    long countByDisciplinaId(Long disciplinaId);

}
