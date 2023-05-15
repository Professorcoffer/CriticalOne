package com.pe.criticalOne.controllers;

import com.pe.criticalOne.entity.NoteEntity;
import com.pe.criticalOne.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/notes")
public class NoteController {
    @Autowired
    private NoteService noteService;

    @PostMapping
    public ResponseEntity create(@RequestBody NoteEntity note) {
        try {
            noteService.create(note);
            return ResponseEntity.ok("Запись успешно сохранёна!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка!");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getOneNote(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(noteService.getOne(id));
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body("Запись не найдена!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка!");
        }
    }

    @GetMapping
    public ResponseEntity getAllNotes() {
        try {
            return ResponseEntity.ok(noteService.getAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка!");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updateNote(@PathVariable("id") Long id, @RequestBody NoteEntity note) {
        try {
            noteService.update(id, note);
            return ResponseEntity.ok("Запись успешно изменёна!");
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body("Запись не найдена!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка!");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteNote(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(noteService.delete(id));
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body("Запись не найдена!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка!");
        }
    }
}
