package com.dbc.pessoaapi.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
public class PessoaCreateDTO {
    @NotEmpty
    @NotBlank
    @ApiModelProperty(value = "Nome da Pessoa")
    private String nome;

    @NotNull
    @ApiModelProperty(value = "Data de Nascimento")
    private LocalDate dataNascimento;

    @Size(max = 11, min = 11, message = "cpf deve conter 11 caracteres")
    @NotNull
    @ApiModelProperty(value = "CPF")
    private String cpf;

    @Email
    private String email;
}