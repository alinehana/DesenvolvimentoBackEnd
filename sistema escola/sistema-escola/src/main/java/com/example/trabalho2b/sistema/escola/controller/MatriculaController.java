package com.example.trabalho2b.sistema.escola.controller;

import com.example.trabalho2b.sistema.escola.dto.MatriculaRequestDTO;
import com.example.trabalho2b.sistema.escola.model.Aluno;
import com.example.trabalho2b.sistema.escola.model.AlunoDisciplina;
import com.example.trabalho2b.sistema.escola.model.Disciplina;
import com.example.trabalho2b.sistema.escola.model.SituacaoAluno;
import com.example.trabalho2b.sistema.escola.repository.AlunoDisciplinaRepository;
import com.example.trabalho2b.sistema.escola.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/matriculas")
public class MatriculaController {
    @Autowired
    private MatriculaService matriculaService;

    @PostMapping
    public ResponseEntity<String> matricular(@RequestBody MatriculaRequestDTO dto) {
        matriculaService.matricular(dto.getIdAluno(), dto.getIdDisciplina());
        return ResponseEntity.ok("Aluno matriculado com sucesso!");
    }
}
