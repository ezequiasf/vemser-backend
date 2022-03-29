package com.dbccompany.vemser.service;

import com.dbccompany.vemser.dto.PessoaCreateDTO;
import com.dbccompany.vemser.dto.PessoaDTO;
import com.dbccompany.vemser.entity.Pessoa;
import com.dbccompany.vemser.exceptions.RegraDeNegocioException;
import com.dbccompany.vemser.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepo;
    @Autowired
    private ObjectMapper objectMapper;

    private boolean validacaoPessoa(Pessoa pessoa) {
        boolean condicaoNome = StringUtils.isBlank(pessoa.getNome());
        boolean condicaoData = ObjectUtils.isEmpty(pessoa.getNascimento());
        boolean condicaoCpf = StringUtils.isBlank(pessoa.getCpf());
        return condicaoNome || condicaoData || condicaoCpf;
    }

    public PessoaDTO cadastrarPessoa(PessoaCreateDTO pessoaCreate) {
        log.info("Chamada de método na service:: Cadastrar Pessoa");
        Pessoa entidadeCriar = objectMapper.convertValue(pessoaCreate, Pessoa.class);
        Pessoa entidadeComId = pessoaRepo.cadastrarPessoa(entidadeCriar);
        return objectMapper.convertValue(entidadeComId, PessoaDTO.class);
    }

    public List<PessoaDTO> listarPessoas() {
        return conversorListaPessoaParaDTO(pessoaRepo.listarPessoas());
    }

    public PessoaDTO atualizarPessoa(Integer idPessoa, PessoaCreateDTO pessoaCreate) throws Exception {
        log.info("Chamada de método na service:: Atualizar Pessoa");
        Pessoa pessoaNovaDado = objectMapper.convertValue(pessoaCreate, Pessoa.class);
        Pessoa pessoaAtualizada = pessoaRepo.atualizarPessoa(idPessoa, pessoaNovaDado);
        return objectMapper.convertValue(pessoaAtualizada, PessoaDTO.class);
    }

    public PessoaDTO deletarPessoa(Integer id) throws RegraDeNegocioException {
        log.info("Chamada de método na service:: Deletar Pessoa");
        Pessoa pessoaDeletada = pessoaRepo.deletarPessoa(id);
        return objectMapper.convertValue(pessoaDeletada, PessoaDTO.class);
    }

    public List<PessoaDTO> encontrarPorNome(String nome) {
        return conversorListaPessoaParaDTO(pessoaRepo.listarPorNome(nome));
    }

    private List<PessoaDTO> conversorListaPessoaParaDTO(List<Pessoa> pessoas) {
        return pessoas
                .stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());
    }
}
