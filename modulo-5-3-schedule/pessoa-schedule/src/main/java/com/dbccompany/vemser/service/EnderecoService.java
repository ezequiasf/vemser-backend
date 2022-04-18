package com.dbccompany.vemser.service;

import com.dbccompany.vemser.dto.EnderecoCreateDTO;
import com.dbccompany.vemser.dto.EnderecoDTO;
import com.dbccompany.vemser.entity.Endereco;
import com.dbccompany.vemser.exceptions.RegraDeNegocioException;
import com.dbccompany.vemser.repository.EnderecoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EnderecoService {

    @Autowired
    private EnderecoRepository endRepo;

    @Autowired
    private ObjectMapper objectMapper;

    public EnderecoDTO cadastrarEndereco(EnderecoCreateDTO enderecoCreate, Integer idPessoa) throws RegraDeNegocioException {
        log.info("Chamada de método na service:: Cadastrar Endereço");
        validarPessoaExiste(idPessoa);
        log.info("Feita validação da pessoa.");
        Endereco enderecoSemId = objectMapper.convertValue(enderecoCreate, Endereco.class);
        Endereco enderecoComId = endRepo.cadastrarEndereco(enderecoSemId, idPessoa);
        return objectMapper.convertValue(enderecoComId, EnderecoDTO.class);
    }

    public List<EnderecoDTO> listarEnderecos() {
        return conversorListaDTO(endRepo.listarEnderecos());
    }

    public EnderecoDTO encontrarEnderecoPorId(Integer id) throws RegraDeNegocioException {
        return objectMapper.convertValue(endRepo.encontrarEnderecoPorId(id), EnderecoDTO.class);
    }

    public List<EnderecoDTO> encontrarEnderecosPorPessoa(Integer idPessoa) {
        return conversorListaDTO(endRepo.encontrarEnderecoPorPessoa(idPessoa));
    }

    public EnderecoDTO atualizarEndereco(Integer id, EnderecoCreateDTO endereco) throws RegraDeNegocioException {
        log.info("Chamada de método na service:: Atualizar endereço.");
        validarPessoaExiste(endereco.getIdPessoa());
        log.info("Feita validação da pessoa.");
        Endereco enderecoNovoDado = objectMapper.convertValue(endereco, Endereco.class);
        Endereco enderecoAtualizado = endRepo.atualizarEndereco(id, enderecoNovoDado);
        return objectMapper.convertValue(enderecoAtualizado, EnderecoDTO.class);
    }

    public EnderecoDTO deletarEndereco(Integer id) throws RegraDeNegocioException {
        log.info("Chamada de método na service:: Deletar Endereço");
        return objectMapper.convertValue(endRepo.deletarEndereco(id), EnderecoDTO.class);
    }

    public void validarPessoaExiste(Integer idPessoa) throws RegraDeNegocioException {
        endRepo.listarEnderecos().stream()
                .filter(e -> e.getIdPessoa().equals(idPessoa))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada no banco!"));
    }

    private List<EnderecoDTO> conversorListaDTO(List<Endereco> enderecos) {
        return enderecos.stream()
                .map(end -> objectMapper.convertValue(end, EnderecoDTO.class))
                .collect(Collectors.toList());
    }
}
