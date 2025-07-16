package com.tech_it_easy.controller.repositories;

import com.tech_it_easy.controller.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
