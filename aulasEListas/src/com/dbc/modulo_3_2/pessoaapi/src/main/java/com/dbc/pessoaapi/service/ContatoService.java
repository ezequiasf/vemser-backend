package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.dto.ContatoCreateDTO;
import com.dbc.pessoaapi.dto.ContatoDTO;
import com.dbc.pessoaapi.entity.ContatoEntity;
import com.dbc.pessoaapi.entity.TipoContato;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.ContatoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContatoService {
    private final ContatoRepository contatoRepository;
    private final ObjectMapper objectMapper;

    public ContatoDTO criarContato(Integer idPessoa, ContatoCreateDTO dto) throws RegraDeNegocioException {
        ContatoEntity contatoInicial = objectMapper.convertValue(dto, ContatoEntity.class);
        contatoInicial.setId_pessoa(idPessoa);
        contatoInicial.setTipo(validarTipo(dto.getTipoContato()));

        ContatoEntity contatoFinalizado = contatoRepository.save(contatoInicial);

        ContatoDTO contMostrado =  objectMapper.convertValue(contatoFinalizado, ContatoDTO.class);
        contMostrado.setTipoContato(TipoContato.ofTipo(contatoFinalizado.getTipo()).toString());
        return contMostrado;
    }

    public ContatoDTO atualizarContato(Integer idContato, ContatoCreateDTO dto) throws RegraDeNegocioException {
        //Set de informações
        ContatoEntity cont1 = contatoRepository
                .findById(idContato)
                .orElseThrow(() -> new RegraDeNegocioException("Contato não existe no banco."));
        cont1.setTipo(validarTipo(dto.getTipoContato()));
        cont1.setDescricao(dto.getDescricao());
        cont1.setNumero(dto.getNumero());

        //==> Guardando no banco
        ContatoEntity cont2 = contatoRepository.save(cont1);

        //==> Convertendo para mostrar ao usuário e setando o tipo
        ContatoDTO contMostrado = objectMapper.convertValue(cont2, ContatoDTO.class);
        contMostrado.setTipoContato(TipoContato.ofTipo(cont2.getTipo()).toString());
        return contMostrado;
    }

    public List<ContatoDTO> listarContatos() {
        return contatoRepository.findAll().stream()
                .map(c -> {
                    ContatoDTO contVolta = objectMapper.convertValue(c, ContatoDTO.class);
                    contVolta.setTipoContato(TipoContato.ofTipo(c.getTipo()).toString());
                    return contVolta;
                })
                .collect(Collectors.toList());
    }

    public void deletarContato(Integer idContato) throws RegraDeNegocioException {
        ContatoEntity ent = contatoRepository.findById(idContato)
                .orElseThrow(() -> new RegraDeNegocioException("O contato não foi encontrado na base de dados."));
        contatoRepository.delete(ent);
    }

    public Integer validarTipo (String tipo) throws RegraDeNegocioException {
        boolean igualResidencial = tipo.equalsIgnoreCase("Residencial");
        boolean igualComercial = tipo.equalsIgnoreCase("Comercial");
        if (!(igualResidencial || igualComercial)){
            throw new RegraDeNegocioException("Tipo não permitido. Apenas disponível: Residencial ou comercial.");
        }
        return TipoContato.valueOf(tipo.toUpperCase()).getTipo();
    }
}
