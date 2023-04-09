package com.devsuperior.bds04.repositories;

import com.devsuperior.bds04.model.entities.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    UserModel findByEmail (String email);
}
