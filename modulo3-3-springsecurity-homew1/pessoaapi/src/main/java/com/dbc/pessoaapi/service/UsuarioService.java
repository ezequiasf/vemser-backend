package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.dto.CadastroUsuarioDTO;
import com.dbc.pessoaapi.dto.LoginDTO;
import com.dbc.pessoaapi.entity.GrupoEntity;
import com.dbc.pessoaapi.entity.TipoGrupo;
import com.dbc.pessoaapi.entity.UsuarioEntity;
import com.dbc.pessoaapi.repository.UsuarioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final ObjectMapper objectMapper;
    private final GrupoService grupoService;

    public LoginDTO salvarUsuario(CadastroUsuarioDTO dto) {
        UsuarioEntity usuario = objectMapper.convertValue(dto, UsuarioEntity.class);
        usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
        if (dto.getGruposTipo().stream().anyMatch(tipo-> tipo==TipoGrupo.ADMIN)){
            GrupoEntity grupoEntity = grupoService.findGrupoById(TipoGrupo.ADMIN.getIdGrupo()).get();
            usuario.setGrupos(Set.of(grupoEntity));
        }else{
            usuario.setGrupos(dto.getGruposTipo().stream().map(tipo -> {
                Integer idGrupo = 0;
                if (tipo == TipoGrupo.CADASTRO) {
                    idGrupo = TipoGrupo.CADASTRO.getIdGrupo();
                } else if (tipo == TipoGrupo.MARKETING) {
                    idGrupo = TipoGrupo.MARKETING.getIdGrupo();
                }
                Optional<GrupoEntity> optGrupo = grupoService.findGrupoById(idGrupo);
                return optGrupo.orElse(null);
            }).collect(Collectors.toSet()));
        }
        return objectMapper.convertValue(usuarioRepository.save(usuario), LoginDTO.class);
    }

    public Optional<UsuarioEntity> findByLoginAndSenha(String login, String senha) {
        return usuarioRepository.findByLoginAndSenha(login, senha);
    }

    public Optional<UsuarioEntity> findByLogin(String login) {
        return usuarioRepository.findByLogin(login);
    }
}
