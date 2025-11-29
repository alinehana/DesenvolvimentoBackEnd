package com.example.trabalho2b.sistema.escola.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DisciplinaDTO {
    private Long id;
    private Long professorId;
    private String codigo;
    private String descricao;
    private String ementa;
}
