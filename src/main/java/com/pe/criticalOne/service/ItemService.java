package com.pe.criticalOne.service;

import com.pe.criticalOne.entity.ItemEntity;
import com.pe.criticalOne.entity.QuestEntity;
import com.pe.criticalOne.exception.ObjectAlreadyExistsException;
import com.pe.criticalOne.repo.ItemRepo;
import com.pe.criticalOne.repo.QuestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {
    @Autowired
    private ItemRepo itemRepo;

    public ItemEntity create(ItemEntity item) throws ObjectAlreadyExistsException {
        if (itemRepo.findByName(item.getName()) != null) {
            throw new ObjectAlreadyExistsException("Артефакт с таким названием уже существует!");
        }
        return itemRepo.save(item);
    }

    public ItemEntity getOne(Long id) {
        return itemRepo.findById(id).get();
    }

    public List<ItemEntity> getAll() {
        List<ItemEntity> items = new ArrayList<>();
        itemRepo.findAll().forEach(items::add);
        return items;
    }

    public ItemEntity update(Long id, ItemEntity item) throws ObjectAlreadyExistsException {
        ItemEntity itemDB = itemRepo.findById(id).get();
        if (itemRepo.findByName(item.getName()) != null && itemRepo.findByName(item.getName()) != itemDB) {
            throw new ObjectAlreadyExistsException("Артефакт с таким названием уже существует!");
        }
        itemDB.setName(item.getName());
        itemDB.setRarity(item.getRarity());
        itemDB.setTunable(item.getTunable());
        itemDB.setCost(item.getCost());
        itemDB.setDescription(item.getDescription());
        itemDB.setType(item.getType());
        itemDB.setCharacters(item.getCharacters());
        return itemRepo.save(item);
    }

    public Long delete(Long id) {
        ItemEntity item = itemRepo.findById(id).get();
        itemRepo.deleteById(id);
        return id;
    }
}
