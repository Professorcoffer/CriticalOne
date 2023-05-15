package com.pe.criticalOne.repo;

import com.pe.criticalOne.entity.ItemEntity;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepo extends CrudRepository<ItemEntity, Long> {
    ItemEntity findByName(String name);
}
