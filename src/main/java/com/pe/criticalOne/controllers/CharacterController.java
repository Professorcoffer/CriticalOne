package com.pe.criticalOne.controllers;

import com.pe.criticalOne.entity.CampaignEntity;
import com.pe.criticalOne.entity.CharacterEntity;
import com.pe.criticalOne.exception.ObjectAlreadyExistsException;
import com.pe.criticalOne.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/characters")
public class CharacterController {
    @Autowired
    private CharacterService characterService;

    @PostMapping
    public ResponseEntity create(@RequestBody CharacterEntity character) {
        try {
            characterService.create(character);
            return ResponseEntity.ok("Персонаж успешно сохранён!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка!");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getOneCharacter(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(characterService.getOne(id));
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body("Персонаж не найден!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка!");
        }
    }

    @GetMapping
    public ResponseEntity getAllCharacters() {
        try {
            return ResponseEntity.ok(characterService.getAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка!");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updateCharacter(@PathVariable("id") Long id, @RequestBody CharacterEntity character) {
        try {
            characterService.update(id, character);
            return ResponseEntity.ok("Персонаж успешно изменён!");
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body("Персонаж не найден!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка!");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCharacter(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(characterService.delete(id));
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body("Персонаж не найден!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка!");
        }
    }
}
