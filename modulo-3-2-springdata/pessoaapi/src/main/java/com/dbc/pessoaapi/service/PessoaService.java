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
                    .map(pEntity -> (PessoaComContatoDTO) constroiDTO(pEntity, new PessoaComContatoDTO()))
                    .collect(Collectors.toList());
        }
        return pessoaRepository.findAll().stream()
                .map(pEntity -> (PessoaComContatoDTO) constroiDTO(pEntity, new PessoaComContatoDTO()))
                .collect(Collectors.toList());
    }

    public List<PessoaComEnderecoDTO> findEnderecoByIdPessoa(Integer idPessoa) {
        if (idPessoa != null) {
            return pessoaRepository.findById(idPessoa).stream()
                    .map(pEntity -> (PessoaComEnderecoDTO) constroiDTO(pEntity, new PessoaComEnderecoDTO()))
                    .collect(Collectors.toList());
        }
        return pessoaRepository.findAll().stream()
                .map(pEntity -> (PessoaComEnderecoDTO) constroiDTO(pEntity, new PessoaComEnderecoDTO()))
                .collect(Collectors.toList());
    }

    public List<PessoaContatoEnderecoDTO> findPessoaContatoEnderecoById (Integer idPessoa){
        if (idPessoa != null) {
            return pessoaRepository.findById(idPessoa).stream()
                    .map(pEntity -> (PessoaContatoEnderecoDTO) constroiDTO(pEntity, new PessoaContatoEnderecoDTO()))
                    .collect(Collectors.toList());
        }
        return pessoaRepository.findAll().stream()
                .map(pEntity -> (PessoaContatoEnderecoDTO) constroiDTO(pEntity, new PessoaContatoEnderecoDTO()))
                .collect(Collectors.toList());
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

    public List<PessoaDTO> findPessoaSemEndereco (){
        return pessoaRepository.findPessoasSemEndereco().stream()
                .map(p-> objectMapper.convertValue(p, PessoaDTO.class))
                .collect(Collectors.toList());
    }

    public PessoaEntity findById (Integer idPessoa) throws RegraDeNegocioException {
        return pessoaRepository.findById(idPessoa)
                .orElseThrow(()-> new RegraDeNegocioException("Pessoa não encontrada!"));
    }

    private PessoaCreateDTO constroiDTO (PessoaEntity pEntity, PessoaCreateDTO dto){
        if (dto instanceof PessoaComContatoDTO){
            PessoaComContatoDTO pc = objectMapper.convertValue(pEntity, PessoaComContatoDTO.class);
            pc.setContatos(findContatosEntity(pEntity));
            return pc;
        }else if (dto instanceof PessoaComEnderecoDTO){
            PessoaComEnderecoDTO pe = objectMapper.convertValue(pEntity, PessoaComEnderecoDTO.class);
            pe.setEnderecos(findEnderecosEntity(pEntity));
            return pe;
        }
        PessoaContatoEnderecoDTO pce = objectMapper.convertValue(pEntity, PessoaContatoEnderecoDTO.class);
        pce.setEnderecoDTOS(findEnderecosEntity(pEntity));
        pce.setContatos(findContatosEntity(pEntity));
        return pce;
    }

    private List<EnderecoDTO> findEnderecosEntity (PessoaEntity pessoaEntity){
        return pessoaEntity.getEnderecos().stream()
                .map(eEntity -> objectMapper.convertValue(eEntity, EnderecoDTO.class))
                .collect(Collectors.toList());
    }

    private List<ContatoDTO> findContatosEntity (PessoaEntity pessoaEntity){
        return pessoaEntity.getContatos().stream()
                .map(cEntity -> objectMapper.convertValue(cEntity, ContatoDTO.class))
                .collect(Collectors.toList());
    }

}
