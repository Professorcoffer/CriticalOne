package com.pe.criticalOne.repo;

import com.pe.criticalOne.entity.SpellEntity;
import org.springframework.data.repository.CrudRepository;

public interface SpellRepo extends CrudRepository<SpellEntity, Long> {
    SpellEntity findByName(String name);
}
