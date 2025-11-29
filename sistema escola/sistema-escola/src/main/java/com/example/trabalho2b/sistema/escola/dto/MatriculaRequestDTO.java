package com.example.trabalho2b.sistema.escola.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatriculaRequestDTO {
    private Long idAluno;
    private Long idDisciplina;
}
