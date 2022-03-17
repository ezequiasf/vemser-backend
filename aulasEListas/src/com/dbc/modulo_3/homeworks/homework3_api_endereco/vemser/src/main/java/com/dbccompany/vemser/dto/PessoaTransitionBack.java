package com.dbccompany.vemser.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
public class PessoaTransitionBack {
    @NotBlank
    private String nome;
    @NotNull
    @Past
    private LocalDate nascimento;
    @CPF
    private String cpf;
    @Email
    private String email;
}
