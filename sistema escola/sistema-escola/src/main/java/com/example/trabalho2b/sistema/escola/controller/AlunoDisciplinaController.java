package com.example.trabalho2b.sistema.escola.controller;

import com.example.trabalho2b.sistema.escola.dto.AtualizarPrimeiroBimestreDTO;
import com.example.trabalho2b.sistema.escola.dto.AtualizarSegundoBimestreDTO;
import com.example.trabalho2b.sistema.escola.service.AlunoDisciplinaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/aluno")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class AlunoDisciplinaController {
    @Autowired
    private AlunoDisciplinaService service;

    @PutMapping("/{idAluno}/disciplina/{idDisciplina}/1bim")
    public ResponseEntity<String> atualizarPrimeiro(
            @PathVariable Long idAluno,
            @PathVariable Long idDisciplina,
            @RequestBody AtualizarPrimeiroBimestreDTO dto) {

        service.atualizarPrimeiroBimestre(idAluno, idDisciplina, dto);
        return ResponseEntity.ok("1º bimestre atualizado com sucesso!");
    }

    @PutMapping("/{idAluno}/disciplina/{idDisciplina}/2bim")
    public ResponseEntity<String> atualizarSegundo(
            @PathVariable Long idAluno,
            @PathVariable Long idDisciplina,
            @RequestBody AtualizarSegundoBimestreDTO dto) {

        service.atualizarSegundoBimestre(idAluno, idDisciplina, dto);
        return ResponseEntity.ok("2º bimestre atualizado com sucesso!");
    }
}
