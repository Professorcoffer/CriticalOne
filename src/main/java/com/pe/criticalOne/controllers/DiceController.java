package com.pe.criticalOne.controllers;

import com.pe.criticalOne.service.DiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dice")
public class DiceController {
    @Autowired
    private DiceService diceService;

    @GetMapping("/roll")
    public ResponseEntity roll(@RequestParam(value = "d4") int d4, @RequestParam(value = "d6") int d6,
                               @RequestParam(value = "d8") int d8, @RequestParam(value = "d10") int d10,
                               @RequestParam(value = "d12") int d12, @RequestParam(value = "d20") int d20,
                               @RequestParam(value = "bonus") int bonus) {
        return ResponseEntity.ok(diceService.roll(d4, d6, d8, d10, d12, d20, bonus));
    }
}
