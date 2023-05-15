package com.pe.criticalOne.service;

import com.pe.criticalOne.entity.NoteEntity;
import com.pe.criticalOne.repo.NoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoteService {
    @Autowired
    private NoteRepo noteRepo;

    public NoteEntity create(NoteEntity note) {
        return noteRepo.save(note);
    }

    public NoteEntity getOne(Long id) {
        return noteRepo.findById(id).get();
    }

    public List<NoteEntity> getAll() {
        List<NoteEntity> notes = new ArrayList<>();
        noteRepo.findAll().forEach(notes::add);
        return notes;
    }

    public NoteEntity update(Long id, NoteEntity note) {
        NoteEntity noteDB = noteRepo.findById(id).get();
        noteDB.setDescription(note.getDescription());
        noteDB.setCampaign(note.getCampaign());
        return noteRepo.save(noteDB);
    }

    public Long delete(Long id) {
        NoteEntity note = noteRepo.findById(id).get();
        noteRepo.deleteById(id);
        return id;
    }
}
