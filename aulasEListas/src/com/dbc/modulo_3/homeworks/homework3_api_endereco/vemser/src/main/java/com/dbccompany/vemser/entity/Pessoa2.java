package com.dbccompany.vemser.entity;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class Pessoa2 extends Entidade{
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
