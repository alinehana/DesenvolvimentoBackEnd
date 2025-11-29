package com.example.trabalho2b.sistema.escola.controller;
import com.example.trabalho2b.sistema.escola.dto.AlunoRequestDTO;
import com.example.trabalho2b.sistema.escola.dto.AlunoResponseDTO;
import com.example.trabalho2b.sistema.escola.service.AlunoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/aluno")
public class AlunoController {
    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping
    public AlunoResponseDTO cadastrar(@RequestBody AlunoRequestDTO dto) {
        return alunoService.cadastrar(dto);
    }

    @PutMapping
    public AlunoResponseDTO atualizar(@RequestBody AlunoRequestDTO dto) {
        return alunoService.atualizar(dto);
    }

    @GetMapping("/{id}")
    public AlunoResponseDTO buscarPorId(@PathVariable Long id) {
        return alunoService.buscarPorId(id);
    }

    @GetMapping("/todos")
    public List<AlunoResponseDTO> listarTodos() {
        return alunoService.listarTodos();
    }
}
