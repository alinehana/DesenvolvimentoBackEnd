package com.example.trabalho2b.sistema.escola.service;

import com.example.trabalho2b.sistema.escola.dto.ProfessorRequestDTO;
import com.example.trabalho2b.sistema.escola.dto.ProfessorResponseDTO;
import com.example.trabalho2b.sistema.escola.model.Professor;
import com.example.trabalho2b.sistema.escola.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;

    public ProfessorResponseDTO salvar(ProfessorRequestDTO dto) {

        // Validações simples
        if (professorRepository.existsByMatricula(dto.getMatricula())) {
            throw new RuntimeException("Matrícula já cadastrada");
        }

        if (professorRepository.existsByCpf(dto.getCpf())) {
            throw new RuntimeException("CPF já cadastrado");
        }

        Professor p = new Professor();
        p.setMatricula(dto.getMatricula());
        p.setNome(dto.getNome());
        p.setCpf(dto.getCpf());

        Professor salvo = professorRepository.save(p);

        ProfessorResponseDTO resp = new ProfessorResponseDTO();
        resp.setId(salvo.getId());
        resp.setMatricula(salvo.getMatricula());
        resp.setNome(salvo.getNome());
        resp.setCpf(salvo.getCpf());

        return resp;
    }

    public ProfessorResponseDTO atualizar(ProfessorRequestDTO dto) {

        Professor existente = professorRepository.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException("Professor não encontrado"));

        existente.setNome(dto.getNome());
        existente.setCpf(dto.getCpf());
        existente.setMatricula(dto.getMatricula());

        Professor salvo = professorRepository.save(existente);

        ProfessorResponseDTO resp = new ProfessorResponseDTO();
        resp.setId(salvo.getId());
        resp.setMatricula(salvo.getMatricula());
        resp.setNome(salvo.getNome());
        resp.setCpf(salvo.getCpf());

        return resp;
    }

    public ProfessorResponseDTO buscarPorId(Long id) {

        Professor p = professorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado"));

        ProfessorResponseDTO resp = new ProfessorResponseDTO();
        resp.setId(p.getId());
        resp.setMatricula(p.getMatricula());
        resp.setNome(p.getNome());
        resp.setCpf(p.getCpf());

        return resp;
    }

    public List<ProfessorResponseDTO> listarTodos() {

        return professorRepository.findAll()
                .stream()
                .map(p -> {
                    ProfessorResponseDTO dto = new ProfessorResponseDTO();
                    dto.setId(p.getId());
                    dto.setMatricula(p.getMatricula());
                    dto.setNome(p.getNome());
                    dto.setCpf(p.getCpf());
                    return dto;
                }).toList();
    }
}
