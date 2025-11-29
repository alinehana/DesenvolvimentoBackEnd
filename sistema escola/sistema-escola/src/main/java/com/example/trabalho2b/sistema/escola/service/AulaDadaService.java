package com.example.trabalho2b.sistema.escola.service;

import com.example.trabalho2b.sistema.escola.dto.AulaDadaRequestDTO;
import com.example.trabalho2b.sistema.escola.model.AulaDada;
import com.example.trabalho2b.sistema.escola.model.Disciplina;
import com.example.trabalho2b.sistema.escola.repository.AulaDadaRepository;
import com.example.trabalho2b.sistema.escola.repository.DisciplinaRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class AulaDadaService {
    private final DisciplinaRepository disciplinaRepository;
    private final AulaDadaRepository aulaDadaRepository;

    public AulaDada cadastrarAula(Long idDisciplina, AulaDadaRequestDTO dto) {

        Disciplina disciplina = disciplinaRepository.findById(idDisciplina)
                .orElseThrow(() -> new RuntimeException("Disciplina não encontrada"));

        AulaDada aula = new AulaDada();
        aula.setDisciplina(disciplina);
        aula.setData(LocalDate.parse(dto.getData()));
        aula.setObservacoes(dto.getObservacoes());

        return aulaDadaRepository.save(aula);
    }
}
