package com.pe.criticalOne.controllers;

import com.pe.criticalOne.entity.ItemEntity;
import com.pe.criticalOne.entity.QuestEntity;
import com.pe.criticalOne.exception.ObjectAlreadyExistsException;
import com.pe.criticalOne.service.ItemService;
import com.pe.criticalOne.service.QuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/items")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping
    public ResponseEntity create(@RequestBody ItemEntity item) {
        try {
            itemService.create(item);
            return ResponseEntity.ok("Артефакт успешно сохранён!");
        } catch (ObjectAlreadyExistsException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка!");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getOneItem(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(itemService.getOne(id));
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body("Артефакт не найден!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка!");
        }
    }

    @GetMapping
    public ResponseEntity getAllItems() {
        try {
            return ResponseEntity.ok(itemService.getAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка!");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updateItem(@PathVariable("id") Long id, @RequestBody ItemEntity item) {
        try {
            itemService.update(id, item);
            return ResponseEntity.ok("Артефакт успешно изменён!");
        } catch (ObjectAlreadyExistsException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body("Артефакт не найден!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка!");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteItem(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(itemService.delete(id));
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body("Артефакт не найден!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка!");
        }
    }
}
