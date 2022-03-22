package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.dto.PessoaCreateDTO;
import com.dbc.pessoaapi.dto.PessoaDTO;
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

    public List<PessoaDTO> findByNome (String nome){
        return pessoaRepository.findByNomeContainsIgnoreCase(nome)
                .stream().map(p-> objectMapper.convertValue(p,PessoaDTO.class))
                .collect(Collectors.toList());
    }

    public PessoaDTO findByCpf (String cpf){
        return objectMapper.convertValue(pessoaRepository.findByCpf(cpf), PessoaDTO.class);
    }

    public List<PessoaDTO> findDataNascimentoBetween (LocalDate inicio, LocalDate fim){
        return pessoaRepository.findByDataNascimentoBetween(inicio, fim)
                .stream().map(pessoaEntity -> objectMapper.convertValue(pessoaEntity, PessoaDTO.class))
                .collect(Collectors.toList());
    }

}
