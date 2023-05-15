package com.pe.criticalOne.repo;

import com.pe.criticalOne.entity.CharacterEntity;
import org.springframework.data.repository.CrudRepository;

public interface CharacterRepo extends CrudRepository<CharacterEntity, Long> {
}
