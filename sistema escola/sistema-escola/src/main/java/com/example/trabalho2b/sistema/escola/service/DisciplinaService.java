package com.example.trabalho2b.sistema.escola.service;

import com.example.trabalho2b.sistema.escola.dto.DisciplinaDTO;
import com.example.trabalho2b.sistema.escola.model.Disciplina;
import com.example.trabalho2b.sistema.escola.model.Professor;
import com.example.trabalho2b.sistema.escola.repository.DisciplinaRepository;
import com.example.trabalho2b.sistema.escola.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DisciplinaService {
    private final DisciplinaRepository disciplinaRepository;
    private final ProfessorRepository professorRepository;

    public DisciplinaService(DisciplinaRepository disciplinaRepository, ProfessorRepository professorRepository) {
        this.disciplinaRepository = disciplinaRepository;
        this.professorRepository = professorRepository;
    }

    // Converter entidade → DTO
    private DisciplinaDTO toDTO(Disciplina d) {
        DisciplinaDTO dto = new DisciplinaDTO();
        dto.setId(d.getId());
        dto.setProfessorId(d.getProfessor().getId());
        dto.setCodigo(d.getCodigo());
        dto.setDescricao(d.getDescricao());
        dto.setEmenta(d.getEmenta());
        return dto;
    }

    // Converter DTO → entidade
    private Disciplina toEntity(DisciplinaDTO dto) {

        Disciplina d = new Disciplina();

        if (dto.getId() != null) {
            d.setId(dto.getId());
        }

        Professor professor = professorRepository.findById(dto.getProfessorId())
                .orElseThrow(() -> new RuntimeException("Professor não encontrado"));

        d.setProfessor(professor);
        d.setCodigo(dto.getCodigo());
        d.setDescricao(dto.getDescricao());
        d.setEmenta(dto.getEmenta());

        return d;
    }

    // CRUD

    public DisciplinaDTO criar(DisciplinaDTO dto) {
        if (disciplinaRepository.existsByCodigo(dto.getCodigo())) {
            throw new RuntimeException("Código já existe!");
        }

        Disciplina disciplina = toEntity(dto);
        return toDTO(disciplinaRepository.save(disciplina));
    }

    public List<DisciplinaDTO> listar() {
        return disciplinaRepository.findAll()
                .stream().map(this::toDTO)
                .collect(Collectors.toList());
    }

    public DisciplinaDTO buscarPorId(Long id) {
        return disciplinaRepository.findById(id)
                .map(this::toDTO)
                .orElseThrow(() -> new RuntimeException("Disciplina não encontrada"));
    }

    public DisciplinaDTO atualizar(Long id, DisciplinaDTO dto) {
        Disciplina existente = disciplinaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Disciplina não encontrada"));

        existente.setCodigo(dto.getCodigo());
        existente.setDescricao(dto.getDescricao());
        existente.setEmenta(dto.getEmenta());

        Professor professor = professorRepository.findById(dto.getProfessorId())
                .orElseThrow(() -> new RuntimeException("Professor não encontrado"));

        existente.setProfessor(professor);

        return toDTO(disciplinaRepository.save(existente));
    }

    public void deletar(Long id) {
        disciplinaRepository.deleteById(id);
    }
}
