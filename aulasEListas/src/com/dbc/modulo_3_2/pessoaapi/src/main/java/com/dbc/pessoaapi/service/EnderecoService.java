package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.dto.ContatoDTO;
import com.dbc.pessoaapi.dto.EnderecoCreateDTO;
import com.dbc.pessoaapi.dto.EnderecoDTO;
import com.dbc.pessoaapi.entity.ContatoEntity;
import com.dbc.pessoaapi.entity.EnderecoEntity;
import com.dbc.pessoaapi.entity.TipoContato;
import com.dbc.pessoaapi.entity.TipoEndereco;
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

    public EnderecoDTO criarEndereco(Integer idPessoa, EnderecoCreateDTO dto) throws RegraDeNegocioException {
        //TODO: validação da pessoa
        EnderecoEntity end = objMapper.convertValue(dto, EnderecoEntity.class);
        end.setId_pessoa(idPessoa);
        end.setTipo(validarTipo(dto.getTipo()));
        EnderecoEntity end2 = endRepo.save(end);
        EnderecoDTO endVolta = objMapper.convertValue(end2, EnderecoDTO.class);
        endVolta.setTipo(TipoEndereco.ofTipo(end2.getTipo()).toString());
        return endVolta;
    }

    public EnderecoDTO atualizarEndereco(Integer idEndereco, EnderecoCreateDTO dto) throws RegraDeNegocioException {

        EnderecoEntity end1 = endRepo
                .findById(idEndereco)
                .orElseThrow(() -> new RegraDeNegocioException("Endereço não existe no banco."));

        end1.setTipo(validarTipo(dto.getTipo()));
        end1.setCep(dto.getCep());
        end1.setCidade(dto.getCidade());
        end1.setComplemento(dto.getComplemento());
        end1.setEstado(dto.getEstado());
        end1.setNumero(dto.getNumero());
        end1.setPais(dto.getPais());
        end1.setLogradouro(dto.getLogradouro());
        EnderecoEntity end2 = endRepo.save(end1);

        EnderecoDTO endVolta = objMapper.convertValue(end2, EnderecoDTO.class);
        endVolta.setTipo(TipoEndereco.ofTipo(end2.getTipo()).toString());
        return endVolta;
    }

    public List<EnderecoDTO> listarEnderecos() {
        return endRepo.findAll().stream()
                .map(e -> {
                    EnderecoDTO endVolta = objMapper.convertValue(e, EnderecoDTO.class);
                    endVolta.setTipo(TipoEndereco.ofTipo(e.getTipo()).toString());
                    return endVolta;
                })
                .collect(Collectors.toList());
    }

    public void deletarEndereco(Integer idEndereco) throws RegraDeNegocioException {
        EnderecoEntity ent = endRepo.findById(idEndereco)
                .orElseThrow(() -> new RegraDeNegocioException("O endereço não foi encontrado na base de dados."));
        endRepo.delete(ent);
    }

    public Integer validarTipo(String tipo) throws RegraDeNegocioException {
        boolean igualResidencial = tipo.equalsIgnoreCase("Residencial");
        boolean igualComercial = tipo.equalsIgnoreCase("Comercial");
        if (!(igualResidencial || igualComercial)) {
            throw new RegraDeNegocioException("Tipo não permitido. Apenas disponível: Residencial ou comercial.");
        }
        return TipoEndereco.valueOf(tipo.toUpperCase()).getTipo();
    }
}
