package com.example.trabalho2b.sistema.escola.service;

import com.example.trabalho2b.sistema.escola.dto.AtualizarPrimeiroBimestreDTO;
import com.example.trabalho2b.sistema.escola.dto.AtualizarSegundoBimestreDTO;
import com.example.trabalho2b.sistema.escola.model.AlunoDisciplina;
import com.example.trabalho2b.sistema.escola.model.SituacaoAluno;
import com.example.trabalho2b.sistema.escola.repository.AlunoDisciplinaRepository;
import com.example.trabalho2b.sistema.escola.repository.AulaDadaAlunoRepository;
import com.example.trabalho2b.sistema.escola.repository.AulaDadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoDisciplinaService {
    @Autowired
    private AlunoDisciplinaRepository alunoDisciplinaRepository;

    @Autowired
    private AulaDadaRepository aulaDadaRepository;

    @Autowired
    private AulaDadaAlunoRepository aulaDadaAlunoRepository;

    public AlunoDisciplina atualizarSegundoBimestre(Long idAluno, Long idDisciplina, AtualizarSegundoBimestreDTO dto) {

        AlunoDisciplina ad = alunoDisciplinaRepository
                .findByAlunoIdAndDisciplinaId(idAluno, idDisciplina)
                .orElseThrow(() -> new RuntimeException("Matrícula não encontrada"));

        ad.setNota2Bim(dto.getNota2Bim());
        ad.setFaltas2Bim(dto.getFaltas2Bim());

        Double n1 = ad.getNota1Bim();
        Double n2 = ad.getNota2Bim();

        Double media = null;
        if (n1 != null && n2 != null) {
            media = (n1 + n2) / 2.0;
        }

        long totalAulas = aulaDadaRepository.countByDisciplinaId(idDisciplina);

        // contar presenças do aluno (falta = false)
        long presencas = aulaDadaAlunoRepository.countByAlunoIdAndAulaDadaDisciplinaIdAndFaltaFalse(idAluno, idDisciplina);

        double percentualPresenca = 0.0;
        if (totalAulas > 0) {
            percentualPresenca = (presencas * 100.0) / totalAulas;
        } else {
            percentualPresenca = 0.0;
        }

        if (media != null) {
            boolean notaAprovada = media >= 6.0;
            boolean presencaOK = percentualPresenca >= 25.0; // mínimo 25% presença

            if (notaAprovada && presencaOK) {
                ad.setSituacao(SituacaoAluno.APROVADO);
                ad.setMatriculado(false); // aprovado = não está mais matriculado
            } else {
                // qualquer falha em nota ou presença = reprovado
                ad.setSituacao(SituacaoAluno.REPROVADO);
                // se reprovado, matriculado continua true
                ad.setMatriculado(true);
            }
        } else {
            ad.setSituacao(SituacaoAluno.EM_CURSO);
        }

        return alunoDisciplinaRepository.save(ad);
    }

    public void atualizarPrimeiroBimestre(Long idAluno, Long idDisciplina, AtualizarPrimeiroBimestreDTO dto) {
    }
}
