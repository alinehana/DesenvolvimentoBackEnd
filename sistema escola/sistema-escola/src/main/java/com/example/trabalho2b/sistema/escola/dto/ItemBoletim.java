package com.example.trabalho2b.sistema.escola.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemBoletim {
    private Long idDisciplina;
    private String codigo;
    private String descricao;

    private Double nota1Bim;
    private Double nota2Bim;

    private Integer faltas1Bim;
    private Integer faltas2Bim;

    private Double mediaFinal;
    private Integer totalFaltas;

    private String situacao;
    private boolean matriculado;
}
