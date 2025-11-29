package com.example.trabalho2b.sistema.escola.controller;

import com.example.trabalho2b.sistema.escola.dto.Boletim;
import com.example.trabalho2b.sistema.escola.service.BoletimService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/aluno")
@RequiredArgsConstructor
public class BoletimController {
    private final BoletimService boletimService;

    @GetMapping("/{id}/boletim")
    public Boletim getBoletim(@PathVariable Long id) {
        return boletimService.gerarBoletim(id);
    }
}
