package com.dbccompany.vemser.service;

import com.dbccompany.vemser.dto.ContatoCreateDTO;
import com.dbccompany.vemser.dto.ContatoDTO;
import com.dbccompany.vemser.entity.Contato;
import com.dbccompany.vemser.exceptions.RegraDeNegocioException;
import com.dbccompany.vemser.repository.ContatoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepo;
    @Autowired
    private ObjectMapper objectMapper;

    public ContatoService() {
        this.contatoRepo = new ContatoRepository();
    }

    public ContatoDTO cadastrarContato(ContatoCreateDTO contatoCreate) throws RegraDeNegocioException {
        log.info("Chamada de método na service:: Cadastrar contato");
        log.info("Contato validado.");
        Contato contatoSemId = objectMapper.convertValue(contatoCreate, Contato.class);
        validarPessoaExiste(contatoSemId);
        Contato contatoComId = contatoRepo.cadastrarContato(contatoSemId);
        return objectMapper.convertValue(contatoComId, ContatoDTO.class);
    }

    public List<ContatoDTO> listarContatos() {
        return converterListaContatoParaDTO(contatoRepo.listarContatos());
    }

    public List<ContatoDTO> listarContatosPorPessoa(Integer idPessoa) {
        return converterListaContatoParaDTO(contatoRepo.listarContatoPessoa(idPessoa));
    }

    public ContatoDTO atualizarContato(Integer idContato, ContatoCreateDTO contato) throws RegraDeNegocioException {
        log.info("Chamada de método na service:: Atualizar contato");
        Contato contatoNovoDado = objectMapper.convertValue(contato, Contato.class);
        validarPessoaExiste(contatoNovoDado);
        log.info("Feita a validação de pessoa.");
        Contato contatoAtualizado = contatoRepo.atualizarContato(idContato, contatoNovoDado);
        return objectMapper.convertValue(contatoAtualizado, ContatoDTO.class);
    }

    public void deletarContato(Integer id) throws RegraDeNegocioException {
        log.info("Chamada de método na service:: Deletar Contato");
        contatoRepo.deletarContato(id);
    }

    public List<ContatoDTO> listarPorTipo(String tipo) {
        return converterListaContatoParaDTO(contatoRepo.encontrarPorTipo(tipo));
    }

    public void validarPessoaExiste(Contato contato) throws RegraDeNegocioException {
        contatoRepo.listarContatos().stream()
                .filter(c -> c.getIdPessoa().equals(contato.getIdPessoa()))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não existe no banco!"));
    }

    private List<ContatoDTO> converterListaContatoParaDTO(List<Contato> contatos) {
        return contatos
                .stream()
                .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                .collect(Collectors.toList());
    }
}


