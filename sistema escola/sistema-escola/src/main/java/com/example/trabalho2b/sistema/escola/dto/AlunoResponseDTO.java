package com.example.trabalho2b.sistema.escola.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlunoResponseDTO {
    private Long id;
    private String nome;
    private String cpf;
    private String ra;
    private Integer anoIngresso;
    private Integer periodoAtual;
}
