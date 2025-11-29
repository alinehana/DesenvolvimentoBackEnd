package com.example.trabalho2b.sistema.escola.controller;

import com.example.trabalho2b.sistema.escola.dto.ProfessorRequestDTO;
import com.example.trabalho2b.sistema.escola.dto.ProfessorResponseDTO;
import com.example.trabalho2b.sistema.escola.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/professor")
public class ProfessorController {
    @Autowired
    private ProfessorService professorService;

    @PostMapping
    public ProfessorResponseDTO criar(@RequestBody ProfessorRequestDTO dto) {
        return professorService.salvar(dto);
    }

    @PutMapping
    public ProfessorResponseDTO atualizar(@RequestBody ProfessorRequestDTO dto) {
        return professorService.atualizar(dto);
    }

    @GetMapping("/{id}")
    public ProfessorResponseDTO buscarPorId(@PathVariable Long id) {
        return professorService.buscarPorId(id);
    }

    @GetMapping("/todos")
    public List<ProfessorResponseDTO> listarTodos() {
        return professorService.listarTodos();
    }
}
