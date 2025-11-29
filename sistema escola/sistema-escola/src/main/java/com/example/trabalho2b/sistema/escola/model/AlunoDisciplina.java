package com.example.trabalho2b.sistema.escola.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "aluno_disciplina")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlunoDisciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    @ManyToOne(optional = false)
    @JoinColumn(name = "disciplina_id")
    private Disciplina disciplina;

    private Double nota1Bim;
    private Double nota2Bim;

    private Integer faltas1Bim;
    private Integer faltas2Bim;

    private Boolean matriculado = true;

    @Enumerated(EnumType.STRING)
    private SituacaoAluno situacao = SituacaoAluno.EM_CURSO;
}
