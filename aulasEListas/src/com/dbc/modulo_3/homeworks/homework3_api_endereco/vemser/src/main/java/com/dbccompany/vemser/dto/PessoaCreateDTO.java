package com.dbccompany.vemser.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PessoaCreateDTO implements DTO{
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
