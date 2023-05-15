package com.pe.criticalOne.controllers;

import com.pe.criticalOne.entity.QuestEntity;
import com.pe.criticalOne.exception.ObjectAlreadyExistsException;
import com.pe.criticalOne.service.QuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/quests")
public class QuestController {
    @Autowired
    private QuestService questService;

    @PostMapping
    public ResponseEntity create(@RequestBody QuestEntity quest) {
        try {
            questService.create(quest);
            return ResponseEntity.ok("Задание успешно сохранёно!");
        } catch (ObjectAlreadyExistsException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка!");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getOneQuest(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(questService.getOne(id));
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body("Задание не найдено!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка!");
        }
    }

    @GetMapping
    public ResponseEntity getAllQuests() {
        try {
            return ResponseEntity.ok(questService.getAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка!");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updateQuest(@PathVariable("id") Long id, @RequestBody QuestEntity quest) {
        try {
            questService.update(id, quest);
            return ResponseEntity.ok("Задание успешно изменёно!");
        } catch (ObjectAlreadyExistsException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body("Задание не найдено!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка!");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteQuest(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(questService.delete(id));
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body("Задание не найдено!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка!");
        }
    }
}
