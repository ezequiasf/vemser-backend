package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.dto.CadastroUsuarioDTO;
import com.dbc.pessoaapi.dto.LoginDTO;
import com.dbc.pessoaapi.entity.UsuarioEntity;
import com.dbc.pessoaapi.repository.GrupoRepository;
import com.dbc.pessoaapi.repository.UsuarioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final ObjectMapper objectMapper;
    private final GrupoRepository grupoRepository;

    public LoginDTO salvarUsuario (CadastroUsuarioDTO dto){
        BCryptPasswordEncoder encriptador = new BCryptPasswordEncoder();
        UsuarioEntity usuario = objectMapper.convertValue(dto, UsuarioEntity.class);
        usuario.setSenha(encriptador.encode(usuario.getSenha()));
        usuario.setGrupos(dto.getGruposString().stream().map(s-> {
            if (s.equalsIgnoreCase("Administradores")){
                return grupoRepository.findById(1).get();
            }else if (s.equalsIgnoreCase("Cadastro")){
                return grupoRepository.findById(2).get();
            }else if (s.equalsIgnoreCase("Marketing")){
                return grupoRepository.findById(3).get();
            }
            return null;
        }).collect(Collectors.toSet()));
        UsuarioEntity usuarioEntity = usuarioRepository.save(usuario);
        return objectMapper.convertValue(usuarioEntity, LoginDTO.class);
    }

    public Optional<UsuarioEntity> findByLoginAndSenha(String login, String senha) {
        return usuarioRepository.findByLoginAndSenha(login, senha);
    }

    public Optional<UsuarioEntity> findByLogin(String login) {
        return usuarioRepository.findByLogin(login);
    }
}
