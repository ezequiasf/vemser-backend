package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.dto.ContatoCreateDTO;
import com.dbc.pessoaapi.dto.ContatoDTO;
import com.dbc.pessoaapi.entity.ContatoEntity;
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
        //TODO: validação da pessoa

        ContatoEntity cont = objectMapper.convertValue(dto, ContatoEntity.class);
        cont.setId_pessoa(idPessoa);

        ContatoEntity cont2 = contatoRepository.save(cont);
        return objectMapper.convertValue(cont2, ContatoDTO.class);
    }

    public ContatoDTO atualizarContato(Integer idContato, ContatoCreateDTO dto) throws RegraDeNegocioException {
        ContatoEntity cont1 = contatoRepository
                .findById(idContato)
                .orElseThrow(() -> new RegraDeNegocioException("Contato não existe no banco."));
        cont1.setTipo(dto.getTipo());
        cont1.setDescricao(dto.getDescricao());
        cont1.setNumero(dto.getNumero());
        ContatoEntity cont2 = contatoRepository.save(cont1);
        return objectMapper.convertValue(cont2, ContatoDTO.class);
    }

    public List<ContatoDTO> listarContatos() {
        return contatoRepository.findAll().stream()
                .map(c -> objectMapper.convertValue(c, ContatoDTO.class))
                .collect(Collectors.toList());
    }

    public void deletarContato(Integer idContato) throws RegraDeNegocioException {
        ContatoEntity ent = contatoRepository.findById(idContato)
                .orElseThrow(() -> new RegraDeNegocioException("O contato não foi encontrado na base de dados."));
        contatoRepository.delete(ent);
    }
}
