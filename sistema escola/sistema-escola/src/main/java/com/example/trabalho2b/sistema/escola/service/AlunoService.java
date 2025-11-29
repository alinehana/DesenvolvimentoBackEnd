package com.example.trabalho2b.sistema.escola.service;

import com.example.trabalho2b.sistema.escola.dto.AlunoRequestDTO;
import com.example.trabalho2b.sistema.escola.dto.AlunoResponseDTO;
import com.example.trabalho2b.sistema.escola.model.Aluno;
import com.example.trabalho2b.sistema.escola.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepository;

    public AlunoResponseDTO cadastrar(AlunoRequestDTO dto) {

        Aluno aluno = new Aluno();
        aluno.setNome(dto.getNome());
        aluno.setCpf(dto.getCpf());
        aluno.setRa(dto.getRa());
        aluno.setAnoIngresso(dto.getAnoIngresso());
        aluno.setPeriodoAtual(dto.getPeriodoAtual());

        aluno = alunoRepository.save(aluno);

        return new AlunoResponseDTO(
                aluno.getId(),
                aluno.getNome(),
                aluno.getCpf(),
                aluno.getRa(),
                aluno.getAnoIngresso(),
                aluno.getPeriodoAtual()
        );
    }

    public AlunoResponseDTO atualizar(AlunoRequestDTO dto) {

        Aluno aluno = alunoRepository.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        aluno.setNome(dto.getNome());
        aluno.setCpf(dto.getCpf());
        aluno.setRa(dto.getRa());
        aluno.setAnoIngresso(dto.getAnoIngresso());
        aluno.setPeriodoAtual(dto.getPeriodoAtual());

        aluno = alunoRepository.save(aluno);

        return new AlunoResponseDTO(
                aluno.getId(),
                aluno.getNome(),
                aluno.getCpf(),
                aluno.getRa(),
                aluno.getAnoIngresso(),
                aluno.getPeriodoAtual()
        );
    }

    public AlunoResponseDTO buscarPorId(Long id) {
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        return new AlunoResponseDTO(
                aluno.getId(),
                aluno.getNome(),
                aluno.getCpf(),
                aluno.getRa(),
                aluno.getAnoIngresso(),
                aluno.getPeriodoAtual()
        );
    }

    public List<AlunoResponseDTO> listarTodos() {
        return alunoRepository.findAll()
                .stream()
                .map(aluno -> new AlunoResponseDTO(
                        aluno.getId(),
                        aluno.getNome(),
                        aluno.getCpf(),
                        aluno.getRa(),
                        aluno.getAnoIngresso(),
                        aluno.getPeriodoAtual()
                ))
                .toList();
    }
}
