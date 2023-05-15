package com.pe.criticalOne.controllers;

import com.pe.criticalOne.entity.UserEntity;
import com.pe.criticalOne.exception.ObjectAlreadyExistsException;
import com.pe.criticalOne.exception.UserWrongPasswordException;
import com.pe.criticalOne.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity registration(@RequestBody UserEntity user) {
        try {
            userService.registration(user);
            return ResponseEntity.ok("Пользователь успешно сохранён!");
        } catch (ObjectAlreadyExistsException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка!");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getOneUser(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(userService.getOne(id));
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body("Пользователь не найден!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка!");
        }
    }

    @GetMapping
    public ResponseEntity getAllUsers() {
        try {
            return ResponseEntity.ok(userService.getAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка!");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updateUser(@PathVariable("id") Long id, @RequestBody UserEntity user) {
        try {
            userService.update(id, user);
            return ResponseEntity.ok("Пользователь успешно изменён!");
        } catch (ObjectAlreadyExistsException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body("Пользователь не найден!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка!");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(userService.delete(id));
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body("Пользователь не найден!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка!");
        }
    }

    @GetMapping("/authorise")
    public ResponseEntity authUser(@RequestParam("login") String login, @RequestParam("password") String password) {
        try {
            return ResponseEntity.ok(userService.auth(login, password));
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body("Пользователь не найден!");
        } catch (UserWrongPasswordException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка!");
        }
    }
}
