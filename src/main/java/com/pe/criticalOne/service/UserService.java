package com.pe.criticalOne.service;

import com.pe.criticalOne.entity.UserEntity;
import com.pe.criticalOne.exception.ObjectAlreadyExistsException;
import com.pe.criticalOne.exception.UserWrongPasswordException;
import com.pe.criticalOne.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public UserEntity registration(UserEntity user) throws ObjectAlreadyExistsException {
        if (userRepo.findByLogin(user.getLogin()) != null) {
            throw new ObjectAlreadyExistsException("Пользователь с таким именем уже существует!");
        }
        if (userRepo.findByEmail(user.getEmail()) != null) {
            throw new ObjectAlreadyExistsException("Пользователь с такой почтой уже существует!");
        }
        return userRepo.save(user);
    }

    public UserEntity getOne(Long id) {
        return userRepo.findById(id).get();
    }

    public List<UserEntity> getAll() {
        List<UserEntity> users = new ArrayList<>();
        userRepo.findAll().forEach(users::add);
        return users;
    }

    public UserEntity update(Long id, UserEntity user) throws ObjectAlreadyExistsException {
        UserEntity userDB = userRepo.findById(id).get();
        if (userRepo.findByLogin(user.getLogin()) != null && userRepo.findByLogin(user.getLogin()) != userDB) {
            throw new ObjectAlreadyExistsException("Пользователь с таким именем уже существует!");
        }
        if (userRepo.findByEmail(user.getEmail()) != null && userRepo.findByEmail(user.getEmail()) != userDB) {
            throw new ObjectAlreadyExistsException("Пользователь с такой почтой уже существует!");
        }
        userDB.setLogin(user.getLogin());
        userDB.setEmail(user.getEmail());
        userDB.setPassword(user.getPassword());
        userDB.setRole(user.getRole());
        return userRepo.save(userDB);
    }

    public Long delete(Long id) {
        UserEntity user = userRepo.findById(id).get();
        userRepo.deleteById(id);
        return id;
    }

    public UserEntity auth(String login, String password) throws UserWrongPasswordException {
        UserEntity user = userRepo.findByLogin(login);
        if (user == null) {
            throw new NoSuchElementException();
        }
        if (!user.getPassword().equals(password)) {
            throw new UserWrongPasswordException("Пароль введён неверно!");
        }
        return user;
    }
}
