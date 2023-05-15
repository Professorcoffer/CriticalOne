package com.pe.criticalOne.service;

import com.pe.criticalOne.entity.CampaignEntity;
import com.pe.criticalOne.entity.CharacterEntity;
import com.pe.criticalOne.exception.ObjectAlreadyExistsException;
import com.pe.criticalOne.repo.CampaignRepo;
import com.pe.criticalOne.repo.CharacterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CharacterService {
    @Autowired
    private CharacterRepo characterRepo;

    public CharacterEntity create(CharacterEntity character) {
        return characterRepo.save(character);
    }

    public CharacterEntity getOne(Long id) {
        return characterRepo.findById(id).get();
    }

    public List<CharacterEntity> getAll() {
        List<CharacterEntity> characters = new ArrayList<>();
        characterRepo.findAll().forEach(characters::add);
        return characters;
    }

    public CharacterEntity update(Long id, CharacterEntity character) throws ObjectAlreadyExistsException {
        CharacterEntity characterDB = characterRepo.findById(id).get();
        characterDB.setUser(character.getUser());
        characterDB.setName(character.getName());
        characterDB.setCharacterClass(character.getCharacterClass());
        characterDB.setBackground(character.getBackground());
        characterDB.setRace(character.getRace());
        characterDB.setLevel(character.getLevel());
        characterDB.setOutlook(character.getOutlook());
        characterDB.setExperience(character.getExperience());
        characterDB.setHealth(character.getHealth());
        characterDB.setArmour(character.getArmour());
        characterDB.setPossession(character.getPossession());
        characterDB.setTemper(character.getTemper());
        characterDB.setIdeals(character.getIdeals());
        characterDB.setAffection(character.getAffection());
        characterDB.setWeaknesses(character.getWeaknesses());
        characterDB.setArchetype(character.getArchetype());
        characterDB.setSkills(character.getSkills());
        characterDB.setGoldCoins(character.getGoldCoins());
        characterDB.setPlatinumCoins(character.getPlatinumCoins());
        characterDB.setCopperCoins(character.getCopperCoins());
        characterDB.setSilverCoins(character.getSilverCoins());
        characterDB.setStrength(character.getStrength());
        characterDB.setDexterity(character.getDexterity());
        characterDB.setConstitution(character.getConstitution());
        characterDB.setIntelligence(character.getIntelligence());
        characterDB.setCharisma(character.getCharisma());
        characterDB.setWisdom(character.getWisdom());
        characterDB.setDanger(character.getDanger());
        characterDB.setType(character.getType());
        characterDB.setImage(character.getImage());
        characterDB.setSpells(character.getSpells());
        characterDB.setItems(character.getItems());
        characterDB.setCampaigns(character.getCampaigns());
        return characterRepo.save(characterDB);
    }

    public Long delete(Long id) {
        CharacterEntity character = characterRepo.findById(id).get();
        characterRepo.deleteById(id);
        return id;
    }
}
