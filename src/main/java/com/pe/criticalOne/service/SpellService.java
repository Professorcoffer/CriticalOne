package com.pe.criticalOne.service;

import com.pe.criticalOne.entity.SpellEntity;
import com.pe.criticalOne.exception.ObjectAlreadyExistsException;
import com.pe.criticalOne.repo.SpellRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpellService {
    @Autowired
    private SpellRepo spellRepo;

    public SpellEntity create(SpellEntity spell) throws ObjectAlreadyExistsException {
        if (spellRepo.findByName(spell.getName()) != null) {
            throw new ObjectAlreadyExistsException("Заклинание с таким названием уже существует!");
        }
        return spellRepo.save(spell);
    }

    public SpellEntity getOne(Long id) {
        return spellRepo.findById(id).get();
    }

    public List<SpellEntity> getAll() {
        List<SpellEntity> spells = new ArrayList<>();
        spellRepo.findAll().forEach(spells::add);
        return spells;
    }

    public SpellEntity update(Long id, SpellEntity spell) throws ObjectAlreadyExistsException {
        SpellEntity spellDB = spellRepo.findById(id).get();
        if (spellRepo.findByName(spell.getName()) != null && spellRepo.findByName(spell.getName()) != spellDB) {
            throw new ObjectAlreadyExistsException("Заклинание с таким названием уже существует!");
        }
        spellDB.setName(spell.getName());
        spellDB.setDistance(spell.getDistance());
        spellDB.setDamage(spell.getDamage());
        spellDB.setLevel(spell.getLevel());
        spellDB.setDamageType(spell.getDamageType());
        spellDB.setClasses(spell.getClasses());
        spellDB.setComponents(spell.getComponents());
        spellDB.setDuration(spell.getDuration());
        spellDB.setDescription(spell.getDescription());
        spellDB.setSchool(spell.getSchool());
        spellDB.setCharacters(spell.getCharacters());
        return spellRepo.save(spellDB);
    }

    public Long delete(Long id) {
        SpellEntity spell = spellRepo.findById(id).get();
        spellRepo.deleteById(id);
        return id;
    }
}
