package com.pe.criticalOne.controllers;

import com.pe.criticalOne.entity.CampaignEntity;
import com.pe.criticalOne.exception.ObjectAlreadyExistsException;
import com.pe.criticalOne.service.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/campaigns")
public class CampaignController {
    @Autowired
    private CampaignService campaignService;

    @PostMapping
    public ResponseEntity create(@RequestBody CampaignEntity campaign) {
        try {
            campaignService.create(campaign);
            return ResponseEntity.ok("Кампания успешно сохранёна!");
        } catch (ObjectAlreadyExistsException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка!");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getOneCampaign(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(campaignService.getOne(id));
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body("Кампания не найдена!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка!");
        }
    }

    @GetMapping
    public ResponseEntity getAllCampaigns() {
        try {
            return ResponseEntity.ok(campaignService.getAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка!");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updateCampaign(@PathVariable("id") Long id, @RequestBody CampaignEntity campaign) {
        try {
            campaignService.update(id, campaign);
            return ResponseEntity.ok("Кампания успешно изменёна!");
        } catch (ObjectAlreadyExistsException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body("Кампания не найдена!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка!");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCampaign(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(campaignService.delete(id));
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body("Кампания не найдена!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка!");
        }
    }
}
