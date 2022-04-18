package com.dbccompany.vemser.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Pessoa {
    private Integer id;
    private String nome;
    private LocalDate nascimento;
    private String cpf;
    private String email;
}
