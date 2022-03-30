package com.dbc.pessoaapi.security;

import com.dbc.pessoaapi.entity.UsuarioEntity;
import com.dbc.pessoaapi.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TokenService {
    private static final String CARACTER_SEPARACAO = ";";
    private final UsuarioService usuarioService;

    public String getToken(UsuarioEntity usuarioEntity){
        String tokenTexto = usuarioEntity.getLogin() + CARACTER_SEPARACAO + usuarioEntity.getSenha();
        return Base64.getEncoder().encodeToString(tokenTexto.getBytes());
    }

    public Optional<UsuarioEntity> isValid(String token){
        if(token == null){
            return Optional.empty();
        }
        byte[] decodedTokenBytes = Base64.getUrlDecoder().decode(token); // bWFpY29uOzEyMw==
        String decodedTokenString = new String(decodedTokenBytes); //maicon;123
        String[] usuarioESenha = decodedTokenString.split(CARACTER_SEPARACAO);/// ['maicon', '123']
        return usuarioService.findByLoginAndSenha(usuarioESenha[0] /*maicon*/, usuarioESenha[1] /*123*/);
    }
}
