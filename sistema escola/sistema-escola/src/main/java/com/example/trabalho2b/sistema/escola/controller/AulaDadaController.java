package com.example.trabalho2b.sistema.escola.controller;

import com.example.trabalho2b.sistema.escola.dto.AulaDadaRequestDTO;
import com.example.trabalho2b.sistema.escola.model.AulaDada;
import com.example.trabalho2b.sistema.escola.service.AulaDadaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/aula")
@RequiredArgsConstructor
public class AulaDadaController {

    private final AulaDadaService aulaService;

    @PostMapping("/disciplina/{idDisciplina}")
    public AulaDada cadastrarAula(@PathVariable Long idDisciplina,
                                  @RequestBody AulaDadaRequestDTO dto) {
        return aulaService.cadastrarAula(idDisciplina, dto);
    }
}
