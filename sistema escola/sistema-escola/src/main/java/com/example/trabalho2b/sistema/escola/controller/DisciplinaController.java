package com.example.trabalho2b.sistema.escola.controller;
import com.example.trabalho2b.sistema.escola.dto.DisciplinaDTO;
import com.example.trabalho2b.sistema.escola.service.DisciplinaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disciplinas")
@CrossOrigin(origins = "*")
public class DisciplinaController {
    private final DisciplinaService disciplinaService;

    public DisciplinaController(DisciplinaService disciplinaService) {
        this.disciplinaService = disciplinaService;
    }

    @PostMapping
    public DisciplinaDTO criar(@RequestBody DisciplinaDTO dto) {
        return disciplinaService.criar(dto);
    }

    @GetMapping
    public List<DisciplinaDTO> listar() {
        return disciplinaService.listar();
    }

    @GetMapping("/{id}")
    public DisciplinaDTO buscar(@PathVariable Long id) {
        return disciplinaService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public DisciplinaDTO atualizar(@PathVariable Long id, @RequestBody DisciplinaDTO dto) {
        return disciplinaService.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        disciplinaService.deletar(id);
    }
}
