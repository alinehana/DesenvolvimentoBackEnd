package com.example.trabalho2b.sistema.escola.repository;

import com.example.trabalho2b.sistema.escola.model.AlunoDisciplina;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AlunoDisciplinaRepository extends JpaRepository<AlunoDisciplina, Long> {
    Optional<AlunoDisciplina> findByAlunoIdAndDisciplinaId(Long idAluno, Long idDisciplina);
    List<AlunoDisciplina> findByAlunoId(Long idAluno);

}
