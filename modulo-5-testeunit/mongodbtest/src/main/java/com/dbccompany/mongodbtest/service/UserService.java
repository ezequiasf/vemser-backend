package com.dbccompany.mongodbtest.service;

import com.dbccompany.mongodbtest.entity.UserEntity;
import com.dbccompany.mongodbtest.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void saveUser(UserEntity user) throws  IllegalArgumentException{
        if (verifyAge(user) && (!verifyUserExists(user) && (!verifyIfEmailExists(user)))) {
            userRepository.saveUser(user);
        }
        throw new IllegalArgumentException("User create failed!");
    }

    //Retorna true se for maior do que 18 anos
    public boolean verifyAge(UserEntity user) {
        return user.getAge() >= 18;
    }

    // Retorna falso se o usuário não existir no banco
    public boolean verifyUserExists(UserEntity userCreate) {
        String user = userRepository.findBy("username", userCreate.getUsername());
        if (user != null) {
            return true;
        }
        return false;
    }

    public boolean verifyIfEmailExists(UserEntity user) {
        String userEmail = userRepository.findBy("email", user.getEmail());
        if (userEmail != null) {
            return true;
        }
        return false;
    }
}
