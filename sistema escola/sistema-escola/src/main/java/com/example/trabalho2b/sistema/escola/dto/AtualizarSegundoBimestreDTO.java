package com.example.trabalho2b.sistema.escola.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AtualizarSegundoBimestreDTO {
    private Double nota2Bim;
    private Integer faltas2Bim;
}
