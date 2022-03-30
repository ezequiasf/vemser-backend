package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.dto.LoginDTO;
import com.dbc.pessoaapi.entity.UsuarioEntity;
import com.dbc.pessoaapi.repository.UsuarioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final ObjectMapper objectMapper;

    public LoginDTO salvarUsuario (LoginDTO dto){
        UsuarioEntity usuario = objectMapper.convertValue(dto, UsuarioEntity.class);
        BCryptPasswordEncoder encriptador = new BCryptPasswordEncoder();
        usuario.setSenha(encriptador.encode(usuario.getSenha()));
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
