package com.example.trabalho2b.sistema.escola.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Boletim {
    private Long idAluno;
    private String nomeAluno;
    private List<ItemBoletim> disciplinas;
}
