package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.dto.ContatoCreateDTO;
import com.dbc.pessoaapi.dto.ContatoDTO;
import com.dbc.pessoaapi.entity.ContatoEntity;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.entity.TipoContato;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.ContatoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ContatoService {
    private final ContatoRepository contatoRepository;
    private final PessoaService pessoaService;
    private final ObjectMapper objectMapper;

    public ContatoDTO criarContato(Integer idPessoa, ContatoCreateDTO dto) throws RegraDeNegocioException {
        //Converter DTO para contato entity (Para salvar)
        ContatoEntity contatoInicial = objectMapper.convertValue(dto, ContatoEntity.class);

        //Buscando a pessoa para setar no contato
        PessoaEntity pessoaEntity = pessoaService.findById(idPessoa);
        contatoInicial.setPessoa(pessoaEntity);

        //Salvando e retornando um DTO
        ContatoEntity contatoFinalizado = contatoRepository.save(contatoInicial);
        return objectMapper.convertValue(contatoFinalizado, ContatoDTO.class);
    }

    public ContatoDTO atualizarContato(Integer idContato, ContatoCreateDTO dto) throws RegraDeNegocioException {
        ContatoEntity cont1 = contatoRepository
                .findById(idContato)
                .orElseThrow(() -> new RegraDeNegocioException("Contato não existe no banco."));
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

    public List<ContatoDTO> findByTipoContato (TipoContato tipoContato){
        return contatoRepository.findByTipoContato(tipoContato).stream()
                .map(c-> objectMapper.convertValue(c, ContatoDTO.class))
                .collect(Collectors.toList());
    }

    public List<ContatoDTO> findContatoByIdPessoa (Integer idPessoa){
        return contatoRepository.findContatoByIdPessoa(idPessoa).stream()
                .map(c-> objectMapper.convertValue(c, ContatoDTO.class))
                .collect(Collectors.toList());
    }

}
