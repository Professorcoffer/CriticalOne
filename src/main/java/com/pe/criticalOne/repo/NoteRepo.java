package com.pe.criticalOne.repo;

import com.pe.criticalOne.entity.NoteEntity;
import org.springframework.data.repository.CrudRepository;

public interface NoteRepo extends CrudRepository<NoteEntity, Long> {
}
