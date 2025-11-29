package com.example.trabalho2b.sistema.escola.service;

import com.example.trabalho2b.sistema.escola.model.Aluno;
import com.example.trabalho2b.sistema.escola.model.AlunoDisciplina;
import com.example.trabalho2b.sistema.escola.model.Disciplina;
import com.example.trabalho2b.sistema.escola.model.SituacaoAluno;
import com.example.trabalho2b.sistema.escola.repository.AlunoDisciplinaRepository;
import com.example.trabalho2b.sistema.escola.repository.AlunoRepository;
import com.example.trabalho2b.sistema.escola.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatriculaService {
    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @Autowired
    private AlunoDisciplinaRepository alunoDisciplinaRepository;

    public void matricular(Long idAluno, Long idDisciplina) {

        Aluno aluno = alunoRepository.findById(idAluno)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        Disciplina disciplina = disciplinaRepository.findById(idDisciplina)
                .orElseThrow(() -> new RuntimeException("Disciplina não encontrada"));

        AlunoDisciplina ad = new AlunoDisciplina();
        ad.setAluno(aluno);
        ad.setDisciplina(disciplina);
        ad.setMatriculado(true);
        ad.setSituacao(SituacaoAluno.valueOf("EM_CURSO"));

        alunoDisciplinaRepository.save(ad);
    }
}
