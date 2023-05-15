package com.pe.criticalOne.service;

import com.pe.criticalOne.entity.QuestEntity;
import com.pe.criticalOne.entity.SpellEntity;
import com.pe.criticalOne.exception.ObjectAlreadyExistsException;
import com.pe.criticalOne.repo.QuestRepo;
import com.pe.criticalOne.repo.SpellRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class QuestService {
    @Autowired
    private QuestRepo questRepo;

    public QuestEntity create(QuestEntity quest) throws ObjectAlreadyExistsException {
        QuestEntity questDB = questRepo.findByName(quest.getName());
        if (questRepo.findByName(quest.getName()) != null && questRepo.findByCampaign(quest.getCampaign()) != null && questRepo.findByName(quest.getName()) == questDB) {
            throw new ObjectAlreadyExistsException("Такое задание уже существует!");
        }
        return questRepo.save(quest);
    }

    public QuestEntity getOne(Long id) {
        return questRepo.findById(id).get();
    }

    public List<QuestEntity> getAll() {
        List<QuestEntity> quests = new ArrayList<>();
        questRepo.findAll().forEach(quests::add);
        return quests;
    }

    public QuestEntity update(Long id, QuestEntity quest) throws ObjectAlreadyExistsException {
        QuestEntity questDB = questRepo.findById(id).get();
        if (questRepo.findByName(quest.getName()) != null && questRepo.findByName(quest.getName()) != questDB) {
            throw new ObjectAlreadyExistsException("Задание с таким названием уже существует!");
        }
        questDB.setName(quest.getName());
        questDB.setDescription(quest.getDescription());
        questDB.setCampaign(quest.getCampaign());
        return questRepo.save(questDB);
    }

    public Long delete(Long id) {
        QuestEntity quest = questRepo.findById(id).get();
        questRepo.deleteById(id);
        return id;
    }
}
