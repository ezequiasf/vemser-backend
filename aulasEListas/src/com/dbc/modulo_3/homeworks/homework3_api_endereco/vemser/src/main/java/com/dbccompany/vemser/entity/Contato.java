package com.dbccompany.vemser.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Contato {
    private Integer idContato;
    private Integer idPessoa;

    @NotBlank
    private String tipoContato;

    @NotBlank
    @Size(max = 13)
    private String numero;

    @NotBlank
    private String descricao;
}
