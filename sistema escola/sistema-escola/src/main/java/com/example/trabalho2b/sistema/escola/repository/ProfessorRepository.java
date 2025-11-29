package com.example.trabalho2b.sistema.escola.repository;

import com.example.trabalho2b.sistema.escola.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    boolean existsByMatricula(String matricula);

    boolean existsByCpf(String cpf);
}
