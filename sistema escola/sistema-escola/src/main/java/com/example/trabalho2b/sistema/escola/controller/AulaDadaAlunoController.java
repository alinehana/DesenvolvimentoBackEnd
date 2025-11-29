package com.example.trabalho2b.sistema.escola.controller;
import com.example.trabalho2b.sistema.escola.dto.PresencaDTO;
import com.example.trabalho2b.sistema.escola.service.AulaDadaAlunoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auladada")
@RequiredArgsConstructor
public class AulaDadaAlunoController {
    private final AulaDadaAlunoService presencaService;

    @PostMapping("/{idAula}")
    public String registrarPresencas(@PathVariable Long idAula,
                                     @RequestBody List<PresencaDTO> presencas) {

        presencaService.registrarPresencas(idAula, presencas);
        return "Presenças registradas com sucesso!";
    }
}
