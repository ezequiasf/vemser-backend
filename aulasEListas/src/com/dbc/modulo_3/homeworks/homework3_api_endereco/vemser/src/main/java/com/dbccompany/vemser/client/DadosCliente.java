package com.dbccompany.vemser.client;

import com.dbccompany.vemser.dto.DadosPessoaisDTO;
import feign.Headers;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;

@FeignClient(value="dados-pessoais-api", url="https://dados-pessoais-vemserdbc.herokuapp.com/")
@Headers("Content-Type: application/json")
public interface DadosCliente {

    @RequestLine("GET /dados-pessoais")
    List<DadosPessoaisDTO> getAll();

    @RequestLine("POST /dados-pessoais")
    DadosPessoaisDTO post(DadosPessoaisDTO dadosPessoaisDTO);
}
