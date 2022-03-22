package com.dbc.pessoaapi.dto;

import com.dbc.pessoaapi.entity.TipoContato;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContatoCreateDTO {
    @NotBlank
    private Integer tipo;
    @NotBlank
    @Size(max = 10, min = 1)
    private String numero;
    @NotBlank
    @Size(min = 1, max = 50)
    private String descricao;

    public void setTipo (String tipo) throws RegraDeNegocioException {
        if(tipo.equalsIgnoreCase("RESIDENCIAL")){
            this.tipo = TipoContato.RESIDENCIAL.getTipo();
        }else if (tipo.equalsIgnoreCase("COMERCIAL")){
            this.tipo = TipoContato.COMERCIAL.getTipo();
        }else{
            throw new RegraDeNegocioException("O tipo informado não é compatível. Por favor, informe residencial ou comercial");
        }
    }
}
