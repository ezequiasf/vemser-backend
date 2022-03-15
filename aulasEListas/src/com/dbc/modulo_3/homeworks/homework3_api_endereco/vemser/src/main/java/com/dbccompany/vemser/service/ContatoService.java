package com.dbccompany.vemser.service;

import com.dbccompany.vemser.entity.Contato;
import com.dbccompany.vemser.exceptions.RegraDeNegocioException;
import com.dbccompany.vemser.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatoService {

    @Autowired
    private  ContatoRepository contatoRepo;

    public ContatoService (){
        this.contatoRepo = new ContatoRepository();
    }

    public Contato cadastrarContato (Contato contato) throws RegraDeNegocioException {
        validarPessoaExiste(contato);
        return contatoRepo.cadastrarContato(contato);
    }

    public List<Contato> listarContatos (){
        return contatoRepo.listarContatos();
    }

    public List<Contato> listarContatosPorPessoa (Integer idPessoa){
        return contatoRepo.listarContatoPessoa(idPessoa);
    }

    public Contato atualizarContato (Integer id, Contato contato) throws RegraDeNegocioException {
        validarPessoaExiste(contato);
        return contatoRepo.atualizarContato(id, contato);
    }

    public void deletarContato (Integer id) throws RegraDeNegocioException {
        contatoRepo.deletarContato(id);
    }

    public List<Contato> listarPorTipo (String tipo){
        return contatoRepo.encontrarPorTipo(tipo);
    }

    public void validarPessoaExiste (Contato contato) throws RegraDeNegocioException{
        contatoRepo.listarContatos().stream()
                .filter(c -> c.getIdPessoa().equals(contato.getIdPessoa()))
                .findFirst()
                .orElseThrow(()-> new RegraDeNegocioException("Pessoa não existe no banco!"));
    }
}
