package com.example.trabalho2b.sistema.escola.service;

import com.example.trabalho2b.sistema.escola.dto.Boletim;
import com.example.trabalho2b.sistema.escola.dto.ItemBoletim;
import com.example.trabalho2b.sistema.escola.model.Aluno;
import com.example.trabalho2b.sistema.escola.model.AlunoDisciplina;
import com.example.trabalho2b.sistema.escola.repository.AlunoDisciplinaRepository;
import com.example.trabalho2b.sistema.escola.repository.AlunoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoletimService {
    private final AlunoRepository alunoRepository;
    private final AlunoDisciplinaRepository alunoDisciplinaRepository;

    public Boletim gerarBoletim(Long idAluno) {
        Aluno aluno = alunoRepository.findById(idAluno)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        List<AlunoDisciplina> matriculas =
                alunoDisciplinaRepository.findByAlunoId(idAluno);

        List<ItemBoletim> itens = matriculas.stream().map(m -> {
            ItemBoletim item = new ItemBoletim();

            item.setIdDisciplina(m.getDisciplina().getId());
            item.setCodigo(m.getDisciplina().getCodigo());
            item.setDescricao(m.getDisciplina().getDescricao());

            item.setNota1Bim(m.getNota1Bim());
            item.setNota2Bim(m.getNota2Bim());

            item.setFaltas1Bim(m.getFaltas1Bim());
            item.setFaltas2Bim(m.getFaltas2Bim());

            Double media = calcularMediaFinal(m.getNota1Bim(), m.getNota2Bim());
            item.setMediaFinal(media);

            Integer totalFaltas = somarFaltas(m.getFaltas1Bim(), m.getFaltas2Bim());
            item.setTotalFaltas(totalFaltas);

            item.setSituacao(m.getSituacao().toString());
            item.setMatriculado(m.getMatriculado());

            return item;
        }).collect(Collectors.toList());

        return new Boletim(
                aluno.getId(),
                aluno.getNome(),
                itens
        );
    }

    private Double calcularMediaFinal(Double n1, Double n2) {
        if (n1 == null || n2 == null) return null;
        return (n1 + n2) / 2.0;
    }

    private Integer somarFaltas(Integer f1, Integer f2) {
        int faltas1 = f1 != null ? f1 : 0;
        int faltas2 = f2 != null ? f2 : 0;
        return faltas1 + faltas2;
    }
}
