package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.dto.EnderecoCreateDTO;
import com.dbc.pessoaapi.dto.EnderecoDTO;
import com.dbc.pessoaapi.entity.EnderecoEntity;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.EnderecoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EnderecoService {
    private final ObjectMapper objMapper;
    private final EnderecoRepository endRepo;
    private final PessoaService pService;

    public EnderecoDTO criarEndereco(Integer idPessoa, EnderecoCreateDTO dto) throws RegraDeNegocioException {
        EnderecoEntity end = objMapper.convertValue(dto, EnderecoEntity.class);

        //Busca da pessoa para mapeamento
        PessoaEntity pEntity = pService.findById(idPessoa);
        end.getPessoas().add(pEntity);

        //Persistência e retorno
        EnderecoEntity end2 = endRepo.save(end);
        return objMapper.convertValue(end2, EnderecoDTO.class);
    }

    public EnderecoDTO atualizarEndereco(Integer idEndereco, EnderecoCreateDTO dto) throws RegraDeNegocioException {
        EnderecoEntity end1 = endRepo
                .findById(idEndereco)
                .orElseThrow(() -> new RegraDeNegocioException("Endereço não existe no banco."));
        end1.setCep(dto.getCep());
        end1.setCidade(dto.getCidade());
        end1.setComplemento(dto.getComplemento());
        end1.setEstado(dto.getEstado());
        end1.setNumero(dto.getNumero());
        end1.setPais(dto.getPais());
        end1.setLogradouro(dto.getLogradouro());
        EnderecoEntity end2 = endRepo.save(end1);
        return objMapper.convertValue(end2, EnderecoDTO.class);
    }

    public List<EnderecoDTO> listarEnderecos() {
        return endRepo.findAll().stream()
                .map(e -> objMapper.convertValue(e, EnderecoDTO.class))
                .collect(Collectors.toList());
    }

    public void deletarEndereco(Integer idEndereco) throws RegraDeNegocioException {
        EnderecoEntity ent = endRepo.findById(idEndereco)
                .orElseThrow(() -> new RegraDeNegocioException("O endereço não foi encontrado na base de dados."));
        endRepo.delete(ent);
    }

    public List<EnderecoDTO> findEnderecoByPais (String pais){
        return endRepo.findEnderecosPorPais(pais).stream()
                .map(eEntity-> objMapper.convertValue(eEntity, EnderecoDTO.class))
                .collect(Collectors.toList());
    }

    public List<EnderecoDTO> findEnderecoByIdPessoa (Integer idPessoa){
        return endRepo.findEnderecoByIdPessoa(idPessoa).stream()
                .map(eEntity -> objMapper.convertValue(eEntity, EnderecoDTO.class))
                .collect(Collectors.toList());
    }
}
