package com.dbccompany.mongodbtest.user;

import com.dbccompany.mongodbtest.entity.UserEntity;
import com.dbccompany.mongodbtest.repository.UserRepository;
import com.dbccompany.mongodbtest.service.UserService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TC_UserEntity {

    private final UserService userService = new UserService(new UserRepository());

    @Test
    void deveTestarSeUsuarioTemIdadeMaiorQueDezoitoAnos() {
        UserEntity u1 = UserEntity.builder()
                .username("zezão")
                .age(19)
                .email("zezao@outlook.com")
                .isactive(true)
                .role("ROLE_PREMIUM")
                .build();
        boolean age = userService.verifyAge(u1);
        assertTrue(age);
    }

    @Test
    void deveTestarSeUsuarioTemIdadeMenorQueDezoitoAnos() {
        UserEntity u1 = UserEntity.builder()
                .username("flavia")
                .age(17)
                .email("flavinha@outlook.com")
                .isactive(true)
                .role("ROLE_STANDARD")
                .build();
        boolean age = userService.verifyAge(u1);
        assertFalse(age);
    }

    @Test
    void deveTestarSeUsuarioNaoECadastrado() {
        UserEntity u1 = UserEntity.builder()
                .username("marcia")
                .age(17)
                .email("marcinha123@outlook.com")
                .isactive(true)
                .role("ROLE_STANDARD")
                .build();
        assertThrows(IllegalArgumentException.class, () -> userService.saveUser(u1));
    }

    @Test
    void deveTestarSeUsuarioJaEstaCadastrado() {
        UserEntity u1 = UserEntity.builder()
                .username("zedasquantas")
                .age(19)
                .email("aleatorio@outlook.com")
                .isactive(true)
                .role("ROLE_STANDARD")
                .build();
        assertThrows(IllegalArgumentException.class, () -> userService.saveUser(u1));
    }


}
