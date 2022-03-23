package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.dto.*;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PessoaService {
    private final PessoaRepository pessoaRepository;
    private final ObjectMapper objectMapper;

    public PessoaDTO create(PessoaCreateDTO pessoa) {
        PessoaEntity pessoaEntity = objectMapper.convertValue(pessoa, PessoaEntity.class);
        PessoaEntity pessoa1 = pessoaRepository.save(pessoaEntity);
        return objectMapper.convertValue(pessoa1, PessoaDTO.class);
    }

    public List<PessoaDTO> list() {
        return pessoaRepository.findAll().stream()
                .map(p -> objectMapper.convertValue(p, PessoaDTO.class))
                .collect(Collectors.toList());
    }

    public PessoaDTO update(Integer id,
                            PessoaCreateDTO pessoaAtualizar) throws Exception {
        PessoaEntity p = pessoaRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada!"));
        p.setCpf(pessoaAtualizar.getCpf());
        p.setDataNascimento(pessoaAtualizar.getDataNascimento());
        p.setEmail(pessoaAtualizar.getEmail());
        p.setNome(pessoaAtualizar.getNome());
        PessoaEntity p2 = pessoaRepository.save(p);
        return objectMapper.convertValue(p2, PessoaDTO.class);
    }

    public void delete(Integer id) throws Exception {
        PessoaEntity p = pessoaRepository.findById(id).orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada!"));
        pessoaRepository.delete(p);
    }

    public List<PessoaDTO> findByNome(String nome) {
        return pessoaRepository.findByNomeContainsIgnoreCase(nome)
                .stream().map(p -> objectMapper.convertValue(p, PessoaDTO.class))
                .collect(Collectors.toList());
    }

    public PessoaDTO findByCpf(String cpf) {
        return objectMapper.convertValue(pessoaRepository.findByCpf(cpf), PessoaDTO.class);
    }

    public List<PessoaDTO> findDataNascimentoBetween(LocalDate inicio, LocalDate fim) {
        return pessoaRepository.findByDataNascimentoBetween(inicio, fim)
                .stream().map(pessoaEntity -> objectMapper.convertValue(pessoaEntity, PessoaDTO.class))
                .collect(Collectors.toList());
    }

    public List<PessoaComContatoDTO> findContatoPessoaOuTodas(Integer idPessoa) {
        if (idPessoa != null) {
            return pessoaRepository.findById(idPessoa)
                    .stream()
                    .map(p -> {
                        PessoaComContatoDTO pc = objectMapper.convertValue(p, PessoaComContatoDTO.class);
                        pc.setContatos(p.getContatos().stream()
                                .map(contatos -> objectMapper.convertValue(contatos, ContatoDTO.class))
                                .collect(Collectors.toList()));
                        return pc;
                    }).collect(Collectors.toList());
        }
        return pessoaRepository.findAll().stream()
                .map(p -> {
                    PessoaComContatoDTO pc = objectMapper.convertValue(p, PessoaComContatoDTO.class);
                    pc.setContatos(p.getContatos().stream().map(cEntity -> objectMapper.convertValue(cEntity, ContatoDTO.class)).collect(Collectors.toList()));
                    return pc;
                }).collect(Collectors.toList());
    }

    public List<PessoaComEnderecoDTO> findEnderecoByIdPessoa(Integer idPessoa) {
        if (idPessoa != null) {
            return pessoaRepository.findById(idPessoa).stream()
                    .map(pEntity -> {
                        PessoaComEnderecoDTO pe = objectMapper.convertValue(pEntity, PessoaComEnderecoDTO.class);
                        pe.setEnderecos(pEntity.getEnderecos().stream()
                                .map(eEntity -> objectMapper.convertValue(eEntity, EnderecoDTO.class))
                                .collect(Collectors.toList()));
                        return pe;
                    }).collect(Collectors.toList());
        }
        return pessoaRepository.findAll().stream().map(pEntity -> {
            PessoaComEnderecoDTO pe = objectMapper.convertValue(pEntity, PessoaComEnderecoDTO.class);
            pe.setEnderecos(pEntity.getEnderecos().stream()
                    .map(eEntity -> objectMapper.convertValue(eEntity, EnderecoDTO.class))
                    .collect(Collectors.toList()));
            return pe;
        }).collect(Collectors.toList());
    }

    public List<PessoaDTO> findPessoaBetweenDatas (LocalDate data1, LocalDate data2){
        return pessoaRepository.findByBetweenDatas(data1, data2).stream()
                .map(p-> objectMapper.convertValue(p, PessoaDTO.class))
                .collect(Collectors.toList());
    }

    public List<PessoaDTO> findPessoaComEndereco (){
        return pessoaRepository.findPessoasComEndereco().stream()
                .map(pEntity-> objectMapper.convertValue(pEntity, PessoaDTO.class))
                .distinct()
                .collect(Collectors.toList());
    }

    public PessoaEntity findById (Integer idPessoa) throws RegraDeNegocioException {
        return pessoaRepository.findById(idPessoa)
                .orElseThrow(()-> new RegraDeNegocioException("Pessoa não encontrada!"));
    }

}
