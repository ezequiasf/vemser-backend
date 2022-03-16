package com.dbccompany.vemser.entity;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Pessoa {
    private Integer id;
    @NotNull
    @NotEmpty
    private String nome;
    @NotNull
    @Past
    private LocalDate nascimento;
    @CPF
    private String cpf;
}