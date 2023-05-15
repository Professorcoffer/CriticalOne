package com.pe.criticalOne.repo;

import com.pe.criticalOne.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<UserEntity, Long> {
    UserEntity findByLogin(String login);
    UserEntity findByEmail(String email);
}
