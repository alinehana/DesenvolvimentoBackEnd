package com.example.trabalho2b.sistema.escola.repository;

import com.example.trabalho2b.sistema.escola.model.AulaDadaAluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AulaDadaAlunoRepository extends JpaRepository<AulaDadaAluno, Long> {
    // conta presenças (falta = false) do aluno em aulas daquela disciplina
    long countByAlunoIdAndAulaDadaDisciplinaIdAndFaltaFalse(Long alunoId, Long disciplinaId);

    //conta registros (presenças+faltas) para verificar consistência
    long countByAlunoIdAndAulaDadaDisciplinaId(Long alunoId, Long disciplinaId);
}
