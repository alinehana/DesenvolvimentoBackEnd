package com.example.trabalho2b.sistema.escola.service;

import com.example.trabalho2b.sistema.escola.dto.PresencaDTO;
import com.example.trabalho2b.sistema.escola.model.Aluno;
import com.example.trabalho2b.sistema.escola.model.AulaDada;
import com.example.trabalho2b.sistema.escola.model.AulaDadaAluno;
import com.example.trabalho2b.sistema.escola.repository.AlunoRepository;
import com.example.trabalho2b.sistema.escola.repository.AulaDadaAlunoRepository;
import com.example.trabalho2b.sistema.escola.repository.AulaDadaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AulaDadaAlunoService {
    private final AulaDadaRepository aulaDadaRepository;
    private final AlunoRepository alunoRepository;
    private final AulaDadaAlunoRepository aulaDadaAlunoRepository;

    public void registrarPresencas(Long idAula, List<PresencaDTO> presencas) {

        AulaDada aula = aulaDadaRepository.findById(idAula)
                .orElseThrow(() -> new RuntimeException("Aula não encontrada"));

        for (PresencaDTO p : presencas) {

            Aluno aluno = alunoRepository.findById(p.getAlunoId())
                    .orElseThrow(() -> new RuntimeException("Aluno não encontrado: " + p.getAlunoId()));

            AulaDadaAluno registro = new AulaDadaAluno();
            registro.setAulaDada(aula);
            registro.setAluno(aluno);
            registro.setFalta(p.isFalta());

            aulaDadaAlunoRepository.save(registro);
        }
    }
}
