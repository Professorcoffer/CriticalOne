package com.pe.criticalOne.controllers;

import com.pe.criticalOne.entity.SpellEntity;
import com.pe.criticalOne.exception.ObjectAlreadyExistsException;
import com.pe.criticalOne.service.SpellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/spells")
public class SpellController {
    @Autowired
    private SpellService spellService;

    @PostMapping
    public ResponseEntity create(@RequestBody SpellEntity spell) {
        try {
            spellService.create(spell);
            return ResponseEntity.ok("Заклинание успешно сохранёно!");
        } catch (ObjectAlreadyExistsException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка!");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getOneSpell(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(spellService.getOne(id));
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body("Заклинание не найдено!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка!");
        }
    }

    @GetMapping
    public ResponseEntity getAllSpells() {
        try {
            return ResponseEntity.ok(spellService.getAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка!");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updateSpell(@PathVariable("id") Long id, @RequestBody SpellEntity spell) {
        try {
            spellService.update(id, spell);
            return ResponseEntity.ok("Заклинание успешно изменёно!");
        } catch (ObjectAlreadyExistsException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body("Заклинание не найдено!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка!");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteSpell(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(spellService.delete(id));
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body("Заклинание не найдено!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка!");
        }
    }
}
